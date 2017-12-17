FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/swag-cljs.jar /swag-cljs/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/swag-cljs/app.jar"]
