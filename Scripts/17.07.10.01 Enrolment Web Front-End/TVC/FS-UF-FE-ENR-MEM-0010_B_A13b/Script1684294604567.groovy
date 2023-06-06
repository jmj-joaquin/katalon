import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable
'Get Data from Input Validation Checklist Excel File'
List<List<String>> payloads = CF.checkPayloads()
List<String> failedTestTypes = new ArrayList()
String payload

WebUI.waitForElementVisible(CF.runtimeObj('Member','____Label', 'Confirmation'), GlobalVariable.G_Timeout['Medium'])
WebUI.scrollToElement(CF.runtimeObj('Member', '____Button (radio)', 'Yes'), GlobalVariable.G_Timeout['Short'])
CF.click('Member', '____Button (radio)', 'Yes')
CF.setDropdownAndVerify('Member', true, 'Intermediary Fulfilment Requirement (IFF) Flag', 'YES')

'Screen start..'
CF.resetPayload(failedTestTypes, payload)
'Loop and put the Payload Value to newly defined payloadItem variable'
for(int i = 0; i < 1/*payloads.size()*/ ; i++) {
	payload = payloads[i][1]
	String testType = payloads[i][0]
	if(failedTestTypes.contains(testType)) continue;
	
	'Input Validation'
	CF.setText('Member', true, 'MPF Intermediary No.', payload)
	CF.setText('Member', true, 'Name of Intermediary', payload)
	CF.setText('Member', true, 'Agent/Broker Code', payload)
	CF.setText('Member', true, 'Split Percentage or Amount', payload)
	
	'Check Payload Test Result / Check if Warning Pop-up page is available'
	CF.checkPayloadResult(testType, failedTestTypes)
}

'Check if all test type failed'
CF.checkTestProgress(failedTestTypes, payloads);

'Happy Path Flow'
CF.setTextAndVerify('Member', true, 'MPF Intermediary No.', '231231231')
CF.setTextAndVerify('Member', true, 'Name of Intermediary', 'ABC Intermediary')
CF.setTextAndVerify('Member', true, 'Agent/Broker Code', '231231231')
CF.setTextAndVerify('Member', true, 'Split Percentage or Amount', '60')
CF.click('Member','____Button', 'Confirm')
CF.click('Member','____Button', 'Next')