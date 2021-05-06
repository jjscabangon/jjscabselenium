Feature: Registration

  @regression @registration
  Scenario: Successful Registration
    Given User registers with valid data
      | First Name   | Test FName   |
      | Last Name    | Test LName   |
      | Password     | Test@1234    |
      | Address      | Test Address |
      | City         | Test City    |
      | Zip          | 00000        |
      | Mobile Phone | 12345678901  |
    Then Post-login page is displayed