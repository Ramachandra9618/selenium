Feature:
#  Scenario Outline: search bar
#    Given the user launches the Chrome browser
#    And the user opens the Flipkart website "https://www.flipkart.com/"
#   When the user click on the search bar
#   And search the product in the search by keyboard "<string>"
#    And press the enter button
#    Then verify the search results  "<string>"
#    And the user closes the website
#
#    Examples:
#      |string|
#      | shirts  |
#      |pant     |
#      |mobile   |

    Scenario: select
      Given the user launches the Chrome browser
      And the user opens the Flipkart website "https://www.flipkart.com/"
      When the user mouse on the electronics
      And the use select the "Gaming"
      And in the select the in order girlsDresses
      And the user select the dress
      And the use click on the AddCart
      Then verify the page
      And the user closes the website
