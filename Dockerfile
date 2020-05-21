FROM openjdk:8-jre-alpine3.9
COPY build/libs/log-processor-1.0-SNAPSHOT.jar /log-processor-1.0-SNAPSHOT.jar
ENTRYPOINT ["java -jar /log-processor-1.0-SNAPSHOT.jar"]