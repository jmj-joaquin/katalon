import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable

WebUI.waitForElementClickable(CF.runtimeObj('Member','____Button', 'Start Enrolment'), GlobalVariable.G_Timeout['Medium'])
String oldUrl = WebUI.getUrl()
String newUrl = oldUrl.replaceAll("tvc", "cee")
WebUI.navigateToUrl(newUrl)
WebUI.waitForElementClickable(CF.runtimeObj('Member','____Button', 'Start Enrolment'), GlobalVariable.G_Timeout['Medium'])
CF.click('Member','____Button', 'Start Enrolment')