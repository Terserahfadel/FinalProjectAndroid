package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.xml.soap.Detail

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
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import internal.GlobalVariable

public class bidproduct {
	@When("user search a product")
	public void user_search_a_product( ) {
		Mobile.startApplication('./APK/app-release.apk', true)
		Mobile.tap(findTestObject('Homepage/textfield-searchbox'),0)
		Mobile.delay(3)
		Mobile.setText(findTestObject('Homepage/textfield-searchbox2'), 'Sambal Bangkok Indofood',0)
		
	}
	
	@When("user tap a product")
	public void user_tap_a_product() {
		Mobile.delay(5)
		Mobile.tap(findTestObject('Homepage/android.widget.ImageView'),0)
	}

	@When("user tap Saya tertarik dan ingin nego button")
	public void user_tap_Saya_tertarik_dan_ingin_nego_button() {
		Mobile.delay(5)
		Mobile.tap(findTestObject('Detail Page Android/btn_nego'),0)
	}

		@When("user input (.*) into price field")
	public void user_input_into_price_field(String Price) {
		if(Price=='valid') {
			Mobile.delay(5)
			Mobile.setText(findTestObject('Detail Page Android/input_price' ), '12000000',0)
		}
		else if(Price=='empty') {
			Mobile.delay(5)
			Mobile.setText(findTestObject('Detail Page Android/input_price'), '',0)
		}
		else if(Price=='zero') {
			Mobile.delay(5)
			Mobile.setText(findTestObject('Detail Page Android/input_price'),'0',0)
		}
		else if(Price=='string') {
			Mobile.delay(5)
			Mobile.setText(findTestObject('Detail Page Android/input_price'), 'abcde',0)
		}
	}

	@When("user tap Kirim button")
	public void user_tap_Kirim_button() {
		
		Mobile.tap(findTestObject('Detail Page Android/btn_bid'), 0)
	}

	@Then("user can see Failed notification")
	public void user_can_see_Failed_notification() {
		Mobile.verifyElementVisible(findTestObject('Detail Page Android/notif_harga kosong'),0)
	}

	@Then("user can see Success notification")
	public void user_can_see_Success_notification() {
		Mobile.verifyElementVisible(findTestObject('Detail Page Android/notif_berhasil'),0)
	}

//	@Then("user cannot tap nego button")
//	public void user_cannot_tap_nego_button() {
//	}
}
