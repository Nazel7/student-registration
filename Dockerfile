FROM openjdk:14-jdk-alpine
ADD pom.xml ./
ADD target/student-reg-docker.jar student-reg-docker.jar
ENTRYPOINT ["java", "-jar", "student-reg-docker.jar"]
EXPOSE 8086


