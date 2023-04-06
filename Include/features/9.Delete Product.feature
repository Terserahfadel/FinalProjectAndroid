@deleteproduct
Feature: Detele product

  Background: 
    Given user already open the app
    When user is in homepage
    And user tap the akun button
    And user tap the masuk button
    And user fill the email field with valid seller email
    And user fill the password field with correct seller password
    And user tap the masuk login button
    Then user can successfully login

    Scenario: user can delete a product
    	When user tap daftar jual saya button
    	And user tap icon delete product
    	Then user successfully delete product