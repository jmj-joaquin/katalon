import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable

CF.browserStart(GlobalVariable.siteUrls['EE-ER_Login'])
CF.setTextAndVerify('Member', true, 'Username', GlobalVariable.G_Creds['EE_Uname'])
CF.setTextAndVerify('Member', true, 'Password', GlobalVariable.G_Creds['Password'])
CF.click('Member','____Button', 'Login')
CF.setText('Member', false, '1', GlobalVariable.G_Creds['OTP'])
CF.checkAndClosePopup()

WebUI.waitForElementClickable(CF.runtimeObj('Member','____Navbar item', 'Manage MPF'), GlobalVariable.G_Timeout['Medium'])
CF.click('Member','____Navbar item', 'Manage MPF')
CF.click('Member','____Navbar item', 'Withdraw Benefits')

WebUI.waitForElementClickable(CF.runtimeObj('Member','____Card (item)', 'Withdrawal of Voluntary Contributions'), GlobalVariable.G_Timeout['Medium'])
CF.click('Member','____Card (item)', 'Withdrawal of Voluntary Contributions')