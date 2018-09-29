FROM openjdk:8-jdk AS BUILD_IMAGE

RUN apt-get update

RUN mkdir /home/akka-starter

WORKDIR /home/akka-starter

COPY . .

RUN ./gradlew build

# Second Stage Build

FROM openjdk:8-jdk

RUN mkdir /home/bin

COPY --from=BUILD_IMAGE /home/akka-starter/build/target/akka-starter-shadow.jar /home/bin/akka-starter-shadow.jar
COPY --from=BUILD_IMAGE /home/akka-starter/start-server.sh /home/bin/start-server.sh

WORKDIR /home/bin
ENTRYPOINT ["sh", "start-server.sh"]