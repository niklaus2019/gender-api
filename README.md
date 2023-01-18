# Gender API app
> ### uses External [_REST API_](https://genderize.io/)  in project. 

## Table of Contents
* [Project scope](#project-scope)
* [General Info](#general-information)
* [Technologies and Frameworks Used](#technologies-and-frameworks-used)



## Project scope
- The scope of project is to build own database that helps detect gender by name.
- Also adding docker for run application in isolation environment (container)
- Additional business logic that involves name and its detected gender is not the scope of this project

## General Information
- Entering the name, external REST API returns as output the gender of name
- But first of all the app will check the name in database (H2) before requesting to the external API
- And if the inputed name is in database (H2), the request won't go to the external API and you can see the gender of inputed name
- But If the inputed name isn't in the database, app will do request to the external API and the result of request record in database

## Technologies and Frameworks Used
- Spring Boot 3.0.1 [_spring-boot_](https://spring.io/projects/spring-boot)
- Spring Data JPA
- Spring Web MVC
- Flyway migration
- ModelMapper
- Database - H2 (in memory)
- Docker [_docker_](https://www.docker.com/)
- IDE - IntelliJ IDEA [_intellij-idea_](https://www.jetbrains.com/)
