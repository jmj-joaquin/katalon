package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object G_Timeout
     
    /**
     * <p></p>
     */
    public static Object G_Creds
     
    /**
     * <p></p>
     */
    public static Object G_TestStep
     
    /**
     * <p></p>
     */
    public static Object siteUrls
     
    /**
     * <p></p>
     */
    public static Object screenCounter
     
    /**
     * <p></p>
     */
    public static Object G_TestId
     
    /**
     * <p></p>
     */
    public static Object G_TestTimeStamp
     
    /**
     * <p></p>
     */
    public static Object G_TestStepId
     
    /**
     * <p></p>
     */
    public static Object G_retryCount
     
    /**
     * <p></p>
     */
    public static Object timeOut
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            G_Timeout = selectedVariables['G_Timeout']
            G_Creds = selectedVariables['G_Creds']
            G_TestStep = selectedVariables['G_TestStep']
            siteUrls = selectedVariables['siteUrls']
            screenCounter = selectedVariables['screenCounter']
            G_TestId = selectedVariables['G_TestId']
            G_TestTimeStamp = selectedVariables['G_TestTimeStamp']
            G_TestStepId = selectedVariables['G_TestStepId']
            G_retryCount = selectedVariables['G_retryCount']
            timeOut = selectedVariables['timeOut']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
