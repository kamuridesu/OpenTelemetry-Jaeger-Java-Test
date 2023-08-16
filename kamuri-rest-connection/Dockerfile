FROM maven:3.6.3-openjdk-8-slim as mvn-build
WORKDIR /target
COPY ./pom.xml .
RUN mvn -B -Dspring-boot.repackage.skip=true dependency:resolve-plugins dependency:resolve clean package
COPY . .
RUN mvn -B -DskipTests clean package

FROM fabric8/java-alpine-openjdk8-jdk

ARG JAEGER_ENDPOINT=http://jaeger:14250
ARG ARG_JAVA_APP_DIR=/usr/local/my_app
ARG SERVICE_NAME=app

RUN apk update && apk upgrade && apk add netcat-openbsd

RUN mkdir -p /agent/
COPY --from=mvn-build /target/target/app.jar $ARG_JAVA_APP_DIR/app.jar
COPY --from=mvn-build /target/opentelemetry-javaagent.jar /agent/opentelemetry.jar

ENV JAVA_APP_DIR=$ARG_JAVA_APP_DIR
ENV JAEGER_ENDPOINT=$JAEGER_ENDPOINT
ENV SERVICE_NAME=$SERVICE_NAME
CMD ["sh", "-c", "java -javaagent:/agent/opentelemetry.jar -Dotel.service.name=${SERVICE_NAME} -Dotel.traces.exporter=jaeger -Dotel.exporter.jaeger.endpoint=${JAEGER_ENDPOINT} -jar /usr/local/my_app/app.jar"]
