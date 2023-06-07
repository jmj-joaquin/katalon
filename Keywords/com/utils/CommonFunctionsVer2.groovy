package com.utils

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CommonFunctionsVer2 {

	//Functions called indirectly

	@Keyword
	public static String xpathToObj(String xpath) {

		System.out.println("Parameter for xpath is "+xpath)
		TestObject testobject

		testobject = new TestObject().addProperty("XPath", ConditionType.EQUALS, xpath)
		System.out.println("The testobject is "+ testobject)

		return testobject
	}

	@Keyword
	public static String getXpath(String sheetName, String parameter) {

		def path = RunConfiguration.getProjectDir()
		def filePath = path + "/Data Files/Object Inventory/eMPF UI Elements Inventory_Web.xlsx"

		def workbook = new XSSFWorkbook(new File(filePath))

		def sheet = workbook.getSheet(sheetName)

		// Find the column indexes for columns F and G
		def columnFIndex = -1
		def columnGIndex = -1
		def headerRow = sheet.getRow(0)
		for (int i = 0; i < headerRow.getLastCellNum(); i++) {
			def cellValue = headerRow.getCell(i)?.getStringCellValue()
			if (cellValue == "Object Name") {
				columnFIndex = i
			} else if (cellValue == "Location attribute (xpath)") {
				columnGIndex = i
			}
		}

		// If either column index is -1, the column was not found
		if (columnFIndex == -1 || columnGIndex == -1) {
			System.out.println("return null ")
			return null
		}

		for (row in sheet) {
			def columnFValue = row.getCell(columnFIndex)?.getStringCellValue()

			if (columnFValue == parameter) {
				def columnGValue = row.getCell(columnGIndex)?.getStringCellValue()
				System.out.println("The xpath value is = "+columnGValue)
				return columnGValue
			}
		}
		System.out.println("return null 2")
		return null
	}

	@Keyword
	public static List<List<String>> checkPayloads() {
		def path = RunConfiguration.getProjectDir()
		def file = path + "/Data Files/Input Validation Checklist_Final_amended.xlsx"
		def workbook = new XSSFWorkbook(file)
		def sheet = workbook.getSheet('Sheet1')

		List<List<String>> payloads = new ArrayList();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			List<String> payload = new ArrayList()
			payload.add(sheet.getRow(i).getCell(1).getStringCellValue()) // Test Type
			payload.add(sheet.getRow(i).getCell(3).getStringCellValue()) // Test Payload
			payloads.add(payload)
		}

		return payloads
	}

	@Keyword
	public static TestObject runtimeObj(String sheetName, String objectName, String xPathVar, String index=null) {
		def xpath = this.getXpath(sheetName, objectName);
		xpath = xpath.replaceAll("xPathVar", xPathVar)
		if(index!=null) {
			xpath = xpath.replaceAll("index", index)
		}
		TestObject testobject

		testobject = new TestObject().addProperty("XPath", ConditionType.EQUALS, xpath)
		System.out.println("The testobject is "+ testobject)

		return testobject
	}

	@Keyword
	public static void removeText(TestObject testObj) {
		WebUI.sendKeys(testObj, Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(testObj, Keys.chord(Keys.BACK_SPACE))
	}

	//Functions called directly

	@Keyword
	public static void setText(String portal, Boolean hasLabel, String xPathVar, String payload, String index=null){
		TestObject testObj
		String objName
		if (hasLabel==true) {
			if(index==null) {
				objName = '____Input field w/ label'
				testObj = this.runtimeObj(portal, objName, xPathVar)
			} else if (index!=null) {
				objName = '____Input field w/ label & index'
				testObj = this.runtimeObj(portal, objName, xPathVar, index)
			}
		} else if (hasLabel==false) {
			objName = '____Input field w/o label'
			testObj = this.runtimeObj(portal, objName, xPathVar)
		}
		WebUI.scrollToElement(testObj, GlobalVariable.G_Timeout['Short'])
		this.removeText(testObj)
		WebUI.setText(testObj, payload)
	}

	@Keyword
	public static void setTextAndVerify(String portal, Boolean hasLabel, String xPathVar, String payload, String index=null){
		TestObject testObj
		String objName
		if (hasLabel==true) {
			if(index==null) {
				objName = '____Input field w/ label'
				testObj = this.runtimeObj(portal, objName, xPathVar)
			} else if (index!=null) {
				objName = '____Input field w/ label & index'
				testObj = this.runtimeObj(portal, objName, xPathVar, index)
			}
		} else if (hasLabel==false) {
			objName = '____Input field w/o label'
			testObj = this.runtimeObj(portal, objName, xPathVar)
		}
		WebUI.scrollToElement(testObj, GlobalVariable.G_Timeout['Short'])
		this.removeText(testObj)
		WebUI.setText(testObj, payload)
		WebUI.verifyElementAttributeValue(testObj, 'value', payload, 10)
	}

	@Keyword
	public static void setNumberAndVerify(String portal, Boolean hasLabel, String xPathVar, String payload, String index=null){
		TestObject testObj
		String objName
		if (hasLabel==true) {
			if(index==null) {
				objName = '____Input field w/ label'
				testObj = this.runtimeObj(portal, objName, xPathVar)
			} else if (index!=null) {
				objName = '____Input field w/ label w/ index'
				testObj = this.runtimeObj(portal, objName, xPathVar, index)
			}
		} else if (hasLabel==false) {
			objName = '____Input field w/o label'
			testObj = this.runtimeObj(portal, objName, xPathVar)
		}
		WebUI.scrollToElement(testObj, GlobalVariable.G_Timeout['Short'])
		this.removeText(testObj)
		for (int i = 0;i < payload.length(); i++){
			WebUI.setText(testObj, (payload.charAt(i)).toString())
		}
		WebUI.verifyElementAttributeValue(testObj, 'value', payload, 10)
	}

	@Keyword
	public static void setDropdownAndVerify(String sheetName, Boolean hasLabel, String xpathVar, String itemXpathVar, String index=null){
		TestObject object
		TestObject valueObj
		String objName
		String valueObjName
		if (hasLabel==true) {
			if(index==null) {
				objName = '____Dropdown field w/ label'
				valueObjName = '____Dropdown value w/ label'
				object = this.runtimeObj(sheetName, objName, xpathVar)
				valueObj = this.runtimeObj(sheetName, valueObjName, xpathVar)
			} else if (index!=null) {
				objName = '____Dropdown field w/ label & index'
				valueObjName = '____Dropdown value w/ label & index'
				object = this.runtimeObj(sheetName, objName, xpathVar, index)
				valueObj = this.runtimeObj(sheetName, valueObjName, xpathVar, index)
			}
		} else if (hasLabel==false) {
			objName = '____Dropdown field w/o label'
			valueObjName = '____Dropdown value w/o label'
			object = this.runtimeObj(sheetName, objName, xpathVar)
			valueObj = this.runtimeObj(sheetName, valueObjName, xpathVar)
		}
		TestObject itemObj = this.runtimeObj(sheetName, '____Dropdown item', itemXpathVar)
		WebUI.scrollToElement(object, GlobalVariable.G_Timeout['Short'])
		WebUI.click(object)
		String itemText = WebUI.getText(itemObj)
		WebUI.click(itemObj)
		WebUI.verifyElementText(valueObj, itemText)
	}

	public static void setDateAndVerify(String sheetName, Boolean hasLabel, String xpathVar, String itemXpathVar, String valueXpathVar, String index=null){
		TestObject object
		TestObject valueObj
		String objName
		String valueObjName
		if (hasLabel==true) {
			if(index==null) {
				objName = '____Date field w/ label'
				valueObjName = '____Date value w/ label'
				object = this.runtimeObj(sheetName, objName, xpathVar)
				valueObj = this.runtimeObj(sheetName, valueObjName, valueXpathVar)
			} else if (index!=null) {
				objName = '____Date field w/ label & index'
				valueObjName = '____Date value w/o label & index'
				object = this.runtimeObj(sheetName, objName, xpathVar, index)
				valueObj = this.runtimeObj(sheetName, valueObjName, valueXpathVar, index)
			}
		} else if (hasLabel==false) {
			objName = '____Date field w/o label'
			valueObjName = '____Date value w/o label'
			object = this.runtimeObj(sheetName, objName, xpathVar)
			valueObj = this.runtimeObj(sheetName, valueObjName, valueXpathVar, index)
		}
		TestObject itemObj = this.runtimeObj(sheetName, '____Date item', itemXpathVar)
		WebUI.scrollToElement(object, GlobalVariable.G_Timeout['Short'])
		WebUI.click(object)
		WebUI.click(itemObj)
		String itemText = WebUI.getAttribute(valueObj, 'value')
		WebUI.verifyElementAttributeValue(object, 'value', itemText, GlobalVariable.G_Timeout['Short'])
	}

	@Keyword
	public static void click(String portal, String objName, String xPathVar, String index=null) {
		TestObject testObj
		if(index==null) {
			testObj = this.runtimeObj(portal, objName, xPathVar)
		} else if (index!=null) {
			testObj = this.runtimeObj(portal, objName, xPathVar, index)
		}
		//ssBeforeNextScreen()
		WebUI.scrollToElement(testObj, GlobalVariable.G_Timeout['Short'])
		WebUI.click(testObj)
	}

	@Keyword
	public static void uploadFile(String portal, String xPathVar, String file, String index=null) {
		String filePath = RunConfiguration.getProjectDir() + '/Include/resources/' + file
		TestObject testObj
		if(index==null) {
			testObj = this.runtimeObj(portal, '____Upload area', xPathVar)
		} else if (index!=null) {
			testObj = this.runtimeObj(portal, '____Upload area w/ index', xPathVar, index)
		}
		WebUI.scrollToElement(testObj, GlobalVariable.G_Timeout['Short'])
		WebUI.uploadFile(testObj, filePath)
	}

	@Keyword
	public static void browserStart(String url) {
		'Open Browser and Nagivate to eMPF URL'
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(url)
	}

	@Keyword
	public static void resetPayload(List<String> failedTestTypes, String payload) {
		failedTestTypes = null
		payload = null
	}

	@Keyword
	public static void checkPayloadResult(String testType, List<String> failedTestTypes) {
		String status
		String dirName = RunConfiguration.getProjectDir()
		TestObject FirstFailFlag = this.runtimeObj('Member', '____Fail flag', 'disable')
		/*TestObject SecondFailFlag = this.runtimeObj('Member', '__Inline Error Msg_Label')*/

		'Check Payload Test Result / Check if Warning Pop-up page is available'
		if (WebUI.verifyElementPresent(FirstFailFlag, GlobalVariable.G_Timeout['Short'], FailureHandling.OPTIONAL)==true /*|| WebUI.verifyElementPresent(SecondFailFlag, GlobalVariable.G_Timeout['Short'], FailureHandling.OPTIONAL)==true*/) {
			status = 'P'
			String screenshotFilename = dirName + '/Screenshots/02/' + GlobalVariable.G_TestId + '/' + GlobalVariable.G_TestStep + '_' + GlobalVariable.G_TestTimeStamp + '/' + status + '_' + testType + '_' + GlobalVariable.G_TestStepId + '.jpg'
			WebUI.takeFullPageScreenshot(screenshotFilename)
		} else {
			status = 'F'
			String screenshotFilename = dirName + '/Screenshots/02/' + GlobalVariable.G_TestId + '/' + GlobalVariable.G_TestStep + '_' + GlobalVariable.G_TestTimeStamp + '/' + status + '_' + testType + '_' + GlobalVariable.G_TestStepId + '.jpg'
			WebUI.takeFullPageScreenshot(screenshotFilename)
			KeywordUtil.markFailed('Inproper validation for '+testType+'. Screenshot: '+screenshotFilename)
			failedTestTypes.add(testType)
		}
	}

	@Keyword
	public static void checkTestProgress(List<String> failedTestTypes, List<String> payloads) {
		if(failedTestTypes.size() == payloads.size())
			KeywordUtil.markFailedAndStop('All test type failed. Stop the test automation.');
	}

	@Keyword
	public static void bypassiAMSmart() {
		WebUI.delay(GlobalVariable.G_Timeout['Short'])
		String oldUrl = WebUI.getUrl()
		String urlRedirect = oldUrl.split("&")[2]
		urlRedirect = urlRedirect.substring((urlRedirect.lastIndexOf("=").toInteger()) + 1)
		String urlState = oldUrl.split("&")[6]
		String newUrl = urlRedirect + '?businessID=bypass&code=' + GlobalVariable.G_Creds['EE_HKID'] + '&' + urlState
		newUrl = newUrl.replaceAll("%3A", ":")
		newUrl = newUrl.replaceAll("%2F", "/")
		WebUI.navigateToUrl(newUrl)
	}

	@Keyword
	public static void checkAndClosePopup() {
		if (WebUI.waitForElementClickable(runtimeObj('Member','____Button (icon)', 'close'), GlobalVariable.G_Timeout['Medium'], FailureHandling.OPTIONAL)==true) {
			WebUI.click(runtimeObj('Member','____Button (icon)', 'close'))
		}
	}

	/*
	 @Keyword
	 public static void ssBeforeNextScreen() {
	 String dirName = RunConfiguration.getProjectDir()
	 String screenshotFilename = dirName + '/Screenshots/02/' + GlobalVariable.G_TestId + '/' + GlobalVariable.G_TestStep + '_' + GlobalVariable.G_TestTimeStamp + '/' + 'Flow' + '_' + GlobalVariable.screenCounter + '.jpg'
	 WebUI.takeFullPageScreenshot(screenshotFilename)
	 }
	 */

}
