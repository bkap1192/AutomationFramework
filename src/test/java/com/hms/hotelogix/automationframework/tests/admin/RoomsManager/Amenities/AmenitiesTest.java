package com.hms.hotelogix.automationframework.tests.admin.RoomsManager.Amenities;

import java.util.concurrent.TimeUnit;

import javax.media.rtp.rtcp.Report;

import org.apache.poi.util.SystemOutLogger;
import org.jboss.netty.util.internal.SystemPropertyUtil;
import org.monte.media.anim.AmigaCAMGMainx;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities.AddAmenitiesAT;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities.AddAmenity;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities.AmenitiesFileUpload;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities.AmenitiesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities.AuditTrailALP;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities.EditAmenity;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities.ViewImage_Class;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.AddRoomTypePage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.EditRoomType;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.RoomTypesLandingPage;

public class AmenitiesTest {


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
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Amenities,Constant.Sheet_Amenities);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	    AL=GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow,  ExcelUtil.GetColumnIndex(Constant.Col_Browser)), "http://hotelogix.net/admine/login/login/");

	    ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	 }




	/**
	 * To Navigate on the Amenities Page
	 * @throws Throwable
	 */

	@Test(priority=1,groups={"P0","AmenitiesTest"},description="To Navigate on the Amenities Page.")
	public void HMS8175() throws Throwable
	{

		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Amenities,Constant.Sheet_Amenities);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

	    String text=ALP.fn_verifyPageHeader();
        Assert.assertEquals(text.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
	    System.out.println("HMS-8175 Executed");

	    Reporter.log("When 'AMENITIES' is clicked under 'ROOMS MANAGER' tab, user gets redirected to 'Amentiies List' page.",true);

	    ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


	/**
	 * To verify Title of the Amenities page
	 * @throws Throwable
	 */

	@Test(priority=2,groups={"P0","AmenitiesTest"},description="To verify Title of the Amenities page")
    public void HMS1486() throws Throwable
    {
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Amenities,Constant.Sheet_Amenities);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

	    Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

	    System.out.println("HMS-1486 Executed");

	    Reporter.log("When 'AMENITIES' is clicked under 'ROOMS MANAGER' tab, 'Amentiies List' gets displayed in window's title bar.",true);

	    ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
    }



    /**
     * To verify the presence of links and buttons on 'Amenities List' page
     * @throws Throwable
     */

	@Test(priority=3,groups={"P0","AmenitiesTest"},description="To verify the presence of links and buttons on 'Amenities List' page")
	public void HMS8817() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	    ALP.fn_verifyAmenitiesElements();

	    System.out.println("HMS-8817 Executed");

	    Reporter.log("When user gets redirected to 'Amenities List' page, all page elements are getting displayed.",true);

		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		
			throw e;
		}
	}


	/**
	 * To verify navigation of 'Add An Amenity' link button on Amenities list page.
	 * @throws Throwable
	 */

	@Test(priority=4,groups={"P0","AmenitiesTest"},description="To verify navigation of 'Add An Amenity' link button on Amenities list page.")
	public void HMS1492() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Amenities,Constant.Sheet_Amenities);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

	    AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();
	    String str=AEP.fn_verifyPageHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

	    System.out.println("HMS-1492 Executed");

	    Reporter.log("When 'ADD AN AMENITY' button on 'Amenities List' page is clicked, system navigates to 'Add/Edit Amenity' page",true);

	    ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}



    /**
     * Verify the title of the page after clicking 'Add an Amenity' button
     * @throws Throwable
     */


	@Test(priority=5,groups={"P0","AmenitiesTest"},description="Verify the title of the page after clicking 'Add an Amenity' button")
	public void HMS8840() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

	    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Amenities,Constant.Sheet_Amenities);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

		System.out.println("HMS-8840 Executed");

		Reporter.log("When 'ADD AN AMENITY' button on 'Amenities List' page is clicked, system navigates to page with title as :'Add Amenity' .",true);

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


    /**
     * Checking Element on "Add/Edit Amenity" page.
     * @throws Throwable
     */
	@Test(priority=6,groups={"P1","AmenitiesTest"},description="Checking Element on Add/Edit Amenity page.")
	public void HMS5812() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	    AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();
	    AEP.fn_verifyPageElements();

	    System.out.println("HMS-5812 Executed");

	    Reporter.log("When user gets redirected to 'Add/Edit Amenity' page, all page elements are getting displayed.",true);

		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		
			throw e;		}
	}



	/**
	 * To verify the functionality of SAVE button on the page.
	 * @throws Throwable
	 */
	@Test(priority=7,groups={"P0","AmenitiesTest"},description="To verify the functionality of SAVE button on the page.")
	public  void HMS8052() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

		String sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();
		AEP.AddAnAminity_WithoutImage();
		String msg=ALP.alertTextMessage();
		Assert.assertEquals(msg, "- Amenity "+'"'+AEP.amntyName+'"'+" Saved Successfully");
		ALP.checkAmenitiesInList(AEP.amntyName);
		RoomTypesLandingPage RLP=AH.fn_NavigateRoomTypes();
		EditRoomType ERT=RLP.fn_EditRoomtype();
		ERT.fn_verifySavedAmenity(AEP.amntyName);
		ERT.roomTypeListLink_AddRoomTypePage();
        AddRoomTypePage ART=RLP.fn_NavigateAddRoomTypes();
        ART.fn_verifySavedAmenity(AEP.amntyName);

        System.out.println("HMS-8052 Executed");

		Reporter.log("On saving amenity,system displays 'Amenities List' page with message as :'- Amenity XXX Saved Successfully'.Saved amenity gets displayed on:\n"
				+"Amenities List, Edit Room Type and Add Room Type page",true);

        ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}




	/**
	 * To verify whether duplicate Amenity added or not in the system.
	 * @throws Throwable
	 */
    @Test(priority=8,groups={"P1","AmenitiesTest"},description="To verify whether duplicate Amenity added or not in the system.")
    public void HMS8841() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

    	String sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    	ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);


		AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();
		AEP.AddAnAminity_WithoutImage();
		ALP.fn_NavigatetoAddAmenity();
		AEP.fn_DuplicateAmenityDetails(AEP.amntyName);
		String str=AEP.fn_verifyDuplicateMsg();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		System.out.println("HMS-8841 Executed");

		Reporter.log("When duplicate amenity is added and saved,system displays message as:\n"
				+"Following ERRORS occurred during submission! - Duplicate Amenity Title",true);

		ExcelUtil.CloseAllExcelReferences();

    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }

    /**
     * 	To verify "ADD AN AMENITY" without data.
     * @throws Throwable
     */
    @Test(priority=9,groups={"P1","AmenitiesTest"},description="To verify ADD AN AMENITY without data.")
    public void HMS1488() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

    	String sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);


		AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();
		String str=AEP.fn_verifyWithoutData();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		System.out.println("HMS-1488 Executed");

		Reporter.log("When no detail is entered on 'Add/Edit Amenity' page and 'Save' button is clicked, system displays error messgae as :\n "
				+"Following ERRORS occurred during submission! - Please enter the Amenity Title.",true);

		ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }


    /**
     * To verify Add An Amenity with details,description and image.
     * @throws Throwable
     */
    @Test(priority=10,groups={"P0","AmenitiesTest"},description="To verify Add An Amenity with details,description and image.")
	public void HMS5839() throws Throwable
	{
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

        sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

        ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
		String str=ALP.alertTextMessage();
		Assert.assertEquals(str.equals("- Amenity "+'"'+AEP.amntyName+'"'+" Saved Successfully"), true);		
		ALP.checkAmenitiesInList(AEP.amntyName);
		RoomTypesLandingPage RLP=AH.fn_NavigateRoomTypes();
		EditRoomType ERT=RLP.fn_EditRoomtype();
		ERT.fn_verifySavedAmenity(AEP.amntyName);
		ERT.roomTypeListLink_AddRoomTypePage();
        AddRoomTypePage ART=RLP.fn_NavigateAddRoomTypes();
        ART.fn_verifySavedAmenity(AEP.amntyName);

		System.out.println("HMS-5839 Executed");

		Reporter.log("On saving amenity with title,description and image,system displays 'Amenities List' page with message as :'- Amenity XXX Saved Successfully'.Saved amenity gets displayed on:\n"
				+"Amenities List, Edit Room Type and Add Room Type page",true);

		ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
   }


    /**
     * To verify 'SAVE' button located on the top right corner of the page.
     * @throws Throwable
     */
	@Test(priority=11,groups={"P0","AmenitiesTest"},description="To verify 'SAVE' button located on the top right corner of the page.")
	public void HMS5840() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

        ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AEP.fn_verifySaveRTBtn(iTestCaseRow);
		String str=ALP.alertTextMessage();
		Assert.assertEquals(str.equals("- Amenity "+'"'+AEP.amntyName+'"'+" Saved Successfully"), true);		
        RoomTypesLandingPage RLP=AH.fn_NavigateRoomTypes();
        EditRoomType ERT=RLP.fn_EditRoomtype();
		ERT.fn_verifySavedAmenity(AEP.amntyName);
		ERT.roomTypeListLink_AddRoomTypePage();
        AddRoomTypePage ART=RLP.fn_NavigateAddRoomTypes();
        ART.fn_verifySavedAmenity(AEP.amntyName);

		System.out.println("HMS-5840 Executed");

		Reporter.log("On entering title,description and image and clicking 'Save' buton at top right corner,system displays 'Amenities List' page with message as :'- Amenity XXX Saved Successfully'.Saved amenity gets displayed on:\n"
				+"Amenities List, Edit Room Type and Add Room Type page",true);
		
		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
		
		
	}


	    /**
	    * To verify Image size in  Add/Edit Amenity Page
	    * @throws Throwable
	    */
	   @Test(priority=12,groups={"P1","AmenitiesTest"},description="To verify Image size in  Add/Edit Amenity Page")
	   public void HMS1500() throws Throwable
	   {
		   try
		   {
		   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		   AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

		   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		   ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

		   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		   AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
			String str=ALP.alertTextMessage();
			Assert.assertEquals(str.equals("- Amenity "+'"'+AEP.amntyName+'"'+" Saved Successfully"), true);		
	   	   ALP.checkAmenitiesInList(AEP.amntyName);

	   	   System.out.println("HMS-1500 Executed");

	   	   Reporter.log("On saving amenity with image of size less than 100kb,system successfully saves it and displays message as :\n"
	   			   +"'- Amenity XXX Saved Successfully'.",true);

	   	   ExcelUtil.CloseAllExcelReferences();
		   }
		   catch(Throwable e)
		   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			   throw e;
		   }
	   }


	   /**
	    * To verify Upload image more than 100kb
	    * @throws Throwable
	    */
	   @Test(priority=13,groups={"P1","AmenitiesTest"},description="To verify Upload image more than 100kb")
	   public void HMS1502() throws Throwable
	   {
		   try
		   {
		   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		   AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

		   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		   ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

		   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		   AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
			String str=ALP.alertTextMessage();
			Assert.assertEquals(str.equals("- Amenity "+'"'+AEP.amntyName+'"'+" Saved Successfully"), true);		
	   	   ALP.checkAmenitiesInList(AEP.amntyName);

		   System.out.println("HMS-1502 Executed");

		   Reporter.log("On saving amenity with image of size more than 100kb,system successfully automatically reduces its size and saves it.It displays message as :\n"
				   +"'- Amenity XXX Saved Successfully'.",true);

		   ExcelUtil.CloseAllExcelReferences();
		   }
		   catch(Throwable e)
		   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			   throw e;
		   }
	   }


	   /**
	    * To verify Upload image with valid format.
	    * @throws Throwable
	    */
	   @Test(priority=14,groups={"P1","AmenitiesTest"},description="To verify Upload image with valid format.")
	   public void HMS5833() throws Throwable
	   {
		   try
		   {
		   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		   AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

		   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		   ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

		   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		   AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
			String str=ALP.alertTextMessage();
			Assert.assertEquals(str.equals("- Amenity "+'"'+AEP.amntyName+'"'+" Saved Successfully"), true);		
	   	   ALP.checkAmenitiesInList(AEP.amntyName);


		   System.out.println("HMS-5833 Executed");

		   Reporter.log("On uploading image with valid format (bmp,jpeg,gif,png,tiff,webp,rif,exif)  and saving it,system saves it successfully and displays message as :\n "
				   +"'- Amenity XXX Saved Successfully'.",true);

		   ExcelUtil.CloseAllExcelReferences();
		   }
		   catch(Throwable e)
		   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			   throw e;

		   }
	   }


	   /**
	    * To verify Upload image with invalid format.
	    * @throws Throwable
	    */
	   @Test(priority=15,groups={"P2","AmenitiesTest"},description="To verify Upload image with invalid format.")
	   public void HMS8826() throws Throwable
	   {
		   try
		   {
		   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		   AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

		   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		   ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

		   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		   AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
			String str=ALP.alertTextMessage();
			Assert.assertEquals(str.equals("- Amenity "+'"'+AEP.amntyName+'"'+" Saved Successfully"), true);		
	   	   ALP.checkAmenitiesInList(AEP.amntyName);


	   	   System.out.println("HMS-8826 Executed");

	   	   //..Log

	   	   Reporter.log("According to test case, system should not allow upload of image with an invalid format while creating amenity and should display a validation message."
	   	   		+ "But system is not working according to the test case",true);

           ExcelUtil.CloseAllExcelReferences();
		   }
		   catch(Throwable e)
		   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			   throw e;
		   }

	   }




	/**
	 * To verify the functionality of cancel button on the top right of page.
	 * @throws Throwable
	 */
	@Test(priority=16,groups={"P2","AmenitiesTest"},description="To verify the functionality of cancel button on the top right of page.")
	public void HMS5819() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		//AddEdit_Amenity AEP=ALP.fn_NavigatetoAddEdit_Amenity();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditAmenity EAP=ALP.fn_clkEdit();
    	EAP.fn_editCancelRT();
		String str=ALP.fn_verifyPageHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		ALP.fn_verifyCancelRTBtn(EAP.amntyName,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));

		System.out.println("HMS-5819 Executed");

		Reporter.log("On entering amenity's mandatory details and clicking 'Cancel' button at top right corner,system displays 'Amenities List' page and amenity does not get saved.",true);

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}



	/**
	 * To verify "CANCEL" button functionality on Add/Edit  Amenity page.
	 * @throws Throwable
	 */
	@Test(priority=17,groups={"P2","AmenitiesTest"},description="To verify CANCEL button functionality on Add/Edit  Amenity page.")
	public void HMS5815() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AEP.fn_cancelBtn(iTestCaseRow);
		String str=ALP.fn_verifyPageHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		ALP.fn_verifyCancelRTBtn(AEP.amntyName,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));

		System.out.println("HMS-5815 Executed");

		Reporter.log("When 'Cancel' button is clicked after entering amenity's mandatory details,system navigates to 'Amenities List' page and amenity does not get saved.",true);

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


	/**
	 * To verify "Main" link in Add/Edit Amenity Page
	 * @throws Throwable
	 */
	@Test(priority=18,groups={"P1","AmenitiesTest"},description="To verify Main link in Add/Edit Amenity Page")
	public void HMS1493() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AEP.fn_clkMain();
		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

		System.out.println("HMS-1493 Executed");

		Reporter.log("On clicking 'Main' link on 'Add/Edit Amenity' page,system nab=vigates to Admine Home page. ",true);

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


	/**
	 * Verifying Amenities List link on Add/Edit Amenity page.
	 * @throws Throwable
	 */
	@Test(priority=19,groups={"P1","AmenitiesTest"},description="Verifying Amenities List link on Add/Edit Amenity page.")
    public void HMS8054() throws Throwable
    {
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AEP.fn_clkAmenitiesList();
		String str=ALP.fn_verifyPageHeader();
        Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		System.out.println("HMS-8054 Executed");

		Reporter.log("On clicking 'Amenities List' link on 'Add/Edit Amenity' page,system navigates to 'Amenities List' page.",true);

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
    }



    /**
     * To verify Audit Trail Link in Add/Edit Amenity Page
     * @throws Throwable
     */
	@Test(priority=20,groups={"P0","AmenitiesTest"},description="To verify Audit Trail Link in Add/Edit Amenity Page")
	public void HMS1494() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		AddAmenity AAP=ALP.fn_NavigatetoAddAmenity();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AAP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
        ALP.fn_NavigatetoAddAmenity();
        String a=GenericClass.GetCurrentWindowID();
        AddAmenitiesAT AT=AAP.fn_clkAuditTrail();
        GenericClass.windowHandle(a);
        String str=AT.fn_verifyHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
        AT.fn_verifyChangeHistory(AAP.amntyName);
        GenericClass.driver.close();
        GenericClass.Switch_Parent_Window(a);

        System.out.println("HMS-1494 Executed");

        Reporter.log("On clicking 'Audit Trail' link on 'Add/Edit Amenity' page,,system displays 'Audit Trail - Amenities' window and shows changed history.",true);

        ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


	/**
	 * To verify pop up while deleting Amenities.
	 * @throws Throwable
	 */
	@Test(priority=21,groups={"P2","AmenitiesTest"},description="To verify pop up while deleting Amenities.")
	public void HMS1495() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		ALP.fn_verifyDeletePopup(iTestCaseRow);

        System.out.println("HMS-1495 Executed");

        Reporter.log("When 'DELETE SELECTED AMENITIES' button is clicked,system displays an alert with message as:\n"
        		+"'Do you really want to delete the selected records?' with an 'OK' and 'Cancel' buttons.",true);

        ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}



	/**
	 * To verify Cancel Button of pop up while deleting Amenity.
	 * @throws Throwable
	 */
	@Test(priority=22,groups={"P2","AmenitiesTest"},description="To verify Cancel Button of pop up while deleting Amenity.")
	public void HMS8058() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		ALP.fn_verifyDeleteDismiss();

		System.out.println("HMS-8058 Executed");

		Reporter.log("When 'Cancel' button of 'DELETE SELECTED AMENITIES' pop-up is clicked,pop-up gets closed and selected amenity(s) does not gets deleted from the list."
				+"The selected checkbox corresponding to the amenity being deleted also remains checked.",true);

		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;			
		}
	}



	/**
	 * To verify amenity is deleted while pressing OK button on the pop up when it is available for the Room Type.
	 * @throws Throwable
	 */
	@Test(priority=23,groups={"P1","AmenitiesTest"},description="To verify amenity is deleted while pressing OK button on the pop up when it is available for the Room Type.")
	public void HMS8059() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

        ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

        AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
        ALP.fn_viewAll();
        ALP.fn_verifyDeleteAccept(AEP.amntyName);
        String str=ALP.fn_verifyDeleteMsg();
        Assert.assertEquals(str.equals("- Amenities "+'"'+AEP.amntyName+'"'+" deleted Successfully"),true);
        ALP.fn_verifyCancelRTBtn(AEP.amntyName,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
        RoomTypesLandingPage RLP=AH.fn_NavigateRoomTypes();
        AddRoomTypePage ARP=RLP.fn_NavigateAddRoomTypes();
        ARP.fn_verifyDeletedAmenity(AEP.amntyName);
        ARP.clk_RoomTypeListLink();
        EditRoomType ERT=RLP.fn_EditRoomtype();
        ERT.fn_verifyDeletedAmenitySelect(AEP.amntyName);

        System.out.println("HMS-8059 Executed");

        Reporter.log("When 'OK' button of 'DELETE SELECTED AMENITIES' for amenity which is not selected for any room type,selected amenity(s) gets deleted and system displays message as:"
        		+"- Amenities "+'"'+"XXX"+'"'+" deleted Successfully",true);

        ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}

	}


	/**
	 * To verify amenity is deleted while pressing OK button on the pop up when it is selected in Room Type.
	 * @throws Throwable
	 */
	@Test(priority=24,groups={"P1","AmenitiesTest"},description="To verify amenity is deleted while pressing OK button on the pop up when it is selected in Room Type.")
	public void HMS9088() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
		AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

        ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

        AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
        RoomTypesLandingPage RLP=AH.fn_NavigateRoomTypes();
        EditRoomType ERT=RLP.fn_EditRoomtype();
        ERT.fn_SelectAmenity(AEP.amntyName);
        ERT.fn_clickSave();
        AH.fn_NavigateAmenities();
        ALP.fn_viewAll();
        ALP.fn_verifyDeleteAccept(AEP.amntyName);
        String str=ALP.fn_verifyDeleteMsg();
        Assert.assertEquals(str.equals("- Amenities "+'"'+AEP.amntyName+'"'+" deleted Successfully"),true);
        ALP.fn_verifyCancelRTBtn(AEP.amntyName,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
        AH.fn_NavigateRoomTypes();
        AddRoomTypePage ART=RLP.fn_NavigateAddRoomTypes();
        ART.fn_verifyDeletedAmenity(AEP.amntyName);
        ART.clk_RoomTypeListLink();
        RLP.fn_EditRoomtype();
        ERT.fn_verifyDeletedAmenitySelect(AEP.amntyName);

        System.out.println("HMS-9088 Executed");

        Reporter.log("When 'OK' button of 'DELETE SELECTED AMENITIES' for amenity which has been selected for any room type,selected amenity(s) gets deleted and system displays message as:"
        		+"- Amenities "+'"'+"XXX"+'"'+" deleted Successfully",true);

        ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{ GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}

	}


	/**
	 * To verify "CANCEL" Button on Amenities List page
	 * @throws Throwable
	 */
   @Test(priority=25,groups={"P2","AmenitiesTest"},description="To verify CANCEL Button on Amenities List page")
   public void HMS1496() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	   ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

	   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

	   ALP.fn_CancelBtnClk();
		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

	   System.out.println("HMS-1496 Executed");

       Reporter.log("On clicking 'CANCEL' button,system navigates to Administrator Console page.",true);

       ExcelUtil.CloseAllExcelReferences();
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }
   }


   /**
    * To verify 'Main' link on 'Amenities List' page.
    * @throws Throwable
    */
   @Test(priority=26,groups={"P1","AmenitiesTest"},description="To verify 'Main' link on 'Amenities List' page.")
   public void HMS8823() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	   ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

	   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

	   ALP.fn_mainLink();
		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

	   System.out.println("HMS-8823 Executed");

	   Reporter.log("On clicking 'Main' link on 'Amenities List' page,system navigates to 'Administrator Console' page.",true);

	   ExcelUtil.CloseAllExcelReferences();
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }
   }


   /**
    * To verify Search An Amenity,Which exist in the 'Amenities List' page.
    * @throws Throwable
    */
   @Test(priority=27,groups={"P1","AmenitiesTest"},description="To verify Search An Amenity,Which exist in the 'Amenities List' page.")
   public void HMS1504() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
   	   ALP.fn_viewAll();
   	   ALP.fn_searchExistingAmenity();

       System.out.println("HMS-1504 Executed");

       Reporter.log("When existing amenity name is entered and 'Search' button is clicked on 'Amenities List' page,searched amenity gets displayed on the page",true);

	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
		   throw e;
		   
	   }
   }


   /**
    * To search for an Amenity ,which is not in the 'Amenities List' page.
    * @throws Throwable
    */
   @Test(priority=28,groups={"P2","AmenitiesTest"},description="To search for an Amenity ,which is not in the 'Amenities List' page.")
   public void HMS8069() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

       ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

   	   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

   	   ALP.fn_searchNonExistingAmenity(iTestCaseRow);

   	   System.out.println("HMS-8069 Executed");

   	   Reporter.log("When non-existing amenity name is entered and 'Search' button is clicked on 'Amenities List' page,system displays message as : 'No Entries Found'",true);

   	   ExcelUtil.CloseAllExcelReferences();
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }
   }



   /**
    * To verify selection for all the amenities by checking all the Amenities Individually.
    * @throws Throwable
    */
   @Test(priority=29,groups={"P2","AmenitiesTest"},description="To verify selection for all the amenities by checking all the Amenities Individually.")
   public void HMS5834() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   ALP.fn_viewAll();
	   ALP.fn_selectIndividualCB();
	   ALP.fn_verifySelect();

	   System.out.println("HMS-5834 Executed");

	   Reporter.log("On clicking checkbox corresponding to amenity on 'Amenities List'page,it gets checked .",true);

	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
		   throw e;
		   
	   }

   }

   /**
    * To Deselect all the amenities using checkbox respective of every Amenities
    * @throws Throwable
    */
   @Test(priority=30,groups={"P1","AmenitiesTest"},description="To Deselect all the amenities using checkbox respective of every Amenities")
   public void HMS8061() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   ALP.fn_viewAll();
	   ALP.fn_selectIndividualCB();
	   ALP.fn_deselectIndividualCB();
	   ALP.fn_verifyDeselect();

	   System.out.println("HMS-8061 Executed");

	   Reporter.log("On clicking selected checkbox corresponding to amenity on 'Amenities List'page,it gets unchecked .",true);

	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());

		   throw e;
		   
	   }
   }


   /**
    * To verify Selection of all the amenities by Master Checkbox.
    * @throws Throwable
    */
   @Test(priority=31,groups={"P2","AmenitiesTest"},description="To verify Selection of all the amenities by Master Checkbox.")
   public void HMS1498() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   ALP.fn_viewAll();
	   ALP.fn_MasterCB();
	   ALP.fn_verifySelect();

	   System.out.println("HMS-1498 Executed");

	   Reporter.log("When master checkbox is clicked on 'Amenities List' page,all the checkboxes corresponding to every amenity on that page gets checked. ",true);

	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
		   throw e;
	   }
   }


   /**
    * To deselect all the Amenities using Master Checkbox on 'Amenities List' page.
    * @throws Throwable
    */
   @Test(priority=32,groups={"P2","AmenitiesTest"},description="To deselect all the Amenities using Master Checkbox on 'Amenities List' page.")
   public void HMS8063() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   ALP.fn_viewAll();
	   ALP.fn_MasterCB();
	   ALP.fn_MasterCB();
	   ALP.fn_verifyDeselect();

	   System.out.println("HMS-8063 Executed");

	   Reporter.log("When already selected master checkbox is clicked on 'Amenities List' page,all the selected checkboxes corresponding to every amenity on that page gets unchecked.",true);

	  
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		
		   throw e;
	   }

   }


   /**
    * To verify Sorting by Amenities on clicking downward arrow.
    * @throws Throwable
    */
   @Test(priority=33,groups={"P2","AmenitiesTest"},description="To verify Sorting by Amenities on clicking downward arrow.")
   public void HMS5907() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   ALP.fn_sortNameAsce();

	   System.out.println("HMS-5907 Executed");

	   Reporter.log("When downward arrow against Amenities header on 'Amenities List' page is clicked,amenities gets alphanumerically sorted in ascending order.",true);

	  
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());

		   throw e;
	   }
   }



   /**
    * To verify Sorting by Amenities on clicking upward arrow.
    * @throws Throwable
    */
   @Test(priority=34,groups={"P2","AmenitiesTest"},description="To verify Sorting by Amenities on clicking upward arrow.")
   public void HMS9086() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   ALP.fn_sortNameDesc();

	   System.out.println("HMS-9086 Executed");

	   Reporter.log("When upward arrow against Amenities header on 'Amenities List' page is clicked,amenities gets alphanumerically sorted in descending order.",true);

	 
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());

		   throw e;
	   }
   }

   /**
    * To verify Sort by Status by clicking downward arrow
    * @throws Throwable
    */
   @Test(priority=35,groups={"P2","AmenitiesTest"},description="To verify Sort by Status by clicking downward arrow")
   public void HMS5908() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   ALP.fn_sortStatusAsce();

	   System.out.println("HMS-5908 Executed");

	   Reporter.log("When downward arrow against Status on 'Amenities List' page is clicked,system displays deactivated amenity at the end of the list.",true);

	  
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
		   throw e;
	   }
   }


   /**
    * To verify Sort by Status by clicking upward arrow
    * @throws Throwable
    */
   @Test(priority=36,groups={"P2","AmenitiesTest"},description="To verify Sort by Status by clicking upward arrow")
   public void HMS9087() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   ALP.fn_sortStatusDesc();

	   System.out.println("HMS-9087 Executed");

	   Reporter.log("When upward arrow against Status on 'Amenities List' page is clicked,system displays activated amenity at the end of the list.",true);

	  
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
		   throw e;
	   }
   }


   /**
    * Editing of An Amenity
    * @throws Throwable
    */
   @Test(priority=37,groups={"P0","AmenitiesTest"},description="Editing of An Amenity")
   public void HMS5803() throws Throwable
   {
       try
       {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   EditAmenity EAP=ALP.fn_clkEdit();

	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

       ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

       iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

   	   EAP.fn_EditAmenity();
		String str=ALP.alertTextMessage();
		Assert.assertEquals(str.equals("- Amenity "+'"'+EAP.amntyName+'"'+" Saved Successfully"), true);		
		ALP.fn_viewAll();
		ALP.checkAmenitiesInList(EAP.amntyName);
  

       System.out.println("HMS-5803 Executed");

       Reporter.log("When amenity title is edited and 'Save' button is clicked,system navigates to 'Amenitites List' page and displays message as :"
    		   +"- Amenity "+'"'+"XXX"+'"'+" Saved Successfully",true);

       ExcelUtil.CloseAllExcelReferences();

       }
       catch(Throwable e)
       { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    	   throw e;
       }

   }



   /**
    * To verify whether view link open uploaded image in new tab or not.
    * @throws Throwable
    */
 @Test(priority=38,groups={"P1","AmenitiesTest"},description="To verify whether view link open uploaded image in new tab or not.")
   public void HMS5809() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

       ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

       iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

       AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
   	   ALP.Image_EditAmenity(AEP.amntyName);
   	   String a=GenericClass.GetCurrentWindowID();
   	   ViewImage_Class VIC=AEP.fn_clkViewLnk();
   	   GenericClass.windowHandle(a);
   	   VIC.fn_verifyImage();

   	   System.out.println("HMS-5809 Executed");

   	   Reporter.log("When 'View' link displayed with uploaded image's name on 'Edit Amenity' page,system opens image in a new tab",true);

   	   ExcelUtil.CloseAllExcelReferences();
	   AH=null;
	   AEP=null;
	   VIC=null;
	   ALP=null;

	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }
   }


   /**
    * To verify whether pop up displays or not with text on image removal from the 'Add/Edit Amenity' page.
    * @throws Throwable
    */
   @Test(priority=39,groups={"P1","AmenitiesTest"},description="To verify whether pop up displays or not with text on image removal from the 'Add/Edit Amenity' page.")
   public void HMS8827() throws Throwable
   {
	   try
	   {
	   ExcelUtil.CloseAllExcelReferences();
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();



	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

	   ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

	   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);


	   AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
	   ALP.Image_EditAmenity(AEP.amntyName);
   	   AEP.fn_verifyRemoveAlert();

   	   System.out.println("HMS-8827 Executed");

   	   Reporter.log("When 'Remove' link displayed against uploaded image name is clicked on 'Edit Amentiy' page,system displays a pop-up with mesaage as : "
   			   +"'Do you really want to delete selected image.' with 'OK' and 'Cancel' buttons.",true);

   	   ExcelUtil.CloseAllExcelReferences();
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }
   }



   /**
    * To verify whether image removes or not when OK button is selected on the pop up
    * @throws Throwable
    */
   @Test(priority=40,groups={"P1","AmenitiesTest"},description="To verify whether image removes or not when OK button is selected on the pop up")
   public void HMS1501() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

       ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

   	   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

   	   AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
   	   ALP.Image_EditAmenity(AEP.amntyName);
   	   AEP.fn_removeAlertAccept();
   	   Thread.sleep(2000);
   	   AEP.fn_verifyRemovedImg();

   	   System.out.println("HMS-1501 Executed");

   	   Reporter.log("When 'Ok' button of pop-up displayed on clicking 'Remove' link is clicked,uploaded image gets removed from the amenity.",true);

   	   ExcelUtil.CloseAllExcelReferences();
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }
   }


   /**
    * To verify whether cancel button close the pop up or not after clicking.
    * @throws Throwable
    */
   @Test(priority=41,groups={"P2","AmenitiesTest"},description="To verify whether cancel button close the pop up or not after clicking.")
   public void HMS8066() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

       ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

   	   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

   	   AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);

   	   ALP.Image_EditAmenity(AEP.amntyName);

   	   //Stores uploaded image's name before clicking 'Remove' link
   	   String a=AEP.fn_getImageName();
   	   AEP.fn_verifyRemoveAlert();

   	   //Stores uploaded image's name when 'Cancel' button is clicked for 'Remove' link's alert
   	   String b=AEP.fn_getImageName();

   	   //Verifies uploaded image's name contained in 'a' and 'b'

       Assert.assertEquals(a, b);

       System.out.println("HMS-8066 Executed");

       Reporter.log("When 'Cancel' button of pop-up displayed on clicking 'Remove' link is clicked,system closes the pop-up",true);

       ExcelUtil.CloseAllExcelReferences();
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }
   }



   /**
    * To verify Deactivation for an Amenities in 'Amenities List 'Page.
    * @throws Throwable
    */
   @Test(priority=42,groups={"P1","AmenitiesTest"},description="To verify Deactivation for an Amenities in 'Amenities List 'Page.")
   public void HMS8070() throws Throwable
   {
	   try
	   {
	    AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	    AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

	    sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

        ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

    	iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

    	AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();
    	AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
        RoomTypesLandingPage RLP=AH.fn_NavigateRoomTypes();
        EditRoomType ERT=RLP.fn_EditRoomtype();
        ERT.fn_SelectAmenity(AEP.amntyName);
        ERT.fn_clickSave();
        AH.fn_NavigateAmenities();
        ALP.fn_viewAll();
	    ALP.verify_deactiveStatus(AEP.amntyName);
	    RoomTypesLandingPage RTP=AH.fn_NavigateRoomTypes();
	    AddRoomTypePage ARP=RTP.fn_NavigateAddRoomTypes();
        ARP.fn_verifyDeactivatedAmenity(AEP.amntyName);
        ARP.clk_RoomTypeListLink();
        RTP.fn_EditRoomtype();
        ERT.Available_verifyDeactivatedAmenity(AEP.amntyName);
        ERT.Selected_verifyDeactivatedAmenity(AEP.amntyName);

	    System.out.println("HMS-8070 Executed");

	    Reporter.log("When right green mark icon under 'Status' column for an amenity is clicked,it gets changed to red cross mark icon i.e."
	    		+" amenity becomes deactivated.",true);

	    ExcelUtil.CloseAllExcelReferences();
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }

   }


   /**
    * To verify Activation status for an Amenities.
    * @throws Throwable
    */
   @Test(priority=43,groups={"P1","AmenitiesTest"},description="To verify Activation status for an Amenities.")
   public void HMS5836() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

       ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

   	   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

   	   AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();
   	   AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
       RoomTypesLandingPage RLP=AH.fn_NavigateRoomTypes();
       EditRoomType ERT=RLP.fn_EditRoomtype();
       ERT.fn_SelectAmenity(AEP.amntyName);
       ERT.fn_clickSave();
       AH.fn_NavigateAmenities();
	   ALP.fn_viewAll();
	   ALP.verify_activeStatus(AEP.amntyName);
	   RoomTypesLandingPage RTP=AH.fn_NavigateRoomTypes();
	   AddRoomTypePage ARP=RTP.fn_NavigateAddRoomTypes();
       ARP.fn_verifyActivatedAmenity(AEP.amntyName);
       ARP.clk_RoomTypeListLink();
       RTP.fn_EditRoomtype();
       ERT.Selected_verifyActivatedAmenity(AEP.amntyName);

	   System.out.println("HMS-5836 Executed");

	   Reporter.log("When red cross mark icon under 'Status' column for an amenity is clicked,it gets changed to right green mark icon i.e."
			   +" amenity becomes activated.",true);

	   ExcelUtil.CloseAllExcelReferences();
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }
   }



   /**
    * To verify pagination on 'Amenities List' page.
    * @throws Throwable
    */
   @Test(priority=44,groups={"P1","AmenitiesTest"},description="To verify pagination on 'Amenities List' page.")
   public void HMS5822() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   ALP.verify_pageDropdown();

	   System.out.println("HMS-5822 Executed");

	   Reporter.log("On selecting a page number from 'Page' dropdown, system navigates to selected page number of 'Amenities List'.",true);

	  
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());

		   throw e;
	   }
   }


   /**
    * To verify record per page
    * @throws Throwable
    */
   @Test(priority=45,groups={"P1","AmenitiesTest"},description="To verify record per page")
   public void HMS5824() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   ALP.verify_viewDropdown("5");

	   System.out.println("HMS-5824 Executed");

	   Reporter.log("On selecting number from 'View records per page' dropdown,system displays selected number of records on 'Amenities List' page.",true);

	
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
		   throw e;
	   }
   }


   /**
    * To verify whether selecting 'All' option pop up alert message or not.
    * @throws Throwable
    */
   @Test(priority=46,groups={"P1","AmenitiesTest"},description="To verify whether selecting 'All' option pop up alert message or not.")
   public void HMS9089() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

       ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

   	   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

       ALP.verifyMsg_ViewAll(iTestCaseRow);

       System.out.println("HMS-9089 Executed");

       Reporter.log("When 'All' is selected from 'View records per page' dropdown,system displays alert as:\n"
    		   +"You have selected to view all records on a single page.\n"
               +"It may take some time to show all the records.\n"
               +"If the number of records are too much then it may misconfigure your server.\n"
               +"Do you want to continue? with 'OK' and 'Cancel' buttons",true);

       ExcelUtil.CloseAllExcelReferences();

	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }

   }


   /**
    * To verify whether clicking Cancel button, cancel all operations and navigate to Amenities list page or not.
    * @throws Throwable
    */
   @Test(priority=47,groups={"P2","AmenitiesTest"},description="To verify whether clicking Cancel button, cancel all operations and navigate to Amenities list page or not.")
   public void HMS9090() throws Throwable
   {

	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

       ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

   	   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

   	   ALP.viewAll_DismissAlert(iTestCaseRow);

   	   System.out.println("HMS-9090 Executed");

   	   Reporter.log("When 'Cancel' button is clicked for 'View records per page' dropdown alert,system cancel all operations and navigate to 'Amenities List' page.",true);

   	   ExcelUtil.CloseAllExcelReferences();
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }
   }


   /**
    * To verify whether clicking OK button, show all amenities on the page or not.
    * @throws Throwable
    */
   @Test(priority=48,groups={"P1","AmenitiesTest"},description="To verify whether clicking OK button, show all amenities on the page or not.")
   public void HMS9091() throws Throwable
   {

	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();

	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

       ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

   	   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

   	   ALP.viewAll_AcceptAlert(iTestCaseRow);

   	   System.out.println("HMS9091 Executed");

   	   Reporter.log("When 'OK' button is clicked for 'View records per page' dropdown alert,system displays all existing amenities on one  'Amenities List' page.",true);

   	   ExcelUtil.CloseAllExcelReferences();
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }
   }


   /**
    * To verify the functionality of 'Next' Link on 'Amenities List' page.
    * @throws Throwable
    */
   @Test(priority=49,groups={"P1","AmenitiesTest"},description="To verify the functionality of 'Next' Link on 'Amenities List' page.")
   public void HMS1509() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   ALP.verify_nextLnk();

	   System.out.println("HMS-1509 Executed");

	   Reporter.log("On clicking 'Next' link on 'Amenities List' page,system navigates to next 'Amenities List' page and displays amenities of that page.",true);

	   
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
		   throw e;
	   }
   }



   /**
    * To verify the functionality of 'Previous' link on 'Amenities List' page
    * @throws Throwable
    */
   @Test(priority=50,groups={"P1","AmenitiesTest"},description="To verify the functionality of 'Previous' link on 'Amenities List' page")
   public void HMS1510() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   ALP.verify_previousLnk();

	   System.out.println("HMS-1510 Executed");

	   Reporter.log("On clicking 'Previous' link,system navigates to previous 'Amenities List' page and displays amenities of that page.",true);

	  
	   }
	   catch(Throwable e)
	   { GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
		   throw e;
	   }
   }



   /**
    * To verify Audit Trail link functionality in the Amenities list Page
    * @throws Throwable
    */
   @Test(priority=51,groups={"P0","AmenitiesTest"},description="To verify Audit Trail link functionality in the Amenities list Page")
   public void HMS1511() throws Throwable
   {
	   try
	   {
	   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
	   AmenitiesLandingPage ALP=AH.fn_NavigateAmenities();
	   AddAmenity AEP=ALP.fn_NavigatetoAddAmenity();

	   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

       ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_Amenities,Constant.Sheet_Amenities);

   	   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

   	   AEP.AddAnAminity(iTestCaseRow,Constant.File_Amenities);
   	   String a=GenericClass.GetCurrentWindowID();
   	   AuditTrailALP AALP=ALP.fn_clkAuditTrail();
   	   GenericClass.windowHandle(a);
   	   String str=AALP.fn_verifyHeader();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
   	   AALP.fn_verifyChangeHistory(AEP.amntyName);
   	   GenericClass.driver.close();
   	   GenericClass.Switch_Parent_Window(a);

   	   System.out.println("HMS-1511 Executed");

   	   Reporter.log("On clicking 'Audit Trail' link on 'Amenities List' page,system displays 'Audit Trail-Amenities' window and shows changed history of Amenities.",true);

   	   ExcelUtil.CloseAllExcelReferences();
	   }
	   catch(Throwable e)
	   {
		   GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
		   throw e;
	   }


   }


		@AfterMethod
		public void Close_Br(){
		GenericClass.driver.close();
		}
}
