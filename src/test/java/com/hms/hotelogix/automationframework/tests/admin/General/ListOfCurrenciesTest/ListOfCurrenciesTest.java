package com.hms.hotelogix.automationframework.tests.admin.General.ListOfCurrenciesTest;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.CashCounterPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskContinueTrialPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage.GroupEnableEditingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage.GroupReservationPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage.GroupViewDetailPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.Payment.AccountStatementLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.Payment.ReservationFolioPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.General.DefaultSettings.DefaultSettingsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.General.ListofCurrencies.AddCurrencyPage;
import com.hms.hotelogix.automationframework.pages.admin.General.ListofCurrencies.AuditTrailPage;
import com.hms.hotelogix.automationframework.pages.admin.General.ListofCurrencies.EditAuditTrailPage;
import com.hms.hotelogix.automationframework.pages.admin.General.ListofCurrencies.EditCurrencyPage;
import com.hms.hotelogix.automationframework.pages.admin.General.ListofCurrencies.ListOfCurrencyAuditTrailPage;
import com.hms.hotelogix.automationframework.pages.admin.General.ListofCurrencies.ListofCurrenciesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.RoomsLandingPage;


public class ListOfCurrenciesTest {
	
	
	
	
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	private AdminHome AH;
	
	
	
	
@BeforeMethod()
public void Login() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
AdminLogin AL=GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser)), "http://hotelogix.stayezee.com/admine/");
// AL=GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, Constant.Col_Browser), "http://hotelogix.stayezee.com/admine/");
AH = AL.adminlogin("13135", "vj@stayzee.com", "deepak");// for http://hotelogix.stayezee.com/admine/
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
	
	

@Test(priority=1,description="To verify Navigation functionality to 'List of Acceptable Currencies' Page.", groups={"P0","ListOfCurrenciesTest"})
public void HMS8917() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
Thread.sleep(2000);
Assert.assertTrue(GenericClass.driver.getTitle().trim().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
Reporter.log("System successfully navigated to the 'List of Acceptable Currencies '' Page.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;
}

}



@Test(priority=2,description="To verify title of the page.", groups={"P0","ListOfCurrenciesTest"})
public void HMS1959() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	Thread.sleep(2000);
	Assert.assertTrue(GenericClass.getText(LOCLP.HeaderTxt_PageTitle).trim().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
	Reporter.log("System successfully showing 'List of Acceptable Currencies ' as a header Page title.", true);	
}

catch(Throwable e){
		GenericClass.getscreenshot(sTestCaseName);
		ExcelUtil.CloseAllExcelReferences(); 
		throw  e;
	}

}



@Test(priority=3,description=" To verify the presence of all the Links, buttons and fields on 'List of Acceptable Currencies' page.", groups={"P1","ListOfCurrenciesTest"})
public void HMS8918() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	LOCLP.fn_verifyPageElements(iTestCaseRow);
	Reporter.log("All the page Elements are verified", true);
	
	
}

catch(Throwable e){
		GenericClass.getscreenshot(sTestCaseName);
		ExcelUtil.CloseAllExcelReferences(); 
		throw  e;
	}

}



@Test(priority=4,description="To verify the functionality of 'Add Currencies' button.", groups={"P0","ListOfCurrenciesTest"})
public void HMS8182() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
Assert.assertTrue(GenericClass.getText(ACP.Txt_pageTitle).trim().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
Reporter.log("Page Title verified", true);
}
catch(Throwable e){
		GenericClass.getscreenshot(sTestCaseName);
		ExcelUtil.CloseAllExcelReferences(); 
		throw  e;
	}
}


@Test(priority=5,description="Verify the title of the page after clicking 'Add Currencies' button", groups={"P1","ListOfCurrenciesTest"})
public void HMS8919() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
	Assert.assertTrue(GenericClass.getText(ACP.Txt_pageTitle).trim().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
    Reporter.log("Page Header verified after landing to Select Acceptable Currencies Page.", true);	
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}

@Test(priority=6,description="Verifying all link, buttons and fields on the page.", groups={"P1","ListOfCurrenciesTest"})
public void HMS8920() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();	
	ACP.fn_verifyPageElements();
	Reporter.log("All the page elements verified of AddCurrency Page.", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences(); 
	throw  e;
}
}



@Test(priority=7,description="To verify Main on Select acceptable Currencies Page.", groups={"P1","ListOfCurrenciesTest"})
public void HMS1976() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
	AH=ACP.fn_ClickOnMainLink();
	Thread.sleep(2000);
	Assert.assertTrue(GenericClass.driver.getTitle().trim().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
    Reporter.log("Main link verified.", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences();
	throw e;
}
}








@Test(priority=8,description=" To verify the functionality of 'Currency List' link.", groups={"P1","ListOfCurrenciesTest"})
public void HMS8948() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
	LOCLP=ACP.fn_ClickOnListOfCurrenciesLink();
	Thread.sleep(2000);
	Assert.assertTrue(GenericClass.driver.getTitle().trim().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
	Reporter.log("List of currencies link of Add currencies verified.", true);
	
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences();
	throw e;
}
}



