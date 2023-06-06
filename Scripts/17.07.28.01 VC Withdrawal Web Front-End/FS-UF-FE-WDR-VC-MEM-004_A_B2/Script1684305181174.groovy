import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable

'Get Data from Input Validation Checklist Excel File'
List<List<String>> payloads = CF.checkPayloads()
List<String> failedTestTypes = new ArrayList()
String payload

WebUI.waitForElementClickable(CF.runtimeObj('Member','____Button (radio)', 'Withdraw by Percentage of Each Fund'), GlobalVariable.G_Timeout['Medium'])
CF.click('Member','____Button (radio)', 'Withdraw by Percentage of Each Fund')

'Screen start..'
CF.resetPayload(failedTestTypes, payload)
'Loop and put the Payload Value to newly defined payloadItem variable'
for(int i = 0; i < 1/*payloads.size()*/ ; i++) {
	payload = payloads[i][1]
	String testType = payloads[i][0]
	if(failedTestTypes.contains(testType)) continue;
	
	'Input Validation'
	CF.setText('Member', false, '1', payload)
	CF.setText('Member', false, '2', payload)

	'Check Payload Test Result / Check if Warning Pop-up page is available'
	CF.checkPayloadResult(testType, failedTestTypes)
}
	
'Check if all test type failed'
CF.checkTestProgress(failedTestTypes, payloads);

'Happy Path Flow'
CF.setTextAndVerify('Member', false, '1', '10')
CF.setTextAndVerify('Member', false, '2', '10')
CF.click('Member','____Button', 'Next')