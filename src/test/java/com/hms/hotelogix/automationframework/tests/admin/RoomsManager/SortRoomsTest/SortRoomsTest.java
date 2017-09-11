package com.hms.hotelogix.automationframework.tests.admin.RoomsManager.SortRoomsTest;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.CashCounterPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.ConfirmLoginPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskLoginPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.RoomTypesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.SortRooms.SortRoomsLandingPage;

public class SortRoomsTest {



	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	private AdminHome AH=new AdminHome();



@BeforeMethod()
public void Login() throws Exception{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
AdminLogin AL=GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser)), "http://hotelogix.stayezee.com/admine/");
AH = AL.adminlogin("13135", "vj@stayzee.com", "deepak");// for http://hotelogix.stayezee.com/admine/
//AH=AL.fn_adminLogin("12487","deepakTest3@stayezee.com","18e44afe");// //http://livestable.hx.local/admine/ url.
ExcelUtil.CloseAllExcelReferences();
Reporter.log("Login Successfull", true);
}


// Directing to Sort Rooms page
@Test(priority=1,description="Directing to Sort Rooms page",groups={"P0","SortRoomsTest"})
public void HMS8838() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
//AL.adminlogin(iTestCaseRow);
SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
Reporter.log("Landed to sort room page", true);
Assert.assertEquals(GenericClass.getText(SRL.Heading_Page), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Page header verified", true);
ExcelUtil.CloseAllExcelReferences();
Reporter.log("Directing to Sort Rooms page", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;
}
}

//To verify Title on Sort Rooms page.
@Test(priority=2,description="To verify Title on Sort Rooms page.",groups={"P1","SortRoomsTest"})
public void HMS1790() throws Exception{
	try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		//AL.adminlogin(iTestCaseRow);
		SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
	Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Reporter.log("Page Title verified", true);
	ExcelUtil.CloseAllExcelReferences();


	Reporter.log("To verify Title on Sort Rooms page.", true);


	}
	catch(Throwable e){
		GenericClass.getscreenshot(sTestCaseName);
		ExcelUtil.CloseAllExcelReferences(); 
		throw  e;
	}

	}


// Verify elements on Sort Rooms Page
@Test(priority=3,description="Verify elements on Sort Rooms Page",groups={"P1","SortRoomsTest"})
public void HMS8839() throws Exception{
	try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		//AL.adminlogin(iTestCaseRow);
		SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
	SRL.VerifyPageElements();
	Reporter.log("All the page elements are verified", true);
}
	catch(Throwable e){
		GenericClass.getscreenshot(sTestCaseName);
		ExcelUtil.CloseAllExcelReferences();
	}

}



