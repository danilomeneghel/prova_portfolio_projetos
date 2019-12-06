# PROVA PORTFOLIO PROJETOS

Projeto Java desenvolvido em Spring 4.

## Características

- MVC
- CRUD
- ACL
- Validation
- Login

## Requisitos

- Java JDK 1.8
- Apache Maven >= 3.5.4
- Apache Tomcat >= 7
- MySql >= 5.1.45

## Tecnologias

- Java
- JPA
- Maven
- Spring
- JSP
- MySql

## Instalação

```
$ git clone https://github.com/danilomeneghel/prova_portfolio_projetos.git

$ cd prova_portfolio_projetos

```

Crie um banco de dados com o nome "prova_portfolio_projetos" no seu Mysql. Você encontra o dump na raiz do projeto (prova_portfolio_projetos.sql) e pode efetuar importação da seguinte forma:

```
$ mysql -u <your user> -p <your password>

mysql> create database `prova_portfolio_projetos`;

mysql> use `prova_portfolio_projetos`;

mysql> source prova_portfolio_projetos.sql

```

Depois abra o arquivo "src/main/java/mvc/config/WebConfig.java" e coloque os dados de acordo com a conexão do seu banco de dados. <br>

Ao concluir a configuração, crie um novo servidor web Apache Tomcat, associe ao projeto e mude a porta para 8181 (ou da sua preferência).<br>

Após feito isso, é só colocar para rodar.<br>
Abra o seu navegador o seguinte endereço: <br>

http://localhost:8181/prova_portfolio_projetos

- Usuário: admin
- Senha: admin

## Licença

Projeto licenciado sob <a href="LICENSE">The MIT License (MIT)</a>.


Desenvolvido por<br>
Danilo Meneghel<br>
danilo.meneghel@gmail.com<br>
http://danilomeneghel.github.io/<br>
