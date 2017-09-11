package com.hms.hotelogix.automationframework.tests.admin.RoomsManager.RoomTaxesTest;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.hotelogix.automationframework.pages.Frontdesk.Accounts.AccountsLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.CashCounterPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskContinueTrialPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskLandingPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.GroupTax.AddGroupTaxPage;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.GroupTax.GroupTaxLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTaxes.AddRoomTaxPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTaxes.AuditTrialPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTaxes.EditRoomTaxPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTaxes.RoomTaxesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.EditRoomType;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.RoomTypesLandingPage;


public class RoomTaxesTest {
	
	
	
	
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	private AdminHome AH;

	




@BeforeMethod()
public void Login() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
AdminLogin AL=GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser)), "http://hotelogix.stayezee.com/admine/");
//AL=GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, Constant.Col_Browser), "http://hotelogix.stayezee.com/admine/");
AH=AL.adminlogin("13135", "vj@stayzee.com", "deepak");// for http://hotelogix.stayezee.com/admine/
//AH=AL.fn_adminLogin("12487","deepakTest3@stayezee.com","18e44afe");// //http://livestable.hx.local/admine/ url.
ExcelUtil.CloseAllExcelReferences(); //http://livestable.hx.local/admine/
Reporter.log("Login Successfull", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw e;
}
}	
	
//Directing to Room Tax List Page.	
@Test(priority=1,groups={"P0","RoomTaxesTest"})	
public void HMS8707() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
Assert.assertEquals(GenericClass.getText(RTLP.Txt_PageTitle).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Page title verified for Room Taxes page", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}


// To verify title.
@Test(priority=2,groups={"P0","RoomTaxesTest"})
public void HMS8854() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	Assert.assertEquals(GenericClass.driver.getTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Page title Bar verified for Room Taxes page", true);
	ExcelUtil.CloseAllExcelReferences(); 
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}


	

//Verify elements on Room Tax List Page	
@Test(priority=3,groups={"P0","RoomTaxesTest"})	
public void HMS1803() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
RTLP.VerifyPageElements();
Reporter.log("All the page elements over Room Tax landing page", true);
ExcelUtil.CloseAllExcelReferences(); 	
}catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;
}
}




//To verify 'Add a tax' button.
@Test(priority=4,groups={"P0","RoomTaxesTest"})
public void HMS5788() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();


RTLP.ClickOnAddATaxButton();
Assert.assertEquals(GenericClass.driver.getTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
ExcelUtil.CloseAllExcelReferences(); 
Reporter.log("Add a tax Page verified after clicking over Add a tax button.", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}
	
	

//To Verify elements on Add/Edit Room Tax page.
@Test(priority=5,groups={"P0","RoomTaxesTest"})
public void HMS8559() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();
Assert.assertEquals(GenericClass.getText(ARTP.Txt_PageHeader).trim(),ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1) ));
Assert.assertEquals(GenericClass.getText(ARTP.Txt_DetailFillUp).trim(),ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
ARTP.VerifyPageElement();
ExcelUtil.CloseAllExcelReferences(); 
Reporter.log("All The page Elements verified", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}



//To verify Main in Add/Edit Room Tax.
@Test(priority=6,groups={"P0"})
public void HMS1811() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
AH=ARTP.ClickOnMainLink();
Assert.assertEquals(AH.fn_verifyPageTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));	
ExcelUtil.CloseAllExcelReferences(); 	
Reporter.log("Main link verified and Administrator title verified.", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}



//To verify Room Tax List link in Add/Edit a Tax.
@Test(priority=7,groups={"P0"})
public void HMS1810() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();

AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
RTLP=ARTP.ClickOnRoomTaxListLink();
Assert.assertEquals(GenericClass.driver.getTitle(),  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
ExcelUtil.CloseAllExcelReferences(); 
Reporter.log("Room Tax list link verified", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}
	


	
//Verify tax type dropdown when % is selected
@Test(priority=8,groups={"P0","RoomTaxesTest"})
public void HMS4702() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
Assert.assertEquals(ARTP.VerifyCalcRuleForTaxType("On Room Tariff Charged","percentage"), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Thread.sleep(2000); 
Assert.assertEquals(ARTP.VerifyCalcRuleForTaxType("On Published Rack Rate","percentage"),  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
ExcelUtil.CloseAllExcelReferences(); 
Reporter.log("Calculation rule verified for Percentage tax", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}	 
}
	
	
	
	

//To ADD A TAX with Valid Data with save tax button at the end of the page.	
@Test(priority=9,groups={"P0","RoomTaxesTest"})	
public void HMS9028() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtBottom);
Assert.assertEquals(GenericClass.getText(RTLP.ValidationMsg).trim(),RTLP.ValidationFormat(ARTP.taxTitle).trim());
Reporter.log("Room Taxes Added", true);
RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
RoomTypesLandingPage  RTSLP=AH.fn_NavigateRoomTypes();
EditRoomType  ERT=RTSLP.fn_EditRoomtype();
ERT.VerifyAddedTax(ARTP.taxTitle);
GroupTaxLandingPage  GTLP=AH.fn_NavigateToGroupTax();
AddGroupTaxPage  AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
AGTP.GetTaxAndVerify(ARTP.taxTitle);
Reporter.log("Taxes are verified", true);
RTLP=AH.fn_NavigateToRoomTaxes();
ExcelUtil.CloseAllExcelReferences();
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}



//To ADD A TAX with Valid Data with save button on top right corner of the page.
@Test(priority=10,groups={"P0","RoomTaxesTest"})
public void HMS1804() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
	String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
	String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
	RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);
	Assert.assertEquals(GenericClass.getText(RTLP.ValidationMsg).trim(),RTLP.ValidationFormat(ARTP.taxTitle).trim());
	Reporter.log("Room Taxes Added", true);
	RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
	RoomTypesLandingPage  RTSLP=AH.fn_NavigateRoomTypes();
	EditRoomType  ERT=RTSLP.fn_EditRoomtype();
	ERT.VerifyAddedTax(ARTP.taxTitle);
	GroupTaxLandingPage  GTLP=AH.fn_NavigateToGroupTax();
	AddGroupTaxPage  AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
	AGTP.GetTaxAndVerify(ARTP.taxTitle);
	Reporter.log("Taxes are verified", true);
	RTLP=AH.fn_NavigateToRoomTaxes();
	RTLP.fn_deleteTheTax(ARTP.taxTitle);
	ExcelUtil.CloseAllExcelReferences();
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}	
	
	
//To Add a tax with valid data.
@Test(priority=11,groups={"P0","RoomTaxesTest"})
public void HMS8893() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
	String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
	String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
	RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);
	Assert.assertEquals(GenericClass.getText(RTLP.ValidationMsg).trim(),RTLP.ValidationFormat(ARTP.taxTitle).trim());
	Reporter.log("Room Taxes Added", true);
	RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
	RoomTypesLandingPage  RTSLP=AH.fn_NavigateRoomTypes();
	EditRoomType  ERT=RTSLP.fn_EditRoomtype();
	ERT.VerifyAddedTax(ARTP.taxTitle);
	GroupTaxLandingPage  GTLP=AH.fn_NavigateToGroupTax();
	AddGroupTaxPage  AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
	AGTP.GetTaxAndVerify(ARTP.taxTitle);
	Reporter.log("-----Taxes are verified----", true);
	ExcelUtil.CloseAllExcelReferences();
	RTLP=AH.fn_NavigateToRoomTaxes();
	RTLP.fn_deleteTheTax(ARTP.taxTitle);
	ExcelUtil.CloseAllExcelReferences();
		
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}

	
	
