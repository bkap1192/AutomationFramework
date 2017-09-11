package com.hms.hotelogix.automationframework.tests.admin.RoomsManager.RoomTypes;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.CashCounterPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.ConfirmLoginPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.Web.WebConsole.WebReservationHomePage;
import com.hms.hotelogix.automationframework.pages.Web.WebConsole.WebSelectRoomPage;
import com.hms.hotelogix.automationframework.pages.admin.Console.RegisteredCorporate.AddCorporate;
import com.hms.hotelogix.automationframework.pages.admin.Console.RegisteredCorporate.ListOfRegisteredCorporateLP;
import com.hms.hotelogix.automationframework.pages.admin.Console.RegisteredTravelAgent.AddTravelAgent;
import com.hms.hotelogix.automationframework.pages.admin.Console.RegisteredTravelAgent.ListOfRegisteredTravelAgentLP;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.CorporatePackages.ListOfPackagesCorporate;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.CorporatePackages.ListOfPackagesCorporate1;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.CorporatePackages.PackageDetailCorporate;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.FrontdeskPackage.AttachaPackagesWindow;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.FrontdeskPackage.FrontDeskPackagesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.FrontdeskPackage.PackageDetailsFrontDesk;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.PackageMaster.AddAPackagePage;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.PackageMaster.PackageMasterListPage;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.RoomPrices.RoomPriceListLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.TravelAgentPackages.ListOfPackageTravelAgent1;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.TravelAgentPackages.ListOfPackagesTravelAgent;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.TravelAgentPackages.PackageDetailTravelAgent;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.WebPackages.AttachaPackageWindow;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.WebPackages.ListOfPackagesWeb;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.WebPackages.PackageDetailWeb;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities.AddAmenity;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities.AmenitiesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities.AuditTrailALP;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.AddRoomTypePage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.AuditTrailAddRoomTypePage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.AuditTrailEditRoomTypePage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.AuditTrailRoomTypeLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.EditRoomType;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.RoomTypesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.SortAmenitiesPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.ViewImage_ClassRT;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.EditRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.RoomsLandingPage;





