Feature: Rami Levi feature
  Scenario: Login
    Given I have navigated to Rami Levi
    And On Rami Levi home page - I click login
    When On login popup - I login with user 'naseem-ali@hotmail.com' and password 'naseem12345'
    Then On Rami Levi home page - 'naseem'

  Scenario: SearchBar
    Given I have navigated to Rami Levi
    When  I input with in search 'bamba'
    And I click on search button
    Then I should be navigated to the correct page

  Scenario: Fast Buying
      Given I have navigated to Rami Levi
      When I click on Fast Buying button
      And I enter input 'bamba'
      And I click on continue
      And I add an item to cart and click on finish
      Then I need to view item on cart




  Scenario: AllDiscounts NavigatePage
    Given I have navigated to Rami Levi
    When I Click AllDiscounts Button
    Then Validate that I navigate to the correct page



    Scenario: sign up
      Given I have navigated to Rami Levi
      And On Rami Levi home page - I click login
      When On login popup - I click signup
      Then On Signup popup fill information
      And email popup appers




