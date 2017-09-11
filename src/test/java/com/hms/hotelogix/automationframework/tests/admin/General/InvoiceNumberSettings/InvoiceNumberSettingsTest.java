package com.hms.hotelogix.automationframework.tests.admin.General.InvoiceNumberSettings;

import org.jsoup.helper.DescendableLinkedList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontdeskPOS.SampleRestaurant.ConfirmOrderPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontdeskPOS.SampleRestaurant.ConfirmOrderPage1;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontdeskPOS.SampleRestaurant.OrderFolioPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontdeskPOS.SampleRestaurant.SampleRestaurantLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.CashCounterPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.ConfirmLoginPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.Payment.AccountStatementLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ReservationSearchResult.ReservationSearchResultLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.General.InvoiceNumberSettings.AuditTrailINS;
import com.hms.hotelogix.automationframework.pages.admin.General.InvoiceNumberSettings.EditFDInvoiceNumber;
import com.hms.hotelogix.automationframework.pages.admin.General.InvoiceNumberSettings.EditPOSInvoiceNumber;
import com.hms.hotelogix.automationframework.pages.admin.General.InvoiceNumberSettings.EditPRInvoiceNumber;
import com.hms.hotelogix.automationframework.pages.admin.General.InvoiceNumberSettings.InvoiceNumberSettingsLP;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.RoomsLandingPage;

public class InvoiceNumberSettingsTest 
{

	public WebDriver driver;

	private String sTestCaseName;

	private int iTestCaseRow;
	private AdminLogin AL=new AdminLogin();
	


