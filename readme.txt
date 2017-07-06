
Created by:   Philip Trim
Created Date: 03-July-2017
Version:      1.0.0

Prerequisites
------------------
- Maven
- Java 8


Executing
------------------
mvn spring-boot:run


Functions
------------------
http://localhost:8081/                          - Enter a new Team into the database.
http://localhost:8081/getTeams                  - View Teams in database (JSON Format only).
http://localhost:8081/getTeamsByStadiumCapacity - View Teams sorted by stadium capacity (JSON Format only).
http://localhost:8081/getTeamDetails?id={Id}    - Retrieve specific team details


Technologies Used
------------------
- Spring MVC
- Spring Boot
- Hibernate but not in use
- JPA
- Mockito
- Apache Commons