//Verify tax type dropdown when % is selected
@Test(priority=12,groups={"P0","RoomTaxesTest"})
public void HMS4703() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
Assert.assertEquals(ARTP.VerifyCalcRuleForTaxType("Per Reservation","fix"), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Thread.sleep(2000); 
Assert.assertEquals(ARTP.VerifyCalcRuleForTaxType("Per Night/Session","fix"),  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
Thread.sleep(2000);
Assert.assertEquals(ARTP.VerifyCalcRuleForTaxType("Per Person Per Night/Session","fix"),  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
ExcelUtil.CloseAllExcelReferences(); 
Reporter.log("Calculation rule verified for Fix Tax Type", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;
}
}



//Verify tax type dropdown when % is selected
@Test(priority=13,groups={"P0","RoomTaxesTest"})
public void HMS8892() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
	String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
	String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
	RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);
	
	Assert.assertEquals(GenericClass.getText(RTLP.ValidationMsg).trim(),RTLP.ValidationFormat(ARTP.taxTitle).trim());
	Reporter.log("Room Taxes Added", true);
	RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
	RoomTypesLandingPage  RTSLP=AH.fn_NavigateRoomTypes();
	EditRoomType  ERT=RTSLP.fn_EditRoomtype();
	ERT.VerifyAddedTax(ARTP.taxTitle);
	GroupTaxLandingPage  GTLP=AH.fn_NavigateToGroupTax();
	AddGroupTaxPage  AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
	AGTP.GetTaxAndVerify(ARTP.taxTitle);
	Reporter.log("-----fix tax created & Taxes are verified----", true);
	RTLP=AH.fn_NavigateToRoomTaxes();
	RTLP.fn_deleteTheTax(ARTP.taxTitle);
	ExcelUtil.CloseAllExcelReferences();
		
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}



//Verify tax type dropdown when % is selected
@Test(priority=14,groups={"P0","RoomTaxesTest"})
public void HMS8896() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
	String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
	String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
	RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);
	Assert.assertEquals(GenericClass.getText(RTLP.ValidationMsg).trim(),RTLP.ValidationFormat(ARTP.taxTitle).trim());
	Reporter.log("Room Taxes Added", true);
	RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
	RoomTypesLandingPage  RTSLP=AH.fn_NavigateRoomTypes();
	EditRoomType  ERT=RTSLP.fn_EditRoomtype();
	ERT.VerifyAddedTax(ARTP.taxTitle);
	GroupTaxLandingPage  GTLP=AH.fn_NavigateToGroupTax();
	AddGroupTaxPage  AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
	AGTP.GetTaxAndVerify(ARTP.taxTitle);
	RTLP=AH.fn_NavigateToRoomTaxes();
	RTLP.fn_deleteTheTax(ARTP.taxTitle);
	Reporter.log("Room Taxes deleted", true);
    ExcelUtil.CloseAllExcelReferences();
	Reporter.log("TAX ADDED AND VERIFIED TO ALL THE REFLECTIONS POINTS.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;
}
}



// To add a tax with valid data for fixed tax Per Person Per Night/Session.
@Test(priority=15,groups={"P0","RoomTaxesTest"})
public void HMS8897() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
	String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
	String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
	GenericClass.clickElement(ARTP.RB_FixedAmtTaxType);
	GenericClass.selectElement( ARTP.DD_CalculationRuleFV, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule)));
	Thread.sleep(2000);
	Assert.assertEquals(ARTP.CB_AdultChildTax.isEnabled(),true);
	Thread.sleep(2000);
	ARTP.fn_addTax(iTestCaseRow,taxType, calcRule, ARTP.Btn_SaveAtBottom);
	Thread.sleep(2000);
	Assert.assertEquals(GenericClass.getText(RTLP.ValidationMsg).trim(),RTLP.ValidationFormat(ARTP.taxTitle).trim());
	Reporter.log("Room Taxes Added", true);
	RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
	RoomTypesLandingPage  RTSLP=AH.fn_NavigateRoomTypes();
	EditRoomType  ERT=RTSLP.fn_EditRoomtype();
	ERT.VerifyAddedTax(ARTP.taxTitle);
	GroupTaxLandingPage  GTLP=AH.fn_NavigateToGroupTax();
	AddGroupTaxPage  AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
	AGTP.GetTaxAndVerify(ARTP.taxTitle);
	RTLP=AH.fn_NavigateToRoomTaxes();
	GenericClass.selectElement(RTLP.DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	RTLP.fn_deleteTheTax(ARTP.taxTitle);
	Reporter.log("-----fix tax created & Taxes are verified----", true);
	ExcelUtil.CloseAllExcelReferences();
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}






//To add a tax with valid data for fixed tax Per Person Per Night/Session.
@Test(priority=16,groups={"P0","RoomTaxesTest"})
public void HMS9119() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();	
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
	GenericClass.clickElement(ARTP.RB_FixedAmtTaxType);
	GenericClass.selectElement( ARTP.DD_CalculationRuleFV, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule)));
	Thread.sleep(2000);
	Assert.assertEquals(ARTP.CB_AdultChildTax.isEnabled(),true);
	Thread.sleep(2000);
    Reporter.log("-----Adult Child Tax CheckBox is enable.----", true);
	ExcelUtil.CloseAllExcelReferences();
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}

	





// To verify dropdown when checkbox for Adult/Chld tax is selected
@Test(priority=17,groups={"P0","RoomTaxesTest"})
public void HMS9120() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
	GenericClass.clickElement(ARTP.RB_FixedAmtTaxType);
	GenericClass.selectElement( ARTP.DD_CalculationRuleFV, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule)));
	Thread.sleep(2000);
	GenericClass.clickElement(ARTP.CB_AdultChildTax);
	Assert.assertTrue(ARTP.DD_ChildAdult.isDisplayed());
    Reporter.log("---Adult_Child dropdown is visible---- ", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}



