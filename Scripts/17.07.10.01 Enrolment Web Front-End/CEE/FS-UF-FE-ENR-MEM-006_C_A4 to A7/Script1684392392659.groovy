import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable
'Get Data from Input Validation Checklist Excel File'
List<List<String>> payloads = CF.checkPayloads()
List<String> failedTestTypes = new ArrayList()
String payload

//Personal Details Section
'Personal Details'
'Happy Path Flow'
WebUI.waitForElementClickable(CF.runtimeObj('Member', '____Dropdown field w/ label', 'Place of Birth'), GlobalVariable.G_Timeout['Medium'])
CF.setDropdownAndVerify('Member', true, 'Place of Birth', 'Hong Kong')
CF.setDropdownAndVerify('Member', true, 'Nationality', 'China')
CF.setTextAndVerify('Member', true, 'Job Title', 'HR Manager')
CF.click('Member','____Card (section)', 'Contact Details')

//Contact Details Section
'Contact Details'
'Happy Path Flow'
CF.click('Member','____Button w/ index', 'Verify', '1')
CF.setText('Member', false, '2', GlobalVariable.G_Creds['OTP'])
CF.click('Member','____Button w/ index', 'Verify', '1')
CF.setText('Member', false, '3', GlobalVariable.G_Creds['OTP'])
CF.setDropdownAndVerify('Member', false, '2', '+852')
CF.setNumberAndVerify('Member', false, '3', '65425610')
CF.click('Member','____Card (section)', 'Address')

//Address Section
'Address'
'Happy Path Flow'
CF.click('Member','____Card (section)', 'Way of Communication')

//Way of Communication Section
'Way of Communication'
'Happy Path Flow'
CF.click('Member','____Card (section)', 'Common Reporting Standard Information')

//Common Reporting Standard Information Section
'Common Reporting Standard Information'
CF.click('Member', '____Button (radio)', 'Not Hong Kong but other jurisdictions or countries')
CF.setDropdownAndVerify('Member', true, 'Jurisdiction of Tax Residency', 'Afghanistan')
CF.click('Member', '____Button (radio)', 'No TIN')
CF.click('Member', '____Button (radio)', 'The account holder is unable to obtain a TIN. Please explain why the account holder is unable to obtain a TIN if you have selected this reason.')

'Screen start..'
CF.resetPayload(failedTestTypes, payload)
'Loop and put the Payload Value to newly defined payloadItem variable'
for(int i = 0; i < 1/*payloads.size()*/ ; i++) {
	payload = payloads[i][1]
	String testType = payloads[i][0]
	if(failedTestTypes.contains(testType)) continue;
	
	'Input Validation'
	CF.setText('Member', false, '1', payload)
	
	'Check Payload Test Result / Check if Warning Pop-up page is available'
	CF.checkPayloadResult(testType, failedTestTypes)
}

'Check if all test type failed'
CF.checkTestProgress(failedTestTypes, payloads);

'Happy Path Flow'
CF.setTextAndVerify('Member', false, '1', 'Lorem ipsum sit dolor ame')
CF.click('Member','____Button', 'Next')