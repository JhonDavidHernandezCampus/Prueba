FROM openjdk:17
COPY "./target/servientrega-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8037
ENTRYPOINT [ "java", "-jar", "app.jar" ]