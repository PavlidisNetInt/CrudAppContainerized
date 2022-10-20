# SpringBoot CRUD Application

---
## Goals 

Develop a SpringBoot application capable of executing basic CRUD operations 
to remote ( dockerized ) database, regarding `<< Movie >>` records.

### PREREQUISITE SOFTWARE

- Java JDK (11 or later) https://www.oracle.com/java/technologies/javase-downloads.html
- Apache Maven https://maven.apache.org/download.cgi
- Postman https://www.postman.com/
- Docker https://www.docker.com/

#### Docker Database Initialization

- Database used : **Oracle 12c** (*requires pulling from nexus repository.*)

1. To first run the container containing the database execute :


    run -d -p 1521:1521 panda.centraldg6.athens.intrasoft-intl.private:32443/ermistn-oracle-12.2.0.1-slim


2. To confirm run :


    docker ps


**Notes :**
<br>*Requires some additional setup!*
- user(schema), password and table creation.
- [read more about](https://confluence.intrasoft-intl.com/pages/viewpage.action?pageId=61386385)
<br>*Consult also application.properties.*

----

#### Following below steps, we can build the SpringBoot CRUD application:

1. Build (without tests)

>    mvn clean install -DskipTests

2. Run 

>    mvn spring-boot:run

#### Troubleshooting and Test Automation Links 

- Web Application URL: http://localhost:8080/

- API URL: http://localhost:8080/v3/api-docs

- Swagger URL (REST API Documentation): http://localhost:8080/swagger-ui/index.html#/

----
#### Docker Application Deployment