@Test(priority=9,description="To verify 'ADD CURRENCIES' by clicking 'Save' button.", groups={"P0","ListOfCurrenciesTest"})
public void HMS1960() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();	
	LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveAtTop);
	String curr=ACP.currencyToAdd;
	String actual=GenericClass.getText(LOCLP.Msg_CurrencyAdded).trim();
	String expected=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim();
   // Assert.assertEquals(actual, expected);
	//Assert.assertEquals(GenericClass.getText(LOCLP.Msg_CurrencyAdded).trim().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim()),true);
	Reporter.log("Currency Added.", true);
	LOCLP.fn_verifyAddedCurrency(ACP.currencyToAdd);
	Reporter.log("Currency Verified and activated.", true);
	DefaultSettingsLandingPage  DSLP=AH.fn_navigateToDefaultSettingPage();
	DSLP.fn_verifyAddedCurrency(ACP.currencyToAdd);
	RoomsLandingPage RLP=AH.fn_NavigateRooms();
	AddRoomsPage  ARP=RLP.ClickOnAddRoomLink();
	String rtype=ARP.fn_addRoomName(1);
	String tit=GenericClass.driver.getTitle();
	FrontdeskContinueTrialPage  FCTP=RLP.fn_clickOnFrontdeskLink();
    GenericClass.fn_SwitchToWindow_Title("Frontdesk");
	CashCounterPage CCP=FCTP.fn_ClickCountinueWithTrail_BT();
	FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
	FLP.fn_ClickCancelButton();
	FLP.fn_createFDReserv("3","3");
	GroupReservationPage GRP=FLP.FillQuickResvsForm(iTestCaseRow, FLP.Link_GroupRes);
	FLP=GRP.ClickOnReserve();
	FLP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FLP.getWebElement(FLP.resvId);
	Thread.sleep(2000);
	FLP.fn_rightClickOnReservation(ele);
	FLP.fn_clickCheckIn();
	Thread.sleep(2000);
	GenericClass.driver.navigate().refresh();
	Thread.sleep(2000);
	FLP.fn_AutoNightAudit1();
	Thread.sleep(2000);
	WebElement ele1=FLP.getWebElement(FLP.resvId);
	Thread.sleep(2000);
	FLP.fn_rightClickOnReservation(ele1);
	Thread.sleep(2000);
	GroupViewDetailPage  GVDP=FLP.fn_clickOnViewDetailPage();
	GroupEnableEditingPage GEEP=GVDP.fn_clickOnEnableEditingBtn();
	ArrayList<String> ids=GEEP.getGroupResIds();
	GEEP.fn_addGuestDetails(ids.get(0).toString(), GEEP.guestDetail);
	GEEP.fn_VerifyAddedCurrency(LOCLP.shortName);
	AccountStatementLandingPage  ASLP=GEEP.fn_clickOnGroupPayment();
	ASLP.fn_VerifyAddedCurrency(LOCLP.shortName);
	ASLP.fn_generateFolio();
	ReservationFolioPage RFP=ASLP.fn_ClickOnPI();
	RFP.fn_VerifyAddedCurrency(LOCLP.shortName);
	Reporter.log("Added currency verified at frontdesk reservation and account and in folios also.", true);
	GenericClass.switchToWindowHandle(tit);
	LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	LOCLP.fn_deleteCurrency(curr);
	Reporter.log("Currency Deleted.", true);
	}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences();
	throw e;
}
}





