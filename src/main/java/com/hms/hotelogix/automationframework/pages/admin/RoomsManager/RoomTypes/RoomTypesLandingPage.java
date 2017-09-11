package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.RoomsLandingPage;

public class RoomTypesLandingPage {

	
	@FindBy(xpath="//td/a[text()='Edit']")
    public  WebElement link_Edit;
	
	@FindBy(xpath="//li/a[@title='Add a Room Type']")
    public  WebElement btn_AddARoomType;
	
	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	 public  WebElement heading_Page;
	
	@FindBy(xpath="//td/select[@name='maxEntries']")
    public  WebElement drpdwn_View;
	
    @FindBy(xpath="//li/a[@title='Delete Selected Room Type(s)']")
    public  WebElement btn_DeleteSelectedRoomType;

    @FindBy(xpath="//a[text()='Save Sort Order']")
    public  WebElement btn_SaveSortOrder;

    @FindBy(xpath="//li//a[text()='Cancel']")
    public  WebElement btn_Cancel;

    @FindBy(xpath="//td[@class='breadcurms_new']/a[text()='Main']")
    public  WebElement link_Main;

    @FindBy(xpath="//td/a/b")
    public  WebElement link_Rooms;

    @FindBy(xpath="//td/a[text()='Add a Room']")
    public  WebElement link_AddARoom;
    
    @FindBy(xpath="//td/a[text()='Sort Amenities']")
    public  WebElement link_SortAmenities;

    @FindBy(xpath="//td[text()='<<Previous | Next>>']")
    public  WebElement txt_PreviousNext;

    @FindBy(xpath="//td/a[text()='AuditTrail']")
    public  WebElement link_AuditTrail;

    @FindBy(xpath="//td/select[@name='offset']")
    public  WebElement drpdwn_Page;
    
    @FindBy(xpath="//table[@class='list_viewnew']//th")
    public  WebElement col_Hash;

    @FindBy(xpath="//table[@class='list_viewnew']//th[3]")
    public  WebElement col_Image;

    @FindBy(xpath="//table[@class='list_viewnew']//th[4]")
    public  WebElement col_RoomType;

    @FindBy(xpath="//table[@class='list_viewnew']//th[5]")
    public  WebElement col_Occupancy;

    @FindBy(xpath="//table[@class='list_viewnew']//tr[2]//th")
    public  WebElement col_Base;

    @FindBy(xpath="//table[@class='list_viewnew']//tr[2]//th[2]")
    public  WebElement col_Maximum;

    @FindBy(xpath="//table[@class='list_viewnew']//th[6]")
    public  WebElement col_Rooms;

    @FindBy(xpath="//table[@class='list_viewnew']//th[7]")
    public  WebElement col_ExtraBed;

    @FindBy(xpath="//table[@class='list_viewnew']//th[8]")
    public WebElement col_Action;

    @FindBy(xpath="//table[@class='list_viewnew']//th[9]")
    public WebElement col_Status;

    @FindBy(xpath="//table[@class='list_viewnew']//th[10]")
    public WebElement col_SortOrder;
    
    @FindBy(xpath="//tr/td[@id='errorTd']")
	public  WebElement errormessage;
    
    @FindBy(xpath="//table[@class='list_viewnew']//tr//td[2]")
    public  List<WebElement> chkbox_count;
    
    @FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	public List<WebElement> tr_count;
    
    @FindBy(xpath="//tr//td/input[@id='id_1']")
	public  WebElement CheckBox;
    
    @FindBy(xpath="//input[@id='id_1']")
	public  WebElement chkbx_checkBox1;
    
    @FindBy(xpath="//table[@class='list_viewnew']/tbody//tr[3]//td[11]/input")
    public  WebElement txtbox_sortValue1;
    
    @FindBy(xpath="//tr//th/input[@type='checkbox']")
	public  WebElement chkbx_Master;
    
    @FindBy(xpath="//table[@class='list_viewnew']//th[4]/a[1]/img")
 	public  WebElement btn_RTNameDownward;

 	@FindBy(xpath="//table[@class='list_viewnew']//th[4]/a[2]")
 	public  WebElement btn_RTNameUpward;
 			
 	@FindBy(xpath="//table[@class='list_viewnew']//th[9]/a[1]/img")
 	public  WebElement btn_RTStatusDownward;

