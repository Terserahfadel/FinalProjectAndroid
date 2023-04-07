@editproduct
Feature: Edit Product

  Background: 
    Given user already open the app
    When user is in homepage
    And user tap the akun button
    And user tap the masuk button
    And user fill the email field with valid seller email
    And user fill the password field with correct seller password
    And user tap the masuk login button
    Then user can successfully login

  Scenario Outline: User can success or failed to do the process
    When user tap daftar jual saya button
    And user tap product that has been published
    And user edit product name with <name> product name
    And user edit product price with <price> product price
    And user edit kategori
    And user edit location with <location> location
    And user edit description with <description> description
    And user insert product image
    And user tap perbarui button
    Then user <result> edit product

    Examples: 
      | case ID | name  | price | location | description | result       |
      | APE02   | empty | valid | valid    | valid       | failed       |
      | APE03   | valid | empty | valid    | valid       | failed       |
      | APE04   | valid | valid | empty    | valid       | failed       |
      | APE05   | valid | valid | valid    | empty       | failed       |
      | APE01   | valid | valid | valid    | valid       | successfully |
