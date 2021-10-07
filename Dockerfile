FROM azul/zulu-openjdk-alpine:8
ARG APP_VERION
WORKDIR /app/
COPY devschool-front-app-server/build/libs/devschool-front-app-server-${ARP_VERSION}.jar devschool-front-app-server.jar
EXPOSE 8080
CMD ["java","-jar","devschool-app-server.jar"]