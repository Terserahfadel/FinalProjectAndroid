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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import groovy.json.StringEscapeUtils
import cucumber.api.java.en.Then

import internal.GlobalVariable

public class EditProfile {
	@When("User in Akun Saya Page")
	public void user_in_Akun_Saya_Page() {
		Mobile.verifyElementVisible(findTestObject('Edit Profile/btn_pencil'), 0)
	}

	@When("User tap the Pencil button")
	public void user_taps_the_Pencil_button() {
		Mobile.tap(findTestObject('Edit Profile/btn_pencil'), 0)
	}

	@When("User can see detail information of Profile User")
	public void user_can_see_detail_information_of_Profile_User() {
		Mobile.verifyElementVisible(findTestObject('Edit Profile/add_image'), 0)
	}

	@When("User add Photo")
	public void user_add_Photo() {
		Mobile.tap(findTestObject('Edit Profile/add_image'), 0)
		Mobile.tap(findTestObject('Edit Profile/btn_galeri'), 0)
		Mobile.tap(findTestObject('Edit Profile/select_image'), 0)
	}

	@When("User tap Nama button")
	public void user_tap_Nama_button() {
		Mobile.tap(findTestObject('Edit Profile/btn_nama'), 0)
	}

	@When("User fill Nama field with (.*) and tap Simpan button")
	public void user_fill_Nama_field_with_and_tap_Simpan_button(String Nama) {
		if (Nama == 'seller') {
			Mobile.clearText(findTestObject('Edit Profile/input_nama'), 0)
			Mobile.setText(findTestObject('Edit Profile/input_nama'), 'User as Seller', 0)
			Mobile.tap(findTestObject('Edit Profile/btn_simpan'), 0)
		}
		else if (Nama == 'buyer') {
			Mobile.clearText(findTestObject('Edit Profile/input_nama'), 0)
			Mobile.setText(findTestObject('Edit Profile/input_nama'), 'User as Buyer', 0)
			Mobile.tap(findTestObject('Edit Profile/btn_simpan'), 0)
		}
		else if (Nama == 'empty') {
			Mobile.clearText(findTestObject('Edit Profile/input_nama'), 0)
			Mobile.tap(findTestObject('Edit Profile/btn_simpan'), 0)
			Mobile.pressBack()
		}
	}

	@When("User tap Nomor HP button")
	public void user_tap_Nomor_HP_button() {
		Mobile.tap(findTestObject('Edit Profile/btn_nomor_hp'), 0)
	}

	@When("User fill Nomor HP field with (.*) and tap Simpan button")
	public void user_fill_Nomor_HP_field_with_and_tap_Simpan_button(String Nomor_HP) {
		if (Nomor_HP == 'valid') {
			Mobile.clearText(findTestObject('Edit Profile/input_nomor_hp'), 0)
			Mobile.setText(findTestObject('Edit Profile/input_nomor_hp'), '088997788665544', 0)
			Mobile.tap(findTestObject('Edit Profile/btn_simpan'), 0)
		}
		else if (Nomor_HP == 'invalid1') {
			Mobile.clearText(findTestObject('Edit Profile/input_nomor_hp'), 0)
			Mobile.setText(findTestObject('Edit Profile/input_nomor_hp'), '3', 0)
			Mobile.tap(findTestObject('Edit Profile/btn_simpan'), 0)
		}
		else if (Nomor_HP == 'invalid2') {
			Mobile.clearText(findTestObject('Edit Profile/input_nomor_hp'), 0)
			Mobile.setText(findTestObject('Edit Profile/input_nomor_hp'), 'abc!!@@##$$%%^^', 0)
			Mobile.tap(findTestObject('Edit Profile/btn_simpan'), 0)
		}
	}

	@Then("User can see the success Message")
	public void user_can_see_the_sucess_Message() {
		Mobile.verifyElementVisible(findTestObject('Edit Profile/btn_nama'), 0)
	}

	@Then("User can see the failed Message")
	public void user_can_see_the_failed_Message() {
		Mobile.verifyElementVisible(findTestObject('Edit Profile/btn_nama'), 0)
	}

	@When("User tap Kata Sandi button")
	public void user_tap_Kata_Sandi_button() {
		Mobile.tap(findTestObject('Edit Profile/btn_password'), 0)
	}

	@When("User fill Kata Sandi Lama field with wrong Old Password {string}")
	public void user_fill_Kata_Sandi_Lama_field_with_wrong_Old_Password(String string) {
		Mobile.verifyElementVisible(findTestObject('Edit Profile/input_sandi_lama'), 0)
		Mobile.setText(findTestObject('Edit Profile/input_sandi_lama'), 'kelompokdua123', 0)
	}

	@When("User fill Kata Sandi Baru field with {string}")
	public void user_fill_Kata_Sandi_Baru_field_with(String string) {
		Mobile.setText(findTestObject('Edit Profile/input_sandi_baru'), 'kelompokdua123', 0)
	}

	@When("User fill Konfirmasi Kata Sandi Baru field with {string}")
	public void user_fill_Konfirmasi_Kata_Sandi_Baru_field_with(String string) {
		Mobile.setText(findTestObject('Edit Profile/input_konfirmasi_sandi'), 'kelompokdua123', 0)
	}

	@When("User tap Simpan button")
	public void user_tap_Simpan_button() {
		Mobile.tap(findTestObject('Edit Profile/btn_simpan_password'), 0)
		Mobile.pressBack()
	}

	@Then("User can see the failed validation")
	public void user_can_see_the_failed_validation() {
		Mobile.verifyElementVisible(findTestObject('Edit Profile/btn_pencil'), 0)
	}
}
