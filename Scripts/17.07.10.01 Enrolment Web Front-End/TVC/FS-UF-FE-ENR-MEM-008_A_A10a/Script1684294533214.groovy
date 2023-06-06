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

WebUI.waitForElementClickable(CF.runtimeObj('Member','____Button (radio)', 'Single Payment'), GlobalVariable.G_Timeout['Medium'])
WebUI.scrollToElement(CF.runtimeObj('Member','____Button (radio)', 'Single Payment'), GlobalVariable.G_Timeout['Short'])
CF.click('Member','____Button (radio)', 'Single Payment')
CF.setText('Member', true, 'Contribution Amount', '10000')
CF.setDateAndVerify('Member', true, 'Contribution Start Date','1','Contribution Start Date')
WebUI.scrollToElement(CF.runtimeObj('Member','____Card (section)', 'Payment Method'), GlobalVariable.G_Timeout['Short'])
CF.click('Member','____Card (section)', 'Payment Method')
CF.setDropdownAndVerify('Member', true, 'Default Payment Method','By Cheque / Other Payment Methods')
CF.click('Member','____Button', 'Next')