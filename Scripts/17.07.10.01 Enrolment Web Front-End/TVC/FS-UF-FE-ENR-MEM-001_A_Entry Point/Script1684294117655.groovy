import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable
CF.browserStart(GlobalVariable.siteUrls['EE-ER_Login'])
CF.setTextAndVerify('Member', true, 'Username', GlobalVariable.G_Creds['EE_Uname'])
CF.setTextAndVerify('Member', true, 'Password', GlobalVariable.G_Creds['Password'])
CF.click('Member','____Button', 'Login')
CF.setText('Member', false, '1', GlobalVariable.G_Creds['OTP'])
if (WebUI.waitForElementClickable(CF.runtimeObj('Member','____Button', 'Got it'), GlobalVariable.G_Timeout['Medium'], FailureHandling.OPTIONAL)==true) {
	WebUI.click(CF.runtimeObj('Member','____Button', 'Got it'))
}
WebUI.waitForElementClickable(CF.runtimeObj('Member','____Navbar item', 'Enrol an MPF account'), GlobalVariable.G_Timeout['Medium'])
CF.click('Member','____Navbar item', 'Enrol an MPF account')