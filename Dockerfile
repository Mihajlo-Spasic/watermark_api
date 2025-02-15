FROM eclipse-temurin:17-jdk

WORKDIR /watermark-api

COPY . /watermark-api

RUN mkdir original_image
RUN mkdir watermark_image

RUN apt-get update && apt-get install -y maven

EXPOSE 4005

CMD ["mvn","spring-boot:run"]
