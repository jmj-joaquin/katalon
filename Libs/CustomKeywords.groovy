
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import java.lang.Boolean

import java.util.List



def static "com.utils.CommonFunctions.xpathToObj"(
    	String xpath	) {
    (new com.utils.CommonFunctions()).xpathToObj(
        	xpath)
}


def static "com.utils.CommonFunctions.getXpath"(
    	String sheetName	
     , 	String parameter	) {
    (new com.utils.CommonFunctions()).getXpath(
        	sheetName
         , 	parameter)
}


def static "com.utils.CommonFunctions.checkPayloads"() {
    (new com.utils.CommonFunctions()).checkPayloads()
}


def static "com.utils.CommonFunctions.runtimeObj"(
    	String sheetName	
     , 	String objectName	
     , 	String xPathVar	
     , 	String index	) {
    (new com.utils.CommonFunctions()).runtimeObj(
        	sheetName
         , 	objectName
         , 	xPathVar
         , 	index)
}


def static "com.utils.CommonFunctions.removeText"(
    	TestObject testObj	) {
    (new com.utils.CommonFunctions()).removeText(
        	testObj)
}


def static "com.utils.CommonFunctions.setText"(
    	String portal	
     , 	Boolean hasLabel	
     , 	String xPathVar	
     , 	String payload	
     , 	String index	) {
    (new com.utils.CommonFunctions()).setText(
        	portal
         , 	hasLabel
         , 	xPathVar
         , 	payload
         , 	index)
}


def static "com.utils.CommonFunctions.setTextAndVerify"(
    	String portal	
     , 	Boolean hasLabel	
     , 	String xPathVar	
     , 	String payload	
     , 	String index	) {
    (new com.utils.CommonFunctions()).setTextAndVerify(
        	portal
         , 	hasLabel
         , 	xPathVar
         , 	payload
         , 	index)
}


def static "com.utils.CommonFunctions.setNumberAndVerify"(
    	String portal	
     , 	Boolean hasLabel	
     , 	String xPathVar	
     , 	String payload	
     , 	String index	) {
    (new com.utils.CommonFunctions()).setNumberAndVerify(
        	portal
         , 	hasLabel
         , 	xPathVar
         , 	payload
         , 	index)
}


def static "com.utils.CommonFunctions.setDropdownAndVerify"(
    	String sheetName	
     , 	Boolean hasLabel	
     , 	String xpathVar	
     , 	String itemXpathVar	
     , 	String index	) {
    (new com.utils.CommonFunctions()).setDropdownAndVerify(
        	sheetName
         , 	hasLabel
         , 	xpathVar
         , 	itemXpathVar
         , 	index)
}


def static "com.utils.CommonFunctions.click"(
    	String portal	
     , 	String objName	
     , 	String xPathVar	
     , 	String index	) {
    (new com.utils.CommonFunctions()).click(
        	portal
         , 	objName
         , 	xPathVar
         , 	index)
}


def static "com.utils.CommonFunctions.uploadFile"(
    	String portal	
     , 	String xPathVar	
     , 	String file	
     , 	String index	) {
    (new com.utils.CommonFunctions()).uploadFile(
        	portal
         , 	xPathVar
         , 	file
         , 	index)
}


def static "com.utils.CommonFunctions.browserStart"(
    	String url	) {
    (new com.utils.CommonFunctions()).browserStart(
        	url)
}


def static "com.utils.CommonFunctions.resetPayload"(
    	java.util.List<String> failedTestTypes	
     , 	String payload	) {
    (new com.utils.CommonFunctions()).resetPayload(
        	failedTestTypes
         , 	payload)
}


def static "com.utils.CommonFunctions.checkPayloadResult"(
    	String testType	
     , 	java.util.List<String> failedTestTypes	) {
    (new com.utils.CommonFunctions()).checkPayloadResult(
        	testType
         , 	failedTestTypes)
}


def static "com.utils.CommonFunctions.checkTestProgress"(
    	java.util.List<String> failedTestTypes	
     , 	java.util.List<String> payloads	) {
    (new com.utils.CommonFunctions()).checkTestProgress(
        	failedTestTypes
         , 	payloads)
}


def static "com.utils.CommonFunctions.bypassiAMSmart"() {
    (new com.utils.CommonFunctions()).bypassiAMSmart()
}


def static "com.utils.CommonFunctions.checkAndClosePopup"() {
    (new com.utils.CommonFunctions()).checkAndClosePopup()
}


def static "com.utils.CommonFunctions.runtimeObj"(
    	String sheetName	
     , 	String objectName	
     , 	String xPathVar	) {
    (new com.utils.CommonFunctions()).runtimeObj(
        	sheetName
         , 	objectName
         , 	xPathVar)
}


def static "com.utils.CommonFunctions.setText"(
    	String portal	
     , 	Boolean hasLabel	
     , 	String xPathVar	
     , 	String payload	) {
    (new com.utils.CommonFunctions()).setText(
        	portal
         , 	hasLabel
         , 	xPathVar
         , 	payload)
}


def static "com.utils.CommonFunctions.setTextAndVerify"(
    	String portal	
     , 	Boolean hasLabel	
     , 	String xPathVar	
     , 	String payload	) {
    (new com.utils.CommonFunctions()).setTextAndVerify(
        	portal
         , 	hasLabel
         , 	xPathVar
         , 	payload)
}


def static "com.utils.CommonFunctions.setNumberAndVerify"(
    	String portal	
     , 	Boolean hasLabel	
     , 	String xPathVar	
     , 	String payload	) {
    (new com.utils.CommonFunctions()).setNumberAndVerify(
        	portal
         , 	hasLabel
         , 	xPathVar
         , 	payload)
}


def static "com.utils.CommonFunctions.setDropdownAndVerify"(
    	String sheetName	
     , 	Boolean hasLabel	
     , 	String xpathVar	
     , 	String itemXpathVar	) {
    (new com.utils.CommonFunctions()).setDropdownAndVerify(
        	sheetName
         , 	hasLabel
         , 	xpathVar
         , 	itemXpathVar)
}


def static "com.utils.CommonFunctions.click"(
    	String portal	
     , 	String objName	
     , 	String xPathVar	) {
    (new com.utils.CommonFunctions()).click(
        	portal
         , 	objName
         , 	xPathVar)
}


def static "com.utils.CommonFunctions.uploadFile"(
    	String portal	
     , 	String xPathVar	
     , 	String file	) {
    (new com.utils.CommonFunctions()).uploadFile(
        	portal
         , 	xPathVar
         , 	file)
}
