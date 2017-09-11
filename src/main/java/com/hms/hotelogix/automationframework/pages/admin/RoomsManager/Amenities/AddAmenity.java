package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class AddAmenity {

	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	 public  WebElement  heading_Page;
	
	@FindBy(xpath="//div//input[@name='Submit5']")
	public  WebElement btn_SaveTop;

	@FindBy(xpath="//div//input[@name='Submit52']")
	public  WebElement btn_CancelTop;
	
	@FindBy(xpath="//input[@name='titleMulTang[]']")
	public  WebElement txtbx_AmenitiesTitle;
	
	@FindBy(xpath="//tbody/tr//td/input")
	public  WebElement amenityName;

	@FindBy(xpath="//td/input[@name='imageName']")
	public  WebElement btn_Browse;

	@FindBy(xpath="//tr//td/textarea[@id='descriptionMulTang_0']")
	public WebElement txtbx_Description;

	@FindBy(xpath="//td/input[@name='Submit5']")
	public  WebElement btn_SaveBottom;

	@FindBy(xpath="//input[@name='Submit52']")
	public  WebElement btn_CancelBottom;

	@FindBy(xpath="//tr/td/a")
	public  WebElement link_Main;

	@FindBy(xpath="//a[text()='Amenities List']")
	 public  WebElement link_Amenities;

	@FindBy(xpath="//td/a[text()='AuditTrail']")
	public  WebElement link_AuditTrailALP;
	
	@FindBy(xpath="//td[@class='padingtd']//tr[2]//td[2]")
	public  WebElement msg_Validation;
	
	@FindBy(xpath="//div/a[text()='View']")
	public  WebElement link_ViewImg;
	
	@FindBy(xpath="//a[contains(@onclick,'return deleteImage')]")
    public  WebElement link_RemoveImg;
	
	public  String amntyName;
	public static String src1;

	
	
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
	
	
	/**
	 * This method verifies display of all the elements on 'AddEditAmenity' page
	 * @throws Exception
	 */
	public void fn_verifyPageElements() throws Exception
	{
		try
		{
		GenericClass.checkElementDisplay("Save btn at top of the page", btn_SaveTop);
		GenericClass.checkElementDisplay("Cance at top of the page", btn_CancelTop);
		GenericClass.checkElementDisplay("Save at bottom of the page", btn_SaveBottom);
		GenericClass.checkElementDisplay("Cance at bottom of the page", btn_CancelBottom);
		GenericClass.checkElementDisplay("Browse", btn_Browse);
		GenericClass.checkElementDisplay("Main", link_Main);
		GenericClass.checkElementDisplay("Amenities", link_Amenities);
		GenericClass.checkElementDisplay("Audit Trail", link_AuditTrailALP);
		GenericClass.checkElementDisplay("Amenities Title", txtbx_AmenitiesTitle);
		GenericClass.checkElementDisplay("Description", txtbx_Description);
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	public  void AddAmenityDetails_WithoutImg() throws Exception
	{

		try
		{

//		fn_uploadimage(iTestCaseRow);
//		Thread.sleep(2000);
        amntyName=GenericClass.generateRandomString();
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AmenitiesTitle), Workbook);
		GenericClass.sendKeys(txtbx_AmenitiesTitle, amntyName);

		Thread.sleep(3000);

		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AmenitiesDescription), Workbook);
		GenericClass.sendKeys(txtbx_Description,amntyName);


		}
		catch(Exception e)
		{
			throw e;
		}

	}
	public  AmenitiesLandingPage AddAnAminity_WithoutImage() throws Exception
	{
        try
        {
        AddAmenityDetails_WithoutImg();
        Thread.sleep(2000);
		GenericClass.clickElement(btn_SaveBottom);
		Thread.sleep(2000);

        }
        catch(NoSuchElementException e)
        {
        	Thread.sleep(1000);
        	GenericClass.js_Click(btn_SaveBottom);
        }
        catch(Exception e)
        {
        	throw e;
        }
		AmenitiesLandingPage AmenitiesLandingPageobj = PageFactory.initElements(GenericClass.driver, AmenitiesLandingPage.class);
		return AmenitiesLandingPageobj;
	}

	
	public  void fn_DuplicateAmenityDetails(String amntyName) throws Exception
	{

		try
		{
		//fn_uploadimage(iTestCaseRow);
		Thread.sleep(2000);

		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AmenitiesTitle), Workbook);
		GenericClass.sendKeys(txtbx_AmenitiesTitle,amntyName);
        GenericClass.clickElement(btn_SaveBottom);
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	public String fn_verifyDuplicateMsg() throws Exception
	{
		try
		{
		String str=GenericClass.getText(msg_Validation);
		return str;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	
	public String fn_verifyWithoutData() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_SaveBottom);
		String str=GenericClass.getText(msg_Validation);
		//System.out.println(ExcelUtil.getCellData(iTestCaseRow, Constant.Col_ExpectedResult4));
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
	
	public  void fn_uploadimage(int iTestCaseRow) throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_Browse);


		WebElement obj=	GenericClass.driver.findElement(By.xpath("//td/input[@name='imageName']"));


		GenericClass.uploadImage(System.getProperty("user.dir")+ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_UploadImagePath)));
		//GenericClass.sendKeys(obj,Constant.Path_ImgData+ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_UploadImagePath)));
		Thread.sleep(2000);
		System.out.println("On wait");
		Thread.sleep(5000);
        obj=null;
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(1000);
			GenericClass.js_Click(btn_Browse);
			WebElement obj=	GenericClass.driver.findElement(By.xpath("//td/input[@name='imageName']"));
			GenericClass.uploadImage(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_UploadImagePath)));
			Thread.sleep(2000);
			System.out.println("On wait");
			Thread.sleep(5000);

		}
		//GenericClass.clickElement(save_bt);

