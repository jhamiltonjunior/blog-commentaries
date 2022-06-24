FROM openjdk:15-jdk-slim-buster

ADD blog.jar app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT [ "sh", "-c", "java -Xms512m -Xmx2048m -jar /app.jar"]