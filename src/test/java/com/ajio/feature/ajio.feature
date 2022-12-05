Feature: Validate Product name in AJIO website 

  Scenario: Ajio Serveware Add To Cart and validate the Product Name
    Given Open the Browser
    And Launch the AJIO URL
    When MouseOver to Home and Kitchen
    And MouseOver to Serveware and Drinkware
    And Choose any Product and Add it to Bag
    And Print price
    And Click Go to Bag
    Then Validate the Product name
    
    
     Scenario: Login with valid username and password
    Given: Launch Browser
    And: Open URL
    When: Enter username "Logambika1993"
    And: Enter Password "Abcd@123Z"
    Then: Logged In Sucessfully