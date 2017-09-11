package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class AddMultipleRoomsPage {
	
	public static String rtype;
	public static String floor;
	public static String block;
	public static String prefixForRoom="1";
	
	
	
	@FindBy(xpath="//td[text()='Add Multiple Rooms']")	
	public  WebElement lbls_AddMultipleRooms;
	
	
	@FindBy(xpath="//td[@class='padingtd']/table/tbody/tr/th")
	public  WebElement Txt_FillDetail;
	
	
	@FindBy(xpath="//div[@id='listing-icons']/ul/li[2]/input")
	public  WebElement Btn_SaveAtTop;
	
	
	@FindBy(xpath="//div[@id='listing-icons']/ul/li[1]/input")
	public  WebElement Btn_CancelAtTop;
	
	
	@FindBy(xpath="//td[@class='comments']/input[1]")
	public  WebElement Btn_SaveAtBtm;
	
	@FindBy(xpath="//td[@class='comments']/input[2]")
	public  WebElement Btn_CancelAtBtm;
	
	
	@FindBy(xpath="//textarea[@name='rmNameOrNoMulName[]']")
	public  WebElement Txtbx_AddRoomNames;
	
	@FindBy(xpath="//input[@name='prefixMulName[]']")
	public  WebElement Txtbx_AddRoomNoPrefix;
	
	@FindBy(xpath="//input[@name='rmFrom']")
	public  WebElement Txtbx_RoomFrom;
	
	@FindBy(xpath="//input[@name='rmTo']")
	public  WebElement Txtbx_RoomTo;
	
	@FindBy(xpath="//select[@name='rmTypeId']")
	public  WebElement Drpdwn_RoomType;
	
	@FindBy(xpath="//select[@name='floorId']")
	public  WebElement Drpdwn_FloorType;
	
	@FindBy(xpath="//select[@name='blockId']")
	public  WebElement Drpdwn_BlockType;
	
	@FindBy(xpath="//textarea[@name='description']")
	public  WebElement Txtbx_Description;
	
	@FindBy(xpath="//a[text()='Main']")
	public  WebElement Link_Main;
	
	@FindBy(xpath="//a[text()='Rooms  List']")
	public  WebElement Link_RoomList;
	
	@FindBy(xpath="//a[text()='AuditTrail']")
	public  WebElement Link_AuditTrail;
	
	@FindBy(xpath="//input[@name='addType' and @value='range']")
	public  WebElement RB_RoomByNumber;
	
	@FindBy(xpath="//td[@class='error']")
	public  WebElement Msg_Validation;

/**
 * Thios method for verifying all the page element.
 * @throws Exception
 */
public void VerifyPageElements() throws Exception{
	GenericClass.checkElementDisplay("lbls_AddMultipleRooms",lbls_AddMultipleRooms);
	GenericClass.checkElementDisplay("Txt_FillDetail",Txt_FillDetail);
	GenericClass.checkElementDisplay("Btn_SaveAtTop",Btn_SaveAtTop);
	GenericClass.checkElementDisplay("Btn_CancelAtTop",Btn_CancelAtTop);
	GenericClass.checkElementDisplay("Btn_SaveAtBtm",Btn_SaveAtBtm);
	GenericClass.checkElementDisplay("Btn_CancelAtBtm",Btn_CancelAtBtm);
	GenericClass.checkElementDisplay("Txtbx_AddRoomNames",Txtbx_AddRoomNames);
	GenericClass.checkElementDisplay("Txtbx_AddRoomNoPrefix",Txtbx_AddRoomNoPrefix);
	GenericClass.checkElementDisplay("Txtbx_RoomFrom",Txtbx_RoomFrom);
	GenericClass.checkElementDisplay("Txtbx_RoomTo",Txtbx_RoomTo);
	GenericClass.checkElementDisplay("Drpdwn_RoomType",Drpdwn_RoomType);
	GenericClass.checkElementDisplay("Drpdwn_FloorType",Drpdwn_FloorType);
	GenericClass.checkElementDisplay("Drpdwn_BlockType",Drpdwn_BlockType);
	GenericClass.checkElementDisplay("Txtbx_Description",Txtbx_Description);
	GenericClass.checkElementDisplay("Link_Main",Link_Main);
	GenericClass.checkElementDisplay("Link_RoomList",Link_RoomList);
	GenericClass.checkElementDisplay("Link_AuditTrail",Link_AuditTrail);
}



/**
 * This method Adding multiple rooms by name .
 * @param ele : Here ele for save button.
 * @return : As it returns Rooms Landing page And initialize all its element.
 * @throws Exception
 */
public RoomsLandingPage AddingMultipleRoomsByName(String room,WebElement ele) throws Exception {
     try{
	GenericClass.sendKeys(Txtbx_AddRoomNames, room);
	rtype=GenericClass.SelectByIndex(Drpdwn_RoomType, 1);
	floor=GenericClass.SelectByIndex(Drpdwn_FloorType, 1);
	block=GenericClass.SelectByIndex(Drpdwn_BlockType, 1);
	GenericClass.sendKeys(Txtbx_Description, GenericClass.generateRandomString());
	GenericClass.clickElement(ele);
     }catch(Exception e){
    	 throw e;
     }
	RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver,RoomsLandingPage.class);
	return RLP;
}



