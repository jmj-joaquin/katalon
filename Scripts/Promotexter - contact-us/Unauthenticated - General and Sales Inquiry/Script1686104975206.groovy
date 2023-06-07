import com.kms.katalon.core.testobject.TestObject
import com.utils.CommonFunctionsVer1

import internal.GlobalVariable

'Arrange'
// Instantiate
CommonFunctionsVer1 CF = new CommonFunctionsVer1(
	folder: "Promotexter",
	testCaseID: "1",
	function: "General and Sales Inquiry",
)
// Test Objects
TestObject passFlag = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Error_Label')
TestObject labelGnSInquiry = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_General and Sales Inquiry _Label')
TestObject inputName = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Name_Input')
TestObject inputEmail = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Email_Input')
TestObject inputPhoneNo = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Phone No._Input')
TestObject inputCompanyName = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Company Name_Input')
TestObject inputMessage = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Message_Input')
TestObject btnSubmit = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Submit_Button')
// Local Variables
String name = 'Testy McTest'
String email = 'test@test.com'
String phoneNo = '(+99) 999-9999-999'
String companyName = 'ABC 123 Company'
String message = 'This is a test inquiry'
List<List> inputs = [[inputName, name],[inputEmail, email],[inputPhoneNo, phoneNo],[inputCompanyName, companyName],[inputMessage, message]]
// Some of Arrange are in Profiles > default 

'Act'
CF.initialize(GlobalVariable.siteUrls['Promotexter_ContactUs'])
// Most of Act are in Keywords > com.utils > CommonFunctionsVer1

'Assert'
CF.setCorrectInputs(inputs)
CF.runPayloads(inputs, passFlag)
CF.verifyElementClickable(btnSubmit)

CF.closeBrowserAfter(GlobalVariable.timeOut['short'])