public class RoomTypeTest
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
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	    AL=GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow,  ExcelUtil.GetColumnIndex(Constant.Col_Browser)), "http://hotelogix.net/admine/login/login/");

	    ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	 }


	/**
	 * To verify Navigation to Room Type List Page.
	 * @throws Throwable
	 */
	@Test(priority=1,groups={"P0","RoomTypeTest"},description="To verify Navigation to Room Type List Page.")
	public void HMS5901() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		String str=RTP.fn_verifyPageHeader();
        Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		
		System.out.println("HMS-5901 Executed");

		Reporter.log("When 'ROOM TYPES' is clicked under 'ROOMS MANAGER' tab, user gets redirected to 'Room Types List' page.",true);

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


	/**
	 * To verify title on Room Types List page.
	 * @throws Throwable
	 */
	@Test(priority=2,groups={"P0","RoomTypeTest"},description="To verify title on Room Types List page.")
	public void HMS1662() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

        Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		System.out.println("HMS-1662 Executed");

		Reporter.log("When 'ROOM TYPES' is clicked under 'ROOMS MANAGER' tab, 'Room Type List' gets displayed in window's title bar.");

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


	/**
	 * To verify the presence of all the Links, buttons and fields on "Room Type List" page.
	 * @throws Throwable
	 */
	@Test(priority=3,groups={"P1","RoomTypeTest"},description="To verify the presence of all the Links, buttons and fields on Room Type List page.")
	public void HMS8858() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
		RTP.fn_viewAll();
		RTP.verify_RoomTypeElements();

		System.out.println("HMS-8858 Executed");

		Reporter.log("When user gets redirected to 'Room Types List' page, all page elements are getting displayed.",true);


		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	
			throw e;
		}


	}


	/**
	 * To verify 'Add a Room Type' button functionality.
	 * @throws Throwable
	 */
	@Test(priority=4,groups={"P0","RoomTypeTest"},description="To verify 'Add a Room Type' button functionality.")
	public void HMS5902() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddRoomTypePage ARP=RTP.fn_NavigateAddRoomTypes();

		String str=ARP.fn_verifyPageHeader();
        Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		System.out.println("HMS-5902 Executed");

		Reporter.log("When 'ADD A ROOM TYPE' button on 'Room Types List' page is clicked, system navigates to 'Add a Room Type' page",true);

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


    /**
     * Verify the title of the page after clicking 'Add a Room Type' button
     * @throws Throwable
     */
	@Test(priority=5,groups={"P1","RoomTypeTest"},description="Verify the title of the page after clicking 'Add a Room Type' button")
	public void HMS8859() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddRoomTypePage ARP=RTP.fn_NavigateAddRoomTypes();

        Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		System.out.println("HMS-8859 Executed");

		Reporter.log("When 'ADD A ROOM TYPE' button on 'Room Types List' page is clicked, system navigates to page with title as :'Add Room Type'.",true);

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

    /**
     * Verifying display of Add/Edit a Room page.
     * @throws Throwable
     */
	@Test(priority=6,groups={"P1","RoomTypeTest"},description="Verifying display of Add/Edit a Room page.")
	public void HMS5905() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddRoomTypePage ARP=RTP.fn_NavigateAddRoomTypes();
		ARP.verifyAddRoomTypePage(iTestCaseRow);

		System.out.println("HMS-5905 Executed");

		Reporter.log("When user gets redirected to 'Add Room Type' page, all page elements are getting displayed.",true);

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


	/**
	 * Add a Room Type with valid data.
	 * @throws Throwable
	 */
	@Test(priority=7,groups={"P0","RoomTypeTest"},description="Add a Room Type with valid data.")
	public void  HMS1663() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
		ArrayList<String> l1=ARTP.fn_FillAddRoomTypeDetails(iTestCaseRow);
		Thread.sleep(2000);
		ARTP.fn_clkSave();
		Thread.sleep(8000);
		String msg=RTP.verify_saveMsg();
		Assert.assertEquals(msg,"- Room Type(s) "+'"'+ARTP.Roomtypename+'"'+" saved successfully");
		RTP.fn_viewAll();
		RTP.verify_AddedRoom(iTestCaseRow,ARTP.Roomtypename);
        String a=GenericClass.GetCurrentWindowID();
        SortAmenitiesPage SAP=RTP.fn_clkSortAmenities(iTestCaseRow,ARTP.Roomtypename);
        GenericClass.windowHandle(a);
        ArrayList<String> l2=SAP.fn_getAmenitiesName();
        //SAP.verify_RTAmenities();
        Assert.assertEquals(l2.equals(l1), true);
        GenericClass.driver.close();
        GenericClass.Switch_Parent_Window(a);
        RoomsLandingPage RLP=AH.fn_NavigateRooms();
        AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
        ARP.fn_verifyAddedRoomType(ARTP.Roomtypename);
        ARP.ClickOnRoomListLink();
        EditRoomsPage ERP=RLP.editlnk();
        ERP.fn_verifyAddedRoomType(ARTP.Roomtypename);
        ERP.ClickOnRoomListLink();
        RLP.RoomTypeFilter_AddedRT(ARTP.Roomtypename);
        FrontDeskPackagesLandingPage FLP=AH.fn_NavigateFrontdeskPackages();
        PackageDetailsFrontDesk PDF=FLP.clck_Editlnk();
        PDF.clk_view();
        PDF.verify_AddedRTName(ARTP.Roomtypename);
        PDF.clk_PkgFrontdeskLnk();
        ListOfPackagesWeb LPW=AH.fn_NavigateWebPackages();
        PackageDetailWeb PDW=LPW.clck_Editlnk();
        PDW.clk_view();
        PDW.verify_AddedRTName(ARTP.Roomtypename);
        PDW.fn_PackageListWeb_Link();
        ListOfPackagesCorporate LOC=AH.fn_NavigateCorporatePackages();
        ListOfPackagesCorporate1 LOC1=LOC.click_addviewpkg();
        PackageDetailCorporate PDC=LOC1.clck_Editlnk();
        PDC.clk_view();
        PDC.verify_AddedRTName(ARTP.Roomtypename);
        PDC.clk_PkgCorpLnk();
        ListOfPackagesTravelAgent LTA=AH.fn_NavigateToTAPkg();
        ListOfPackageTravelAgent1 LTA1=LTA.click_addviewpkg();
        PackageDetailTravelAgent PTA=LTA1.clck_Editlnk();
        PTA.clk_view();
        PTA.verify_AddedRTName(ARTP.Roomtypename);
        PTA.clk_PkgTALnk();

		System.out.println("HMS-1663 Executed");

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


	/**
	 * To verify Add a Room Type without Data.
	 * @throws Throwable
	 */
	@Test(priority=8,groups={"P1","RoomTypeTest"},description="To verify Add a Room Type without Data.")
	public void HMS1666() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
		ARTP.fn_clkSave();
		String str=ARTP.verify_errorMsg();
		Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		System.out.println("HMS-1666 Executed");

		Reporter.log("When 'Save' button is clicked without entering data on 'Add a Room Type' page, system displays validatio message as :\n"
				+"Following ERRORS occurred during submission!\n- Please Enter title for Room Type\n"
				+"- Please Enter Short Name\n- Please Enter description for Room Type"
				+"- Base Occupancy should be greater than zero.\n- Please Select Amenities",true);

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


	/**
	 * To verify Add Room Types with duplicate data.
	 * @throws Throwable
	 */
	@Test(priority=9,groups={"P1","RoomTypeTest"},description="To verify Add Room Types with duplicate data.")
	public void HMS5906() throws Throwable
	{
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
		ARTP.fn_FillAddRoomTypeDetails(iTestCaseRow);
		ARTP.fn_clkSave();
		RTP.fn_NavigateAddRoomTypes();
		ARTP.fn_AddRoomTypeDuplicateDetails(iTestCaseRow,ARTP.Roomtypename);
		ARTP.fn_clkSave();
		String str=ARTP.verify_errorMsg();
        Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		System.out.println("HMS-5906 Executed");

		Reporter.log("When 'Save' button is clicked on entering duplicate room type name and room type short name, system displays error message as :\n"
				+"Following ERRORS occurred during submission!\n"
				+"- Duplicate Room Type name\n"
				+"- Duplicate Room Type short name",true);

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}


	/**
	 * To Verify Upload Image(s)
	 * @throws Throwable
	 */
	@Test(priority=10,groups={"P1","RoomTypeTest"},description="To Verify Upload Image(s) ")
	public void HMS5909() throws Throwable
	{

		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		EditRoomType ERTP=RTP.fn_EditRoomtype();
		ERTP.fn_uploadimage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_UploadImagePath)));
		RTP.fn_viewAll();
		RTP.clkEdit_RTWithImg(ERTP.RTName);
		ERTP.fn_verifyUploadedImg();
		RTP.fn_verifyUploadedImg();
		AddRoomsPage ARP=RTP.fn_chkRooms(iTestCaseRow,ERTP.RTName);
		RoomPriceListLandingPage RPLP=AH.fn_NavigateRoomPrices();
		WebReservationHomePage WRP=RPLP.verify_RTPublishedOnWeb(ERTP.RTName);
		WebSelectRoomPage WSR=WRP.fn_CheckAvability();
		Thread.sleep(3000);
		WSR.verify_UploadedImg(ERTP.RTName);

		System.out.println("HMS-5909 Executed");

		Reporter.log("When 'Browse' button is clicked on 'Edit Room Type' page while uploading an image,system successfully uploads image and displays it on :\n "
				+"'Room Types List' page on Admine Console and 'Select Rooms/Packages' on Web Console.",true);

		ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}

	}


	 /**
	  * To Verify "View" option for uploaded image in Add a Room Type page.
	  * @throws Throwable
	  */
	 @Test(priority=11,groups={"P1","RoomTypeTest"},description="To Verify View option for uploaded image in Add a Room Type page.")
	 public void HMS5928() throws Throwable
	 {
		 try
		 {
		    AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			EditRoomType ERTP=RTP.fn_EditRoomtype();
			ERTP.fn_uploadimage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_UploadImagePath)));
			RTP.fn_viewAll();
			RTP.clkEdit_RTWithImg(ERTP.RTName);
			String a=GenericClass.GetCurrentWindowID();
			ViewImage_ClassRT VIC=ERTP.fn_clkViewLnk();
            GenericClass.windowHandle(a);
            Thread.sleep(3000);
            VIC.fn_verifyImage(ERTP.src1);
            GenericClass.driver.close();
            GenericClass.Switch_Parent_Window(a);


			System.out.println("HMS-5928 Executed");

			Reporter.log("When 'View' link displayed next to uploaded image on 'Edit Room Type' page is clicked,system displays uploaded image in a new tab.",true);

			ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }
	 }


	 /**
	  * To verify pop up on removing uploaded image.
	  * @throws Throwable
	  */
	 @Test(priority=12,groups={"P1","RoomTypeTest"},description="To verify pop up on removing uploaded image.")
	 public void HMS5929() throws Throwable
	 {
		 try
		 {
		    AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			EditRoomType ERTP=RTP.fn_EditRoomtype();
			ERTP.fn_uploadimage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_UploadImagePath)));
			RTP.fn_viewAll();
			RTP.clkEdit_RTWithImg(ERTP.RTName);
            ERTP.fn_verifyRemoveAlert(iTestCaseRow);

			System.out.println("HMS-5929 Executed");

			Reporter.log("When 'Remove' link displayed next to uploaded image on 'Edit Room Type' page is clicked,system displays an alert as :\n"
					+"'Do you really want to delete selected image.' with an 'OK' and 'Cancel' buttons.",true);

			ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }
	 }



	 /**
	  * To verify uploaded room image is deleted while pressing OK button on the pop up.
	  * @throws Throwable
	  */
	 @Test(priority=13,groups={"P1","RoomTypeTest"},description="To verify uploaded room image is deleted while pressing OK button on the pop up.")
	 public void HMS5930() throws Throwable
	 {
		 try
		 {
		    AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
			ARTP.fn_FillAddRoomTypeDetails(iTestCaseRow);
			ARTP.fn_clkSave();
			Thread.sleep(6000);
			EditRoomType ERTP=RTP.clkEdit_RTtoAddImg(ARTP.Roomtypename);
			Thread.sleep(5000);
			ERTP.fn_uploadimage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_UploadImagePath)));

			RTP.fn_viewAll();
			RTP.clkEdit_RTWithImg(ERTP.RTName);
			ERTP.fn_removeAlertAccept();
			Thread.sleep(3000);
			ERTP.fn_verifyRemovedImg();

			System.out.println("HMS-5930 Executed");

			Reporter.log("When 'Remove' alert on 'Edit Room Type' page is accepted,system deletes the uploaded image.\n"
					+"System removes 'View' and 'Remove' link as well.",true);

			ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }
	 }


	 /**
	  * Verify CANCEL button on the pop up while removing uploaded image(s).
	  * @throws Throwable
	  */
	 @Test(priority=14,groups={"P1","RoomTypeTest"},description="Verify CANCEL button on the pop up while removing uploaded image(s).")
	 public void HMS8860() throws Throwable
	 {
		 try
		 {
		    AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
			ARTP.fn_FillAddRoomTypeDetails(iTestCaseRow);
			ARTP.fn_clkSave();
			Thread.sleep(6000);
			EditRoomType ERTP=RTP.clkEdit_RTtoAddImg(ARTP.Roomtypename);
			Thread.sleep(5000);
			ERTP.fn_uploadimage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_UploadImagePath)));
			RTP.fn_viewAll();
			RTP.clkEdit_RTWithImg(ERTP.RTName);
			ERTP.fn_removeAlertDismiss();
			String str=ERTP.verify_pageHeader();
            Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
			System.out.println("HMS-8860 Executed");

			ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }
	 }


	 /**
	  * To verify whether Room Type save or not when HO > BO.
	  * @throws Throwable
	  */
	 @Test(priority=15,groups={"P0","RoomTypeTest"},description="To verify whether Room Type save or not when HO > BO.")
	 public void HMS8861() throws Throwable
	 {
		 try
		 {
		    AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			EditRoomType ERTP=RTP.fn_EditRoomtype();
			Thread.sleep(3000);
			ERTP.fn_HOGrtrBO(iTestCaseRow, Constant.File_RoomTypes);
			Thread.sleep(2000);
			ERTP.fn_clkSave();
			Thread.sleep(8000);
			String str=RTP.verify_saveMsg();
			Assert.assertEquals(str.equals("- Room Type(s) "+'"'+ERTP.RTName+'"'+" saved successfully"),true);
			RTP.fn_viewAll();
			RTP.verify_AddedRoom(iTestCaseRow,ERTP.RTName);
	        RoomsLandingPage RLP=AH.fn_NavigateRooms();
	        AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
	        ARP.fn_verifyAddedRoomType(ERTP.RTName);
	        ARP.ClickOnRoomListLink();
	        EditRoomsPage ERP=RLP.editlnk();
	        ERP.fn_verifyAddedRoomType(ERTP.RTName);
	        ERP.ClickOnRoomListLink();
	        RLP.RoomTypeFilter_AddedRT(ERTP.RTName);
	        FrontDeskPackagesLandingPage FLP=AH.fn_NavigateFrontdeskPackages();
	        PackageDetailsFrontDesk PDF=FLP.clck_Editlnk();
	        PDF.clk_view();
	        PDF.verify_AddedRTName(ERTP.RTName);
	        PDF.clk_PkgFrontdeskLnk();
	        ListOfPackagesWeb LPW=AH.fn_NavigateWebPackages();
	        PackageDetailWeb PDW=LPW.clck_Editlnk();
	        PDW.clk_view();
	        PDW.verify_AddedRTName(ERTP.RTName);
	        PDW.fn_PackageListWeb_Link();
	        ListOfPackagesCorporate LOC=AH.fn_NavigateCorporatePackages();
	        ListOfPackagesCorporate1 LOC1=LOC.click_addviewpkg();
	        PackageDetailCorporate PDC=LOC1.clck_Editlnk();
	        PDC.clk_view();
	        PDC.verify_AddedRTName(ERTP.RTName);
	        PDC.clk_PkgCorpLnk();
	        ListOfPackagesTravelAgent LTA=AH.fn_NavigateToTAPkg();
	        ListOfPackageTravelAgent1 LTA1=LTA.click_addviewpkg();
	        PackageDetailTravelAgent PTA=LTA1.clck_Editlnk();
	        PTA.clk_view();
	        PTA.verify_AddedRTName(ERTP.RTName);
	        PTA.clk_PkgTALnk();

	        System.out.println("HMS-8861 Executed");

	        Reporter.log("When Higher Occupancy is set greater than Base Occupancy while adding a room type,system succesfully saves it and dislays Room Type in 'Room Types List'.",true);

	        ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }

	 }

     /**
      * To verify whether Room Type save or not when HO < BO.
      * @throws Throwable
      */
	 @Test(priority=16,groups={"P1","RoomTypeTest"},description="To verify whether Room Type save or not when HO < BO.")
	 public void HMS8862() throws Throwable
	 {
		 try
		 {
		    AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			EditRoomType ERTP=RTP.fn_EditRoomtype();
			Thread.sleep(3000);
			ERTP.fn_HOLessthanBO(iTestCaseRow, Constant.File_RoomTypes);
			Thread.sleep(2000);
			ERTP.fn_clkSave();
			Thread.sleep(8000);
		    String str=ERTP.verify_errorMsg();
			Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);


	        System.out.println("HMS-8862 Executed");

	        Reporter.log("When Higher Occupancy is set less than Base Occupancy while adding a room type,system displays  validation as:\n"
	        		+"Following ERRORS occurred during submission!\n"
	        		+"- Higher Occupancy needs to be more than or equal to Base Occupancy",true);

	        ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }
	 }

	 /**
	  * To verify High Price field.
	  * @throws Throwable
	  */
	 @Test(priority=17,groups={"P1","RoomTypeTest"},description="To verify High Price field.")
	 public void HMS5910() throws Throwable
	 {
		 try
		 {
		 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		 EditRoomType ERTP=RTP.fn_EditRoomtype();
		 Thread.sleep(3000);
		 ERTP.fn_HOequalBO(iTestCaseRow, Constant.File_RoomTypes);

		 System.out.println("HMS-5910 Executed");

		 Reporter.log("When Higher Occupancy is set equal to Base Occupancy while adding a room type,Higher Price textbox becomes disabled.",true);

		 ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }
	 }

     /**
      * To verify whether allowing extra bed without mentioning extra bed number save Room Type or not.
      * @throws Throwable
      */
	 @Test(priority=18,groups={"P1","RoomTypeTest"},description="To verify whether allowing extra bed without mentioning extra bed number save Room Type or not.")
	 public void HMS8863() throws Throwable
	 {
		 try
		 {
		 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		 EditRoomType ERTP=RTP.fn_EditRoomtype();
		 Thread.sleep(3000);
		 ERTP.fn_clkExtraBed();
		 String str=ERTP.verify_errorMsg();
         Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		 System.out.println("HMS-8863 Executed");

		 Reporter.log("When checkbox for 'Extra bed allowed?' is selected without mentioning number of extra beds and 'Save' button is clicked,system displays a validation as :\n"
		 		+"Following ERRORS occurred during submission!\n"
				 +"- Please select the number for Extra bed allowed",true);

		 ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }
	 }


	 /**
	  * To verify Extra Bed(s) Price field without selecting checkbox for Extra Bed(s).
	  * @throws Throwable
	  */
	 @Test(priority=19,groups={"P0","RoomTypeTest"},description="To verify Extra Bed(s) Price field without selecting checkbox for Extra Bed(s).")
	 public void HMS5912() throws Throwable
	{

		 try
		 {
		 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		 AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
		 ARTP.fn_FillExtraBedPrice(iTestCaseRow);

		 System.out.println("HMS-5912 Executed");

		 Reporter.log("'Extra Bed(s) Price' field remains inactive when 'Extra bed allowed?' checkbox is not checked on 'Add a Room Type' page while creating a room type. ",true);

		 ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }
	 }


     /**
      * Verify Extra Bed(s) drop down without selecting checkbox for Extra Bed(s)
      * @throws Throwable
      */
	 @Test(priority=20,groups={"P1","RoomTypeTest"},description="Verify Extra Bed(s) drop down without selecting checkbox for Extra Bed(s)")
	 public void HMS5913() throws Throwable
	 {
		 try
		 {
		 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		 AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
         ARTP.fn_SelectExtraBed(iTestCaseRow);

         System.out.println("HMS-5913 Executed");

         Reporter.log("'extra beds allowed' dropdown remains inactive when 'Extra bed allowed?' checkbox is unchecked.",true);

         ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }
	 }


  /******************Need to modify****************/
	 /**
	  * Attaching Taxes in a Room Type.
	  * @throws Throwable
	  */
	 //@Test(priority=21,groups={"P1","RoomTypeTest"},description="Attaching Taxes in a Room Type.")
	 public void HMS5914() throws Throwable
	 {
		 try
		 {
		 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		 AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
		 ARTP.fn_FillAddRoomTypeDetails(iTestCaseRow);
		 ARTP.fn_clkSave();
		 EditRoomType ERT=RTP.clkEdit_RTWithImg(ARTP.Roomtypename);
		 ERT.fn_AddTax();
		 //ERT.fn_clickSave();
		 Thread.sleep(5000);
		 RTP.newRT_chkRooms(iTestCaseRow,ARTP.Roomtypename);
		 String a=GenericClass.GetCurrentWindowID();
		 ConfirmLoginPage CLP=AH.ClickOnFrontdeskLink();
		 GenericClass.windowHandle(a);
		 CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
		 FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
         FLP.fn_ClickCancelButton();
         FLP.fn_clickCurrentLnk();
        // FLP.getCountOfRooms1();
         FLP.fn_createFDReserv(ARTP.Roomtypename, "3", "3");
         FLP.fn_fillAddQuickResrv("1");
         FLP.fn_ReservWithTax();
         
         System.out.println("HMS-5914 Executed");
         
         ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }

	 }
