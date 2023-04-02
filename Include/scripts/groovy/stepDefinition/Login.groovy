package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import internal.GlobalVariable

public class Login {
	@Given("user already open the app")
	public void user_already_open_the_app() {
		Mobile.startApplication('./APK/app-release.apk', true)
	
	}

	@When("user is in homepage")
	public void user_is_in_homepage() {
		Mobile.verifyElementVisible(findTestObject('Homepage/btn-akun'), 0)
	}

	@When("user tap the akun button")
	public void user_tap_the_akun_button() {
		Mobile.tap(findTestObject('Homepage/btn-akun'), 0)
	}

	@When("user tap the masuk button")
	public void user_tap_the_masuk_button() {
		Mobile.tap(findTestObject('Login/btn_masuk'), 0)
	}

	@When("user fill the email field with (.*) email")
	public void user_fill_the_email_field_with_email(String email) {
		if(email=='valid seller' || email=='valid') {
			Mobile.setText(findTestObject('Login/input_email_login'), 'oktaapriyanti874@gmail.com', 0)
		}else if(email=='valid buyer') {
			Mobile.setText(findTestObject('Login/input_email_login'), 'hi.julea@gmail.com', 0)
		}else if(email=='empty') {
			Mobile.setText(findTestObject('Login/input_email_login'), '', 0)
		}else if(email=='incorrect email format') {
			Mobile.setText(findTestObject('Login/input_email_login'), 'oktaapriyanti874gmail.com', 0)
		}else if(email=='unregister') {
			Mobile.setText(findTestObject('Login/input_email_login'), 'nicky.byrne@gmail.com', 0)
		}
	}
	@When("user fill the password field with(.*) password")
	public void user_fill_the_password_field_with_password(String password) {
		if(password==' correct seller') {
			Mobile.setText(findTestObject('Login/input_password_login'), 'oktacantik', 0)
		}else if(password==' correct buyer') {
			Mobile.setText(findTestObject('Login/input_password_login'), 'Bintang7*', 0)
		}else if(password==' empty') {
			Mobile.setText(findTestObject('Login/input_password_login'), '', 0)
		}else if(password==' incorrect') {
			Mobile.setText(findTestObject('Login/input_password_login'), 'oktajelek', 0)
		}else if(password==' correct') {
			Mobile.setText(findTestObject('Login/input_password_login'), 'okta123', 0)
		}
	}


	@When("user tap the masuk login button")
	public void user_tap_the_masuk_login_button() {
		Mobile.tap(findTestObject('Login/btn_masuk_login'), 0)
	}

	@Then("user can (.*) login")
	public void user_can_login_(String result) {
		if(result=='succesfully') {
			Mobile.verifyElementVisible(findTestObject('Profile Page/btn_edit_profile'), 0)
		}else if(result=='failed') {
			Mobile.verifyElementVisible(findTestObject('Login/btn_masuk_login'), 0)
		}
	    
	}
}
