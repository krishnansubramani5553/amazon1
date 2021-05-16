Feature: Adding and deleting a product from cart in amazon

  Scenario: Select any product and add the product to the cart and remove the product from the cart
    Given User is on Amazon site
    When User enters an product name in the search text box and press enter key
    And Add the product to the cart
    When Go the cart select the product
    Then User should remove or delete the product from the cart
