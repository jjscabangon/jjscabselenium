Feature: Homepage

  @regression @home
  Scenario: Homepage Layout
    Given User is in Homepage
    Then Header is displayed
    And Top Menu is displayed
    And Slider Banner is displayed
    And Suggested Product is displayed
    And Category is displayed
    And Social Media is displayed
    And Footer is displayed
