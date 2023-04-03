Feature: Login Feature

 
  Scenario Outline: User can login using correct credentials
  	Given user already open the app
    When user is in homepage
    And user tap the akun button
    And user tap the masuk button
    And user fill the email field with <email> email
    And user fill the password field with <password> password
    And user tap the masuk login button 
    Then user can <result> login  
    
    Examples: 
    | Case_id | email 								|	password 				| result 			|
    | AL01		| valid seller					|	correct seller  | succesfully |
    | AL02		| valid buyer 					|	correct buyer   | succesfully |
    | AL03		| empty 								|	correct					| failed      |
    | AL04		| valid									|	empty						| failed			|
    | AL05		| incorrect email format|	incorrect				| failed			|
    | AL06 		| unregister 						|	correct 				| failed			|
    
    
    