FROM openjdk:17-oracle

MAINTAINER martiigarcia

COPY target/proyect.jar proyect.jar

ENTRYPOINT ["java","-jar","/proyect.jar"]