//		RoomtypeLandingPage RoomtypeLandingPageobj = PageFactory.initElements(GenericClass.driver, RoomtypeLandingPage.class);
//		return RoomtypeLandingPageobj;

		}

	
	
	public  void fn_AddAmenityDetails(int iTestCaseRow,String Workbook) throws Exception
	{

		try
		{

		fn_uploadimage(iTestCaseRow);
		Thread.sleep(2000);
        amntyName=GenericClass.generateRandomString();
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AmenitiesTitle), Workbook);
		GenericClass.sendKeys(txtbx_AmenitiesTitle, amntyName);

		Thread.sleep(3000);

		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AmenitiesDescription), Workbook);
		GenericClass.sendKeys(txtbx_Description, amntyName);


		}
		catch(Exception e)
		{
			//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AmenitiesTitle), Workbook);
			GenericClass.js_Sendkey(txtbx_AmenitiesTitle, amntyName);

			Thread.sleep(3000);

			//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AmenitiesDescription), Workbook);
			GenericClass.js_Sendkey(txtbx_Description, amntyName);

		}

	}

	
	public  AmenitiesLandingPage AddAnAminity( int iTestCaseRow,String Workbook) throws Exception
	{
        try
        {
        fn_AddAmenityDetails(iTestCaseRow,Workbook);
        Thread.sleep(2000);
		GenericClass.clickElement(btn_SaveBottom);
		Thread.sleep(2000);

        }
        catch(NoSuchElementException e)
        {
        	Thread.sleep(1000);
        	GenericClass.js_Click(btn_SaveBottom);
        }
        catch(Exception e)
        {
        	throw e;
        }
		AmenitiesLandingPage AmenitiesLandingPageobj = PageFactory.initElements(GenericClass.driver, AmenitiesLandingPage.class);
		return AmenitiesLandingPageobj;
	}
	
	
	public  AmenitiesLandingPage fn_verifySaveRTBtn( int iTestCaseRow) throws Exception
	{

        try
        {
        fn_uploadimage(iTestCaseRow);
        fn_AddAmenityDetails(iTestCaseRow,Constant.File_Amenities);
		Thread.sleep(2000);
		GenericClass.clickElement(btn_SaveTop);
		Thread.sleep(2000);
        }
        catch(NoSuchElementException e)
        {
        	fn_uploadimage(iTestCaseRow);
            fn_AddAmenityDetails(iTestCaseRow,Constant.File_Amenities);
      		Thread.sleep(2000);
      		GenericClass.js_Click(btn_SaveTop);
      		Thread.sleep(2000);
        }
        catch (Exception e)
        {
			throw e;
		}
		AmenitiesLandingPage AmenitiesLandingPageobj = PageFactory.initElements(GenericClass.driver, AmenitiesLandingPage.class);
		return AmenitiesLandingPageobj;
	}

	
	
	public  AmenitiesLandingPage fn_cancelBtn( int iTestCaseRow) throws Exception
	{

		try
		{
		fn_AddAmenityDetails(iTestCaseRow,Constant.File_Amenities);
		Thread.sleep(2000);
		GenericClass.clickElement(btn_CancelBottom);
		Thread.sleep(2000);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(1000);
			GenericClass.js_Click(btn_CancelBottom);
		}
		catch(Exception e)
		{
			throw e;
		}
		AmenitiesLandingPage AmenitiesLandingPageobj = PageFactory.initElements(GenericClass.driver, AmenitiesLandingPage.class);
		return AmenitiesLandingPageobj;
	}

	
	public AdminHome fn_clkMain() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_Main);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(1000);
			GenericClass.js_Click(link_Main);
		}
		catch(Exception e)
		{
			throw e;
		}
		AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
		return AH;
	}
	
	
	public AmenitiesLandingPage fn_clkAmenitiesList() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_Amenities);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(1000);
			GenericClass.js_Click(link_Amenities);
		}
		catch (Exception e)
		{
			throw e;
		}
		AmenitiesLandingPage AmenitiesLandingPageobj = PageFactory.initElements(GenericClass.driver, AmenitiesLandingPage.class);
		return AmenitiesLandingPageobj;
	}
	
	
	public AddAmenitiesAT fn_clkAuditTrail() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_AuditTrailALP);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(1000);
			GenericClass.js_Click(link_AuditTrailALP);
		}
		catch(Exception e)
		{
			throw e;
		}
		AddAmenitiesAT AT=PageFactory.initElements(GenericClass.driver, AddAmenitiesAT.class);
		return AT;
	}
	
	
	public ViewImage_Class fn_clkViewLnk() throws Exception
	{
		try
		{
		WebElement ele=GenericClass.driver.findElement(By.cssSelector("div[id^=container]"));
		src1=ele.getText();
		int i=src1.indexOf("(");
		String part=src1.substring(0, i);
		src1=part.trim();
		GenericClass.clickElement(link_ViewImg);
		}
		catch(NoSuchElementException e)
		{
			WebElement ele=GenericClass.driver.findElement(By.cssSelector("div[id^=container]"));
			src1=ele.getText();
			int i=src1.indexOf("(");
			String part=src1.substring(0, i);
			src1=part.trim();
			GenericClass.js_Click(link_ViewImg);
		}
		ViewImage_Class VIC=PageFactory.initElements(GenericClass.driver, ViewImage_Class.class);
		return VIC;
	}
	
	
	
	public void fn_removeAlertAccept() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_RemoveImg);
		GenericClass.ActionOnAlert("Accept");
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
		boolean value=link_RemoveImg.isDisplayed();
		Assert.assertEquals(value, false);
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	
	public String  fn_getImageName()
	{
		try
		{
		WebElement ele=GenericClass.driver.findElement(By.cssSelector("div[id^=container]"));
		src1=ele.getText();
		int i=src1.indexOf("(");
		String part=src1.substring(0, i);
		src1=part.trim();
		return src1;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_verifyRemoveAlert() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_RemoveImg);
		String text=GenericClass.ActionOnAlert("Dismiss");
		Assert.assertEquals(text, "Do you really want to delete selected image.");
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
}
