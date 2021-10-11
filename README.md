# *library-api*

Bem-vindo a `library-api` um projeto usando Spring Boot para disponibilizar uma API de uma livraria. 
Este projeto faz parte do Bootcamp Java da Alura!

## Aos instrutores
Pessoal, sei que no meu projeto existem coisas que ainda não vimos e que ainda iremos ver, como o docker, mas já estou pondo em prática para aprender em paralelo. Peço desculpas por não seguir a risca os detalhes do projeto.
No quesito aplição sim, segui a risca todas as especificações. Um forte abraço.

## Usando Postman

Foi disponibilizada uma [coleção Postman](https://github.com/claudioacioli/library-api/blob/main/library-api.postman_collection.json) para auxiliar os instrutores na validação do código.

## Usando o Docker

**Atenção: como pré-requisito para seguir os passos abaixo faz se necessário ter uma instância de banco de dados rodando
antes de empacotar o aplicativo em um `.jar`. Estudando para oferecer uma solução mais amigável**

1. Crie as variaveis de ambiente 
```shell
export DATABASE_HOST=127.0.0.1
export DATABASE_PORT=3306
export DATABASE_USER=root
export DATABASE_PASSWORD=123
```
2. Crie o arquivo `.jar`: 
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