import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF
'Get Data from Input Validation Checklist Excel File'
List<List<String>> payloads = CF.checkPayloads()
List<String> failedTestTypes = new ArrayList()
String payload

CF.click('Employer', '____Button (arrow)', '2')
WebUI.click(CF.runtimeObj('Employer', '____Dropdown field w/o label', '1'))
WebUI.click(CF.runtimeObj('Employer', '____Label', 'Scheme Enrolment'))
WebUI.click(CF.runtimeObj('Employer', '____Label', 'Employee Termination'))
WebUI.click(CF.runtimeObj('Employer', '____Label', 'Employee Enrolment'))
WebUI.click(CF.runtimeObj('Employer', '____Label', 'Contribution'))
CF.click('Employer', '____Button', 'Search')
WebUI.click(CF.runtimeObj('Employer', '____Date field w/o label', '2'))
WebUI.click(CF.runtimeObj('Employer', '____Date item', '1'))
WebUI.click(CF.runtimeObj('Employer', '____Date item (end)', '2'))
CF.click('Employer', '____Button', 'Search')

'Screen start..'
'Loop and put the Payload Value to newly defined payloadItem variable'
for(int i = 0; i < payloads.size() ; i++) {
	payload = payloads[i][1]
	String testType = payloads[i][0]
	if(failedTestTypes.contains(testType)) continue;
	'Input Validation'
	CF.setText('Employer', false, '1', payload)	
	'Check Payload Test Result / Check if Warning Pop-up page is available'
	CF.checkPayloadResult(testType, failedTestTypes)
}

'Check if all test type failed'
CF.checkTestProgress(failedTestTypes, payloads);