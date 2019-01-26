#!/bin/sh

while ! nc -z zipkin-server 9411 ; do
    echo "Waiting for upcoming zipkin-server"
    sleep 3
done

while ! nc -z discovery-service 8761 ; do
    echo "Waiting for upcoming discovery-service"
    sleep 3
done

while ! nc -z account-service 2222 ; do
    echo "Waiting for upcoming account-service"
    sleep 3
done

while ! nc -z customer-service 3333 ; do
    echo "Waiting for upcoming customer-service"
    sleep 3
done

java -jar /opt/lib/gateway-service-0.0.1-SNAPSHOT.jar
