package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes;

import java.util.ArrayList;
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



public class AddRoomTypePage {
		
	@FindBy(xpath="//input[@type='checkbox']")
	public  List<WebElement> checkBox;
	
	@FindBy(xpath="//div[@class='headingtxt']/table//tr//td[2]")
	public  WebElement heading_Page;
	
	@FindBy(xpath="//li/input[@name='Submit5']")
	public WebElement btn_SaveTop;

	@FindBy(xpath="//td[@class='error']")
	public WebElement errormessage;
	
	@FindBy(xpath="//td[text()='Name the Room Type*']")
	public  WebElement txt_NameRoomType;

	@FindBy(xpath="//td/input[@name='titleMulTang[]']")
	public  WebElement editbox_NameRoomType;

	@FindBy(xpath="//td[text()='Short Name*']")
	public  WebElement txt_ShortName;

	@FindBy(xpath="//td/input[@name='accronym']")
	public  WebElement editbox_shortName;

	@FindBy(xpath="//td[@class='padingtd']//tr[4]//td[2]")
	public  WebElement txt_ShortNameMsg;

	@FindBy(xpath="//td[text()='Upload Image(s) ']")
	public  WebElement txt_UploadImage;

	@FindBy(xpath="//td/input[@name='imageName']")
	public  WebElement btn_Browse;

	@FindBy(xpath="//select[@id='mainAmenity']")
	public  WebElement AAmenities;

	@FindBy(xpath="//td[text()='Image Caption ']")
	public  WebElement txt_ImageCaption;

	@FindBy(xpath="//td/input[@name='caption']")
	public  WebElement editbox_ImageCaption;

	@FindBy(xpath="//td[text()='Description*']")
	public  WebElement txt_Description;

	@FindBy(xpath="//td/textarea[@name='descriptionMulTang[]']")
	public  WebElement editbox_Description;

	@FindBy(xpath="//td[text()='Base Occupancy*']")
	public  WebElement txt_BaseOccupancy;

    @FindBy(xpath="//td[@class='padingtd']//tr[5]//td[2]//em")
    public  WebElement txt_UploadImageMsg;

	@FindBy(xpath="//select[@id='stdOccupancy']")
	public  WebElement drpdwn_BaseOccupancy;

	@FindBy(xpath="//td[text()='Higher Occupancy']")
	public  WebElement txt_HigherOccupancy;

	@FindBy(xpath="//select[@id='higherOccupancy']")
	public  WebElement drpdwn_HigherOccupancy;

	@FindBy(xpath="//td[text()='Extra bed allowed? ']")
	public  WebElement txt_ExtraBedAllowed;

	@FindBy(xpath="//input[@name='isBedAlwd']")
	public  WebElement chkbox_ExtraBedAllowed;

	@FindBy(xpath="//td[@class='padingtd']//tr[11]//td[2]")
    public  WebElement txt_ExtraBedAllowedMsg;

	@FindBy(xpath="//td//select[@id='xtrAlwdBeds']")
	public  WebElement drpdwn_ExtraBeds;

	@FindBy(xpath="//tr/td[text()='Number of Rooms of this Room Type ']")
	public  WebElement txt_NumberOfRooms;

	@FindBy(xpath="//tr/td[text()='Select Amenities* ']")
	public  WebElement txt_SelectAmenities;

	@FindBy(xpath="//select[@id='mainAmenity']/option[1]")
	public  WebElement txt_AddAmenities;

	@FindBy(xpath="//tr/td[text()='Available Amenities']")
	public  WebElement txt_AvailableAmenities;

	@FindBy(xpath="//tr//td[text()='Selected Amenities']")
	public  WebElement txt_SelectedAmenities;

	@FindBy(xpath="//select[@id='selectedAmenity']")
	public   WebElement drpdwn_SelectedAmenity;

	@FindBy(xpath="//td//input[@name='Submit2']")
	public  WebElement btn_trfAvailableAmenities;

	@FindBy(xpath="//td//input[@name='Submit3']")
	public  WebElement btn_trfSelectedAmenities;

	@FindBy(xpath="//tr/td[text()='Rack Rate*']")
	public  WebElement txt_RackRate;

