<h1>Movies Project</h1>
O projeto Movies é uma aplicação Spring Boot que importa dados de filmes a partir de um arquivo CSV e os armazena em um banco de dados H2.

<h3>Requisitos</h3>
Para execução do projeto, é necessário instalação do JDK 17

<h3>Executando o Projeto</h3>
Para executar o projeto, nenhuma instalação externa é necessária. Ao ser iniciada, a aplicação cria o banco de dados e o popula com os dados do arquivo movielist.csv, que se encontra em src/main/resources/.


<h3>Executando Testes de Integração</h3>
Para executar os testes de integração, utilize o seguinte comando:<br>
mvn test<br>
Os testes de integração garantem que o processo de importação esteja funcionando corretamente.<br>