// To add a tax with valid data for fixed tax Per Adult Per Night/Session. 
@Test(priority=18,groups={"P0","RoomTaxesTest"})
public void HMS9029() throws Exception{
try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
		AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
		String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
		String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
		ARTP.AddTaxBasedOnPaxType(iTestCaseRow,ARTP.Btn_SaveAtBottom);
		Thread.sleep(2000);
	    Assert.assertEquals(GenericClass.getText(RTLP.ValidationMsg).trim(),RTLP.ValidationFormat(ARTP.taxTitle).trim());
		Reporter.log("Room Taxes Added", true);
		RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
		RoomTypesLandingPage  RTSLP=AH.fn_NavigateRoomTypes();
		EditRoomType  ERT=RTSLP.fn_EditRoomtype();
		ERT.VerifyAddedTax(ARTP.taxTitle);
		GroupTaxLandingPage  GTLP=AH.fn_NavigateToGroupTax();
		AddGroupTaxPage  AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
		AGTP.GetTaxAndVerify(ARTP.taxTitle);
		RTLP=AH.fn_NavigateToRoomTaxes();
		GenericClass.selectElement(RTLP.DD_View, "All");
		GenericClass.ActionOnAlert("Accept");
		RTLP.fn_deleteTheTax(ARTP.taxTitle);
		Reporter.log("Room Tax deleted", true);
		Reporter.log("-----fix tax for adult created & Taxes are verified----", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;
}
}





// To add a tax with valid data for fixed tax Per Child Per Night/Session.
@Test(priority=19,groups={"P0","RoomTaxesTest"})
public void HMS9030() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();
	ARTP.AddTaxBasedOnPaxType(iTestCaseRow,ARTP.Btn_SaveAtBottom);
	Thread.sleep(2000);
    Assert.assertEquals(GenericClass.getText(RTLP.ValidationMsg).trim(),RTLP.ValidationFormat(ARTP.taxTitle).trim());
	Reporter.log("Room Taxes Added", true);
	RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
	RoomTypesLandingPage  RTSLP=AH.fn_NavigateRoomTypes();
	EditRoomType  ERT=RTSLP.fn_EditRoomtype();
	ERT.VerifyAddedTax(ARTP.taxTitle);
	GroupTaxLandingPage  GTLP=AH.fn_NavigateToGroupTax();
	AddGroupTaxPage  AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
	AGTP.GetTaxAndVerify(ARTP.taxTitle);
	RTLP=AH.fn_NavigateToRoomTaxes();
	GenericClass.selectElement(RTLP.DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	RTLP.fn_deleteTheTax(ARTP.taxTitle);
	Reporter.log("Room tax deleted.", true);
	Reporter.log("-----fix tax for child created & Taxes are verified----", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}




//To Add a Tax without Data
@Test(priority=20,groups={"P1","RoomTaxesTest"})
public void HMS1805() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();		
	GenericClass.clickElement(ARTP.Btn_SaveAtBottom);
	GenericClass.ActionOnAlert("Accept");
	Thread.sleep(2000);
	Assert.assertEquals(GenericClass.value.toString().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("---pop verified for enter tax title---", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}



// To add Room Tax with duplicate tax title.
@Test(priority=21,groups={"P1","RoomTaxesTest"})
public void HMS9031() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
	String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
	String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
	RTLP=ARTP.fn_addTax(iTestCaseRow, taxType, calcRule, ARTP.Btn_SaveAtBottom);
	String ttitle=ARTP.taxTitle;
	System.out.println(ttitle);
	ARTP=RTLP.ClickOnAddATaxButton();
	String act=ARTP.fn_verifyDuplicateTaxTitleMessage(iTestCaseRow,ttitle);
    Thread.sleep(2000);
	Assert.assertEquals(act, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
    RTLP=AH.fn_NavigateToRoomTaxes();
    GenericClass.selectElement(RTLP.DD_View, "All");
    GenericClass.ActionOnAlert("Accept");
    RTLP.fn_deleteTheTax(ARTP.taxTitle);
    Reporter.log("Tax deleted.", true);
	Reporter.log("---Duplicate room tax title message verified---", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}



// To add Room Tax with duplicate Tax ID(Short Name).
@Test(priority=22,groups={"P1","RoomTaxesTest"})
public void HMS9032() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
	String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
	String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
	RTLP=ARTP.fn_addTax(iTestCaseRow, taxType, calcRule, ARTP.Btn_SaveAtBottom);
	String taxId=ARTP.taxId;
	ARTP=RTLP.ClickOnAddATaxButton();
	String act=ARTP.fn_VerifyDuplicateTaxIdMessage(iTestCaseRow, taxId);
	Thread.sleep(2000);
    Assert.assertEquals(act, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("---Duplicate room tax id message verified---", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}



// To save tax with Tax title only.
@Test(priority=23,groups={"P1","RoomTaxesTest"},description="Pop text verified after saving tax with tax title only")
public void HMS8889() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();
	GenericClass.sendKeys(ARTP.TxtBox_TaxTitle,GenericClass.generateRandomString());
	GenericClass.clickElement(ARTP.Btn_SaveAtBottom);
	GenericClass.ActionOnAlert("Accept");
	Assert.assertEquals(GenericClass.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Pop text verified after saving tax with tax title only.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;
}
}


@Test(priority=24,groups={"P1","RoomTaxesTest"},description="Pop text verified after saving tax with tax id only")
public void HMS8890() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();
	GenericClass.sendKeys(ARTP.TxtBox_TaxShortNumber,GenericClass.generateRandomString());
	GenericClass.clickElement(ARTP.Btn_SaveAtBottom);
	GenericClass.ActionOnAlert("Accept");
	Assert.assertEquals(GenericClass.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Pop text verified after saving tax with tax id only.", true);	
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=25,description="Pop text verified after saving tax with account code only.",groups={"P1","RoomTaxesTest"})
public void HMS8894() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();
	ARTP.CreateAccountCode();
	Thread.sleep(2000);
	GenericClass.clickElement(ARTP.Btn_SaveAtBottom);
	Thread.sleep(2000);
	GenericClass.ActionOnAlert("Accept");
	Thread.sleep(2000);
	Assert.assertEquals(GenericClass.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Pop text verified after saving tax with account code only.", true);		
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=26,description="Pop text verified after saving tax with tax type and calculation rule",groups={"P1","RoomTaxesTest"})
public void HMS8891() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
	GenericClass.clickElement(ARTP.RB_PercentageTaxType);
	GenericClass.selectElement(ARTP.DD_CalculationRuleforPV, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule)));
	GenericClass.clickElement(ARTP.Btn_SaveAtBottom);
	GenericClass.ActionOnAlert("Accept");
	Thread.sleep(2000);
	Assert.assertEquals(GenericClass.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Pop text verified after saving tax with tax type and calculation rule", true);		
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=27,description="Pop tax verified after filling mandatory fields and inputting character to the tax amount field.",groups={"P1","RoomTaxesTest"})
public void HMS1807() throws Exception  {
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();
	GenericClass.sendKeys(ARTP.TxtBox_TaxTitle,GenericClass.generateRandomString());
	GenericClass.sendKeys(ARTP.TxtBox_TaxShortNumber,GenericClass.generateRandomString());
	ARTP.CreateAccountCode();
	GenericClass.clickElement(ARTP.RB_PercentageTaxType);
	GenericClass.sendKeys(ARTP.TxtBox_TaxAmountForTaxType, "amount");
	GenericClass.selectElement(ARTP.DD_CalculationRuleforPV, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule)));
	Thread.sleep(2000);
	
	GenericClass.clickElement(ARTP.Btn_SaveAtBottom);
	GenericClass.ActionOnAlert("Accept");
	Thread.sleep(2000);
	Assert.assertEquals(GenericClass.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Pop tax verified after filling mandatory fields and inputting character to the tax amount field.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=28,description="Save Tax type with Special characters",groups={"P1","RoomTaxesTest"})