	@FindBy(xpath="//tr/td[text()='Base Price ']")
	public  WebElement txt_BasePrice;

	@FindBy(xpath="//input[@name='basePrice']")
	public  WebElement editbox_BasePrice;

	@FindBy(xpath="//tr/td[text()=' Higher Price (Upcharge Per Additional Person)) ']")
	public  WebElement txt_HigherPrice;

	@FindBy(xpath="//input[@name='higherPrice']")
	public  WebElement editbox_HigherPrice;

	@FindBy(xpath="//tr/td[text()='Extra Bed Price ']")
	public  WebElement txt_ExtraBedPrice;

	@FindBy(xpath="//input[@name='extraBedPrice']")
	public  WebElement editbox_ExtraBedPrice;

	@FindBy(xpath="//tr/td[text()='Select Applicable Tax(es) ']")
	public WebElement txt_SelectApplicableTax;

	@FindBy(xpath="//td//a[text()='Main']")
	public  WebElement link_Main;

	@FindBy(xpath="//td/a[text()='AuditTrail']")
	public  WebElement link_AuditTrail;

	@FindBy(xpath="//td//a[text()='Room Types  List']")
	public  WebElement link_RoomTypesList;

	@FindBy(xpath="//input[@type='submit']")
	public  WebElement btn_SaveBottom;

	@FindBy(xpath="//input[@value='Cancel']")
	public  WebElement btn_CancelBottom;

	@FindBy(xpath="//li/input[@name='Submit52']")
	public  WebElement btn_CancelTop;

	@FindBy(xpath="//input[@name='taxes[]']")
	public  WebElement tax_cb;

	@FindBy(xpath="//div/a[@id='imgViewLink']")
	public  WebElement link_view;

	@FindBy(xpath="//div/a[text()='Remove']")
	public  WebElement link_remove;

	@FindBy(xpath="//div/a[@id='imageCaptionLink_8975']")
	public WebElement addCaption;

	@FindBy(xpath="//td[@align='left']//div")
	public  List<WebElement> countOfAddedImage;

	@FindBy(xpath="//input[@name='taxes[]']")
	public  WebElement chkbox_Tax1;
	
	@FindBy(xpath="//select[@id='blockId']")
	public  WebElement drpdwn_RoomareaBlock;
	
