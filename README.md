# API de Filmes
Este é um simples projeto de uma API de Filmes em Java, que permite realizar operações CRUD (Create, Read, Update e Delete) para gerenciar informações de filmes.

# Funcionalidades
A API de Filmes oferece as seguintes funcionalidades:

- Cadastrar um novo filme, fornecendo informações como título, diretor, gênero e ano de lançamento.
- Obter informações de um filme específico, através de seu ID.
- Listar todos os filmes cadastrados.
- Atualizar as informações de um filme existente.
- Excluir um filme do banco de dados.

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- Java: Linguagem de programação principal.
- Spring Boot: Framework para o desenvolvimento de aplicações Java.
- Spring Data JPA: Biblioteca que facilita a interação com o banco de dados.
- H2DB: Banco de dados relacional utilizado para armazenar as informações dos filmes.

# Configuração do ambiente
Para executar o projeto, siga as etapas abaixo:

- Certifique-se de ter o Java JDK (versão X ou superior) instalado em sua máquina.
- Clone este repositório para o seu ambiente local.
- Importe o projeto em sua IDE preferida.
- Configure as informações de conexão com o banco de dados no arquivo application.properties.
- Execute o projeto.
- Endpoints da API

A API de Filmes expõe os seguintes endpoints:

- GET /movies: Retorna a lista de todos os filmes cadastrados. Se for adicionado o nome do filme como parâmetro, caso esteja cadastrado, apenas ele será retornado. Exemplo: ".../movies?nome=Interestelar" será retornado o filme Interestelar juntamente com suas respectivas informações.
- GET /movies/{id}: Retorna as informações do filme correspondente ao ID informado.
- POST /movies: Cria um novo filme com base nos dados fornecidos no corpo da requisição.
- PUT /movies/{id}: Atualiza as informações do filme correspondente ao ID informado, com base nos dados fornecidos no corpo da requisição.
- DELETE /movies/{id}: Exclui o filme correspondente ao ID informado.

