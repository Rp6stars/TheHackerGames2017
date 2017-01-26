FROM alpine:3.3
MAINTAINER Eniko Pal <eniko.pal@ratedpeople.com>

RUN apk --update add curl
RUN apk --update add openjdk8-jre
WORKDIR /opt

EXPOSE 8999

COPY start-app.sh /opt/
COPY application.properties.template /opt/

COPY thehackergames2017-0.0.1-SNAPSHOT.jar /opt/jars/thehackergames2017.jar

CMD ["sh", "start-app.sh"]

