@addproduct
Feature: Add Product

	Background: User can login using correct credentials
    Given user is in login page
    When user fill the email field with "rossiemaulana@gmail.com"
    And user fill the password field with "masuk123"
    And user tap the Masuk button
    Then user successfully login
    
  Scenario Outline: User can success or failed to do the process
  	When user tap + button
  	And user input product name with <name>
  	And user input product price with <price>
  	And user select kategori
  	And user input location with <location>
  	And user input description with <description>
  	And user insert product image
  	And user tap terbitkan button
  	Then user <result> add product
  	Examples: 
  	| case ID | name		| price		| location		| description		| result				|
  	| AAP02		| empty		| valid		| valid				| valid					| failed				|
  	| AAP03		| valid		| empty		| valid				| valid					| failed				|
  	| AAP04		| valid		| valid		| empty				| valid					| failed				|
  	| AAP05		| valid		| valid		| valid				| empty					| failed				|
  	| AAP01		| valid		| valid		| valid				| valid					| successfully	|