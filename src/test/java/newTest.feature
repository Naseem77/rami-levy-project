Feature: Rami Levi feature



  Scenario: Login
    Given I have navigated to Rami Levi
    And On Rami Levi home page - I click login
    When On login popup - I login with user 'salehzarora.z.007@gmail.com' and password 'saleh12345'
    Then On Rami Levi home page - 'סאלח'



    Scenario: first
    #Given i have navigated the home page
      When navigated to the profile and fill the address
      Then i should view the address


