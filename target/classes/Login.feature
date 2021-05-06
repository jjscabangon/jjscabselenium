Feature: Login

  @regression @login
  Scenario: Successful Login
    Given End User logs in
      | Username | jjscabangon@gmail.com |
      | Password | Test@1234             |
    Then Post-login page is displayed

  @regression @login
  Scenario: Unsuccessful Login - Incorrect Email
    Given End User logs in
      | Username | jjscabangon |
      | Password | Test@1234   |
    Then Post-login page is not displayed

  @regression @login
  Scenario: Unsuccessful Login - Incorrect Email
    Given End User logs in
      | Username | jjscabangon@gmail.com |
      | Password | abc                   |
    Then Post-login page is not displayed