import com.kms.katalon.core.testobject.TestObject
import com.utils.CommonFunctionsVer1

import internal.GlobalVariable

'Arrange'
// Instantiate
CommonFunctionsVer1 CF = new CommonFunctionsVer1(
	folder: "Promotexter",
	testCaseID: "1",
	function: "Email links",
)
// Test Objects
TestObject emailSupport = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Support Email_Label')
TestObject emailSales = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Sales Email_Label')
// Some of Arrange are in Profiles > default 

'Act'
CF.initialize(GlobalVariable.siteUrls['Promotexter_ContactUs'])
// Most of Act are in Keywords > com.utils > CommonFunctionsVer1

'Assert'
CF.verifyElementAttributeValue(emailSupport, 'href', 'mailto:support@promotexter.com', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(emailSales, 'href', 'mailto:sales@promotexter.com', GlobalVariable.timeOut['short'])

CF.closeBrowserAfter(GlobalVariable.timeOut['short'])