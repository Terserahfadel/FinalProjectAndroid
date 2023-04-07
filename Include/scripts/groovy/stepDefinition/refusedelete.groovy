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
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import groovy.json.StringEscapeUtils
import cucumber.api.java.en.Then

public class refusedelete {

	@Given("user tap diminati button")
	public void user_tap_diminati_button() {
		Mobile.tap(findTestObject('Daftar Jual Saya/btn-diminati'), 0)
	}

	@Given("user tap product offer")
	public void user_tap_product_offer() {
		Mobile.tap(findTestObject('Daftar Jual Saya/Refuse Product'), 0)
	}

	@Given("user tap tolak button")
	public void user_tap_tolak_button() {
		Mobile.tap(findTestObject('Daftar Jual Saya/btn-tolak ID'), 0)
	}

	@Given("user tap produk button")
	public void user_tap_produk_button() {
		Mobile.pressBack()
		Mobile.tap(findTestObject('Daftar Jual Saya/btn-produk list'), 0)
	}

	@Given("user tap icon delete product")
	public void user_tap_icon_delete_product() {
		Mobile.delay(25)
		Mobile.tap(findTestObject('Daftar Jual Saya/delete product ID'), 0)
		Mobile.delay(5)
		Mobile.tap(findTestObject('Daftar Jual Saya/hapus produk'), 0)
		
	}
	@Then("user successfully refuse bid")
	public void user_successfully_refuse_bid() {
		Mobile.delay(10)
		Mobile.verifyElementNotVisible(findTestObject('Daftar Jual Saya/btn-tolak ID'), 0)
	}
	
	@Then("user successfully delete product")
	public void user_successfully_delete_product() {
		Mobile.verifyElementNotVisible(findTestObject('Daftar Jual Saya/product-Sambal Bangkok Indofood'), 0)
		
	}
}
