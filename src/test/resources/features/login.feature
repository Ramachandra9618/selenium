Feature: User Login

  Scenario: Successful login with valid credentials
    Given the user launches the Chrome browser
    And the user opens the Flipkart website "https://www.flipkart.com/"
    When the user clicks on the login button
    And the user enters a the mobile number "9618395570"
    And the user clicks on the request OTP button
    Then the verify button should be visible
    And the user closes the website


  Scenario Outline: Login with different credentials
    Given the user launches the Chrome browser
    And the user opens the Flipkart website "https://www.flipkart.com/"
    When the user clicks on the login button
    And the user enters the mobile number "<mobile_number>"
    And the user clicks on the request OTP button
    Then the result should be "<result>"
    And the user closes the website

    Examples:
      | mobile_number | result                  |
      | 1234567890    | "error message displayed"|

  Scenario: sample
    Given the user launches the Chrome browser
    And the user opens the Flipkart website "https://www.flipkart.com/"
    When the user move the mouse "200" and "500" right click
    And the user closes the website

  Scenario: search option
    Given the user launches the Chrome browser
    And the user opens the Flipkart website "https://www.flipkart.com/"
    When search the product in the search "shirts"
    And press the enter button
    Then verify the search results  "shirts"
    And the user closes the website