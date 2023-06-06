import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable

'Get Data from Input Validation Checklist Excel File'
List<List<String>> payloads = CF.checkPayloads()
List<String> failedTestTypes = new ArrayList()
String payload

CF.browserStart(GlobalVariable.siteUrls['EE-ER_Login'])
CF.click('Employer', '____Navbar item', 'Employer')
CF.setTextAndVerify('Employer', true, 'Username', GlobalVariable.G_Creds['ER_Uname'])
CF.setTextAndVerify('Employer', true, 'Password', GlobalVariable.G_Creds['Password'])
CF.click('Employer','____Button', 'Login')
CF.setText('Employer', false, '1', GlobalVariable.G_Creds['OTP'])
if(WebUI.verifyElementPresent(CF.runtimeObj('Employer','____Button', 'Confirm'), GlobalVariable.G_Timeout['Medium'], FailureHandling.OPTIONAL)) {
	CF.click('Employer','____Button', 'Confirm')
}
if(WebUI.verifyElementPresent(CF.runtimeObj('Employer','____Button', 'Got it'), GlobalVariable.G_Timeout['Medium'], FailureHandling.OPTIONAL)) {
	CF.click('Employer','____Button', 'Got it')
}
CF.click('Employer','____Navbar item', 'My Account')
CF.click('Employer','____Navbar item', 'My Record')
CF.click('Employer','____Button (arrow)', '1')

'Screen start..'
'Loop and put the Payload Value to newly defined payloadItem variable'
for(int i = 0; i < payloads.size() ; i++) {
	payload = payloads[i][1]
	String testType = payloads[i][0]
	if(failedTestTypes.contains(testType)) continue;
	
	if(WebUI.verifyElementPresent(CF.runtimeObj('Employer','____Input field (pagination)','1'), GlobalVariable.G_Timeout['Short'], FailureHandling.OPTIONAL)==true){
		WebUI.scrollToElement(CF.runtimeObj('Employer','____Input field (pagination)','1'), GlobalVariable.G_Timeout['Short'])
	}
	
	'Input Validation'
	CF.setText('Employer', false, '1', payload)
	CF.setText('Employer', false, '3', payload)
	if(WebUI.verifyElementPresent(CF.runtimeObj('Employer','____Input field (pagination)','1'), GlobalVariable.G_Timeout['Short'], FailureHandling.OPTIONAL)==true){
		WebUI.setText(CF.runtimeObj('Employer', '____Input field (pagination)', '1'), payload)
	}
	WebUI.scrollToElement(CF.runtimeObj('Employer','____Button', 'Search'), GlobalVariable.G_Timeout['Short'])
	
	'Check Payload Test Result / Check if Warning Pop-up page is available'
	CF.checkPayloadResult(testType, failedTestTypes)
}

'Check if all test type failed'
CF.checkTestProgress(failedTestTypes, payloads);

'Happy Path Flow'
WebUI.scrollToElement(CF.runtimeObj('Employer', '____Input field w/o label', '1'), GlobalVariable.G_Timeout['Short'])
if(WebUI.verifyElementPresent(CF.runtimeObj('Employer','____Input field (pagination)','1'), GlobalVariable.G_Timeout['Short'], FailureHandling.OPTIONAL)==true){
	WebUI.scrollToElement(CF.runtimeObj('Employer','____Input field (pagination)','1'), GlobalVariable.G_Timeout['Short'])
}
CF.setTextAndVerify('Employer', false, '1', '51712291474')
CF.setTextAndVerify('Employer', false, '3', 'Wen Lee')
if(WebUI.verifyElementPresent(CF.runtimeObj('Employer','____Input field (pagination)','1'), GlobalVariable.G_Timeout['Short'], FailureHandling.OPTIONAL)==true){
			WebUI.setText(CF.runtimeObj('Employer', '____Input field (pagination)', '1'), '2')
}
WebUI.scrollToElement(CF.runtimeObj('Employer','____Button', 'Search'), GlobalVariable.G_Timeout['Short'])
CF.click('Employer','____Button', 'Search')