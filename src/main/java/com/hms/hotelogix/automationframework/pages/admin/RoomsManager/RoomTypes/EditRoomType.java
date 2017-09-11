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
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class EditRoomType {

	
	@FindBy(xpath="//select[@id='mainAmenity']")
	public  WebElement multplSelect_AAmenities;
	
	@FindBy(xpath="//td//a[text()='Room Types  List']")
	public  WebElement link_RoomTypesList;
	
	@FindBy(xpath="//select[@id='selectedAmenity']")
	public   WebElement drpdwn_SelectedAmenity;
	
	@FindBy(xpath="//select[@id='mainAmenity']")
	public WebElement AAmenities;

	@FindBy(xpath="//td//input[@name='Submit2']")
	public  WebElement trfAvailableAmenities_BT;
	
	@FindBy(xpath="//input[@type='submit']")
	public  WebElement save_bt;
	
	@FindBy(xpath="//td/input[@name='imageName']")
	public  WebElement btn_Browse;
	
	@FindBy(xpath="//td/input[@name='titleMulTang[]']")
	public  WebElement editbox_NameRoomType;
	
	@FindBy(xpath="//input[@type='submit']")
	public  WebElement btn_SaveBottom;
	
	@FindBy(xpath="//div/a[@id='imgViewLink']")
	public  WebElement link_view;
	
	@FindBy(xpath="//div/a[text()='Remove']")
	public  WebElement link_remove;
	
	@FindBy(xpath="//div[@class='headingtxt']/table//tr//td[2]")
	public WebElement heading_Page;
	
	@FindBy(xpath="//select[@id='stdOccupancy']")
	public  WebElement drpdwn_BaseOccupancy;
	
	@FindBy(xpath="//select[@id='higherOccupancy']")
	public  WebElement drpdwn_HigherOccupancy;
	
	@FindBy(xpath="//input[@name='basePrice']")
	public  WebElement editbox_BasePrice;
	
	@FindBy(xpath="//input[@name='higherPrice']")
	public  WebElement editbox_HigherPrice;
	
	@FindBy(xpath="//li/input[@name='Submit5']")
	public  WebElement btn_SaveTop;
	
	@FindBy(xpath="//td[@class='error']")
	public  WebElement errormessage;
	
	@FindBy(xpath="//input[@name='isBedAlwd']")
	public  WebElement chkbox_ExtraBedAllowed;
	
	@FindBy(xpath="//input[@name='taxes[]']")
	public  WebElement tax_cb;
	
	@FindBy(xpath="//form/table/tbody/tr[2]/td/table/tbody/tr[17]/td[2]/table/tbody/tr")
	public List<WebElement> AllTaxesCount;
	
	public  String src1;
	public  String RTName;
	public static String imgName;
	
	public static ArrayList<String> l1=new ArrayList<String>();

	
	public void fn_verifySavedAmenity(String amntyName) throws Exception
	   {
			try
			{
	        	Select sel=new Select(multplSelect_AAmenities);
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
			}catch(AssertionError e)
			{
				throw e;
			}catch(Exception e)
			{
				throw e;
			}
	   }

	
	/**
	 * This method clicks on 'Room Types List' link and navigates to 'Room Types List' page
	 * @return Object of RoomTypesLandingPage and initializes all its elements
	 * @throws Exception
	 */

	public  RoomTypesLandingPage roomTypeListLink_AddRoomTypePage() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_RoomTypesList);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(1000);
			GenericClass.js_Click(link_RoomTypesList);
		}
		catch(Exception e)
		{
			throw e ;
		}
		RoomTypesLandingPage RoomtypeLandingPageobj=	PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RoomtypeLandingPageobj;
	}

	
	public void fn_verifyDeletedAmenitySelect(String amntyName) throws Exception
	{
		try
		{
		Select sel=new Select(drpdwn_SelectedAmenity);
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

	
	public void fn_SelectAmenity(String amntyName) throws Exception
    {
		try
		{
    	Select sel=new Select(AAmenities);
    	List<WebElement> size=sel.getOptions();

    	for(WebElement we: size)
    	{
    		String str=we.getText();
    		if(str.equalsIgnoreCase(amntyName))
    		{
    			we.click();
                GenericClass.clickElement(trfAvailableAmenities_BT);
    		}
    	}

		}

		catch(Exception e)
		{
			throw e;
		}

    }

	public RoomTypesLandingPage fn_clickSave() throws Exception
	{
		try
		{
		GenericClass.clickElement(save_bt);
		}
		catch(NoSuchElementException e)
		{
			GenericClass.js_Click(save_bt);
		}
		catch(Exception e)
		{
			throw e;
		}
		RoomTypesLandingPage RoomtypeLandingPageobj=PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RoomtypeLandingPageobj;
	}
	
	
	public void Selected_verifyActivatedAmenity(String amntyName) throws Exception
	{
		try
		{
		Select sel=new Select(drpdwn_SelectedAmenity);
    	int size=sel.getOptions().size();
    	for(int i=0;i<size;i++)
    	{

    	     String str=sel.getOptions().get(i).getText();
    	     l1.add(str);
    	     if(l1.contains(amntyName))
 	    	{
 	    		System.out.println("Activated amenity is getting displayed under 'Selected Amenities' multiple select box.");
 	    		break;
 	    	}
    	}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void  Available_verifyDeactivatedAmenity(String amntyName) throws Exception
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
	
	
	public void Selected_verifyDeactivatedAmenity(String amntyName) throws Exception
	{
		try
		{
		Select sel=new Select(drpdwn_SelectedAmenity);
    	int size=sel.getOptions().size();
    	for(int i=0;i<size;i++)
    	{

    	     String str=sel.getOptions().get(i).getText();
    	     l1.add(str);
    	     if(l1.contains(amntyName))
 	    	{
    	    	 Assert.assertEquals(l1.contains(amntyName), true);
 	    		System.out.println("Deactivated amenity still gets displayed under 'Selected Amenities' multiple select box. ");
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
	
	public  RoomTypesLandingPage fn_uploadimage(String imgPath) throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_Browse);
		Thread.sleep(4000);
		GenericClass.uploadImage(System.getProperty("user.dir")+imgPath);
		Thread.sleep(3000);
		System.out.println("On wait");
		RTName=editbox_NameRoomType.getAttribute("value");

		GenericClass.clickElement(btn_SaveBottom);
		}
		catch(Exception e)
		{
			throw e;
		}
		RoomTypesLandingPage RTLP=PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RTLP;

	}

	public RoomTypesLandingPage fn_verifyUploadedImg() throws Exception
	{
		try
		{
		WebElement ele=GenericClass.driver.findElement(By.cssSelector("div[id^=container]"));
		imgName=ele.getText();
		int i=imgName.indexOf("(");
		String part=imgName.substring(0, i);
		imgName=part.trim();
		GenericClass.clickElement(link_RoomTypesList);
		RoomTypesLandingPage RTP=PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RTP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public ViewImage_ClassRT fn_clkViewLnk() throws Exception
	{
		try
		{
		WebElement ele=GenericClass.driver.findElement(By.cssSelector("div[id^=container]"));
		src1=ele.getText();
		int i=src1.indexOf("(");
		String part=src1.substring(0, i);
		src1=part.trim();
		GenericClass.clickElement(link_view);
		}
		catch(NoSuchElementException e)
		{
			WebElement ele=GenericClass.driver.findElement(By.cssSelector("div[id^=container]"));
			src1=ele.getText();
			int i=src1.indexOf("(");
			String part=src1.substring(0, i);
			src1=part.trim();
			GenericClass.js_Click(link_view);
		}
		ViewImage_ClassRT VIC=PageFactory.initElements(GenericClass.driver, ViewImage_ClassRT.class);
		return VIC;
	}

	
	public void fn_verifyRemoveAlert(int iTestCaseRow) throws Exception
	{
		try
		{
		GenericClass.clickElement(link_remove);
		String text=GenericClass.ActionOnAlert("Dismiss");
		Assert.assertEquals(text, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
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

	
	public void fn_removeAlertAccept() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_remove);
		GenericClass.Alert_Accept();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_verifyRemovedImg()
	{
		try
		{
		boolean value1=link_remove.isDisplayed();
		Assert.assertEquals(value1, false);
		boolean value2=link_view.isDisplayed();
		Assert.assertEquals(value2, false);
		}
		catch(AssertionError e)
		{
			throw e;
		}

	}
	
	
	public void fn_removeAlertDismiss() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_remove);
		GenericClass.Alert_Dismiss();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public String verify_pageHeader() throws Exception
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
	
	
	public  void fn_HOGrtrBO(int iTestCaseRow,String Workbook) throws Exception

	{
        try
        {
		RTName=editbox_NameRoomType.getAttribute("value");
		//ExcelUtil.setCellData(RTName, iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName), Workbook);

		GenericClass.selectElement(drpdwn_BaseOccupancy, "1");
		GenericClass.selectElement(drpdwn_HigherOccupancy, "3");


		GenericClass.sendKeys(editbox_BasePrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeBasePrice)));

		GenericClass.sendKeys(editbox_HigherPrice, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeHigherPrice)));
        }
        catch(Exception e)
        {
        	throw e;
        }

	}

	
	public  void  fn_HOLessthanBO(int iTestCaseRow,String Workbook) throws Exception

	{
		try
		{
		RTName=editbox_NameRoomType.getAttribute("value");
	//	ExcelUtil.setCellData(RTName, iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName), Workbook);

		GenericClass.selectElement(drpdwn_BaseOccupancy, "2");
		GenericClass.Alert_Accept();
		GenericClass.selectElement(drpdwn_HigherOccupancy, "1");


		GenericClass.sendKeys(editbox_BasePrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeBasePrice)));

		GenericClass.sendKeys(editbox_HigherPrice, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeHigherPrice)));
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public RoomTypesLandingPage fn_clkSave() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_SaveTop);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(2000);
			GenericClass.js_Click(btn_SaveTop);
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

	
	public void fn_clkExtraBed() throws Exception
	{
		try
		{
		GenericClass.clickElement(chkbox_ExtraBedAllowed);
		GenericClass.clickElement(btn_SaveTop);
		}
		catch(Exception e)
		{
			throw e ;
		}
	}
	
	
	public RoomTypesLandingPage fn_AddTax() throws Exception
	{
		try
		{
		GenericClass.clickElement(tax_cb);
		GenericClass.clickElement(btn_SaveBottom);
		RoomTypesLandingPage RoomtypeLandingPageobj=	PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RoomtypeLandingPageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public  void  fn_HOequalBO(int iTestCaseRow,String Workbook) throws Exception

	{
		try
		{
		RTName=editbox_NameRoomType.getAttribute("value");

		GenericClass.selectElement(drpdwn_BaseOccupancy, "1");

		GenericClass.selectElement(drpdwn_HigherOccupancy, "1");


		GenericClass.sendKeys(editbox_BasePrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeBasePrice)));

		//GenericClass.sendKeys(editbox_HigherPrice, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeHigherPrice)));
        boolean value=editbox_HigherPrice.isEnabled();
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
	
	public RoomTypesLandingPage fn_EditRTDetails() throws Exception
	{
		try
		{
			RTName=GenericClass.generateRandomString();
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeName), Workbook);
		GenericClass.sendKeys(editbox_NameRoomType,RTName);
        GenericClass.clickElement(btn_SaveBottom);
		}
		catch(Exception e)
		{
			throw e;
		}
		RoomTypesLandingPage RTLP=PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RTLP;
	}
	
	public  void fn_CharInBasePrice(int iTestCaseRow) throws Exception
	{
		try
		{
		editbox_BasePrice.click();
		editbox_BasePrice.clear();

		GenericClass.sendKeys(editbox_BasePrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomTypeBasePrice)));
		GenericClass.clickElement(btn_SaveBottom);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public ArrayList<String> fn_getSelectedAmenities()
	{
		try
		{
		Select sel=new Select(drpdwn_SelectedAmenity);
    	int size=sel.getOptions().size();
    	for(int i=0;i<size;i++)
    	{

    	     String str=sel.getOptions().get(i).getText();
    	     l1.add(str);
    	}

    	return l1;
		}
		catch(Exception e)
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
		RoomTypesLandingPage RoomtypeLandingPageobj=	PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RoomtypeLandingPageobj;
	}
	
	public void VerifyAddedTax(String taxTitle){
		ArrayList<String> taxes=new ArrayList<String>();
		try{
		for(int i=1;i<=AllTaxesCount.size();i++){
		String taxInList=GenericClass.driver.findElement(By.xpath("//form/table/tbody/tr[2]/td/table/tbody/tr[17]/td[2]/table/tbody/tr["+i+"]/td[2]/table/tbody/tr/td[1]")).getText();
		taxes.add(taxInList);
		}
		Assert.assertEquals(taxes.contains(taxTitle),true);
		Reporter.log("Added Tax verified at Edit Room types", true);
		}
		catch(Exception e){
		throw e;
		}
		}
	
	
	/**	
	 * As this method verifies the deleted tax.
	 * @param tax: Its added tax which is deleted.
	 * @exception :throw exception if any occurs.
	 * @author deepak 
	 */
	public void fn_verifyDeletedTax(String tax){
	try{
		ArrayList<String> taxes=new ArrayList<String>();
		for(int i=1;i<=AllTaxesCount.size();i++){
		String taxInList=GenericClass.driver.findElement(By.xpath("//form/table/tbody/tr[2]/td/table/tbody/tr[17]/td[2]/table/tbody/tr["+i+"]/td[2]/table/tbody/tr/td[1]")).getText();
		taxes.add(taxInList);
	}
	Assert.assertFalse(taxes.contains(tax));
	Reporter.log("Tax not found.", true);
	}
	catch(Exception e){
	throw e;	
	}
	} 
	
	public RoomTypesLandingPage fn_attachTheTaxToRoomType(String addedTax) throws Exception{
		try{
		for(int i=1;i<=AllTaxesCount.size();i++){
		String tax=GenericClass.driver.findElement(By.xpath("//form/table/tbody/tr[2]/td/table/tbody/tr[17]/td[2]/table/tbody/tr["+i+"]/td[2]/table/tbody/tr/td[1]")).getText();
		if(tax.equals(addedTax)){
		GenericClass.driver.findElement(By.xpath("//form/table/tbody/tr[2]/td/table/tbody/tr[17]/td[2]/table/tbody/tr["+i+"]/td[1]/input")).click();
		break;
		}
		}
		GenericClass.clickElement(btn_SaveBottom);
		}
		catch(Exception e){
		throw e;	
		}

		RoomTypesLandingPage RTL=PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RTL;
		}
	
	
	/**
	 * As this method is getting all the taxes are available in the room type.
	 * @return: As it returns the arrayList containing all the taxes.
	 * @exception : If any occurs.
	 * @author deepak.
	 */
	public ArrayList<String> fn_getTaxes(){
	ArrayList<String> taxes=null;	
	try{
	taxes=new ArrayList<String>();
	for(int i=1;i<=AllTaxesCount.size();i++){
	String taxInList=GenericClass.driver.findElement(By.xpath("//form/table/tbody/tr[2]/td/table/tbody/tr[17]/td[2]/table/tbody/tr["+i+"]/td[2]/table/tbody/tr/td[1]")).getText();
	taxes.add(taxInList);
	}
	}
	catch(Exception e){
	throw e;	
	}
	return taxes;
	}
}

