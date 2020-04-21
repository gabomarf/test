FROM openjdk:11.0.6-jre

EXPOSE 8080

VOLUME /tmp

ADD target/*.jar microservice.jar

#ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom"

USER root

ENTRYPOINT exec java $JAVA_OPTS -jar /microservice.jar