@Test(priority=10,description="To verify Audit trail in Select Acceptable Currencies Page.", groups={"P1","ListOfCurrenciesTest"})
public void HMS1977() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();	
	LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveAtTop);
	String curr=ACP.currencyToAdd;
	LOCLP.fn_verifyAddedCurrency(curr);
	String sname=LOCLP.shortName;
	ACP=LOCLP.fn_clickOnAddCurrency();	
	String cid=GenericClass.GetCurrentWindowID();
	AuditTrailPage ATP=ACP.fn_clickOnAuditTrail();
	GenericClass.windowHandle(cid);
	ATP.fn_VerifyChanges("Currency Name " + curr +" created by");
	ATP.fn_VerifyChanges("Currency Short Name " + sname + " created by");
	GenericClass.Switch_Parent_Window(cid);
	LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	LOCLP.fn_deleteCurrency(curr);
	Reporter.log("Currency Deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}


@Test(priority=11,description=" To verify 'ADD CURRENCIES' by clicking 'Save currency list' button.", groups={"P0","ListOfCurrenciesTest"})
public void HMS8997() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();	
	LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
	String curr=ACP.currencyToAdd;
	String actual=GenericClass.getText(LOCLP.Msg_CurrencyAdded).trim();
	String expected=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim();
    //Assert.assertEquals(actual, expected);
	//Assert.assertEquals(GenericClass.getText(LOCLP.Msg_CurrencyAdded).trim().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim()),true);
	Reporter.log("Currency Added.", true);
	LOCLP.fn_verifyAddedCurrency(ACP.currencyToAdd);
	Reporter.log("Currency Verified and activated.", true);
	DefaultSettingsLandingPage  DSLP=AH.fn_navigateToDefaultSettingPage();
	DSLP.fn_verifyAddedCurrency(ACP.currencyToAdd);
	RoomsLandingPage RLP=AH.fn_NavigateRooms();
	AddRoomsPage  ARP=RLP.ClickOnAddRoomLink();
	String rtype=ARP.fn_addRoomName(1);	
	String tit=GenericClass.driver.getTitle();
	FrontdeskContinueTrialPage  FCTP=RLP.fn_clickOnFrontdeskLink();
    GenericClass.fn_SwitchToWindow_Title("Frontdesk");
	CashCounterPage CCP=FCTP.fn_ClickCountinueWithTrail_BT();
	FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
	FLP.fn_ClickCancelButton();
	FLP.fn_createFDReserv(rtype, "3", "3");
	GroupReservationPage GRP=FLP.FillQuickResvsForm(iTestCaseRow, FLP.Link_GroupRes);
	FLP=GRP.ClickOnReserve();
	FLP.fn_verifyReservation();
	Thread.sleep(2000);
	WebElement ele=FLP.getWebElement(FLP.resvId);
	Thread.sleep(2000);
	FLP.fn_rightClickOnReservation(ele);
	FLP.fn_clickCheckIn();
	Thread.sleep(2000);
	GenericClass.driver.navigate().refresh();
	Thread.sleep(2000);
	FLP.fn_AutoNightAudit1();
	Thread.sleep(2000);
	WebElement ele1=FLP.getWebElement(FLP.resvId);
	Thread.sleep(2000);
	FLP.fn_rightClickOnReservation(ele1);
	Thread.sleep(2000);
	GroupViewDetailPage  GVDP=FLP.fn_clickOnViewDetailPage();
	GroupEnableEditingPage GEEP=GVDP.fn_clickOnEnableEditingBtn();
	ArrayList<String> ids=GEEP.getGroupResIds();
	GEEP.fn_addGuestDetails(ids.get(0).toString(), GEEP.guestDetail);
	GEEP.fn_VerifyAddedCurrency(LOCLP.shortName);
	AccountStatementLandingPage  ASLP=GEEP.fn_clickOnGroupPayment();
	ASLP.fn_VerifyAddedCurrency(LOCLP.shortName);
	ASLP.fn_generateFolio();
	ReservationFolioPage RFP=ASLP.fn_ClickOnPI();
	RFP.fn_VerifyAddedCurrency(LOCLP.shortName);
	Reporter.log("Added currency verified at frontdesk reservation and account and in folios also.", true);
	GenericClass.switchToWindowHandle(tit);
	LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	LOCLP.fn_deleteCurrency(curr);
	Reporter.log("Currency deleted.", true);
	
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences();
	throw e;
}
}




@Test(priority=12,description="To verify functionality of  Cancel button in right corner of the page.", groups={"P2","ListOfCurrenciesTest"})
public void HMS1961() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
	LOCLP=ACP.fn_clickOnCancelBtn(ACP.Btn_CancelAtTop);
	Assert.assertEquals(GenericClass.driver.getTitle().trim(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Cancel link at top verified on Add currency page.", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences();
	throw e;	
}
}




@Test(priority=13,description="To verify functionality of Cancel button in the bottom of the page.", groups={"P1","ListOfCurrenciesTest"})
public void HMS9262() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
	LOCLP=ACP.fn_clickOnCancelBtn(ACP.Btn_Cancel);
	Assert.assertEquals(GenericClass.driver.getTitle().trim(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Cancel link at bottom verified on Add currency page.", true);	
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}



@Test(priority=14,description="To verify Navigation functionality to 'List of Acceptable Currencies' Page.", groups={"P1","ListOfCurrenciesTest"})
public void HMS8922() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
ACP.fn_verifyMovefunctionOfCurrency();
Reporter.log("Move to left functionality '<<' verified", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences();
	throw e;
}
}


@Test(priority=15,description=" Verify the functionality of '<<' button on 'Select Acceptable Currencies' page", groups={"P1","ListOfCurrenciesTest"})
public void HMS8921() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
ACP.fn_verifyMovefunctionOfCurrency();
Reporter.log("Move to Right functionality '>>' verified", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences();
	throw e;
}	
}


@Test(priority=16,description="To verify alert pop up while deleting currencies.", groups={"P1","ListOfCurrenciesTest"})
public void HMS8201() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
Thread.sleep(3000);
String txt=LOCLP.fn_VerifyCurrencyDeletionPopUp();
Assert.assertEquals(txt.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim());
Reporter.log("Deletion pop up text verified.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences();
	throw e;	
}
}

