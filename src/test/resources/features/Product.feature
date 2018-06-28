@Amazon
Feature: Login feature file

  @Login
  Scenario: Verify login functionality of customer
    Given I am on Amazon page
    When I search for product
    Then I should be able to see the product on product listing page

  @DataDriven
  Scenario Outline: Verify login functionality of customer
    Given I am on Amazon page
    When I search for "<product>"

    Examples: 
      | product        |
      | Apple iPhone X |
      | Samsung        |
      | MI             |