/***************************************************************************/

	 /**
	  * Cancel in Add a Room Type page.
	  * @throws Throwable
	  */
	 @Test(priority=22,groups={"P1","RoomTypeTest"},description="Cancel in Add a Room Type page.")
	 public void HMS1667() throws Throwable
		{
		 try
		 {
		 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		 AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
	     ARTP.fn_FillAddRoomTypeDetails(iTestCaseRow);
	     ARTP.fn_clkCancelTopBtn();
	     String str=RTP.fn_verifyPageHeader();
         Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
	     System.out.println("HMS-1667 Executed");

	     Reporter.log("When 'Cancel' button is clicked after adding mandatory details while creating a room type on 'Add a Room Type' page,system navigates to 'Room Types List' page and does not save room type details.",true);

	     ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }
		 }



     /**
      * To verify Delete a Room Type popup.
      * @throws Throwable
      */
	 @Test(priority=23,groups={"P1","RoomTypeTest"},description="To verify Delete a Room Type popup.")	 
	 public void HMS1670() throws Throwable
	 {
		 try
		 {
		 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		 String str=RTP.fn_verifyDeleteAlertMsg();
		 Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);

		 System.out.println("HMS-1670 Executed");

		 Reporter.log("When 'DELETE SELECTED AMENITIES' button is clicked,system displays an alert with message as:\n"
				 +"'Do you really want to delete the selected records?' with an 'OK' and 'Cancel' buttons.",true);

		 ExcelUtil.CloseAllExcelReferences();
		 }
		 catch(Throwable e)
		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			 throw e;
		 }
	}


     /**
      * To verify Delete a Room Type functionality.
      * @throws Throwable
      */
	 @Test(priority=24,groups={"P1","RoomTypeTest"},description="To verify Delete a Room Type functionality.")
	 public void HMS5916() throws Throwable
		{
          try
          {
		 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		 AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
		 ARTP.fn_FillAddRoomTypeDetails(iTestCaseRow);
		 ARTP.fn_clkSave();
		 Thread.sleep(6000);
		 //RTP.verify_DeleteRoomTypeMsg(iTestCaseRow);
		 RTP.fn_viewAll();
		 RTP.fn_verifyDeleteAccept(ARTP.Roomtypename);
		 RTP.verify_DeletedRoom(ARTP.Roomtypename);
		 RoomsLandingPage RLP=AH.fn_NavigateRooms();
	     AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
	     ARP.fn_verifyDeletedRoomType(ARTP.Roomtypename);
	     ARP.ClickOnRoomListLink();
	     EditRoomsPage ERP=RLP.editlnk();
	     ERP.fn_verifyDeletedRoomType(ARTP.Roomtypename);
	     ERP.ClickOnRoomListLink();
	     RLP.RoomTypeFilter_DeletedRT(ARTP.Roomtypename);
	     PackageMasterListPage PML=AH.fn_NavigateToPackageMaster();
	     AddAPackagePage APP=PML.fn_ClickAddaPackageLink();
	     APP.fillPkgDetails(iTestCaseRow,"1");
	     APP.clickOnSave();
	     FrontDeskPackagesLandingPage FLP=AH.fn_NavigateFrontdeskPackages();
	     String a =GenericClass.GetCurrentWindowID();
	     AttachaPackagesWindow APW=FLP.fn_ClickAttachAPackageLink();
	     GenericClass.windowHandle(a);
	     APW.fn_attachPkg();
	     GenericClass.Switch_Parent_Window(a);
	     FLP.fn_viewAll();
	     PackageDetailsFrontDesk PDF=FLP.clckSpecifiedPkg_Editlnk();
	     PDF.clk_view();
	     PDF.verify_DeletedRTName(ARTP.Roomtypename);
	     PDF.clk_PkgFrontdeskLnk();
	     ListOfPackagesWeb LPW=AH.fn_NavigateWebPackages();
	     String b=GenericClass.GetCurrentWindowID();
	     LPW.fn_ClickAttachaPackageLink();
	     GenericClass.windowHandle(b);
	     APW.fn_attachPkg();
	     GenericClass.Switch_Parent_Window(b);
	     LPW.fn_viewAll();
	     PackageDetailWeb PDW=LPW.clckSpecifiedPkg_Editlnk();
	     PDW.clk_view();
	     PDW.verify_DeletedRTName(ARTP.Roomtypename);
	     PDW.fn_PackageListWeb_Link();
	     ListOfPackagesCorporate LOC=AH.fn_NavigateCorporatePackages();
	     ListOfPackagesCorporate1 LOC1=LOC.click_addviewpkg();
	     LOC1.fn_viewAll();
         String c=GenericClass.GetCurrentWindowID();
         LOC1.fn_ClickAttachaPackageLink();
         GenericClass.windowHandle(c);
         APW.fn_attachPkg();
         GenericClass.Switch_Parent_Window(c);
         LOC1.fn_viewAll();
	     PackageDetailCorporate PDC=LOC1.clckSpecifiedPkg_Editlnk();
	     PDC.clk_view();
	     PDC.verify_DeletedRTName(ARTP.Roomtypename);
	     PDC.clk_PkgCorpLnk();
	     ListOfPackagesTravelAgent LTA=AH.fn_NavigateToTAPkg();
	     ListOfPackageTravelAgent1 LTA1=LTA.click_addviewpkg();
	     String d=GenericClass.GetCurrentWindowID();
	     LTA1.fn_ClickAttachaPackageLink();
	     GenericClass.windowHandle(d);
	     APW.fn_attachPkg();
	     GenericClass.Switch_Parent_Window(d);
	     LTA1.fn_viewAll();
	     PackageDetailTravelAgent PTA=LTA1.clckSpecifiedPkg_Editlnk();
	     PTA.clk_view();
	     PTA.verify_DeletedRTName(ARTP.Roomtypename);
	     PTA.clk_PkgTALnk();


		 System.out.println("HMS-5916 Executed");

		 Reporter.log("When 'OK' button of 'DELETE SELECTED ROOM TYPE(S)' alert is clicked,selected room type gets deleted and system displays message as:"
				 +"- Room Type(s) XXX deleted successfully",true);


		 ExcelUtil.CloseAllExcelReferences();
          }
          catch(Throwable e)
          {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
  		ExcelUtil.CloseAllExcelReferences();
        	  throw e;
          }
		}


       /**
        * Verify Cancel button on pop up while deleting any Room Type
        * @throws Throwable
        */
	   @Test(priority=25,groups={"P2","RoomTypeTest"},description="Verify Cancel button on pop up while deleting any Room Type")
	   public void HMS8864() throws Throwable
	   {
		   try
		   {
		   AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		   RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

		   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		   ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

		   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		   RTP.fn_verifyDeleteDismiss(iTestCaseRow);
		   String str=RTP.fn_verifyPageHeader();
           Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		   System.out.println("HMS8864 Executed");

		   Reporter.log("When 'Cancel' button of 'DELETE SELECTED ROOM TYPE(S)' pop-up is clicked,pop-up gets closed and selected room type(s) does not gets deleted from the list."
				   +"The selected checkbox corresponding to the room type being deleted also remains checked.",true);

		   ExcelUtil.CloseAllExcelReferences();
		   }
		   catch(Throwable e)
		   {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
			   throw e;
		   }
	   }



	    /**
	     * To verify Main link on Add a Room Type page.
	     * @throws Throwable
	     */
	    @Test(priority=26,groups={"P1","RoomTypeTest"},description="To verify Main link on Add a Room Type page.")
		public void HMS1669() throws Throwable
		{
	    	try
	    	{
	    	 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			 AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
			 ARTP.clk_Mainlnk();
			 Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

			 System.out.println("HMS-1669 Executed");

			 Reporter.log("When 'Main' link on 'Add a Room Type' page is clicked,system navigates to 'Administrator Console' page.",true);

			 ExcelUtil.CloseAllExcelReferences();
	    	}
	    	catch(Throwable e)
	    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			ExcelUtil.CloseAllExcelReferences();
	    		throw e;
	    	}
		}


		/**
		 * To verify Room Types List link on Add a Room Type page.
		 * @throws Throwable
		 */
		 @Test(priority=27,groups={"P1","RoomTypeTest"},description="To verify Room Types List link on Add a Room Type page.")
		 public void HMS1668() throws Throwable
		{
			 try
			 {
			 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			 AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
			 ARTP.clk_RoomTypeListLink();
			 String str=RTP.fn_verifyPageHeader();
             Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
			 System.out.println("HMS-1668 Executed");

			 Reporter.log("When 'Room Type List' link on 'Add a Room Type' page is clicked,system navigates to 'Room Types List' page.",true);

			 ExcelUtil.CloseAllExcelReferences();
			 }
			 catch(Throwable e)
			 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
				 throw e;
			 }
		 }


		 /**
		  * To verify Cancel in Room Types List.
		  * @throws Throwable
		  */
		 @Test(priority=28,groups={"P1","RoomTypeTest"},description="To verify Cancel in Room Types List.")
		 public void HMS5918() throws Throwable
		 {
			 try
			 {
			 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			 RTP.clk_Cancel();
			 String str=AH.fn_verifyPageTitle();
             Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
			 System.out.println("HMS-5918 Executed");

			 Reporter.log("When 'Cancel' button on 'Room Types List' page is clicked,system navigates to 'Administrator Console' page.",true);

			 ExcelUtil.CloseAllExcelReferences();
			 }
			 catch(Throwable e)
			 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
				 throw e;
			 }
		}


		 /**
		  *  To verify 'Audit Trail' link on Add a Room Type Page.
		  * @throws Throwable
		  */
		 @Test(priority=29,groups={"P1","RoomTypeTest"},description="To verify 'Audit Trail' link on Add a Room Type Page.")
		 public void HMS5915() throws Throwable
		 {
			 try
			 {
			 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			 AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
			 Thread.sleep(1000);
			 ARTP.fn_FillAddRoomTypeDetails(iTestCaseRow);
			 ARTP.fn_clkSave();
			 RTP.fn_NavigateAddRoomTypes();
			 String a=GenericClass.GetCurrentWindowID();
			 AuditTrailAddRoomTypePage ATART=ARTP.fn_clkAuditTrail();
			 GenericClass.windowHandle(a);
             ATART.verify_ChangedHistory(iTestCaseRow,ARTP.Roomtypename);
             GenericClass.driver.close();
             GenericClass.Switch_Parent_Window(a);

			 System.out.println("HMS-5915 Executed");

			 Reporter.log("When 'Audit Trail' link on 'Add a Room Type' page is clicked,'Audit Trail-Room Type' window and displays captured history of changes (including Date,By, and the changes) "
					 +"made on Add a Room Type page",true);


			 ExcelUtil.CloseAllExcelReferences();
			 }
			 catch(Throwable e)
			 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
				 throw e;
			 }
		 }



		    /**
		     * To verify Delete Reserved Room Types.
		     * @throws Throwable
		     */
			@Test(priority=30,groups={"P1","RoomTypeTest"},description="To verify Delete Reserved Room Types.")
			public void HMS1671() throws Throwable
			{
				try
				{
				 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
				 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

				 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

				 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

				 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				 RTP.fn_viewAll();
                 RTP.verifyMsg_DeleteReservedRoomType(iTestCaseRow,"Deluxe");

				 System.out.println("HMS-1671 Executed");

				 Reporter.log("When reserved room type is selected ad 'DELETE SELECTED ROOM TYPE(S)' button is clicked on 'Room Types List' page,system displays validation message as:\n"
						 +"- These Room Type(s) cannot be deleted as some of these Room types have Active Reservations/DNR.",true);

				 ExcelUtil.CloseAllExcelReferences();
				}
				catch(Throwable e)
				{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
					throw e;
				}
			 }


			 /**
			 * To verify Save Sort Order in Room Types List.
			 * @throws Throwable
			 */
			 @Test(priority=31,groups={"P1","RoomTypeTest"},description="To verify Save Sort Order in Room Types List.")
			 public void HMS1675() throws Throwable
			 {

				 try
				 {
				 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
				 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

				 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

				 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

				 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				 
				 RTP.validData_saveSortOrder(iTestCaseRow);
				 
				 System.out.println("HMS-1675 Executed");
				 
				 ExcelUtil.CloseAllExcelReferences();
				 }
				 catch(Throwable e)
				 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
					ExcelUtil.CloseAllExcelReferences();
					 throw e;
				 }
			 }

			 
			 /**
			  * To 'Save Sort Order' when any user is logged in to the frontdesk.
			  * @throws Throwable
			  */
			 @Test(priority=32,groups={"P1","RoomTypeTest"},description="To 'Save Sort Order' when any user is logged in to the frontdesk.")
			 public void HMS8865() throws Throwable
			 {
				 try
				 {
				 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
				 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
				 
				 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

				 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

				 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				 
				 RTP.verify_sortMsg(iTestCaseRow);
				 
				 System.out.println("HMS-8865 Executed");
				 
				 ExcelUtil.CloseAllExcelReferences();
				 }
				 catch(Throwable e)
				 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
					ExcelUtil.CloseAllExcelReferences();
					 throw e;
				 }
			 }

			 /**
			  * To verify selection for the Room Type by checking all the Room Type Individually.
			  * @throws Throwable
			  */
			 @Test(priority=33,groups={"P2","RoomTypeTest"},description="To verify selection for the Room Type by checking all the Room Type Individually.")
			 public void HMS5917() throws Throwable
			 {
				 try
				 {
				 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
				 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
				 RTP.fn_viewAll();
				 RTP.fn_selectIndividualCB();
				 RTP.fn_verifySelect();

				 System.out.println("HMS-5917 Executed");

                 Reporter.log("On clicking checkbox corresponding to room type on 'Room Types List'page,it gets checked .",true);
				 }
				 catch(Throwable e)
				 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				
					 throw e;
				 }
			}


		  /**
		  * To verify de-selection for the Room Type by unchecking all the Room Type Individually.
		  * @throws Throwable
		  */
          @Test(priority=34,groups={"P2","RoomTypeTest"},description="To verify de-selection for the Room Type by unchecking all the Room Type Individually.")
          public void HMS8866() throws Throwable
          {
        	  try
        	  {
        	  AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			  RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
		   	  RTP.fn_viewAll();
			  RTP.fn_selectIndividualCB();
			  RTP.fn_deselectIndividualCB();
			  RTP.fn_verifyDeselect();

			  System.out.println("HMS-8866 Executed");

			  Reporter.log("On clicking selected checkbox corresponding to room types on 'Room Types List'page,it gets unchecked .",true);
        	  }
        	  catch(Throwable e)
        	  {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
     
        		  throw e;
        	  }
          }



          /**
           * To verify Selection of all the Room Type by Master Checkbox.
           * @throws Throwable
           */
          @Test(priority=35,groups={"P2","RoomTypeTest"},description="To verify Selection of all the Room Type by Master Checkbox.")
          public void HMS8867() throws Throwable
          {
        	  try
        	  {
        	  AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			  RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			  RTP.fn_MasterCB();
              RTP.verify_MasterSelect();

              System.out.println("HMS-8867 Executed");

              Reporter.log("When master checkbox is clicked on 'Room Types List' page,all the checkboxes corresponding to every room type on that page gets checked. ",true);
        	  }
        	  catch(Throwable e)
        	  {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
     
        		  throw e;
        	  }
          }


          /**
           * To deselect all the Room Types using Master Check box on 'Room Types List' page.
           * @throws Throwable
           */
          @Test(priority=36,groups={"P2","RoomTypeTest"},description="To deselect all the Room Types using Master Check box on 'Room Types List' page.")
          public void HMS8868() throws Throwable
          {
              try
              {
        	  AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			  RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			  RTP.fn_MasterCB();
			  RTP.fn_MasterCB();
			  RTP.verify_MasterDeselect();

			  System.out.println("HMS-8868 Executed");

			  Reporter.log("When already selected master checkbox is clicked on 'Room Types List' page,all the selected checkboxes corresponding to every room type on that page gets unchecked.",true);
              }
              catch(Throwable e)
              {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
      	
            	  throw e;
              }
          }


          /**
           * To verify  Rooms link on Room Types List page.
           * @throws Throwable
           */
          @Test(priority=37,groups={"P1","RoomTypeTest"},description="To verify  Rooms link on Room Types List page.")
     	  public void HMS5920() throws Throwable
          {
        	  try
        	  {
        	  AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			  RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
              RTP.fn_viewAll();
              RoomsLandingPage RLP=RTP.fn_clkTotalNoOfRoomlnk();
              String text=RLP.verify_RoomTypeNameFilter();
        	  Assert.assertEquals(text, RTP.RTName);
        	  
     		  System.out.println("HMS-5920:Rooms link on Room Types List page");

     		  Reporter.log("When total number of rooms link is clicked corresponding to a room type,system navigates to 'Room List' page for the Room type selected in the filter.",true);
        	  }
        	  catch(Throwable e)
        	  {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
 
        		  throw e;
        	  }
     	}


         /**
          * To verify Add a Room link on Room Types List page.
          * @throws Throwable
          */
     	 @Test(priority=38,groups={"P1","RoomTypeTest"},description="To verify Add a Room link on Room Types List page.")
     	 public void HMS5921() throws Throwable
     	 {
     		 try
     		 {
     		 AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			 RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			 sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			 ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			 iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

             RTP.fn_viewAll();
             AddRoomsPage ARP=RTP.fn_AddARoomLink();
             String str=ARP.verify_pageHeader();
     		Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
             String text=ARP.verify_RoomTypeNameFilter();
       	     Assert.assertEquals(text, RTP.RTName);

             System.out.println("HMS-5921 Executed");

             Reporter.log("When 'Add a Room' link is clicked correso=ponding toa room type,system navigates to 'Add/Edit a Room' page with room type selected from the dropdown.",true);

             ExcelUtil.CloseAllExcelReferences();

     		 }
     		 catch(Throwable e)
     		 {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
     		ExcelUtil.CloseAllExcelReferences();
     			throw e;

     		 }
     	}


        /**
         * To verify Edit link against a Room Type.
         * @throws Throwable
         */
     	@Test(priority=39,groups={"P1","RoomTypeTest"},description="To verify Edit link against a Room Type.")
    	public void HMS1672() throws Throwable
     	{
     		try
     		{
     		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			EditRoomType ERTP=RTP.fn_EditRoomtype();
			String str=ERTP.verify_pageHeader();
            Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
    		System.out.println("HMS-1672 Executed");

    		Reporter.log("When 'Edit' link corresponding to a room type on 'Room Types List' page is clicked,system navigates to 'Add a Room Type' page.",true);

    		ExcelUtil.CloseAllExcelReferences();

     		}
     		catch(Throwable e)
     		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		ExcelUtil.CloseAllExcelReferences();
     			throw e;
     		}
    	}


    	/**
    	 * To verify Editing a Room Type.
    	 * @throws Throwable
    	 */
     	@Test(priority=40,groups={"P1","RoomTypeTest"},description="To verify Editing a Room Type.")
    	public void HMS1673() throws Throwable
    	{
     		try
     		{
     		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			EditRoomType ERTP=RTP.fn_EditRoomtype();
            ERTP.fn_EditRTDetails();
            String str=RTP.verify_saveMsg();
            Assert.assertEquals(str.equals("- Room Type(s) "+'"'+ERTP.RTName+'"'+" saved successfully"), true);
            RTP.fn_viewAll();
            RTP.verify_EditedRoom(ERTP.RTName);
            RoomsLandingPage RLP=AH.fn_NavigateRooms();
            AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
            ARP.fn_verifyEditedRoomType(ERTP.RTName);
            ARP.ClickOnRoomListLink();
            EditRoomsPage ERP=RLP.editlnk();
            ERP.fn_verifyEditedRoomType(ERTP.RTName);
            ERP.ClickOnRoomListLink();
            RLP.RoomTypeFilter_EditedRT(ERTP.RTName);
            FrontDeskPackagesLandingPage FLP=AH.fn_NavigateFrontdeskPackages();
            PackageDetailsFrontDesk PDF=FLP.clck_Editlnk();
            PDF.clk_view();
            PDF.verify_EditedRTName(ERTP.RTName);
            PDF.clk_PkgFrontdeskLnk();
            ListOfPackagesWeb LPW=AH.fn_NavigateWebPackages();
            PackageDetailWeb PDW=LPW.clck_Editlnk();
            PDW.clk_view();
            PDW.verify_EditedRTName(ERTP.RTName);
            PDW.fn_PackageListWeb_Link();
            ListOfPackagesCorporate LOC=AH.fn_NavigateCorporatePackages();
            ListOfPackagesCorporate1 LOC1=LOC.click_addviewpkg();
            PackageDetailCorporate PDC=LOC1.clck_Editlnk();
            PDC.clk_view();
            PDC.verify_EditedRTName(ERTP.RTName);
            PDC.clk_PkgCorpLnk();
            ListOfPackagesTravelAgent LTA=AH.fn_NavigateToTAPkg();
            ListOfPackageTravelAgent1 LTA1=LTA.click_addviewpkg();
            PackageDetailTravelAgent PTA=LTA1.clck_Editlnk();
            PTA.clk_view();
            PTA.verify_EditedRTName(ERTP.RTName);
            PTA.clk_PkgTALnk();

    		System.out.println("HMS-1673 Executed");

    		Reporter.log("When a room type is edited and 'Save' button is clicked on 'Edit Room Type' page,system navigates to 'Room Types List' page and message is displayed as :"
    				+"Room type 'XXX' saved successfully.",true);

    		ExcelUtil.CloseAllExcelReferences();
     		}
     		catch(Throwable e)
     		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		ExcelUtil.CloseAllExcelReferences();
     			throw e;
     		}


    	}


    	/**
    	 * To verify base price on Add a Room Type page.
    	 * @throws Throwable
    	 */
    	@Test(priority=41,groups={"P1","RoomTypeTest"},description="To verify base price on Add a Room Type page.")
    	public void HMS5923() throws Throwable
    	{
    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();

			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			EditRoomType ERTP=RTP.fn_EditRoomtype();
			ERTP.fn_CharInBasePrice(iTestCaseRow);
			String str=ERTP.verify_errorMsg();
            Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
    		System.out.println("HMS-5923 Executed");

    		Reporter.log("When characters are added in 'Base Price' field and saved,system remains on 'Add a Room Type' page and displays error message as : \n"
    				+"Following ERRORS occurred during submission!\n"
    				+"- Invalid Base Price",true);

    		ExcelUtil.CloseAllExcelReferences();
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		ExcelUtil.CloseAllExcelReferences();
    			throw e;
    		}
    	}


    	/**
    	 * To verify Sort Amenities link for Room Type.
    	 * @throws Throwable
    	 */
    	@Test(priority=42,groups={"P0","RoomTypeTest"},description="To verify Sort Amenities link for Room Type.")
    	public void HMS1674() throws Throwable
    	{
    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			EditRoomType ERTP=RTP.fn_EditRoomtype();
			ArrayList<String> l1=ERTP.fn_getSelectedAmenities();
			ERTP.clk_RoomTypeListLink();
			String a=GenericClass.GetCurrentWindowID();
            SortAmenitiesPage SAP=RTP.fn_SortAmenities();
            GenericClass.windowHandle(a);
            String str=SAP.verify_pageHeader();
    		Assert.assertTrue(str.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
            SAP.verify_SortAmenitiesPage(iTestCaseRow);
            ArrayList<String> l2=SAP.fn_getAmenitiesName();
            Assert.assertEquals(l2.equals(l1), true);
            GenericClass.driver.close();
            GenericClass.Switch_Parent_Window(a);
    		//RoomTypeAmenities.fn_verifyRoomTypeAmenitiesPage();
    		System.out.println("HMS-1674 Executed");
    	
    		ExcelUtil.CloseAllExcelReferences();
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		ExcelUtil.CloseAllExcelReferences();
    			throw e;
    		}
    		
    	}


    	/**
    	 * Verifying all link, buttons and fields on the page.
    	 * @throws Throwable
    	 */
    	@Test(priority=43,groups={"P1","RoomTypeTest"},description="Verifying all link, buttons and fields on the page.")
    	public void HMS8873() throws Throwable
    	{
    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			String a=GenericClass.GetCurrentWindowID();
            SortAmenitiesPage SAP=RTP.fn_SortAmenities();
            GenericClass.windowHandle(a);
            SAP.verify_SortAmenitiesPage(iTestCaseRow);
            GenericClass.driver.close();
            GenericClass.Switch_Parent_Window(a);
            System.out.println("HMS-8873 Executed");
            
            ExcelUtil.CloseAllExcelReferences();
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		ExcelUtil.CloseAllExcelReferences();
    			throw e;
    		}
    	}
    	
    	
    	/**
    	 * To verify Sort Amenities for a room type.
    	 * @throws Throwable
    	 */
    	@Test(priority=44,groups={"P0","RoomTypeTest"},description=" To verify Sort Amenities for a room type.")
    	public void HMS5924() throws Throwable
    	{

    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			String a=GenericClass.GetCurrentWindowID();
            SortAmenitiesPage SAP=RTP.fn_SortAmenities();
            GenericClass.windowHandle(a);
            SAP.fn_getRTName();
    		SAP.fn_SaveSortAmenities(iTestCaseRow);
    		GenericClass.Switch_Parent_Window(a);
    		String str=RTP.fn_verifyAmenitiesSortOrderMsg();
			Assert.assertEquals(str, "- Amenities for Room Type "+'"'+SortAmenitiesPage.RTName+'"'+" sorted successfully!");
    		System.out.println("HMS-5924:Sort amenities for a Room Type .");
    		
    		ExcelUtil.CloseAllExcelReferences();
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		ExcelUtil.CloseAllExcelReferences();
    			throw e;
    		}
    	}
    	
    	
    	/**
    	 * To verify CANCEL button on the page.
    	 * @throws Throwable
    	 */
       	@Test(priority=45,groups={"P2","RoomTypeTest"},description="To verify CANCEL button on the page.")
    	public void HMS8869() throws Throwable
    	{
       		try
       		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			String a=GenericClass.GetCurrentWindowID();
			SortAmenitiesPage SAP=RTP.fn_SortAmenities();
			GenericClass.windowHandle(a);
			SAP.fn_clkCancelBtn();
			GenericClass.Switch_Parent_Window(a);
		    String str=RTP.fn_verifyPageHeader();
			Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
			System.out.println("HMS-8869 Executed");
			
			ExcelUtil.CloseAllExcelReferences();
       		}
       		catch(Throwable e)
       		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		ExcelUtil.CloseAllExcelReferences();
       			throw e;
       		}
    	}
    	
    	/*************** TC is being failed as this is bug ***********************/ 
    	/**
       	 * To verify Inactive status of a room type.
    	 * @throws Throwable
    	 */
       	@Test(priority=46,groups={"P1","RoomTypeTest"},description="To verify Inactive status of a room type.")
       	public void HMS1719() throws Throwable
       	{
       		try
       		{
       		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
			ARTP.fn_FillAddRoomTypeDetails(iTestCaseRow);
			ARTP.fn_clkSave();
			RTP.fn_viewAll();
			RTP.clk_ActiveToDeactive(iTestCaseRow);
			RTP.fn_verifyDeactiveStatus(iTestCaseRow);
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
            AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
            ARP.fn_verifyDeactivatedRoomType(RTP.RTName);
            ARP.ClickOnRoomListLink();
            EditRoomsPage ERP=RLP.editlnk();
            ERP.fn_verifyDeactivatedRoomType(RTP.RTName);
            ERP.ClickOnRoomListLink();
            RLP.RoomTypeFilter_DeactiveRT(RTP.RTName);
            FrontDeskPackagesLandingPage FLP=AH.fn_NavigateFrontdeskPackages();
            PackageDetailsFrontDesk PDF=FLP.clck_Editlnk();
            PDF.clk_view();
            PDF.verify_DeactiveRTName(RTP.RTName);
            PDF.clk_PkgFrontdeskLnk();
            ListOfPackagesWeb LPW=AH.fn_NavigateWebPackages();
            PackageDetailWeb PDW=LPW.clck_Editlnk();
            PDW.clk_view();
            PDW.verify_DeactiveRTName(RTP.RTName);
            PDW.fn_PackageListWeb_Link();
            ListOfPackagesCorporate LOC=AH.fn_NavigateCorporatePackages();
            ListOfPackagesCorporate1 LOC1=LOC.click_addviewpkg();
            PackageDetailCorporate PDC=LOC1.clck_Editlnk();
            PDC.clk_view();
            PDC.verify_DeactiveRTName(RTP.RTName);
            PDC.clk_PkgCorpLnk();
            ListOfPackagesTravelAgent LTA=AH.fn_NavigateToTAPkg();
            ListOfPackageTravelAgent1 LTA1=LTA.click_addviewpkg();
            PackageDetailTravelAgent PTA=LTA1.clck_Editlnk();
            PTA.clk_view();
            PTA.verify_DeactiveRTName(RTP.RTName);
            PTA.clk_PkgTALnk();
            
            
            System.out.println("HMS-1719 Executed");
            Reporter.log("This test case is failing as de-activated room is still being displayed in all types of packages ",true);
            
            ExcelUtil.CloseAllExcelReferences();
       		}
       		catch(Throwable e)
       		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		ExcelUtil.CloseAllExcelReferences();
       			throw e;
       		}
       	}
    	
       	
       	
       	/**
       	 * To verify Activate status for a Room Type.
       	 * @throws Throwable
       	 */
       	@Test(priority=47,groups={"P1","RoomTypeTest"},description="To verify Activate status for a Room Type.")
       	public void HMS1718() throws Throwable
       	{
       		try
       		{
       		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			
			RTP.fn_viewAll();
			RTP.clk_DeactiveToActive(iTestCaseRow);
			RTP.fn_verifyActiveStatus(iTestCaseRow);
			RoomsLandingPage RLP=AH.fn_NavigateRooms();
            AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
			ARP.fn_verifyActivatedRoomType(RTP.RTName);
			ARP.ClickOnRoomListLink();
	        EditRoomsPage ERP=RLP.editlnk();
	        ERP.ClickOnRoomListLink();
	        RLP.RoomTypeFilter_ActiveRT(RTP.RTName);
	        FrontDeskPackagesLandingPage FLP=AH.fn_NavigateFrontdeskPackages();
            PackageDetailsFrontDesk PDF=FLP.clck_Editlnk();
            PDF.clk_view();
            PDF.verify_ActiveRTName(RTP.RTName);
            PDF.clk_PkgFrontdeskLnk();
            ListOfPackagesWeb LPW=AH.fn_NavigateWebPackages();
            PackageDetailWeb PDW=LPW.clck_Editlnk();
            PDW.clk_view();
            PDW.verify_ActiveRTName(RTP.RTName);
            PDW.fn_PackageListWeb_Link();
            ListOfPackagesCorporate LOC=AH.fn_NavigateCorporatePackages();
            ListOfPackagesCorporate1 LOC1=LOC.click_addviewpkg();
            PackageDetailCorporate PDC=LOC1.clck_Editlnk();
            PDC.clk_view();
            PDC.verify_ActiveRTName(RTP.RTName);
            PDC.clk_PkgCorpLnk();
            ListOfPackagesTravelAgent LTA=AH.fn_NavigateToTAPkg();
            ListOfPackageTravelAgent1 LTA1=LTA.click_addviewpkg();
            PackageDetailTravelAgent PTA=LTA1.clck_Editlnk();
            PTA.clk_view();
            PTA.verify_ActiveRTName(RTP.RTName);
            PTA.clk_PkgTALnk();
            
            System.out.println("HMS-1718 Executed");
            
            ExcelUtil.CloseAllExcelReferences();
       		}
       		catch(Throwable e)
       		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		ExcelUtil.CloseAllExcelReferences();
       			throw e;
       		}
       	}
       	
       	
       	/**
       	 * To Deactivate the Reserved Room Type
       	 * @throws Throwable
       	 */
       	@Test(priority=48,groups={"P1","RoomTypeTest"},description="To Deactivate the Reserved Room Type")
    	public void HMS1720() throws Throwable
    	{
       		try
       		{
       		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
			ARTP.fn_FillAddRoomTypeDetails(iTestCaseRow);
			ARTP.fn_clkSave();
			RTP.fn_viewAll();
			RTP.fn_addRooms(iTestCaseRow,ARTP.Roomtypename);
			ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
      		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
      		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
      		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
      		FLP.fn_ClickCancelButton();
      		FLP.fn_clickCurrentLnk();
      		GenericClass.driver.navigate().refresh();
      		Thread.sleep(3000);
      		FLP.fn_ClickCancelButton();
      		FLP.fn_createFDReserv(ARTP.Roomtypename, "3", "3");
      		FLP.fn_fillAddQuickResrv("1");
      		FLP.fn_rghtClkChkIn();
      		GenericClass.fn_SwitchToWindow_Title("Room List");
			AH.fn_NavigateRoomTypes();
			RTP.clk_DeactiveReservedRT(iTestCaseRow,ARTP.Roomtypename);
    		
    		System.out.println("HMS-1720 Executed");
    		
    		ExcelUtil.CloseAllExcelReferences();
       		}
       		catch(Throwable e)
       		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		ExcelUtil.CloseAllExcelReferences();
       			throw e;
       		}
    	}
       	
    	
    	/**
    	 * To verify Sort by Room type by clicking downward arrow
    	 * @throws Throwable
    	 */
    	@Test(priority=49,groups={"P2","RoomTypeTest"},description="To verify Sort by Room type by clicking downward arrow")
    	public void HMS1716() throws Throwable
    	{
    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			RTP.sortRTName_downwardArrow();
			
			System.out.println("HMS-1716 Executed");
			
		
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());

    			throw e;
    		}
    	}
    	
    	
    	
    	/**
    	 * To verify Sort by Room type by clicking upward arrow
    	 * @throws Throwable
    	 */
    	@Test(priority=50,groups={"P2","RoomTypeTest"},description="To verify Sort by Room type by clicking upward arrow")
    	public void HMS8870() throws Throwable
    	{
    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			RTP.sortRTName_upwardArrow();
			
			System.out.println("HMS-8870 Executed");
			
			
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    
    			throw e;
    		}
    	}
    	
    	
    	/**
    	 * To verify Sort by Status by clicking downward arrow
    	 * @throws Throwable
    	 */
    	@Test(priority=51,groups={"P2","RoomTypeTest"},description="To verify Sort by Status by clicking downward arrow")
    	public void HMS1717() throws Throwable
    	{
    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			Thread.sleep(4000);
			RTP.sortStatus_downwardArrow();
			
			System.out.println("HMS-1717 Executed");
			
			
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    	
    			throw e;
    		}
    	}
    	
    	
    	/**
    	 * To sort the room types by status column after pressing upward button.
    	 * @throws Throwable
    	 */
    	@Test(priority=52,groups={"P2","RoomTypeTest"},description="To sort the room types by status column after pressing upward button.")
    	public void HMS8871() throws Throwable
    	{
    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			Thread.sleep(4000);
			RTP.sortStatus_upwardArrow();
			
			System.out.println("HMS-8871 Executed");
			
			
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		
    			throw e;
    		}
    	}
    	
    	
    	/*@Test(priority=53,groups={"P2","RoomTypeTest"},description="")
    	public void HMS1715() throws Throwable
    	{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			Thread.sleep(4000);
    	}*/
    	
    	
    	
    	/*@Test(priority=54,groups="",description="")
    	public void HMS8872()
    	{
    		
    	}*/
    	
    	/**
    	 * To verify Main link in Room Types List page.
    	 * @throws Throwable
    	 */
    	@Test(priority=55,groups={"P1","RoomTypeTest"},description="To verify Main link in Room Types List page.")
    	public void HMS1705() throws Throwable
    	{
    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			
			RTP.mainLink();

            Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);  
			
			System.out.println("HMS-1705 Executed");
			
			ExcelUtil.CloseAllExcelReferences();
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		ExcelUtil.CloseAllExcelReferences();
    			throw e;
    		}
    	}
    	
    	
    	/**
    	 * To verify Page in Room Types List page.
    	 * @throws Throwable
    	 */
    	@Test(priority=56,groups={"P1","RoomTypeTest"},description="To verify Page in Room Types List page.")
    	public  void HMS1721() throws Throwable
    	{
    		try{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			RTP.verify_pageDropdown();			
			
    	    System.out.println("HMS-1721 Executed");
    	    
    	    
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    		
    			throw e;
    		}
    	}
    	
    	
    	
    	/**
    	 * To verify View in Room Types List page.
    	 * @throws Throwable
    	 */
    	@Test(priority=57,groups={"P1","RoomTypeTest"},description="To verify View in Room Types List page.")
    	public  void HMS1722() throws Throwable
    	{
    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			RTP.verify_viewDropdown("1");   		
    		System.out.println("HMS-1722 Executed");    		    	
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    
    			throw e;
    		}
    	}
    	
    	
    	/**
    	 * To verify Next in Room Types List page.
    	 * @throws Throwable
    	 */
    	@Test(priority=58,groups={"P1","RoomTypeTest"},description="To verify Next in Room Types List page.")
    	public void HMS1723() throws Throwable
    	{
    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			RTP.verify_nextLnk();
			
			System.out.println("HMS-1723 Executed");
			
			
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    	
    			throw e;
    		}
    	}
    	
    	
    	
    	/**
    	 * To verify Previous in Room Types List page.
    	 * @throws Throwable
    	 */
    	@Test(priority=59,groups={"P1","RoomTypeTest"},description="To verify Previous in Room Types List page.")
    	public void HMS1724() throws Throwable
    	{
    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			RTP.verify_previousLnk();
			
			System.out.println("HMS-1724 Executed");
			
			
    		}
    		catch(Throwable e)
    		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
    	
    			throw e;
    		}
    	}
    	
    	
    	
    	/**
    	 * To verify Audit Trail link in Room Types List page.
    	 * @throws Throwable
    	 */
    	@Test(priority=60,groups={"P1","RoomTypeTest"},description="To verify Audit Trail link in Room Types List page.")
    	public void HMS1730() throws Throwable
    	{
    		try
    		{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
			RoomTypesLandingPage RTP= AH.fn_NavigateRoomTypes();
			
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RoomTypes,Constant.Sheet_RoomTypes);

			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			
			AddRoomTypePage ARTP=RTP.fn_NavigateAddRoomTypes();
			ARTP.fn_FillAddRoomTypeDetails(iTestCaseRow);
			ARTP.fn_clkSave();
			String a=GenericClass.GetCurrentWindowID();
			AuditTrailRoomTypeLandingPage ATRTP=RTP.fn_clkAuditTrail();
			GenericClass.windowHandle(a);
			Thread.sleep(4000);
			ATRTP.verify_ChangedHistory(iTestCaseRow,ARTP.Roomtypename);
			GenericClass.Switch_Parent_Window(a);
			
			System.out.println("HMS-1730 Executed");
			
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
