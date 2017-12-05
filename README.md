# xy-inc

Serviços Back-End de uma plataforma GPS , para auxiliar pessoas na localização de pontos de interesse.

Back-End services of a GPS platform, to auxiliate people in the localization of points of interest.

## Getting Started

After cloning this small service project to your computer (by using the command git clone https://github.com/carloshpb/xy-inc.git on your terminal, or simply downloading it from the Clone button of this page), you should go to the folder of the project, open a terminal at the directory of it and type these commands :


This command will run the Maven Wrapper of this project, to configurate the project's dependencies :

**Linux**
./mvnw clean package


**Windows**
mvnw.cmd clean install

This command will run the application and it's local host :

java -jar target/gpsxyinc-0.0.1-SNAPSHOT.jar

After that, try to access the 3 services by those URLs :

**Service that will list all the coordinators saved at the database**<br />
http://localhost:8080/gps/listarCoordenadas

**Service to register new interest points of interest, with 3 attributes : name, integer x and integer y**<br />
http://localhost:8080/gps/cadastrarCoordenada/{name-of-point-of-interest}/{coordinate-x}/{coordinate-y}

**Service to show all points of interest by proximity, by sending 3 attributes : actual-x, actual-y and max-meters**<br />
http://localhost:8080/gps/buscarPonto/{actual-x}/{actual-y}/{max-meters}

### Prerequisites

It's needed to have JRE 8 or higher to run : <br />
http://www.oracle.com/technetwork/pt/java/javase/downloads/jre8-downloads-2133155.html <br />
http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html

## Running the tests

To run the project's tests, go to it's directory and run this command :


## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/) - The web framework used <br />
* [Maven](https://maven.apache.org/) - Dependency Management <br />
* [JPA](http://www.oracle.com/technetwork/java/javaee/tech/persistence-jsp-140049.html) - Used to manage data between Java objects / classes and a relational database <br />
* [H2](http://www.h2database.com/html/main.html) - Embedded database used <br />
* [Spring-Web Dependencies](https://mvnrepository.com/artifact/org.springframework/spring-web) - Conjunct of Maven web dependencies 

## Authors

* **Carlos Humberto de Paula Borges** - [GitHub](https://github.com/carloshpb)
