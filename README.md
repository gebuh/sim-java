# Backend sim implemented in Java

To run, from the parent directory:
Run ./initialize-database.sh to populate base data
jwt token expiration is set to 3 minutes
change it in application.properties (jwt.token.valid) and restart for a longer token session.

From terminal:
$ mvn install
$ java -jar target/sim-0.0.1-SNAPSHOT.jar

run postman at backend-sim.postman_collection.json
or use HTTP

Structure:
.
├── backend-sim.postman_collection.json
├── data
│   ├── data.sql
│   └── simulation.db
├── initialize-database.sh
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── boose
    │   │           └── sim
    │   │               ├── config
    │   │               │   ├── DatasourceConfig.java
    │   │               │   ├── JwtAuthenticationEntryPoint.java
    │   │               │   ├── JwtRequestFilter.java
    │   │               │   ├── JwtTokenUtil.java
    │   │               │   └── WebSecurityConfig.java
    │   │               ├── controller
    │   │               │   ├── AnimalsController.java
    │   │               │   ├── JwtAuthenticationController.java
    │   │               │   └── UserController.java
    │   │               ├── database
    │   │               │   ├── SQLiteDialect.java
    │   │               │   └── SQLiteIdentityColumnSupport.java
    │   │               ├── dto
    │   │               │   ├── AnimalsDTO.java
    │   │               │   └── UsersDTO.java
    │   │               ├── entity
    │   │               │   ├── AnimalsEntity.java
    │   │               │   └── UsersEntity.java
    │   │               ├── jwt
    │   │               │   ├── JwtRequest.java
    │   │               │   └── JwtResponse.java
    │   │               ├── repository
    │   │               │   ├── AnimalsRepository.java
    │   │               │   └── UsersRepository.java
    │   │               ├── service
    │   │               │   ├── AnimalsServiceImpl.java
    │   │               │   ├── JwtUserDetailsServiceImpl.java
    │   │               │   └── UserServiceImpl.java
    │   │               ├── SimApplication.java
    │   │               └── validation
    │   │                   ├── UniqueLogin.java
    │   │                   └── UniqueLoginValidator.java
    │   └── resources
    │       ├── application.properties
    │       └── persistence-sqlite.properties
    └── test
        └── java
            └── com
                └── boose
                    └── sim
                        ├── service
                        │   └── UserServiceImplTest.java
                        └── SimApplicationTests.java