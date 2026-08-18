Projeto Final JAVA Back-End

# Gerenciador de Endereços - API Backend

## Descrição do Projeto
Este repositório contém a API REST do Projeto Final do curso de Desenvolvedor Back-End do SENAI. Desenvolvida em Java com o framework Spring Boot, a aplicação é responsável por receber os dados enviados pelo frontend e realizar a persistência em um banco de dados MySQL, fornecendo um CRUD completo com operações mapeadas e validadas.

## Tecnologias Utilizadas
* **Linguagem:** Java
* **Framework:** Spring Boot (Spring Web, Spring Data JPA)
* **Banco de Dados:** MySQL
* **Gerenciador de Dependências:** Maven

## Como Configurar o Banco de Dados
1. Crie o banco de dados executando o seguinte comando SQL localmente:
```sql
CREATE DATABASE projeto_final;
```
2. No arquivo `src/main/resources/application.properties`, configure as credenciais de acordo com o seu ambiente local:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/projeto_final?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```

## Endpoints da API REST (CRUD)
A API responde no endereço base `http://localhost:8080/api/enderecos` e possui os seguintes endpoints mapeados:

| Método | Endpoint | Descrição | Corpo da Requisição (JSON) |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/enderecos` | Lista todos os endereços salvos | Nenhum |
| **POST** | `/api/enderecos` | Salva um novo endereço no banco | `{ "cep": "01001-000", "logradouro": "Praça da Sé", "bairro": "Sé", "localidade": "São Paulo", "uf": "SP" }` |
| **PUT** | `/api/enderecos/{id}` | Atualiza um endereço existente por ID | `{ "cep": "01001-000", "logradouro": "Novo Nome", "bairro": "Sé", "localidade": "SP", "uf": "SP" }` |
| **DELETE**| `/api/enderecos/{id}` | Remove um endereço do banco por ID | Nenhum |

## Como Rodar o Backend
1. Certifique-se de que o MySQL está ativo e com a database criada.
2. Clone o repositório e execute a classe principal do Spring Boot (`ProjetoFinalJavaBackendApplication.java`).
3. A API estará pronta e escutando na porta `8080`.
