FROM eclipse-temurin:17

WORKDIR /app

COPY AESApp.java .

RUN javac AESApp.java

CMD ["java", "AESApp"]