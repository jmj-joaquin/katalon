import com.kms.katalon.core.testobject.TestObject
import com.utils.CommonFunctionsVer1

import internal.GlobalVariable

'Arrange'
// Instantiate
CommonFunctionsVer1 CF = new CommonFunctionsVer1(
	folder: "Promotexter",
	testCaseID: "1",
	function: "Our Location",
)
// Test Objects
TestObject mapPhilippines = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Philippines_Map')
TestObject mapHongkong = CF.getRuntimeObj('Unauthenticated', 'Contact Us_Middle_Hongkong_Map')
// Some of Arrange are in Profiles > default 

'Act'
CF.initialize(GlobalVariable.siteUrls['Promotexter_ContactUs'])
// Most of Act are in Keywords > com.utils > CommonFunctionsVer1

'Assert'
CF.verifyElementAttributeValue(mapPhilippines, 'src', 'https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d7723.570908957054!2d121.05277500000001!3d14.554257999999999!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x6f0778b2fc6f363f!2sPromotexter!5e0!3m2!1sen!2sph!4v1602492823423!5m2!1sen!2sph', GlobalVariable.timeOut['short'])
CF.verifyElementAttributeValue(mapHongkong, 'src', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1806.75229152604!2d114.16901012028154!3d22.317089123561853!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x34040175e130ef7f%3A0xa95d737bd05a4fa6!2sPromotexter%20Ltd.!5e0!3m2!1sen!2sph!4v1602493105141!5m2!1sen!2sph', GlobalVariable.timeOut['short'])

CF.closeBrowserAfter(GlobalVariable.timeOut['short'])