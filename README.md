# AlinAirLine

###Alin AirLine is a project with the purpose to allows us to manage information about commercial flights.

For this project, we used Spring Boot 2.5.1, Maven, Postgresql, Bootstrap 3

To use this project you need to follow the next steps:

* You will need to install PostgreSQL and create a new database called airport.
* To have access to all the files, you will need to download them to your computer.
* In the project, you will find the application.properties file. This one can be found on this location `src/main/resources/application.properties`
* To configure your database you will need to fill the following fields with your database username and password: `spring.datasource.username=` & `spring.datasource.password=`
* If you want to change the database name you can do it by changing the link from `spring.datasource.url=`. Here you can change the database port as well
* After all the configuration is done, you can write in terminal the following command to download all maven dependencies:
> `mvn dependency:resolve`
* After that, you will need to build the project, for that you will need to type in terminal:
> `mvn package`
* And to start the server you will type:
> `mvn spring-boot:run `
* When you will get the information that the server is started, you can access the homepage with the following links:
> `http://localhost:8080/home` or `http://localhost:8080/`
* To have access to all the functions, you will need to create a new ADMIN account from the database. To encrypt your password you can use the following link:
> `https://bcrypt-generator.com/`

This is all you need to do.
I hope you will like this project :D
