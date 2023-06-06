import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable

WebUI.waitForElementVisible(CF.runtimeObj('Member','____Label', 'Terms and Conditions'), GlobalVariable.G_Timeout['Medium'])
WebUI.scrollToElement(CF.runtimeObj('Member','____P title', 'Language'), GlobalVariable.G_Timeout['Short'])
//CF.clickToNextScreen('Member', '___Button', 'Accept')