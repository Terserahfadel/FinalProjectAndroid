@addproduct
Feature: Add Product

  Background: 
    Given user already open the app
    When user is in homepage
    And user tap the akun button
    And user tap the masuk button
    And user fill the email field with valid seller email
    And user fill the password field with correct seller password
    And user tap the masuk login button
    Then user can successfully login

  Scenario Outline: User can success or failed to do the Add Product process
    When user tap + button
    And user input product name with <name> product name
    And user input product price with <price> product price
    And user select kategori
    And user input location with <location> location
    And user input description with <description> description
    And user insert product image
    And user tap terbitkan button
    Then user <result> add product

    Examples: 
      | case ID | name  | price | location | description | result       |
      | AAP02   | empty | valid | valid    | valid       | failed       |
      | AAP03   | valid | empty | valid    | valid       | failed       |
      | AAP04   | valid | valid | empty    | valid       | failed       |
      | AAP05   | valid | valid | valid    | empty       | failed       |
      | AAP01   | valid | valid | valid    | valid       | successfully |
