@Edit_Profile_Seller
Feature: Edit Profile Mobile App

  Background: 
    Given user already open the app
    When user is in homepage
    And user tap the akun button
    And user tap the masuk button
    And user fill the email field with valid buyer email
    And user fill the password field with correct buyer password
    And user tap the masuk login button

  Scenario Outline: User can success and failed do the Edit Profile process
    When User in Akun Saya Page
    And User tap the Pencil button
    And User can see detail information of Profile User
    And User add Photo
    And User tap Nama button
    And User fill Nama field with <Nama> and tap Simpan button
    And User tap Nomor HP button
    And User fill Nomor HP field with <Nomor_HP> and tap Simpan button
    Then User can see the <Result> Message

    Examples: 
      | case_id | Nama   | Nomor_HP | Result  |
      | AEP01   | seller | valid    | success |
      | AEP02   | empty  | valid    | failed  |
      | AEP03   | seller | invalid1 | success |
      | AEP04   | seller | invalid2 | success |

  Scenario: User want to change Password with input wrong Old Password
    When User in Akun Saya Page
    And User tap the Pencil button
    And User can see detail information of Profile User
    And User add Photo
    And User tap Kata Sandi button
    And User fill Kata Sandi Lama field with wrong Old Password "virara123"
    And User fill Kata Sandi Baru field with "akuanakgembala"
    And User fill Konfirmasi Kata Sandi Baru field with "akuanakgembala123"
    And User tap Simpan button
    Then User can see the failed validation
