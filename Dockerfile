FROM openjdk:10.0.1-10-jdk-slim-sid
VOLUME /tmp
RUN mkdir /app
WORKDIR /app
ENV JAVA_OPTS=""
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "build/libs/p1020268sample-0.0.1-SNAPSHOT.jar"]
