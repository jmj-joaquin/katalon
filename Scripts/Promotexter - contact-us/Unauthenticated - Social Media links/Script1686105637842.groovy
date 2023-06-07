import com.kms.katalon.core.testobject.TestObject
import com.utils.CommonFunctionsVer1

import internal.GlobalVariable

'Arrange'
// Instantiate
CommonFunctionsVer1 CF = new CommonFunctionsVer1(
	folder: "Promotexter",
	testCaseID: "1",
	function: "Social Media links",
)
// Test Objects
TestObject iconFacebook = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Facebook_Icon')
TestObject iconLinkedIn = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_LinkedIn_Icon')
// Some of Arrange are in Profiles > default 

'Act'
CF.initialize(GlobalVariable.siteUrls['Promotexter_ContactUs'])
// Most of Act are in Keywords > com.utils > CommonFunctionsVer1

'Assert'
CF.verifyElementAttributeValue(iconFacebook, 'href', 'https://web.facebook.com/promotexter/', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(iconLinkedIn, 'href', 'https://www.linkedin.com/company/promotexter', GlobalVariable.timeOut['short'])

CF.closeBrowserAfter(GlobalVariable.timeOut['short'])