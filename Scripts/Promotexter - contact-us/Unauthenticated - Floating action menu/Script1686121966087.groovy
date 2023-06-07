import com.kms.katalon.core.testobject.TestObject
import com.utils.CommonFunctionsVer1

import internal.GlobalVariable

'Arrange'
// Instantiate
CommonFunctionsVer1 CF = new CommonFunctionsVer1(
	folder: "Promotexter",
	testCaseID: "1",
	function: "Floating action menu",
)
// Test Objects
TestObject iconViber = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Floating_Viber_Icon')
TestObject labelViber = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Floating_Viber_Label')
TestObject iconMessenger = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Floating_Messenger_Icon')
TestObject labelMessenger = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Floating_Messenger_Label')
// Some of Arrange are in Profiles > default 

'Act'
CF.initialize(GlobalVariable.siteUrls['Promotexter_ContactUs'])
// Most of Act are in Keywords > com.utils > CommonFunctionsVer1

'Assert'
CF.scrollAndClick(iconViber)
CF.verifyElementPresent(labelViber, GlobalVariable.timeOut['short'])

CF.scrollAndClick(iconMessenger)
CF.scrollAndClick(iconMessenger)

CF.closeBrowserAfter(GlobalVariable.timeOut['short'])