public void HMS1806() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();
GenericClass.sendKeys(ARTP.TxtBox_TaxTitle,GenericClass.generateRandomString());
GenericClass.sendKeys(ARTP.TxtBox_TaxShortNumber,GenericClass.generateRandomString());
ARTP.CreateAccountCode();
GenericClass.clickElement(ARTP.RB_PercentageTaxType);
GenericClass.sendKeys(ARTP.TxtBox_TaxAmountForTaxType, "@#$%^");
GenericClass.selectElement(ARTP.DD_CalculationRuleforPV, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule)));
Thread.sleep(2000);
GenericClass.clickElement(ARTP.Btn_SaveAtBottom);
GenericClass.ActionOnAlert("Accept");
Thread.sleep(2000);
Assert.assertEquals(GenericClass.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Pop tax verified after filling mandatory fields and inputting special character to the tax amount field.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}


@Test(priority=29,description="Account code pop up verified.",groups={"P1","RoomTaxesTest"})
public void HMS8558() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();
GenericClass.clickElement(ARTP.Link_AddAccountCode);
Assert.assertEquals(GenericClass.getText(ARTP.Txt_HeaderAccountCode).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Account code pop up verified.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;		
}
}





@Test(priority=30,description="Account code pop up elements verification.",groups={"P1","RoomTaxesTest"})
public void HMS8560() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();
GenericClass.clickElement(ARTP.Link_AddAccountCode);
ARTP.fn_verifyAccountCodePopUpElements();
Reporter.log("Account code pop up elements verified.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	 
}
}

