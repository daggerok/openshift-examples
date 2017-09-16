FROM openjdk:8u131-jre-alpine
RUN apk --no-cache add busybox-suid bash \
  && addgroup app-group \
  && adduser -h /home/app -s /bin/bash -D -u 1025 app app-group
WORKDIR /home/app
USER app
COPY build/libs/*.jar /home/app/app.jar
EXPOSE 8080
ENV JAVA_OPTS="-Xss228k -Xms128m -Xmx256m \
               -XX:MaxMetaspaceSize=128M \
               -XX:MaxDirectMemorySize=128M \
               -Dserver.tomcat.max-threads=1 \
               -Djava.security.egd=file:/dev/./urandom \
               -Dspring.profiles.active=ololo" \
MYSQL_PASSWORD="app" \
MYSQL_USER="app" \
MYSQL_DATABASE="app"
ENTRYPOINT bash /home/app/app.jar
