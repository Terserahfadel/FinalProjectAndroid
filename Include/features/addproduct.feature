@addproduct
Feature: Add Product

  Scenario: 
    When user tap + button
    And user input product name with "sikat gigi kadal"
    And user input product price with "14000"
    And user select kategori
    And user input location
    And user input description
    And user tap terbitkan button
    And user insert product image
    Then user successfully add product
