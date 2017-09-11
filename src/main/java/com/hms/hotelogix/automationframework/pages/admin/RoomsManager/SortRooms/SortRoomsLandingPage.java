package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.SortRooms;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.ConfirmLoginPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class SortRoomsLandingPage {

	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/td")
	public  List<WebElement> AllTheRooms;
	
	@FindBy(xpath="//a[text()='| Frontdesk']")
	public WebElement Link_Frontdesk;
	
	@FindBy(xpath="//td[text()='Sort Rooms']")
	public  WebElement Heading_Page;
	
	@FindBy(xpath="//a[text()='Main']")
	public  WebElement Link_Main;

	@FindBy(xpath="//a[text()='Save Sort Order']")
	public  WebElement Btn_SaveSortOrder;

	@FindBy(xpath="//a[text()='Cancel']")
	public  WebElement Btn_Cancel;

	@FindBy(xpath="//a[text()='AuditTrail']")
	public  WebElement Link_AuditTrail;
	
	@FindBy(xpath="//td[@id='errorTd']")
	public  WebElement Msg_Validation;

	@FindBy(xpath="//td[@id='errorTd']/strong")
	public  WebElement Msg_CountDownValidation;

	@FindBy(xpath="//table[@class='list_viewnew']//tr")
	public  List<WebElement> TabRowtr_AllTable;	
	
	
	/**
	 * This method ensures that the Room we are looking exist in the sort room landing page.	
	 * @param iTestCaseRow : This parameter is used for getting room name from the external file (Test data handling).
	 * @throws Exception: throws exception if any occurs.
	 */
	public void VerifyRoom(String room) throws Exception{
		ArrayList<String> rooms=new ArrayList<String>();
		try{
			//String rname=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber));
			for(int i=0;i<AllTheRooms.size()-1;i++){
				AllTheRooms=GenericClass.driver.findElements(By.xpath("//table[@class='list_viewnew']/tbody/tr/td"));
				String Rname=AllTheRooms.get(i).getText();
				rooms.add(Rname);
				if(room.equals(Rname)){
					Assert.assertTrue(room.equals(Rname));
					break;
				}
			}
			Assert.assertEquals(rooms.contains(room),true);
			Reporter.log("ADDED ROOMS VERIFIED IN SORT ROOMS MODULE.", true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
			
	

	public ConfirmLoginPage fn_ClickOnFrontdesk() throws Exception{
		try{
			GenericClass.clickElement(Link_Frontdesk);
			return PageFactory.initElements(GenericClass.driver, ConfirmLoginPage.class);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * This method ensures that the deleted room doesn't appears in sort rooms landing page.
	 * @param s : This parameter is room name for which we are checking that room name doesn't exist anymore.
	 * @return 
	 */
	public ArrayList<String> VerifyDeletedRoom(){
		try{
			ArrayList<String> coll= new ArrayList<String>();
			for(int i=0;i<AllTheRooms.size()-1;i++){
				AllTheRooms=GenericClass.driver.findElements(By.xpath("//table[@class='list_viewnew']/tbody/tr/td"));
				String Rname=AllTheRooms.get(i).getText();
			     coll.add(Rname);
				}
			return coll;
				}catch(Exception e){
					throw e;
				}
			}
	
	/**
	 * This method ensures that the deactivated rooms doesn't appears on sort room landing page anymore.
	 * @param s : This parameter fetch the deactivated room for checking that the room exists or not.
	 */
	public void VerifyDeactivatedRooms(String s){
		try{
		for(int i=0;i<AllTheRooms.size()-1;i++){
		AllTheRooms=GenericClass.driver.findElements(By.xpath("//table[@class='list_viewnew']/tbody/tr/td"));
		String Rname=AllTheRooms.get(i).getText();
		Assert.assertFalse(s.equals(Rname));
	     }
		Reporter.log("Deactivated ROOMS VERIFIED IN SORT ROOMS MODULE. And it is not persent.", true);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * This method is used for verifying the elements on Sort room landing page. 
	 * @throws Exception : throws exception if any occurs.
	 */
	public  void VerifyPageElements() throws Exception {
			try{
		GenericClass.checkElementDisplay("Page header " ,Heading_Page);
			GenericClass.checkElementDisplay("Main link", Link_Main);
			GenericClass.checkElementDisplay("Save sort order ",  Btn_SaveSortOrder);
			GenericClass.checkElementDisplay("Link AuditTrail", Link_AuditTrail);
			GenericClass.checkElementDisplay("Cancel button", Btn_Cancel);
			}catch(Exception e){
				throw e;
			}
		}
	
	/**
	 * This method is used for clicking on main link on sort room page.	
	 * @return: As it returns AdminHome page and initializes all it's elements.
	 * @throws Exception :throws exception if any occurs.
	 */
	public AdminHome ClickOnMain() throws Exception{
		try{
		GenericClass.clickElement(Link_Main);
		AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
		return AH;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	/**
	 * This method clicks on cancel button on Sort Rooms landing page.	
	 * @return : As this method returns AdminHome page and initializes all it's element.
	 * @throws Exception
	 */
	public AdminHome ClickOnCancel() throws Exception{
	try{
		GenericClass.clickElement(Btn_Cancel);
	AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
	return AH;
	}catch(Exception e){
		throw e;
	}
	}
		
		
	/**
	 * This method is used for getting room number and it's sort order.	
	 * @return
	 */
	public ArrayList<String> GetPageData(){
		try{
		ArrayList<String> ar=new ArrayList<String>();
		int size=TabRowtr_AllTable.size();
		for(int i=2; i<=size-(size-3);i++){
			String roomName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[1]")).getText();
			ar.add(roomName);
			String oldSortValue=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input[1]")).getAttribute("value");
			ar.add(oldSortValue);
		}
		return ar;
		}catch(Exception e){
			throw e;
			
		}
		
	}
	
	
	/**
	 * This method used for to give sort order to room numbers.
	 * @param iTestCaseRow : This parameter is used for test data handling.
	 * @throws Exception : throws exception if any occurs.
	 */
	public void SetSortOrder(int iTestCaseRow) throws Exception{
		try{
		GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td[2]/input[1]")).clear();
		GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td[2]/input[1]")).sendKeys(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_SortOrder)));	
		GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[3]//td[2]/input[1]")).sendKeys(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_SortOrder1)));
		GenericClass.clickElement(Btn_SaveSortOrder);
		}catch(Exception e){
			throw e;
		}
	}
}
