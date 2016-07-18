Feature: Login.

Scenario: Validation of the login.

Given I have chosen to log in.
When I login with details. "Karan" as username and "pass" as password.
Then The service should validate the credentials.
