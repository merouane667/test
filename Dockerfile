FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","/app.jar"]

#----------------------------------------------------------------------------
# Create a Docker image using "Multi Stage Build"
# See more details on : https://spring.io/guides/topicals/spring-boot-docker/
#FROM openjdk:8-jdk-alpine as build
#WORKDIR /workspace/app

#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring

#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#COPY src src

#RUN ./mvnw install -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG DEPENDENCY=/workspace/app/target/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","product.Application"]