@Test(priority=17,description="To Verify Cancel button on pop up while deleting currencies", groups={"P1","ListOfCurrenciesTest"})
public void HMS8923() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
Thread.sleep(3000);
String txt=LOCLP.fn_VerifyCurrencyDeletionPopUp();
LOCLP.fn_verifyAddedCurrency(LOCLP.currencyToDelete);
Reporter.log("Currency exist after cancelling the delete pop up.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}



@Test(priority=18,description="To verify Deletion of Currency from the list.", groups={"P1","ListOfCurrenciesTest"})
public void HMS1962() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
LOCLP.fn_deleteCurrency(ACP.currencyToAdd);

String msg=GenericClass.getText(LOCLP.Msg_deletionCurrency).trim();
String msg1=LOCLP.fn_vlidateDeletionMsg(ACP.currencyToAdd);
Assert.assertEquals(msg, msg1);
Reporter.log("Currency deletion succesfull", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}

@Test(priority=19,description="To verify the functionality of 'CANCEL' button on the page.", groups={"P2","ListOfCurrenciesTest"})
public void HMS1963() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AH=LOCLP.fn_clickOnCancel();
Assert.assertEquals(GenericClass.driver.getTitle().trim(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Administrator Console page verified after clicking on cancel link over List of currency page.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}

@Test(priority=20,description="To verify 'Main' link on 'List of Acceptable Currencies'", groups={"P1","ListOfCurrenciesTest"})
public void HMS1964() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AH=LOCLP.fn_clickOnMainLink();
Assert.assertEquals(GenericClass.driver.getTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Administrator console page title verified after clicking over main link on List of Currency page.",true);


}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}

@Test(priority=21,description="To verify Selection of all the Currencies by Master Checkbox.", groups={"P2","ListOfCurrenciesTest"})
public void HMS1965() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
boolean res=LOCLP.fn_verifyTheMasterCheckBox();
Assert.assertEquals(res, true);
Reporter.log("Master check box are working fine.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}



@Test(priority=22,description=" To deselect all the Currencies using Master Check box on page.", groups={"P2","ListOfCurrenciesTest"})
public void HMS8924() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
LOCLP.fn_verifyDeselectAllFromMasterCB();
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}



@Test(priority=23,description=" To verify selection of all currencies by checking all the currencies Individually.", groups={"P2","ListOfCurrenciesTest"})
public void HMS8925() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
	LOCLP.fn_verifySelectAllFromMasterCB();	
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}


@Test(priority=24,description="To Deselect all the currencies using checkbox respective of every currency",groups={"P2","ListOfCurrenciesTest"})
public void HMS8926() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
LOCLP.fn_selectRecordUsingCheckBoxAndVerifySelectedCheckBox();
Reporter.log("Individual check box verified.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority=25,description="To verify Sort by Currencies by clicking downward arrow", groups={"P2","ListOfCurrenciesTest"})
public void HMS1968() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
	GenericClass.sortingName_Downward(LOCLP.DD_View, "All", LOCLP.Link_DownwardArrowForCurrencies, LOCLP.CB_All, "//table[@class='list_viewnew']/tbody/tr/td[3]");
	Reporter.log("Downward functionality verified by currency name.", true);
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}




@Test(priority=26,description=" To verify Sorting by Currencies on clicking upward arrow", groups={"P2","ListOfCurrenciesTest"})
public void HMS8927() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
	GenericClass.sortingName_Upward(LOCLP.DD_View, "All", LOCLP.Link_UpwardArrowForCurrencies, LOCLP.CB_All, "//table[@class='list_viewnew']/tbody/tr/td[3]");
	Reporter.log("Upward functionality verified by currency name.", true);	
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}



@Test(priority=27,description="To verify Sorting by Abbreviation on clicking downward arrow.", groups={"P2","ListOfCurrenciesTest"})
public void HMS1969() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
	GenericClass.sortingName_Downward(LOCLP.DD_View, "All", LOCLP.Link_DownwardArrowForAbreviation, LOCLP.CB_All, "//table[@class='list_viewnew']/tbody/tr/td[4]");
	Reporter.log("Downward functionality verified by currency Abreviation.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}


@Test(priority=28,description="  To verify Sorting by Abbreviation on clicking upward arrow", groups={"P2","ListOfCurrenciesTest"})
public void HMS8928() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
	GenericClass.sortingName_Upward(LOCLP.DD_View, "All", LOCLP.Link_UpwardArrowForAbreviation, LOCLP.CB_All, "//table[@class='list_viewnew']/tbody/tr/td[4]");
	Reporter.log("Upward functionality verified by currency Abreviation.", true);		
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}



//Need to make function which can sort the special characters.
@Test(priority=29,description="To verify Sort by Symbol by clicking downward arrow", groups={"P2","ListOfCurrenciesTest"})
public void HMS1970() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
	GenericClass.sortingName_Downward(LOCLP.DD_View, "All", LOCLP.Link_DownwardArrowForSymbol, LOCLP.CB_All, "//table[@class='list_viewnew']/tbody/tr/td[5]");
	Reporter.log("Downward functionality verified by currency symbol.", true);	
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}

}



//Need to make function which can sort the special characters.
@Test(priority=30,description=" To verify Sorting by Symbol on clicking upward arrow", groups={"P2","ListOfCurrenciesTest"})
public void HMS8929() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
GenericClass.sortingName_Upward(LOCLP.DD_View, "All", LOCLP.Link_UpwardArrowForSymbol, LOCLP.CB_All, "//table[@class='list_viewnew']/tbody/tr/td[5]");
Reporter.log("Upward functionality verified by currency symbol.", true);		
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}



@Test(priority=31,description="To verify Sort by Status by clicking downward arrow", groups={"P2","ListOfCurrenciesTest"})
public void HMS1971() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
GenericClass.sortstatus_Downward(LOCLP.DD_View, "All", LOCLP.Img_ActiveStatus, LOCLP.Link_DownwardArrowForStatus, LOCLP.CB_All, "//table[@class='list_viewnew']/tbody/tr/td[3]", "//table[@class='list_viewnew']/tbody/tr/td[8]//img");
Reporter.log("Downward sort status Verified.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}

}



