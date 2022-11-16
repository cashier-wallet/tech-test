# Wallet Team Tech Test

We would like you to develop a rest endpoint in Java in TDD manner. The goal of this exercise is to get an idea of the code you would produce if you were working at Bally’s, therefore your solution should be of production quality.

## Problem:
Develop a Registration Service that implements a /register endpoint taking a JSON body.

### Required data & validation:
*	Username - alphanumeric, no spaces
*	Password – min length 4, at least one upper case letter & number

### Expected responses:
*	If the request body fails to conform to any of the basic validation checks return HTTP Status code: 400
*	If the username has already been used/customer created, reject the request and return HTTP Status code: 409
*	A successful registration must return HTTP Status code: 201

### Example request:
```
    curl -v -X POST http://localhost:8080/tech-test-api/v1/register \
    -H 'Content-Type: application/json' \
    -d '{
    "username": "BobFrench", "password": "Password1", "dob": "1980-02-21",
    "paymentCardNumber": "349293081054422"
    }'
```
