import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable

'Get Data from Input Validation Checklist Excel File'
List<List<String>> payloads = CF.checkPayloads()
List<String> failedTestTypes = new ArrayList()
String payload

WebUI.waitForElementClickable(CF.runtimeObj('Member', '____Dropdown field w/ label', 'Bank Name'), GlobalVariable.G_Timeout['Medium'])
CF.setDropdownAndVerify('Member', true, 'Bank Name', 'United Overseas Bank Ltd.')

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

	'Check Payload Test Result / Check if Warning Pop-up page is available'
	CF.checkPayloadResult(testType, failedTestTypes)
}
	
'Check if all test type failed'
CF.checkTestProgress(failedTestTypes, payloads);

'Happy Path Flow'
CF.setTextAndVerify('Member', true, 'Bank Account Holder Name', 'Chan Tai Man')
CF.setTextAndVerify('Member', true, 'Bank No.', '0123')
CF.setTextAndVerify('Member', true, 'Branch No.', '99000')
CF.setTextAndVerify('Member', true, 'Bank Account No.', '990000002229')
CF.click('Member','____Button', 'Next')