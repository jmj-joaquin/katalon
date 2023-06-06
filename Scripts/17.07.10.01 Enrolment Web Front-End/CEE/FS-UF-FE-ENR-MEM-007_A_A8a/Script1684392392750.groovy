import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable

WebUI.waitForElementClickable(CF.runtimeObj('Member', '____Input field w/o label', '1'), GlobalVariable.G_Timeout['Medium'])
CF.setNumberAndVerify('Member', false, '1', '100')
CF.setNumberAndVerify('Member', false, '2', '100')
CF.setNumberAndVerify('Member', false, '3', '100')
CF.setNumberAndVerify('Member', false, '4', '100')
CF.click('Member','____Button', 'Next')