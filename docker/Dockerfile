FROM alpine:3.3
MAINTAINER Eniko Pal <eniko.pal@ratedpeople.com>

RUN apk --update add curl
RUN apk --update add openjdk8-jre
WORKDIR /opt

EXPOSE 8080

COPY start-app.sh /opt/
COPY application.properties.template /opt/

COPY thehackergames2017.jar /opt/jars/thehackergames2017.jar

CMD ["sh", "start-app.sh"]

