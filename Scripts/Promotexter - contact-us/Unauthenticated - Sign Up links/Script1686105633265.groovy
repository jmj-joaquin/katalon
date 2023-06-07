import com.kms.katalon.core.testobject.TestObject
import com.utils.CommonFunctionsVer1

import internal.GlobalVariable

'Arrange'
// Instantiate
CommonFunctionsVer1 CF = new CommonFunctionsVer1(
	folder: "Promotexter",
	testCaseID: "1",
	function: "Sign Up links",
)
// Test Objects
TestObject navItemSignUp = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Sign Up Now_Button')
TestObject btnGetStarted = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Get Started_Button')
// Some of Arrange are in Profiles > default 

'Act'
CF.initialize(GlobalVariable.siteUrls['Promotexter_ContactUs'])
// Most of Act are in Keywords > com.utils > CommonFunctionsVer1

'Assert'
CF.verifyElementPresent(navItemSignUp, GlobalVariable.timeOut['short'])
CF.verifyElementPresent(btnGetStarted, GlobalVariable.timeOut['short'])

CF.closeBrowserAfter(GlobalVariable.timeOut['short'])