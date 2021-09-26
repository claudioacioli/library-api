# *library-api*

Bem-vindo a `library-api` um projeto usando Spring Boot para disponibilizar uma API de uma livraria.  
Este projeto faz parte do segundo projeto do Bootcamp Java da Alura!

## Usando Postman

Foi disponibilizada uma coleção Postman para auxiliar os instrutores na validação do código.

## Usando o Docker

Caso deseje usar `Dockerfile`, siga os métodos abaixo:

1. Crie o arquivo `.jar`:
```shell
./mvnw package && java -jar target/*.jar
```

2. crie uma imagem `docker`:
```shell
docker build -t library-api/v1.0 .
```

3. Execute o container
```shell
docker run library-api:v1.0
```

4. Altere a variável `endpoint` na coleção Postman