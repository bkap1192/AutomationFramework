package com.hms.hotelogix.automationframework.tests.admin.RoomsManager.DisplayColors;

import java.util.ArrayList;
import java.util.Set;

import javax.media.rtp.rtcp.Report;

import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.Housekeeping.HousekeepingLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.CashCounterPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.ConfirmLoginPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ReservationSearchResult.ReservationSearchResultLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage.EnableEditingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.Web.WebConsole.WebAddMoreRoomPage;
import com.hms.hotelogix.automationframework.pages.Web.WebConsole.WebConfirmReservationPage;
import com.hms.hotelogix.automationframework.pages.Web.WebConsole.WebConfirmReservationPrintPage;
import com.hms.hotelogix.automationframework.pages.Web.WebConsole.WebReservationHomePage;
import com.hms.hotelogix.automationframework.pages.Web.WebConsole.WebSelectRoomPage;
import com.hms.hotelogix.automationframework.pages.Web.WebCorporateConsole.CorporateAddMoreRoomPage;
import com.hms.hotelogix.automationframework.pages.Web.WebCorporateConsole.CorporateConfirmReservationPage;
import com.hms.hotelogix.automationframework.pages.Web.WebCorporateConsole.CorporateConfirmReservationPrintPage;
import com.hms.hotelogix.automationframework.pages.Web.WebCorporateConsole.CorporateConsolePage;
import com.hms.hotelogix.automationframework.pages.Web.WebCorporateConsole.CorporateLoginPage;
import com.hms.hotelogix.automationframework.pages.Web.WebCorporateConsole.CorporateSelectRoomPage;
import com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole.WebGuestAddMoreRoomPage;
import com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole.WebGuestConfirmReservationPage;
import com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole.WebGuestConfirmReservationPrintPage;
import com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole.WebGuestConsoleLandingPage;
import com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole.WebGuestConsoleLoginPage;
import com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole.WebGuestSelectRoomPage;
import com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole.WebGuestStayDetailsPage;
import com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent.TAAddMoreRoomPage;
import com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent.TAConfirmReservationPage;
import com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent.TAConfirmReservationPrintPage;
import com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent.TAConsolePage;
import com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent.TALoginPage;
import com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent.TASelectRoomPage;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.DisplayColors.DisplayColorsAuditTrail;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.DisplayColors.DisplayColorsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.RoomsLandingPage;
import com.hms.hotelogix.automationframework.pages.emailaccount.EmailAccountLoginPage;
import com.hms.hotelogix.automationframework.pages.emailaccount.EmailHomePage;

public class DisplayColorsTest
{

	public WebDriver driver;

	private String sTestCaseName;

	private int iTestCaseRow;
	private AdminLogin AL=new AdminLogin();


