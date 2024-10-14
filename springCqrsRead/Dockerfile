# 1. JDK 17 베이스 이미지를 선택한다.
FROM openjdk:17-jdk-slim

# 2. 작업 디렉토리를 설정합니다.
WORKDIR /app

# 3. Gradle 빌드에서 생성된 JAR 파일을 컨테이너로 복사한다.
# build/libs 폴더에 생성된 JAR 파일을 복사한다.
COPY build/libs/springCqrsRead-0.0.1-SNAPSHOT.jar /app/springCqrsRead.jar

# 4. 컨테이너가 실행될 때 JAR 파일을 실행하도록 설정한다.
ENTRYPOINT ["java", "-jar", "/app/springCqrsRead.jar"]
