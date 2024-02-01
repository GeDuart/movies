Movies Project
O projeto Movies é uma aplicação Spring Boot que importa dados de filmes a partir de um arquivo CSV e os armazena em um banco de dados H2.

Requisitos
Certifique-se de ter as seguintes ferramentas instaladas antes de começar:

Java 17
Maven
Git
Clonando o Repositório
Clone o repositório para o seu ambiente local usando o seguinte comando:

bash
Copy code
git clone https://github.com/GeDuart/movies.git
Configuração do Banco de Dados
O projeto utiliza um banco de dados H2 embutido. Não é necessário configurar um banco de dados externo. A configuração padrão pode ser encontrada no arquivo src/main/resources/application.properties.

Executando o Projeto
Navegue até o diretório do projeto e execute o seguinte comando para compilar e executar a aplicação:

bash
Copy code
mvn spring-boot:run
A aplicação estará acessível em http://localhost:8080. Você pode verificar o console do Spring Boot para obter informações sobre a inicialização da aplicação.


Executando Testes de Integração
Para executar os testes de integração, utilize o seguinte comando:

bash
Copy code
mvn test
Os testes de integração garantem que o processo de importação esteja funcionando corretamente.
