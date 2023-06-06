import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable

'Get Data from Input Validation Checklist Excel File'
List<List<String>> payloads = CF.checkPayloads()
List<String> failedTestTypes = new ArrayList()
String payload

WebUI.waitForElementClickable(CF.runtimeObj('Member','____Button (radio)', 'Single Payment'), GlobalVariable.G_Timeout['Medium'])
WebUI.scrollToElement(CF.runtimeObj('Member','____Button (radio)', 'Single Payment'), GlobalVariable.G_Timeout['Short'])
CF.click('Member','____Button (radio)', 'Single Payment')
CF.setText('Member', true, 'Contribution Amount', '10000')
CF.setDateAndVerify('Member', true, 'Contribution Start Date','1','Contribution Start Date')
WebUI.scrollToElement(CF.runtimeObj('Member','____Card (section)', 'Payment Method'), GlobalVariable.G_Timeout['Short'])
CF.click('Member','____Card (section)', 'Payment Method')

CF.setDropdownAndVerify('Member', true, 'Default Payment Method', 'By Direct Debit Authorizatoin') //Typo on actual site
CF.setDropdownAndVerify('Member', true, 'Bank Name', 'United Overseas Bank Ltd.')
CF.setDropdownAndVerify('Member', true, 'Identification Type', 'Passport')

'Screen start..'
CF.resetPayload(failedTestTypes, payload)
'Loop and put the Payload Value to newly defined payloadItem variable'
for(int i = 0; i < 1/*payloads.size()*/ ; i++) {
	payload = payloads[i][1]
	String testType = payloads[i][0]
	if(failedTestTypes.contains(testType)) continue;
	
	'Input Validation'
	CF.setText('Member', true, 'Bank Account Holder Name', payload)
	CF.setText('Member', true, 'Bank No.', payload)
	CF.setText('Member', true, 'Branch No.', payload)
	CF.setText('Member', true, 'Bank Account No.', payload)
	CF.setText('Member', true, 'Identification No.', payload)
	CF.setText('Member', true, 'DDA Limit for Each Payment', payload)
	
	'Check Payload Test Result / Check if Warning Pop-up page is available'
	CF.checkPayloadResult(testType, failedTestTypes)
}

'Check if all test type failed'
CF.checkTestProgress(failedTestTypes, payloads);

'Happy Path Flow'
CF.setTextAndVerify('Member', true, 'Bank Account Holder Name', 'Chai Tai Man')
CF.setTextAndVerify('Member', true, 'Bank No.', '2324')
CF.setTextAndVerify('Member', true, 'Branch No.', '121232')
CF.setTextAndVerify('Member', true, 'Bank Account No.', '11110001010100')
CF.setTextAndVerify('Member', true, 'Identification No.', 'A12345678')
CF.setText('Member', true, 'DDA Limit for Each Payment', '100000')
CF.click('Member','____Button', 'Next')