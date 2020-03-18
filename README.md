# XY Inc

## Como Utilizar

### Executando Testes

Execute o seguinte comando:

	mvn test

### Executando Aplicação

Execute o seguinte comando:

	mvn spring-boot:run
	
### Utilizando Swagger

Caso queira, a atividade possui o swagger, para acessar, basta ir na url: http://localhost:8080/swagger-ui.html

## Endpoints Disponíveis

Segue abaixo a tabela dos endpoints disponíveis na API

|Caminho|Método|Função|
|-|-|-|
|/point|GET|Busca todos os pontos de interesses cadastrados no banco de dados|
|/point|POST|Cadastra um novo ponto de interesse no banco de dados|
|/point/x/{coordinateX}/y/{coordinateY}/distance/{maxDistance}|GET|Busca pontos de interesse baseados na proximidade através dos parâmetros informados|

### Cadastrando um novo ponto de interesse

Abaixo, está o json de modelo para cadastrar um novo ponto de interesse:

```json
{  
	"coordinateX":  0,
	"coordinateY":  0,
	"name":  "string"
}
```

### Buscando Pontos de Interesse Próximos

No quadro abaixo estão os tipos referentes ao PathVariable para busca de pontos de interesse próximos.

|PathVariable|Tipo|
|-|-|
|coordinateX|Long|
|coordinateY|Long|
|maxDistance|Long|

## Principais Tecnologias

 - [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
 - [Maven 3](https://maven.apache.org/download.cgi)
 - [Mockito](https://site.mockito.org/)
 - [Junit 5](https://junit.org/junit5/)
