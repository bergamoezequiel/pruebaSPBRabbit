FROM openjdk:8-alpine
ADD target/prueba-0.0.1-SNAPSHOT.jar /usr/share/prueba-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/prueba-0.0.1-SNAPSHOT.jar"]