@Test(priority=31,description="Account code addition and verification to the reflections point.",groups={"P1","RoomTaxesTest"})
public void HMS8561() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();
RTLP=ARTP.fn_addTax(iTestCaseRow, taxType, calcRule, ARTP.Btn_SaveAtBottom);
String tTitle=ARTP.taxTitle;
String aCode=ARTP.accountCode;
EditRoomTaxPage ERTP=RTLP.fn_clickOnEditLink(tTitle);
String tit=GenericClass.GetCurrentWindowID();
FrontdeskContinueTrialPage  FCTP=ERTP.fn_clickOnFDLink();
GenericClass.switchToWindowHandle("Frontdesk");
CashCounterPage  CCP=FCTP.fn_ClickCountinueWithTrail_BT();
FrontdeskLandingPage  FLP=CCP.fn_ClickContinueButton();
FLP.fn_ClickCancelButton();
AccountsLandingPage ACL=FLP.fn_clickOnAccountsLink();
GenericClass.switchToWindowHandle("Accounts");
String acCode=ACL.fn_verifyAccountCode(aCode);
Assert.assertTrue(acCode.equals(aCode));
Reporter.log("Account code verified at accounts section of frontdesk.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}


@Test(priority=32,description="Verifying account code duplication error message.",groups={"P1","RoomTaxesTest"})
public void HMS8562() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
ARTP.CreateAccountCode();
String acCode=ARTP.accountCode;
Thread.sleep(2000);
RTLP=ARTP.ClickOnRoomTaxListLink();
ARTP=RTLP.ClickOnAddATaxButton();
String msg=ARTP.fn_VerifyDuplicateAccountCode(acCode);
Thread.sleep(2000);
Assert.assertEquals(msg,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Duplicate account code verified.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}

@Test(priority=33,description="Verifying account code Cancel button.",groups={"P1","RoomTaxesTest"})
public void HMS8563() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
GenericClass.clickElement(ARTP.Link_AddAccountCode);
GenericClass.clickElement(ARTP.Btn_Cancel);
Assert.assertFalse(ARTP.Txt_HeaderAccountCode.isDisplayed());
Reporter.log("Account code cancel button verified.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=34,description="Verified slab table data after clicking on Add slabs link.",groups={"P1","RoomTaxesTest"})
public void HMS4697() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
ARTP.fn_verifySlabTableElement();
Reporter.log("Verified slab table data after clicking on Add slabs link.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=35,description="Adding slab Tax with calculation rule 'On Room Tariff Charged'",groups={"P0","RoomTaxesTest"})
public void HMS4699() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
RTLP=ARTP.fn_AddSlabTax(iTestCaseRow, taxType, calcRule, ARTP.Btn_SaveAtBottom);
RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
EditRoomType ERT=RTL.fn_EditRoomtype();
ERT.VerifyAddedTax(ARTP.taxTitle);
GroupTaxLandingPage GTLP=AH.fn_NavigateToGroupTax();
AddGroupTaxPage AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
AGTP.GetTaxAndVerify(ARTP.taxTitle);
Reporter.log("Slab tax added and verified at the reflections points.", true);
RTLP=AH.fn_NavigateToRoomTaxes();
GenericClass.selectElement(RTLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
RTLP.fn_deleteTheTax(ARTP.taxTitle);
Reporter.log("Slab Tax deleted", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=36,description="Adding slab Tax with calculation rule 'On Published Rack Rate'",groups={"P0","RoomTaxesTest"})
public void HMS8904() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
	String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
	RTLP=ARTP.fn_AddSlabTax(iTestCaseRow, taxType, calcRule, ARTP.Btn_SaveAtBottom);
	RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
	RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
	EditRoomType ERT=RTL.fn_EditRoomtype();
	ERT.VerifyAddedTax(ARTP.taxTitle);
	GroupTaxLandingPage GTLP=AH.fn_NavigateToGroupTax();
	AddGroupTaxPage AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
	AGTP.GetTaxAndVerify(ARTP.taxTitle);
	Reporter.log("Slab tax added and verified at the reflections points.", true);
	RTLP=AH.fn_NavigateToRoomTaxes();
	GenericClass.selectElement(RTLP.DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	RTLP.fn_deleteTheTax(ARTP.taxTitle);
	Reporter.log("Slab Tax deleted", true);	
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;
}
}



@Test(priority=37,description="Verifying add slab link for Fixed tax type'",groups={"P1","RoomTaxesTest"})
public void HMS9033() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();	
GenericClass.clickElement(ARTP.RB_FixedAmtTaxType);
ARTP.fn_verifySlabTableElement();
Reporter.log("Slab tax table element verified after clicking ", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=38,description="Verifying add slab link for Fixed tax type along with calculation rule 'Per Reservation'",groups={"P0","RoomTaxesTest"})
public void HMS8905() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
RTLP=ARTP.fn_AddSlabTax(iTestCaseRow, taxType, calcRule, ARTP.Btn_SaveAtBottom);
RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
EditRoomType ERT=RTL.fn_EditRoomtype();
ERT.VerifyAddedTax(ARTP.taxTitle);
GroupTaxLandingPage GTLP=AH.fn_NavigateToGroupTax();
AddGroupTaxPage AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
AGTP.GetTaxAndVerify(ARTP.taxTitle);
Reporter.log("Slab tax added and verified at the reflections points.", true);
RTLP=AH.fn_NavigateToRoomTaxes();
GenericClass.selectElement(RTLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
RTLP.fn_deleteTheTax(ARTP.taxTitle);
Reporter.log("Slab Tax deleted", true);		
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}


@Test(priority=39,description="Verifying add slab link for Fixed tax type along with calculation rule 'Per Night/Session'",groups={"P0","RoomTaxesTest"})
public void HMS8906() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
	String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
	RTLP=ARTP.fn_AddSlabTax(iTestCaseRow, taxType, calcRule, ARTP.Btn_SaveAtBottom);
	RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
	RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
	EditRoomType ERT=RTL.fn_EditRoomtype();
	ERT.VerifyAddedTax(ARTP.taxTitle);
	GroupTaxLandingPage GTLP=AH.fn_NavigateToGroupTax();
	AddGroupTaxPage AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
	AGTP.GetTaxAndVerify(ARTP.taxTitle);
	Reporter.log("Slab tax added and verified at the reflections points.", true);
	RTLP=AH.fn_NavigateToRoomTaxes();
	GenericClass.selectElement(RTLP.DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	RTLP.fn_deleteTheTax(ARTP.taxTitle);
	Reporter.log("Slab Tax deleted", true);		
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=40,description="Verifying add slab link for Fixed tax type along with calculation rule 'Per Person Per Night/Session'",groups={"P0","RoomTaxesTest"})
public void HMS8907() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
ARTP.fn_addSlabforPerPersonPerNightSessionAlongWithPaxType(iTestCaseRow,ARTP.Btn_SaveAtBottom);
RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
EditRoomType ERT=RTL.fn_EditRoomtype();
ERT.VerifyAddedTax(ARTP.taxTitle);
GroupTaxLandingPage GTLP=AH.fn_NavigateToGroupTax();
AddGroupTaxPage AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
AGTP.GetTaxAndVerify(ARTP.taxTitle);
Reporter.log("Slab tax added and verified at the reflections points.", true);
RTLP=AH.fn_NavigateToRoomTaxes();
GenericClass.selectElement(RTLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
RTLP.fn_deleteTheTax(ARTP.taxTitle);
Reporter.log("Slab Tax deleted", true);		
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=41,description="Verifying add slab link for Fixed tax type along with calculation rule 'Per Adult Per Night/Session'",groups={"P0","RoomTaxesTest"})
public void HMS9034() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
	ARTP.fn_addSlabforPerPersonPerNightSessionAlongWithPaxType(iTestCaseRow,ARTP.Btn_SaveAtBottom);
	RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
	RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
	EditRoomType ERT=RTL.fn_EditRoomtype();
	ERT.VerifyAddedTax(ARTP.taxTitle);
	GroupTaxLandingPage GTLP=AH.fn_NavigateToGroupTax();
	AddGroupTaxPage AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
	AGTP.GetTaxAndVerify(ARTP.taxTitle);
	Reporter.log("Slab tax added and verified at the reflections points.", true);
	RTLP=AH.fn_NavigateToRoomTaxes();
	GenericClass.selectElement(RTLP.DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	RTLP.fn_deleteTheTax(ARTP.taxTitle);
	Reporter.log("Slab Tax deleted", true);		
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw e;	
}
}


@Test(priority=42,description="Verifying add slab link for Fixed tax type along with calculation rule 'Per Child Per Night/Session'",groups={"P0","RoomTaxesTest"})
public void HMS9035() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
	ARTP.fn_addSlabforPerPersonPerNightSessionAlongWithPaxType(iTestCaseRow,ARTP.Btn_SaveAtBottom);
	RTLP.verifyAddedTaxAlongWithStatus(ARTP.taxTitle);
	RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
	EditRoomType ERT=RTL.fn_EditRoomtype();
	ERT.VerifyAddedTax(ARTP.taxTitle);
	GroupTaxLandingPage GTLP=AH.fn_NavigateToGroupTax();
	AddGroupTaxPage AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
	AGTP.GetTaxAndVerify(ARTP.taxTitle);
	Reporter.log("Slab tax added and verified at the reflections points.", true);
	RTLP=AH.fn_NavigateToRoomTaxes();
	GenericClass.selectElement(RTLP.DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	RTLP.fn_deleteTheTax(ARTP.taxTitle);
	Reporter.log("Slab Tax deleted", true);		
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=43,description="To add slab without data",groups={"P1","RoomTaxesTest"})
public void HMS9121() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
GenericClass.sendKeys(ARTP.TxtBox_TaxTitle, GenericClass.generateRandomString());
GenericClass.sendKeys(ARTP.TxtBox_TaxShortNumber, GenericClass.generateRandomString());
GenericClass.sendKeys(ARTP.TxtArea_Description, GenericClass.generateRandomString());
GenericClass.clickElement(ARTP.RB_PercentageTaxType);
ARTP.CreateAccountCode();
GenericClass.selectElement(ARTP.DD_CalculationRuleforPV, "On Room Tariff Charged");
Thread.sleep(2000);
GenericClass.sendKeys(ARTP.TxtBox_TaxAmountForTaxType, "10");
GenericClass.clickElement(ARTP.Link_AddSlabs);
//ARTP.fn_clickOnDate("10");
GenericClass.clickElement(ARTP.Btn_SaveAtBottom);
Thread.sleep(2000);
GenericClass.ActionOnAlert("Accept");
Thread.sleep(2000);
Assert.assertEquals(GenericClass.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("pop up text verified when adding slab tax without date.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=44,description="To add slab tax without enetering tax",groups={"P1","RoomTaxesTest"})
public void HMS9122() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
	GenericClass.sendKeys(ARTP.TxtBox_TaxTitle, GenericClass.generateRandomString());
	GenericClass.sendKeys(ARTP.TxtBox_TaxShortNumber, GenericClass.generateRandomString());
	GenericClass.sendKeys(ARTP.TxtArea_Description, GenericClass.generateRandomString());
	GenericClass.clickElement(ARTP.RB_PercentageTaxType);
	ARTP.CreateAccountCode();
	GenericClass.selectElement(ARTP.DD_CalculationRuleforPV, "On Room Tariff Charged");
	Thread.sleep(2000);
	GenericClass.sendKeys(ARTP.TxtBox_TaxAmountForTaxType, "10");
	GenericClass.clickElement(ARTP.Link_AddSlabs);
	ARTP.fn_clickOnDate("10");
	GenericClass.clickElement(ARTP.Btn_SaveAtBottom);
	Thread.sleep(2000);
	GenericClass.ActionOnAlert("Accept");
	Thread.sleep(2000);
	Assert.assertEquals(GenericClass.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("pop up text verified when adding slab tax without date.", true);	
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=45,description="To verify Cancel button at top in Add/Edit a Tax page.",groups={"P1","RoomTaxesTest"})
public void HMS1808() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
GenericClass.sendKeys(ARTP.TxtBox_TaxTitle, GenericClass.generateRandomString());
GenericClass.sendKeys(ARTP.TxtBox_TaxShortNumber, GenericClass.generateRandomString());
GenericClass.sendKeys(ARTP.TxtArea_Description, GenericClass.generateRandomString());
ARTP.CreateAccountCode();
GenericClass.clickElement(ARTP.RB_PercentageTaxType);
GenericClass.selectElement(ARTP.DD_CalculationRuleforPV, "On Room Tariff Charged");	
GenericClass.sendKeys(ARTP.TxtBox_TaxAmountForTaxType, "10");
GenericClass.clickElement(ARTP.Btn_CancelAtTop);
Thread.sleep(2000);
Assert.assertEquals(GenericClass.driver.getTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Cancel button at top verified.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}


@Test(priority=46,description="To verify Cancel button at bottom in Add/Edit a Tax page.",groups={"P1","RoomTaxesTest"})
public void HMS9036() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
	GenericClass.sendKeys(ARTP.TxtBox_TaxTitle, GenericClass.generateRandomString());
	GenericClass.sendKeys(ARTP.TxtBox_TaxShortNumber, GenericClass.generateRandomString());
	GenericClass.sendKeys(ARTP.TxtArea_Description, GenericClass.generateRandomString());
	ARTP.CreateAccountCode();
	GenericClass.clickElement(ARTP.RB_PercentageTaxType);
	GenericClass.selectElement(ARTP.DD_CalculationRuleforPV, "On Room Tariff Charged");	
	GenericClass.sendKeys(ARTP.TxtBox_TaxAmountForTaxType, "10");
	Thread.sleep(2000);
	GenericClass.clickElement(ARTP.Btn_CancelAtBottom);
	Thread.sleep(2000);
	Assert.assertEquals(GenericClass.driver.getTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Cancel button at bottom verified.", true);	
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}


@Test(priority=47,description="To verify Cancel button at bottom in Add/Edit a Tax page.",groups={"P1","RoomTaxesTest"})
public void HMS5796() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);	
RTLP.fn_SelectCheckBoxForaTax(ARTP.taxTitle);
GenericClass.clickElement(RTLP.Btn_DeleteSelectedTaxes);
GenericClass.ActionOnAlert("Accept");
Thread.sleep(2000);
Assert.assertEquals(GenericClass.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Pop up text verified after clicking on delete tax button.", true);
RTLP.fn_deleteTheTax(ARTP.taxTitle);
Reporter.log("Created Tax deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=48,description="Verify Audit Trail link on Add/Edit a Room Tax page.",groups={"P1","RoomTaxesTest"})
public void HMS9043() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);
String tamt=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxAmount));
String desc=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description));
String taxTitle=ARTP.taxTitle;
String taxId=ARTP.taxId;
String acCode=ARTP.accountCode;
ARTP=RTLP.ClickOnAddATaxButton();
String a=GenericClass.GetCurrentWindowID();
AuditTrialPage  ATP=ARTP.fn_clickOnAuditTrailLink();
GenericClass.windowHandle(a);
System.out.println("acv");
ATP.fn_VerifyChanges(taxTitle +" "+ tamt+"% "+ calcRule +" created by");
ATP.fn_VerifyChanges("Account Code"+" "+acCode+ " created by");
ATP.fn_VerifyChanges("Short Order 0 created by");
ATP.fn_VerifyChanges("Description"+" "+desc+ " created by");
ATP.fn_VerifyChanges("0.00"+" "+calcRule+" created by");
ATP.fn_VerifyChanges("Tax Short Name"+" "+taxId+" created by");
ATP.fn_VerifyChanges("Tax Name"+" "+taxTitle+ " created by");
GenericClass.Switch_Parent_Window(a);
AH.fn_NavigateToRoomTaxes();
GenericClass.selectElement(RTLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
RTLP.fn_deleteTheTax(ARTP.taxTitle);
Reporter.log("Slab Tax deleted", true);		
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}





