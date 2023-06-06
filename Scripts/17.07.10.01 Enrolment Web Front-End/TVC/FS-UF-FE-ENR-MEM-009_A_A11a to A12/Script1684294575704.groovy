import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.utils.CommonFunctions as CF

WebUI.waitForElementClickable(CF.runtimeObj('Member','____Upload area', 'Certified True Copy of Address Proof'), GlobalVariable.G_Timeout['Medium'])
CF.uploadFile('Member', 'Certified True Copy of Address Proof', 'test.png')

CF.click('Member','____Card (section)', 'Proof of Source of Fund (for SVC and TVC)')
CF.uploadFile('Member', 'Proof of Source of Fund (for SVC and TVC)', 'test.png')

CF.click('Member','____Card (section)', 'Address Proof')
CF.uploadFile('Member', 'Address Proof', 'test.png')

CF.click('Member', '____Card (section)', 'Certified True Copy of Proof of Source of Fund')
CF.uploadFile('Member', 'Certified True Copy of Proof of Source of Fund', 'test.png')

CF.click('Member', '____Card (section)', 'HKID Card Copy / Passport Copy')
CF.uploadFile('Member', 'HKID Card Copy / Passport Copy', 'test.png')

CF.click('Member', '____Card (section)', 'Certified True Copy of HKID Card / Passport')
CF.uploadFile('Member', 'Certified True Copy of HKID Card / Passport', 'test.png')

CF.click('Member','____Button', 'Next')