/**
 * This method for Adding rooms by number/range
 * @param iTestCaseRow : As it is used for test data handling.
 * @param ele : Here ele for save button.
 * @return : As it returns Room Landing Page.And initialize all its element.
 * @throws Exception
 */
public RoomsLandingPage AddingMultipleRoomsByNumber(String roomnumfrom,String roomnumto,WebElement ele) throws Exception {
	GenericClass.clickElement(RB_RoomByNumber);
	//int v=Integer.parseInt(ExcelUtil.flipFlop);
//	int va=v+1;
//    String roomto=Integer.toString(va);
	GenericClass.sendKeys(Txtbx_AddRoomNoPrefix, prefixForRoom);
	GenericClass.sendKeys(Txtbx_RoomFrom, roomnumfrom);
	GenericClass.sendKeys(Txtbx_RoomTo, roomnumto);
	rtype=GenericClass.SelectByIndex(Drpdwn_RoomType, 1);
	floor=GenericClass.SelectByIndex(Drpdwn_FloorType, 1);
	block=GenericClass.SelectByIndex(Drpdwn_BlockType, 1);
	GenericClass.sendKeys(Txtbx_Description, GenericClass.generateRandomString());
	GenericClass.clickElement(ele);
	RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver,RoomsLandingPage.class);
	return RLP;
}

	/**
	 * This method for Verifies duplicacy for Multiple room addition By name.
	 * @param iTestCaseRow : As it is for test data handling
	 * @param ele : Here ele for save button.
	 * @throws Exception
	 */
	public void verifyDuplicateRoomAdditionByName(String room,WebElement ele) throws Exception{
		try{
	    String twoRoom=GenericClass.generateRandomString();
		String mulRooms=room+","+twoRoom;
		GenericClass.sendKeys(Txtbx_AddRoomNames, mulRooms);
		rtype=GenericClass.SelectByIndex(Drpdwn_RoomType, 1);
		floor=GenericClass.SelectByIndex(Drpdwn_FloorType, 1);
		block=GenericClass.SelectByIndex(Drpdwn_BlockType, 1);
		GenericClass.sendKeys(Txtbx_Description, GenericClass.generateRandomString());	GenericClass.clickElement(ele);
		}catch(Exception e){
			throw e;
		}
		}


/**
 * This method for Verifies duplicacy for Multiple room addition By number.
 * @param iTestCaseRow : As it is for test data handling
 * @param ele : Here ele for save button.
 * @throws Exception
 */
public void verifyDuplicateRoomAdditionByNumber(int iTestCaseRow,WebElement ele,String Workbook) throws Exception{
	
	
	GenericClass.clickElement(RB_RoomByNumber);

	String oneRoom=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber));
	String twoRoom=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber1));
	GenericClass.sendKeys(Txtbx_AddRoomNoPrefix, prefixForRoom);
	GenericClass.sendKeys(Txtbx_RoomFrom, oneRoom);
	GenericClass.sendKeys(Txtbx_RoomTo, twoRoom);
	rtype=GenericClass.SelectByIndex(Drpdwn_RoomType, 4);
	floor=GenericClass.SelectByIndex(Drpdwn_FloorType, 1);
	block=GenericClass.SelectByIndex(Drpdwn_BlockType, 1);
	ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow,  ExcelUtil.GetColumnIndex(Constant.Col_Description),Workbook);
	GenericClass.sendKeys(Txtbx_Description, ExcelUtil.getCellData(iTestCaseRow,  ExcelUtil.GetColumnIndex(Constant.Col_Description)));
	GenericClass.clickElement(ele);

	}

/**
 * This method for multiple rooms by room name only.
 * @param ele : Here ele for save button.
 * @throws Exception
 */
public void AddingMultipleRoomsByNameOnly(String multirooms,WebElement ele) throws Exception {
    try{
	GenericClass.sendKeys(Txtbx_AddRoomNames, multirooms);
	GenericClass.clickElement(ele);
    }catch(Exception e){
    	throw e;
    }
   }



/**
 * This method for getting page header.
 * @return : As it returns String format for page header.
 */
public String getPageHeader(){
return lbls_AddMultipleRooms.getText();
}
















/**
 * This method Clicks on Main link on Add multiple rooms  page.
 * @return : As it returns Admin Home page and initialize all its element.
 * @throws Exception
 */
public AdminHome ClickOnMainLink() throws Exception {
	GenericClass.clickElement(Link_Main);
	AdminHome AH=PageFactory.initElements(GenericClass.driver,AdminHome.class);
	return AH;
	
}
















/**
 * This method for Clicking on Room List link on Add multiple room page.
 * @return : As it returns Rooms Landing Page and initialize all its element.
 * @throws Exception
 */
