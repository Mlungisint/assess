Feature: Ability to checkout a shopping products
  Scenario: As a user i should be able to checkout the product i bought
    Given i logged in to https://www.saucedemo.com
    When i select the product from the website
    And i add the product to the cart
    Then then i should be able to checkout the product