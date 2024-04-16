Rest API with JWT Authentication : 

Spring Boot, MySQL, Spring Security

1. Create/Register User `localhost:8082/api/v1/auth
2. Login user (To get `JWT Token`): `localhost:8082/api/v1/auth/login`

Use the generated `auth otken` as `bearer` in `Postman`

```json

[POST]api/v1/auth
[POST]api/v1/employee-address/{userId}
[PUT]api/v1/user
[PUT]api/v1/employee-address/{addressId}
[GET]api/v1/user/{id}
[GET]api/v1/user//{pagenumber=0}/{search}
[DELETE]api/v1/user/{userId}
[GET]api/v1/employee-address/{addressId}
[DELETE]api/v1/employee-address/{addressId}
[DELETE]api/v1/employee/{id}

```