@Test(priority=49,description="To verify Delete a Tax functionality",groups={"P0","RoomTaxesTest"})
public void HMS1812() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);
RTLP.fn_deleteTheTax(ARTP.taxTitle);
String vmsg=RTLP.fn_getDeletionTaxMessage(ARTP.taxTitle);
Assert.assertEquals(GenericClass.getText(RTLP.ValidationMsg).trim(), vmsg);
RoomTypesLandingPage  RTSLP=AH.fn_NavigateRoomTypes();
EditRoomType  ERT=RTSLP.fn_EditRoomtype();
ERT.fn_verifyDeletedTax(ARTP.taxTitle);
GroupTaxLandingPage  GTLP=AH.fn_NavigateToGroupTax();
AddGroupTaxPage  AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
AGTP.fn_verifyDeletedTax(ARTP.taxTitle);
Reporter.log("-----Room Tax deleted ----", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}




@Test(priority=50,description="To Delete a tax that is added to a Room type.",groups={"P1","RoomTaxesTest"})
public void  HMS9037() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);	
String taxTitle=ARTP.taxTitle;
RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
EditRoomType ERT=RTL.fn_EditRoomtype();
RTL=ERT.fn_attachTheTaxToRoomType(taxTitle);
Thread.sleep(2000);
RTLP=AH.fn_NavigateToRoomTaxes();
RTLP.fn_SelectCheckBoxForaTax(taxTitle);
GenericClass.clickElement(RTLP.Btn_DeleteSelectedTaxes);
GenericClass.ActionOnAlert("Accept");
String vmsg=RTLP.fn_getValidationMsgWhenDeletingTaxAttachedWithRoomType(taxTitle);
Thread.sleep(2000);
Assert.assertEquals(GenericClass.getText(RTLP.ValidationMsg).trim(),vmsg);
Reporter.log("Validation message verified ehilr trying to delete tax attached to a room type.", true);
RTL=AH.fn_NavigateRoomTypes();
ERT=RTL.fn_EditRoomtype();
RTL=ERT.fn_attachTheTaxToRoomType(taxTitle);
RTLP=AH.fn_NavigateToRoomTaxes();
RTLP.fn_viewAllrecordsOnThePage();
RTLP.fn_deleteTheTax(taxTitle);
Reporter.log("Tax Deleted", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;		
}
}


