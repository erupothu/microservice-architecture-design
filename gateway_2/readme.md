#### API Gateway

##### API Gateway Server
- This server will be running on [http://localhost:6000](http://localhost:6000)

##### Eureka Server
- This Service is registered with Eureka Server for Registry and Discovery
- Eureka Server is running on [http://localhost:8761/eureka](http://localhost:8761/eureka)
- We can enable or disable this service with -- eureka.client.enabled= false

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