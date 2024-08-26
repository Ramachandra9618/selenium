Feature:

Feature: User Registration and Login Flow

  Scenario Outline: Register or Login based on user status
    Given the user launches the Chrome browser
    And the user opens the Flipkart website "https://www.flipkart.com/"
    When  the user moves on login button.
    And the user clicks on the register button.
    And the user enters the mobile number "<mobile_number>"
    And the clicks on the continue button.
    Then the user  <action>
    And the user closes the website


    Examples:
      | mobile_number | action                        |
      | 12345         | "check the error message "    |
      | 9618395572    | "verify the verify button"    |
      | 9618395570    | "verify the requestOTP Button"|



