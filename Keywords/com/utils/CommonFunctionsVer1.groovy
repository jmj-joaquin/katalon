package com.utils

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import java.sql.Timestamp
import java.text.SimpleDateFormat

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

public class CommonFunctionsVer1 {
	String projectDirectory = RunConfiguration.getProjectDir()
	String folder
	String testCaseID
	String function
	String timestamp = new SimpleDateFormat('yyyMMdd_HHmmss').format(new Timestamp(System.currentTimeMillis()))
	List<String> failedTestTypes = new ArrayList()
	List<List<String>> payloads = this.loadPayloads()
	int retryCount = 0

	@Keyword
	public void initialize(String url) {
		try {
			WebUI.openBrowser(url)
			WebUI.maximizeWindow()
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage())

			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on initialize()")
				WebUI.waitForPageLoad(GlobalVariable.timeOut['medium'])
				initialize(url)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public TestObject getRuntimeObj(String portal, String objectName) {

		def xpath = this.getColumnData(portal, objectName, "Location attribute (xpath)")
		TestObject testObject = new TestObject(objectName)
		testObject.addProperty("XPath", ConditionType.EQUALS, xpath)
		System.out.println("The testObject is "+ testObject)
		return testObject
	}

	@Keyword
	public void scrollAndClick(TestObject testObject) {
		try {
			WebUI.scrollToElement(testObject, GlobalVariable.timeOut['medium'])
			WebUI.click(testObject)
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage())

			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on scrollAndClick()")
				WebUI.waitForElementClickable(testObject, GlobalVariable.timeOut['medium'])
				scrollAndClick(testObject)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public void setTextAndVerify(TestObject testObject, String text) {
		try {
			this.removeText(testObject)
			WebUI.setText(testObject, text)
			WebUI.verifyElementAttributeValue(testObject, 'value', text, GlobalVariable.timeOut['medium'])
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage())

			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on setTextAndVerify()")
				WebUI.waitForElementVisible(testObject, GlobalVariable.timeOut['medium'])
				setTextAndVerify(testObject, text)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public void verifyElementAttributeValue(TestObject testObject, String attribute, String value, Integer timeout) {
		String testType = 'Functional testing'
		try {
			scrollToElement(testObject)
			if (WebUI.verifyElementAttributeValue(testObject, attribute, value, timeout, FailureHandling.OPTIONAL)) {
				String status = 'P'
				this.takeScreenshot(status, testType)
			} else {
				String status = 'F'
				String screenshotFilename = this.takeScreenshot(status, testType)
				KeywordUtil.markFailed(((testType + ': Incorrect result') + '. Screenshot: ') + screenshotFilename)
				failedTestTypes.add(testType)
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage())

			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on setTextAndVerify()")
				WebUI.waitForElementVisible(testObject, GlobalVariable.timeOut['medium'])
				verifyElementAttributeValue(testObject, attribute, value, timeout)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public void verifyElementText(TestObject testObject, String text) {
		String testType = 'Functional testing'
		try {
			scrollToElement(testObject)
			if (WebUI.verifyElementText(testObject, text, FailureHandling.OPTIONAL)) {
				String status = 'P'
				this.takeScreenshot(status, testType)
			} else {
				String status = 'F'
				String screenshotFilename = this.takeScreenshot(status, testType)
				KeywordUtil.markFailed(((testType + ': Incorrect result') + '. Screenshot: ') + screenshotFilename)
				failedTestTypes.add(testType)
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage())

			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on setTextAndVerify()")
				WebUI.waitForElementVisible(testObject, GlobalVariable.timeOut['medium'])
				verifyElementText(testObject, text)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public void verifyElementPresent(TestObject testObject, Integer timeout) {
		String testType = 'Functional testing'
		try {
			scrollToElement(testObject)
			if (WebUI.verifyElementPresent(testObject, timeout, FailureHandling.OPTIONAL)) {
				String status = 'P'
				this.takeScreenshot(status, testType)
			} else {
				String status = 'F'
				String screenshotFilename = this.takeScreenshot(status, testType)
				KeywordUtil.markFailed(((testType + ': Incorrect result') + '. Screenshot: ') + screenshotFilename)
				failedTestTypes.add(testType)
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage())

			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on setTextAndVerify()")
				WebUI.waitForElementVisible(testObject, GlobalVariable.timeOut['medium'])
				verifyElementPresent(testObject, timeout)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public void verifyElementClickable(TestObject testObject) {
		String testType = 'Functional testing'
		try {
			scrollToElement(testObject)
			if (WebUI.verifyElementClickable(testObject)) {
				String status = 'P'
				this.takeScreenshot(status, testType)
			} else {
				String status = 'F'
				String screenshotFilename = this.takeScreenshot(status, testType)
				KeywordUtil.markFailed(((testType + ': Incorrect result') + '. Screenshot: ') + screenshotFilename)
				failedTestTypes.add(testType)
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage())

			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on setTextAndVerify()")
				WebUI.waitForElementVisible(testObject, GlobalVariable.timeOut['medium'])
				verifyElementClickable(testObject)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public void setPhoneNo(TestObject phoneNoInput, String phoneNo) {
		try {
			this.removeText(phoneNoInput)
			for(def index = 0; index <8; index++) {
				WebUI.setText(phoneNoInput, phoneNo.charAt(index).toString())
			}
			WebUI.verifyElementAttributeValue(phoneNoInput, 'value', phoneNo, GlobalVariable.timeOut['medium'])
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage())

			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on setPhoneNo()")
				WebUI.waitForElementVisible(phoneNoInput, GlobalVariable.timeOut['medium'])
				setPhoneNo(phoneNoInput, phoneNo)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public void removeText(TestObject testObject) {
		try {
			WebUI.sendKeys(testObject, Keys.chord(Keys.CONTROL, 'a'))
			WebUI.sendKeys(testObject, Keys.chord(Keys.BACK_SPACE))
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage())

			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				KeywordUtil.markWarning(message)
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on removeText()")
				WebUI.waitForElementVisible(testObject, GlobalVariable.timeOut['medium'])
				removeText(testObject)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	private List<List<String>> loadPayloads() {
		try {
			def path = RunConfiguration.getProjectDir()
			def file = path + "/Data Files/Input Validation Checklist_Final_amended.xlsx"
			def workbook = new XSSFWorkbook(file)
			def sheet = workbook.getSheet('Sheet1')
			List<List<String>> payloads = new ArrayList()

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				List<String> payload = new ArrayList()
				payload.add(sheet.getRow(i).getCell(1).getStringCellValue())
				payload.add(sheet.getRow(i).getCell(3).getStringCellValue())
				payloads.add(payload)
			}
			return payloads
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage())

			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount    + ". Issue on loadPayloads()")
				loadPayloads()
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
				return null
			}
		}
	}

	@Keyword
	public String getColumnData(String portal, String objectName, String columnName) {

		def path = RunConfiguration.getProjectDir()
		def filePath = path + "/Data Files/Object Inventory/UI Elements Inventory_Web.xlsx"
		def workbook = new XSSFWorkbook(new File(filePath))
		def sheet = workbook.getSheet(portal)
		def columnFIndex = -1
		def targetColumnIndex = -1
		def headerRow = sheet.getRow(0)

		for (int i = 0; i < headerRow.getLastCellNum(); i++) {
			def cellValue = headerRow.getCell(i)?.getStringCellValue()

			if (cellValue == "Object Name") {
				columnFIndex = i
			} else if (cellValue == columnName) {
				targetColumnIndex = i
			}
		}

		if (targetColumnIndex == -1)
			KeywordUtil.markErrorAndStop("\n\nCF.getRuntimeObj(): The given columnName is not found. Please check if your columnName is correct.\n")

		if (columnFIndex == -1)
			KeywordUtil.markErrorAndStop("\n\nCF.getRuntimeObj(): The \'Object Name\' column is not found. Please check your excel\n")

		for (row in sheet) {
			def columnFValue = row.getCell(columnFIndex)?.getStringCellValue()

			if (columnFValue == objectName) {
				def targetColumnValue = row.getCell(targetColumnIndex)?.getStringCellValue()

				if(targetColumnValue != null) {
					System.out.println("The xpath value is = " + targetColumnValue)
					return targetColumnValue
				} else {
					KeywordUtil.markErrorAndStop("\n\nCF.getRuntimeObj(): Xpath is not found based on the \'Object Name\'. Please check if your xpath is not empty.\n")
				}
			}
		}

		KeywordUtil.markErrorAndStop("\n\nCF.getRuntimeObj(): The given \'Object Name\' is not found. Please check if your \'Object Name\' is correct.\n")
	}

	@Keyword
	public String takeScreenshot(String status, String testType) {
		try {
			System.out.println(this.testCaseID)
			String screenshotFilename = this.projectDirectory + '/Screenshots/' + this.folder + '/' + this.testCaseID + '/' + this.function + '_' + this.timestamp + '/' + status + '_' + testType + '.jpg'
			WebUI.takeFullPageScreenshot(screenshotFilename)
			return screenshotFilename
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage())

			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on takeScreenshot()")
				takeScreenshot(status, testType)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
				return null
			}
		}
	}

	@Keyword
	public void checkTestProgress() {
		try {
			List<String> testTypes = new ArrayList()

			for (List<String> payload : this.payloads) {
				if (!testTypes.contains(payload.get(0))) {
					testTypes.add(payload.get(0))
				}
			}

			if(failedTestTypes.size() == testTypes.size()) {
				KeywordUtil.markFailedAndStop('All test type failed. Stop the test automation.')
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage())

			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on checkTestProgress()")
				checkTestProgress()
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public void setCorrectInputs(List<List> inputs) {
		try {
			for(int i=0; i<inputs.size(); i++) {
				TestObject targetInput = inputs[i][0]
				String defaultValue = inputs[i][1]
				this.setTextAndVerify(targetInput, defaultValue)
			}
		} catch (Exception e) {
			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on setCorrectInputs()")
				setCorrectInputs(inputs)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public void runPayloads(List<List> inputs, TestObject passFlag) {
		for(int i = 0; i < inputs.size(); i++) {
			TestObject targetInput = inputs[i][0]
			String defaultValue = inputs[i][1]

			for(int j = 0; j < this.payloads.size(); j++) {
				String payload = this.payloads[j][1]
				String testType = this.payloads[j][0]

				if(this.failedTestTypes.contains(testType)) continue;
				if(this.checkIfPayloadLengthExceeded(targetInput, payload)) continue;

				WebUI.scrollToElement(targetInput, GlobalVariable.timeOut['short'])
				this.setTextAndVerify(targetInput, payload)

				if (WebUI.verifyElementPresent(passFlag, GlobalVariable.timeOut['short'], FailureHandling.OPTIONAL)) {
					String status = 'P'
					this.takeScreenshot(status, testType)
				} else {
					String status = 'F'
					String screenshotFilename = this.takeScreenshot(status, testType)
					KeywordUtil.markFailed((('Inproper validation for ' + testType) + '. Screenshot: ') + screenshotFilename)
					failedTestTypes.add(testType)
				}
			}
			this.setTextAndVerify(targetInput, defaultValue)
			checkTestProgress()
		}
	}

	private boolean checkIfPayloadLengthExceeded(TestObject targetInput, String payload) {
		String inputFieldMaxLength = WebUI.getAttribute(targetInput, 'maxlength')
		if (inputFieldMaxLength == null) return;

		int payloadLength = payload.size()

		if(Integer.parseInt(inputFieldMaxLength) <= payloadLength) {
			KeywordUtil.markPassed("Skip payload: The payload string length is exceeded the inputfield's max length.")
			return true
		} else {
			return false
		}
	}

	@Keyword
	public void callTestCase(String testCaseWithFolder) {
		try {
			WebUI.callTestCase(findTestCase("Test Cases/" + testCaseWithFolder), null, FailureHandling.OPTIONAL)
		} catch (Exception e) {
			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on callTestCase()")
				callTestCase(testCaseWithFolder)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public void delay(int seconds) {
		try {
			WebUI.delay(seconds)
		} catch (Exception e) {
			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on delay()")
				delay(seconds)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public void scrollToElement(TestObject testObject) {
		try {
			WebUI.scrollToElement(testObject, GlobalVariable.timeOut['short'])
		} catch (Exception e) {
			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on scrollToElement()")
				scrollToElement(testObject)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}

	@Keyword
	public void closeBrowserAfter(int seconds) {
		try {
			WebUI.delay(seconds)
			WebUI.closeBrowser()
		} catch (Exception e) {
			if (retryCount < GlobalVariable.G_retryCount) {
				retryCount++
				System.out.println("Retrying... Retry count: " + retryCount + ". Issue on closeBrowserAfter()")
				closeBrowserAfter(seconds)
			} else {
				System.out.println("Maximum number of retries reached. Test failed.")
				retryCount = 0
			}
		}
	}
}