//To verify "Main" link on Sort Rooms page.
@Test(priority=4,description="To verify 'Main' link on Sort Rooms page.",groups={"P1","SortRoomsTest"})
public void HMS1795() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
//AL.adminlogin(iTestCaseRow);
SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
SRL.ClickOnMain();
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
Assert.assertEquals(GenericClass.driver.getTitle(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
ExcelUtil.CloseAllExcelReferences();
Reporter.log("To verify 'Main' link on Sort Rooms page.", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;
}
}


//Save Sort Order without data.
@Test(priority=5,description="Save Sort Order",groups={"P1","SortRoomsTest"})
public void HMS1791() throws Exception{
try{
sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
//AL.adminlogin(iTestCaseRow);
SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
GenericClass.clickElement(SRL.Btn_SaveSortOrder);
Assert.assertEquals(GenericClass.getText(SRL.Msg_Validation),ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Validation msg verified after clicking on save sort order button",true);
ExcelUtil.CloseAllExcelReferences();
Reporter.log("To verify 'Save Sort Order saved successfully'", true);
}
catch(Throwable e){
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences(); 
throw  e;
}
}




//To 'Save Sort Order' when any user is logged in to the frontdesk.
@Test(priority=6,description="To 'Save Sort Order' when any user is logged in to the frontdesk.",groups={"P1","SortRoomsTest"})
public void HMS7969() throws Exception{
	try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		//AdminHome AH=AL.adminlogin(iTestCaseRow);
		SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
		String a=GenericClass.GetCurrentWindowID();
		ConfirmLoginPage  CLP=AH.ClickOnFrontdeskLink();
		GenericClass.windowHandle(a);
		CashCounterPage  CCP=CLP.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage  FLP=CCP.fn_ClickContinueButton();
		FLP.fn_ClickCancelButton();
		GenericClass.Switch_Parent_Window(a);
		GenericClass.clickElement(SRL.Btn_SaveSortOrder);
		GenericClass.ActionOnAlert("Accept");
		Assert.assertEquals(GenericClass.value,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log("Validation msg verified after clicking on save sort order button",true);
		ExcelUtil.CloseAllExcelReferences();

		Reporter.log("To 'Save Sort Order' when any user is logged in to the frontdesk.", true);



	}
	catch(Throwable e){
		GenericClass.getscreenshot(sTestCaseName);
		ExcelUtil.CloseAllExcelReferences(); 
		throw  e;
	}
}



//To "Cancel" the Save sort order Pop-Up
@Test(priority=7,description="To 'Cancel' the Save sort order Pop-Up",groups={"P2","SortRoomsTest"})
public void HMS7977() throws Exception{
	try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		//AdminHome AH=AL.adminlogin(iTestCaseRow);
		SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
		String a=GenericClass.GetCurrentWindowID();
		ConfirmLoginPage  CLP=AH.ClickOnFrontdeskLink();
		GenericClass.windowHandle(a);
		CashCounterPage  CCP=CLP.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage  FLP=CCP.fn_ClickContinueButton();
		FLP.fn_ClickCancelButton();
		GenericClass.Switch_Parent_Window(a);
		GenericClass.clickElement(SRL.Btn_SaveSortOrder);
		GenericClass.ActionOnAlert("Dismiss");
		Thread.sleep(2000);
		Assert.assertEquals(GenericClass.getText(SRL.Heading_Page),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Reporter.log("We are on the Sort room landing page after dismissing the pop up,while saving save sort order.",true);
		ExcelUtil.CloseAllExcelReferences();

		Reporter.log("To 'Cancel' the Save sort order Pop-Up", true);


	}
	catch(Throwable e){
		GenericClass.getscreenshot(sTestCaseName);
		ExcelUtil.CloseAllExcelReferences(); 
		throw  e;
	}
}






//To verify the OK button on 'Save Sort order' pop-up
@Test(priority=8,description="To verify the OK button on 'Save Sort order' pop-up",groups={"P0","SortRoomsTest"})
public void HMS7971() throws Exception{
	try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		//AdminHome AH=AL.adminlogin(iTestCaseRow);
		SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
		String a=GenericClass.GetCurrentWindowID();
		ConfirmLoginPage  CLP=AH.ClickOnFrontdeskLink();
		GenericClass.windowHandle(a);
		CashCounterPage  CCP=CLP.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage  FLP=CCP.fn_ClickContinueButton();
		FLP.fn_ClickCancelButton();
		GenericClass.Switch_Parent_Window(a);
		GenericClass.clickElement(SRL.Btn_SaveSortOrder);
		GenericClass.ActionOnAlert("Accept");
		Thread.sleep(2000);
		Assert.assertTrue(GenericClass.getText(SRL.Msg_CountDownValidation).contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
		Reporter.log("Count down time validation message verified after clicking on Save Sort order..",true);
		ExcelUtil.CloseAllExcelReferences();

		Reporter.log("To verify the OK button on 'Save Sort order' pop-up", true);

	}
	catch(Throwable e){
		GenericClass.getscreenshot(sTestCaseName);
		ExcelUtil.CloseAllExcelReferences(); 
		throw  e;
	}
}


//Save Sort Order and wait to forcefully log out the logged-in users.
@Test(priority=9,description="Save Sort Order and wait to forcefully log out the logged-in users.",groups={"P0","SortRoomsTest"})
public void HMS8931() throws Exception{
	try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		//AdminHome AH=AL.adminlogin(iTestCaseRow);
		SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
		String a=GenericClass.GetCurrentWindowID();
		ConfirmLoginPage  CLP=AH.ClickOnFrontdeskLink();
		GenericClass.windowHandle(a);
		CashCounterPage  CCP=CLP.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage  FLP=CCP.fn_ClickContinueButton();
		FLP.fn_ClickCancelButton();
		GenericClass.Switch_Parent_Window(a);
		Thread.sleep(2000);
		GenericClass.clickElement(SRL.Btn_SaveSortOrder);
		GenericClass.ActionOnAlert("Accept");
		Thread.sleep(2000);
		Assert.assertTrue(GenericClass.getText(SRL.Msg_CountDownValidation).contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
		Thread.sleep(240000);
		GenericClass.fn_SwitchToWindow_Title("Frontdesk");
		Thread.sleep(2000);
		Assert.assertEquals(GenericClass.driver.findElement(By.xpath("//h1[contains(text(),'Welcome to Hotelogix')]")).getText().trim(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		Reporter.log("Count down time validation message verified after clicking on Save Sort order..",true);
        Reporter.log("Save Sort Order and wait to forcefully log out the logged-in users.", true);
		ExcelUtil.CloseAllExcelReferences();
	}
	catch(Throwable e){
		GenericClass.getscreenshot(sTestCaseName);
		ExcelUtil.CloseAllExcelReferences(); 
		throw  e;
	}
}



//To verify "Cancel" button on Sort Rooms page.
@Test(priority=10,description="Verify delete icon for add slab field",groups={"P2","SortRoomsTest"})
public void HMS1796() throws Exception{
		try{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			//AdminHome AH=AL.adminlogin(iTestCaseRow);
			SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
			SRL.ClickOnCancel();
			Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			Reporter.log("Administrator home page verified after clicking on Cancel button", true);



			ExcelUtil.CloseAllExcelReferences();
		}
		catch(Throwable e){
			GenericClass.getscreenshot(sTestCaseName);
			ExcelUtil.CloseAllExcelReferences(); 
			throw  e;
		}


	}

//To "Save sort order" when no user is logged in.
@Test(priority=11,description="Verify delete icon for add slab field",groups={"P0","SortRoomsTest"})
public void HMS7974() throws Exception{
	try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_SortRooms,Constant.Sheet_SortRooms);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		//AdminHome AH=AL.adminlogin(iTestCaseRow);
		SortRoomsLandingPage SRL=AH.fn_navigateToSortRooms();
		ArrayList<String> ar=SRL.GetPageData();
		SRL.SetSortOrder(iTestCaseRow);
		GenericClass.ActionOnAlert("Accept");
	    Reporter.log("save sort order saved successfully.", true);



		ExcelUtil.CloseAllExcelReferences();
	}
	catch(Throwable e){
		GenericClass.getscreenshot(sTestCaseName);
		ExcelUtil.CloseAllExcelReferences(); 
		throw  e;
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
