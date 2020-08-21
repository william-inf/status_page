FROM openjdk:14-alpine
COPY build/libs/status_page-*-all.jar status_page.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "status_page.jar"]