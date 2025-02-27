FROM eclipse-temurin:17-jdk

WORKDIR /watermark-api

COPY . /watermark-api

RUN mkdir -p original_image
RUN mkdir -p watermark_image

RUN apt-get update && apt-get install -y maven

EXPOSE 4005
EXPOSE 4000

CMD ["mvn","spring-boot:run"]