	@BeforeMethod
	 public void Login() throws Throwable
	 {
		try
		{
			
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AL=GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser)), "http://hotelogix.net/admine/login/login/");
	    
		//AL=GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, Constant.Col_Browser), "http://livestable.hx.local/admine/login/login/");

	    ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e )
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	 }

	
	
	/**
	 * To verify whether user is able to navigate 'Invoice Number Settings' page.
	 * @throws Throwable
	 */
	@Test(priority=1,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify whether user is able to navigate 'Invoice Number Settings' page.")
	public void HMS8908() throws Throwable
	{
		try
		{
			AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
	   ////AdminHome AH=AL.adminlogin_12485();
       InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
       
       sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	   ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

	   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	   
	   String str=INS.verify_pageHeader();
	   Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
	   
	   System.out.println("HMS-8908 Executed");
	   
	   ExcelUtil.CloseAllExcelReferences();
		}

		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify " Title" of Invoice Number Setting page.
	 * @throws Throwable
	 */
	@Test(priority=2,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Title of Invoice Number Setting page.")
	public void HMS6350() throws Throwable
	{
		try
		{
		 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			
		 ////AdminHome AH=AL.adminlogin_12485();
	     InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
	       
	     sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		 
		 Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		 
		 System.out.println("HMS-6350 Executed");
		 
		 ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	/**
	 * To verify the presence of all the Links, buttons and fields on "Invoice Number Settings" page.
	 * @throws Throwable
	 */
	@Test(priority=3,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify the presence of all the Links, buttons and fields on Invoice Number Settings page.")
	public void HMS8909() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
	    InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
	    INS.fn_verifyPageElements();
	    
	    System.out.println("HMS-8909 Executed");
	    
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
			throw e;
		}
	   
	}
	
	/**
	 * To verify "Main"  text link on Invoice Number Settings page.
	 * @throws Throwable
	 */
	@Test(priority=4,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Main  text link on Invoice Number Settings page.")
	public void HMS6351() throws Throwable
	{
		try
		{
        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
	    InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
	    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	    INS.fn_clkMainLnk();
		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
	    
	    System.out.println("HMS-6351 Executed");
	    
	    ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{
			 GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	/**
	 * To verify "Edit" text link in Invoice Number Settings page for Frontdesk.
	 * @throws Throwable
	 */
	@Test(priority=5,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit text link in Invoice Number Settings page for Frontdesk.")
	public void HMS6352() throws Throwable
	{
		try
		{
        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
	    InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
	    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		String a=GenericClass.GetCurrentWindowID();
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		String str=EIN.fn_verifyPageHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		
		System.out.println("HMS-6352 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}

		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Verify title of the page after clicking 'Edit' button for Frontdesk
	 * @throws Throwable
	 */
	@Test(priority=6,groups={"P0","InvoiceNumbserSettingsTest"},description="Verify title of the page after clicking 'Edit' button for Frontdesk")
	public void HMS8910() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		String a=GenericClass.GetCurrentWindowID();
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		System.out.println("HMS-8910 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify the presence of all the Links, buttons and fields on "Edit Frontdesk Invoice Number" page.
	 * @throws Throwable
	 */
	@Test(priority=7,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify the presence of all the Links, buttons and fields on Edit Frontdesk Invoice Number page.")
	public void HMS8911() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
        EIN.fn_verifyElements();
        
        System.out.println("HMS-8911");
        
        ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Verify message corresponding to 'Prefix' label on 'Edit Frontdesk Invoice Number' page
	 * @throws Throwable
	 */
	@Test(priority=8,groups={"P1","InvoiceNumbserSettingsTest"},description="Verify message corresponding to 'Prefix' label on 'Edit Frontdesk Invoice Number' page")
	public void HMS8916() throws Throwable
	{
		try
		{
        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		String str=EIN.fn_getPrefixTxt();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		
		System.out.println("HMS-8916 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}

		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
		
	}
	
	/**
	 * To verify "Edit Frontdesk Invoice Number" page.
	 * @throws Throwable
	 */
	@Test(priority=9,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Invoice Number page.")
	public void HMS6353() throws Throwable
	{
		try
		{
        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		EIN.fn_editFDPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedFDPrefix(iTestCaseRow); 
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
	    AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
	    String rtype= ARP.fn_addRoomName(1); 
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		FLP.fn_createFDReserv(rtype,"3","3");
  		FLP.fn_fillAddQuickResrvDetails(iTestCaseRow);
  	    String ID=FLP.fn_getReservId();
  		GenericClass.driver.navigate().refresh();
  	    Thread.sleep(12000);
  	    FLP.fn_AutoNightAudit1();
  	    Thread.sleep(10000);
  	    ReservationSearchResultLandingPage RSLP=  FLP.fn_SearchReservationID(ID.trim());
  	    ViewDetailsPage VDP= RSLP.fn_ClickOnSearchedRecord();
		AccountStatementLandingPage ASP=VDP.fn_ClickOnPayment_BT();
  	    ASP.fn_makeFullPayment();
  	    Thread.sleep(5000);
  	    ASP.fn_clkGenerateFolio();
  	    Thread.sleep(8000);
  	    ASP.fn_ClickSettleFolio_Accept();
  	    Thread.sleep(5000);
		ASP.fn_LockFolio(iTestCaseRow);
  	     
		System.out.println("HMS6353 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Frontdesk Invoice Number" page without Prefix
	 * @throws Throwable
	 */
	@Test(priority=10,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Invoice Number page without Prefix")
	public void HMS6354() throws Throwable
	{
		try
		{
        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		EIN.fn_editFDPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedFDPrefix(iTestCaseRow);
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
	    AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
	    String rtype= ARP.fn_addRoomName(1); 
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		FLP.fn_createFDReserv(rtype,"3","3");  		
  		FLP.fn_fillAddQuickResrvDetails(iTestCaseRow);
  	    String ID=FLP.fn_getReservId();
  		GenericClass.driver.navigate().refresh();
  	    Thread.sleep(12000);
  	    FLP.fn_AutoNightAudit1();
  	    Thread.sleep(10000);
  	    ReservationSearchResultLandingPage RSLP=  FLP.fn_SearchReservationID(ID.trim());
  	    ViewDetailsPage VDP= RSLP.fn_ClickOnSearchedRecord();
		AccountStatementLandingPage ASP=VDP.fn_ClickOnPayment_BT();
  	    ASP.fn_makeFullPayment();
  	    Thread.sleep(5000);
  	    ASP.fn_clkGenerateFolio();
  	    Thread.sleep(8000);
  	    ASP.fn_ClickSettleFolio_Accept();
  	    Thread.sleep(5000);
		ASP.fn_LockFolio(iTestCaseRow);
		
		System.out.println("HMS-6354 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	
	/**
	 * To verify "Edit Frontdesk Invoice Number" page without Starting Series Number.
	 * @throws Throwable
	 */
	@Test(priority=11,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Invoice Number page without Starting Series Number.")
	public  void HMS6355() throws Throwable
	{
		try
		{
        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		EIN.fn_editFDPrefix(iTestCaseRow);
		String str=EIN.fn_verifyAlert();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-6355 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	/**
	 * To verify "Edit Frontdesk Invoice Number" page without Prefix & Starting Series Number.
	 * @throws Throwable
	 */
	@Test(priority=12,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Invoice Number page without Prefix & Starting Series Number.")
	public void HMS6356() throws Throwable
	{
		try
		{
        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		EIN.fn_editFDPrefix(iTestCaseRow);
		String str=EIN.fn_verifyAlert();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS6356 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
		
	}
	
	
	/**
	 * To verify " Edit Frontdesk Invoice Number" page with numeric in Prefix field.
	 * @throws Throwable
	 */
	@Test(priority=13,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Invoice Number page with numeric in Prefix field.")
	public void HMS6357() throws Throwable
	{
		try
		{
        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		EIN.fn_editFDPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedFDPrefix(iTestCaseRow);
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
		String rtype= ARP.fn_addRoomName(1); 
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		FLP.fn_createFDReserv(rtype,"3","3");
  		FLP.fn_fillAddQuickResrvDetails(iTestCaseRow);
  	    String ID=FLP.fn_getReservId();
  		GenericClass.driver.navigate().refresh();
  	    Thread.sleep(12000);
  	    FLP.fn_AutoNightAudit1();
  	    Thread.sleep(10000);
  	    ReservationSearchResultLandingPage RSLP=  FLP.fn_SearchReservationID(ID.trim());
  	    ViewDetailsPage VDP= RSLP.fn_ClickOnSearchedRecord();
		AccountStatementLandingPage ASP=VDP.fn_ClickOnPayment_BT();
  	    ASP.fn_makeFullPayment();
  	    Thread.sleep(5000);
  	    ASP.fn_clkGenerateFolio();
  	    Thread.sleep(8000);
  	    ASP.fn_ClickSettleFolio_Accept();
  	    Thread.sleep(5000);
		ASP.fn_LockFolio(iTestCaseRow);
		
		System.out.println("HMS-6357 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify " Edit Fontdesk Invoice Number" page with alphanumeric in Prefix field.
	 * @throws Throwable
	 */
	@Test(priority=14,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Fontdesk Invoice Number page with alphanumeric in Prefix field.")
	public void HMS6358() throws Throwable
	{
		try
		{
        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		EIN.fn_editFDPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedFDPrefix(iTestCaseRow);
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
		String rtype= ARP.fn_addRoomName(1); 
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		FLP.fn_createFDReserv(rtype,"3","3");
  		FLP.fn_fillAddQuickResrvDetails(iTestCaseRow);
  	    String ID=FLP.fn_getReservId();
  		GenericClass.driver.navigate().refresh();
  	    Thread.sleep(12000);
  	    FLP.fn_AutoNightAudit1();
  	    Thread.sleep(10000);
  	    ReservationSearchResultLandingPage RSLP=  FLP.fn_SearchReservationID(ID.trim());
  	    ViewDetailsPage VDP= RSLP.fn_ClickOnSearchedRecord();
		AccountStatementLandingPage ASP=VDP.fn_ClickOnPayment_BT();
  	    ASP.fn_makeFullPayment();
  	    Thread.sleep(5000);
  	    ASP.fn_clkGenerateFolio();
  	    Thread.sleep(8000);
  	    ASP.fn_ClickSettleFolio_Accept();
  	    Thread.sleep(5000);
		ASP.fn_LockFolio(iTestCaseRow);
		
		System.out.println("HMS-6358 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Frontdesk Invoice Number" page  with (-,_) special characters in Prefix field.
	 * @throws Throwable
	 */
	@Test(priority=15,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Invoice Number page  with (-,_) special characters in Prefix field.")
	public void HMS6359() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		EIN.fn_editFDPrefix(iTestCaseRow);
		//GenericClass.Alert_Accept();
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedFDPrefix(iTestCaseRow);
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
		String rtype= ARP.fn_addRoomName(1);
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		FLP.fn_createFDReserv(rtype,"3","3");
  		FLP.fn_fillAddQuickResrvDetails(iTestCaseRow);
  	    String ID=FLP.fn_getReservId();
  		GenericClass.driver.navigate().refresh();
  	    Thread.sleep(12000);
  	    FLP.fn_AutoNightAudit1();
  	    Thread.sleep(10000);
  	    ReservationSearchResultLandingPage RSLP=  FLP.fn_SearchReservationID(ID.trim());
  	    ViewDetailsPage VDP= RSLP.fn_ClickOnSearchedRecord();
		AccountStatementLandingPage ASP=VDP.fn_ClickOnPayment_BT();
  	    ASP.fn_makeFullPayment();
  	    Thread.sleep(5000);
  	    ASP.fn_clkGenerateFolio();
  	    Thread.sleep(8000);
  	    ASP.fn_ClickSettleFolio_Accept();
  	    Thread.sleep(5000);
		ASP.fn_LockFolio(iTestCaseRow);
		
		System.out.println("HMS-6359 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	
	
	/**
	 * To verify "Edit Frontdesk Invoice Number" page with (@,#,% etc) special characters in Prefix field.
	 * @throws Throwable
	 */
	@Test(priority=16,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Invoice Number page with (@,#,% etc) special characters in Prefix field.")
	public void HMS6360() throws Throwable
	{
		try
		{
		    AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			
			//AdminHome AH=AL.adminlogin_12485();
			InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
			String a=GenericClass.GetCurrentWindowID();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			
			EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
			GenericClass.windowHandle(a);
			EIN.fn_editFDPrefix(iTestCaseRow);
			String str=EIN.fn_verifyAlert();
			//System.out.println(str);
			//System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
			GenericClass.driver.close();
			GenericClass.Switch_Parent_Window(a);
			
			System.out.println("HMS-6360 Executed");
			
			ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To view " Edit Frontdesk Invoice Number" with alphbetic in Starting Series Number field.
	 * @throws Throwable
	 */
	@Test(priority=17,groups={"P1","InvoiceNumbserSettingsTest"},description="To view Edit Frontdesk Invoice Number with alphbetic in Starting Series Number field.")
	public void HMS6361() throws Throwable
	{
		try
		{
        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		EIN.fn_editFDPrefix(iTestCaseRow);
		String str=EIN.fn_verifyAlert();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-6361 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Frontdesk Invoice Number" page with alphanumeric in Starting Series Number field.
	 * @throws Throwable
	 */
	@Test(priority=18,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Invoice Number page with alphanumeric in Starting Series Number field.")
	public void HMS6362() throws Throwable
	{
		try
		{
        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		EIN.fn_editFDPrefix(iTestCaseRow);
		String str=EIN.fn_verifyAlert();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-6362 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}

		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Frontdesk Invoice Number" page with special characters in Starting Series Number field.
	 * @throws Throwable
	 */
	@Test(priority=19,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Invoice Number page with special characters in Starting Series Number field.")
	public void HMS6363() throws Throwable
	{
		try
		{
        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		EIN.fn_editFDPrefix(iTestCaseRow);
		String str=EIN.fn_verifyAlert();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-6363 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Cancel" button in Edit  Frontdesk Invoice Number paqe.
	 * @throws Throwable
	 */
	@Test(priority=20,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Cancel button in Edit  Frontdesk Invoice Number page.")
	public void HMS6364() throws Throwable
	{
		try
		{
	        AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			
			//AdminHome AH=AL.adminlogin_12485();
			InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
			String a=GenericClass.GetCurrentWindowID();
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			
			EditFDInvoiceNumber EIN=INS.fn_clkFDEditLnk();
			GenericClass.windowHandle(a);
			EIN.fn_fillDetails(iTestCaseRow);
			EIN.fn_clkCancelBtn();
			GenericClass.Switch_Parent_Window(a);
			String str=INS.verify_pageHeader();
			Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
			
			System.out.println("HMS6364 Executed");
			
			ExcelUtil.CloseAllExcelReferences();
		}

		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit" text link in Invoice Number Settings page for Payment Receipt.
	 * @throws Throwable
	 */
	@Test(priority=21,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit text link in Invoice Number Settings page for Payment Receipt.")
	public void HMS9176() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		String text=EPRI.fn_verifyPageHeader();
		Assert.assertEquals(text, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-9176 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}

		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Verify title of the page after clicking 'Edit' button for Payment Receipt
	 * @throws Throwable
	 */
	@Test(priority=22,groups={"P0","InvoiceNumbserSettingsTest"},description="Verify title of the page after clicking 'Edit' button for Payment Receipt")
	public void HMS9177() throws Throwable
	{
		try
		{
	    AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-9177 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}		
	}
	
	
	/**
	 * To verify the presence of all the Links, buttons and fields on "Edit Frontdesk Payment Receipt Number" page.
	 * @throws Throwable
	 */
	@Test(priority=23,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify the presence of all the Links, buttons and fields on Edit Frontdesk Payment Receipt Number page.")
	public void HMS9178() throws Throwable
	{

		try
		{
	    AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
        EPRI.fn_verifyElements();
        GenericClass.driver.close();
        GenericClass.Switch_Parent_Window(a);
        
        System.out.println("HMS-9178 Executed");
        
        ExcelUtil.CloseAllExcelReferences();
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Verify message corresponding to 'Prefix' label on 'Edit Frontdesk Payment Receipt Number' page
	 * @throws Throwable
	 */
	@Test(priority=24,groups={"P1","InvoiceNumbserSettingsTest"},description="Verify message corresponding to 'Prefix' label on 'Edit Frontdesk Payment Receipt Number' page")
	public void HMS9179() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		String text=EPRI.fn_getPrefixTxt();
		Assert.assertEquals(text.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-9179 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}

		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Frontdesk Payment Receipt Number" on the page.
	 * @throws Throwable
	 */
	@Test(priority=25,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Payment Receipt Number on the page.")
	public void HMS9180() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		EPRI.fn_editFDPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedPRPrefix(iTestCaseRow);
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
		String rtype= ARP.fn_addRoomName(1);	
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		FLP.fn_createFDReserv(rtype,"3","3");
  		FLP.fn_fillAddQuickResrvDetails(iTestCaseRow);
  	    String ID=FLP.fn_getReservId();
  	    FLP.fn_clkClose();
  		/*GenericClass.driver.navigate().refresh();
  	    Thread.sleep(12000);
  	    FLP.fn_AutoNightAudit1();*/
  	    Thread.sleep(10000);
  	    ReservationSearchResultLandingPage RSLP=  FLP.fn_SearchReservationID(ID.trim());
  	    ViewDetailsPage VDP= RSLP.fn_ClickOnSearchedRecord();
		AccountStatementLandingPage ASP=VDP.fn_ClickOnPayment_BT();
		ASP.fn_clkPayNow(iTestCaseRow);
		ASP.fn_verifyPREditedInvoice(iTestCaseRow);
		
		
		System.out.println("HMS-9180 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	/**
	 * To verify "Edit Frontdesk Payment Receipt Number" page without Prefix
	 * @throws Throwable
	 */
	@Test(priority=26,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Payment Receipt Number page without Prefix")
	public void HMS9181() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		EPRI.fn_editFDPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedPRPrefix(iTestCaseRow);
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
		String rtype= ARP.fn_addRoomName(1); 	
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
        FLP.fn_createFDReserv(rtype,"3","3");
        FLP.fn_fillAddQuickResrvDetails(iTestCaseRow);
  	    String ID=FLP.fn_getReservId();
  	    FLP.fn_clkClose();
  		/*GenericClass.driver.navigate().refresh();
  	    Thread.sleep(12000);
  	    FLP.fn_AutoNightAudit1();*/
  	    Thread.sleep(10000);
  	    ReservationSearchResultLandingPage RSLP=  FLP.fn_SearchReservationID(ID.trim());
  	    ViewDetailsPage VDP= RSLP.fn_ClickOnSearchedRecord();
		AccountStatementLandingPage ASP=VDP.fn_ClickOnPayment_BT();
		ASP.fn_clkPayNow(iTestCaseRow);
		ASP.fn_verifyPREditedInvoice(iTestCaseRow);
		
		System.out.println("HMS-9181 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Frontdesk Payment Receipt Number" page without Starting Series Number.
	 * @throws Throwable
	 */
	@Test(priority=27,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Payment Receipt Number page without Starting Series Number.")
	public void HMS9182() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		EPRI.fn_editFDPrefix(iTestCaseRow);
		String str=EPRI.fn_verifyAlert();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);

		System.out.println("HMS-9182 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	/**
	 * To verify "Edit Frontdesk Invoice Number" page without Prefix & Starting Series Number.
	 * @throws Throwable
	 */
	@Test(priority=28,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Invoice Number page without Prefix & Starting Series Number.")
	public void HMS9186() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		EPRI.fn_editFDPrefix(iTestCaseRow);
		String str=EPRI.fn_verifyAlert();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);

		System.out.println("HMS-9186 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	/**
	 * To verify " Edit Frontdesk Payment Receipt Number" page with numeric in Prefix field.
	 * @throws Throwable
	 */
	@Test(priority=29,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Payment Receipt Number page with numeric in Prefix field.")
	public void HMS9187() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		EPRI.fn_editFDPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedPRPrefix(iTestCaseRow);
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
		String rtype= ARP.fn_addRoomName(1);	
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		FLP.fn_createFDReserv(rtype,"3","3");
  		FLP.fn_fillAddQuickResrvDetails(iTestCaseRow);
  	    String ID=FLP.fn_getReservId();
  	    FLP.fn_clkClose();
  		/*GenericClass.driver.navigate().refresh();
  	    Thread.sleep(12000);
  	    FLP.fn_AutoNightAudit1();*/
  	    Thread.sleep(10000);
  	    ReservationSearchResultLandingPage RSLP=  FLP.fn_SearchReservationID(ID.trim());
  	    ViewDetailsPage VDP= RSLP.fn_ClickOnSearchedRecord();
		AccountStatementLandingPage ASP=VDP.fn_ClickOnPayment_BT();
		ASP.fn_clkPayNow(iTestCaseRow);
		ASP.fn_verifyPREditedInvoice(iTestCaseRow);
		
		System.out.println("HMS-9187 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Fontdesk Payment Receipt Number" page with alphanumeric in Prefix field.
	 * @throws Throwable
	 */
	@Test(priority=30,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Fontdesk Payment Receipt Number page with alphanumeric in Prefix field.")
	public void HMS9188() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		EPRI.fn_editFDPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedPRPrefix(iTestCaseRow);
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
		String rtype= ARP.fn_addRoomName(1);		
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		FLP.fn_createFDReserv(rtype,"3","3");
  		FLP.fn_fillAddQuickResrvDetails(iTestCaseRow);
  	    String ID=FLP.fn_getReservId();
  	    FLP.fn_clkClose();
  		/*GenericClass.driver.navigate().refresh();
  	    Thread.sleep(12000);
  	    FLP.fn_AutoNightAudit1();*/
  	    Thread.sleep(10000);
  	    ReservationSearchResultLandingPage RSLP=  FLP.fn_SearchReservationID(ID.trim());
  	    ViewDetailsPage VDP= RSLP.fn_ClickOnSearchedRecord();
		AccountStatementLandingPage ASP=VDP.fn_ClickOnPayment_BT();
		ASP.fn_clkPayNow(iTestCaseRow);
		ASP.fn_verifyPREditedInvoice(iTestCaseRow);
		
		System.out.println("HMS-9188 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Frontdesk Payment Receipt Number" page  with (-,_) special characters in Prefix field.
	 * @throws Throwable
	 */
	@Test(priority=31,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Payment Receipt Number page  with (-,_) special characters in Prefix field.")
	public void HMS9189() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		EPRI.fn_editFDPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedPRPrefix(iTestCaseRow);
		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
		String rtype= ARP.fn_addRoomName(1);		
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		FLP.fn_createFDReserv(rtype,"3","3");
  		FLP.fn_fillAddQuickResrvDetails(iTestCaseRow);
  	    String ID=FLP.fn_getReservId();
  	    FLP.fn_clkClose();
  		/*GenericClass.driver.navigate().refresh();
  	    Thread.sleep(12000);
  	    FLP.fn_AutoNightAudit1();*/
  	    Thread.sleep(10000);
  	    ReservationSearchResultLandingPage RSLP=  FLP.fn_SearchReservationID(ID.trim());
  	    ViewDetailsPage VDP= RSLP.fn_ClickOnSearchedRecord();
		AccountStatementLandingPage ASP=VDP.fn_ClickOnPayment_BT();
		ASP.fn_clkPayNow(iTestCaseRow);
		ASP.fn_verifyPREditedInvoice(iTestCaseRow);
		
		System.out.println("HMS-9189 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	
	/**
	 * To verify "Edit Frontdesk Payment Receipt Number" page with (@,#,% etc) special characters in Prefix field.
	 * @throws Throwable
	 */
	@Test(priority=32,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Payment Receipt Number page with (@,#,% etc) special characters in Prefix field.")
	public void HMS9190() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		EPRI.fn_editFDPrefix(iTestCaseRow);
		String str=EPRI.fn_verifyAlert();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-9190 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To view " Edit Frontdesk Payment Receipt Number" with alphbetic in Starting Series Number field.
	 * @throws Throwable
	 */
	@Test(priority=33,groups={"P1","InvoiceNumbserSettingsTest"},description="To view Edit Frontdesk Payment Receipt Number with alphbetic in Starting Series Number field.")
	public void HMS9191() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		EPRI.fn_editFDPrefix(iTestCaseRow);
		String str=EPRI.fn_verifyAlert();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-9191 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	/**
	 * To verify "Edit Frontdesk Payment Receipt Number" page with alphanumeric in Starting Series Number field.
	 * @throws Throwable
	 */
	@Test(priority=34,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Payment Receipt Number page with alphanumeric in Starting Series Number field.")
	public void HMS9192() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		EPRI.fn_editFDPrefix(iTestCaseRow);
		String str=EPRI.fn_verifyAlert();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-9192 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Frontdesk Payment Receipt Number" page with special characters in Starting Series Number field.
	 * @throws Throwable
	 */
	@Test(priority=35,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Frontdesk Payment Receipt Number page with special characters in Starting Series Number field.")
	public void HMS9193() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		EPRI.fn_editFDPrefix(iTestCaseRow);
		String str=EPRI.fn_verifyAlert();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-9193 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Cancel" button in Edit  Frontdesk Payment Receipt Number paqe.
	 * @throws Throwable
	 */
	@Test(priority=36,groups={"P2","InvoiceNumbserSettingsTest"},description="To verify Cancel button in Edit  Frontdesk Payment Receipt Number page.")
	public void HMS9194() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				
		EditPRInvoiceNumber EPRI= INS.fn_clkPREditLnk();
		GenericClass.windowHandle(a);
		EPRI.fn_fillPRDetails(iTestCaseRow);
		EPRI.fn_clkCancelBtn();
		GenericClass.Switch_Parent_Window(a);
		Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		System.out.println("HMS-9194 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify Sort by "POS Points" clicking downward arrow in Invoice Number Settings page.
	 * @throws Throwable
	 */
	@Test(priority=37,groups={"P2","InvoiceNumbserSettingsTest"},description="To verify Sort by POS Points clicking downward arrow in Invoice Number Settings page.")
	public void HMS6365() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		INS.fn_POSPtDownwardSort();
		
		System.out.println("HMS-6365 Executed");
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
		
		
	}
	
	
	/**
	 * To verify Sort by "POS Points" clicking upward arrow in Invoice Number Settings page.
	 * @throws Throwable
	 */
	@Test(priority=38,groups={"P2","InvoiceNumbserSettingsTest"},description="To verify Sort by POS Points clicking upward arrow in Invoice Number Settings page.")
	public void HMS8912() throws Throwable
	{
		
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		INS.fn_POSPtUpwardSort();
		
		System.out.println("HMS-8912 Executed");
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit" under POS Point(s) title in Invoice Number Settings page.
	 * @throws Throwable
	 */
	@Test(priority=39,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit under POS Point(s) title in Invoice Number Settings page.")
	public void HMS6366() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		INS.clk_editPOSLink();
		GenericClass.windowHandle(a);
        Assert.assertEquals(GenericClass.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		
		System.out.println("HMS-6366 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
			
		}
		
	}
	
	
	/**
	 * Verify title of the page after clicking 'Edit' button for POS Point(s)
	 * @throws Throwable
	 */
	@Test(priority=40,groups={"P1","InvoiceNumbserSettingsTest"},description="Verify title of the page after clicking 'Edit' button for POS Point(s)")
	public void HMS8913() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.clk_editPOSLink();
		String posPt="("+INS.POSPt+")";
		GenericClass.windowHandle(a);
		String text=EPOS.verify_pageHeader();
		System.out.println(text);
		System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))+" "+posPt);
		Assert.assertEquals(text.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))+" "+posPt), true);	
		GenericClass.driver.close();
		
		System.out.println("HMS-8913 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
		
	}
	
	
	/**
	 * To verify the presence of all the Links, buttons and fields on "Edit Pos Invoice Number" page.
	 * @throws Throwable
	 */
	@Test(priority=41,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify the presence of all the Links, buttons and fields on Edit Pos Invoice Number page.")
	public void HMS8914() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		EditPOSInvoiceNumber EPOS=INS.clk_editPOSLink();
		GenericClass.windowHandle(a);
		EPOS.fn_verifyPageElements();
	    GenericClass.driver.close();
	    GenericClass.Switch_Parent_Window(a);
	    
	    System.out.println("HMS-8914 Executed");
	    
	    ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Verify message corresponding to 'Prefix' label on 'Edit Pos Invoice Number' page
	 * @throws Throwable
	 */
	@Test(priority=42,groups={"P1","InvoiceNumbserSettingsTest"},description="Verify message corresponding to 'Prefix' label on 'Edit Pos Invoice Number' page")
	public void HMS8915() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.clk_editPOSLink();
		GenericClass.windowHandle(a);
		String text=EPOS.fn_getPrefixTxt();
		Assert.assertEquals(text.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-8915 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}

		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	/**
	 * To verify "Edit POS Invoice Number" page.
	 * @throws Throwable
	 */
	@Test(priority=43,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit POS Invoice Number page.")
	public void HMS6367() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.fn_clkSampleRestEdit(iTestCaseRow);
		GenericClass.windowHandle(a);
		EPOS.fn_editPOSPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedSampleRestPrefix(iTestCaseRow);
		/*RoomsLandingPage RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		ARP.AddUniqueRoom();		*/
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		//String b=GenericClass.GetCurrentWindowID();
		SampleRestaurantLandingPage SRLP=FLP.ClickToSampleRestaurant();
		GenericClass.fn_SwitchToWindow_Title("Restaurant");
		//GenericClass.windowHandle(b);
		ConfirmOrderPage COP=SRLP.fn_GenerateOrder();
		ConfirmOrderPage1 COP1=COP.ConfirmOrder();
		OrderFolioPage OFP=COP1.fn_VerifyPayNowButton(iTestCaseRow);	
		OFP.verify_FolioNumber(iTestCaseRow);
		//GenericClass.driver.close();
		//GenericClass.Switch_Parent_Window(b);
		
		
		System.out.println("HMS-6367 Excuted");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Pos Invoice Number" page without Prefix
	 * @throws Throwable
	 */
	@Test(priority=44,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Pos Invoice Number page without Prefix")
	public void HMS6368() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.fn_clkSampleRestEdit(iTestCaseRow);
		GenericClass.windowHandle(a);
		EPOS.fn_editPOSPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyBlankSampleRestPrefix(iTestCaseRow);
		/*RoomsLandingPage RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		ARP.AddUniqueRoom();		*/
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		//String b=GenericClass.GetCurrentWindowID();
		SampleRestaurantLandingPage SRLP=FLP.ClickToSampleRestaurant();
		GenericClass.fn_SwitchToWindow_Title("Restaurant");
		//GenericClass.windowHandle(b);
		ConfirmOrderPage COP=SRLP.fn_GenerateOrder();
		ConfirmOrderPage1 COP1=COP.ConfirmOrder();
		Thread.sleep(4000);
		OrderFolioPage OFP=COP1.fn_VerifyPayNowButton(iTestCaseRow);	
		OFP.verify_FolioNumber(iTestCaseRow);
		
		System.out.println("HMS-6368 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Pos Invoice Number" page without Starting Series Number.
	 * @throws Throwable
	 */
	@Test(priority=45,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Pos Invoice Number page without Starting Series Number.")
	public void HMS6369() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.clk_editPOSLink();
		GenericClass.windowHandle(a);
		EPOS.fn_editPOSPrefix(iTestCaseRow);
		String text=EPOS.fn_verifyAlert();
		Assert.assertEquals(text.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-6369 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
		
	}
	
	
	/**
	 * To verify "Edit Pos Invoice Number" page without Prefix & Starting Series Number.
	 * @throws Throwable
	 */
	@Test(priority=46,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Pos Invoice Number page without Prefix & Starting Series Number.")
	public void HMS6370() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.clk_editPOSLink();
		GenericClass.windowHandle(a);
		EPOS.fn_editPOSPrefix(iTestCaseRow);
		String text=EPOS.fn_verifyAlert();
		Assert.assertEquals(text.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-6370 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify " Edit Pos Invoice Number" page with numeric value in Prefix field.
	 * @throws Throwable
	 */
	@Test(priority=47,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Pos Invoice Number page with numeric value in Prefix field.")
	public void HMS6371() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.fn_clkSampleRestEdit(iTestCaseRow);
		GenericClass.windowHandle(a);
		EPOS.fn_editPOSPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedSampleRestPrefix(iTestCaseRow);
		/*RoomsLandingPage RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		ARP.AddUniqueRoom();		*/
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		//String b=GenericClass.GetCurrentWindowID();
		SampleRestaurantLandingPage SRLP=FLP.ClickToSampleRestaurant();
		GenericClass.fn_SwitchToWindow_Title("Restaurant");
		//GenericClass.windowHandle(b);
		ConfirmOrderPage COP=SRLP.fn_GenerateOrder();
		ConfirmOrderPage1 COP1=COP.ConfirmOrder();
		Thread.sleep(4000);
		OrderFolioPage OFP=COP1.fn_VerifyPayNowButton(iTestCaseRow);	
		OFP.verify_FolioNumber(iTestCaseRow);
		
		System.out.println("HMS-6371 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Pos Invoice Number" page with alphanumeric in Prefix field.
	 * @throws Throwable
	 */
	@Test(priority=48,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Pos Invoice Number page with alphanumeric in Prefix field.")
	public void HMS6372() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.fn_clkSampleRestEdit(iTestCaseRow);
		GenericClass.windowHandle(a);
		EPOS.fn_editPOSPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedSampleRestPrefix(iTestCaseRow);
		/*RoomsLandingPage RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		ARP.AddUniqueRoom();		*/
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		//String b=GenericClass.GetCurrentWindowID();
		SampleRestaurantLandingPage SRLP=FLP.ClickToSampleRestaurant();
		GenericClass.fn_SwitchToWindow_Title("Restaurant");
		//GenericClass.windowHandle(b);
		ConfirmOrderPage COP=SRLP.fn_GenerateOrder();
		ConfirmOrderPage1 COP1=COP.ConfirmOrder();
		Thread.sleep(4000);
		OrderFolioPage OFP=COP1.fn_VerifyPayNowButton(iTestCaseRow);	
		OFP.verify_FolioNumber(iTestCaseRow);
		
		System.out.println("HMS-6372 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Pos Invoice Number" page  with (-,_) special characters in Prefix field.
	 * @throws Throwable
	 */
	@Test(priority=49,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Edit Pos Invoice Number page  with (-,_) special characters in Prefix field.")
	public void HMS6373() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.fn_clkSampleRestEdit(iTestCaseRow);
		GenericClass.windowHandle(a);
		EPOS.fn_editPOSPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		INS.fn_verifyEditedSampleRestPrefix(iTestCaseRow);
		/*RoomsLandingPage RLP=AH.fn_NavigateRooms();
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		ARP.AddUniqueRoom();		*/
		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		//String b=GenericClass.GetCurrentWindowID();
		SampleRestaurantLandingPage SRLP=FLP.ClickToSampleRestaurant();
		GenericClass.fn_SwitchToWindow_Title("Restaurant");
		//GenericClass.windowHandle(b);
		ConfirmOrderPage COP=SRLP.fn_GenerateOrder();
		ConfirmOrderPage1 COP1=COP.ConfirmOrder();
		Thread.sleep(4000);
		OrderFolioPage OFP=COP1.fn_VerifyPayNowButton(iTestCaseRow);	
		OFP.verify_FolioNumber(iTestCaseRow);
		
		System.out.println("HMS-6373 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Pos Invoice Number" page with (@,#,% etc) special characters in Prefix field.
	 * @throws Throwable
	 */
	@Test(priority=50,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Pos Invoice Number page with (@,#,% etc) special characters in Prefix field.")
	public void HMS6374() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.clk_editPOSLink();
		GenericClass.windowHandle(a);
		EPOS.fn_editPOSPrefix(iTestCaseRow);
		EPOS.fn_verifyAlert();
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-6374 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify " Edit Pos Invoice Number" page with alphbetic in Starting Series Number field.
	 * @throws Throwable
	 */
	@Test(priority=51,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Pos Invoice Number page with alphbetic in Starting Series Number field.")
	public void HMS6375() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.clk_editPOSLink();
		GenericClass.windowHandle(a);
		EPOS.fn_editPOSPrefix(iTestCaseRow);
		EPOS.fn_verifyAlert();
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-6375 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Pos Invoice Number" page with alphanumeric value in Starting Series Number field.
	 * @throws Throwable
	 */
	@Test(priority=52,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Pos Invoice Number page with alphanumeric value in Starting Series Number field.")
	public void HMS6376() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.clk_editPOSLink();
		GenericClass.windowHandle(a);
		EPOS.fn_editPOSPrefix(iTestCaseRow);
		EPOS.fn_verifyAlert();
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-6376 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Edit Pos Invoice Number" page with special characters in Starting Series Number field.
	 * @throws Throwable
	 */
	@Test(priority=53,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify Edit Pos Invoice Number page with special characters in Starting Series Number field.")
	public void HMS6377() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.clk_editPOSLink();
		GenericClass.windowHandle(a);
		EPOS.fn_editPOSPrefix(iTestCaseRow);
		EPOS.fn_verifyAlert();
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-6377 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify "Cancel" button in Edit Pos Invoice Number paqe.
	 * @throws Throwable
	 */
	@Test(priority=54,groups={"P2","InvoiceNumbserSettingsTest"},description="To verify Cancel button in Edit Pos Invoice Number page.")
	public void HMS6378() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		String a=GenericClass.GetCurrentWindowID();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditPOSInvoiceNumber EPOS=INS.clk_editPOSLink();
		GenericClass.windowHandle(a);
		EPOS.fn_fillPOSDetails(iTestCaseRow);
		EPOS.fn_clkCancelBtn();
		//GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		System.out.println("HMS-6378 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify Page dropdown at bottom left corner in POS Point(s) section.
	 * @throws Throwable
	 */
	@Test(priority=55,groups={"P2","InvoiceNumbserSettingsTest"},description="To verify Page dropdown at bottom left corner in POS Point(s) section.")
	public void HMS6381() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		INS.verify_pageDropdown();
		INS.chk_PreviousEnablity();
		
		System.out.println("HMS-6381 Executed");
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
			throw e;
		}
	}
	
	
	/**
	 * To verify "View" records per page drop down under POS Point(s) title in Invoice Number Settings page.
	 * @throws Throwable
	 */
	@Test(priority=56,groups={"P2","InvoiceNumbserSettingsTest"},description="To verify View records per page drop down under POS Point(s) title in Invoice Number Settings page.")
	public void HMS6382() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		INS.verify_viewDropdown("5");
		
		System.out.println("HMS-6382 Executed");
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
			throw e;
		}
			
	}
	
	/**
	 * To verify Next link at bottom right corner under POS Point(s) section when message corresponding to 'Page' is 'of 1'.
	 * @throws Throwable
	 */
	@Test(priority=57,groups={"P2","InvoiceNumbserSettingsTest"},description="To verify Next link at bottom right corner under POS Point(s) section when message corresponding to 'Page' is 'of 1'.")
	public void HMS6383() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		INS.verify_nxtLnkEnability("5");
		
		System.out.println("HMS-6383 Executed");
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
			throw e;
		}
	}
	
	
	/**
	 * ﻿To verify Next link at bottom right corner under POS Point(s) section on the page when message corresponding to 'Page' is 'of 2'.
	 * @throws Throwable
	 */
	@Test(priority=58,groups={"P2","InvoiceNumbserSettingsTest"},description="To verify Next link at bottom right corner under POS Point(s) section on the page when message corresponding to 'Page' is 'of 2'.")
	public void HMS9171() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		
		INS.verify_nextLnk("1");
		
		System.out.println("HMS-9171 Executed");
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
			throw e;
		}
		
	}
	
	
	/**
	 * To verify Previous Link at bottom right corner on page when '1' is selected from the Page dropdown.
	 * @throws Throwable
	 */
	@Test(priority=59,groups={"P2","InvoiceNumbserSettingsTest"},description="To verify Previous Link at bottom right corner on page when '1' is selected from the Page dropdown.")
	public void HMS6387() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		INS.verify_PreviousLnkEnability("5");
		
		System.out.println("HMS-6387 Executed");
		
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
			throw e;
		}		
	}
	
	
	/**
	 * To verify Previous Link at bottom right corner under POS Point(s) section on the page when '2' is selected from the Page dropdown.
	 * @throws Throwable
	 */
	@Test(priority=60,groups={"P2","InvoiceNumbserSettingsTest"},description="To verify Previous Link at bottom right corner under POS Point(s) section on the page when '2' is selected from the Page dropdown.")
	public void HMS9172() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		INS.verify_previousLnk();
		
		System.out.println("HMS-9172 Executed");
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
			throw e;
		}
	}
	
	
	/**
	 * To verify whether 'No' is selected or not under Custom Setting section on Invoice Number Settings page.
	 * @throws Throwable
	 */
	@Test(priority=61,groups={"P1","InvoiceNumbserSettingsTest"},description="To verify whether 'No' is selected or not under Custom Setting section on Invoice Number Settings page.")
	public void HMS9173() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		boolean b=INS.verify_defaultCustomSetting();
		Assert.assertEquals(b, true);
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
			throw e;
		}
	}
	
	/**
	 * To change custom setting from NO to YES on Invoice Number Settings page.
	 * @throws Throwable
	 */
	@Test(priority=62,groups={"P0","InvoiceNumbserSettingsTest"},description="To change custom setting from NO to YES on Invoice Number Settings page.")
    public void HMS9174() throws Throwable
    {
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		INS.clk_YesRBCustomSetting();
		String a=INS.verify_saveMsg();
		Assert.assertEquals(a.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
        INS.clk_NoRBCustomSetting();
        
        System.out.println("HMS-9174 Executed");
        
        ExcelUtil.CloseAllExcelReferences();
		}
	
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
    }
	
	/**
	 * To verify "Audit Trail" text link in Invoice Number Settings page.
	 * 
	 * @throws Throwable
	 */
	@Test(priority=63,groups={"P0","InvoiceNumbserSettingsTest"},description="To verify Audit Trail text link in Invoice Number Settings page.")
	public void HMS6388() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");

		//AdminHome AH=AL.adminlogin_12485();
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	    ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_InvoiceNumberSettings,Constant.Sheet_InvoiceNumberSettings);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
       
		String a=GenericClass.GetCurrentWindowID();
		InvoiceNumberSettingsLP INS=AH.fn_NavigateInvNumSettingPage();
		EditFDInvoiceNumber EFD=INS.fn_clkFDEditLnk();
		GenericClass.windowHandle(a);
		EFD.fn_editFDPrefix(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		String b=GenericClass.GetCurrentWindowID();
		AuditTrailINS AT=INS.fn_clkAuditTrailLnk();
		GenericClass.windowHandle(b);
        AT.verify_pageHeader(iTestCaseRow);		
		AT.verify_ChangedHistory(iTestCaseRow);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(b);
		
		System.out.println("HMS-6388 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
			
		}		
	}
	
	
	
	
	@AfterMethod
	public void Close_Br()
	{		GenericClass.driver.close();
		 GenericClass.driver.quit();
	}
}
