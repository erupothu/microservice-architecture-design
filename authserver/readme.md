#### OAuth Server

##### Authentication and Authorization Server
- This is a SSO (Single Sign on) Server. Once login will allow all other microservice to Login
- The OAuth Server will run on [http://localhost:8000](http://localhost:8000)
- username: harish
- password: hpass
- This Server is configured with Rest Api's to Create, Read, Update and Delete User Details.
- Authentication happens with username and Bcrypt PasswordEncoder.
- Client Server will have to register with ClientID and Secrect key with redirect URL
- urls like H2 DB login, Swagger UI are Admin Role Restricted.
- We can change the AuthorizationServiceConfig file to updated the Security

##### H2DB
- Credentials are Stored in InMemory Database H2
- DB console login [http://localhost:8000/h2-console](http://localhost:8000/h2-console)
- host: jdbc:h2:file:./data/mydb
- username: user
- password: password
- After Login we can write the Queries on Tables

##### Eureka Server
- This Service is registered with Eureka Server for Registry and Discovery
- Eureka Server is running on [http://localhost:8761/eureka](http://localhost:8761/eureka)
- We can enable or disable this service with -- eureka.client.enabled= false

##### Actuator
- This service sharing the health, info and metrics to public

#### Password Hashing Functions
* bcrypt
    * BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
    * String encodedPassword = bCryptPasswordEncoder.encode(plainPassword);
    
* scrypt- 
    * SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder(cpuCost, memoryCost,parallelization,keyLength,saltLength);
    * String encodedPassword = sCryptPasswordEncoder.encode(plainPassword);
* PBKDF2 -
    * Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder(pepper, iterations, hashWidth);
    * pbkdf2PasswordEncoder.setEncodeHashAsBase64(true);
    * String encodedPassword = pbkdf2PasswordEncoder.encode(plainPassword);
* argon2,
    * Argon2PasswordEncoder argon2PasswordEncoder = new Argon2PasswordEncoder(saltLength,hashLength,parallelism,memory,iterations);
    * String encodePassword = argon2PasswordEncoder.encode(plainPassword);
* and others.
    * PasswordEncoderFactories.createDelegatingPasswordEncoder();
    * delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(new SCryptPasswordEncoder());

