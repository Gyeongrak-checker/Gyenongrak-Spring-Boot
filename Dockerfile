# 1단계: JAR 파일을 실행할 기본 이미지 지정
FROM eclipse-temurin:17-jdk-alpine

# 2단계: 애플리케이션 jar 파일을 이미지로 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 3단계: 포트 설정 (Spring Boot의 기본 포트는 8080)
EXPOSE 8080

# 4단계: 애플리케이션 실행 명령
ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.profiles.active=prod"]