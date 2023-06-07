import com.kms.katalon.core.testobject.TestObject
import com.utils.CommonFunctionsVer1

import internal.GlobalVariable

'Arrange'
// Instantiate
CommonFunctionsVer1 CF = new CommonFunctionsVer1(
	folder: "Promotexter",
	testCaseID: "1",
	function: "Top Navigation bar",
)
// Test Objects
TestObject logoPromotexter = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Promotexter_Logo')
TestObject navItemChannels = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Channels_Nav Item')
	TestObject subItemChat = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Chat_Sub Item')
	TestObject subItemSMS = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_SMS_Sub Item')
	TestObject subItemViber = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Viber_Sub Item')
	TestObject subItemViberAds = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Viber Ads_Sub Item')
	TestObject subItemEmail = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Email_Sub Item')
TestObject navItemDevs = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Developers_Nav Item')
	TestObject subAPIDocs = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_API Documentation_Sub Item')
	TestObject subItemItegs = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Integrations_Sub Item')
	TestObject subItemVerAPI = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Verify API_Sub Item')
	TestObject subItemAPIx = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_APIx_Sub Item')
TestObject navItemInsights = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Insights_Nav Item')
TestObject navItemPricing = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Pricing_Nav Item')
TestObject navItemLogin = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Log In_Link')
TestObject navItemSignUp = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Top_Sign Up Now_Button')
// Some of Arrange are in Profiles > default 

'Act'
CF.initialize(GlobalVariable.siteUrls['Promotexter_ContactUs'])
// Most of Act are in Keywords > com.utils > CommonFunctionsVer1

'Assert'
CF.verifyElementAttributeValue(logoPromotexter, 'src', 'https://promotexter.com/wp-content/themes/wp-bootstrap-4/assets/images/header/ptx-header-logo-dark.svg', GlobalVariable.timeOut['short'])
CF.verifyElementText(navItemChannels, 'Channels')
CF.scrollAndClick(navItemChannels)
	CF.verifyElementAttributeValue(subItemChat, 'href', GlobalVariable.siteUrls['Promotexter']+'/chat/', GlobalVariable.timeOut['short'])
	CF.verifyElementAttributeValue(subItemSMS, 'href', GlobalVariable.siteUrls['Promotexter']+'/sms/', GlobalVariable.timeOut['short'])
	CF.verifyElementAttributeValue(subItemViber, 'href', GlobalVariable.siteUrls['Promotexter']+'/viber/', GlobalVariable.timeOut['short'])
	CF.verifyElementAttributeValue(subItemViberAds, 'href', GlobalVariable.siteUrls['Promotexter']+'/viber-ads/', GlobalVariable.timeOut['short'])
	CF.verifyElementAttributeValue(subItemEmail, 'href', GlobalVariable.siteUrls['Promotexter']+'/email/', GlobalVariable.timeOut['short'])
CF.verifyElementText(navItemDevs, 'Developers')
CF.scrollAndClick(navItemChannels)
CF.scrollAndClick(navItemDevs)
	CF.verifyElementText(subAPIDocs, 'API Documentation')
	CF.verifyElementAttributeValue(subItemItegs, 'href', GlobalVariable.siteUrls['Promotexter']+'/developer/', GlobalVariable.timeOut['short'])
	CF.verifyElementAttributeValue(subItemVerAPI, 'href', GlobalVariable.siteUrls['Promotexter']+'/2fa-verify/', GlobalVariable.timeOut['short'])
	CF.verifyElementText(subItemAPIx, 'APIx')
CF.scrollAndClick(navItemDevs)
CF.verifyElementAttributeValue(navItemInsights, 'href', GlobalVariable.siteUrls['Promotexter']+'/insights/', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(navItemPricing, 'href', GlobalVariable.siteUrls['Promotexter']+'/pricing/', GlobalVariable.timeOut['short'])
CF.verifyElementText(navItemLogin, 'Log In')
CF.verifyElementPresent(navItemSignUp, GlobalVariable.timeOut['short'])

CF.closeBrowserAfter(GlobalVariable.timeOut['short'])