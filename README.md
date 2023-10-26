# AccountDemo

## Summary
Provides an API that allows customers to open a new account

- The API will expose an endpoint which accepts the user information (customerID, initialCredit).
- Once the endpoint is called, a new account will be opened connected to the user whose ID is customerID.
- Also, if initialCredit is not 0, a transaction will be sent to the new account.
- Another Endpoint will output the user information showing Name, Surname, balance, and transactions of the accounts.

## API and Endpoints
Application has 2 apis:
- AccountAPI
- CustomerAPI

(Get) Retrieve all customers with:
```
/api/v1/customer
```

(Get) Retrieve spesific customer with:
```
/api/v1/customer/{customerId}
```

(Post) Create new account with:
```
/api/v1/account
```

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Restful API
- H2 In memory database
- Docker
- JUnit 5

## Prequisities
- Maven
- Docker