	public  String amenityN1;
	public  String Roomtypename;
	public static ArrayList<String> l1=new ArrayList<String>();

	
	/**
     * This method gets size of 'Available Amenities' multiple select box in 'size' variable
     * Check for added amenity in the list
     * @param iTestCaseRow : Is used for test data
    * @throws Exception,AssertionError
     */
	public void fn_verifySavedAmenity(String amntyName) throws Exception
   {
		try
		{
    	Select sel=new Select(AAmenities);
    	int size=sel.getOptions().size();
    	for(int i=0;i<size;i++)
    	  {

    	     String str=sel.getOptions().get(i).getText();
    	     if(str.equalsIgnoreCase(amntyName))
    	       {
    	    	 Assert.assertEquals(str.equals(amntyName), true);
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

	
	
	public void fn_verifyDeletedAmenity(String amntyName) throws Exception
	{
		try
		{
		Select sel=new Select(AAmenities);
    	int size=sel.getOptions().size();
    	for(int i=0;i<size;i++)
    	{

    	     String str=sel.getOptions().get(i).getText();
    	     l1.add(str);
    	     if(l1.contains(amntyName))
 	    	{
    	    	 Assert.assertEquals(l1.contains(amntyName), true);
 	    		System.out.println("Deleted amenity is still getting displayed on 'Add Room Type' page under 'Availabale Amenities' section.");
 	    		break;
 	    	}
    	}
		}catch(AssertionError e)
		{
			throw e;
		}catch(Exception e)
		{
			throw e;
		}
	}

	
	public  RoomTypesLandingPage clk_RoomTypeListLink() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_RoomTypesList);
		}
		catch(NoSuchElementException e)
		{
			GenericClass.js_Click(link_RoomTypesList);
		}
		catch(Exception e)
		{
			throw e;
		}
		RoomTypesLandingPage RoomtypeLandingPageobj=PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RoomtypeLandingPageobj;
	}
	
	
	public void fn_verifyActivatedAmenity(String amntyName) throws Exception
	{
		try
		{
		Select sel=new Select(AAmenities);
    	int size=sel.getOptions().size();
    	for(int i=0;i<size;i++)
    	{

    	     String str=sel.getOptions().get(i).getText();
    	     l1.add(str);
    	     if(l1.contains(amntyName))
 	    	{
    	    	 Assert.assertEquals(l1.contains(amntyName), true);
 	    		System.out.println("Activated amenity is getting displayed under 'Available Amenities' multiple selection box.");
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
	
	
	public  void verify_deactiveStatus(String amntyName) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(checkBox);
		for(int i=2;i<=count;i++)
		{
	      WebElement element=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]"));
	      amenityN1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	        if(amenityN1.contains(amntyName))
	          {
	            String value=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]//img")).getAttribute("src");
	             if(value.contains("on.GIF"))
	                {
	                  element.click();
	                  Thread.sleep(4000);
	                }

	          }


	    String value1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]//img")).getAttribute("src");
	    Assert.assertTrue(value1.contains("off.GIF"));
	    break;
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
	
	public void fn_verifyDeactivatedAmenity(String amntyName) throws Exception
	{
		try
		{
		Select sel=new Select(AAmenities);
    	int size=sel.getOptions().size();
    	for(int i=0;i<size;i++)
    	{

    	     String str=sel.getOptions().get(i).getText();
    	     l1.add(str);
    	     if(l1.contains(amntyName))
 	    	{
    	    	 Assert.assertEquals(l1.contains(amntyName), true);
 	    		System.out.println("Deactivated amenity is still getting displayed under 'Available Amenities' multiple selection box");
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
	
	public String fn_verifyPageHeader() throws Exception
	{
		try
		{
		String str=GenericClass.getText(heading_Page);
        return str;
		}		
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void verifyAddRoomTypePage(int iTestCaseRow) throws Exception
	{
		try
		{

	    Boolean result=	GenericClass.checkElementDisplay("Add a Room Type",heading_Page);
		GenericClass.checkElementDisplay("Save",btn_SaveTop);
		GenericClass.checkElementDisplay("Cancel",btn_CancelTop);
		GenericClass.checkElementDisplay("Save btn at bottom",btn_SaveBottom);
		GenericClass.checkElementDisplay("Cancel btn at bottom",btn_CancelBottom);
		GenericClass.checkElementDisplay("Main",link_Main);
		GenericClass.checkElementDisplay("Audit Trail",link_AuditTrail);
		GenericClass.checkElementDisplay("Room Types List",link_RoomTypesList);

		GenericClass.checkElementDisplay("Name Room Type Edit box",editbox_NameRoomType);

		GenericClass.checkElementDisplay("Short Name Editbox",editbox_shortName);
		String str1=GenericClass.getText(txt_ShortNameMsg);
		Assert.assertEquals(str1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));

		GenericClass.checkElementDisplay("Upload Image text",txt_UploadImage);
		GenericClass.checkElementDisplay("Browse button", btn_Browse);
		String str2=GenericClass.getText(txt_UploadImageMsg);
		Assert.assertEquals(str2, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));

		GenericClass.checkElementDisplay("Image Caption Editbox",editbox_ImageCaption);

		GenericClass.checkElementDisplay("Description Editbox",editbox_Description);

		GenericClass.checkElementDisplay("Base Occupancy Dropdown",drpdwn_BaseOccupancy);

		GenericClass.checkElementDisplay("Higher Occupancy Dropdown",drpdwn_HigherOccupancy);

		GenericClass.checkElementDisplay("Extra Beds Drpdown",drpdwn_ExtraBeds);
		GenericClass.checkElementDisplay("Extra Bed Allowed checkbox",chkbox_ExtraBedAllowed);
		String str3=GenericClass.getText(txt_ExtraBedAllowedMsg);
        Assert.assertTrue(str3.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3))));

		GenericClass.checkElementDisplay("Number Of Rooms text",txt_NumberOfRooms);

		GenericClass.checkElementDisplay("Select Amenities text",txt_SelectAmenities);
		GenericClass.checkElementDisplay("Available Amenities text",txt_AvailableAmenities);
		GenericClass.checkElementDisplay("Selected Amenities text",txt_SelectedAmenities);
		GenericClass.checkElementDisplay("trfAvailableAmenities button",btn_trfAvailableAmenities);
		GenericClass.checkElementDisplay("trfSelectedAmenities button",btn_trfSelectedAmenities);
		GenericClass.checkElementDisplay("RackRate text",txt_RackRate);

		GenericClass.checkElementDisplay("BasePrice text",txt_BasePrice);
		GenericClass.checkElementDisplay("BasePrice Editbox",editbox_BasePrice);

		GenericClass.checkElementDisplay("HigherPrice text",txt_HigherPrice);
		GenericClass.checkElementDisplay("HigherPrice Editbox",editbox_HigherPrice);

		GenericClass.checkElementDisplay("ExtraBedPrice text",txt_ExtraBedPrice);
		GenericClass.checkElementDisplay("ExtraBedPrice Editbox",editbox_ExtraBedPrice);

		GenericClass.checkElementDisplay("SelectApplicableTax text",txt_SelectApplicableTax);

		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	
	public  ArrayList<String> fn_FillAddRoomTypeDetails(int iTestCaseRow) throws Exception

	{
		try
		{
        Thread.sleep(6000);
        Roomtypename=GenericClass.generateRandomString();
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName), Workbook);
		GenericClass.sendKeys(editbox_NameRoomType, Roomtypename);

		Thread.sleep(3000);
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeShortName), Workbook);
		GenericClass.sendKeys(editbox_shortName,Roomtypename);

		Thread.sleep(3000);
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description), Workbook);
			GenericClass.sendKeys(editbox_Description, Roomtypename);


		GenericClass.selectElement(drpdwn_BaseOccupancy, "1");
		GenericClass.selectElement(drpdwn_HigherOccupancy, "3");
		GenericClass.clickElement(txt_AddAmenities);
		GenericClass.clickElement(btn_trfAvailableAmenities);

		Select sel=new Select(drpdwn_SelectedAmenity);
    	int size=sel.getOptions().size();
    	for(int i=0;i<size;i++)
    	{

    	     String str=sel.getOptions().get(i).getText();
    	     l1.add(str);
    	}

		GenericClass.sendKeys(editbox_BasePrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeBasePrice)));

		GenericClass.sendKeys(editbox_HigherPrice, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeHigherPrice)));
		}
		catch(Exception e)
		{
			throw e;
		}
		return l1;
	}


	public RoomTypesLandingPage fn_clkSave() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_SaveTop);
		}
		catch(NoSuchElementException e)
		{
			GenericClass.js_Click(btn_SaveTop);
		}
		catch(Exception e)
		{
			throw e;
		}
		RoomTypesLandingPage RoomtypeLandingPageobj = PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RoomtypeLandingPageobj;
	}
	
	
	public  String verify_errorMsg() throws Exception
	{
		try
		{
		String str=GenericClass.getText(errormessage);
        return str;
		}			
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public  void fn_AddRoomTypeDuplicateDetails(int iTestCaseRow,String rtName) throws Exception
	{

		try
		{
		GenericClass.sendKeys(editbox_NameRoomType,rtName );

		GenericClass.sendKeys(editbox_shortName,rtName);

		GenericClass.sendKeys(editbox_Description, rtName);

		GenericClass.selectElement(drpdwn_BaseOccupancy, "2");
		GenericClass.selectElement(drpdwn_HigherOccupancy, "4");
		GenericClass.clickElement(txt_AddAmenities);
		GenericClass.clickElement(btn_trfAvailableAmenities);

		GenericClass.sendKeys(editbox_BasePrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeBasePrice)));

		GenericClass.sendKeys(editbox_HigherPrice, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeHigherPrice)));

		GenericClass.clickElement(btn_SaveTop);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public  void fn_FillExtraBedPrice(int iTestCaseRow) throws Exception

	{
		try
		{
        Thread.sleep(3000);
        Roomtypename=GenericClass.generateRandomString();
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName), Workbook);
		GenericClass.sendKeys(editbox_NameRoomType, Roomtypename);

		//Thread.sleep(3000);
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeShortName), Workbook);
		GenericClass.sendKeys(editbox_shortName,Roomtypename);

		//Thread.sleep(3000);
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description), Workbook);
			GenericClass.sendKeys(editbox_Description, Roomtypename);


		GenericClass.selectElement(drpdwn_BaseOccupancy, "1");
		GenericClass.selectElement(drpdwn_HigherOccupancy, "3");
		GenericClass.clickElement(txt_AddAmenities);
		GenericClass.clickElement(btn_trfAvailableAmenities);

		Select sel=new Select(drpdwn_SelectedAmenity);
    	int size=sel.getOptions().size();
    	for(int i=0;i<size;i++)
    	{

    	     String str=sel.getOptions().get(i).getText();
    	     l1.add(str);
    	}

		GenericClass.sendKeys(editbox_BasePrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeBasePrice)));

		GenericClass.sendKeys(editbox_HigherPrice, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeHigherPrice)));

		boolean value=editbox_ExtraBedPrice.isEnabled();
		Assert.assertEquals(value, false);
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

	
	public  void fn_SelectExtraBed(int iTestCaseRow) throws Exception

	{
		try
		{
        Thread.sleep(3000);
        Roomtypename=GenericClass.generateRandomString();
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName), Workbook);
		GenericClass.sendKeys(editbox_NameRoomType,Roomtypename);

		//Thread.sleep(3000);
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeShortName), Workbook);
		GenericClass.sendKeys(editbox_shortName,Roomtypename);

		//Thread.sleep(3000);
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description), Workbook);
			GenericClass.sendKeys(editbox_Description, Roomtypename);


		GenericClass.selectElement(drpdwn_BaseOccupancy, "1");
		GenericClass.selectElement(drpdwn_HigherOccupancy, "3");
		GenericClass.clickElement(txt_AddAmenities);
		GenericClass.clickElement(btn_trfAvailableAmenities);

		Select sel=new Select(drpdwn_SelectedAmenity);
    	int size=sel.getOptions().size();
    	for(int i=0;i<size;i++)
    	{

    	     String str=sel.getOptions().get(i).getText();
    	     l1.add(str);
    	}

		GenericClass.sendKeys(editbox_BasePrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeBasePrice)));

		GenericClass.sendKeys(editbox_HigherPrice, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeHigherPrice)));

		boolean value=drpdwn_ExtraBeds.isEnabled();
		Assert.assertEquals(value, false);
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
	
	
	public  RoomTypesLandingPage fn_clkCancelTopBtn() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_CancelTop);

		RoomTypesLandingPage RoomtypeLandingPageobj=	PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RoomtypeLandingPageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public AdminHome clk_Mainlnk() throws Exception
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
	
	public AuditTrailAddRoomTypePage fn_clkAuditTrail() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_AuditTrail);
		}
		catch(NoSuchElementException e)
		{
			GenericClass.js_Click(link_AuditTrail);
		}
		AuditTrailAddRoomTypePage ATAP=PageFactory.initElements(GenericClass.driver, AuditTrailAddRoomTypePage.class);
		return ATAP;
	}

	
	
	public void fn_CreateRoomtype(int iTestCaseRow) throws Exception{
		try{
			GenericClass.sendKeys(editbox_NameRoomType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			GenericClass.sendKeys(editbox_shortName,GenericClass.generateRandomString());
			GenericClass.sendKeys(editbox_Description, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
			GenericClass.selectElement(drpdwn_BaseOccupancy, "1");
			GenericClass.selectElement(drpdwn_HigherOccupancy, "3");
			GenericClass.clickElement(txt_AddAmenities);
			GenericClass.clickElement(btn_trfAvailableAmenities);
			GenericClass.sendKeys(editbox_BasePrice,"1");

			GenericClass.sendKeys(editbox_HigherPrice, "2");
			
		}catch(Exception e){
			throw e;
		}
	    }
}
