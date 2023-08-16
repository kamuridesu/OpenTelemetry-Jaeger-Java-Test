if [ ! -f ./kamuri-rest-test/opentelemetry-javaagent.jar ]; then
    curl --output ./kamuri-rest-test/opentelemetry-javaagent.jar -L https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar
fi

if [ ! -f ./kamuri-rest-connection/opentelemetry-javaagent.jar ]; then
    cp ./kamuri-rest-test/opentelemetry-javaagent.jar ./kamuri-rest-connection/opentelemetry-javaagent.jar
fi

docker-compose up --build -d
