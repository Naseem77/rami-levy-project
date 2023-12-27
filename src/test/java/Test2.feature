Feature: Tests with login

#Background:
#  Given I have logged in



    Scenario: Add Address
      Given I have logged in
      When navigated to the profile and fill the address
      Then i should view the address

    Scenario: Remove Address
    Given i navigated to the profile address page
    When  i click on the delete button and confirm
    Then  Validate that address deleted


    Scenario: Add item via API and Remove Item via UI
    When I add one item to the cart via API
    And Removing Item from the cart
    Then validate cart is empty

    Scenario: Add item via UI and remove all via API
    When I add one item to the cart via UI
    And Remove item from the cart with API
    Then validate cart empty