    @FindBy(xpath="//table[@class='list_viewnew']//th[9]/a[2]")
 	public  WebElement btn_RTStatusUpward;
 		    
 	@FindBy(xpath="//table[@class='list_viewnew']//th[9]/a[1]/img")
    public  WebElement btn_RTSortOrderDownward;
 	
 	@FindBy(name="id[]")
	public  List<WebElement> CheckBoxList;
 	
 	@FindBy(xpath="//tr//td[10]//a/img")
	public  WebElement img_Status;
 	
 	@FindBy(xpath="//td[@id='col_1']")
    public  WebElement col_1_text;
 	
 	@FindBy(xpath="//tr//td/a[text()='Next>>']")
    public  WebElement link_Next;
 	
 	@FindBy(xpath="//tr//td/a[text()='<<Previous']")
	public  WebElement link_Previous;
    
    
    public  String RTName;
    public static String message;
    
	public  String fn_verifyPageHeader() throws Exception
    {

    	try
    	{
		String str=GenericClass.getText(heading_Page);
        return str;
    	}
    	catch(AssertionError e)
    	{
    		throw e;
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    }
	
	/**
	 * This method clicks on 'Edit' link corresponding to a room type and navigates to 'Add a Room Type' page
	 * @return Object of AddRoomTypePage class and initializes all its elements
	 * @throws Exception
	 */
	public EditRoomType fn_EditRoomtype() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_Edit);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(1000);
			GenericClass.js_Click(link_Edit);
		}
		catch(Exception e)
		{
			throw e;
		}
		EditRoomType ERT = PageFactory.initElements(GenericClass.driver, EditRoomType.class);
		return ERT;
	}

	
	/**
	 * This method clicks on 'ADD A ROOM TYPE' button and navigates to 'Add a Room Type' page
	 * @return Object of AddRoomTypePage and initializes all its elements
	 * @throws Exception
	 */
	public  AddRoomTypePage fn_NavigateAddRoomTypes() throws Exception
	{
        try
        {
		GenericClass.clickElement(btn_AddARoomType);
        }catch(NoSuchElementException e)
        {
        	Thread.sleep(1000);
        	GenericClass.js_Click(btn_AddARoomType);
        }catch(Exception e)
        {
        	throw e;
        }
		AddRoomTypePage addroomtypeobj = PageFactory.initElements(GenericClass.driver, AddRoomTypePage.class);
		return addroomtypeobj;
	}
	
	public  RoomTypesLandingPage fn_viewAll() throws InterruptedException
	{
		try
		{
		GenericClass.selectElement(drpdwn_View, "All");
		GenericClass.ActionOnAlert("Accept");
		}
		catch(Exception e)
		{
			throw e;
		}
		RoomTypesLandingPage RTLPPageobj=	PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RTLPPageobj;
	}
	
	
	public  void verify_RoomTypeElements() throws Exception
	{
         try
         {
		//GenericClass.checkElementDisplay("Room type List Page",heading_Page );
		GenericClass.checkElementDisplay("ADD A ROOM TYPE",btn_AddARoomType);
		GenericClass.checkElementDisplay("DELETE SELECTED ROOM TYPE(s)",btn_DeleteSelectedRoomType);
		GenericClass.checkElementDisplay("SAVE SORT ORDER",btn_SaveSortOrder);
		GenericClass.checkElementDisplay("CANCEL",btn_Cancel );
		GenericClass.checkElementDisplay("Main",link_Main);
		GenericClass.checkElementDisplay("Rooms",link_Rooms);
		GenericClass.checkElementDisplay("Add a Room",link_AddARoom);
		GenericClass.checkElementDisplay("Edit",link_Edit);
	    GenericClass.checkElementDisplay("<<Previous | Next>>",txt_PreviousNext);
		GenericClass.checkElementDisplay("Audit Trail",link_AuditTrail);
		GenericClass.checkElementDisplay("Page",drpdwn_Page);
		GenericClass.checkElementDisplay("View records per page",drpdwn_View);
		GenericClass.checkElementDisplay("#", col_Hash);
		GenericClass.checkElementDisplay("Image", col_Image);
		GenericClass.checkElementDisplay("Room Type", col_RoomType);
		GenericClass.checkElementDisplay("Occupancy", col_Occupancy);
		GenericClass.checkElementDisplay("Base", col_Base);
		GenericClass.checkElementDisplay("Maximum", col_Maximum);
		GenericClass.checkElementDisplay("Rooms", col_Rooms);
		GenericClass.checkElementDisplay("Extra Bed(s) Allowed", col_ExtraBed);
		GenericClass.checkElementDisplay("Action", col_Action);
		GenericClass.checkElementDisplay("Status", col_Status);
		GenericClass.checkElementDisplay("Sort Order", col_SortOrder);
         }

         catch(Exception e)
         {
        	 throw e;
         }
    }
	
	public  String verify_saveMsg() throws Exception
	{
		try
		{
		String txt=GenericClass.getText(errormessage);
		return txt;
		}				
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public  void verify_AddedRoom(int iTestCaseRow,String rtName) throws Exception
	{

		try
		{
		int count=GenericClass.tr_count(chkbox_count);
		for(int i=3;i<=count;i++)
		{
			String RTName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();
			if(RTName.equals(rtName))
			{
			Assert.assertEquals(RTName, rtName);
			String status=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[10]//img")).getAttribute("src");
			Assert.assertTrue(status.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
			break;

			}
		}
		}
		catch(Exception e)
		{
			throw e;
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	
	public SortAmenitiesPage fn_clkSortAmenities(int iTestCaseRow,String rtName) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(chkbox_count);
		for(int i=3;i<=count;i++)
		{
			String RTName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();
			if(RTName.equals(rtName))
			{
                Assert.assertTrue(RTName.equals(rtName));
				WebElement link=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[9]//a[2]"));
				link.click();
				break;
			}
		}

		SortAmenitiesPage SAP=PageFactory.initElements(GenericClass.driver, SortAmenitiesPage.class);
		return SAP;
		}
		catch(Exception e)
		{
			throw e;
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	public EditRoomType clkEdit_RTWithImg(String rtName)
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);
		for(int i=3;i<=count;i++)
		{
			String name=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();
			if(name.equals(rtName))
			{
				Assert.assertEquals(name, rtName);
				GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[9]/a")).click();
				break;
			}
		}
		EditRoomType ERT=PageFactory.initElements(GenericClass.driver, EditRoomType.class);
		return ERT;
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void fn_verifyUploadedImg()
	{
		try
		{
		int count=GenericClass.tr_count(chkbox_count);
		for(int i=3;i<=count;i++)
		{
			String str=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[3]/img")).getAttribute("src");
			boolean b=str.endsWith(EditRoomType.imgName);
			Assert.assertTrue(str.endsWith(EditRoomType.imgName));
			break;
		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	
	public AddRoomsPage fn_chkRooms(int iTestCaseRow,String RTName) throws Exception
    {
		try
		{
    	int count=GenericClass.tr_count(chkbox_count);
    	for(int i=3;i<=count;i++)
    	{
    		String name=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();
    		if(name.equals(RTName))
    		{
    			Assert.assertEquals(name, RTName);
    			String roomNo=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[7]/a/b")).getText();
    			if(roomNo.contains("0"))
    			{
    				Assert.assertTrue(roomNo.contains("0"));
    				WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[7]//a[2]"));
    				ele.click();
    				AddRoomsPage ARP=PageFactory.initElements(GenericClass.driver, AddRoomsPage.class);
    				ARP.RT_addRoom(iTestCaseRow);
    				break;
    			}
    		}
    	}

    	AddRoomsPage ARP=PageFactory.initElements(GenericClass.driver, AddRoomsPage.class);
    	return ARP;
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
    }
	
	public EditRoomType clkEdit_RTtoAddImg(String rtName) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(chkbox_count);
		for(int i=3;i<=count;i++)
		{
			String name=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();
			if(name.equals(rtName))
			{
				Assert.assertTrue(name.equals(rtName));
				GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[9]/a")).click();
				break;
			}
		}
		EditRoomType ERT=PageFactory.initElements(GenericClass.driver, EditRoomType.class);
		return ERT;
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public AddRoomsPage newRT_chkRooms(int iTestCaseRow,String rtName) throws Exception
    {
		try
		{
    	int count=GenericClass.tr_count(chkbox_count);
    	for(int i=3;i<=count;i++)
    	{
    		String name=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();
    		if(name.equals(rtName))
    		{
    			Assert.assertEquals(name, rtName);
    			String roomNo=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[7]/a/b")).getText();
    			if(roomNo.contains("0"))
    			{
    				Assert.assertTrue(roomNo.contains("0"));
    				WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[7]//a[2]"));
    				ele.click();
    				AddRoomsPage ARP=PageFactory.initElements(GenericClass.driver, AddRoomsPage.class);
    				ARP.RT_addRoom(iTestCaseRow);
    				break;
    			}
    		}
    	}

    	AddRoomsPage ARP=PageFactory.initElements(GenericClass.driver, AddRoomsPage.class);
    	return ARP;
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
    }
	
	public  String fn_verifyDeleteAlertMsg() throws Exception
	{
		try
		{
		GenericClass.clickElement(CheckBox);
		GenericClass.clickElement(btn_DeleteSelectedRoomType);
		String str= GenericClass.Alert_Dismiss();
        return str;
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void fn_verifyDeleteAccept(String rtName) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(chkbox_count);
		for(int i=3;i<=count;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();
			if(data.equals(rtName))
			{
				WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[2]/input"));
				ele.click();

				break;
			}
		}
		GenericClass.clickElement(btn_DeleteSelectedRoomType);
		GenericClass.Alert_Accept();
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	
	public void verify_DeletedRoom(String roomTypeName) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(chkbox_count);
		for(int i=3;i<=count;i++)
		{
			String RTName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();
			Assert.assertNotEquals(RTName, roomTypeName);
		}
		}
		catch(AssertionError e)
		{
			throw e;
			
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_verifyDeleteDismiss(int iTestCaseRow) throws Exception
	{
		try
		{
			GenericClass.clickElement(chkbx_checkBox1);
			//String RTName = GenericClass.getText(RoomType_name1);
			GenericClass.clickElement(btn_DeleteSelectedRoomType);
            GenericClass.Alert_Dismiss();
			boolean value=chkbx_checkBox1.isSelected();
			Assert.assertEquals(value, true);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public  AdminHome clk_Cancel() throws Exception
	{

		try
		{
		GenericClass.clickElement(btn_Cancel);
		AdminHome pageobj = PageFactory.initElements(GenericClass.driver, AdminHome.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public  void verifyMsg_DeleteReservedRoomType(int iTestCaseRow,String rtName) throws Exception
	{

		try
		{
        int trcount=GenericClass.tr_count(tr_count);

        for(int i=3;i<trcount;i++)
        {
        	String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();

        if(data.equals(rtName))
        {
            WebElement toclick=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[2]//input"));
            toclick.click();
            GenericClass.clickElement(btn_DeleteSelectedRoomType);
            GenericClass.ActionOnAlert("Accept");
            String str=GenericClass.getText(errormessage);
            Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
            break;
        }

        }
		}
		catch(Exception e)
		{
			throw e;
		}

    }
	
	
	public  void validData_saveSortOrder(int iTestCaseRow) throws Exception
	{
		try
		{
		txtbox_sortValue1.clear();
		GenericClass.sendKeys(txtbox_sortValue1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_SortOrder)));
		GenericClass.clickElement(btn_SaveSortOrder);
		if(GenericClass.isAlertPresent()==true)
		{
		  String aobj=GenericClass.Alert_NoAction();
		  Thread.sleep(3000);
		  System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		
		 // System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		
		
		  if(aobj.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))))
		    {

		     //System.out.println(aobj);
		     Assert.assertEquals(aobj, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		     System.out.println("Save sort order has been successfully saved for room type.");
		   
	       }
		else
			if(aobj.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))))
			{
				GenericClass.Alert_Accept();				 
				Thread.sleep(240000);
				String AfterSortMsg =GenericClass.getText(errormessage);
				    if(AfterSortMsg.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3))))
				      {
				    	txtbox_sortValue1.clear();
						GenericClass.sendKeys(txtbox_sortValue1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_SortOrder)));
				    	GenericClass.clickElement(btn_SaveSortOrder);
				    	String sortsave=GenericClass.Alert_Accept();
				    	 if(sortsave.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))))
				    	  {
				    		 System.out.println("Save sort order has been successfully saved for room type.");
				    	  }
				    	 else
				    	  {
				    		 System.out.println("Sort order not saved.");
				    	  }
				      }
			       else
			         {
			           System.out.println("Save Sort order is not being displayed");
			         }
			}
		}
		else
		{
			String AfterSortMsg =GenericClass.getText(errormessage);
            Assert.assertEquals(AfterSortMsg, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		}
		
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void verify_sortMsg(int iTestCaseRow) throws Exception
	{
		try
		{
		txtbox_sortValue1.clear();
		GenericClass.sendKeys(txtbox_sortValue1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_SortOrder)));
		GenericClass.clickElement(btn_SaveSortOrder);
		if(GenericClass.isAlertPresent()==true)
		{
			  String aobj=GenericClass.Alert_Dismiss();
              Assert.assertEquals(aobj, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		}
		
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_selectIndividualCB()
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);
		for(int i=3;i<count;i++)
		{
			WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]//input"));
			ele.click();
		}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_verifySelect()
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);
		for(int i=3;i<count;i++)
		{
			WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]//input"));
			boolean value=ele.isSelected();
			Assert.assertEquals(value, true);
		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	public void fn_deselectIndividualCB()
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);
		for(int i=3;i<count;i++)
		{
			WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]//input"));
			ele.click();
		}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void fn_verifyDeselect()
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);
		for(int i=3;i<count;i++)
		{
			WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]//input"));
			boolean value=ele.isSelected();
			Assert.assertEquals(value, false);
		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}

	
	public  void fn_MasterCB() throws Exception
	{
		try
		{
		GenericClass.clickElement(chkbx_Master);
		}
		catch(NoSuchElementException e)
		{
			GenericClass.js_Click(chkbx_Master);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void verify_MasterSelect()
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);
		for(int i=3;i<count;i++)
		{
			WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input"));
			boolean value=ele.isSelected();
			Assert.assertEquals(value, true);
		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	public void verify_MasterDeselect()
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);
		for(int i=3;i<count;i++)
		{
			WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input"));
			boolean value=ele.isSelected();
			Assert.assertEquals(value, false);
		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	public RoomsLandingPage fn_clkTotalNoOfRoomlnk() throws Exception
    {try{
    	int count=GenericClass.tr_count(chkbox_count);
    	for(int i=3;i<=count;i++)
    	{

    			String roomNo=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[7]/a/b")).getText();
    			if(roomNo!="0")
    			{
    				WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[7]//a[2]"));
    				RTName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();
    				ele.click();
    				RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver, RoomsLandingPage.class);
    				break;
    			}

    	}

    	RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver, RoomsLandingPage.class);
    	return RLP;
    }catch(Exception e){
    	throw e;
    }
    }
	
	
	public  AddRoomsPage fn_AddARoomLink() throws Exception
	{
		try
		{
        RTName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr[3]//td[4]")).getText();
		GenericClass.clickElement(link_AddARoom);
		AddRoomsPage ARP = PageFactory.initElements(GenericClass.driver, AddRoomsPage.class);
		return ARP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  void verify_EditedRoom(String rtName) throws Exception
	{

		try
		{
		int count=GenericClass.tr_count(chkbox_count);
		for(int i=3;i<=count;i++)
		{
			String RTName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();
			if(RTName.equals(rtName))
			{
			Assert.assertEquals(RTName, rtName);
			break;
			}

		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	
	public  SortAmenitiesPage fn_SortAmenities() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_SortAmenities);

		SortAmenitiesPage SAP = PageFactory.initElements(GenericClass.driver, SortAmenitiesPage.class);
		return SAP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	
	public  String fn_verifyAmenitiesSortOrderMsg() throws Exception
	{
		try
		{
		message = GenericClass.getText(errormessage);
		return message;
		}			
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public  String  clk_ActiveToDeactive(int iTestCaseRow) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);
		for(int i=3;i<=count;i++)
		{
		      
			RTName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]")).getText();
			String roomNo=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[7]/a/b")).getText();
			if(roomNo.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))))
			{
				Assert.assertEquals(roomNo.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
			    String value=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]//img")).getAttribute("src");
	            if(value.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))))
	               {		            
	        	    Assert.assertTrue(value.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))));
	                 WebElement element=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]//img"));		         
	               	element.click();
	                Thread.sleep(4000);
	                break;  
	              }
		   }  
		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
        catch(Exception e)
        {
        	throw e;
        }
        return RTName;
		
	}
	
	
	public void fn_verifyDeactiveStatus(int iTestCaseRow) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);
		for(int i=3;i<=count;i++)
		{
			String str=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]")).getText();
			if(str.equals(RTName))
			{
				Assert.assertEquals(str, RTName);
			    String value1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]//img")).getAttribute("src");
			    Assert.assertTrue(value1.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3))));
			    break;

			}
		}

     	}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e ;
		}

	}
	
	
	public  String  clk_DeactiveToActive(int iTestCaseRow) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);

		for(int i=3;i<=count;i++)
		{
		      
			RTName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]")).getText();
			String value=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]//img")).getAttribute("src");
	        if(value.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))))
	          {
	            
	        	Assert.assertTrue(value.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
	            WebElement element=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]//img"));
	         
	        	element.click();
	            Thread.sleep(4000);
	            break;  
	          }
		}  
		}
		catch(AssertionError e)
		{
			throw e;
		}
        catch(Exception e)
        {
        	throw e;
        }
        return RTName;
		
	}
	
	
	public void fn_verifyActiveStatus(int iTestCaseRow) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);
		for(int i=3;i<=count;i++)
		{
			String str=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]")).getText();
			if(str.equals(RTName))
			{
				Assert.assertEquals(str, RTName);
			    String value1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]//img")).getAttribute("src");
			    Assert.assertTrue(value1.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))));
			    break;

			}
		}

     	}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e ;
		}

	}
	
	
	public AddRoomsPage fn_addRooms(int iTestCaseRow,String rtName) throws Exception
    {
		try
		{
    	int count=GenericClass.tr_count(chkbox_count);
    	for(int i=3;i<=count;i++)
    	{
    		String name=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();
    		if(name.equals(rtName))
    		{
    			Assert.assertEquals(name,rtName);
    			String roomNo=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[7]/a/b")).getText();
    			if(roomNo.contains("0"))
    			{
    				Assert.assertTrue(roomNo.contains("0"));
    				WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[7]//a[2]"));
    				ele.click();
    				AddRoomsPage ARP=PageFactory.initElements(GenericClass.driver, AddRoomsPage.class);
    				ARP.RT_addRoom(iTestCaseRow);
    				break;
    			}
    		}
    	}

    	AddRoomsPage ARP=PageFactory.initElements(GenericClass.driver, AddRoomsPage.class);
    	return ARP;
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
    }

	
	public  String  clk_DeactiveReservedRT(int iTestCaseRow,String rtName) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);
		for(int i=3;i<=count;i++)
		{
		    String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]")).getText();
		    if(data.equals(rtName))
		    {
		    	Assert.assertEquals(data.equals(rtName), true);		
			//String roomNo=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[7]/a/b")).getText();
          /*  if(roomNo.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))))
            {
			//RTName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]")).getText();
			Assert.assertTrue(roomNo.contains("0"));*/
            String value=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]//img")).getAttribute("src");
	        if(value.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))))
	          {
	            
	        	Assert.assertTrue(value.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))));
	            WebElement element=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]//img"));
	         
	        	element.click();
	            Thread.sleep(4000);
	            String str=GenericClass.Alert_Accept();
	            Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
	            break;  
	          }
		}  
		}
		}
		
		catch(AssertionError e)
		{
			throw e;
		}
        catch(Exception e)
        {
        	throw e;
        }
        return RTName;
		
	}

	
	public void sortRTName_downwardArrow() throws Exception
    {
    	try
    	{
    	GenericClass.sortingName_Downward(drpdwn_View, "100", btn_RTNameDownward, CheckBoxList, "//table[@class='list_viewnew']//tr/td[4]");
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    }
	
	
	 public void sortRTName_upwardArrow() throws Exception
	    {
	    	try
	    	{
	    	GenericClass.sortingName_Upward(drpdwn_View, "100", btn_RTNameUpward, CheckBoxList, "//table[@class='list_viewnew']//tr/td[4]");
	    	}
	    	catch(Exception e)
	    	{
	    		throw e;
	    	}
	    }
	  

	    public void sortStatus_downwardArrow() throws Exception
	    {
	    	try
	    	{
	    	GenericClass.sortstatus_Downward(drpdwn_View, "100", img_Status, btn_RTStatusDownward, CheckBoxList, "//table[@class='list_viewnew']//tr/td[4]", "//table[@class='list_viewnew']//tr/td[10]/a/img");
	    	}
	    	catch(Exception e)
	    	{
	    		throw e;
	    	}
	    }
	    
	    
	    
	    public void sortStatus_upwardArrow() throws Exception
	    {
	    	try
	    	{
	    	GenericClass.sortstatus_Upward(drpdwn_View, "100", btn_RTStatusUpward, CheckBoxList, "//table[@class='list_viewnew']//tr/td[4]", "//table[@class='list_viewnew']//tr/td[10]/a/img");
	    	}
	    	catch(Exception e)
	    	{
	    		throw e;
	    	}
	    }
	    
	    public  AdminHome mainLink() throws Exception
		{
			try
			{
			GenericClass.clickElement(link_Main);
			AdminHome AdminHomeobj=	PageFactory.initElements(GenericClass.driver, AdminHome.class);
			return AdminHomeobj;
			}
			catch(Exception e)
			{
				throw e;
			}
		}
	    
		public void verify_viewDropdown(String DropdownValueForView)
		{
			//GenericClass.selectElement(View_Dropdown, DropdownValueForView);
		    try
		    {
			Select sel = new Select(drpdwn_View);
		    sel.selectByVisibleText(DropdownValueForView);
			int count=GenericClass.CheckBox_Count(CheckBoxList);
			String count1=Integer.toString(count);
			if(DropdownValueForView.equals(count1))
			{
               Assert.assertEquals(DropdownValueForView.equals(count1), true);
			}
		    }
		    catch(AssertionError e)
		    {
		    	throw e;
		    }
		}

		
		public  void verify_pageDropdown()
		{
			try
			{
			 GenericClass.selectElement(drpdwn_View, "1");
			 //GenericClass.selectElement(page_dropdown, "4");
		 	 String a=GenericClass.selectElementByvalue(drpdwn_Page, "2");
			 String columntxt=GenericClass.getText(col_1_text);
			 System.out.println(columntxt);
			 boolean columnobj=columntxt.contains(a);
			 //System.out.println(columnobj);
			 Assert.assertEquals(columnobj, true);
			}
			catch(AssertionError e)
			{
				throw e;
			}
		}
		
		public void verify_nextLnk() throws Exception
		{

			try
			{
				 Select select=new Select(drpdwn_Page);
			     String selectedoption=select.getFirstSelectedOption().getText();
			     int actlvalue=Integer.parseInt(selectedoption);
			     int expvalue=actlvalue+1;
				 GenericClass.selectElement(drpdwn_View, "1");
				 GenericClass.clickElement(link_Next);
				 //System.out.println(selectedoption);
				 String nexttext=GenericClass.getText(col_1_text);
				 int actual=Integer.parseInt(nexttext);
				 Assert.assertEquals(actual, expvalue);
				 //System.out.println(nextobj);
			}
			catch(AssertionError e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
		}
		
		public  void verify_previousLnk() throws Exception
		{
			try
			{
			 GenericClass.selectElement(drpdwn_View, "1");
			 GenericClass.clickElement(link_Next);
			 Select next1=new Select(drpdwn_Page);
			 String nextobj=next1.getFirstSelectedOption().getText();
			 int act2value=Integer.parseInt(nextobj);
			 GenericClass.clickElement(link_Previous);
			 Select previous1=new Select(drpdwn_Page);
			 String previousobj=previous1.getFirstSelectedOption().getText();
			 int act3value=Integer.parseInt(previousobj);
			 int exp3value=act2value-1;
			 Assert.assertEquals(act3value, exp3value);
			}
			catch(AssertionError e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
		}
		
		public  AuditTrailRoomTypeLandingPage fn_clkAuditTrail() throws Exception
		{

			try
			{
			GenericClass.clickElement(link_AuditTrail);

			AuditTrailRoomTypeLandingPage AuditTrailRTobj = PageFactory.initElements(GenericClass.driver, AuditTrailRoomTypeLandingPage.class);
			return AuditTrailRTobj;
			}
			catch(Exception e)
			{
				throw e;
			}
		}

}

