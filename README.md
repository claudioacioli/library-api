## Docker Usage

To use the `Dockerfile`, please follow the instructions below:

1. Build and create the `.jar` file:
```shell
./mvnw package && java -jar target/*.jar
```

2. create the docker image:
```shell
docker build -t library-api/v1.0 .
```

3. Run the image as a container
```shell
docker run library-api:v1.0
```
