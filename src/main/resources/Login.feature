Feature: Login

  @regression @login
  Scenario: Successful Login
    Given User is in Homepage
    When User logs in
      | Username | jjscabangon@gmail.com |
      | Password | Test@1234             |
    Then Post-login page is displayed

  @regression @login
  Scenario: Unsuccessful Login - Incorrect Email
    Given User is in Homepage
    When User logs in
      | Username | jjscabangon |
      | Password | Test@1234   |
    Then Post-login page is not displayed

  @regression @login
  Scenario: Unsuccessful Login - Incorrect Email
    Given User is in Homepage
    When User logs in
      | Username | jjscabangon@gmail.com |
      | Password | abc                   |
    Then Post-login page is not displayed