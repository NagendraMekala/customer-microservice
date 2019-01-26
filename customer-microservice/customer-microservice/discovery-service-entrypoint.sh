#!/bin/sh

while ! nc -z zipkin-server 9411 ; do
    echo "Waiting for upcoming zipkin-server"
    sleep 3
done

java -jar /opt/lib/discovery-service-0.0.1-SNAPSHOT.jar
