## CashOnline
Challenge proyecto API Rest. Especificación en `cashonline/src/main/resources/docs/Examen Backend Cash v2 (1).docx`.

## Requisitos
- Postman
- Git
- IDE preferido + JAVA 11 + MVN + SpringBoot
- MySQL

## Opciones de ejecución
### 1.
### Clonar el repositorio y correr en local
- Clonar este repositorio a su entorno local usando `git clone https://github.com/korrakeala/cashonline.git`.
- Acualizar las credenciales de la conección a DB en `application.properties`. En `cashonline/src/main/resources/dumps db/` hay un dump de una base pre-cargada para importar al servidor de DB local.
- "Launch" gráficamente en IDE o, en consola, navegar hasta el directorio donde está la app y ejecutar `mvn spring-boot:run`.
- En `cashonline/src/main/resources/postman collections/` hay una colección para importar a Postman con los modelos de HTTP Requests ya armados. Hay que cambiar la URL `https://cashonlineheroku.herokuapp.com/` por `https://localhost:8080/`.

### 2.
### Probar directamente la app deployada en Heroku por medio de Postman
- Clonar este repositorio a su entorno local usando `git clone https://github.com/korrakeala/cashonline.git`.
- Importar a Postman la colección `CashOnline.postman_collection.json` ubicada en `cashonline/src/main/resources/postman collections/`.
