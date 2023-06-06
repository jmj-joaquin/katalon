import java.sql.Timestamp
import java.text.SimpleDateFormat

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext

import internal.GlobalVariable


class NewTestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def setTestCaseDetails(TestCaseContext testCaseContext) {
		String testCase = testCaseContext.getTestCaseId()
		String testCaseStep = testCase.substring((testCase.lastIndexOf("/").toInteger()) + 1)
		String testCaseId = testCase.substring((testCase.indexOf("/").toInteger()) + 1)
		String testStepId = testCase.substring((testCase.indexOf("/").toInteger()) + 1)
		GlobalVariable.G_TestStep = testCaseStep.split("-")[5]
		GlobalVariable.G_TestId = testCaseId.split(" ")[0]
		GlobalVariable.G_TestStepId = testCaseStep.split("-")[1]
		//GlobalVariable.screenCounter++
	}
	
	@BeforeTestSuite
	def setTimeStamp() {
		String timestamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Timestamp(System.currentTimeMillis()));
		GlobalVariable.G_TestTimeStamp = timestamp
	}
}