@Test(priority=51,description="Cancel deleting a tax ",groups={"P2","RoomTaxesTest"})
public void HMS8902() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);	
String taxTitle=ARTP.taxTitle;
RTLP.fn_SelectCheckBoxForaTax(taxTitle);
GenericClass.clickElement(RTLP.Btn_DeleteSelectedTaxes);
GenericClass.ActionOnAlert("Dismiss");
RTLP.verifyAddedTaxAlongWithStatus(taxTitle);
Reporter.log("Tax verified after clicking on cancel button on delete pop up.", true);
RTLP.fn_viewAllrecordsOnThePage();
Thread.sleep(2000);
GenericClass.clickElement(RTLP.Btn_DeleteSelectedTaxes);
Thread.sleep(2000);
GenericClass.ActionOnAlert("Accept");
Reporter.log("Delete Tax", true);
}
catch(Exception e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;
}
}



@Test(priority=52,description="Cancel deleting a tax ",groups={"P2","RoomTaxesTest"})
public void HMS1814() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);	
EditRoomTaxPage ERTP= RTLP.fn_clickOnEditLink(ARTP.taxTitle);
RTLP=ERTP.fn_editTaxDetails();
String edTaxTitle=ERTP.taxTitle;
String msg=RTLP.fn_getValidationMessage(edTaxTitle);
Thread.sleep(2000);
Assert.assertEquals(GenericClass.getText(RTLP.ValidationMsg).trim(), msg);
Thread.sleep(2000);
RTLP.verifyAddedTaxAlongWithStatus(edTaxTitle);
RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
EditRoomType ERT=RTL.fn_EditRoomtype();
ERT.VerifyAddedTax(edTaxTitle);
GroupTaxLandingPage GTLP=AH.fn_NavigateToGroupTax();
AddGroupTaxPage AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
AGTP.GetTaxAndVerify(edTaxTitle);
Reporter.log("Edited tax verified at reflections points.", true);
RTLP=AH.fn_NavigateToRoomTaxes();
GenericClass.selectElement(RTLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
RTLP.fn_deleteTheTax(edTaxTitle);
Reporter.log(" Tax deleted", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=53,description="Verify edit link for tax slab for same activation date.",groups={"P0","RoomTaxesTest"})
public void HMS4700() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
RTLP=ARTP.fn_addSlabforPerPersonPerNightSessionAlongWithPaxType(iTestCaseRow,ARTP.Btn_SaveAtBottom);
String taxTitle=ARTP.taxTitle;
EditRoomTaxPage ERTP=RTLP.fn_clickOnEditLink(ARTP.taxTitle);
ERTP.fn_changeTaxAmtForSlab();
RTLP.verifyAddedTaxAlongWithStatus(taxTitle);
RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
EditRoomType ERT=RTL.fn_EditRoomtype();
ERT.VerifyAddedTax(taxTitle);
GroupTaxLandingPage GTLP=AH.fn_NavigateToGroupTax();
AddGroupTaxPage AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
AGTP.GetTaxAndVerify(taxTitle);
Reporter.log("Edited tax verified at reflections points.", true);
RTLP=AH.fn_NavigateToRoomTaxes();
GenericClass.selectElement(RTLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
RTLP.fn_deleteTheTax(taxTitle);
Reporter.log("Tax deleted", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}





@Test(priority=54,description="Verify edit link for tax slab for different activation date",groups={"P0","RoomTaxesTest"})
public void HMS4701() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage ARTP=RTLP.ClickOnAddATaxButton();
	RTLP=ARTP.fn_addSlabforPerPersonPerNightSessionAlongWithPaxType(iTestCaseRow,ARTP.Btn_SaveAtBottom);
	String taxTitle=ARTP.taxTitle;
	EditRoomTaxPage ERTP=RTLP.fn_clickOnEditLink(ARTP.taxTitle);
	String date=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ActivationDateForSlab));
	ERTP.fn_changeTaxSlabDate(date);
	RTLP.verifyAddedTaxAlongWithStatus(taxTitle);
	RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
	EditRoomType ERT=RTL.fn_EditRoomtype();
	ERT.VerifyAddedTax(taxTitle);
	GroupTaxLandingPage GTLP=AH.fn_NavigateToGroupTax();
	AddGroupTaxPage AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
	AGTP.GetTaxAndVerify(taxTitle);
	Reporter.log("Edited tax verified at reflections points.", true);
	RTLP=AH.fn_NavigateToRoomTaxes();
	GenericClass.selectElement(RTLP.DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	RTLP.fn_deleteTheTax(taxTitle);
	Reporter.log("Tax deleted", true);	
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=55,description="To verify sort functionality of Taxes.",groups={"P2","RoomTaxesTest"})
public void HMS5801() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);	
GenericClass.sortingName_Downward(RTLP.DD_View, "All", RTLP.TblHeader_DownWardSortBtnForTaxesColumn, RTLP.AllCheckBox, "//table[@class='list_viewnew']/tbody/tr/td[3]");
Reporter.log("As downward sort function verified.", true);
GenericClass.selectElement(RTLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
RTLP.fn_deleteTheTax(ARTP.taxTitle);
Reporter.log("Tax deleted", true);	
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}



@Test(priority=56,description="To verify sort functionality of Taxes.",groups={"P2","RoomTaxesTest"})
public void HMS9039() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);	
GenericClass.sortingName_Upward(RTLP.DD_View, "All", RTLP.TblHeader_UpWardSortBtnForSortOrderColumn, RTLP.AllCheckBox, "//table[@class='list_viewnew']/tbody/tr/td[3]");
Reporter.log("As Upward sort function verified.", true);
GenericClass.selectElement(RTLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
RTLP.fn_deleteTheTax(ARTP.taxTitle);
Reporter.log("Tax deleted", true);	
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}

