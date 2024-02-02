# Movies Project
O projeto Movies é uma aplicação para possibilitar a leitura da lista de indicados e vencedores
da categoria Pior Filme do Golden Raspberry Awards.

# Rodando o Projeto no IntelliJ IDEA

Este guia fornece instruções sobre como configurar e executar o projeto "Movies" no IntelliJ IDEA.

### Requisitos
- Java Development Kit (JDK) 17 
- IntelliJ IDEA Community Edition
- Git
- Maven

## Clonando o Repositório

Abra o terminal e execute o seguinte comando para clonar o repositório:

```bash
git clone https://github.com/GeDuart/movies.git
```

### Importando o Projeto no IntelliJ IDEA 
+  Abra o IntelliJ IDEA. 
+  No menu principal, clique em "File" > "Open".
+  Navegue até o diretório onde o repositório foi clonado e selecione a pasta do projeto.
+  Clique em "Open" para importar o projeto.<br>

### Executando o Projeto
+  No IntelliJ IDEA, abra o arquivo src/main/java/com/seu/pacote/MoviesApplication.java.
+  Clique com o botão direito no arquivo e selecione "Run MoviesApplication". 
+  A aplicação será iniciada e estará acessível em http://localhost:8080 


### Executando Testes de Integração
+ Abra o terminal no IntelliJ IDEA. <br>
+ Execute o seguinte comando para executar os testes de integração: 
```bash
mvn test
```
+ Se o maven nao estiver configurado pode realizar os testes clicando no ícone do Maven localizado à direita. Em seguida, expanda a opção "movies", acesse a opção Lifecycle e selecione a opção de test.
### Swagger
Acesse a documentação Swagger em http://localhost:8080/swagger-ui/index.html para explorar e interagir com a API. 
 
#### Agora você deve ter o projeto "Movies" rodando no IntelliJ IDEA. <br>
