FROM amazoncorretto:17-alpine-jdk

MAINTAINER martiigarcia

COPY target/proyect-0.0.1-SNAPSHOT.jar proyect-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/proyect-0.0.1-SNAPSHOT.jar"]