	@BeforeMethod()
	public void Login() throws Throwable
	{
		try
		{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	    AL=GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser)), "http://hotelogix.net/admine/login/login/");

	    ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

    /**
     *  Directing to Manage Display Colors page
     *  @throws Throwable

     */

	@Test(priority=1,groups={"P0","DisplayColorsTest"},description="Directing to Manage Display Colors page")
    public void HMS8843() throws Throwable
    {
		try
		{
		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		DCP.fn_verifyPageHeader(iTestCaseRow);

		System.out.println("HMS-8843 Executed");


		Reporter.log("When 'DISPLAY COLORS' is clicked under 'ROOMS MANAGER' tab, user gets redirected to 'Manage Display Colors' page.",true);


		ExcelUtil.CloseAllExcelReferences();

		}
		catch(Throwable e)
		{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
    }


    /**
     *  To verify Title of 'Manage Display Colors' page
     *  @throws Throwable


     */

    @Test(priority=2,groups={"P1","DisplayColorsTest"},description="To verify Title of 'Manage Display Colors' page")
    public void HMS1798() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		DCP.fn_verifyPageHeader(iTestCaseRow);

		System.out.println("HMS-1798 Executed");

		Reporter.log("When 'DISPLAY COLORS' is clicked under 'ROOMS MANAGER' tab,'Manage Display Colors' gets displayed in the title bar.",true);

		ExcelUtil.CloseAllExcelReferences();


    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }


    /**
     * To Verify Elements on Manage Display Colours Page
     * @throws Throwable


     */

    @Test(priority=3,groups={"P1","DisplayColorsTest"},description="To Verify Elements on Manage Display Colours Page")
    public void HMS7952() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		DCP.fn_CheckElements(iTestCaseRow);

		System.out.println("HMS-7952 Executed");

		Reporter.log("When user gets redirected to 'Manage Display Colors' page, all page elements are getting displayed.",true);

		ExcelUtil.CloseAllExcelReferences();



    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }

    /**
     *  Verify Color drop-down under 'Select Color Coding of Room status for the Front Desk tape chart' section.
     *  @throws Throwable
     */

    @Test(priority=4,groups={"P1","DisplayColorsTest"},description="Verify Color drop-down under 'Select Color Coding of Room status for the Front Desk tape chart' section.")
    public void HMS8847() throws Throwable
    {
    	try
    	{
        	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();
    		DCP.verifyDropdown_RoomStatus();

    		System.out.println("HMS-8847 Executed");

    		Reporter.log("Color code drop-down gets displayed under 'Select Color Coding of Room status for the Front Desk tape chart' section. for \n"
    				    + "Reserved Rooms, Checked-in Rooms, Checked-out Rooms, Temp Rooms, Overbooked Rooms",true);

    		


    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		
    		throw e;
    	}
    }


     /**
      * Verify Color dropdown under 'Select Color Coding of Housekeeping status' section.
      * @throws Throwable
      */
    @Test(priority=5,groups={"P1","DisplayColorsTest"},description="Verify Color dropdown under 'Select Color Coding of Housekeeping status' section.")
    public void HMS8848() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();
		DCP.verifyDropdown_HousekeepingStatus();

		System.out.println("HMS-8848 Executed");

		Reporter.log("Color code drop-down gets displayed under 'Select Color Coding of Housekeeping status' section. for \n"
				+ "Touch-up Rooms, Dirty Rooms, Inspect Rooms, Clean Rooms, Repair Rooms, Do Not Reserve(DNR)",true);

		
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		
    		throw e;
    	}
    }


    /**
     * Verify Textbox under 'Select Alphabet Coding for the Front Desk tape chart' section.
     * @throws Throwable
     */

    @Test(priority=6,groups={"P1","DisplayColorsTest"},description="Verify Textbox under 'Select Alphabet Coding for the Front Desk tape chart' section.")
    public void HMS8849() throws Throwable
    {

    	try
    	{
        	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();
    		DCP.verifyTextbox_AlphabetCode();

    		System.out.println("HMS-8849 Executed");

    		Reporter.log("Color code drop-down gets displayed under 'Select Alphabet Coding for the Front Desk tape chart' section. for \n"
    				+ "Travel Agent Booking, Corporate Booking, Online/Web Booking, Group Booking, Other/GDS Booking",true);

    		
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		
    		throw e;
    	}
    }



    /**
     *  Save without any change on 'Manage Display Colors' page
     *  @throws Throwable
     */

    @Test(priority=7,groups={"P1","DisplayColorsTest"},description="Save without any change on 'Manage Display Colors' page")
    public void HMS8846() throws Throwable
    {
    	try
    	{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
    		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

    		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

    		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

    		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

    		DCP.fn_clkSaveChangesBtn();
    		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);

    		System.out.println("HMS-8846 Executed");

    		Reporter.log("When 'Save Changes' button is clicked without any change, system displays message as: \n"
    				+ "Display Colors saved successfully",true);

    		ExcelUtil.CloseAllExcelReferences();

    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }


    /**
     *  To verify Main link on Manage Display Colors page
     *  @throws Throwable
     */
    @Test(priority=8,groups={"P1","DisplayColorsTest"},description="To verify Main link on Manage Display Colors page")
    public void HMS1800() throws Throwable
    {
          try
          {
        	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
      		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

      		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

      		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

      		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

            DCP.fn_clkMainLink();
    		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

            System.out.println("HMS-1800 Executed");

            Reporter.log("On clicking 'Main' link on 'Manage Display Colors' page,user gets redirected to Admine Console home page.",true);

            ExcelUtil.CloseAllExcelReferences();



          }
          catch(Throwable e)
          {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
  		ExcelUtil.CloseAllExcelReferences();
        	  throw e;
          }
    }


    /**
     *  Change Color code for 'Reserved Rooms' with 'Save Changes' button
     *  @throws Throwable

     */

    @Test(priority=9,groups={"P1","DisplayColorsTest"},description="Change Color code for 'Reserved Rooms' with 'Save Changes' button")
    public void HMS1799() throws Throwable
    {
    	try
    	{
    		AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
      		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

      		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

      		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

      		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

      		DCP.ReservedRoom_ColorChange();
      		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
      		DCP.verify_RRColorchange();
      		//String a=GenericClass.GetCurrentWindowID();

      		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
      		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
      		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
      		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
      		FLP.fn_ClickCancelButton();
      		FLP.verify_RRColorCode();
      		//String b=GenericClass.GetCurrentWindowID();
      		//System.out.println(b);
      		HousekeepingLandingPage HLP=FLP.ClickOnHouseleepingLink();
      		GenericClass.fn_SwitchToWindow_Title("Housekeeping");
      		HLP.verify_RRColorCode();
      		GenericClass.driver.close();
      		//GenericClass.Switch_Parent_Window(b);
      		//GenericClass.driver.close();
      		//GenericClass.Switch_Parent_Window(a);

      		System.out.println("HMS-1799 Executed");

            Reporter.log("When color code for Reserved Room is changed and 'Save Changes' button is clicked on Manage Display Color,color gets changed for Reserved Rooms",true);

            ExcelUtil.CloseAllExcelReferences();


    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }



    /**
     *  Change Color code for 'Reserved Rooms' with 'Save' button
     *  @throws Throwable

     */

    @Test(priority=10,groups={"P1","DisplayColorsTest"},description="Change Color code for 'Reserved Rooms' with 'Save' button")
    public void HMS8944() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.ReservedRoom_ColorChange1();
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		DCP.verify_RRColorchange();
  		//String a=GenericClass.GetCurrentWindowID();

  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.verify_RRColorCode();
  		//GenericClass.driver.navigate().to("http://hotelogix.stayezee.com/housekeeping/");
  		//String b=GenericClass.GetCurrentWindowID();
  		//System.out.println(b);
  		HousekeepingLandingPage HLP=FLP.ClickOnHouseleepingLink();
  		//GenericClass.windowHandle(b);
  		GenericClass.fn_SwitchToWindow_Title("Housekeeping");
  		Thread.sleep(4000);
  		HLP.verify_RRColorCode();
  		GenericClass.driver.close();

  		System.out.println("HMS-8944 Executed");

        Reporter.log("When color code for Reserved Room is changed and 'Save' button is clicked on Manage Display Color,color gets changed for Reserved Rooms on manage display colors,frontdesk tapechart and housekeeping",true);

        ExcelUtil.CloseAllExcelReferences();

    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }

    /**
     *  Change Color code for 'Checked-in Rooms'
     *  @throws Throwable

     */

    @Test(priority=11,groups={"P1","DisplayColorsTest"},description="Change Color code for 'Checked-in Rooms'")
    public void HMS7934() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.CheckedinRoom_ColorChange();
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		//String a=GenericClass.GetCurrentWindowID();

  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
        FLP.verify_CIColorCode();
  		HousekeepingLandingPage HLP=FLP.ClickOnHouseleepingLink();
  		GenericClass.fn_SwitchToWindow_Title("Housekeeping");
  		Thread.sleep(4000);
  		HLP.verify_CIRColorCode();
  		GenericClass.driver.close();

  		System.out.println("HMS-7934 Executed");


  		Reporter.log("When color code for Checked-in Rooms is changed and 'Save' button is clicked on Manage Display Color,color gets changed for Checked-in Rooms on frontdesk as well as  houskeeping console",true);

  		ExcelUtil.CloseAllExcelReferences();


    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }


    /**
     *  Change Color code for 'Checked-out Rooms'
     *  @throws Throwable

     */

    @Test(priority=12,groups={"P1","DisplayColorsTest"},description="Change Color code for 'Checked-out Rooms'")
    public void HMS7935() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.CheckedoutRoom_ColorChange();
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);

  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.verify_COColorCode();
  		HousekeepingLandingPage HLP=FLP.ClickOnHouseleepingLink();
  		GenericClass.fn_SwitchToWindow_Title("Housekeeping");
  		Thread.sleep(4000);
  		HLP.verify_CORColorCode();
  		GenericClass.driver.close();

  		System.out.println("HMS-7935 Executed");

  		Reporter.log("When color code for Checked-out Rooms is changed and 'Save' button is clicked on Manage Display Color,color gets changed for Checked-out Rooms on frontdesk as well as houskeeping console \n"
  				+ "under 'Room Legends' and 'Room Status Legends' respectively",true);

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
     *  Change Color code for 'Temp Rooms'
     *  @throws Throwable

     */

    @Test(priority=13,groups={"P1","DisplayColorsTest"},description="Change Color code for 'Temp Rooms'")
    public void HMS7936() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.TempRoom_ColorChange();
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);


  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
        FLP.verify_TempColorCode();
    	GenericClass.driver.close();
    	//GenericClass.Switch_Parent_Window(a);

    	System.out.println("HMS-7936 Executed");

    	Reporter.log("When color code for Temp Rooms is changed and 'Save' button is clicked on Manage Display Color,color gets changed for Temp Rooms on frontdesk under 'Room Legends",true);

    	ExcelUtil.CloseAllExcelReferences();


    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }

    /**
     *  Change Color code for 'Overbooked Rooms'
     *  @throws Throwable

     */

    @Test(priority=14,groups={"P1","DisplayColorsTest"},description="Change Color code for 'Overbooked Rooms'")
    public void HMS7937() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.OverbookedRoom_ColorChange();
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		//String a=GenericClass.GetCurrentWindowID();

  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.verify_OverbookedColorCode();
  		GenericClass.driver.close();
    	//GenericClass.Switch_Parent_Window(a);

    	System.out.println("HMS-7937 Executed");

    	Reporter.log("When color code for Overbooked Rooms is changed and 'Save' button is clicked on Manage Display Color,color gets changed for Overbooked Rooms on frontdesk under 'Room Legends'",true);

    	ExcelUtil.CloseAllExcelReferences();



    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}

    }


    /**
     * Change Color code for 'Touch-up Rooms'
     * @throws Throwable
     */

    @Test(priority=15,groups={"P1","DisplayColorsTest"},description="Change Color code for 'Touch-up Rooms'")
    public void HMS5903() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.TouchupRoom_ColorChange();
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		//String a=GenericClass.GetCurrentWindowID();

  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.verify_TouchupRColorCode();
  		HousekeepingLandingPage HLP=FLP.ClickOnHouseleepingLink();
  		GenericClass.fn_SwitchToWindow_Title("Housekeeping");
  		Thread.sleep(4000);
  		HLP.verify_TouchupColorCode();
  		GenericClass.driver.close();

  		System.out.println("HMS-5903 Executed");

  		Reporter.log("When color code for Touch-up Rooms is changed and 'Save' button is clicked on Manage Display Color,color gets changed for Touch-up Rooms on frontdesk and housekeeping console \n"
  				+ "under 'Housekeeping Legends' and 'House Status Legends' respectively.",true);

  		ExcelUtil.CloseAllExcelReferences();


    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}

    }


    /**
     * Change Color code for 'Dirty Rooms'
     * @throws Throwable
     */
    @Test(priority=16,groups={"P1","DisplayColorsTest"},description="Change Color code for 'Dirty Rooms'")
    public void HMS7940() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.DirtyRoom_ColorChange();
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		//String a=GenericClass.GetCurrentWindowID();

  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.verify_DirtyRColorCode();
  		HousekeepingLandingPage HLP=FLP.ClickOnHouseleepingLink();
  		GenericClass.fn_SwitchToWindow_Title("Housekeeping");
  		Thread.sleep(4000);
  		HLP.verify_DirtyColorCode();
  		GenericClass.driver.close();

  		System.out.println("HMS-7940 Executed");

  		Reporter.log("When color code for Dirty Rooms is changed and 'Save' button is clicked on Manage Display Color,color gets changed for Dirty Rooms on frontdesk and housekeeping console \n"
  		            + "under 'Housekeeping Legends' and 'House Status Legends' respectively.",true);

  		ExcelUtil.CloseAllExcelReferences();

    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }

    /**
     * Change Color code for 'Inspect Rooms'
     *
     * @throws Throwable
     */

    @Test(priority=17,groups={"P1","DisplayColorsTest"},description="Change Color code for 'Inspect Rooms'")
    public void HMS7941() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.InspectRoom_ColorChange();
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		//String a=GenericClass.GetCurrentWindowID();

  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.verify_InspectRColorCode();
  		HousekeepingLandingPage HLP=FLP.ClickOnHouseleepingLink();
  		GenericClass.fn_SwitchToWindow_Title("Housekeeping");
  		Thread.sleep(4000);
  		HLP.verify_InspectColorCode();
  		GenericClass.driver.close();

  		System.out.println("HMS-7941 Executed");

  		Reporter.log("When color code for Inspect Rooms is changed and 'Save' button is clicked on Manage Display Color,color gets changed for Inspect Rooms on frontdesk and housekeeping console \n"
  				 + "under 'Housekeeping Legends' and 'House Status Legends' respectively.",true);

  		ExcelUtil.CloseAllExcelReferences();

    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}

    }

    /**
     * Change Color code for 'Clean Rooms'
     * @throws Throwable
     */

    @Test(priority=18,groups={"P1","DisplayColorsTest"},description="Change Color code for 'Clean Rooms'")
    public void HMS7942() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.CleanRoom_ColorChange();
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		//String a=GenericClass.GetCurrentWindowID();

  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.verify_CleanRColorCode();
  		HousekeepingLandingPage HLP=FLP.ClickOnHouseleepingLink();
  		GenericClass.fn_SwitchToWindow_Title("Housekeeping");
  		Thread.sleep(4000);
  		HLP.verify_CleanColorCode();

  		System.out.println("HMS-7942 Executed");

  		Reporter.log("When color code for Clean Rooms is changed and 'Save' button is clicked on Manage Display Color,color gets changed for Clean Rooms on frontdesk and housekeeping console \n"
 				 + "under 'Housekeeping Legends' and 'House Status Legends' respectively.",true);

  		ExcelUtil.CloseAllExcelReferences();

    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }


    /**
     * Change Color code for 'Repair Rooms'
     * @throws Throwable
     */
    @Test(priority=19,groups={"P1","DisplayColorsTest"},description="Change Color code for 'Repair Rooms'")
    public void HMS7943() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.RepairRoom_ColorChange();
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		//String a=GenericClass.GetCurrentWindowID();

  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.verify_RepairRColorCode();
  		HousekeepingLandingPage HLP=FLP.ClickOnHouseleepingLink();
  		GenericClass.fn_SwitchToWindow_Title("Housekeeping");
  		Thread.sleep(4000);
  		HLP.verify_RepairColorCode();

  		GenericClass.driver.close();

  		System.out.println("HMS-7943 Executed");

  		Reporter.log("When color code for Repair Rooms is changed and 'Save' button is clicked on Manage Display Color,color gets changed for Repair Rooms on frontdesk and housekeeping console \n"
  				 + "under 'Housekeeping Legends' and 'House Status Legends' respectively.",true);

  		ExcelUtil.CloseAllExcelReferences();



    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }


    /**
     * Change Color code for 'Do Not Reserve (DNR)'
     * @throws Throwable
     */
    //@Test(priority=20,groups={"P1","DisplayColorsTest"},description="Change Color code for 'Do Not Reserve (DNR)'")
    public void HMS7944() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.DNRoom_ColorChange();
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		//String a=GenericClass.GetCurrentWindowID();

  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		Thread.sleep(4000);
  		FLP.verify_DNRColorCode1();
  		FLP.verify_DNRColorCode2();
  		HousekeepingLandingPage HLP=FLP.ClickOnHouseleepingLink();
  		GenericClass.fn_SwitchToWindow_Title("Housekeeping");
  		Thread.sleep(4000);
  		HLP.verify_DNRColorCode1();
  		HLP.verify_DNRColorCode2();
  		GenericClass.driver.close();

  		System.out.println("HMS-7944 Executed");

  		Reporter.log("When color code for Do Not Reserve Rooms is changed and 'Save' button is clicked on Manage Display Color,color gets changed for Do Not Reserve Rooms on frontdesk and housekeeping console \n"
 				 + "under 'Housekeeping Legends' and 'House Status Legends' respectively.",true);

  		ExcelUtil.CloseAllExcelReferences();


    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }

    /**
     * Save Alphabet code for 'Travel Agent Booking'
     * @throws Throwable
     */

    //@Test(priority=21,groups={"P1","DisplayColorsTest"},description="Save Alphabet code for 'Travel Agent Booking'")
    public void HMS5904() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.TABooking_codeChange(iTestCaseRow);
  		DCP.verify_TACodeChange(iTestCaseRow);
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
  		AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
  		String rtype= ARP.fn_addRoomName(1);
  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		//GenericClass.windowHandle(a);
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		//FLP.getCountOfRooms1();
        //FLP.WindowScroll();
  		FLP.fn_createFDReserv(rtype,"3","3");
  		Thread.sleep(3000);
  		EnableEditingPage EEP=FLP.fn_clkGroupLnk();
  		Thread.sleep(3000);
  		EEP.reserve_TABooking();
  		EEP.fillDetails_TABooking(iTestCaseRow);
  		FLP.fn_verifyReservation(iTestCaseRow);
  		WebReservationHomePage WRP=FLP.fn_WebReservationLink();
  		Thread.sleep(6000);
  		GenericClass.fn_SwitchToWindow_Title("Web Reservation");
        TALoginPage TAL=WRP.fn_NavigateToTAConsole();
        TAConsolePage TAC=TAL.fn_TALogin(iTestCaseRow);
        TASelectRoomPage TSP=TAC.fn_CheckAvability();
        TAAddMoreRoomPage TAAMP=TSP.fn_SelectRoomandRate();
        TAConfirmReservationPage TACP=TAAMP.ClickOnConfirmBtn();
        TAConfirmReservationPrintPage TACP1=TACP.ConfirmBooking1(iTestCaseRow,Constant.File_DislayColors);
        TACP1.fn_GetReservID();
        GenericClass.driver.close();
        GenericClass.fn_SwitchToWindow_Title("Frontdesk");
        ReservationSearchResultLandingPage RSP=FLP.fn_SearchReservationID(TACP1.reservID.trim());
        ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
        Thread.sleep(3000);
        VDP.verify_CodeChange(iTestCaseRow);

        System.out.println("HMS-5904 Executed");

  		Reporter.log("When alphabet code for Travel Agent Booking is changed and saved,it gets displayed for all TA bookings created from frontdesk tapechart as well as TA Console.",true);

  		ExcelUtil.CloseAllExcelReferences();

    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}


    }

    /**
     * Save Alphabet code for 'Corporate Booking'
     * @throws Throwable
     */

    @Test(priority=22,groups={"P1","DisplayColorsTest"},description="Save Alphabet code for 'Corporate Booking'")
    public void HMS7945() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.CorporateBooking_codeChange(iTestCaseRow);
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		DCP.verify_CorpCodeChange(iTestCaseRow);
  		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
  		AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
  		String rtype= ARP.fn_addRoomName(1);
  		//String a=GenericClass.GetCurrentWindowID();

  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		//GenericClass.windowHandle(a);
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		//FLP.getCountOfRooms1();
        //FLP.WindowScroll();
  		//FLP.fn_ResrvOneNT();
  		FLP.fn_createFDReserv(rtype,"3","3");
  		Thread.sleep(3000);
  		EnableEditingPage EEP=FLP.fn_clkGroupLnk();
  		Thread.sleep(3000);
  		EEP.reserve_CorporateBooking();
  		Thread.sleep(4000);
  		EEP.fillDetails_CorporateBooking(iTestCaseRow);
  		Thread.sleep(4000);
  		FLP.fn_verifyReservation(iTestCaseRow);
  		Thread.sleep(3000);
  		WebReservationHomePage WRP=FLP.fn_WebReservationLink();
  		Thread.sleep(3000);
  		GenericClass.fn_SwitchToWindow_Title("Web Reservation");
  		Thread.sleep(3000);
  		CorporateLoginPage CRP=WRP.fn_NavigateToCorpConsole();
  		Thread.sleep(6000);
  		CorporateConsolePage CRCP=CRP.fn_CorporateLogin(iTestCaseRow);
  		Thread.sleep(3000);
  		CorporateSelectRoomPage CRSP=CRCP.fn_CheckAvability();
  		Thread.sleep(3000);
  		CorporateAddMoreRoomPage CARP=CRSP.fn_SelectRoomandRate();
  		CorporateConfirmReservationPage CCRP=CARP.ClickOnConfirmBtn();
  		CorporateConfirmReservationPrintPage CRPP=CCRP.ConfirmBooking1(iTestCaseRow,Constant.File_DislayColors);
  		Thread.sleep(3000);
  		CRPP.fn_GetReservID();
  		GenericClass.driver.close();
        GenericClass.fn_SwitchToWindow_Title("Frontdesk");
        Thread.sleep(3000);
        ReservationSearchResultLandingPage RSP=FLP.fn_SearchReservationID(CorporateConfirmReservationPrintPage.reservID.trim());
        Thread.sleep(3000);
        ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
        VDP.verify_CodeChange(iTestCaseRow);

        System.out.println("HMS-7945 Executed");

  		Reporter.log("When alphabet code for Corporate Booking is changed and saved,it gets displayed for all Corporate bookings created from frontdesk tapechart as well as Corporate console.",true);

  		ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}

    }


    /**
     *  Save Alphabet code for 'Online/Web Booking'
     * @throws Throwable
     */

    @Test(priority=23,groups={"P1","DisplayColorsTest"},description="Save Alphabet code for 'Online/Web Booking'")
    public void HMS7946() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.OnlineWebBooking_codeChange(iTestCaseRow);
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		DCP.verify_OnlineCodeChange(iTestCaseRow);
  		RoomsLandingPage RLP=AH.fn_NavigateRooms();
  		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
  		//ARP.AddingRoom_DC(iTestCaseRow, AddRoomsPage.SaveAtBtm_Btn,Constant.File_DislayColors);
  		ARP.fn_addRoomName(1);
  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		WebReservationHomePage WRP=FLP.fn_WebReservationLink();
  		Thread.sleep(3000);
  		GenericClass.fn_SwitchToWindow_Title("Web Reservation");
  		Thread.sleep(3000);
  		WebSelectRoomPage WSR=WRP.fn_CheckAvability();
  		WebAddMoreRoomPage WAP=WSR.fn_SelectRoomandRate();
  		WebConfirmReservationPage WCP=WAP.ClickOnConfirmBtn();
  		WebConfirmReservationPrintPage WPP=WCP.ConfirmBooking1();
  		String id=WPP.fn_GetReservID();
  		GenericClass.driver.close();
        GenericClass.fn_SwitchToWindow_Title("Frontdesk");
        Thread.sleep(3000);
        ReservationSearchResultLandingPage RSP=FLP.fn_SearchReservationID(id.trim());
        Thread.sleep(3000);
        ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
        VDP.verify_CodeChange(iTestCaseRow);

        System.out.println("HMS-7946 Executed");

        Reporter.log("When alphabet code for Online/Web Booking is changed and saved,it gets displayed for all Online/Web bookings on frontdesk tapechart created from Web console.",true);

        ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;

    	}
    }



    /**
     * Save Alphabet code for 'Group Booking'
     * @throws Throwable
     */
    @Test(priority=24,groups={"P1","DisplayColorsTest"},description="Save Alphabet code for 'Group Booking'")
    public void HMS7947() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.GroupBooking_codeChange(iTestCaseRow);
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		DCP.verify_GroupCodeChange(iTestCaseRow);
  		RoomsLandingPage RLP=AH.fn_NavigateRooms();
  		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
  		//ARP.fn_SaveAndDuplicateMultpl2RM(iTestCaseRow,Constant.File_DislayColors);
  		String rtype=ARP.saveAndDuplicate(1);
  		AH.fn_getHotelName();
  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		//FLP.fn_clk2Rooms();
       // FLP.windowScrollUp();
        //FLP.fn_GroupResrvTwoRoom();
  		FLP.fn_createFDReserv(rtype,"3","3");
        FLP.fn_fillAddQuickResrv("2");
        Thread.sleep(2000);
        FLP.fn_verifyReservation(iTestCaseRow);
        Thread.sleep(2000);
  		WebReservationHomePage WRP=FLP.fn_WebReservationLink();
  		Thread.sleep(3000);
  		GenericClass.fn_SwitchToWindow_Title("Web Reservation");
  		Thread.sleep(3000);
  		WebSelectRoomPage WSP=WRP.fn_CheckAvability();
  		WebAddMoreRoomPage WAP=WSP.fn_SelectRoomandRate();
  		WAP.fn_selectNoOfRooms();
  		Thread.sleep(1000);
  		WebConfirmReservationPage WCP=WAP.ClickOnConfirmBtn();
  		WebConfirmReservationPrintPage WPP=WCP.ConfirmBooking1();
  		Thread.sleep(2000);
  		WPP.fn_GetReservIDG();
  		//GenericClass.driver.close();
        GenericClass.fn_SwitchToWindow_Title("Frontdesk");
        Thread.sleep(3000);
        ReservationSearchResultLandingPage RSP=FLP.fn_SearchReservationID(WPP.reservID.trim());
        Thread.sleep(3000);
        ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
        VDP.verify_CodeChange(iTestCaseRow);
    	FLP.fn_clkClose1();
    	Thread.sleep(2000);
    	FLP.fn_clkClose1();
    	Thread.sleep(2000);
    	EmailAccountLoginPage EAP=GenericClass.fn_OpenSpecificEmailBox(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser)), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
    	EmailHomePage EHP=EAP.DoSpecificEmailLogin(iTestCaseRow);
    	ArrayList<String> at=EHP.fn_navigateToSpecificInbox(iTestCaseRow);
    	Thread.sleep(2000);
    	GenericClass.driver.close();
        Thread.sleep(2000);
        WebGuestConsoleLoginPage WGCL=GenericClass.fn_OpenWebGuestConsolePage("FF", at.get(0).toString());
    	Thread.sleep(2000);
    	WebGuestConsoleLandingPage WGCLP=WGCL.DoLogin(at.get(1).toString(),at.get(2).toString(), at.get(3).toString());
        Thread.sleep(2000);
    	WebGuestStayDetailsPage WGS=WGCLP.ClickOnBookNow();
    	Thread.sleep(2000);
    	WebGuestSelectRoomPage WGSR=WGS.fn_CheckAvability();
    	Thread.sleep(2000);
    	WebGuestAddMoreRoomPage WGAMR=WGSR.SelectRoom();
    	Thread.sleep(2000);
    	WebGuestConfirmReservationPage WGCRP=WGAMR.ClickOnConfirmBtn();
    	Thread.sleep(2000);
    	WebGuestConfirmReservationPrintPage WCRPP=WGCRP.ConfirmBooking(iTestCaseRow);
    	Thread.sleep(2000);
    	String rid=WCRPP.GetReservationId();
    	Thread.sleep(2000);
    	GenericClass.switchToWindowHandle("Frontdesk");
    	Thread.sleep(2000);
        GenericClass.driver.navigate().refresh();
        Thread.sleep(2000);
        FLP.fn_ClickCancelButton();
        FLP.fn_SearchReservationID(rid.trim());
        Thread.sleep(3000);
        RSP.fn_ClickOnSearchedRecord();
        VDP.verify_CodeChange(iTestCaseRow);

        System.out.println("HMS-7947 Executed");

        Reporter.log("When alphabet code for Group Booking is changed and saved,it gets displayed for all Group bookings on frontdesk tapechart created from Web console.",true);

        ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }


    /**
     * Save Alphabet code for 'Other/GDS Booking'
     * @throws Throwable
     */
    @Test(priority=25,groups={"P1","DisplayColorsTest"},description="Save Alphabet code for 'Other/GDS Booking'")
    public void HMS7948() throws Throwable
    {
         try
         {
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.OtherGDSBooking_codeChange(iTestCaseRow);
  		DCP.fn_verifySuccessfulSaveMsg(iTestCaseRow);
  		DCP.verify_OtherGDSCodeChange(iTestCaseRow);// Reflections has been covered only for Manage Display Colors page  and not for Other/GDS/Channel  bookings

  		System.out.println("HMS-7948 Executed");

  		Reporter.log("When alphabet code for Other/GDS Booking is changed and saved,it gets displayed for all those bookings on frontdesk tapechart created from GDS/Channels",true);

  		ExcelUtil.CloseAllExcelReferences();

        }
        catch(Throwable e)
         {GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
 		ExcelUtil.CloseAllExcelReferences();
        	 throw e;
         }

    }


    /**
     * Verify Alphabet Code for Rooms that have been Reserved and Assigned.
     * @throws Throwable
     */
    @Test(priority=26,groups={"P1","DisplayColorsTest"},description="Verify Alphabet Code for Rooms that have been Reserved and Assigned.")
    public void HMS8932() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.get_ReservedAssignedCodeChange();

  		RoomsLandingPage  RLP=AH.fn_NavigateRooms();
  		AddRoomsPage ARP= RLP.ClickOnAddRoomLink();
  		String rtype= ARP.fn_addRoomName(1);
  		ConfirmLoginPage CLP= AH.ClickOnFrontdeskLink();
  		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
  		Thread.sleep(4000);
  		CashCounterPage CCP=CLP.fn_ClickCountinueWithTrail_BT();
  		Thread.sleep(4000);
  		FrontdeskLandingPage FLP=CCP.fn_ClickContinueButton();
  		Thread.sleep(4000);
  		FLP.fn_ClickCancelButton();
  		FLP.fn_clickCurrentLnk();
  		Thread.sleep(4000);
  		/*FLP.getCountOfRooms1();
  		FLP.fn_ResrvOneNT();
  		Thread.sleep(3000);*/
  		FLP.fn_createFDReserv(rtype,"3","3");
  		//FLP.fn_fillAddQuickResrv(iTestCaseRow,Constant.File_DislayColors);
  		FLP.fn_fillAddQuickResrv("1");
  		FLP.fn_verifyReservedAssigned();

  		System.out.println("HMS-8932 Executed");

  		Reporter.log("Alphabet code set for Reserved and Assigned rooms on 'Manage Display Colors' page in Admine Console gets displayed for all the reserved bookings on frontdesk tapechart \n"
  				+ "as well as on assigning rooms to reserved bookings",true);

 		ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
     		throw e;

    	}

    }

    /**
     * Verify 'Cancel' button on 'Manage display Colors' page.
     * @throws Throwable
     */
    @Test(priority=27,groups={"P2","DisplayColorsTest"},description="Verify 'Cancel' button on 'Manage display Colors' page.")
    public void HMS1801() throws Throwable
    {
    	try
    	{
    	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.ReservedRoom_ColorChangeCancel();
		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

  		System.out.println("HMS-1801 Executed");

  		Reporter.log("On clicking 'Cancel' button at the end of Manage Display Colors page after setting color code for Reserved rooms under 'Select Color Coding of Room status for the Front Desk tape chart' section,\n"
  				+"system cancel the current operation and navigate to the home page of Admin Console.",true);

		ExcelUtil.CloseAllExcelReferences();

    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		 throw e;

    	}
    }

    /**
     * Verify 'Cancel' button on 'Manage display Colors' page.
     * @throws Throwable
     */

    @Test(priority=28,groups={"P2","DisplayColorsTest"},description="Verify 'Cancel' button on 'Manage display Colors' page.")
    public void HMS8933() throws Throwable
    {
    	try
    	{
     	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();

  		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DislayColors,Constant.Sheet_DisplayColors);

  		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

  		DCP.ReservedRoom_ColorChangeCancelTop();
		Assert.assertEquals(GenericClass.driver.getTitle().equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

  		System.out.println("HMS-8933 Executed");

  		Reporter.log("On clicking 'Cancel' button at the top right corner Manage Display Colors page after setting color code for Reserved rooms under 'Select Color Coding of Room status for the Front Desk tape chart' section,\n"
  				+ "system cancel the current operation and navigate to the home page of Admin Console.",true);

  		ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }



    /**
     * To verify Audit Trail link on 'Manage Display Colors' page.
     * @throws Throwable
     */
    @Test(priority=29,groups={"P1","DisplayColorsTest"},description="To verify Audit Trail link on 'Manage Display Colors' page.")
    public void HMS1802() throws Throwable
    {
    	try
    	{
     	AdminHome AH=AL.adminlogin("12903","barkha.kapoor52@gmail.com","86bc0493");
  		DisplayColorsLandingPage DCP=AH.fn_NavigateDisplayColors();

  		DCP.fn_getColorCode();
  		DCP.ChangeColor_AuditTrail();
  		String a=GenericClass.GetCurrentWindowID();
  		DisplayColorsAuditTrail DCAT=DCP.click_AuditTrailLnk();
  		GenericClass.windowHandle(a);
        DCAT.verify_ChangedHistory();
        GenericClass.driver.close();
        GenericClass.Switch_Parent_Window(a);

        System.out.println("HMS-1802 Executed");

        Reporter.log("On clicking 'Audit Trail' link ,it displays history of changes made on 'Manage Display Colors' page.",true);

        ExcelUtil.CloseAllExcelReferences();
    	}
    	catch(Throwable e)
    	{GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		ExcelUtil.CloseAllExcelReferences();
    		throw e;
    	}
    }

	@AfterMethod
	public void Close_Br(){
	GenericClass.driver.quit();
	}
}
