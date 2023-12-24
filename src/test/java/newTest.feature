Feature: Rami Levi feature
  Scenario: Login
    Given I have navigated to Rami Levi
    And On Rami Levi home page - I click login
    When On login popup - I login with user 'tzahi@tzahi.com' and password 'Aa123123'
    Then On Rami Levi home page - 'Tzahi'