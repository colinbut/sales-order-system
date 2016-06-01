# Sales Order System

## Table of Contents

* [Summary](#summary)
* [Technical Overview](#technical-overview)
* [Team Members](#team-members)
* [Project Demo](#project-demo)
* [Technology/Tool Stack](#tech-tool)

### <a name="summary"></a>Summary

This is a very small full-stack web application that is used as a sample and for pure demonstration purposes.

### <a name="technical-overview"></a>Technical Overview

#### High Level Architecture

The application is just a simplistic monolithic application built with several layers. In summary, back-end is written in Java which connects to a back-end in-memory relational database (HSQL). Can also connect to other relational databases (MySQL). Application is scafolded by Spring Framework. Model-View-Controller (MVC) architectural pattern is used to separate the front-end from the back-end. This is achieved by Spring Web MVC. This application would then be deployed on an embedded web container (Apache Tomcat).

#### Front-end

The front-end is plainly JSP with a bit of JSTL here and there. Dandelion Databases also used to implement tables in the UI. Basic CSS for styling. Bootstrap provides the front-end framework for this.  

#### Application Patterns

##### Transaction Script Pattern

This application is very simple. It is a web application that currently provides basic CRUD operations. Everything operation view as a business transaction is executed down through various layers. Therefore, an anemic domain model is used as opposed to a pure object-oriented domain model. This is sufficient and ideal because at this moment there is not much (if any) complex business logic processing that is required.

##### Service Layer Pattern

Defining the application's boundary and setting the available operations from the perspective of interfacing client layers (front-end). It encapsulates the application's business logic, controlling transactions and coor-dinating responses in the implementation of its operations.


##### Repository Pattern

An object-oriented view of the data store underneath providing an extra layer of abstraction (Spring Data JPA) in front of the data access capabilities of the Data Mapper pattern. Object Relational Mapping framework (Hibernate) is used to achieve this effect of mapping the differences between relational database tables and the domain model. JPA's entity manager encapsulates the data access element (Data Access Object pattern).

#### Declarative Programming

Spring Framework's annotation support (component scanning) is done to do this taking advantage of Spring Framework's core abilities - Dependency Injection provided by the Inversion of Control (IOC) container.

#### Security issues

The application enables login/logout feature which was implemented using the basic features of the Spring Security module of the Spring Framework. 

### <a name="tech-tool"></a>Technology/Tool Stack

* Spring Framework:
  * Spring Web MVC
  * Spring Data JPA
  * Spring Security
  * Spring Test Context Framework
* JPA
* Hibernate ORM
* JTA
* Bean Validation
* JSP/ JSTL
* Bootstrap 3 - HTML, CSS, JS
* Dandelion DataTables
* MySQL
* SLF4j/Log4j

### Testing

* JUnit
* Mockito
* Cucumber-JVM
* Spring Test Context Framework - Integration Testing
* HyperSQL embedded database

### Build

* Maven