public RoomsLandingPage ClickOnRoomListLink() throws Exception {
GenericClass.clickElement(Link_RoomList);
RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver,RoomsLandingPage.class);
return RLP;
	
}

/**
 * This method for adding multiple rooms by number without providing range.
 * @param iTestCaseRow : As it is for test data handling.
 * @param ele : Here ele for save button.
 * @throws Exception
 */
public void AddingMultipleRoomsByNumberByLeavingToRange(int iTestCaseRow, WebElement ele,String Workbook) throws Exception {
	GenericClass.clickElement(RB_RoomByNumber);
	ExcelUtil.setCellData(GenericClass.GenerateRandomNumber(2), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber),Workbook);
	String oneRoom=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber));
	GenericClass.sendKeys(Txtbx_AddRoomNoPrefix, prefixForRoom);
	GenericClass.sendKeys(Txtbx_RoomFrom, oneRoom);
	rtype=GenericClass.SelectByIndex(Drpdwn_RoomType, 4);
	floor=GenericClass.SelectByIndex(Drpdwn_FloorType, 1);
	block=GenericClass.SelectByIndex(Drpdwn_BlockType, 1);
	ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow,  ExcelUtil.GetColumnIndex(Constant.Col_Description),Workbook);
	GenericClass.sendKeys(Txtbx_Description, ExcelUtil.getCellData(iTestCaseRow,  ExcelUtil.GetColumnIndex(Constant.Col_Description)));
	GenericClass.clickElement(ele);
    }




/**
 * This method for adding room by putting invalid range (Ex. maxRange < minRange)
 * @param iTestCaseRow: This is for test data handling.
 * @param ele : Here ele for save button.
 * @throws Exception
 */
public void AddingMultipleRoomFromLessThenTo(int iTestCaseRow, WebElement ele,String Workbook) throws Exception{
	GenericClass.clickElement(RB_RoomByNumber);
	ExcelUtil.setCellData(GenericClass.GenerateRandomNumber(2), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber),Workbook);
	int v=Integer.parseInt(ExcelUtil.flipFlop);
	int va=v+1;
	  String a=Integer.toString(va);
	ExcelUtil.setCellData(a, iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber1),Workbook);
    String oneRoom=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber));
    String twoRoom=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber1));
	GenericClass.sendKeys(Txtbx_AddRoomNoPrefix, prefixForRoom);
	GenericClass.sendKeys(Txtbx_RoomFrom, twoRoom);
	GenericClass.sendKeys(Txtbx_RoomTo, oneRoom);
	rtype=GenericClass.SelectByIndex(Drpdwn_RoomType, 4);
	floor=GenericClass.SelectByIndex(Drpdwn_FloorType, 1);
	block=GenericClass.SelectByIndex(Drpdwn_BlockType, 1);
	ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow,  ExcelUtil.GetColumnIndex(Constant.Col_Description),Workbook);
	GenericClass.sendKeys(Txtbx_Description, ExcelUtil.getCellData(iTestCaseRow,  ExcelUtil.GetColumnIndex(Constant.Col_Description)));
	GenericClass.clickElement(ele);
	
	
	
}



/**
 * This method Adding room by number by providing invalid range.
 * @param iTestCaseRow: This is used for test data handling.
 * @param ele : Here ele for save button.
 * @throws Exception
 */
public void AddingMultipleRoomByInvalidRoomRange(int iTestCaseRow, WebElement ele,String Workbook) throws Exception{
	GenericClass.clickElement(RB_RoomByNumber);
	ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber),"Rooms.xlsx");
	ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber1),"Rooms.xlsx");
    String oneRoom=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber));
    String twoRoom=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumber1));
	GenericClass.sendKeys(Txtbx_AddRoomNoPrefix, prefixForRoom);
	GenericClass.sendKeys(Txtbx_RoomFrom, "aa");
	GenericClass.sendKeys(Txtbx_RoomTo, "ba");
	rtype=GenericClass.SelectByIndex(Drpdwn_RoomType, 4);
	floor=GenericClass.SelectByIndex(Drpdwn_FloorType, 1);
	block=GenericClass.SelectByIndex(Drpdwn_BlockType, 1);
	ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description),Workbook);
	GenericClass.sendKeys(Txtbx_Description, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
	GenericClass.clickElement(ele);
	
}

/**
 * This method Adding room by nuber by leaving room type.
 * @param iTestCaseRow : This is used for test data handling.
 * @param ele : Here ele for save button.
 * @throws Exception
 */
public void AddingMultipleRoomsByNumberWithoutRoomType(String room1, String room2, WebElement ele) throws Exception {
	try{
	GenericClass.clickElement(RB_RoomByNumber);
	GenericClass.sendKeys(Txtbx_AddRoomNoPrefix, prefixForRoom);
	GenericClass.sendKeys(Txtbx_RoomFrom, room1);
	GenericClass.sendKeys(Txtbx_RoomTo, room2);
	GenericClass.clickElement(ele);
	}catch(Exception e){
		throw e;
	}
	
}


	

}
