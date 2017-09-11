package com.hms.hotelogix.automationframework.tests.admin.RoomsManager.Floors;


import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Test;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors.AddFloorPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors.AuditTrailPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors.FloorsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddMultipleRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.RoomsLandingPage;

@SuppressWarnings("static-access")
public class FloorTest {

	
	
	private String sTestCaseName;

	private int iTestCaseRow;
	
	@BeforeMethod
	public void Login() throws Exception {
		AdminLogin AL = GenericClass.fn_OpenAdmin("FF", "http://hotelogix.net/admine/login/login/");
		  AdminHome AH=AL.adminlogin("12904","akash.khanna610@gmail.com","168c507d");
		//AL.adminlogin_12302();
	  }
	
	@Test(priority=1, groups={"P0","FloorTest"},description="To verify Navigation to Floor List Page.")
	public void HMStc8691() throws Exception{
		try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Floors,Constant.Sheet_Floors);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AdminHome AH=new AdminHome();
		AH.fn_NavigateToFloors();
	    Assert.assertEquals(GenericClass.driver.getTitle().equalsIgnoreCase(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
	    System.out.println("HMStc-1587 is passed");
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		 throw e;
		}
	    }
	
	
	@Test(priority=2, groups={"P1","FloorTest"},description="To verify the presence of all the Links, buttons and fields on 'FloorsList' page.")
	public void HMStc1587_8842() throws Exception{
		try{
			AdminHome AH=new AdminHome();
			FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		    FLP.check_elements();
		    System.out.println("HMStc-1587 is passed");
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	

	@Test(priority=3, groups={"P0","FloorTest"},description="Navigate Add a Floor page, Verifying all link, buttons and fields on the page.")
	public void HMStc8311_8844_8845() throws Exception{
		try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Floors,Constant.Sheet_Floors);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		  AdminHome AH=new AdminHome();
		  FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		  AddFloorPage AFP=FLP.Click_AnyButtonOrLink(FLP.AddaFloor_btn);
		  GenericClass.switchToWindowHandle("Add Floor");
		  Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		  Thread.sleep(3000);
		  Assert.assertEquals(AFP.Cancel_Btn.isDisplayed() && AFP.Cancel_Btn.isEnabled(),true);
		  Assert.assertEquals(AFP.Save_Btn.isDisplayed() && AFP.Save_Btn.isEnabled(),true);
		  GenericClass.driver.close();
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	}

	@Test(priority=4, groups={"P0","FloorTest"},description="To verify the functionality of Save button on the page with valid data.Verified reflected points.")
	public void HMStc1588() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		AddFloorPage AFP=FLP.Click_AnyButtonOrLink(FLP.AddaFloor_btn);
		GenericClass.switchToWindowHandle("Add Floor");
		String floorname=GenericClass.generateRandomString();
		AFP.fn_AddFloor(floorname, AFP.Btn_Save);
		GenericClass.switchToWindowHandle("Floors List");
		List<String> arr=FLP.fn_VerifyAddedFloor();
		Assert.assertEquals(arr.contains(floorname), true);
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		List<String> arr1=FLP.fn_CheckblocknameinDropDown(RLP.FloorFilter_DD);
		Assert.assertEquals(arr1.contains(floorname), true);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		List<String> arr2=FLP.fn_CheckblocknameinDropDown(ARP.drpdown_Floor);
		Assert.assertEquals(arr2.contains(floorname), true);
		GenericClass.clickElement(ARP.link_RoomList);
		Thread.sleep(2000);
		AddMultipleRoomsPage AMP=RLP.ClickOnAddMultipleRoom_Link();
		List<String> arr3=FLP.fn_CheckblocknameinDropDown(AMP.Drpdwn_FloorType);
		Assert.assertEquals(arr3.contains(floorname), true);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		
	}
		
	
	@Test(priority=5, groups={"P0","FloorTest"},description="To verify Alert msg after adding duplicate floor name.")
	public void HMStc1589() throws Exception{
		try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Floors,Constant.Sheet_Floors);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		AddFloorPage AFP=FLP.Click_AnyButtonOrLink(FLP.AddaFloor_btn);
		GenericClass.switchToWindowHandle("Add Floor");
		String floorname=GenericClass.generateRandomString();
		AFP.fn_AddFloor(floorname,AFP.Btn_Save);
		GenericClass.switchToWindowHandle("Floors List");
		FLP.Click_AnyButtonOrLink(FLP.AddaFloor_btn);
		GenericClass.switchToWindowHandle("Add Floor");
		AFP.fn_AddFloor(floorname,AFP.Btn_Save);
		String str=GenericClass.getText(AFP.Duplicate_Msg);
		String val= ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1));
		Assert.assertEquals(str.equalsIgnoreCase(val), true);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	}
	
	
	@Test(priority=6, groups={"P2","FloorTest"},description="To verify Alert msg when adding floor without data.")
	public void HMStc1590() throws Exception{
		try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Floors,Constant.Sheet_Floors);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		AddFloorPage AFP=FLP.Click_AnyButtonOrLink(FLP.AddaFloor_btn);
		GenericClass.switchToWindowHandle("Add Floor");
		AFP.fn_AddFloor("", AFP.Save_Btn);
		String alertext=GenericClass.ActionOnAlert("Accept");
		Assert.assertEquals(alertext.equalsIgnoreCase(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	}
	
	@Test(priority=7, groups={"P2","FloorTest"},description="To verify functionality of Cancel button on 'Add a Floor' page.")
	public void HMStc1591_1597() throws Exception{
		try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Floors,Constant.Sheet_Floors);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		AddFloorPage AFP=FLP.Click_AnyButtonOrLink(FLP.AddaFloor_btn);
		GenericClass.switchToWindowHandle("Add Floor");
		AFP.fn_AddFloor("Test", AFP.Cancel_Btn);
		GenericClass.switchToWindowHandle("Floors List");
		Assert.assertEquals(GenericClass.driver.getTitle().equalsIgnoreCase(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	}

	
	@Test(priority=8, groups={"P0","FloorTest"},description="Delete floor and verified reflections points.")
	public void HMStc1592_8692_8693() throws Exception{
		try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Floors,Constant.Sheet_Floors);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		AddFloorPage AFP=FLP.Click_AnyButtonOrLink(FLP.AddaFloor_btn);
		GenericClass.switchToWindowHandle("Add Floor");
		String floorname=GenericClass.generateRandomString();
		AFP.fn_AddFloor(floorname, AFP.Save_Btn);
		GenericClass.switchToWindowHandle("Floors List");
		GenericClass.selectElement(FLP.ViewDropdown_section, "All");
		GenericClass.alert_handle();
		FLP.VerifyDeletedFloor(floorname);
		GenericClass.clickElement(FLP.DeleteSelFloor_btn);
		String alerttext=GenericClass.ActionOnAlert("Dismiss");
		Assert.assertEquals(alerttext.equalsIgnoreCase(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		GenericClass.clickElement(FLP.DeleteSelFloor_btn);
		GenericClass.ActionOnAlert("Accept");
		List<String> arr=FLP.VerifyDeletedFloor(floorname);
		Assert.assertEquals(arr.contains(floorname), false);
		RoomsLandingPage RLP = AH.fn_NavigateRooms();
		List<String> arr1=FLP.fn_CheckblocknameinDropDown(RLP.FloorFilter_DD);
		Assert.assertEquals(arr1.contains(floorname), false);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		List<String> arr2=FLP.fn_CheckblocknameinDropDown(ARP.drpdown_Floor);
		Assert.assertEquals(arr2.contains(floorname), false);
		GenericClass.clickElement(ARP.link_RoomList);
		Thread.sleep(2000);
		AddMultipleRoomsPage AMP=RLP.ClickOnAddMultipleRoom_Link();
		List<String> arr3=FLP.fn_CheckblocknameinDropDown(AMP.Drpdwn_FloorType);
		Assert.assertEquals(arr3.contains(floorname), false);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
		
	
	@Test(priority=9, groups={"P2","FloorTest"},description="To verify Cancel button on Floor landing page.")
	public void HMStc1593() throws Exception{
		try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Floors,Constant.Sheet_Floors);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		FLP.Click_AnyButtonOrLink(FLP.Cancel_btn);
		Assert.assertEquals(GenericClass.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	@Test(priority=10, groups={"P1","FloorTest"},description="To verify 'Main' link in Floor List page.")
	public void HMStc1630() throws Exception{
		try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Floors,Constant.Sheet_Floors);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		FLP.Click_AnyButtonOrLink(FLP.Main_link);
		Assert.assertEquals(GenericClass.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
		
	@Test(priority=11, groups={"P2","FloorTest"},description="To verify all check boxes by select or deselect.")
	public void HMStc5889_8852() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		FLP.SelectAll_checkbox();
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	@Test(priority=12, groups={"P2","FloorTest"},description="To verify functionality of Master Check box by select and deselect.")
	public void HMStc1595_8851() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		FLP.master_checkbox();
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}

	@Test(priority=13, groups={"P1","FloorTest"},description=" To verify whether 'Add New' link save the room and increase room count or not.")
	public void HMStc8575_8576_9096() throws Exception{
		try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Floors,Constant.Sheet_Floors);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		AddRoomsPage arp=FLP.fn_ClickAddNew_Link();
		Assert.assertEquals(GenericClass.driver.getTitle(), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		String roomname=GenericClass.generateRandomString();
		RoomsLandingPage RLP=arp.fn_AddRoom(roomname,"Test");
		RLP.VerifyAddedRoom(roomname);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
		
	@Test(priority=14, groups={"P0","FloorTest"},description="To verify Editing a Floor. Verified reflected point.")
	public void HMStc1596() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		String beforeedit=FLP.fn_GetFirstFloorname();
		AddFloorPage AFP=FLP.Click_AnyButtonOrLink(FLP.Edit_btn);
		GenericClass.switchToWindowHandle("Edit Floor");
		AFP.fn_Editfloor(AFP.Title_Box, GenericClass.generateRandomString());
		GenericClass.switchToWindowHandle("Floors List");
		String edited=FLP.fn_GetFirstFloorname();
		Assert.assertEquals(beforeedit.equalsIgnoreCase(edited),false);
		RoomsLandingPage rlp=AH.fn_NavigateRooms();
		List<String> arr=FLP.fn_CheckblocknameinDropDown(rlp.FloorFilter_DD);
		Assert.assertEquals(arr.contains(edited), true);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	
	@Test(priority=15, groups={"P2","FloorTest"},description="To verify the Cancel button of editing a Floor page.")
	public void HMStc5900() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		String floorname=FLP.fn_GetFirstFloorname();
		FLP.fn_ActivateAndDeactivateFirstFloor("on.GIF");
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		List<String> arr1=FLP.fn_CheckblocknameinDropDown(RLP.FloorFilter_DD);
		Assert.assertEquals(arr1.contains(floorname), false);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		List<String> arr2=FLP.fn_CheckblocknameinDropDown(ARP.drpdown_Floor);
		Assert.assertEquals(arr2.contains(floorname), false);
		GenericClass.clickElement(ARP.link_RoomList);
		Thread.sleep(2000);
		AddMultipleRoomsPage AMP=RLP.ClickOnAddMultipleRoom_Link();
		List<String> arr3=FLP.fn_CheckblocknameinDropDown(AMP.Drpdwn_FloorType);
		Assert.assertEquals(arr3.contains(floorname), false);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	
	@Test(priority=16, groups={"P1","FloorTest"},description="To verify activation of floor and coverd reflected points.")
	public void HMStc8697() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		String floorname=FLP.fn_GetFirstFloorname();
		FLP.fn_ActivateAndDeactivateFirstFloor("off.GIF");
		RoomsLandingPage RLP=AH.fn_NavigateRooms();
		List<String> arr1=FLP.fn_CheckblocknameinDropDown(RLP.FloorFilter_DD);
		Assert.assertEquals(arr1.contains(floorname), true);
		AddRoomsPage ARP=RLP.ClickOnAddRoomLink();
		List<String> arr2=FLP.fn_CheckblocknameinDropDown(ARP.drpdown_Floor);
		Assert.assertEquals(arr2.contains(floorname), true);
		GenericClass.clickElement(ARP.link_RoomList);
		Thread.sleep(2000);
		AddMultipleRoomsPage AMP=RLP.ClickOnAddMultipleRoom_Link();
		List<String> arr3=FLP.fn_CheckblocknameinDropDown(AMP.Drpdwn_FloorType);
		Assert.assertEquals(arr3.contains(floorname), true);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	
	@Test(priority=17, groups={"P2","FloorTest"},description="To verify View records per page dropdown in Floors List.")
	public void HMStc5896() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		int numofrecord=FLP.fn_VerifyRecordDropdown(FLP.ViewDropdown_section, "1");
		Assert.assertEquals(numofrecord-2, 1);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	
	@Test(priority=18, groups={"P2","FloorTest"},description="To verify Page dropdown in Floor List page.")
	public void HMStc1648() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		int numofrecord=FLP.fn_VerifyPageDropdown(FLP.PageDropdown_section, FLP.ViewDropdown_section, "1", "1");
		Assert.assertEquals(numofrecord-2, 1);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	
	@Test(priority=19, groups={"P1","FloorTest"},description="Select All record from view dropdown and verify Alert msg.")
	public void HMStc9097_9098() throws Exception{
		try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Floors,Constant.Sheet_Floors);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		GenericClass.selectElement(FLP.ViewDropdown_section, "All");
		String val=GenericClass.ActionOnAlert("Dismiss");
		Assert.assertEquals(val, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	
	@Test(priority=20, groups={"P1","FloorTest"},description="Select All record from view dropdown.")
	public void HMStc9099() throws Exception{
		try{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_Floors,Constant.Sheet_Floors);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		GenericClass.selectElement(FLP.ViewDropdown_section, "All");
		String val=GenericClass.ActionOnAlert("Accept");
		Assert.assertEquals(val, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	
	@Test(priority=21, groups={"P2","FloorTest"},description="To verify Next link in Floor List page,")
	public void HMStc1649() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		String firstpage=FLP.fn_GetFirstFloorname();
		FLP.fn_VerifyPageDropdown(FLP.ViewDropdown_section, FLP.PageDropdown_section, "1", "1");
		GenericClass.clickElement(FLP.Next_Link);
		Thread.sleep(2000);
		String secondpage=FLP.fn_GetFirstFloorname();
		Assert.assertEquals(firstpage.equalsIgnoreCase(secondpage),false);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	
	@Test(priority=22, groups={"P2","FloorTest"},description="To verify Previous in Floor List page.")
	public void HMStc1650() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		String firstpage=FLP.fn_GetFirstFloorname();
		FLP.fn_VerifyPageDropdown(FLP.ViewDropdown_section, FLP.PageDropdown_section, "1", "1");
		GenericClass.clickElement(FLP.Next_Link);
		Thread.sleep(2000);
		Assert.assertEquals(FLP.Previous_Link.isDisplayed() && FLP.Previous_Link.isEnabled(), true);
		GenericClass.clickElement(FLP.Previous_Link);
		Thread.sleep(2000);
		String first=FLP.fn_GetFirstFloorname();
		Assert.assertEquals(firstpage.equalsIgnoreCase(first), true);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	@Test(priority=23, groups={"P1","FloorTest"},description="Click on AuditTrail link and verify updation in AuditTrail page.")
	public void HMStc1651() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		AddFloorPage AFP=FLP.Click_AnyButtonOrLink(FLP.Edit_btn);
		GenericClass.switchToWindowHandle("Edit Floor");
		String editedfloorname=GenericClass.generateRandomString();
		AFP.fn_Editfloor(AFP.Title_Box, editedfloorname);
		GenericClass.switchToWindowHandle("Floors List");
		AuditTrailPage ATP=FLP.fn_ClickAuditTrail_Link();
		GenericClass.switchToWindowHandleByURL("http://hotelogix.stayezee.com/admine/audittrail/popup/controllerName/floors/id/");
		List<String> arr=ATP.verify_ChangedHistory(editedfloorname);
		Assert.assertEquals(arr.contains(editedfloorname),true);
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	@Test(priority=24, groups={"P2","FloorTest"},description="To verify short floor name by using upward and downward arrow.")
	public void HMStc1598_8696() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		FLP.SortFloors();
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}
	
	@Test(priority=25, groups={"P2","FloorTest"},description="To verify short floor status by using upward and downward arrow.")
	public void HMStc1599_8853() throws Exception{
		try{
		AdminHome AH=new AdminHome();
		FloorsLandingPage FLP=AH.fn_NavigateToFloors();
		FLP.SortByStatus();
		} catch (Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
		}

	@AfterMethod
	public void CloseAPP() throws Exception{
	        GenericClass.driver.quit();

	}
	
	
}
