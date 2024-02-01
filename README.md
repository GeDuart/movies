<h1>Movies Project</h1>
O projeto Movies é uma aplicação Spring Boot que importa dados de filmes a partir de um arquivo CSV e os armazena em um banco de dados H2.

# Rodando o Projeto no IntelliJ IDEA

Este guia fornece instruções sobre como configurar e executar o projeto "Movies" no IntelliJ IDEA.

### Requisitos
- Java Development Kit (JDK) 17 <br>
- IntelliJ IDEA Community Edition <br>
- Git<br>

## Clonando o Repositório

Abra o terminal e execute o seguinte comando para clonar o repositório:

```bash
git clone https://github.com/GeDuart/movies.git
```

### Importando o Projeto no IntelliJ IDEA 
+  Abra o IntelliJ IDEA. <br>
+  No menu principal, clique em "File" > "Open".<br>
+  Navegue até o diretório onde o repositório foi clonado e selecione a pasta do projeto.<br>
+  Clique em "Open" para importar o projeto.<br>

### Executando o Projeto
+  No IntelliJ IDEA, abra o arquivo src/main/java/com/seu/pacote/MoviesApplication.java. <br>
+  Clique com o botão direito no arquivo e selecione "Run MoviesApplication". <br>
+  A aplicação será iniciada e estará acessível em http://localhost:8080 <br>


### Executando Testes de Integração
+ Abra o terminal no IntelliJ IDEA. <br>
+ Execute o seguinte comando para executar os testes de integração: <br>
```bash
mvn test
```

### Swagger
Acesse a documentação Swagger em http://localhost:8080/swagger-ui/index.html para explorar e interagir com a API. <br>
 
#### Agora você deve ter o projeto "Movies" rodando no IntelliJ IDEA. <br>
