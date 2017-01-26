#!bin/sh

echo Creating application.properties file based on environment variables

sh application.properties.template

JAVA_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000"

echo Starting microservice

/usr/bin/java $JAVA_OPTS -jar jars/thehackergames2017.jar
 
