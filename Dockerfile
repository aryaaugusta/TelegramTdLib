FROM alpine:3.9 as builder

RUN apk update
RUN apk upgrade
RUN apk add --update alpine-sdk linux-headers git zlib-dev openssl-dev gperf php cmake openjdk8


WORKDIR /tmp/td/

RUN  git clone https://github.com/puguhTri/td.git /tmp/td/

WORKDIR /tmp/td/
RUN rm -rf build
RUN mkdir build
WORKDIR /tmp/td/build/

RUN cmake -DCMAKE_BUILD_TYPE=Release -DJAVA_HOME=/usr/lib/jvm/java-1.8-openjdk/ -DCMAKE_INSTALL_PREFIX:PATH=../example/java/td -DTD_ENABLE_JNI=ON ..
RUN cmake --build . --target install

WORKDIR /tmp/td/example/java/
RUN rm -rf build
RUN mkdir build
WORKDIR /tmp/td/example/java/build

RUN cmake -DCMAKE_BUILD_TYPE=Release -DJAVA_HOME=/usr/lib/jvm/java-1.8-openjdk/ -DCMAKE_INSTALL_PREFIX:PATH=../../../tdlib -DTd_DIR:PATH=$(readlink -f ../td/lib/cmake/Td) ..
RUN cmake --build . --target install


WORKDIR /tmp/tddb/
RUN git clone https://github.com/puguhTri/dirdb.git /tmp/tddb/

WORKDIR /usr/
RUN mkdir java
WORKDIR /usr/java/
RUN mkdir packages
WORKDIR /usr/java/packages/
RUN mkdir lib
WORKDIR /usr/java/packages/lib/



#MAVEN BUILD
#FROM maven:3.6.3-jdk-11-slim AS MAVEN_TOOL_CHAIN
#COPY pom.xml /tmp/
#COPY src /tmp/src/
#WORKDIR /tmp/
#RUN mvn package -Dmaven.test.skip=true

FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
ARG JAR_NAME=telegramcore.jar
#COPY --from=MAVEN_TOOL_CHAIN /tmp/${JAR_FILE} ${JAR_NAME}
COPY ${JAR_FILE} ${JAR_NAME}
COPY --from=builder /tmp/td/tdlib/bin/libtdjni.so /usr/java/packages/lib/
WORKDIR /opt/
RUN mkdir telegram
WORKDIR /opt/telegram/
RUN mkdir db1
COPY --from=builder /tmp/tddb/ /opt/telegram/db1/

WORKDIR /

ENTRYPOINT ["java","-jar","telegramcore.jar"]

##NON BUILD
#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} czpremium-product.jar
#ENTRYPOINT ["java","-jar","czpremium-product.jar"]
