# MVPDummyJSON

This project demonstrates a simple Spring Boot API that authenticates users against the [DummyJSON](https://dummyjson.com) API. Each successful login is stored in a PostgreSQL database.

## Requirements
- Java 21+
- Maven
- PostgreSQL running on `localhost:5432` with database `mvpdummyjson` and user/password `postgres`.

## Running
1. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```
2. Perform a login request:
   ```bash
   curl -X POST http://localhost:8080/api/login \
       -H 'Content-Type: application/json' \
       -d '{"username": "emilys", "password": "emilyspass"}'
   ```
   The service will authenticate with DummyJSON and respond with the authenticated user data.

## How login is logged
The application stores each successful login in the `login_log` table with the username, login time, access token, and refresh token. The `AuthService` class handles the login via a Feign client and persists a `LoginLog` entity using `LoginLogRepository`.

## Test user
DummyJSON provides test users. Example credentials:
- **Username:** `emilys`
- **Password:** `emilyspass`

## Example curl for login
```
curl --request POST \
  --url https://dummyjson.com/auth/login \
  --header 'Content-Type: application/json' \
  --data '{
    "username": "emilys",
    "password": "emilyspass"
  }'
```
