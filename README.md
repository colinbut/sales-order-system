# Sales Order System

## Table of Contents

* [Summary](#summary)
* [Running Locally](#running-locally)
* [Running Unit Tests](#running-unit-tests)
* [Running Integration Tests](#running-integration-tests)
* [Running End2End Tests](#running-e2e-tests)
* [Technical Overview](#technical-overview)
  * [High Level Architecture] (#high-level-architecture)
    * [Back End] (#back-end)  
    * [Front End] (#front-end)
  * [Application Patterns] (#application-patterns)
  * [Declarative Programming] (#declarative-programming)
  * [Security Issues] (#security-issues)
  * [Testing] (#testing)
  	* [Integration Testing] (#integration-testing)
	* [End 2 End Testing] (#e2e-testing)
* [Team Members](#team-members)
* [Project Demo](#project-demo)
* [Technology/Tool Stack](#tech-tool)

### <a name="summary"></a>Summary

This is a very small full-stack web application that is used as a sample and is for pure demonstration purposes.

### <a name="running-locally"></a>Running Locally

1) Checkout code
```
git clone https://github.com/colinbut/sales-order-system.git
```

2) Do a local build
```
mvn clean package
```

... will compile the sources, package up the war file

3) Run application
```
mvn tomcat7:run-war
```

uses maven tomcat7 plugin to run the application within an embedded Apache Tomcat web container

once the application loaded, navigate to:

```
http://localhost:8080/online-application/login
```

using some sample credentials below:

### <a name="running-unit-tests"></a>Running Unit Tests

```
mvn test
```

... this will run all unit test within the suite of tests

or

from your IDE, just navigate to the unit test class and click on the IDE's 'run' button

### <a name="running-integration-tests"></a>Running Integration Tests

```
mvn verify
```

... this will run all integration test within the suite of tests. 

or

from your IDE, just navigate to the integration test class and click on the IDE's 'run' button

### <a name="technical-overview"></a>Technical Overview

#### <a name="high-level-architecture"></a>High Level Architecture

The application is just a simplistic monolithic application built with several layers. In summary, back-end is written in Java which connects to a back-end in-memory relational database (HSQL). Can also connect to other relational databases (MySQL). Application is scafolded by Spring Framework. Model-View-Controller (MVC) architectural pattern is used to separate the front-end from the back-end. This is achieved by Spring Web MVC. This application would then be deployed on an embedded web container (Apache Tomcat).

##### <a name="back-end"></a>Back End

* The back-end is completely built using Java
* It is bootstrapped by Spring Framework
* Database is a RDBMS (Relational Database Management System):
  * default in memory-db (HSQL)
  * MySQL supported too
* Spring Data JPA provides the Data Access Abstraction
  * Persistence done using JPA (Hibernate the implementation) 
* JSP serves front-end html content...

##### <a name="front-end"></a>Front End

The front-end is plainly JSP with a bit of JSTL here and there. Dandelion Databases also used to implement tables in the UI. Basic CSS for styling. Bootstrap provides the front-end framework for this.  

#### <a name="application-patterns"></a>Application Patterns

##### Transaction Script Pattern

This application is very simple. It is a web application that currently provides basic CRUD operations. Everything operational is viewed as a business transaction which is executed down through the various layers. Therefore, an anemic domain model is used as opposed to a pure object-oriented domain model. This is sufficient and ideal because at this moment there is not much (if any) complex business logic processing that is required.

##### Service Layer Pattern

Defining the application's boundary and setting the available operations from the perspective of interfacing client layers (front-end). It encapsulates the application's business logic, controlling transactions and coor-dinating responses in the implementation of its operations.

e.g.

```java
@Service("itemServiceImpl")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
		
	...

}
```

##### Repository Pattern

An object-oriented view of the data store underneath providing an extra layer of abstraction (Spring Data JPA) in front of the data access capabilities of the Data Mapper pattern. Object Relational Mapping framework (Hibernate) is used to achieve this effect of mapping the differences between relational database tables and the domain model. JPA's entity manager encapsulates the data access element (Data Access Object pattern).

e.g. of a Spring Data JPA Repository

```java
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
```

#### <a name="declarative-programming"></a>Declarative Programming

Spring Framework's annotation support (component scanning) is done to do this taking advantage of Spring Framework's core abilities - Dependency Injection provided by the Inversion of Control (IOC) container.

```java
@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	@Qualifier("orderServiceImpl")
	private OrderService orderService;

	@Autowired
	@Qualifier("customerServiceImpl")
	private CustomerService customerService;

	@Autowired
	@Qualifier("itemServiceImpl")
	private ItemService itemService;

	@Autowired
	@Qualifier("orderFormValidator")
	private OrderFormValidator orderFormValidator;
```

#### <a name="security-issues"></a>Security issues

The application enables login/logout feature which was implemented using the basic features of the Spring Security module of the Spring Framework. 

The following application-security.xml Spring configuration file shows key security configurations:

```xml
<beans:beans xmlns="http://www.springframework.org/schema/security"
             xmlns:beans="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
	http://www.springframework.org/schema/security
	http://www.springframework.org/schema/security/spring-security-3.2.xsd">

    <http auto-config="true">

        <!-- items -->
        <intercept-url pattern="/items" access="ROLE_TEST_USER,ROLE_ADMIN" />
        <intercept-url pattern="/items/create" access="ROLE_TEST_USER,ROLE_ADMIN" />
        <intercept-url pattern="/items/createItem" access="ROLE_TEST_USER,ROLE_ADMIN" />

        ....

        <form-login
            login-page="/login"
            default-target-url="/customers"
            authentication-failure-url="/login?error"
            username-parameter="username"
            password-parameter="password"
        />

        <logout logout-success-url="/login?logout" />

        <csrf/>

    </http>

    <authentication-manager>
        <authentication-provider>
            <user-service>
                <!-- hard coding application user credentials - switch to DB or LDAP -->
                <user name="testUser" password="password" authorities="ROLE_TEST_USER" />
                <user name="admin" password="password" authorities="ROLE_ADMIN" />
            </user-service>
        </authentication-provider>
    </authentication-manager>

</beans:beans>
```
#### <a name="testing"></a>Testing

##### <a name="integration-testing"></a>Integration Testing

##### <a name="e2e-testing"></a>End 2 End Testing

End 2 End Testing (Acceptance Testing) is done using Cucumber-JVM. This is available under the test-automation sub module. The intent of this is to provide end to end automation of the full stack web application. Maybe, can integrate Selenium in the future which would allow automation of the web application on web browsers. But for now, cucumber tests are written in the back-end code. Acceptance criterias are written in the .feature files using the Gherkin language. This area needs improvement.
Note that End 2 End testing for this project is still WIP.

### <a name="team-members"></a>Team Members

ME 

### <a name="project-demo"></a>Project Demo

[TBD]

### <a name="tech-tool"></a>Technology/Tool Stack

| Front End            | Back End        | Database        | Testing             | Other          |
|:-------------------- |:--------------- |:--------------- |:------------------- |:-------------- |
| HTML                 | Java 8          | HSQL (HyperSQL) | JUnit               | SLF4j - Log4j  |
| CSS                  | Spring Core     | MySQL           | Mockito             | Maven          |
| JS                   | Spring Web MVC  | SQL             | Cucumber-JVM        | Tomcat         |
| Bootstrap            | Spring Data JPA |                 | Spring Test Context | SonarQube      |
| JSP                  | Spring Security |                 |                     |                |
| JSTL                 | JPA - Hibernate |                 |                     |                |
| Dandelion DataTables | JTA             |                 |                     |                |
|                      | Bean Validation |                 |                     |                |





