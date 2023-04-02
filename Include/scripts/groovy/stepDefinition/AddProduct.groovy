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
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import groovy.json.StringEscapeUtils
import cucumber.api.java.en.Then
import internal.GlobalVariable

public class AddProduct {

	@When("user tap + button")
	public void user_tap_button() {
		Mobile.startApplication('APK/app-release.apk', false)
		Mobile.tap(findTestObject('Homepage/btn_addproduct'), 0)
	}

	@When("user input product name with (.*)")
	public void user_input_product_name_with(String name) {
		if (name=='valid') {
			Mobile.setText(findTestObject('Add Product/Input_Nama Produk'), 'Sambal Bangkok Indofood', 0)
		}
		else if(name=='empty') {
			Mobile.setText(findTestObject('Add Product/Input_Nama Produk'), '', 0)
		}
	}

	@When("user input product price with (.*)")
	public void user_input_product_price_with(String harga) {
		if (harga=='valid') {
			Mobile.setText(findTestObject('Add Product/Input_Harga Produk'), '14000', 0)
		}
		else if (harga=='empty') {
			Mobile.setText(findTestObject('Add Product/Input_Harga Produk'), '', 0)
		}
	}

	@When("user select kategori")
	public void user_select_kategori() {
		Mobile.tap(findTestObject('Add Product/Dropdown_Kategori'), 0)
		Mobile.tap(findTestObject('Add Product/Input_Lokasi Produk'),0)
	}

	@When("user input location with (.*)")
	public void user_input_location(String lokasi) {
		if (lokasi=='valid') {
			Mobile.setText(findTestObject('Add Product/Input_Lokasi Produk'), 'Banten', 0)
		}
		else if (lokasi=='empty') {
			Mobile.setText(findTestObject('Add Product/Input_Lokasi Produk'), '', 0)
		}
	}

	@When("user input description with (.*)")
	public void user_input_description(String deskripsi) {
		if (deskripsi=='valid') {
			Mobile.setText(findTestObject('Add Product/Input_Deskripsi'), 'pedas, sepedas mulut tetangga', 0)
		}
		else if (deskripsi=='empty') {
			Mobile.setText(findTestObject('Add Product/Input_Deskripsi'), '', 0)
		}
	}

	@When("user insert product image")
	public void user_insert_product_image() {
		Mobile.tap(findTestObject('Add Product/btn_tambah foto'), 0)
		Mobile.tap(findTestObject('Add Product/Button_Galeri'), 0)
		Mobile.tap(findTestObject('Add Product/btn_pilih gambar'), 0)
	}

	@When("user tap terbitkan button")
	public void user_tap_terbitkan_button() {
		Mobile.tap(findTestObject('Add Product/Button_Terbitkan'), 0)
	}

	@Then("user successfully add product")
	public void user_successfully_add_product() {
		Mobile.delay(10)
		Mobile.verifyElementVisible(findTestObject('Daftar Jual Saya/btn_product1 ID'), 0)
		Mobile.delay(5)
	}

	@Then("user failed add product")
	public void user_failed_add_product() {
		Mobile.verifyElementVisible(findTestObject('Add Product/Button_Terbitkan'), 0)
	}
}
