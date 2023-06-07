import com.kms.katalon.core.testobject.TestObject
import com.utils.CommonFunctionsVer1

import internal.GlobalVariable

'Arrange'
// Instantiate
CommonFunctionsVer1 CF = new CommonFunctionsVer1(
	folder: "Promotexter",
	testCaseID: "1",
	function: "Footer links",
)
// Test Objects
TestObject iconFacebook = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_Facebook_Icon')
TestObject iconMail = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_Mail_Icon')
TestObject iconLinkedIn = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_LinkedIn_Icon')

TestObject linkChat = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_Chat_Link')
TestObject linkSMS = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_SMS_Link')
TestObject linkViber = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_Viber_Link')
TestObject linkEmail = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_Email_Link')
TestObject linkContact = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_Contact_Link')
TestObject linkSupport = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_Support_Link')
TestObject linkSales = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_Sales_Link')
TestObject linkCareers = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_Careers_Link')
TestObject linkToS = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_Terms of Service_Link')
TestObject linkPrivacyPolicy = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Bottom_Privacy Policy_Link')
// Some of Arrange are in Profiles > default 

'Act'
CF.initialize(GlobalVariable.siteUrls['Promotexter_ContactUs'])
// Most of Act are in Keywords > com.utils > CommonFunctionsVer1

'Assert'
CF.verifyElementAttributeValue(iconFacebook, 'href', 'https://web.facebook.com/promotexter', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(iconMail, 'href', 'https://mail.google.com/mail/?view=cm&fs=1&tf=1&to=sales@promotexter.com&su=Promotexter%20Inquiry&body=Hello%20Promotexter,', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(iconLinkedIn, 'href', 'https://www.linkedin.com/company/promotexter', GlobalVariable.timeOut['short'])

CF.verifyElementAttributeValue(linkChat, 'href', GlobalVariable.siteUrls['Promotexter']+'/chat/', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(linkSMS, 'href', GlobalVariable.siteUrls['Promotexter']+'/sms/', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(linkViber, 'href', GlobalVariable.siteUrls['Promotexter']+'/viber/', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(linkEmail, 'href', GlobalVariable.siteUrls['Promotexter']+'/email/', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(linkContact, 'href', GlobalVariable.siteUrls['Promotexter']+'/contact-us/', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(linkSupport, 'href', 'https://mail.google.com/mail/?view=cm&fs=1&tf=1&to=support@promotexter.com&su=Promotexter%20Help%20Inquiry&body=Hello%20Promotexter,', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(linkSales, 'href', GlobalVariable.siteUrls['Promotexter']+'/contact-us/', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(linkCareers, 'href', GlobalVariable.siteUrls['Promotexter']+'/careers/', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(linkToS, 'href', GlobalVariable.siteUrls['Promotexter']+'/terms-of-service/', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(linkPrivacyPolicy, 'href', GlobalVariable.siteUrls['Promotexter']+'/privacy-policy/', GlobalVariable.timeOut['short'])

CF.closeBrowserAfter(GlobalVariable.timeOut['short'])