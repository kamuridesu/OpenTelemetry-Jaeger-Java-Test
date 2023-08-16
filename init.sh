OPENTELEMETRY_AGENT_LATEST="https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar"

if [ ! -f ./kamuri-rest-test/opentelemetry-javaagent.jar ]; then
    curl --output ./kamuri-rest-test/opentelemetry-javaagent.jar -L $OPENTELEMETRY_AGENT_LATEST
fi

if [ ! -f ./kamuri-rest-connection/opentelemetry-javaagent.jar ]; then
    cp ./kamuri-rest-test/opentelemetry-javaagent.jar ./kamuri-rest-connection/opentelemetry-javaagent.jar
fi

docker-compose up --build -d