@Test(priority=32,description=" To verify Sort by Status by clicking upward arrow",groups={"P2","ListOfCurrenciesTest"})
public void HMS8930() throws Exception{
try{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
	ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
	GenericClass.sortstatus_Upward(LOCLP.DD_View, "All", LOCLP.Link_DownwardArrowForStatus, LOCLP.CB_All, "//table[@class='list_viewnew']/tbody/tr/td[3]", "//table[@class='list_viewnew']/tbody/tr/td[8]//img");	
}
catch(Throwable e){
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences();
	throw e;	
}
}


@Test(priority=33,description="To verify whether Currencies deactivate or not.", groups={"P1","ListOfCurrenciesTest"})
public void HMS1967() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage  ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
String curr=ACP.currencyToAdd;
LOCLP.fn_DeactivateTheCurrency(ACP.currencyToAdd);
LOCLP.fn_verifyDeactivatedCurrency(ACP.currencyToAdd);
DefaultSettingsLandingPage  DSLP=AH.fn_navigateToDefaultSettingPage();
DSLP.fn_verifyDeactivatedCurrency(ACP.currencyToAdd);
RoomsLandingPage RLP=AH.fn_NavigateRooms();
AddRoomsPage  ARP=RLP.ClickOnAddRoomLink();
String rtype=ARP.fn_addRoomName(1);
String tit=GenericClass.driver.getTitle();
FrontdeskContinueTrialPage  FCTP=RLP.fn_clickOnFrontdeskLink();
GenericClass.fn_SwitchToWindow_Title("Frontdesk");
CashCounterPage CCP=FCTP.fn_ClickCountinueWithTrail_BT();
FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
FLP.fn_ClickCancelButton();
FLP.fn_createFDReserv(rtype, "3", "3");
GroupReservationPage GRP=FLP.FillQuickResvsForm(iTestCaseRow, FLP.Link_GroupRes);
FLP=GRP.ClickOnReserve();
FLP.fn_verifyReservation();
Thread.sleep(2000);
WebElement ele=FLP.getWebElement(FLP.resvId);
Thread.sleep(2000);
FLP.fn_rightClickOnReservation(ele);
FLP.fn_clickCheckIn();
Thread.sleep(2000);
GenericClass.driver.navigate().refresh();
Thread.sleep(2000);
FLP.fn_AutoNightAudit1();
Thread.sleep(2000);
WebElement ele1=FLP.getWebElement(FLP.resvId);
Thread.sleep(2000);
FLP.fn_rightClickOnReservation(ele1);
Thread.sleep(2000);
GroupViewDetailPage  GVDP=FLP.fn_clickOnViewDetailPage();
GroupEnableEditingPage GEEP=GVDP.fn_clickOnEnableEditingBtn();
ArrayList<String> ids=GEEP.getGroupResIds();
GEEP.fn_addGuestDetails(ids.get(0).toString(), GEEP.guestDetail);
GEEP.fn_verifyDeactivatedCurrency(LOCLP.deactivatedCurrencyAbreviation);
AccountStatementLandingPage  ASLP=GEEP.fn_clickOnGroupPayment();
ASLP.fn_verifyDeactivatedCurrency(LOCLP.deactivatedCurrencyAbreviation);
ASLP.fn_generateFolio();
ReservationFolioPage RFP=ASLP.fn_ClickOnPI();
RFP.fn_verifyDeactivatedCurrency(LOCLP.deactivatedCurrencyAbreviation);
GenericClass.fn_SwitchToWindow_Title(tit);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(curr);
Reporter.log("Deactivated currency not found at any reflection points.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}

@Test(priority=34,description="To verify whether Currencies activate or not.", groups={"P1","ListOfCurrenciesTest"})
public void HMS1966() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
String currencyTodeactivate=ACP.currencyToAdd;
LOCLP.fn_DeactivateTheCurrency(currencyTodeactivate);
LOCLP.fn_activateTheCurrencyAndVerify(currencyTodeactivate);
DefaultSettingsLandingPage  DSLP=AH.fn_navigateToDefaultSettingPage();
DSLP.fn_verifyActivatedCurrency(currencyTodeactivate);
RoomsLandingPage RLP=AH.fn_NavigateRooms();
AddRoomsPage  ARP=RLP.ClickOnAddRoomLink();
String rtype=ARP.fn_addRoomName(1);
String tit=GenericClass.driver.getTitle();
FrontdeskContinueTrialPage  FCTP=RLP.fn_clickOnFrontdeskLink();
GenericClass.fn_SwitchToWindow_Title("Frontdesk");
CashCounterPage CCP=FCTP.fn_ClickCountinueWithTrail_BT();
FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
FLP.fn_ClickCancelButton();
FLP.fn_createFDReserv(rtype, "3", "3");
GroupReservationPage GRP=FLP.FillQuickResvsForm(iTestCaseRow, FLP.Link_GroupRes);
FLP=GRP.ClickOnReserve();
FLP.fn_verifyReservation();
Thread.sleep(2000);
WebElement ele=FLP.getWebElement(FLP.resvId);
Thread.sleep(2000);
FLP.fn_rightClickOnReservation(ele);
FLP.fn_clickCheckIn();
Thread.sleep(2000);
GenericClass.driver.navigate().refresh();
Thread.sleep(2000);
FLP.fn_AutoNightAudit1();
Thread.sleep(2000);
WebElement ele1=FLP.getWebElement(FLP.resvId);
Thread.sleep(2000);
FLP.fn_rightClickOnReservation(ele1);
Thread.sleep(2000);
GroupViewDetailPage  GVDP=FLP.fn_clickOnViewDetailPage();
GroupEnableEditingPage GEEP=GVDP.fn_clickOnEnableEditingBtn();
ArrayList<String> ids=GEEP.getGroupResIds();
GEEP.fn_addGuestDetails(ids.get(0).toString(), GEEP.guestDetail);
GEEP.fn_verifyActivatedCurrency(LOCLP.deactivatedCurrencyAbreviation);
AccountStatementLandingPage  ASLP=GEEP.fn_clickOnGroupPayment();
ASLP.fn_verifyActivatedCurrency(LOCLP.deactivatedCurrencyAbreviation);
ASLP.fn_generateFolio();
ReservationFolioPage RFP=ASLP.fn_ClickOnPI();
RFP.fn_verifyActivatedCurrency(LOCLP.deactivatedCurrencyAbreviation);
Reporter.log("Activated currency found at reflection points.", true);
GenericClass.switchToWindowHandle(tit);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(currencyTodeactivate);
Reporter.log("Currency deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}




@Test(priority=35,description=" To verify whether correct currency symbol display in 'Symbol' column or not for a currency.", groups={"P1","ListOfCurrenciesTest"})
public void HMS9012() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage  ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrencyToHotel(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyToAdd)));
Thread.sleep(2000);
EditCurrencyPage  ECP=LOCLP.fn_ClickOnEditLinkForCurrency(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyToAdd)));
LOCLP=ECP.fn_clickOnListOfCurrencyLink();
String symbol= LOCLP.fn_getCurrencySymbol(iTestCaseRow);
GenericClass.driver.navigate().to(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_URL)));
Assert.assertEquals(GenericClass.driver.getPageSource().contains(symbol), true);
Reporter.log("Currency symbol verified.", true);
LOCLP.fn_deleteCurrency(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyToAdd)));
Reporter.log("USD Deleted as well", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}





