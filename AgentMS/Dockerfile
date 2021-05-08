FROM openjdk:11 
ADD target/agent.jar agent.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","agent.jar"]
