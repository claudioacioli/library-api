# *library-api*

Bem-vindo a `library-api` um projeto usando Spring Boot para disponibilizar uma API de uma livraria. 
Este projeto faz parte do Bootcamp Java da Alura!

## Aos instrutores
Pessoal, sei que no meu projeto existem coisas que ainda não vimos e que ainda iremos ver, como o docker, mas já estou pondo em prática para aprender em paralelo. Peço desculpas por não seguir a risca os detalhes do projeto.
No quesito aplição sim, segui a risca todas as especificações. Um forte abraço.

## Usando Postman

Foi disponibilizada uma [coleção Postman](https://github.com/claudioacioli/library-api/blob/main/library-api.postman_collection.json) para auxiliar os instrutores na validação do código.

##Pré-requisito

Como pré-requisito para seguir os passos abaixo é necessário ter uma instância de banco de dados rodando
antes de empacotar o aplicativo em um `.jar`. Estudando para oferecer uma solução mais amigável. 

Por enquanto sugiro a criação de um container do `mariadb` com o comando abaixo:
```shell
# comando foi dividido em linhas para uma melhor visualização.
docker run 
  -v ${PWD}/initdata:/data/application 
  -p 127.0.0.1:3306:3306 
  --name some-mariadb 
  -e MARIADB_ROOT_PASSWORD=123 
  -d 
  mariadb:latest 
  --init-file /data/application/init.sql
```

## Usando o Docker

1. Crie as variaveis de ambiente 
```shell
export DATABASE_HOST=127.0.0.1
export DATABASE_PORT=3306
export DATABASE_USER=root
export DATABASE_PASSWORD=123
```

3. Crie o arquivo `.jar`: 
```shell
./mvnw package
```

2. Crie e inicialize utilizando o `docker-compose`:
```shell
docker-compose up -d
```

3. Para um teste menos aprofundado sugiro a utilização do utilitário de linha de comando `httpie`:
```shell
http :8585/authors
```
Caso queira testar com a coleção `postman` disponibilizada, certifique-se de alterar a variável `endpoint`.