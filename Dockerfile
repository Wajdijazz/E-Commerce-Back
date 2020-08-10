FROM openjdk:8
EXPOSE 8080 
ADD target/E-Commerce-0.0.1-SNAPSHOT.jar E-Commerce-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/E-Commerce-0.0.1-SNAPSHOT.jar"]