//As for this test case an issue is raised already for the enhancement of page title and here validation done by HTML title tag.
@Test(priority=36,description="To Verify whether user is able to navigate 'List of Acceptable Currencies' page for currency editing or not.", groups={"P1","ListOfCurrenciesTest"})
public void HMS8203() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage  ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
EditCurrencyPage  ECP=LOCLP.fn_ClickOnEditLinkForCurrency(ACP.currencyToAdd);
Assert.assertEquals(GenericClass.driver.getTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("As title verified.", true);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(ACP.currencyToAdd);
Reporter.log("Currency deleted", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}


@Test(priority=37,description="To Verify Conversion Rate column with 'Currency conversion rate' set as manual.", groups={"P1","ListOfCurrenciesTest"})
public void HMS8205() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

DefaultSettingsLandingPage  DSLP=AH.fn_navigateToDefaultSettingPage();
DSLP.fn_setConversionRate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ConversionRateMode)).trim());


ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage  ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
EditCurrencyPage  ECP=LOCLP.fn_clickOnEditforParticularCurrency(ACP.currencyToAdd);
ECP.fn_verifyPageElements();
Reporter.log("Edit page elements are verified.", true);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(ACP.currencyToAdd);
Reporter.log("Currency deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}




@Test(priority=38,description="Verify conversion rate of currency when 'Currency Conversion Rate' as Manual", groups={"P1","ListOfCurrenciesTest"})
public void HMS9263() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

DefaultSettingsLandingPage  DSLP=AH.fn_navigateToDefaultSettingPage();
DSLP.fn_setConversionMargin(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_MarginAmount)));
DSLP.fn_setConversionRate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ConversionRateMode)).trim());
ListofCurrenciesLandingPage LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage  ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrencyToHotel(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyToAdd)));
LOCLP.fn_verifyAddedCurrency(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyToAdd)));
String abr=LOCLP.shortName;
System.out.println(abr);
EditCurrencyPage  ECP=LOCLP.fn_clickOnEditforParticularCurrency(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyToAdd)));
LOCLP=ECP.fn_setConversionRate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ConversionRateToInput)));
RoomsLandingPage RLP=AH.fn_NavigateRooms();
AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
String rtype=ARP.fn_addRoomName(1);
String tit=GenericClass.driver.getTitle();
FrontdeskContinueTrialPage FCTP=RLP.fn_clickOnFrontdeskLink();
GenericClass.switchToWindowHandle("Frontdesk");
CashCounterPage CCP=FCTP.fn_ClickCountinueWithTrail_BT();
FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
FLP.fn_ClickCancelButton();
FLP.fn_createFDReserv(rtype, "3", "3");
GroupReservationPage GRP=FLP.FillQuickResvsForm(iTestCaseRow, FLP.Btn_Reserve);
FLP.fn_verifyReservation();
Thread.sleep(2000);
WebElement ele=FLP.getWebElement(FLP.resvId);
Thread.sleep(2000);
FLP.fn_rightClickOnReservation(ele);
FLP.fn_clickCheckIn();
Thread.sleep(2000);
WebElement ele1=FLP.getWebElement(FLP.resvId);
Thread.sleep(2000);
FLP.fn_rightClickOnReservation(ele1);
AccountStatementLandingPage  ASL=FLP.fn_clickOnPayment();
ASL.fn_postCustomCharge(iTestCaseRow);
Thread.sleep(2000);
GenericClass.clickElement(ASL.Btn_GenerateFolio);
Thread.sleep(2000);
ReservationFolioPage  RFP=ASL.fn_ClickOnPI();
String str=RFP.fn_getConvertedAmount(abr);
String amt=str.split("\\s")[0].toString();
Assert.assertEquals(amt, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("INR converted to USD", true);
GenericClass.switchToWindowHandle(tit);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyToAdd)));
Reporter.log("Successfull transaction conversion from INR to USD.", true);

}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}




