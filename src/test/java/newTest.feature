Feature: Rami Levi feature
  Scenario: Login
    Given I have navigated to Rami Levi
    And On Rami Levi home page - I click login
    When On login popup - I login with user 'saeedyasen41@gmail.com' and password 'Aש123123'
    Then On Rami Levi home page - 'סעיד'

  Scenario: AllDiscounts Navigate
    Given I have navigated to Rami Levi Home Page
    When I Click AllDiscounts Button
    Then Validate that I navigate to the correct page

  Scenario: Add and Remove Item
    Given I have navigated to Rami Levi
    When Adding one item
    And Removing Item from the cart
    Then  check that the cart doesn't contain it

