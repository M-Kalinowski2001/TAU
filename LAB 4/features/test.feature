Feature: E-commerce and Scraping Tests

  Scenario: User logs in and adds products to the cart
    Given the user is on the Saucedemo website using "{browser}"
    When the user logs in with username "problem_user" and password "secret_sauce"
    And the user adds products to the cart
    Then the cart should contain 2 items

  Scenario: User attempts to log in with invalid credentials
    Given the user is on the Scrapthissite website using "{browser}"
    When the user attempts to log in with invalid credentials
    Then the user should not be able to log in