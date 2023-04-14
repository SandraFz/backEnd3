FROM amazoncorretto:11-alpine-jdk
MAINTAINER sandraFer
COPY target/MyPortfolio8-0.0.1-SNAPSHOT.jar MyPortfolio8-app.jar
ENTRYPOINT ["java","-jar","/MyPortfolio8-app.jar"]
