	package com.hms.hotelogix.automationframework.tests.admin.RoomsManager.RoomsTest;
	
	
	
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;
import org.apache.poi.ss.formula.functions.Roman;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.Housekeeping.HousekeepingLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.CashCounterPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.ConfirmLoginPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskLoginPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors.FloorsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions.PhoneExtensionsListPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddMultipleRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AuditTrailPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.EditRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.RoomsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.SortRooms.SortRoomsLandingPage;
import com.hms.hotelogix.automationframework.tests.admin.WebManager.WebSetting.Ireporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.jna.platform.win32.WinNT.GENERIC_MAPPING;
	
	
	public class RoomsTest {
	
	
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	private AdminLogin AL=new AdminLogin();
	private AdminHome AH=new AdminHome();
	public static ExtentTest test;
	

	
	
	
	
	@BeforeMethod
	public void Login(Method method) throws Throwable{
		try{
		ExcelUtil.CloseAllExcelReferences();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		//ExcelUtil.getCellData(iTestCaseRow, Constant.Col_Browser
	    AL=GenericClass.fn_OpenAdmin(("FF"), "http://hotelogix.net/admine/login/login");
	    AH = AL.adminlogin("13131","fdgdfg@stayezee.com","5ca949fe");
		}catch(Throwable e){
			e.printStackTrace();
			ExcelUtil.CloseAllExcelReferences();
		//	GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }

	
	@Test(priority=1,groups={"P0","RoomsTest"},description="Directed  to Rooms List pageTitle Page Verified")
	public void HMS5846() throws Throwable{
	try{
	//AL.adminlogin_12302();
	AH.fn_NavigateRooms();
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +Constant.File_Rooms,Constant.Sheet_Rooms);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex("ExpectedResult1")));
	Reporter.log("Directed  to Rooms List pageTitle Page Verified", true);
	ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e){
	ExcelUtil.CloseAllExcelReferences();
	 GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	throw e;
	}
	}

	//To verify title of Room List Landing Page.
    @Test(priority=2,groups={"P0","RoomsTest"},description="Page Title Header Verified")
	public void HMS1736() throws Throwable{
	try{
	//AL.adminlogin_12302();
	RoomsLandingPage RLP=AH.fn_NavigateRooms();
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +Constant.File_Rooms,Constant.Sheet_Rooms);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	Assert.assertEquals(GenericClass.getText(RLP.RoomListPage_Header).trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim());
	Reporter.log("Page Title Header Verified", true);
	ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e){
	ExcelUtil.CloseAllExcelReferences();
	//GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	throw e;
	}
	}
	

	//Verify elements on Rooms List Landing Page.
	@Test(priority=3,groups={"P0","RoomsTest"},description="All Elements are visible on the Rooms Landing page")
	public void HMS8818() throws Throwable{
	try{
	//AL.adminlogin_12302();
	RoomsLandingPage RLP=AH.fn_NavigateRooms();
	RLP.VerifyElement();
	ExcelUtil.CloseAllExcelReferences();
	Reporter.log("All Elements are visible on the Rooms Landing page", true);
	}catch(Throwable e){
	ExcelUtil.CloseAllExcelReferences();
	GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	throw e;
	}
	}
	
	
	//To verify 'Add a Room' button.
	@Test(priority=4,groups={"P0","RoomsTest"},description="Verify to navigate landed on Add/Edit a Room page.")
	public void HMS5847() throws Throwable{
	try{
	//AL.adminlogin_12302();
	Reporter.log("Login Success", true);
	RoomsLandingPage RLP=AH.fn_NavigateRooms();
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
	Assert.assertEquals(GenericClass.getText(ARP.Page_Header), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	ExcelUtil.CloseAllExcelReferences();
	Reporter.log("Verify to navigate landed on Add/Edit a Room page.", true);
	}catch(Throwable e){
	ExcelUtil.CloseAllExcelReferences();
	GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	throw e;
	}
	}
	
	
	//To verify elements on Add/Edit a Room page.
	@Test(priority=5,groups={"P0","RoomsTest"},description="To verify Elements on Add/Edit a Room page.")
	public void HMS5850() throws Throwable{
	try{
	//AL.adminlogin_12302();
	RoomsLandingPage RLP=AH.fn_NavigateRooms();
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
	Assert.assertEquals(GenericClass.getText(ARP.Enterddetail_Txt), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	ARP.VerifyPageElements();
	Reporter.log("All the page elements are avilable on Add Room Page", true);
	ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e){
	 GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	ExcelUtil.CloseAllExcelReferences();
	throw e;
	}
	}

	
	// To verify Add Rooms with valid data by clicking save button at the top.
	@Test(priority=6,groups={"P0","RoomsTest"}, description="Room Addeed to click save image button and Verified at reflections points.")
	public void HMS8954() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		String room=GenericClass.generateRandomString();
		ARP.AddingRoom(room, ARP.btn_SaveAtBtm);
		Assert.assertEquals(GenericClass.getText(RLP.Validation_Msg),RLP.ValidationFormat(room));
		SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
		SRL.VerifyRoom(room);
		ConfirmLoginPage CLP=SRL.fn_ClickOnFrontdesk();
		GenericClass.switchToWindowHandle("Frontdesk");
		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP1=CCP.fn_ClickContinueButton();
		FLP1.fn_ClickCancelButton();
		FLP1.VerifyRoomInFrontdesk(room);
		Reporter.log("Room Verified at frontdesk", true);
		HousekeepingLandingPage  HKL=FLP1.ClickOnHouseleepingLink();
		GenericClass.switchToWindowHandle("Housekeeping");
		HKL.VerifyRoom(room);
		Reporter.log("Room  Addeed and Verified at reflections points", true);
		ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
	}
	}
	
	
	//To verify Add Rooms with valid data By clicking at the end of data.
	@Test(priority=7,groups={"P0","RoomsTest"}, description="Rooms added to click bottom save button and validate at reflections points")
	public void HMS1737() throws Throwable{
		try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
	    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
	    String room=GenericClass.generateRandomString();
	    RLP=ARP.AddingRoom(room,ARP.btn_SaveAtBtm);
	    Assert.assertEquals(GenericClass.getText(RLP.Validation_Msg), RLP.ValidationFormat(room));
		Reporter.log("Rooms added validation msg showing", true);
		SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
		SRL.VerifyRoom(room);
		ConfirmLoginPage CLP=SRL.fn_ClickOnFrontdesk();
		GenericClass.switchToWindowHandle("Frontdesk");
		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP1=CCP.fn_ClickContinueButton();
		FLP1.fn_ClickCancelButton();
		FLP1.VerifyRoomInFrontdesk(room);
		Reporter.log("Room Verified at frontdesk", true);
		Thread.sleep(3000);	
		HousekeepingLandingPage  HKL=FLP1.ClickOnHouseleepingLink();
		GenericClass.switchToWindowHandle("Housekeeping");
		HKL.VerifyRoom(room);
		Reporter.log("Rooms added to click bottom save button and validate at reflections points", true);
		ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
	}
	}
	
	//To Add Rooms without entering data.
	@Test(priority=8,groups={"P1","RoomsTest"}, description="Rooms added without any data..and all the valdation message verified")
	public void HMS1738() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
	    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		GenericClass.clickElement(ARP.btn_SaveAtTop);
		ArrayList<String> emsg=ARP.GetValidationMsg();
		Assert.assertEquals(emsg.get(0).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Assert.assertEquals(emsg.get(1).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		Assert.assertEquals(emsg.get(2).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		Reporter.log("Rooms added without any data..and all the valdation message verified", true);
		ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
	}
	}


	//To verify Add Rooms with duplicate data.
	@Test(priority=9,groups={"P1","RoomsTest"}, description="Add room with duplicate data and - Duplicate Room Name/Number. Text Verified")
	public void HMS1741() throws Throwable{
		try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
	    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	    ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
	    String room=GenericClass.generateRandomString();
		RLP=ARP.AddingRoom(room,ARP.btn_SaveAtBtm);
		ARP=RLP.ClickOnAddRoomLink();
		ARP.AddingDuplicateRoom(room, ARP.btn_SaveAtBtm);
		Reporter.log("Room along with duplicate data", true);
		ArrayList<String> emsg=ARP.GetValidationMsgg();
		Assert.assertEquals(emsg.get(0).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log("Following ERRORS occurred during submission! Text Verified", true);
		Thread.sleep(2000);
		Assert.assertEquals(emsg.get(1).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		Reporter.log("Add room with duplicate data and - Duplicate Room Name/Number. Text Verified", true);
		ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
	
	}
	}
	
	
	//Enter Room Name/Number only and Save.
	@Test(priority=10,groups={"P1","RoomsTest"}, description="To verify Enter Room Name/Number only and Save. The - Please Select Room Type. Text Verified")
	public void HMS8819() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		String room=GenericClass.generateRandomString();
		ARP.AddingRoomsByEnteringRoomNameOnly(room,ARP.btn_SaveAtTop);
		ArrayList<String> emsg=ARP.GetValidationMsgg();
		Assert.assertEquals(emsg.get(0).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log(" 	Following ERRORS occurred during submission! Text Verified", true);
		Thread.sleep(2000);
		Assert.assertEquals(emsg.get(1).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		Reporter.log(" 	- Please Select Room Type. Text Verified", true);
		ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
	}
	}
	
	
	
	//Select Room Type only and Save
	@Test(priority=11,groups={"P1","RoomsTest"}, description="Select Room Type only and Save. - Please Enter Room Name / Number Text Verified")
	public void HMS8820() throws Throwable{
		try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
	
		ARP.AddingRoomBySelectingRoomrTypeOnly(ARP.btn_SaveAtTop);
		ArrayList<String> emsg=ARP.GetValidationMsgg();
		Assert.assertEquals(emsg.get(0).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log(" 	Following ERRORS occurred during submission! Text Verified", true);
		Thread.sleep(2000);
		Assert.assertEquals(emsg.get(1).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		Reporter.log(" - Please Enter Room Name / Number. Text Verified", true);
		ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	}
	

	//To verify Save and duplicate room button without entering data.
	@Test(priority=12,groups={"P1","RoomsTest"}, description="To verify Save and duplicate room button without entering data. - Please Enter Room Name / Number. Text Verified")
	public void HMS1744() throws Throwable{
		try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
	
		GenericClass.clickElement(ARP.btn_SaveDuplicateRoomAtBtm);
		ArrayList<String> emsg=ARP.GetValidationMsgg();
		Assert.assertEquals(emsg.get(0).toString(), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log("Following ERRORS occurred during submission! Text Verified", true);
		Thread.sleep(2000);
		Assert.assertEquals(emsg.get(1).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		Reporter.log(" - Please Enter Room Name / Number. Text Verified", true);
		ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	 //To verify Save and duplicate room button with duplicate data.
	@Test(priority=13,groups={"P1","RoomsTest"}, description="To verify Save and duplicate room button with duplicate data. - Duplicate Room Name/Number. Text Verified")
	public void HMS1743() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		String room=GenericClass.generateRandomString();
		ARP.AddingRoom(room, ARP.btn_SaveAtTop);
		Reporter.log("Existing rooms adding ", true);
		RLP.ClickOnAddRoomLink();
		ARP.AddingDuplicateRoom(room,ARP.btn_SaveDuplicateRoomAtBtm);
		ArrayList<String> emsg=ARP.GetValidationMsgg();
		Assert.assertEquals(emsg.get(0).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log(" 	Following ERRORS occurred during submission! Text Verified", true);
		Thread.sleep(2000);
		Assert.assertEquals(emsg.get(1).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		Reporter.log("- Duplicate Room Name/Number. Text Verified", true);
		ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	   }
	

	
	// Add Rooms with Save and duplicate room button at top right corner of the page.
	@Test(priority=14,groups={"P0","RoomsTest"}, description="Add Rooms with Save and duplicate room button at top right corner of the page.")
	public void HMS8955() throws Throwable{
		try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		String title=GenericClass.driver.getTitle();
	    String room=GenericClass.generateRandomString();
		ARP.AddingRoom(room, ARP.btn_SaveAndDuplicateRoomAtTop);
		Reporter.log("ROOM ADDED", true);
		Assert.assertEquals(GenericClass.getText(ARP.Validation_Msg).trim(),ARP.GetValidationMsgFormat(room));
		String title1=GenericClass.driver.getTitle();
		Reporter.log(title1 + "TITLE AFTER ADDING ROOM ", true);
		Assert.assertEquals(title, title1);
		Reporter.log("TITLE ARE SAME", true);
		String Selrtype=GenericClass.GetSelectedValueFromDropdown(ARP.drpdown_RoomType );
		Reporter.log(Selrtype + " SELECTED ROOM TYPWE VALUE", true);
		Assert.assertEquals(ARP.rtype, Selrtype);
		Reporter.log("EARLIER SELECTED ROOM VALUE IS SELECTED THERE IN ROOM TYPE DROPDOWN ", true);
		RLP=ARP.ClickOnRoomListLink();
		Reporter.log("CLICKED OVER ROOM LIST LINK IN ADD ROOM PAGE ", true);
		RLP.VerifyAddedRoom(room);
	    Reporter.log("ROOM VERIFIED IN ROOM LANDING PAGE AND ACTIVATED",true);
	    SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
	    Reporter.log("NAVIGATION SUCCESS TO SORT ROOMS",true);
		SRL.VerifyRoom(room);
	    Reporter.log("ROOM VERIFIED IN SORT ROOMS MODULE",true);
	    PhoneExtensionsListPage PEL=AH.fn_NavigateToPhoneExtPage();
	    Reporter.log("NAVIGATED TO PHONE EXTENSIONS MODULE",true);
	    PEL.VerifyAddedRoom(room);
	    Reporter.log("ADDED ROOM VERIFIED IN PHONE EXTENSION MODULE",true);
	    ConfirmLoginPage CLP= PEL.fn_ClickandNavigateOnFrontDesk();
	    GenericClass.switchToWindowHandle("Frontdesk");
		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
		Reporter.log("CLICKED OVER CONTINUE TRAIL BUTTON",true);
		FrontdeskLandingPage FLP1=CCP.fn_ClickContinueButton();
		Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
		FLP1.fn_ClickCancelButton();
	    Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
		FLP1.VerifyRoomInFrontdesk(room);
		Reporter.log("ADDED ROOM VERIFIED ON FRONTDESK",true);
		HousekeepingLandingPage  HKL=FLP1.ClickOnHouseleepingLink();
		Reporter.log("NAVIGATED TO HOUSEKEEPING CONSOLE",true);
		GenericClass.switchToWindowHandle("Housekeeping");
		HKL.VerifyRoom(room);
		Reporter.log("ROOM VERIFIED IN HOUSEKEEPING",true);
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	  }
	
	
	
	
	//Add Rooms with Save and duplicate room button at the end of the page.
	@Test(priority=15,groups={"P0","RoomsTest"}, description="Add Rooms with Save and duplicate room button at the end of the page.")
	public void HMS1742() throws Throwable{
		try{
		//AL.adminlogin_12302();
		Reporter.log("Login Success", true);
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		Reporter.log("Landed to Rooms List Page", true);
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		Reporter.log("Got Current method name for handling test data", true);
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +Constant.File_Rooms,Constant.Sheet_Rooms);
		Reporter.log("Path to test data file and sheet name passed", true);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		Reporter.log("Test Case identified in the excel file for test data", true);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		Reporter.log("CLICKED OVER ADD ROOM LINK", true);
		ARP.fn_VerifyFloorAndBlocks();
		String title=GenericClass.driver.getTitle();
		Reporter.log(title + "TITLE BEFORE ADDING ROOM ", true);
		String room=GenericClass.generateRandomString();
		ARP.AddingRoom(room, ARP.btn_SaveDuplicateRoomAtBtm);
		Reporter.log("ROOM ADDED", true);
		Assert.assertEquals(GenericClass.getText(ARP.Validation_Msg).trim(),ARP.GetValidationMsgFormat(room));
		String title1=GenericClass.driver.getTitle();
		Reporter.log(title1 + "TITLE AFTER ADDING ROOM ", true);
		Assert.assertEquals(title, title1);
		Reporter.log("TITLE ARE SAME", true);
		String Selrtype=GenericClass.GetSelectedValueFromDropdown(ARP.drpdown_RoomType );
		Reporter.log(Selrtype + " SELECTED ROOM TYPWE VALUE", true);
		Assert.assertEquals(ARP.rtype, Selrtype);
		Reporter.log("EARLIER SELECTED ROOM VALUE IS SELECTED THERE IN ROOM TYPE DROPDOWN ", true);
		RLP=ARP.ClickOnRoomListLink();
		Reporter.log("CLICKED OVER ROOM LIST LINK IN ADD ROOM PAGE ", true);
		RLP.VerifyAddedRoom(room);
	    Reporter.log("ROOM VERIFIED IN ROOM LANDING PAGE AND ACTIVATED",true);
	    SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
	    Reporter.log("NAVIGATION SUCCESS TO SORT ROOMS",true);
		SRL.VerifyRoom(room);
	    Reporter.log("ROOM VERIFIED IN SORT ROOMS MODULE",true);
	    PhoneExtensionsListPage PEL=AH.fn_NavigateToPhoneExtPage();
	    Reporter.log("NAVIGATED TO PHONE EXTENSIONS MODULE",true);
	    PEL.fn_CheckPhoneExtention();
	    PEL.VerifyAddedRoom(room);
	    Reporter.log("ADDED ROOM VERIFIED IN PHONE EXTENSION MODULE",true);
	    ConfirmLoginPage CLP= PEL.fn_ClickandNavigateOnFrontDesk();
	    GenericClass.switchToWindowHandle("Frontdesk");
		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
		Reporter.log("CLICKED OVER CONTINUE TRAIL BUTTON",true);
		FrontdeskLandingPage FLP1=CCP.fn_ClickContinueButton();
		Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
		FLP1.fn_ClickCancelButton();
	    Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
		FLP1.VerifyRoomInFrontdesk(room);
		Reporter.log("ADDED ROOM VERIFIED ON FRONTDESK",true);
		HousekeepingLandingPage  HKL=FLP1.ClickOnHouseleepingLink();
		Reporter.log("NAVIGATED TO HOUSEKEEPING CONSOLE",true);
		GenericClass.switchToWindowHandle("Housekeeping");
		HKL.VerifyRoom(room);
		Reporter.log("ROOM VERIFIED IN HOUSEKEEPING",true);
		Reporter.log("Room Added by Save and  Duplicate button and verified at Reflections point",true);
		ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	//Enter Room Name/Number only and Save and Duplicate Room.
	@Test(priority=16,groups={"P1","RoomsTest"}, description="Enter Room Name/Number only and Save and Duplicate Room. - Please Select Room Type. Text Verified")
	public void HMS8821() throws Throwable{
	try{
	     //AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		String room=GenericClass.generateRandomString();
		ARP.AddingRoomsByEnteringRoomNameOnly(room,ARP.btn_SaveAndDuplicateRoomAtTop);
		ArrayList<String> emsg=ARP.GetValidationMsgg();
		Assert.assertEquals(emsg.get(0).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log("Following ERRORS occurred during submission! Text Verified", true);
		Thread.sleep(2000);
		Assert.assertEquals(emsg.get(1).toString(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		Reporter.log("- Please Select Room Type. Text Verified", true);
		ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e){
	 ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	  throw e;
		}
	}
	
	
	@Test(priority=17,groups={"P1","RoomsTest"}, description="Select Room Type only and Save and Duplicate Room.  Following ERRORS occurred during submission! Please Enter Room Name / Number Text verified.")
	public void HMS8822() throws Throwable{
	try{
	//AL.adminlogin_12302();
	RoomsLandingPage RLP=AH.fn_NavigateRooms();
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
	Reporter.log("CLICKED OVER ADD ROOM LINK", true);
	ARP.AddingRoomBySelectingRoomrTypeOnly(ARP.btn_SaveAndDuplicateRoomAtTop);
	Reporter.log("ADDING ROOM BY SELECTING ROOM TYPE ONLY", true);
	ArrayList<String> emsg=ARP.GetValidationMsgg();
	Reporter.log("GETTING VALIDATION MESSAGE", true);
	Assert.assertEquals(emsg.get(0).toString(), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log(" 	Following ERRORS occurred during submission! Text Verified", true);
	Thread.sleep(2000);
	Assert.assertEquals(emsg.get(1).toString(), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	Reporter.log("- Please Enter Room Name / Number.  validation Text Verified", true);
	ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
		}
		}
	
	
	
	@Test(priority=18,groups={"P0","RoomsTest"}, description="To verify Save and Duplicate Room button.")
	public void HMS5868() throws Throwable{
		try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		String str=GenericClass.generateRandomString();
		ARP.fn_VerifyFloorAndBlocks();
		ARP.AddRoomBySaveAndDuplicateButton(str,ARP.btn_SaveAndDuplicateRoomAtTop);
     	String str1=GenericClass.generateRandomString();
		RLP=ARP.Add_Room(str1,ARP.btn_SaveAtTop);
		Reporter.log("ROOM ADDED USING SAVE BUTTON", true);
		String actual=RLP.ValidationFormat(str1);
		Assert.assertEquals(GenericClass.getText(RLP.Validation_Msg),actual);
		Reporter.log("VALIDATION FOR ADDED ROOM IS DISPLAYING", true);
		RLP.VerifyAddedRoom(str1);
		Reporter.log(" Room added and ROOM VERIFIED ON ROOMS LANDING PAGE AND IS ACTIVE", true);
		ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	@Test(priority=19,groups={"P2","RoomsTest"}, description="To Verify Cancel button at the top right corner in Add/Edit a Room page.")
	public void HMS1747() throws Throwable{
		try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		String room=GenericClass.generateRandomString();
		ARP.ClickOnCancel_AfterFilling_RoomDetail(room, ARP.btn_CancelAtTop);
		Thread.sleep(2000);
		Assert.assertEquals(GenericClass.driver.getTitle(),   ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log("We are on Add Room Page after filling the form and cancelling it by cancel button at top", true);
		ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }

	
	
	@Test(priority=20,groups={"P2","RoomsTest"}, description="To Verify 'Cancel' button at the end on Add/Edit a Room page.")
	public void HMS8956() throws Throwable{
		try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		Reporter.log("CLICKED OVER ADD ROOM LINK", true);
		String room=GenericClass.generateRandomString();
		ARP.ClickOnCancel_AfterFilling_RoomDetail(room, ARP.btn_CancelAtBtm);
		Reporter.log("ROOM DETAIL FILLED AND CANCEL BUTTON PREESED", true);
		Thread.sleep(2000);
		Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log("We are on Add Room Page after filling the form and cancelling it by cancel buttonb at top", true);
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	}
	
	
	@Test(priority=21,groups={"P0","RoomsTest"}, description="ADMINISTRATOR CONSOLE PAGE DISPLAYING AFTER CLICKING ON MAIN LINK")
	public void HMS1749() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			ARP.ClickOnMainLink();
			Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("ADMINISTRATOR CONSOLE PAGE DISPLAYING AFTER CLICKING ON MAIN LINK", true);
			ExcelUtil.CloseAllExcelReferences();
			}catch(Throwable e){
				ExcelUtil.CloseAllExcelReferences();
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
	        }
	
	
	
	@Test(priority=22,groups={"P0","RoomsTest"}, description="ROOM LIST LANDING  PAGE DISPLAYING AFTER CLICKING ON ROOM LIST LINK")
	public void HMS1748() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			ARP.ClickOnRoomListLink();
			Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("ROOM LIST LANDING  PAGE DISPLAYING AFTER CLICKING ON ROOM LIST LINK", true);
			ExcelUtil.CloseAllExcelReferences();
			}catch(Throwable e){
				ExcelUtil.CloseAllExcelReferences();
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
	        }
	
	
	@Test(priority=23,groups={"P0","RoomsTest"}, description="Click on Audit Trail link and to verify landing on AuditTrail page.")
	public void HMS5871() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			String room=GenericClass.generateRandomString();
			ARP.AddingRoom(room,ARP.btn_SaveAtTop);
			Reporter.log("ROOM ADDED ", true);
		    ARP=RLP.ClickOnAddRoomLink();
			Reporter.log("ROOM HISTORY CHECKING IN AUDIT TRAIL", true);
			String a=GenericClass.GetCurrentWindowID();
			AuditTrailPage ATP= ARP.ClickOnAuditTrailPage();
			GenericClass.windowHandle(a);
			ATP.VerifyAuditTrail(room);
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("AUDIT TRAIL verified", true);
		}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		  GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
	}
	}
	
	@Test(priority=24,groups={"P0","RoomsTest"}, description="Click on 'ADD MULTIPLE ROOM(S)' button and To verify landing on 'Add Multiple Rooms' page.")
	public void HMS5873() throws Throwable{
	
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
		    Assert.assertEquals(AMR.getPageHeader(), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		    Reporter.log("ADD MULTIPLE ROOM PAGE VERIFIED", true);
		    ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
			}
			}
	
	
	// Verify display of Add Multiple Rooms page.
	@Test(priority=25,groups={"P0","RoomsTest"}, description="To verify all elements in Add multiple Rooms page.")
	public void HMS5874() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
		Assert.assertEquals(GenericClass.getText(AMR.Txt_FillDetail), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		AMR.VerifyPageElements();
		ExcelUtil.CloseAllExcelReferences();
		Reporter.log("Add multiple rooms Page elements verified ", true);
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	//To verify 'Main' in Add Multiple Rooms.
	@Test(priority=26,groups={"P0","RoomsTest"}, description=" ADMIN HOME PAGE TITLE VERIFIED AFTER CLICKING ON MAIN LINK IN 'ADD MULTIPLE ROOMS PAGE'.")
	public void HMS1767() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
		    AMR.ClickOnMainLink();
			Assert.assertEquals(GenericClass.getText(AH.AdminHome_title),ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log(" ADMIN HOME PAGE TITLE VERIFIED AFTER CLICKING ON MAIN LINK.", true);
			ExcelUtil.CloseAllExcelReferences();
				}catch(Throwable e){
				ExcelUtil.CloseAllExcelReferences();
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
	        }
	

	
	//To verify 'Rooms List' in Add Multiple Rooms page.
	@Test(priority=27,groups={"P0","RoomsTest"}, description="ROOM LIST TITLE PAGE  VERIFIED AFTER CLICKING ON ROOM LIST LINK IN ADD MULTIPLE ROOMS PAGE.")
	public void HMS1766() throws Throwable{
		try{
		    //AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
		    AMR.ClickOnRoomListLink();
			Assert.assertEquals(GenericClass.driver.getTitle(),ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("ROOM LIST TITLE PAGE  VERIFIED AFTER CLICKING ON ROOM LIST LINK", true);
			ExcelUtil.CloseAllExcelReferences();
				}catch(Throwable e){
				ExcelUtil.CloseAllExcelReferences();
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
	        }
	

	
	//To verify Add Multiple rooms with room names and save with button at the top right corner of the page.
	@Test(priority=28,groups={"P0","RoomsTest"}, description="Multiple rooms added by clicking on save button at top on Add multiple room page. and verified at Multiple source where it gets reflect.")
	public void HMS1750() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
			String room1=GenericClass.generateRandomString();
			String room2=GenericClass.generateRandomString();
			String multiroom=room1+","+room2;
			AMR.AddingMultipleRoomsByName(multiroom,AMR.Btn_SaveAtTop);
			Reporter.log("MULTIPLE ROOMS ADDED", true);
		    Assert.assertEquals(GenericClass.getText(RLP.Validation_Msg),ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("VALIDATION MESSAGE VERIFIED", true);
			RLP.VerifyAddedRoom(room1);
			Reporter.log("1ST ROOM VERIFIED", true);
			RLP.VerifyAddedRoom(room2);
			Reporter.log("2ND ROOM VERIFIED", true);
			SortRoomsLandingPage  SRL=AH.fn_navigateToSortRooms();
	        SRL.VerifyRoom(room1);
	        Reporter.log("1ST ROOM VERIFIED IN SORT ROOMS", true);
	        SRL.VerifyRoom(room2);
	        Reporter.log("2ND ROOM VERIFIED IN SORT ROOMS", true);
	        PhoneExtensionsListPage PEL= AH.fn_NavigateToPhoneExtPage();
	        PEL.VerifyAddedRoom(room1);
	        Reporter.log("1ST ROOM VERIFIED IN PHONE EXTENSION MODULE", true);
	        PEL.VerifyAddedRoom(room2);
		    Reporter.log("ADDED ROOM VERIFIED IN PHONE EXTENSION MODULE",true);
		    ConfirmLoginPage CLP= PEL.fn_ClickandNavigateOnFrontDesk();
		    GenericClass.switchToWindowHandle("Frontdesk");
			CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
			Reporter.log("CLICKED OVER CONTINUE TRAIL BUTTON",true);
			FrontdeskLandingPage FLP1=CCP.fn_ClickContinueButton();
			Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
			FLP1.fn_ClickCancelButton();
		    Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
			FLP1.VerifyRoomInFrontdesk(room1);
			Reporter.log("1ST ROOM VERIFIED ON FRONTDESK",true);
			FLP1.VerifyRoomInFrontdesk(room2);
			Reporter.log("2ND ROOM VERIFIED ON FRONTDESK",true);
			HousekeepingLandingPage  HKL=FLP1.ClickOnHouseleepingLink();
			Reporter.log("NAVIGATED TO HOUSEKEEPING CONSOLE",true);
		    GenericClass.switchToWindowHandle("Housekeeping");
	    	HKL.VerifyRoom(room1);
	        Reporter.log("1st ROOM VERIFIED IN HOUSE KEEPING MODULE", true);
	        HKL.VerifyRoom(room2);
	    	Reporter.log("2ND ROOM VERIFIED IN HOUSE KEEPING MODULE", true);
	    	ExcelUtil.CloseAllExcelReferences();
	 		Reporter.log("multiple rooms added by clicking on save button at top on Add multiple room page. and verified at Multiple source where it gets reflect.", true);
			}catch(Throwable e){
				ExcelUtil.CloseAllExcelReferences();
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
	        }
	
	
	//  To verify Add Multiple rooms with room names and save with button at the end of the page.
	@Test(priority=29,groups={"P0","RoomsTest"}, description="Multiple rooms added by clicking on save button at bottom on Add multiple room page. and verified at Multiple source where it gets reflect.")
	public void HMS8957() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
			String room1=GenericClass.generateRandomString();
			String room2=GenericClass.generateRandomString();
			String multiroom=room1+","+room2;
			AMR.AddingMultipleRoomsByName(multiroom,AMR.Btn_SaveAtBtm);
			Reporter.log("MULTIPLE ROOMS ADDED", true);
		    Assert.assertEquals(GenericClass.getText(RLP.Validation_Msg),ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("VALIDATION MESSAGE VERIFIED", true);
			RLP.VerifyAddedRoom(room1);
			Reporter.log("1ST ROOM VERIFIED", true);
			RLP.VerifyAddedRoom(room2);
			Reporter.log("2ND ROOM VERIFIED", true);
			SortRoomsLandingPage  SRL=AH.fn_navigateToSortRooms();
	        SRL.VerifyRoom(room1);
	        Reporter.log("1ST ROOM VERIFIED IN SORT ROOMS", true);
	        SRL.VerifyRoom(room2);
	        Reporter.log("2ND ROOM VERIFIED IN SORT ROOMS", true);
	        PhoneExtensionsListPage PEL= AH.fn_NavigateToPhoneExtPage();
	        PEL.VerifyAddedRoom(room1);
	        Reporter.log("1ST ROOM VERIFIED IN PHONE EXTENSION MODULE", true);
	        PEL.VerifyAddedRoom(room2);
		    Reporter.log("ADDED ROOM VERIFIED IN PHONE EXTENSION MODULE",true);
		    ConfirmLoginPage CLP=PEL.fn_ClickandNavigateOnFrontDesk();
		    GenericClass.switchToWindowHandle("Frontdesk");
			CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
			Reporter.log("CLICKED OVER CONTINUE TRAIL BUTTON",true);
			FrontdeskLandingPage FLP1=CCP.fn_ClickContinueButton();
			Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
			FLP1.fn_ClickCancelButton();
		    Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
			FLP1.VerifyRoomInFrontdesk(room1);
			Reporter.log("1ST ROOM VERIFIED ON FRONTDESK",true);
			FLP1.VerifyRoomInFrontdesk(room2);
			Reporter.log("2ND ROOM VERIFIED ON FRONTDESK",true);
			HousekeepingLandingPage  HKL=FLP1.ClickOnHouseleepingLink();
			Reporter.log("NAVIGATED TO HOUSEKEEPING CONSOLE",true);
		    GenericClass.switchToWindowHandle("Housekeeping");
	    	HKL.VerifyRoom(room1);
	        Reporter.log("1st ROOM VERIFIED IN HOUSE KEEPING MODULE", true);
	        HKL.VerifyRoom(room2);
	    	Reporter.log("2nd ROOM VERIFIED IN HOUSE KEEPING MODULE", true);
	    	ExcelUtil.CloseAllExcelReferences();
	    	Reporter.log("multiple rooms added by clicking on save button at bottom on Add multiple room page. and verified at Multiple source where it gets reflect.", true);
	    } catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
		}
		}
		
	
	
	//To verify Add Multiple rooms with room numbers.
	@Test(priority=30,groups={"P0","RoomsTest"}, description="Multiple rooms added  by  range format along with prefix format. clicking on save button at bottom on Add multiple room page. and verified at Multiple source where it gets reflect.")
	public void HMS1752() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			String room1=GenericClass.GenerateRandomNumber(2);
			Integer val=Integer.parseInt(room1)+1;
			String room2=val.toString();
			
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
			AMR.AddingMultipleRoomsByNumber(room1,room2,AMR.Btn_SaveAtBtm);
			Reporter.log("MULTIPLE ROOMS ADDED", true);
		    Assert.assertEquals(GenericClass.getText(RLP.Validation_Msg),ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("VALIDATION MESSAGE VERIFIED", true);
			RLP.VerifyAddedRoom(AddMultipleRoomsPage.prefixForRoom+room1);
			Reporter.log("1ST ROOM VERIFIED", true);
			RLP.VerifyAddedRoom(AddMultipleRoomsPage.prefixForRoom+room2);
			Reporter.log("2ND ROOM VERIFIED", true);
			SortRoomsLandingPage  SRL=AH.fn_navigateToSortRooms();
	        SRL.VerifyRoom(AddMultipleRoomsPage.prefixForRoom+room1);
	        Reporter.log("1ST ROOM VERIFIED IN SORT ROOMS", true);
	        SRL.VerifyRoom(AddMultipleRoomsPage.prefixForRoom+room2);
	        Reporter.log("2ND ROOM VERIFIED IN SORT ROOMS", true);
	        PhoneExtensionsListPage PEL= AH.fn_NavigateToPhoneExtPage();
	        PEL.VerifyAddedRoom(AddMultipleRoomsPage.prefixForRoom+room1);
	        Reporter.log("1ST ROOM VERIFIED IN PHONE EXTENSION MODULE", true);
	        PEL.VerifyAddedRoom(AddMultipleRoomsPage.prefixForRoom+room2);
		    Reporter.log("ADDED ROOM VERIFIED IN PHONE EXTENSION MODULE",true);
		    ConfirmLoginPage CLP= PEL.fn_ClickandNavigateOnFrontDesk();
		    GenericClass.switchToWindowHandle("Frontdesk");
			CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
			Reporter.log("CLICKED OVER CONTINUE TRAIL BUTTON",true);
			FrontdeskLandingPage FLP1=CCP.fn_ClickContinueButton();
			Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
			FLP1.fn_ClickCancelButton();
		    Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
			FLP1.VerifyRoomInFrontdesk(AddMultipleRoomsPage.prefixForRoom+room1);
			Reporter.log("1ST ROOM VERIFIED ON FRONTDESK",true);
			FLP1.VerifyRoomInFrontdesk(AddMultipleRoomsPage.prefixForRoom+room2);
			Reporter.log("2ND ROOM VERIFIED ON FRONTDESK",true);
			HousekeepingLandingPage  HKL=FLP1.ClickOnHouseleepingLink();
			Reporter.log("NAVIGATED TO HOUSEKEEPING CONSOLE",true);
		    GenericClass.switchToWindowHandle("Housekeeping");
	    	HKL.VerifyRoom(AddMultipleRoomsPage.prefixForRoom+room1);
	        Reporter.log("1st ROOM VERIFIED IN HOUSE KEEPING MODULE", true);
	        HKL.VerifyRoom(AddMultipleRoomsPage.prefixForRoom+room2);
	    	Reporter.log("2nd ROOM VERIFIED IN HOUSE KEEPING MODULE", true);
	    	ExcelUtil.CloseAllExcelReferences();
	    	Reporter.log("multiple rooms added  by  range format along with prefix format. clicking on save button at bottom on Add multiple room page. and verified at Multiple source where it gets reflect.", true);
	}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
	}
	}
	
	
	//To Save Multiple rooms without entering data.
	@Test(priority=31,groups={"P1","RoomsTest"}, description="Added multiple room without data..And validation messages verified")
	public void HMS1754() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage AMR=RLP.ClickOnAddMultipleRoom_Link();
			GenericClass.clickElement(AMR.Btn_SaveAtTop);
			Thread.sleep(5000);
			String s=GenericClass.getText(AMR.Msg_Validation);
	        System.out.println(s);
			Thread.sleep(2000);
			String a=ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1));
			System.out.println(a);
			Assert.assertEquals(s.trim(),"Following ERRORS occurred during submission!"+ "\n" + "- Please Enter Room Name/Numbers"+"\n"+"- Please Select Room Type");
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("Added multiple room without data..And validation messages verified", true);
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	

	
	//Add Multiple rooms without data but radio button for 'Add Room nos' selected
	@Test(priority=32,groups={"P1","RoomsTest"}, description="Added room by selecting only room by numbers radio button without data..Valdation messages verified")
	public void HMS5877() throws Throwable{
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage AMR= RLP.ClickOnAddMultipleRoom_Link();
			GenericClass.clickElement(AMR.RB_RoomByNumber);
			GenericClass.clickElement(AMR.Btn_SaveAtTop);
			Thread.sleep(5000);
			String s=GenericClass.getText(AMR.Msg_Validation);
			Thread.sleep(2000);
			ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1));
			Assert.assertEquals(s,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("Added room by selecting only room by numbers radio button without data..Valdation messages verified", true);
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
		
	
	
	//To verify Adding Multiple rooms with duplicate room names.
	@Test(priority=33,groups={"P1","RoomsTest"}, description="To verify Adding Multiple rooms with duplicate room names. Validation message 'Following ERRORS occurred during submission! - Duplicate Room Name/Number.' appears")
	public void HMS1751() throws Throwable{
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
			Reporter.log("CLICKED OVER ADD MULTIPLE ROOMS LINK ON ROOMS LIST PAGE", true);
			String Room=GenericClass.generateRandomString();
			RLP=AMR.AddingMultipleRoomsByName(Room, AMR.Btn_SaveAtTop);
			RLP.ClickOnAddMultipleRoom_Link();
			AMR.verifyDuplicateRoomAdditionByName(Room,AMR.Btn_SaveAtTop);
			Thread.sleep(5000);
			String s=GenericClass.getText(AMR.Msg_Validation);
			Thread.sleep(2000);
			Assert.assertEquals(s,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("Validation message 'Following ERRORS occurred during submission! - Duplicate Room Name/Number.' appears", true);
	
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	//Adding Multiple rooms with duplicate room numbers.
	@Test(priority=34,groups={"P1","RoomsTest"}, description="To verify Adding Multiple rooms with duplicate room names. 'Following ERRORS occurred during submission! - Duplicate Room Name/Number.' Text verified")
	public void HMS1753() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
			String room1=GenericClass.GenerateRandomNumber(2);
			Integer val=Integer.parseInt(room1)+1;
			String room2=val.toString();
			
			AMR.AddingMultipleRoomsByNumber(room1,room2,AMR.Btn_SaveAtBtm);
			RLP.ClickOnAddMultipleRoom_Link();
			AMR.AddingMultipleRoomsByNumber(room1,room2,AMR.Btn_SaveAtBtm);
			Thread.sleep(5000);
			String s=GenericClass.getText(AMR.Msg_Validation);
			System.out.println(s);
			Thread.sleep(2000);
			String a=ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1));
			System.out.println(a);
			Assert.assertEquals(s,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Validation message verified", true);
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("System should display the message “Following ERRORS occurred during submission! - Duplicate Room Name/Number.", true);
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }

	
	// Adding Multiple Rooms without 'To' Field.
	@Test(priority=35,groups={"P1","RoomsTest"}, description="Added Multiple Rooms without 'To' Field.And validation message verified")
	public void HMS5886() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
			String room1=GenericClass.GenerateRandomNumber(2);
			AMR.AddingMultipleRoomsByNumber(room1,"",AMR.Btn_SaveAtBtm);
			String s=GenericClass.getText(AMR.Msg_Validation);
			System.out.println(s);
			Thread.sleep(2000);
			Assert.assertEquals(s,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Validation message verified", true);
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("Added Multiple Rooms without 'To' Field.And validation message verified", true);
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	     }
	
	
	//Enter Room To value less than Room From Value and save multiple rooms
	@Test(priority=36,groups={"P1","RoomsTest"}, description="Entered Room To value less than Room From Value and save multiple rooms .Validation message verified.")
	public void HMS8829() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			
			String room1=GenericClass.GenerateRandomNumber(2);
			Integer val=Integer.parseInt(room1)+1;
			String room2=val.toString();
	
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
			AMR.AddingMultipleRoomsByNumber(room2,room1,AMR.Btn_SaveAtBtm);
			String s=GenericClass.getText(AMR.Msg_Validation);
			Thread.sleep(2000);
			Assert.assertEquals(s,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("Entered Room To value less than Room From Value and save multiple rooms .Validation message verified", true);
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	//Entering character value in 'Room# ' and 'To' field .
	@Test(priority=37,groups={"P1","RoomsTest"}, description="Entered Multiple Room By Invalid Room Range ..Validation message verified")
	public void HMS5888() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
			AMR.AddingMultipleRoomsByNumber(GenericClass.generateRandomString(),GenericClass.generateRandomString(),AMR.Btn_SaveAtBtm);
			String s=GenericClass.getText(AMR.Msg_Validation);
			Thread.sleep(2000);
			Assert.assertEquals(s,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Entered Multiple Room By Invalid Room Range ..Validation message verified", true);
			ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	

	//Enter Room Name only and save multiple rooms
	@Test(priority=38,groups={"P1","RoomsTest"}, description="Entered Multiple Rooms By Name Only ..Validation message verified")
	public void HMS8824() throws Throwable{
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
			String room1=GenericClass.generateRandomString()+","+GenericClass.generateRandomString();
			
			AMR.AddingMultipleRoomsByNameOnly(room1, AMR.Btn_SaveAtTop);
			String s=GenericClass.getText(AMR.Msg_Validation);
			Thread.sleep(2000);
			Assert.assertEquals(s,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Entered Multiple Rooms By Name Only ..Validation message verified", true);
			ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	

	//Enter Room No only and save multiple rooms
	@Test(priority=39,groups={"P1","RoomsTest"}, description="Added Multiple Rooms By Number Without Room Type..and Validation message verified")
	public void HMS8825() throws Throwable{
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
	
			String room1=GenericClass.GenerateRandomNumber(2);
			Integer val=Integer.parseInt(room1)+1;
			String room2=val.toString();
			
			AMR.AddingMultipleRoomsByNumberWithoutRoomType( room1, room2,  AMR.Btn_SaveAtTop);
			String s=GenericClass.getText(AMR.Msg_Validation);
			Thread.sleep(2000);
			Assert.assertEquals(s,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("Added Multiple Rooms By Number Without Room Type..and Validation message verified", true);
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	

	//Select room type only and save multiple rooms.
	@Test(priority=40,groups={"P1","RoomsTest"}, description="Room adding by only selecting room type only..And Validation message verified")
	public void HMS8828() throws Throwable{
		try{
		    //AL.adminlogin_12302();
	
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
			GenericClass.SelectByIndex(AMR.Drpdwn_RoomType, 1);
			//GenericClass.selectElement(AMR.Drpdwn_RoomType, "Luxury");
			GenericClass.clickElement(AMR.Btn_SaveAtTop);
			String s=GenericClass.getText(AMR.Msg_Validation);
			System.out.println(s);
			Thread.sleep(2000);
			String a=ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1));
			System.out.println(a);
			Assert.assertEquals(s,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("Room adding by only selecting room type only..And Validation message verified", true);
	
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
	
		}
		}
	
	//To verify 'Cancel' button at the top right corner on Add Multiple Rooms page.
	@Test(priority=41,groups={"P2","RoomsTest"}, description="Multiple room addition cancelled(By cancel btn at top) after filling the room detail and Room List Page verified")
	public void HMS1768() throws Throwable{
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Reporter.log("Test Case identified in the excel file for test data", true);
			
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
	        String room=GenericClass.generateRandomString();
		    AMR.AddingMultipleRoomsByName(room, AMR.Btn_CancelAtTop);
			String s=GenericClass.driver.getTitle();
			Thread.sleep(2000);
			Assert.assertEquals(s,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Multiple room addition cancelled(By cancel btn at top) after filling the room detail and Room List Page verified", true);
			ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	// To verify 'Cancel' button at the end on Add Multiple Rooms page.
	@Test(priority=42,groups={"P2","RoomsTest"}, description="Multiple room addition cancelled(By cancel btn at Bottom) after filling the room detail and Room List Page verified")
	public void HMS8958() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddMultipleRoomsPage  AMR=RLP.ClickOnAddMultipleRoom_Link();
			 String room=GenericClass.generateRandomString();
		    AMR.AddingMultipleRoomsByName(room, AMR.Btn_CancelAtBtm);
			String s=GenericClass.driver.getTitle();
			Thread.sleep(2000);
			Assert.assertEquals(s,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("Multiple room addition cancelled(By cancel btn at Bottom) after filling the room detail and Room List Page verified", true);
	
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	
	//To verify Delete Selected Room(s) button.
	@Test(priority=43,groups={"P1","RoomsTest"}, description="Delete Pop up message verified while deleting Room")
	public void HMS1769() throws Throwable{
		try{
		    //AL.adminlogin_12302();
	
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			String room=GenericClass.generateRandomString();
		    RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
	
		    RLP.DeleteRooms(room);
		    GenericClass.ActionOnAlert("Dismiss");
		    Thread.sleep(2000);
		    Assert.assertEquals(GenericClass.value,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		    Reporter.log("Delete Pop up message verified while deleting Room", true);
			ExcelUtil.CloseAllExcelReferences();
		    }catch(Throwable e){
		    	ExcelUtil.CloseAllExcelReferences();
		    	GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		    	throw e;
		}
		}

	// To verify Delete a Room functionality.
	@Test(priority=44,groups={"P1","RoomsTest"}, description="Room DELETED AND VERIFIED AT REFLECTIOS POINTS")
	public void HMS5891() throws Throwable{
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
	
			String room=GenericClass.generateRandomString();
		    RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
	
		    RLP.DeleteRooms(room);
		    GenericClass.ActionOnAlert("Accept");
		    Thread.sleep(2000);
		    Assert.assertEquals(GenericClass.getText(RLP.Validation_Msg),RLP.ValidationFormatForDelete(room));
		    Reporter.log("Delete message verified", true);
		    Thread.sleep(5000);
		    ArrayList<String> coll=RLP.VerifyTableForRooms();
		    Assert.assertEquals(coll.contains(room), false);
		    SortRoomsLandingPage SRL= AH.fn_navigateToSortRooms();
		    ArrayList<String> coll1 =SRL.VerifyDeletedRoom();
		    Assert.assertEquals(coll1.contains(room), false);
		    Reporter.log("Deleted ROOMS VERIFIED IN SORT ROOMS MODULE.", true);
		    PhoneExtensionsListPage PEL=AH.fn_NavigateToPhoneExtPage();
		    ArrayList<String> coll2=PEL.VerifyDeletedRoom();
		    Assert.assertEquals(coll2.contains(room), false);
		    Reporter.log("Deleted ROOM NOT MATCHED. anD VERIFIED IN PHONE EXTENSION MODULE ",true);
			ConfirmLoginPage CLP=PEL.fn_ClickandNavigateOnFrontDesk();
			GenericClass.switchToWindowHandle("Frontdesk");
			CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
			FrontdeskLandingPage FLP1=CCP.fn_ClickContinueButton();
			FLP1.fn_ClickCancelButton();
			FLP1.VerifyDeletedRoomInFrontdesk(room);
			Reporter.log(room+" Room is not persent", true);
		    HousekeepingLandingPage  HKL=FLP1.ClickOnHouseleepingLink();
		    GenericClass.switchToWindowHandle("Housekeeping");
		    HKL.VerifyDeletedRoom(room);
		    Reporter.log("ROOM_is_not_persent_and_VERIFIED_IN_HOUSEKEEPING_MODULE", true);
		    Reporter.log("Room DELETED AND VERIFIED AT REFLECTIOS POINTS", true);
		    ExcelUtil.CloseAllExcelReferences();
		    }catch(Throwable e){
		    	 ExcelUtil.CloseAllExcelReferences();
		    		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		    	 throw e;
		}
		}
	

	// To Delete a room that is marked as DNR.
//	@Test(priority=45,groups={"P1"})
//	public void HMS8934() throws Throwable{
//		try{
//			AdminHome AH=//AL.adminlogin_12302();
//	
//			RoomsLandingPage RLP=AdminHome.fn_NaviagteToRooms();
//	
//			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
//			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
//			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
//	
//			AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
//	
//		    RLP=ARP.AddingRoom(iTestCaseRow, AddRoomsPage.SaveAtTop_Btn, Constant.File_Rooms);
//	
//		    String str=ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber));
//		    GenericClass.driver.close();
//		    FrontdeskLoginPage FLP=GenericClass.fn_OpenFrontdesk("ff", "http://hotelogix.stayezee.com/frontdesk/login/login");
//			ConfirmLoginPage CLP=FLP.Frontdesklogin_12954();
//			CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
//			FrontdeskLandingPage FLP1=CCP.fn_ClickContinueButton();
//			FLP1.fn_ClickCancelButton();
//	
//			WebElement ele=FLP1.VerifyRoomInFrontdesk(str);
//			FLP1.MarkDNRToRoom(ele);
//			GenericClass.driver.close();
//			new RoomsTest().Login();
//			//AL.adminlogin_12302();
//		    RLP=AdminHome.fn_NaviagteToRooms();
//		    RLP.DeleteRooms(iTestCaseRow);
//		    GenericClass.ActionOnAlert("Accept");
//	
//		    Assert.assertEquals(GenericClass.getText(RoomsLandingPage.Validation_Msg), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
//			Reporter.log("Messsage verified room can't be deleted because it is mark as DNR", true);
//			ExcelUtil.CloseAllExcelReferences();
//		    }catch(Throwable e){
//		    	 ExcelUtil.CloseAllExcelReferences();
//		    	 throw e;
//		   }
//	    }
	


	
	
	//To Delete all the rooms on Rooms List page.
	@Test(priority=46,groups={"P3"},description="Messsage verified ' - These Room(s) cannot be deleted as some of these Room have Active Reservations/DNR.'")
	public void HMS1770() throws Throwable{
	try{
		//AL.adminlogin_12302();
	
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
	
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
		GenericClass.selectElement(RLP.DD_View, "All");
		GenericClass.ActionOnAlert("Accept");
		GenericClass.clickElement(RLP.CB_Master);
		GenericClass.clickElement(RLP.Btn_DeleteSelectedRooms);
		GenericClass.ActionOnAlert("Accept");
	    Assert.assertEquals(GenericClass.getText(RLP.Validation_Msg), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log("Messsage verified ' - These Room(s) cannot be deleted as some of these Room have Active Reservations/DNR.'", true);
		ExcelUtil.CloseAllExcelReferences();
	    }catch(Throwable e){
	    	ExcelUtil.CloseAllExcelReferences();
	    	GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	    	throw e;
		}
     	}
	
	
	//To cancel deleting a room
	@Test(priority=47,groups={"P2","RoomsTest"},description="Number of rooms are same after pressing cancel button on delete alert")
	public void HMS8831() throws Throwable{
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			GenericClass.selectElement(RLP.DD_View, "All");
			GenericClass.ActionOnAlert("Accept");
			int c=GenericClass.tr_count(RLP.CB_AllRooms);
			GenericClass.clickElement(RLP.CB_Master);
			Reporter.log("Master checkbox is selected", true);
			GenericClass.clickElement(RLP.Btn_DeleteSelectedRooms);
			GenericClass.ActionOnAlert("Dismiss");
			Thread.sleep(2000);
			int c1=GenericClass.tr_count(RLP.CB_AllRooms);
			Thread.sleep(2000);
		    Assert.assertEquals(c, c1);
		    Thread.sleep(2000);
			Reporter.log("Number of rooms are same after pressing cancel button on delete alert ", true);
		    ExcelUtil.CloseAllExcelReferences();
		    }catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
			}
	        }
	
	
	//To verify Cancel in Rooms List
	@Test(priority=48,groups={"P2","RoomsTest"},description="Administrator console page appears after clicking on cancel button on Room List Landing Page")
	public void HMS1771() throws Throwable{
		try{
			 //AL.adminlogin_12302();
	
			RoomsLandingPage RLP= AH.fn_NavigateRooms();
			Reporter.log("Landed to Rooms List Page", true);
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			GenericClass.clickElement(RLP.Cancel_Btn);
			Thread.sleep(2000);
			Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Administrator console page appears after clicking on cancel button on Room List Landing Page", true);
	
		    ExcelUtil.CloseAllExcelReferences();
		    }catch(Throwable e){
		    	ExcelUtil.CloseAllExcelReferences();
		    	GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		    	throw e;
			}
	        }

	
	//To verify Filter dropdown in Rooms List page.
	@Test(priority=49,groups={"P2","RoomsTest"},description="ROOM TYPE FILTER DROPDOWN IS VISIBLE")
	public void HMS1776() throws Throwable{
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	
			Assert.assertTrue(RLP.BlockFilter_DD.isDisplayed());
			Assert.assertTrue(RLP.FloorFilter_DD.isDisplayed());
			Assert.assertTrue(RLP.FloorFilter_DD.isDisplayed());
			Reporter.log("ROOM TYPE FILTER DROPDOWN IS VISIBLE", true);
		    ExcelUtil.CloseAllExcelReferences();
		    }catch(Throwable e){
		    	 ExcelUtil.CloseAllExcelReferences();
		    		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		    	 throw e;
			}
	        }
	

	//Search room that exist in a different room type.
	@Test(priority=50,groups={"P2","RoomsTest"},description="Search room that exist in a different room type.Message 'No entries found' is verified.")
	public void HMS8833() throws Throwable{
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage  RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
	
			String room=GenericClass.generateRandomString();
			RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
			RLP.fn_CheckRoomType(iTestCaseRow);
			Reporter.log(room + " Room Added by "+ ARP.rtype, true);
			
			GenericClass.SelectByIndex(RLP.RoomTypeFilter_DD,2);
			Reporter.log("Searching  " + ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber))+ "Room with another room type", true);
			RLP.SearchRoomInRoomList(room);
			Reporter.log("Entered " + ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber))+ "Room in serach box type", true);
			Thread.sleep(2000);
			Assert.assertEquals(GenericClass.getText(RLP.NoEntriesFound_Txt), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Entered " + ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber))+ "Room not found ", true);
			ExcelUtil.CloseAllExcelReferences();
		    }catch(Throwable e){
		    	ExcelUtil.CloseAllExcelReferences();
		    	GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		    	throw e;
			}
	        }
	
	// To Delete a room that is assigned to a reservation
	@Test(priority=52,groups={"P1","RoomsTest"},description="Delete Reserved room and verify message '- These Room(s) cannot be deleted as some of these Room have Active Reservations/DNR.'")
	public void HMS8935() throws Throwable{
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage  RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			
			RLP.fn_DeleteOccupaiedRoom("Accept");
			Assert.assertEquals(GenericClass.getText(RLP.Validation_Msg), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("Room Can't be deleted because it is assigned to the reservation", true);
	
		}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
		}
	    }

	
	
	// Search room that exist on different floor
	@Test(priority=51,groups={"P1","RoomsTest"},description="No Entries found Validation message appears. When we are searching room in another floor.")
	public void HMS8960() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage  RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
	
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			RLP.CheckFloorAvailability(RLP.FloorFilter_DD,iTestCaseRow,Constant.File_Rooms);
			Thread.sleep(3000);
		    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			Reporter.log("Clicked over add room link", true);
			
			String room=GenericClass.generateRandomString();
			RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
			Reporter.log(ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber))+ " Room Added by "+ ARP.rtype, true);
			GenericClass.SelectByIndex(RLP.FloorFilter_DD,2);
			RLP.SearchRoomInRoomList(room);
			Reporter.log("Entered " + ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber))+ "Room in serach box type", true);
			Thread.sleep(2000);
			Assert.assertEquals(GenericClass.getText(RLP.NoEntriesFound_Txt), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("No Entries found Validation message appears. When we are searching room in another floor ", true);
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }

	
	
	// Search room that exist in different Block.
	@Test(priority=53,groups={"P1","RoomsTest"},description="No Entries found Validation message appears. When we are searching room in another block")
	public void HMS8961() throws Throwable{
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage  RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			RLP.CheckBlockAvailability(RLP.BlockFilter_DD,iTestCaseRow,Constant.File_Rooms);
			
			Thread.sleep(3000);
		    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			Reporter.log("Clicked over add room link", true);
			String room=GenericClass.generateRandomString();
			RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
			Reporter.log(room+ " Room Added by "+ AddRoomsPage.block, true);
			GenericClass.SelectByIndex(RLP.BlockFilter_DD,2);
			RLP.SearchRoomInRoomList(room);
			Reporter.log("Entered " + room+ "Room in serach box type", true);
			Thread.sleep(2000);
			Assert.assertEquals(GenericClass.getText(RLP.NoEntriesFound_Txt), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("No Entries found Validation message appears. because we are searching room in another block", true);
		}catch(Throwable e){
		  ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
		}
	    }
	
		
	
	// Search room that does not exist
	@Test(priority=54,groups={"P1","RoomsTest"},description="Search room which is not created and verify message 'No entries found'.")
	public void HMS8962() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage  RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			
			Thread.sleep(3000);
		    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		    String room=GenericClass.generateRandomString();
			RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
			Reporter.log(ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber))+ " Room Added by "+ AddRoomsPage.block, true);
			RLP.DeleteRooms(room);
			GenericClass.ActionOnAlert("Accept");
	
			RLP.SearchRoomInRoomList(room);
			Reporter.log("Entered " + room+ "Room in serach box type", true);
			Thread.sleep(2000);
			Assert.assertEquals(GenericClass.getText(RLP.NoEntriesFound_Txt), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Search room not found because it doesn't exist", true);
			ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	//To verify Search Rooms in Rooms List page.
	@Test(priority=55,groups={"P1","RoomsTest"},description="To verify serch room in search edit box which is already exist.")
	public void HMS1775() throws Throwable{
	
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage  RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Thread.sleep(3000);
		    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
	        String room=GenericClass.generateRandomString();
			RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
			Reporter.log(room+ " Room Added by "+ AddRoomsPage.block, true);
			RLP.SearchRoomInRoomList(room);
			Reporter.log("Entered " + room+ "Room in serach box type", true);
			Thread.sleep(2000);
			RLP.VerifyAddedRoom(room);
			Reporter.log("Search room  found because it appears in the room list page.", true);
			ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	}
	

	// To Delete a room that is checked in .
	@Test(priority=56,groups={"P1","RoomsTest"}, description="To verify delete room which is Checked-In and verified message '- These Room(s) cannot be deleted as some of these Room have Active Reservations/DNR.'")
	public void HMS8936() throws Throwable{
		try{
			//AL.adminlogin_12302();
	
			RoomsLandingPage  RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			
			RLP.fn_DeleteOccupaiedRoom("Accept");
			Assert.assertEquals(GenericClass.getText(RLP.Validation_Msg), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("Room can't be deleted because room having active reservation on that.", true);
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
		

	// To verify Select All functionality in Rooms List
	@Test(priority=57,groups={"P2","RoomsTest"},description="To Select Master check box in Rooms landing page. The all other checkboxes get selected.")
	public void HMS5893() throws Throwable{
		try{
		//AL.adminlogin_12302();
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		Reporter.log("Landed to Rooms List Page", true);
	    RLP.VerifyMasterCheckBox();
	    Reporter.log("Master checkbox for Rooms module verified for selection", true);
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	//Deselect all rooms on Room List page
	@Test(priority=58,groups={"P2","RoomsTest"},description="To deselect Master check box in Rooms landing page. The all other checkboxes get deselected.")
	public void HMS8830() throws Throwable{
		try{
		//AL.adminlogin_12302();
		Reporter.log("Login Success", true);
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		Reporter.log("Landed to Rooms List Page", true);
	    RLP.VerifyDeselect();
	    Reporter.log("Master checkbox for  Rooms module verified for deselection", true);
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	
	//To verify Edit link in Rooms List.
	@Test(priority=59,groups={"P1","RoomsTest"},description="Click on Edit link against any room and Add/Edit page is appear.")
	public void HMS1773() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage  RLP=AH.fn_NavigateRooms();
	
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			
			RLP.CheckFloorAvailability(RLP.FloorFilter_DD,iTestCaseRow,Constant.File_Rooms);
			Thread.sleep(3000);
		    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			Reporter.log("Clicked over add room link", true);
			String room=GenericClass.generateRandomString();
			RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
			Thread.sleep(2000);
			RLP.SelectRoomToEdit(room);
			Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Edit room page title verified", true);
			ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	}
	
	
	//To verify Editing a Room.
	@Test(priority=60,groups={"P0","RoomsTest"},description="Edit exist room name and verify all reflected points.")
	public void HMS1774() throws Throwable{
		try{
			//AL.adminlogin_12302();
	        RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		    iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Thread.sleep(3000);
		    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			Reporter.log("Clicked over add room link", true);
			String room=GenericClass.generateRandomString();
			RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
			Thread.sleep(2000);
			EditRoomsPage ERP=RLP.SelectRoomToEdit(room);
			RLP=ERP.EditTheRoom(room,ERP.Btn_Save);
		    RLP.VerifyAddedRoom(room);
			SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
		    Reporter.log("NAVIGATION SUCCESS TO SORT ROOMS",true);
			SRL.VerifyRoom(room);
		    Reporter.log("ROOM VERIFIED IN SORT ROOMS MODULE",true);
		    PhoneExtensionsListPage PEL=AH.fn_NavigateToPhoneExtPage();
		    Reporter.log("NAVIGATED TO PHONE EXTENSIONS MODULE",true);
		    PEL.fn_CheckPhoneExtention();
		    PEL.VerifyAddedRoom(room);
		    Reporter.log("ADDED ROOM VERIFIED IN PHONE EXTENSION MODULE",true);
		    ConfirmLoginPage CLP=PEL.fn_ClickandNavigateOnFrontDesk();
		    GenericClass.switchToWindowHandle("Frontdesk");
			CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
			Reporter.log("CLICKED OVER CONTINUE TRAIL BUTTON",true);
			FrontdeskLandingPage FLP1=CCP.fn_ClickContinueButton();
			Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
			FLP1.fn_ClickCancelButton();
		    Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
			FLP1.VerifyRoomInFrontdesk(room);
			Reporter.log("ADDED ROOM VERIFIED ON FRONTDESK",true);
			HousekeepingLandingPage  HKL=FLP1.ClickOnHouseleepingLink();
			Reporter.log("NAVIGATED TO HOUSEKEEPING CONSOLE",true);
			GenericClass.switchToWindowHandle("Housekeeping");
			HKL.VerifyRoom(room);
			Reporter.log("ROOM VERIFIED IN HOUSEKEEPING",true);
			Reporter.log("Edited Room by Save button and verified at Reflections point",true);
			ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
	}
	}
	
	
	//Edit a Room and save and duplicate room.
	@Test(priority=61 ,groups={"P0","RoomsTest"},description="Edit Room name and click Save and  Duplicate button and verified at Reflections point")
	public void HMS5897() throws Throwable{
		try{
			//AL.adminlogin_12302();
	        RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		    iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Thread.sleep(3000);
		    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			Reporter.log("Clicked over add room link", true);
			String room=GenericClass.generateRandomString();
			RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
			Thread.sleep(2000);
			EditRoomsPage ERP=RLP.SelectRoomToEdit(room);
			RLP=ERP.EditTheRoom(room,ERP.Btn_SaveNDuplicateRoomTop);
			GenericClass.clickElement(ERP.Btn_Cancel);
			RLP.VerifyAddedRoom(room);
			SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
		    Reporter.log("NAVIGATION SUCCESS TO SORT ROOMS",true);
			SRL.VerifyRoom(room);
		    Reporter.log("ROOM VERIFIED IN SORT ROOMS MODULE",true);
		    PhoneExtensionsListPage PEL=AH.fn_NavigateToPhoneExtPage();
		    Reporter.log("NAVIGATED TO PHONE EXTENSIONS MODULE",true);
		    PEL.fn_CheckPhoneExtention();
		    PEL.VerifyAddedRoom(room);
		    Reporter.log("ADDED ROOM VERIFIED IN PHONE EXTENSION MODULE",true);
		    ConfirmLoginPage CLP=PEL.fn_ClickandNavigateOnFrontDesk();
		    GenericClass.switchToWindowHandle("Frontdesk");
			CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
			Reporter.log("CLICKED OVER CONTINUE TRAIL BUTTON",true);
			FrontdeskLandingPage FLP1=CCP.fn_ClickContinueButton();
			Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
			FLP1.fn_ClickCancelButton();
		    Reporter.log("CLICKED OVER CONTINUE BUTTON",true);
			FLP1.VerifyRoomInFrontdesk(room);
			Reporter.log("ADDED ROOM VERIFIED ON FRONTDESK",true);
			HousekeepingLandingPage  HKL=FLP1.ClickOnHouseleepingLink();
			Reporter.log("NAVIGATED TO HOUSEKEEPING CONSOLE",true);
			GenericClass.switchToWindowHandle("Housekeeping");
			HKL.VerifyRoom(room);
			Reporter.log("ROOM VERIFIED IN HOUSEKEEPING",true);
			Reporter.log("Edit Room name and click Save and  Duplicate button and verified at Reflections point",true);
			ExcelUtil.CloseAllExcelReferences();
			
		}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
	}
	}
	
	//To verify Status of a Room.
	@Test(priority=62 ,groups={"P0","RoomsTest"},description="Room deactivated and verified at reflections point")
	public void HMS1779() throws Throwable{
		try{
			//AdminHome  AH=AL.adminlogin_12302();
	        RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		    iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Thread.sleep(3000);
		    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			Reporter.log("Clicked over add room link", true);
			String room=GenericClass.generateRandomString();
			RLP=ARP.AddingRoom( room, ARP.btn_SaveAtTop);
			RLP.ChangeStatus(room);
			Thread.sleep(2000);
			Reporter.log("Room deactivated", true);
			SortRoomsLandingPage  SRL=AH.fn_navigateToSortRooms();
			SRL.VerifyDeactivatedRooms(room);
			String a=GenericClass.GetCurrentWindowID();
			ConfirmLoginPage CLP=AH.ClickOnFrontdeskLink();
			GenericClass.windowHandle(a);
			CashCounterPage  CCP=CLP.fn_ClickCountinueWithTrail_BT();
			FrontdeskLandingPage  FLP=CCP.fn_ClickContinueButton();
			FLP.fn_ClickCancelButton();
			Thread.sleep(4000);
			FLP.VerifyDeactivatedRoom(room);
			HousekeepingLandingPage  HKL=FLP.ClickOnHouseleepingLink();
			GenericClass.fn_SwitchToWindow_Title("Housekeeping");
			HKL.VerifyDeactivatedRoom(room);
	
			ExcelUtil.CloseAllExcelReferences();
		   Reporter.log("Room deactivated and verified at reflections point", true);
	
		}catch(Throwable e){
	ExcelUtil.CloseAllExcelReferences();
	GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	throw e;
	}
		}
	
	
	
	// Deactivate a room that is marked as DNR.
	@Test(priority=63 ,groups={"P0","RoomsTest"},description="Deactivate reserved room. '-This Room cannot be deactivated as it has Active Reservations/DNR' message verified.")
	public void HMS8940() throws Throwable{
		try{
			//AL.adminlogin_12302();
	        RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		    iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Thread.sleep(3000);
			RLP.fn_DeactivateOccupiedRoom("Accept");
			String roommsg=GenericClass.ActionOnAlert("Accept");
			Assert.assertEquals(roommsg,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		    Reporter.log("This Room cannot be deactivated as it has Active Reservations/DNR", true);
		    ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
	}
	}
	
	// Deactivate a Room that is assigned to a reservation.
	@Test(priority=64,groups={"P1","RoomsTest"},description=" Deactivate a Room that is assigned to a DNR. '-This Room cannot be deactivated as it has Active Reservations/DNR.' message verified.")
	public void HMS8938() throws Throwable{
		try{
			//AdminHome  AH=AL.adminlogin_12302();
	        RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		    iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Thread.sleep(3000);
		    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			Reporter.log("Clicked over add room link", true);
			String room=GenericClass.generateRandomString();
			RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
			String a=GenericClass.GetCurrentWindowID();
			ConfirmLoginPage CLP=AH.ClickOnFrontdeskLink();
			GenericClass.windowHandle(a);
		    CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
			FrontdeskLandingPage FLP1=CCP.fn_ClickContinueButton();
		    GenericClass.driver.navigate().refresh();
			FLP1.fn_ClickCancelButton();
			FLP1.WindowScroll();
			Thread.sleep(2000);
			WebElement we=FLP1.fn_GetWebelementforDNR(room);
			FLP1.MarkDNRToRoom(we);
			GenericClass.Switch_Parent_Window(a);
			RLP.ChangeStatus(room);
		    String alrtTxt=GenericClass.ActionOnAlert("Accept");
		    Thread.sleep(2000);
			Assert.assertEquals(alrtTxt,ExcelUtil.getCellData(iTestCaseRow,  ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("This Room cannot be deactivated as it has Active Reservations/DNR", true);
	}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
	}
	}
	
	
	
	//Deactivate a room that is checked-in.
	@Test(priority=65,groups={"P1","RoomsTest"}, description="Deactivate a room that is checked-in. 'This Room cannot be deactivated as it has Active Reservations/DNR' message verified.")
	public void HMS1780() throws Throwable{
		try{
			//AL.adminlogin_12302();
	        RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		    iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		    Thread.sleep(3000);
			RLP.fn_DeactivateOccupiedRoom("Accept");
			String roommsg=GenericClass.ActionOnAlert("Accept");
			Assert.assertEquals(roommsg,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		    ExcelUtil.CloseAllExcelReferences();
			Reporter.log("This Room cannot be deactivated as it has checked In Reservations/DNR", true);
	}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
	}
	}
	
	//To verify Activate status for a Room
	@Test(priority=66,groups={"P0","RoomsTest"},description=" Verified Activated status for a Room and verified all reflected point.")
	public void HMS1778() throws Throwable{
	try{
		//	AdminHome  AH=//AL.adminlogin_12302();
			RoomsLandingPage  RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			RLP.CheckFloorAvailability(RLP.FloorFilter_DD,iTestCaseRow,Constant.File_Rooms);
			
			Thread.sleep(3000);
		    AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		    String room=GenericClass.generateRandomString();
			RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
			RLP.ChangeStatus(room);
			Thread.sleep(2000);
			String actSrc=RLP.ChangeStatus(room);
			Thread.sleep(6000);
			Assert.assertEquals(actSrc.endsWith("off.GIF"),true);
			Thread.sleep(2000);
			SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
			SRL.VerifyRoom(room);
			AH.fn_NavigateRooms();
		    String a=GenericClass.GetCurrentWindowID();
		    ConfirmLoginPage CLP=AH.ClickOnFrontdeskLink();
			GenericClass.windowHandle(a);
			CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
			FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
			FLP.fn_ClickCancelButton();
			//FLP.fn_clickCurrentLnk();
			FLP.VerifyActivatedRoom(room);
			HousekeepingLandingPage  HKL=FLP.ClickOnHouseleepingLink();
			GenericClass.switchToWindowHandle("Housekeeping");
			HKL.VerifyRoom(room);
			ExcelUtil.CloseAllExcelReferences();
			Reporter.log("verified Activated status for a Room", true);
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	//To verify Sort by Room Names/Numbers.
	@Test(priority=67,groups={"P2","RoomsTest"},description="To verify Sort by Room Names/Numbers")
	public void HMS1782() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		GenericClass.sortingName_Downward(RLP.DD_View, "All",RLP.Btn_DownwardSortRoomNameNumbers , RLP.All_CB, "//table[@class='list_viewnew']//tbody//td[3]");
		ExcelUtil.CloseAllExcelReferences();
		Reporter.log("Downward arrow Sort by Room Names/Numbers verified.", true);
		}
		catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
	}
	}
	
	
	// To verify Sort by Room Names/Numbers
	@Test(priority=68,groups={"P2","RoomsTest"},description="Upward arrow Sort by Room Names/Numbers verified.")
	public void HMS8941() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		GenericClass.sortingName_Upward(RLP.DD_View, "All",RLP.Btn_UpwardSortRoomNameNumbers , RLP.All_CB, "//table[@class='list_viewnew']//tbody//td[3]");
		ExcelUtil.CloseAllExcelReferences();
		Reporter.log("Upward arrow Sort by Room Names/Numbers verified.", true);
		}
		catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
		}
	    }

	
	//To verify downward Sort by Room Type
	@Test(priority=69,groups={"P2","RoomsTest"},description="Downward arrow Sort by Room Types verified.")                      //// Some modification in sortingName_Downward method
	public void HMS1789() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		GenericClass.sortingName_Downward(RLP.DD_View, "100",RLP.Btn_DownwardSortRoomTypes , RLP.All_CB, "//table[@class='list_viewnew']//tbody//td[4]");
		ExcelUtil.CloseAllExcelReferences();
		Reporter.log("Downward arrow Sort by Room Types verified.", true);
		}catch(Throwable e){
	      ExcelUtil.CloseAllExcelReferences();
	  	GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
		}
		}
	
	//To verify upward Sort by Room Type
	@Test(priority=70,groups={"P2","RoomsTest"},description="Verify Upward arrow Sort by Room Types verified.")                    // sortingName_Upward need to be modified 
	public void HMS8942() throws Throwable{
	try{
	//AL.adminlogin_12302();
	RoomsLandingPage  RLP=AH.fn_NavigateRooms();
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
	
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	GenericClass.sortingName_Upward(RLP.DD_View, "100",RLP.Btn_DownwardSortRoomTypes , RLP.All_CB, "//table[@class='list_viewnew']//tbody//td[4]");
	ExcelUtil.CloseAllExcelReferences();
	Reporter.log("Upward arrow Sort by Room Types verified.", true);
	}
	catch(Throwable e){
	ExcelUtil.CloseAllExcelReferences();
	GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	throw e;
	}
	}
	
	
	// Sort by Status with upward arrow.
	@Test(priority=71,groups={"P2","RoomsTest"},description="Verify Sort rooms by Status with upward arrow")
	public void HMS8943() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		String room=GenericClass.generateRandomString();
		RLP=ARP.AddingRoom(room, ARP.btn_SaveAtTop);
		Thread.sleep(2000);
		RLP.DownwardSortByStatus();
		Thread.sleep(2000);
		ExcelUtil.CloseAllExcelReferences();
		Reporter.log("Downward arrow Sort by Room Types verified.", true);
		}
		catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
		}
	}
	
	//Sort by Status with downward arrow.
	@Test(priority=72,groups={"P2","RoomsTest"},description="To verify Sort rooms by Status with Downward arrow")
	public void HMS1783() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		Thread.sleep(2000);
		RLP.UpwardSortByStatus();
		Thread.sleep(2000);
		ExcelUtil.CloseAllExcelReferences();
		Reporter.log("To verify Sort rooms by Status with Downward arrow.", true);
		}
		catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
	}
	}
	

	//To verify Main in Room List
	@Test(priority=73,groups={"P0","RoomsTest"},description="Administrator Home page verified after clicking  Main link on  Room List Landing Page.")
	public void HMS1772() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		Thread.sleep(2000);
		RLP.ClickOnMainLink();
		Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Thread.sleep(2000);
		ExcelUtil.CloseAllExcelReferences();
		Reporter.log("Administrator Home page verified after clicking  Main link on Room List Landing Page ", true);
		}catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
		}
	}
	
	
	
	//To Verify 'View' dropdown at the bottom center on Rooms List page
	@Test(priority=74,groups={"P2","RoomsTest"},description="To Verify 'View' dropdown at the bottom center on Rooms List page.")
	public void HMS1784() throws Throwable{
		try{
		//AL.adminlogin_12302();
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		Thread.sleep(2000);
		GenericClass.selectElement(RLP.DD_View, "5");
		int size=GenericClass.tr_count(RLP.All_CB);
		String s=Integer.toString(size);
		Assert.assertEquals(s, "5");
		Thread.sleep(2000);
		ExcelUtil.CloseAllExcelReferences();
		Reporter.log("To Verify 'View' dropdown at the bottom center on Rooms List page ", true);
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	}
	
	
	//To verify Page dropdown at bottom left corner on Rooms List page.
	@Test(priority=75,groups={"P2","RoomsTest"},description="Page dropdown verified in rooms landing page.")
	public void HMS1785() throws Throwable{
		try{
		//AL.adminlogin_12302();
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		Thread.sleep(2000);
		RLP.VerifyPageDropdown();
		Reporter.log("Page dropdown verified", true);
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	}

	
	//To verify Next link at bottom right corner on rooms when message corresponding to 'Page' is 'of 1'.
	@Test(priority=76,groups={"P2","RoomsTest"},description="To verify Next link at bottom right corner on rooms when message corresponding to 'Page' is 'of 1'.")
	public void HMS1786() throws Throwable{
		try{
		//AL.adminlogin_12302();
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		Thread.sleep(2000);
		GenericClass.selectElement(RLP.DD_View, "All");
		GenericClass.ActionOnAlert("Accept");
		Assert.assertEquals(GenericClass.getText(RLP.Txt_PreviousNext), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log("Previous and Next links are disabled",true);
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e){
		ExcelUtil.CloseAllExcelReferences();
		GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		throw e;
		}
	}
		
	@Test(priority=77,groups={"P2","RoomsTest"},description="To verify Next link at bottom right corner on rooms when message corresponding to 'Page' is 'of 2'.")
	public void HMS8949() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		Thread.sleep(2000);
		RLP.VerifyPageDropdown();
		Reporter.log("Page dropdown verified",true);
		}catch(Throwable e){
		  throw e;
		}
	    }
	
	
	@Test(priority=78,groups={"P2","RoomsTest"},description="To verify Previous Link at bottom right corner on rooms list page when '1' is selected from the Page dropdown.")
	public void HMS1787() throws Throwable{
	try{
		//AL.adminlogin_12302();
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
		iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		Thread.sleep(2000);
		System.out.println(GenericClass.getText(RLP.Txt_DeactivePreviousLink));
		ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1));
		Assert.assertEquals(GenericClass.getText(RLP.Txt_DeactivePreviousLink), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log("Previous link is disabled",true);
		ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
	      ExcelUtil.CloseAllExcelReferences();
	  	GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	         throw e;
	      }
	      }
	
	
	@Test(priority=80,groups={"P0","RoomsTest"},description="To verify Audit Trail link in Rooms and navigate on AuditTrail page.")
	public void HMS1788() throws Throwable{
		try{
			//AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			String room=GenericClass.generateRandomString();
			ARP.AddingRoom(room, ARP.btn_SaveAtBtm);
			String a=GenericClass.GetCurrentWindowID();
			AuditTrailPage ATP=RLP.ClickOnAuditTrailLink();
			GenericClass.windowHandle(a);
		    ATP.VerifyAuditTrail(room +" created by");
			ExcelUtil.CloseAllExcelReferences();
			}catch(Throwable e){
				ExcelUtil.CloseAllExcelReferences();
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
	        }
	
	
	@Test(priority=79,groups={"P1","RoomsTest"},description="To verify Previous Link at bottom right corner on Rooms List page when '2' is selected from the Page dropdown.")
	public void HMS8952() throws Throwable{
		try{
		    //AL.adminlogin_12302();
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Rooms,Constant.Sheet_Rooms);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			Thread.sleep(2000);
			GenericClass.selectElement(RLP.DD_View, "1");
			System.out.println(GenericClass.getText(RLP.Txt_DeactivePreviousLink));
			Assert.assertEquals(GenericClass.getText(RLP.Txt_DeactivePreviousLink), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Previous link is disabled",true);
			ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e){
			ExcelUtil.CloseAllExcelReferences();
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	@AfterMethod
	public void closeApp() throws Throwable{
		Set<String> handles = GenericClass.driver.getWindowHandles();
		for(String windowId: handles){
		GenericClass.driver.switchTo().window(windowId);
		GenericClass.driver.close();
	}
	}

	
	
	}
