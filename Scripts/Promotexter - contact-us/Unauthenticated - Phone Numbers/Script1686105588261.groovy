import com.kms.katalon.core.testobject.TestObject
import com.utils.CommonFunctionsVer1

import internal.GlobalVariable

'Arrange'
// Instantiate
CommonFunctionsVer1 CF = new CommonFunctionsVer1(
	folder: "Promotexter",
	testCaseID: "1",
	function: "Phone Numbers",
)
// Test Objects
TestObject phonePhilippines = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Philippines Phone No._Label')
TestObject phoneHongkong = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Hong Kong Phone No._Label')
// Some of Arrange are in Profiles > default 

'Act'
CF.initialize(GlobalVariable.siteUrls['Promotexter_ContactUs'])
// Most of Act are in Keywords > com.utils > CommonFunctionsVer1

'Assert'
CF.verifyElementPresent(phonePhilippines, GlobalVariable.timeOut['short'])
CF.verifyElementPresent(phoneHongkong, GlobalVariable.timeOut['short'])

CF.closeBrowserAfter(GlobalVariable.timeOut['short'])