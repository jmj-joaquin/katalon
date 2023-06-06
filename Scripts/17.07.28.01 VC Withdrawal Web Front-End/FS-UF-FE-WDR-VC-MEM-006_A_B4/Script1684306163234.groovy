import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable

CF.checkAndClosePopup()
WebUI.waitForElementClickable(CF.runtimeObj('Member', '____Button', 'Submit'), GlobalVariable.G_Timeout['Medium'])
CF.click('Member', '____Button', 'Submit')