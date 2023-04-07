package stepDefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import groovy.json.StringEscapeUtils


import org.apache.commons.lang.RandomStringUtils

class Register {

	@Given("User already in the Homepage")
	public void user_already_in_the_homepage() {
		Mobile.startApplication('APK/app-release.apk', true)
	}

	@When("User tap on Akun menu")
	public void user_tap_on_akun_menu() {
		Mobile.tap(findTestObject('Homepage/btn-akun'), 0)
	}

	@When("User tap on Masuk button")
	public void user_tap_on_masuk_button() {
		Mobile.tap(findTestObject('Login/btn_masuk'), 0)
	}

	@When("User tap on Daftar option")
	public void user_tap_on_daftar_option() {
		Mobile.tap(findTestObject('Login/menu_daftar'), 0)
	}

	@When("User input the Name field")
	public void user_input_the_name_field() {
		Mobile.setText(findTestObject('Register/input_nama_register'), 'Kristi', 0)
	}

	@When("User input the Email field with (.*) Email")
	public void user_input_the_email_field_with_email(String email) {
		if (email == 'valid') {
			Mobile.setText(findTestObject('Register/input_email_register'), RandomStringUtils.randomAlphabetic(8) + '@gmail.com', 0)
		}
		else if (email == 'invalid') {
			Mobile.setText(findTestObject('Register/input_email_register'), RandomStringUtils.randomAlphabetic(8) + '@yahocom', 0)
		}
		else if (email == 'registered') {
			Mobile.setText(findTestObject('Register/input_email_register'), 'Kristyulia07@gmail.com', 0)
		}
	}

	@When("User input the Password field with (.*) Password")
	public void user_input_the_password_field_with_password(String password) {
		if (password == 'valid') {
			Mobile.setText(findTestObject('Register/input_password_register'), '12345678', 0)
		}
		else if (password == 'empty') {
			Mobile.setText(findTestObject('Register/input_password_register'), '', 0)
		}
	}

	@When("User input the Nomor HP field with (.*) Nomor HP")
	public void user_input_the_phone_number_field_with_phone_number(String NoHp) {
		if (NoHp == 'valid') {
			Mobile.setText(findTestObject('Register/input_nomorHP_register'), '085335266678', 0)
		}
		else if (NoHp == 'invalid') {
			Mobile.setText(findTestObject('Register/input_nomorHP_register'), '0000000', 0)
		}
	}

	@When("User input Kota into Kota field")
	public void user_input_city_into_city_field() {
		Mobile.setText(findTestObject('Register/input_kota_register'), 'Jakarta',0)
	}

	@When("User input Alamat into Alamat field")
	public void user_input_address_into_address_field() {
		Mobile.setText(findTestObject('Register/input_alamat_register'), 'Jl Antena 10 Jakarta selatan',0)
	}

	@When("User tap on Daftar button")
	public void user_tap_on_daftar_button() {
		Mobile.tap(findTestObject('Register/btn_daftar'), 0)
	}

	@Then("User can see the (.*) result")
	public void user_can_see_the_result(String result) {
		if(result=='success') {
			Mobile.delay(5)
			Mobile.verifyElementVisible(findTestObject('Akun/btn-daftar jual saya'), 0)
			Mobile.delay(5)
		}
		else if(result=='failed') {
			Mobile.delay(5)
			Mobile.verifyElementVisible(findTestObject('Register/btn_daftar'), 0)
			Mobile.delay(5)
		}
	}
}
