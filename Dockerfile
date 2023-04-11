FROM amazoncorretto:8
MAINTAINER sandraFer
COPY target/MyPortfolio8-0.0.1-SNAPSHOT.jar MyPortfolio8-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/backEnd3/MyPortfolio8-0.0.1-SNAPSHOT.jar"]
