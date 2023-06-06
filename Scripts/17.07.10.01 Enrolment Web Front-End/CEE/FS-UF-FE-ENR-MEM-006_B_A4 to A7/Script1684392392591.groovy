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
WebUI.scrollToElement(CF.runtimeObj('Member','____Card (section)', 'Way of Communication'), GlobalVariable.G_Timeout['Short'])
CF.click('Member','____Button (radio)', 'Other Address')
CF.setDropdownAndVerify('Member', true, 'Country/Region', 'Hong Kong', '2')
CF.setDropdownAndVerify('Member', true, 'District', 'Kennedy Town', '2')

'Screen start..'
CF.resetPayload(failedTestTypes, payload)
'Loop and put the Payload Value to newly defined payloadItem variable'
for(int i = 0; i < 1/*payloads.size()*/ ; i++) {
	payload = payloads[i][1]
	String testType = payloads[i][0]
	if(failedTestTypes.contains(testType)) continue;
	
	'Input Validation'
	CF.setText('Member', true, 'Flat/Room', payload, '2')
	CF.setText('Member', true, 'Floor/House No.', payload, '2')
	CF.setText('Member', true, 'Block', payload, '2')
	CF.setText('Member', true, 'Building', payload, '2')
	CF.setText('Member', true, 'Street (Street No. and Street Name)', payload, '2')
	
	'Check Payload Test Result / Check if Warning Pop-up page is available'
	CF.checkPayloadResult(testType, failedTestTypes)
}

'Check if all test type failed'
CF.checkTestProgress(failedTestTypes, payloads);

'Happy Path Flow'
CF.setTextAndVerify('Member', true, 'Flat/Room', '701', '2')
CF.setTextAndVerify('Member', true, 'Floor/House No.', '7', '2')
CF.setTextAndVerify('Member', true, 'Block', '10', '2')
CF.setTextAndVerify('Member', true, 'Building', 'Example Building', '2')
CF.setTextAndVerify('Member', true, 'Street (Street No. and Street Name)', '100 Example Street', '2')
CF.click('Member','____Card (section)', 'Way of Communication')

//Way of Communication Section
'Way of Communication'
'Happy Path Flow'
CF.click('Member','____Card (section)', 'Common Reporting Standard Information')

//Common Reporting Standard Information Section
'Common Reporting Standard Information'
CF.click('Member', '____Button (radio)', 'Hong Kong and other jurisdictions or countries')
CF.setDropdownAndVerify('Member', true, 'Jurisdiction of Tax Residency', 'Hong Kong')

'Screen start..'
CF.resetPayload(failedTestTypes, payload)
'Loop and put the Payload Value to newly defined payloadItem variable'
for(int i = 0; i < 1/*payloads.size()*/ ; i++) {
	payload = payloads[i][1]
	String testType = payloads[i][0]
	if(failedTestTypes.contains(testType)) continue;
	
	'Input Validation'
	CF.setText('Member', true, 'Taxpayer Identification Number (TIN)', payload)
	
	'Check Payload Test Result / Check if Warning Pop-up page is available'
	CF.checkPayloadResult(testType, failedTestTypes)
}

'Check if all test type failed'
CF.checkTestProgress(failedTestTypes, payloads);

'Happy Path Flow'
CF.setTextAndVerify('Member', true, 'Taxpayer Identification Number (TIN)', '123321212')
CF.click('Member','____Button', 'Next')