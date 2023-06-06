import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable

WebUI.waitForElementClickable(CF.runtimeObj('Member','____Dropdown field w/ label', 'Scheme Name'), GlobalVariable.G_Timeout['Medium'])
CF.setDropdownAndVerify('Member', true, 'Scheme Name', 'Sun Life Rainbow MPF Scheme')
CF.click('Member','____Button', 'Next')