@Test(priority=57,description="Verify delete icon for add slab field",groups={"P0","RoomTaxesTest"})
public void HMS4698() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RTLP=ARTP.fn_AddSlabTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtBottom);
String taxTitle=ARTP.taxTitle;
RTLP.verifyAddedTaxAlongWithStatus(taxTitle);
GenericClass.selectElement(RTLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
RTLP.fn_deleteTheTax(ARTP.taxTitle);
Thread.sleep(3000);
RTLP.fn_verifyDeletedTax(taxTitle);
RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
EditRoomType ERT=RTL.fn_EditRoomtype();
ERT.fn_verifyDeletedTax(taxTitle);
GroupTaxLandingPage GTLP=AH.fn_NavigateToGroupTax();
AddGroupTaxPage AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
AGTP.fn_verifyDeletedTax(taxTitle);
Reporter.log("Edited tax verified at reflections points.", true);
RTLP=AH.fn_NavigateToRoomTaxes();
GenericClass.selectElement(RTLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
RTLP.fn_deleteTheTax(taxTitle);
Reporter.log("Tax deleted", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;		
}
}




@Test(priority=58,description="To De-activate Room Tax",groups={"P0","RoomTaxesTest"})
public void HMS1825() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);	
String taxTitle=ARTP.taxTitle;
String status=RTLP.fn_DeactivateTheCurrency(taxTitle);
System.out.println(status);
System.out.println(RTLP.deactiveTaxStatus);
Assert.assertTrue(status.endsWith(RTLP.deactiveTaxStatus));
Reporter.log("Room tax is deactivated.", true);
RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
EditRoomType ERT=RTL.fn_EditRoomtype();
ArrayList<String> taxList1=ERT.fn_getTaxes();
Assert.assertFalse(taxList1.contains(taxTitle));
GroupTaxLandingPage GTLP=AH.fn_NavigateToGroupTax();
AddGroupTaxPage AGTP=GTLP.fn_ClickOnAddGroupTaxBtn();
ArrayList<String> taxList=AGTP.fn_getAllTaxes();
Thread.sleep(2000);
Assert.assertFalse(taxList.contains(taxTitle));
Reporter.log("Deactivated tax verified at reflections points.", true);
RTLP=AH.fn_NavigateToRoomTaxes();
GenericClass.selectElement(RTLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
RTLP.fn_deleteTheTax(taxTitle);
Reporter.log("Room Taxes deactivated and deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;		
}
}






@Test(priority=59,description="To Activate Room Tax",groups={"P0","RoomTaxesTest"})
public void HMS1823() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	String taxType=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxType));
	String calcRule=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule));
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	AddRoomTaxPage  ARTP=RTLP.ClickOnAddATaxButton();	
	RTLP=ARTP.fn_addTax(iTestCaseRow,taxType,calcRule,ARTP.Btn_SaveAtTop);
	String tamt=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxAmount));
	String desc=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description));
	String taxTitle=ARTP.taxTitle;
	String taxId=ARTP.taxId;
	String acCode=ARTP.accountCode;
	String a=GenericClass.GetCurrentWindowID();
	AuditTrialPage  ATP=RTLP.fn_clickOnAuditTrailLink();
	GenericClass.windowHandle(a);
	System.out.println("acv");
	ATP.fn_VerifyChanges(taxTitle +" "+ tamt+"% "+ calcRule +" created by");
	ATP.fn_VerifyChanges("Account Code"+" "+acCode+ " created by");
	ATP.fn_VerifyChanges("Short Order 0 created by");
	ATP.fn_VerifyChanges("Description"+" "+desc+ " created by");
	ATP.fn_VerifyChanges("0.00"+" "+calcRule+" created by");
	ATP.fn_VerifyChanges("Tax Short Name"+" "+taxId+" created by");
	ATP.fn_VerifyChanges("Tax Name"+" "+taxTitle+ " created by");
	GenericClass.Switch_Parent_Window(a);
	AH.fn_NavigateToRoomTaxes();
	GenericClass.selectElement(RTLP.DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	RTLP.fn_deleteTheTax(ARTP.taxTitle);
	Reporter.log("Created Tax deleted", true);			
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;	
}
}

@Test(priority=60,groups={"P1"}, description="To verify Cancel button and Main link in RoomTax page.")
public void HMS1815_1816() throws Exception{
try{

	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();	
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_RoomTaxes,Constant.Sheet_RoomTaxes);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);	
	RTLP.fn_VerifyCancelOrMainfunction(RTLP.Btn_Cancel);
	String title=GenericClass.driver.getTitle();
	String expected=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1));
	Assert.assertEquals(title, expected);
	AH.fn_NavigateToRoomTaxes();
	RTLP.fn_VerifyCancelOrMainfunction(RTLP.Link_Main);
	Assert.assertEquals(GenericClass.driver.getTitle(), expected);
}catch(Throwable e){
	 GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	ExcelUtil.CloseAllExcelReferences();
	 throw e;
}
}

@Test(priority=61,groups={"P1","RoomTaxes"}, description="To verify CheckBoxes in RoomTaxes page.")
public void HMS1809_8903() throws Exception{
try{
	//AdminHome AH=AL.adminlogin_12302();
	//AdminHome AH=AL.adminlogin_12954();
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	RTLP.fn_VerifyCheckboxes();
}catch(Throwable e){
	 GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	throw e;
}
}


@Test(priority=62,groups={"P1","RoomTaxes"}, description="To verify Sort Roomtaxes by status.")  
public void HMS1820_9041() throws Exception{
try{
	

	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	//RTLP.fn_CheckStatus();
	RTLP.DownwardSortByStatus();
	RTLP.UpwardSortByStatus();
}catch(Throwable e){
	 GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	 throw e;
}
}


@Test(priority=63,groups={"P1","RoomTaxes"}, description="To verify Next, Previous link and Page,View DropDown which are Displayed and Enabled.")   
public void HMS1822_9044_1821_9045_1817_1818() throws Exception{
try{
	
	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
    RTLP.fn_VerifyNextAndPreviousLink();
}catch(Throwable e){
      GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	throw e;
}
}


@Test(priority=64,groups={"P2","RoomTaxes"}, description="To verify make in order and sort by order using upward and downward arrow.")   
public void HMS1819_9041_5807() throws Exception{
try{

	RoomTaxesLandingPage RTLP=AH.fn_NavigateToRoomTaxes();
	RTLP.fn_SaveOrderAndSortupwardandDownward();
}catch(Throwable e){
	 GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	throw e;
}
}


@AfterMethod()
public void closeApp() throws Exception{
Set<String> handles = GenericClass.driver.getWindowHandles();
for(String windowId: handles){
GenericClass.driver.switchTo().window(windowId);
GenericClass.driver.close();
}
ExcelUtil.CloseAllExcelReferences();
}	
	
	
	
	
	

}
