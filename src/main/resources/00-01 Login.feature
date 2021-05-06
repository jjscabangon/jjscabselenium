Feature: Login

  @regression @login @high
  Scenario: Login as Super Administrator
    Given End User logs in
      | Username | Super    |
      | Password | Test1234 |