FROM maven:3.6.3-openjdk-8-slim as mvn-build
WORKDIR /target
COPY ./pom.xml .
RUN mvn -B -Dspring-boot.repackage.skip=true dependency:resolve-plugins dependency:resolve clean package
COPY . .
RUN mvn -B -DskipTests clean package

FROM fabric8/java-alpine-openjdk8-jdk

ARG ARG_JAVA_APP_DIR=/usr/local/my_app
ARG SERVICE_NAME=app
ARG OTEL_EXPORTER_OTLP_ENDPOINT=http://otel-collector:4317

RUN apk update && apk upgrade && apk add netcat-openbsd

RUN mkdir -p /agent/
COPY --from=mvn-build /target/target/app.jar $ARG_JAVA_APP_DIR/app.jar
COPY --from=mvn-build /target/opentelemetry-javaagent.jar /agent/opentelemetry.jar

ENV JAVA_APP_DIR=$ARG_JAVA_APP_DIR
ENV JAEGER_ENDPOINT=$JAEGER_ENDPOINT
ENV SERVICE_NAME=$SERVICE_NAME
ENV OTEL_EXPORTER_OTLP_ENDPOINT=$OTEL_EXPORTER_OTLP_ENDPOINT
CMD ["sh", "-c", "java -javaagent:/agent/opentelemetry.jar -Dotel.service.name=${SERVICE_NAME} -jar /usr/local/my_app/app.jar"]
