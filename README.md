# Fox API

Api de cadastro de Diretor com lista de filmes.

## Link da API para utilização

```
https://fox-films.herokuapp.com
```

Path Existente:

POST

```
/api/v1/director
```

## Swagger

A aplicação está na nuvem e swagger disponível no link abaixo... 


```
https://fox-films.herokuapp.com/swagger-ui.html
```

## Tecnologias

Esta api foi cencebida usando spring boot, docker, mongoDb, MongoExpress, DevTools para agilizar o desenvolvimento e swagger ui para disponibilizar a documentação.

## Banco de dados

A aplicação que está na nuvem foi conectada em um banco noSql MLab.com (MongoDb)
 
Já a aplicação local é conectada em um mongoDb provido em imagem de docker, é utilizado um arquivo js para iniciar o banco com pelo menos uma informação de insert, toda vez que o container é removido, os dados sao perdidos.


### Pré-Requesitos

Você precisa ter instalado em sua máquina:

```
Docker
```

```
Maven
```

```
JDK 1.8
```

### Build e excecucão da aplicação -- All on Docker

Toda a aplicação está preparada para ser utilizada com o docker, replicando os comandos abaixo, você terá o mongoDb na porta 27017, o Mongo-Express no http://localhost:8081, a aplicação no http://localhost:8090 e a documentação no http://localhost:8090/swagger-ui.html

Os comandos a seguir devem ser feitos no diretório raiz da aplicação...

```
sudo mvn clean install
```

```
sudo cd target
```

```
sudo cp fox-films-0.0.1-SNAPSHOT.jar ../docker/docker-api/
```

O comando a seguir deve ser feito na pasta docker...

```
sudo docker-compose -f docker-compose.yml build
```

```
sudo docker-compose -f docker-compose.yml up
```

Após essa sequencia de comandos você consegue acessar o link abaixo utilizando a senha de admin para acessar o mongo-express e ter uma visualização completa da sua collection

```
http://localhost:8081
```

User: admin
Password: 123456

Acessando o link abaixo você consegue visualizar a documentação da api e já fazer testes locais...

```
http://localhost:8090/swagger-ui.html
```

### Build e excecucão da aplicação (MODO DEBUG)

No modo Debug, os comandos acionaram o build e o preparo dos containers do Banco Mongo e do gerenciador Mongo Express, ficando a seu encargo executar a aplicação pelo eclipse, isso para fins de debug.

Os comandos a seguir devem ser feitos no diretório raiz da aplicação...

```
sudo mvn clean install
```

```
sudo cd target
```

```
sudo cp fox-films-0.0.1-SNAPSHOT.jar ../docker/docker-api/
```

O comando a seguir deve ser feito na pasta docker...

```
sudo docker-compose -f docker-compose-debug.yml build
```

```
sudo docker-compose -f docker-compose-debug.yml up
```

Após essa sequencia de comandos você consegue acessar o link abaixo utilizando a senha de admin para acessar o mongo-express e ter uma visualização completa da sua collection

```
http://localhost:8081
```

User: admin
Password: 123456

## Executando os testes

Para executar os testes automatizados, basta usar o comando

```
mvn test
```

Ou ainda quando no eclipse, clicando com o botão direito no package da aplicação > Run As> JUnit Test

## Padrao de Arquitetura 
 O padrao de arquitetura para as classes dessa aplicacao segue:
 
 	*Repository - Interface que extende do MongoRepository
 	*Model - Classes utilizadas em testes
    *Entity - Entidades que possuem anotações de validação e nome da collection onde será salva
 	*Resource - Classes responsavel pelas chamadas HTTP
    *Service - Para uma melhor organização, essas classes são responsáveis por manusear/repassar as informações entre o controller e o repository
 	
 OBS:. Vale lembrar, que para esta aplicacao, nao foi incluido uma camada de *BUSINESS* onde fica contido as regras de negocio. Foi decidido assim, pois as chamadas eram simples e nao visavam regras complexas.
 
 
## URLs e ENDPOINTS
 
 	URL BASE: api/v1
 	
**Diretor** 
Para cadastro de Diretor

    Para cadastrar mais de um filme por vez, basta enviar um array com os filmes junto com o objeto diretor.

	[POST] api/v1/director

## Exemplo de Json

{
	"name": "Kevin Feige",
	"birthdayDate": "1991-10-40",
	"films": [
		{
			"name": "Vingadores - Ultimato",
			"year": "2019"
		},
        {
			"name": "Vingadores - Guerra infinita",
			"year": "2018"
		}	
	]
}

## Built With

* [SpringBoot](https://spring.io/projects/spring-boot) - SPRING
* [Maven](https://maven.apache.org/) - Dependency Management
* [Eclipse](https://eclispsefundation.org) - The Eclipse Fundation
* [Docker](https://www.docker.com/) - Enterprise Container
* [MongoDb](https://www.mongodb.com/) - NoSql


## Versioning

Para versionar, estou usando o padrao [SemVer](http://semver.org/)

## Authors

* **Yohanes Lopes** - *Initial work* - [Yohanes26](https://github.com/Yohanes26)
