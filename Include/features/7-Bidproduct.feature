@Bidfarhanandroid
Feature: Bid product feature

#	Background:
#Given user already open the app
    #When user is in homepage
    #And user tap the akun button
    #And user tap the masuk button
    #And user fill the email field with valid buyer email
    #And user fill the password field with correct buyer password
    #And user tap the masuk login button 
    #Then user can succesfully login 
		
	Scenario Outline: user can see success and failed do the buying process
		When user search a product
    When user tap a product
    And user tap Saya tertarik dan ingin nego button
    And user input <Price> into price field
    And user tap Kirim button
    Then user can see <Result> notification

    Examples: 
      | Case ID | Price      | Result  |
      | WB01    | valid      | Success |
      | WB02    | empty      | Failed  |
      | WB04    | zero       | Success |
      | WB05    | string     | Failed  |


  #Scenario: WB03 user want to buy a product twice
    #When user tap a product
    #Then user cannot tap nego button