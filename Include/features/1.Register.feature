@Register

Feature: Register

Scenario Outline: User can success or failed due the register process     
		Given User already in the Homepage
    When User tap on Akun menu
    And User tap on Masuk button
    And User tap on Daftar option
    And User input the Name field
    And User input the Email field with <email> Email
    And User input the Password field with <password> Password
    And User input the Nomor HP field with <nomor_hp> Nomor HP
    And User input Kota into Kota field
    And User input Alamat into Alamat field
    And User tap on Daftar button
    Then User can see the <result> result
  
    Examples:
      | Case_ID | email      | password | nomor_hp  	| result   	|
      | AR01    | valid      | valid  	| valid  			| success   | 
      | AR02    | invalid		 | valid  	| valid  			| failed  	|
      | AR03    | registered | valid  	| valid  			| failed    | 
      | AR04    | valid      | empty  	| valid  			| failed    |
      | AR05    | valid      | valid  	| invalid	  	| success   |