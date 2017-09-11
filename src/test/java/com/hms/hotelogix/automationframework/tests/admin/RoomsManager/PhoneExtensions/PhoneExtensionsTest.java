package com.hms.hotelogix.automationframework.tests.admin.RoomsManager.PhoneExtensions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions.AddMultiplePhoneExtension;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions.AddPhoneExtension;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions.AuditTrailAddMultiplePE;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions.AuditTrailAddPE;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions.AuditTrailPELandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions.EditPhoneExtension;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions.PhoneExtensionsListPage;

public class PhoneExtensionsTest 
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
	    AL=GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow,  ExcelUtil.GetColumnIndex(Constant.Col_Browser)), "http://hotelogix.net/admine/login/login/");
	    //AL=GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, Constant.Col_Browser), "http://livestable.hx.local/admine/login/login/");

	    ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e )
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	 }


	
	/**
	 * Directing to 'Phone Extension List' page.
	 * @throws Throwable
	 */
	@Test(priority=1,groups={"P0","PhoneExtensionsTest"},description="Directing to 'Phone Extension List' page.")
	public void HMS8996() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		
		//AdminHome AH=AL.adminlogin_12485();
		
		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		String str=PELP.verify_pageHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		System.out.println("HMS-8996 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
		

	}
	
	
	/**
	 * Verify Title 
	 * @throws Throwable
	 */
	@Test(priority=2,groups={"P0","PhoneExtensionsTest"},description="Verify Title")
	public void HMS8998() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		
		System.out.println("HMS-8998 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 *  Verify elements on Phone Extension List Page
	 * @throws Throwable
	 */
	@Test(priority=3,groups={"P0","PhoneExtensionsTest"},description=" Verify elements on Phone Extension List Page")
	public void HMS8999() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		PELP.verify_pageElements();
		
		System.out.println("HMS-8999 Executed");
		
	
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
			throw e;
		}
	}
	
	
	/**
	 * To verify 'Add a Extension' button.
	 * @throws Throwable
	 */
	@Test(priority=4,groups={"P0","PhoneExtensionsTest"},description="To verify 'Add a Extension' button.")
	public void HMS9003() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		String str=APE.verify_pageHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		System.out.println("HMS-9003 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	
	/**
	 * Verify all elements on 'Add/Edit a Phone Extension' page.
	 * @throws Throwable
	 */
	@Test(priority=5,groups={"P0","PhoneExtensionsTest"},description=" Verify all elements on 'Add/Edit a Phone Extension' page.")
	public void HMS9004() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		APE.verify_pageElements(iTestCaseRow);
		
		System.out.println("HMS-9004 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	/**
	 * To verify 'Main' link on Add/Edit a Phone Extension page.
	 * @throws Throwable
	 */
	@Test(priority=6,groups={"P0","PhoneExtensionsTest"},description="To verify 'Main' link on Add/Edit a Phone Extension page.")
	public void HMS9020() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
        APE.fn_clkMain();
		String heading=AH.verify_pgeHeader();
		Assert.assertEquals(heading.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		System.out.println("HMS-9020 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	/**
	 * To verify 'Phone Extension List' link on Add/Edit a Phone Extension page.
	 * @throws Throwable
	 */
	@Test(priority=7,groups={"P0","PhoneExtensionsTest"},description="To verify 'Phone Extension List' link on Add/Edit a Phone Extension page.")
	public void HMS9021() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		APE.fn_clkPhoneExtsn();
		String str=PELP.verify_pageHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		System.out.println("HMS-9021 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	/**
	 * To verify Add a extension with valid data and Save with button at top right corner of the page.
	 * @throws Throwable
	 */
	@Test(priority=8,groups={"P0","PhoneExtensionsTest"},description="To verify Add a extension with valid data and Save with button at top right corner of the page.")
	public void HMS9009() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		APE.fn_validDataPhExtsn();
		String str=PELP.verify_saveMsg();
		Assert.assertEquals(str.equals("- Phone extension "+'"'+APE.PENum+'"'+" Saved Successfully"),true);
		PELP.verify_savedPhoneExtsn(APE.PENum,iTestCaseRow);
		
		System.out.println("HMS-9009 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify Add a extension with valid data and Save with button at end of the page.
	 * @throws Throwable
	 */
	@Test(priority=9,groups={"P0","PhoneExtensionsTest"},description="To verify Add a extension with valid data and Save with button at end of the page.")
	public void HMS9011() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		APE.fn_validDataPhExtsn1();
		Thread.sleep(3000);
		String str=PELP.verify_saveMsg();
		Assert.assertEquals(str.equals("- Phone extension "+'"'+APE.PENum+'"'+" Saved Successfully"),true);
		Thread.sleep(2000);
		PELP.verify_savedPhoneExtsn(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExtensionNumber)),iTestCaseRow);
		
		System.out.println("HMS-9011 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	/**
	 * To Add Phone Extension without entering data.
	 * @throws Throwable
	 */
	@Test(priority=10,groups={"P1","PhoneExtensionsTest"},description="To Add Phone Extension without entering data.")
	public void HMS9015() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		APE.fn_clkSave();
		String str=APE.verify_displayedMsg();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		System.out.println("HMS-9015 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Add Phone extension with duplicate data
	 * @throws Throwable
	 */
	@Test(priority=11,groups={"P1","PhoneExtensionsTest"},description="Add Phone extension with duplicate data")
	public void HMS9016() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		//PELP.fn_getPENum1();
		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		APE.fn_validDataPhExtsn1();
		PELP.fn_navigateToAddPhoneExtnsn();
	    APE.fn_addDuplicatePE(APE.PENum);
		String str=APE.verify_displayedMsg();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		
		System.out.println("HMS-9016 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Enter Extension Number only and Save.
	 * @throws Throwable
	 */
	@Test(priority=12,groups={"P0","PhoneExtensionsTest"},description="Enter Extension Number only and Save.")
	public void HMS9017() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		APE.fn_addPENumberOnly();
		String str=PELP.verify_saveMsg();
		Assert.assertEquals(str.equals("- Phone extension "+'"'+APE.PENum+'"'+" Saved Successfully"),true);
		PELP.verify_savedPhoneExtsn( ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExtensionNumber)),iTestCaseRow);
		
		System.out.println("HMS-9017 Executed");
	    
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify 'Cancel' button at the top right corner in Add/Edit a Phone Extension page.
	 * @throws Throwable
	 */
	@Test(priority=13,groups={"P2","PhoneExtensionsTest"},description="To verify 'Cancel' button at the top right corner in Add/Edit a Phone Extension page.")
	public void HMS9018() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		APE.addData_clkCancel(iTestCaseRow);
		String str=PELP.verify_pageHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		System.out.println("HMS-9018 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences(); 
			throw e;
		}
	}
	
	
	
	/**
	 * To verify 'Cancel' button at the end in Add/Edit a Phone Extension page.
	 * @throws Throwable
	 */
	@Test(priority=14,groups={"P2","PhoneExtensionsTest"},description="To verify 'Cancel' button at the end in Add/Edit a Phone Extension page.")
	public void HMS9019() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		APE.addData_clkCancel1(iTestCaseRow);
		String str=PELP.verify_pageHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		
		System.out.println("HMS-9019 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify 'Audit Trail' link on Add/Edit a Phone Extension page.
	 * @throws Throwable
	 */
	@Test(priority=15,groups={"P0","PhoneExtensionsTest"},description="To verify 'Audit Trail' link on Add/Edit a Phone Extension page.")
	public void HMS9022() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		APE.fn_addPENumberOnly();
		PELP.fn_navigateToAddPhoneExtnsn();
		String a=GenericClass.GetCurrentWindowID();
		AuditTrailAddPE ATA=APE.fn_clkAuditTrail();
		GenericClass.windowHandle(a);
		ATA.verify_ChangedHistory(iTestCaseRow,APE.PENum);
		GenericClass.driver.close();
		GenericClass.Switch_Parent_Window(a);
		
		System.out.println("HMS-9022 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify 'Add Multiple Extension(s)' link.
	 * @throws Throwable
	 */
	@Test(priority=16,groups={"P0","PhoneExtensionsTest"},description="To verify 'Add Multiple Extension(s)' link.")
	public void HMS9023() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		String str=AMPE.verify_pageHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		System.out.println("HMS9023 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
		
	}
	
	
	/**
	 * Verify elements on 'Add Multiple Phone Extensions' page.
	 * @throws Throwable
	 */
	@Test(priority=17,groups={"P0","PhoneExtensionsTest"},description="Verify elements on 'Add Multiple Phone Extensions' page.")
	public void HMS9024() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.verify_pageElements(iTestCaseRow);
		
		System.out.println("HMS-9024 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To Verify 'Main' link on Add Multiple Phone Extensions page.
	 * @throws Throwable
	 */
	@Test(priority=18,groups={"P0","PhoneExtensionsTest"},description="To Verify 'Main' link on Add Multiple Phone Extensions page.")
	public void HMS9057() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_clkMain();
		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		
		System.out.println("HMS9057 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify 'Phone Extension List' link on Add Multiple Phone Extensions page.
	 * @throws Throwable
	 */
	@Test(priority=19,groups={"P0","PhoneExtensionsTest"},description="To verify 'Phone Extension List' link on Add Multiple Phone Extensions page.")
	public void HMS9058() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_clkPhExtnLink();
		String str=PELP.verify_pageHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		System.out.println("HMS-9058 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Add Multiple extensions with extension names and save with button at top right corner of the page.
	 * @throws Throwable
	 */
	@Test(priority=20,groups={"P0","PhoneExtensionsTest"},description="Add Multiple extensions with extension names and save with button at top right corner of the page.")
	public void HMS9025() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_validData();
		AMPE.fn_clkTopSaveBtn();
		String str=PELP.verify_saveMultplExtsnMsg();
		Assert.assertEquals(str.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		PELP.fn_viewAll();
		PELP.verify_savedMultplPhExtsn(iTestCaseRow);
		
		System.out.println("HMS-9025 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Add Multiple extensions with extension names and save with button at end of the page.
	 * @throws Throwable
	 */
	@Test(priority=21,groups={"P0","PhoneExtensionsTest"},description="Add Multiple extensions with extension names and save with button at end of the page.")
	public void HMS9026() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_validData1();
		//AMPE.fn_clkBottomSaveBtn();
		String str=PELP.verify_saveMultplExtsnMsg();
		Assert.assertEquals(str.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		PELP.fn_viewAll();
		PELP.verify_savedMultplPhExtsn(iTestCaseRow);
		
		System.out.println("HMS-9026 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Add Multiple extensions with extension nos and save .
	 * @throws Throwable
	 */
	@Test(priority=22,groups={"P0","PhoneExtensionsTest"},description="Add Multiple extensions with extension nos and save .")
	public void HMS9027() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_addExtnNo(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_FromExtn_PE)),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ToExtn_PE)),iTestCaseRow);
		String str=PELP.verify_saveMultplExtsnMsg();
		Assert.assertEquals(str.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		PELP.fn_viewAll();
		PELP.verify_savedExtsnNo(iTestCaseRow);

		System.out.println("HMS-9027 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	
	/**
	 * To save Multiple Extensions without entering data. 
	 * @throws Throwable
	 */
	@Test(priority=23,groups={"P1","PhoneExtensionsTest"},description="To save Multiple Extensions without entering data.")
	public void HMS9046() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_clkTopSaveBtn();
		String str=AMPE.verify_displayedMsg();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		System.out.println("HMS-9046 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
		
	}
	
	
	/**
	 * Add Multiple rooms without data but Add Extension nos selected
	 * @throws Throwable
	 */
	@Test(priority=24,groups={"P1","PhoneExtensionsTest"},description="Add Multiple rooms without data but Add Extension nos selected")
	public void HMS9047() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_clkAddExtnNos();
		String str=AMPE.verify_displayedMsg();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		
		System.out.println("HMS-9047 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * To verify Adding Multiple Extensions with duplicate extension names.
	 * @throws Throwable
	 */
	@Test(priority=25,groups={"P1","PhoneExtensionsTest"},description="To verify Adding Multiple Extensions with duplicate extension names.")
	public void HMS9048() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();	
		//String PEName=GenericClass.generateRandomString();
		AMPE.fn_validData();
		AMPE.fn_clkBottomSaveBtn();
		PELP.fn_navigateToAddMultiplePhExtnsn();	
		AMPE.fn_duplicateExtnName(AMPE.PENum);
		AMPE.fn_clkBottomSaveBtn();
		String str=AMPE.verify_displayedMsg();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		
		System.out.println("HMS-9048 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Add Multiple extensions with duplicate Extension nos
	 * @throws Throwable
	 */
	@Test(priority=26,groups={"P1","PhoneExtensionsTest"},description="Add Multiple extensions with duplicate Extension nos")
	public void HMS9049() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		
		String PEFr=GenericClass.GenerateRandomNumber(2);
		Integer i=Integer.parseInt(PEFr)+1;
		String PETo=i.toString();
		
		AMPE.fn_addExtnNo(PEFr, PETo, iTestCaseRow);
		PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_addExtnNo(PEFr, PETo, iTestCaseRow);
		String str=AMPE.verify_displayedMsg();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		
		System.out.println("HMS-9049 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Add Multiple Extensions without 'To' field.
	 * @throws Throwable
	 */
	@Test(priority=27,groups={"P1","PhoneExtensionsTest"},description="Add Multiple Extensions without 'To' field.")
	public void HMS9050() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_addExtnNo(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_FromExtn_PE)), "", iTestCaseRow);
		String str=AMPE.verify_displayedMsg();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		
		System.out.println("HMS-9050 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Enter Extension To value less than Extension From Value and save multiple extensions.
	 * @throws Throwable
	 */
	@Test(priority=28,groups={"P1","PhoneExtensionsTest"},description="Enter Extension To value less than Extension From Value and save multiple extensions.")
	public void HMS9051() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		String PE1=GenericClass.GenerateRandomNumber(2);
		Integer a=Integer.parseInt(PE1)-1;
		String PE2=a.toString();
		
		AMPE.fn_addExtnNo(PE1, PE2, iTestCaseRow);
		String str=AMPE.verify_displayedMsg();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		
		System.out.println("HMS-9051 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Enter character value in Extension# and To field and save
	 * @throws Throwable
	 */
	@Test(priority=29,groups={"P1","PhoneExtensionsTest"},description="Enter character value in Extension# and To field and save")
	public void HMS9052() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_addExtnNo(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_FromExtn_PE)), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ToExtn_PE)), iTestCaseRow);
		String str=AMPE.verify_displayedMsg();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		
		System.out.println("HMS-9052 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Enter Extension Name only and save multiple extensions
	 * @throws Throwable
	 */
	@Test(priority=30,groups={"P1","PhoneExtensionsTest"},description="Enter Extension Name only and save multiple extensions")
	public void HMS9053() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_validData1();
		String str=PELP.verify_saveMultplExtsnMsg();
		Assert.assertEquals(str.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		PELP.fn_viewAll();
		PELP.verify_savedExtsnNo(iTestCaseRow);
		
		System.out.println("HMS-9053 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
	  }
	
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}
	
	
	/**
	 * Enter Extension No only and save multiple extensions
	 * @throws Throwable
	 */
	@Test(priority=31,groups={"P0","PhoneExtensionsTest"},description="Enter Extension No only and save multiple extensions")
    public void HMS9054() throws Throwable
    {
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_addExtnNo(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_FromExtn_PE)),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ToExtn_PE)),iTestCaseRow);
		String str=PELP.verify_saveMultplExtsnMsg();
		Assert.assertEquals(str.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		PELP.fn_viewAll();
		PELP.verify_savedExtsnNo(iTestCaseRow);
		
		System.out.println("HMS-9054 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
    }
    
    
    /**
     * To verify 'Cancel' button at the top right corner on Add Multiple Phone Extensions page.
     * @throws Throwable
     */
    @Test(priority=32,groups={"P2","PhoneExtensionsTest"},description="To verify 'Cancel' button at the top right corner on Add Multiple Phone Extensions page.")
    public void HMS9055() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_validData();
		AMPE.fn_clkTopCancelbtn();
		//String str=PELP.verify_pageTitle();
		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		System.out.println("HMS-9055 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
	
    
    /**
     * To verify 'Cancel' button at the end on Add Multiple Phone Extensions page.
     * @throws Throwable
     */
    @Test(priority=33,groups={"P1","PhoneExtensionsTest"},description="To verify 'Cancel' button at the end on Add Multiple Phone Extensions page.")
    public void HMS9056() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
		AMPE.fn_validData();
		AMPE.fn_clkBottomCancelbtn();
		//PELP.verify_pageTitle(iTestCaseRow);
		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		System.out.println("HMS-9056 Executed");
		ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    
    /**
     * To verify 'Audit Trail' link on Add Multiple Phone Extensions Page.
     * @throws Throwable
     */
    @Test(priority=34,groups={"P0","PhoneExtensionsTest"},description="To verify 'Audit Trail' link on Add Multiple Phone Extensions Page.")
    public void HMS9059() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
        AMPE.fn_validData();
        AMPE.fn_clkBottomSaveBtn();
        PELP.fn_navigateToAddMultiplePhExtnsn();
        String a=GenericClass.GetCurrentWindowID();
        AuditTrailAddMultiplePE ATMPE=AMPE.fn_clkAuditTrailLnk();
        GenericClass.windowHandle(a);
        ATMPE.verify_ChangedHistory(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)),AMPE.PENum);
        GenericClass.driver.close();
        GenericClass.Switch_Parent_Window(a);
        
        System.out.println("HMS-9059 Execuetd");
		
		ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    /**
     * To verify Delete Selected Extension(s) button.
     * @throws Throwable
     */
    @Test(priority=35,groups={"P1","PhoneExtensionsTest"},description="To verify Delete Selected Extension(s) button.")
    public void HMS9060() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		APE.fn_validDataPhExtsn();
		PELP.fn_verifyDeletePEPopup(APE.PENum);
		
		System.out.println("HMS-9060 Executed");
		
        ExcelUtil.CloseAllExcelReferences();        
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    /**
     * Delete a phone extension
     * @throws Throwable
     */
    @Test(priority=36,groups={"P1","PhoneExtensionsTest"},description="Delete a phone extension")
    public void HMS9061() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
		APE.fn_validDataPhExtsn();
		PELP.fn_DeletePEPopupAccept(APE.PENum);
		String str=PELP.fn_verifyDeletePEAcceptMsg();
		Assert.assertEquals(str.equals("- Phone extension Number(s) "+'"'+APE.PENum+'"'+" deleted Successfully"), true);
		PELP.fn_viewAll();
		PELP.fn_verifyDeletedPE(APE.PENum);
		
		System.out.println("HMS-9061 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    /**
     * Cancel deleting a Phone Extension.
     */
    @Test(priority=37,groups={"P1","PhoneExtensionsTest"},description="Cancel deleting a Phone Extension.")
    public void HMS9062() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		PELP.fn_clkDeletePEPopupCancel();
		//PELP.verify_pageTitle(iTestCaseRow);
		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		PELP.fn_viewAll();
		PELP.fn_verifyDeleteCancelClk();
		
		System.out.println("HMS-9062 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    /**
     * To verify 'Cancel' button on Phone Extension List page.
     * @throws Throwable
     */
    @Test(priority=38,groups={"P0","PhoneExtensionsTest"},description="To verify 'Cancel' button on Phone Extension List page.")
    public void HMS9063() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		PELP.fn_clkCancelBtn();
		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		
		System.out.println("HMS-9063 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    /**
     * Select all extensions
     * @throws Throwable
     */
    @Test(priority=39,groups={"P1","PhoneExtensionsTest"},description="Select all extensions")
    public void HMS9064() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		PELP.fn_selectIndividualCB();
		PELP.fn_verifySelect();
		
		System.out.println("HMS-9064 Executed");

    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
	
    /**
     * Deselect all Extensions on Phone Extension List page.
     * @throws Throwable
     */
    @Test(priority=40,groups={"P1","PhoneExtensionsTest"},description="Deselect all Extensions on Phone Extension List page.")
    public void HMS9065() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		PELP.fn_viewAll();
		PELP.fn_selectIndividualCB();
		PELP.fn_deselectIndividualCB();
		PELP.fn_verifyDeselect();
		
		System.out.println("HMS-9065 Executed");
        
		
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		
    		throw e;
    	}
    }
    
    /**
     * To verify Edit link in Phone Extension List
     * @throws Throwable
     */
    @Test(priority=41,groups={"P0","PhoneExtensionsTest"},description="To verify Edit link in Phone Extension List")
    public void HMS9066() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		//AdminHome AH=AL.adminlogin_12485();

		PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		EditPhoneExtension EPE=PELP.fn_clkEditBtn();
		String str=EPE.verify_pageHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

		System.out.println("HMS-9066 Executed");
		
		ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    
    /**
     * To Edit a Phone Extension
     * @throws Throwable
     */
    @Test(priority=42,groups={"P0","PhoneExtensionsTest"},description="To Edit a Phone Extension")
    public void HMS9067() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    			
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    	
    	AddPhoneExtension APE=PELP.fn_navigateToAddPhoneExtnsn();
    	//String PE=GenericClass.GenerateRandomNumber(2);
    	APE.fn_validDataPhExtsn();
    	EditPhoneExtension EPE=PELP.fn_EditPE(APE.PENum+1);
    	EPE.fn_EditPENum(APE.PENum+1);
    	String str=PELP.verify_saveMsg();
		Assert.assertEquals(str.equals("- Phone extension "+'"'+APE.PENum+1+'"'+" Saved Successfully"),true);
    	PELP.fn_viewAll();
    	PELP.verify_savedPhoneExtsn(APE.PENum+1,iTestCaseRow);
    	
    	System.out.println("HMS-9067 Executed");
    	
    	ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    		
    	}
    	
    			
    }
    
    
    /**
     * Deactivate an Extension
     * @throws Throwable
     */
    @Test(priority=43,groups={"P0","PhoneExtensionsTest"},description="Deactivate an Extension")
    public void HMS9068() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    			
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    	
    	PELP.fn_viewAll();
    	PELP.fn_verifyDeactiveStatus(iTestCaseRow);
    	
    	System.out.println("HMS-9068 Executed");
    	
    	ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    /**
     * Activate an Extension
     * @throws Throwable
     */
    @Test(priority=44,groups={"P0","PhoneExtensionsTest"},description="Activate an Extension")
    public void HMS9069() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    			
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    	
    	PELP.fn_viewAll();
    	PELP.fn_verifyActiveStatus(iTestCaseRow);
    	
    	System.out.println("HMS-9069 Executed");
    	
    	ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    /**
     * Sort by Status with downward arrow.
     * @throws Throwable
     */
    @Test(priority=49,groups={"P1","PhoneExtensionsTest"},description="Sort by Status with downward arrow.")
    public void HMS9074() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    			
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    	
    	PELP.sortStatus_DownwardArrowClk(iTestCaseRow);
    	
    	System.out.println("HMS-9074 Executed");
    	
    	ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    
    @Test(priority=50,groups={"P1","PhoneExtensionsTest"},description="Sort by Status with upward arrow.")
    public void HMS9075() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    			
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    	
    	PELP.sortStatus_UpwardArrowClk(iTestCaseRow);
    	
    	System.out.println("HMS-9075 Executed");
    	
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
     * To verify 'Save Selected' button.
     * @throws Throwable
     */
    @Test(priority=51,groups={"P2","PhoneExtensionsTest"},description="To verify 'Save Selected' button.")
    public void HMS9076() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    			
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    	
    	PELP.fn_clkSaveSelectedBtn();
    	
		String str=PELP.verify_saveMultplExtsnMsg();
		Assert.assertEquals(str.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

    	
    	System.out.println("HMS-9076 Executed");
    	
    	ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    	
    }
    
    
    /**
     * To save Room and Department for an extension
     * @throws Throwable
     */
    @Test(priority=52,groups={"P1","PhoneExtensionsTest"},description="To save Room and Department for an extension")
    public void HMS9077() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    			
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    	
    	PELP.fn_verifyPEPresence(iTestCaseRow);
    	PELP.fn_clkSaveSelectedBtn();
    	PELP.fn_verifySaveSelectedMsg(iTestCaseRow);
    	
    	System.out.println("HMS-9077 Executed");
    	
    	ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    /**
     * Verify 'Main' link on Phone Extension list page.
     * @throws Throwable
     */
    @Test(priority=53,groups={"P0","PhoneExtensionsTest"},description="Verify 'Main' link on Phone Extension list page.")
    public void HMS9078() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    			
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    	
    	PELP.fn_clkMainLnk();
		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
    	
    	System.out.println("HMS-9078 Executed");
    	
    	ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    	
    }
    
    /**
     * To Verify 'View' dropdown at the bottom center on Phone Extension List page
     * @throws Throwable
     */
    @Test(priority=54,groups={"P2","PhoneExtensionsTest"},description="To Verify 'View' dropdown at the bottom center on Phone Extension List page")
    public void HMS9079() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    	PELP.fn_verifyViewDropdown("1");
    	
    	System.out.println("HMS-9079 Executed");
    	
    
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		
    		throw e;
    	}
    }
    
    
    /**
     * To verify Page drop down at bottom left corner on Phone Extension List page.
     * @throws Throwable
     */
    @Test(priority=55,groups={"P2","PhoneExtensionsTest"},description="To verify Page drop down at bottom left corner on Phone Extension List page.")
    public void HMS9080() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    	
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    	
    	PELP.verify_pageDropdown(iTestCaseRow);
    	
    	System.out.println("HMS-9080 Executed");
    	
    	ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    /**
     * To verify Next link at bottom right corner on Phone Extension list page when message corresponding to 'Page' is 'of 1'.
     * @throws Throwable
     */
    @Test(priority=56,groups={"P2","PhoneExtensionsTest"},description="To verify Next link at bottom right corner on Phone Extension list page when message corresponding to 'Page' is 'of 1'.")
    public void HMS9081() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    	
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    	
    	PELP.fn_verifyDisabledNextLnk(iTestCaseRow);
    	
    	System.out.println("HMS-9081 Executed");
    	
    	ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    /**
     * To verify Next link at bottom right corner on Phone Extension List page when message corresponding to 'Page' is 'of 2'.
     * @throws Throwable
     */
    @Test(priority=57,groups={"P2","PhoneExtensionsTest"},description="To verify Next link at bottom right corner on Phone Extension List page when message corresponding to 'Page' is 'of 2'.")
    public void HMS9082() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

        PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    	
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    	
    	PELP.verify_nextLnk(iTestCaseRow);
    	
    	System.out.println("HMS-9082 Executed");
    	
    	ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    /**
     * To verify Previous Link at bottom right corner on Phone extension List page when '1' is selected from the Page dropdown.
     * @throws Throwable
     */
    @Test(priority=58,groups={"P2","PhoneExtensionsTest"},description="To verify Previous Link at bottom right corner on Phone extension List page when '1' is selected from the Page dropdown.")
    public void HMS9083() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

    	PELP.fn_clkPreviousLnk(iTestCaseRow);
    	
    	System.out.println("HMS-9083 Executed");
   
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
    		throw e;
    	}
    }
    
    
    
    /**
     * To verify Previous Link at bottom right corner on Phone Extension List page when '2' is selected from the Page dropdown.
     * @throws Throwable
     */
    @Test(priority=59,groups={"P2","PhoneExtensionsTest"},description="To verify Previous Link at bottom right corner on Phone Extension List page when '2' is selected from the Page dropdown.")
    public void HMS9084() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    	PELP.fn_verifyDisabledPreviousLnk(iTestCaseRow);
    	
    	System.out.println("HMS-9084 Executed");
    	
    	ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }
    
    
    /**
     * To verify Audit Trail link in Phone Extension List page.
     * @throws Throwable
     */
    @Test(priority=60,groups={"P0","PhoneExtensionsTest"},description="To verify Audit Trail link in Phone Extension List page.")
    public void HMS9085() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    	//AdminHome AH=AL.adminlogin_12485();

    	PhoneExtensionsListPage PELP=AH.fn_NavigateToPhoneExtPage();
    			
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_PhoneExtensions,Constant.Sheet_PhoneExtensions);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    	AddMultiplePhoneExtension AMPE=PELP.fn_navigateToAddMultiplePhExtnsn();
    	AMPE.fn_validData();
    	AMPE.fn_clkBottomSaveBtn();
    	String a=GenericClass.GetCurrentWindowID();
    	AuditTrailPELandingPage ATLP=PELP.fn_clkAuditTrail();
    	GenericClass.windowHandle(a);
    	ATLP.verify_ChangedHistory(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)),AMPE.PENum);
    	GenericClass.driver.close();
    	GenericClass.Switch_Parent_Window(a);
    	
    	System.out.println("HMS-9085 Executed");
    	
    	ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
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
