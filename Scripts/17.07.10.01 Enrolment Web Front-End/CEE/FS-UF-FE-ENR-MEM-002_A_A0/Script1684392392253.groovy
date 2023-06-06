import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.utils.CommonFunctions as CF

import internal.GlobalVariable

WebUI.waitForElementClickable(CF.runtimeObj('Member','____Card (item)', 'Tax Deductible Voluntary Contribution Account'), GlobalVariable.G_Timeout['Medium'])
CF.click('Member','____Card (item)', 'Tax Deductible Voluntary Contribution Account')