@Test(priority=39,description=" To Verify Conversion Rate column with 'Currency conversion rate' set as Automatic.", groups={"P1","ListOfCurrenciesTest"})
public void HMS9001() throws Throwable{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

DefaultSettingsLandingPage  DSLP=AH.fn_navigateToDefaultSettingPage();
DSLP.fn_setConversionRate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ConversionRateMode)));
ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
EditCurrencyPage ECP=LOCLP.fn_clickOnEditforParticularCurrency(ACP.currencyToAdd);
ECP.fn_VerifyPageElementsWhenConversionReateIsAuto();
Reporter.log("Edit page elements verified when conversion rate is set to the automatic.", true);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(ACP.currencyToAdd);
Reporter.log("Curency deleted", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}


@Test(priority=40,description=" To verify Edit Currencies with manual 'currency conversion rate' setting.", groups={"P1","ListOfCurrenciesTest"})
public void HMS9005() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

DefaultSettingsLandingPage  DSLP=AH.fn_navigateToDefaultSettingPage();
DSLP.fn_setConversionRate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ConversionRateMode)));
ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
String currencyToEdit=ACP.currencyToAdd;
EditCurrencyPage ECP=LOCLP.fn_clickOnEditforParticularCurrency(currencyToEdit);
LOCLP=ECP.fn_EditTitleAndConversionRate(iTestCaseRow);
Assert.assertTrue(LOCLP.Msg_CurrencyAdded.getText().trim().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyTitleToEdit))));
Reporter.log("Currency Edited successfully", true);
LOCLP.fn_getEditedTitleAndConversionRate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyTitleToEdit)));
Assert.assertEquals(LOCLP.currency, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyTitleToEdit)));
Thread.sleep(2000);
Assert.assertEquals(LOCLP.conversionRate, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ConversionRateToInput)));
Reporter.log("Conversion Rate and Currency title verified after edit.", true);
DSLP=AH.fn_navigateToDefaultSettingPage();
DSLP.fn_verifyEditedCurrency(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyTitleToEdit)));
Reporter.log("Edited currency verified.", true);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyTitleToEdit)));
Reporter.log("Currency deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}


@Test(priority=41,description="To verify Edit Currencies with automatic 'currency conversion rate' setting.", groups={"P1","ListOfCurrenciesTest"})
public void HMS1972() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

DefaultSettingsLandingPage  DSLP=AH.fn_navigateToDefaultSettingPage();	
DSLP.fn_setConversionRate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ConversionRateMode)));
ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
String currencyToEdit=ACP.currencyToAdd;
EditCurrencyPage ECP=LOCLP.fn_clickOnEditforParticularCurrency(currencyToEdit);
LOCLP=ECP.fn_EditTitle(iTestCaseRow);
Assert.assertTrue(LOCLP.Msg_CurrencyAdded.getText().trim().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyTitleToEdit))));
Reporter.log("Currency Edited successfully", true);
LOCLP.fn_getEditedTitleAndConversionRate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyTitleToEdit)));
Assert.assertEquals(LOCLP.currency, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyTitleToEdit)));
Reporter.log("Conversion Rate and Currency title verified after edit.", true);
DSLP=AH.fn_navigateToDefaultSettingPage();
DSLP.fn_verifyEditedCurrency(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyTitleToEdit)));
Reporter.log("Edited currency verified.", true);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyTitleToEdit)));
Reporter.log("Currency deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}



@Test(priority=42,description="To verify Cancel of Editing Currencies", groups={"P1","ListOfCurrenciesTest"})
public void HMS1973() throws Throwable{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
String currencyToEdit=ACP.currencyToAdd;
EditCurrencyPage ECP=LOCLP.fn_clickOnEditforParticularCurrency(currencyToEdit);
GenericClass.sendKeys(ECP.TB_CurrencyTitle, "NewTitle");
GenericClass.clickElement(ECP.Btn_Cancel);
Thread.sleep(2000);
Assert.assertTrue(GenericClass.driver.getTitle().trim().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
Reporter.log("Title verified.", true);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(currencyToEdit);
Reporter.log("Currency deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}




@Test(priority=43,description="To verify Edit Currencies Without Currency Title", groups={"P1","ListOfCurrenciesTest"})
public void HMS1974() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
String currencyToEdit=ACP.currencyToAdd;
EditCurrencyPage ECP=LOCLP.fn_clickOnEditforParticularCurrency(currencyToEdit);	
ECP.TB_CurrencyTitle.clear();
GenericClass.clickElement(ECP.Btn_SaveCurrency);
GenericClass.ActionOnAlert("Accept");
Thread.sleep(2000);
Assert.assertEquals(GenericClass.value.trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Alert pop title verified,While saving currency without entering title.", true);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(currencyToEdit);
Reporter.log("Currency deleted.", true);

}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}

@Test(priority=44,description="To verify Main in List of Acceptable Currencies Page.", groups={"P1","ListOfCurrenciesTest"})
public void HMS1979() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
String currencyToEdit=ACP.currencyToAdd;
EditCurrencyPage ECP=LOCLP.fn_clickOnEditforParticularCurrency(currencyToEdit);
AH=ECP.fn_clickOnMainLink();
Assert.assertEquals(GenericClass.driver.getTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Admin home console page verified after clicking on main link on Edit currency page.", true);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(currencyToEdit);
Reporter.log("Currency deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}



@Test(priority=45,description="To verify List of acceptable Currencies in List of Acceptable Currencies Page.", groups={"P1","ListOfCurrenciesTest"})
public void HMS1978() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
String currencyToEdit=ACP.currencyToAdd;
EditCurrencyPage ECP=LOCLP.fn_clickOnEditforParticularCurrency(currencyToEdit);
LOCLP=ECP.fn_clickOnListOfCurrencyLink();
Thread.sleep(2000);
Assert.assertEquals(GenericClass.driver.getTitle().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("List of currency title verified after ckicking on list of currency link on Edit currency page.", true);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(currencyToEdit);
Reporter.log("Currency deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}



@Test(priority=46,description="To verify Audit Trail in List of Acceptable Currencies Page", groups={"P1","ListOfCurrenciesTest"})
public void HMS1980() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
String currencyToEdit=ACP.currencyToAdd;
LOCLP.fn_verifyAddedCurrency(currencyToEdit);
String abbreviation=LOCLP.shortName;
String conversionRate=LOCLP.conversionRate;
EditCurrencyPage ECP=LOCLP.fn_clickOnEditforParticularCurrency(currencyToEdit);
String a=GenericClass.GetCurrentWindowID();
EditAuditTrailPage EATP=ECP.fn_clickOnAuditTrailPage();
GenericClass.windowHandle(a);
EATP.fn_VerifyChanges("Currency Rate "+ conversionRate+" created by");
EATP.fn_VerifyChanges("Currency Short Name "+ abbreviation+" created by");
EATP.fn_VerifyChanges("Currency Name "+ currencyToEdit+" created by");
Reporter.log("Audit Trail verified for the Edit page.", true);
GenericClass.Switch_Parent_Window(a);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(currencyToEdit);
Reporter.log("Currency deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}

@Test(priority=47,description="To verify the functionality of Page dropdown at bottom left corner on List of Acceptable Currencies page", groups={"P1","ListOfCurrenciesTest"})
public void HMS1981() throws Throwable{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
LOCLP.fn_verifyPageDropdown();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");

LOCLP.fn_deleteCurrency(ACP.currencyToAdd);
Reporter.log("Currency deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}



@Test(priority=48,description="To verify 'View' records per page drop down on 'List of Acceptable Currencies' page", groups={"P1","ListOfCurrenciesTest"})
public void HMS1982() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
LOCLP.fn_verifyViewDropdown();
GenericClass.selectElement(LOCLP.DD_View, "All");
GenericClass.ActionOnAlert("Accept");
LOCLP.fn_deleteCurrency(ACP.currencyToAdd);
Reporter.log("Currency deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority=49,description="To check whether user is redirected to 'next'  page or not by clicking 'Next' link.", groups={"P1","ListOfCurrenciesTest"})
public void HMS1983() throws Throwable{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
LOCLP.fn_verifyNextLink();
Reporter.log("Next link verified.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}


@Test(priority=50,description="To check whether user is redirected to previous 'List of Acceptable Currencies' page or not by clicking 'Previous' link on page", groups={"P1","ListOfCurrenciesTest"})
public void HMS1984() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();
LOCLP.fn_verifyPreviousLink();
Reporter.log("Previous link verified.", true);
}
catch(Exception e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;	
}
}




@Test(priority=51,description="To verify Audit Trail", groups={"P1","ListOfCurrenciesTest"})
public void HMS1985() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_ListOfCurrencies,Constant.Sheet_ListOfCurrencies);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

ListofCurrenciesLandingPage  LOCLP=AH.fn_navigateToListOfCurrenciesPage();	
AddCurrencyPage ACP=LOCLP.fn_clickOnAddCurrency();
LOCLP=ACP.fn_addCurrency(ACP.Btn_SaveCurrencyList);
String currencyToEdit=ACP.currencyToAdd;
LOCLP.fn_verifyAddedCurrency(currencyToEdit);
String abbreviation=LOCLP.shortName;
String conversionRate=LOCLP.conversionRate;
String a=GenericClass.GetCurrentWindowID();
ListOfCurrencyAuditTrailPage  LOCATP=LOCLP.fn_clickOnAuditTrailPage();
GenericClass.windowHandle(a);
LOCATP.fn_VerifyChanges("Currency Rate "+ conversionRate+" created by");
LOCATP.fn_VerifyChanges("Currency Short Name "+ abbreviation+" created by");
LOCATP.fn_VerifyChanges("Currency Name "+ currencyToEdit+" created by");
Reporter.log("Audit Trail verified for the List of currency page.", true);
GenericClass.Switch_Parent_Window(a);
LOCLP=AH.fn_navigateToListOfCurrenciesPage();
LOCLP.fn_deleteCurrency(currencyToEdit);
Reporter.log("Currency deleted.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
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

}



	
	

}
