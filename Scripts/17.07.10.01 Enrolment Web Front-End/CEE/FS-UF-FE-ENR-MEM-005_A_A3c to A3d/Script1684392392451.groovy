import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable

WebUI.waitForElementClickable(CF.runtimeObj('Member','____Card (item)', '"iAM Smart"'), GlobalVariable.G_Timeout['Medium'])
CF.click('Member','____Card (item)', '"iAM Smart"')
CF.bypassiAMSmart()