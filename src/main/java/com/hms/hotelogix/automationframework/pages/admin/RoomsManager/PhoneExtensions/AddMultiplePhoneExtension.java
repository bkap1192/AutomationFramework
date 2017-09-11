
package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class AddMultiplePhoneExtension 
{

	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	public  WebElement heading_Page;
	
	@FindBy(xpath="//td[@class='padingtd']//th")
	public WebElement txt_pageMsg;
	
	@FindBy(xpath="//input[@name='Submit5']")
	public WebElement btn_topSave;
	
	@FindBy(xpath="//input[@name='Submit52']")
	public WebElement btn_topCancel;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement btn_btmSave;
	
	@FindBy(xpath="//input[@value='Cancel']")
	public WebElement btn_btmCancel;
	
	@FindBy(xpath="//td[@class='padingtd']//tr[8]//td[2]")
	public WebElement txt_Note;
	
	@FindBy(xpath="//textarea[@name='extensionNo']")
	public WebElement txtbox_addExtensionNames;
	
	@FindBy(xpath="//input[@name='prefix']")
	public WebElement txtbox_prefix;
	
	@FindBy(xpath="//input[@name='rmFrom']")
	public WebElement txtbox_Extension;
	
	@FindBy(xpath="//input[@name='rmTo']")
    public WebElement txtbox_to;
	
	@FindBy(xpath="//textarea[@name='title']")
	public WebElement txtbox_Title;
	
	@FindBy(xpath="//textarea[@name='description']")
	public WebElement txtbox_Comments;
	
	@FindBy(xpath="//td//a[text()='Main']")
	public WebElement link_Main;
	
	@FindBy(xpath="//td/a[text()='AuditTrail']")
	public WebElement link_AuditTrail;
	
	@FindBy(xpath="//td//a[text()='Phone Extension  List']")
	public WebElement link_PhoneExtension;
	
	@FindBy(xpath="//input[@value='commseprated']")
	public WebElement radiobtn_addExtsnNames;
	
	@FindBy(xpath="//input[@value='range']")
	public WebElement radiobtn_addExtsnNos;
	
	@FindBy(xpath="//td[@class='error']")
    public WebElement txt_Message;
	
	
	public String PEName;
	public String PENum;
	
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
	
	
	
	public void verify_pageElements(int iTestCaseRow) throws Exception
	{
		try
		{
		GenericClass.checkElementDisplay("Add Extension Names", txtbox_addExtensionNames);
		GenericClass.checkElementDisplay("Prefix", txtbox_prefix);
		GenericClass.checkElementDisplay("Extenson #", txtbox_Extension);
		GenericClass.checkElementDisplay("to", txtbox_to);
		GenericClass.checkElementDisplay("Title", txtbox_Title);
		GenericClass.checkElementDisplay("Comments", txtbox_Comments);
		GenericClass.checkElementDisplay("Save top btn", btn_topSave);
		GenericClass.checkElementDisplay("Cancel top btn", btn_topCancel);
		GenericClass.checkElementDisplay("Save bottom btn", btn_btmSave);
		GenericClass.checkElementDisplay("Cancel bottom btn", btn_btmCancel);
		GenericClass.checkElementDisplay("Main", link_Main);
		GenericClass.checkElementDisplay("Phone Extension", link_PhoneExtension);
		GenericClass.checkElementDisplay("Audit Trail", link_AuditTrail);
		String str=GenericClass.getText(txt_Note);
		Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
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
	  
	
	public AdminHome fn_clkMain() throws Exception
	{
		try{
		GenericClass.clickElement(link_Main);
		
		AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
		return AH;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public PhoneExtensionsListPage fn_clkPhExtnLink() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_PhoneExtension);
		
		PhoneExtensionsListPage PELP=PageFactory.initElements(GenericClass.driver, PhoneExtensionsListPage.class);
		return PELP;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	
	public PhoneExtensionsListPage fn_clkTopCancelbtn() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_topCancel);
		
		PhoneExtensionsListPage PELP=PageFactory.initElements(GenericClass.driver, PhoneExtensionsListPage.class);
		return PELP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public PhoneExtensionsListPage fn_clkBottomCancelbtn() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_btmCancel);
		
		PhoneExtensionsListPage PELP=PageFactory.initElements(GenericClass.driver, PhoneExtensionsListPage.class);
		return PELP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public PhoneExtensionsListPage fn_validData() throws Exception
	{
		try
		{
			PEName=GenericClass.generateRandomString();
			PENum=GenericClass.GenerateRandomNumber(2);
		GenericClass.clickElement(radiobtn_addExtsnNames);
		GenericClass.sendKeys(txtbox_addExtensionNames, PENum);
		GenericClass.sendKeys(txtbox_Title, PEName);
		GenericClass.sendKeys(txtbox_Comments, PEName);
		//GenericClass.clickElement(btn_topSave);
		
		PhoneExtensionsListPage PELP=PageFactory.initElements(GenericClass.driver, PhoneExtensionsListPage.class);
		return PELP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public PhoneExtensionsListPage fn_validData1() throws Exception
	{
		try
		{
			PEName=GenericClass.generateRandomString();
			PENum=GenericClass.GenerateRandomNumber(2);
		GenericClass.clickElement(radiobtn_addExtsnNames);
		GenericClass.sendKeys(txtbox_addExtensionNames,PENum);
		GenericClass.sendKeys(txtbox_Title, PEName);
		GenericClass.sendKeys(txtbox_Comments, PEName);
		GenericClass.clickElement(btn_btmSave);
		
		PhoneExtensionsListPage PELP=PageFactory.initElements(GenericClass.driver, PhoneExtensionsListPage.class);
		return PELP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public PhoneExtensionsListPage fn_addExtnNo(String PEFrom,String PETo,int iTestCaseRow) throws Exception
	{
		try
		{
			PEName=GenericClass.generateRandomString();
		GenericClass.clickElement(radiobtn_addExtsnNos);
		GenericClass.sendKeys(txtbox_prefix, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix_PE)));
		GenericClass.sendKeys(txtbox_Extension,PEFrom);
		GenericClass.sendKeys(txtbox_to,PETo);
		GenericClass.sendKeys(txtbox_Title, PEName);
		GenericClass.sendKeys(txtbox_Comments, PEName);
		GenericClass.clickElement(btn_btmSave);
		
		PhoneExtensionsListPage PELP=PageFactory.initElements(GenericClass.driver, PhoneExtensionsListPage.class);
		return PELP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void fn_clkTopSaveBtn() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_topSave);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public PhoneExtensionsListPage fn_clkBottomSaveBtn() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_btmSave);
		
		PhoneExtensionsListPage PELP=PageFactory.initElements(GenericClass.driver, PhoneExtensionsListPage.class);
		return PELP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	/**
	 * This method stores displayed message text in a string variable 'str'
	 * Compares it with test data's expected result 
	 * @param iTestCaseRow: Is used for test data
	 * @throws Exception,AssertionError
	 */
	public String verify_displayedMsg() throws Exception
	{
		try
		{
		String str=GenericClass.getText(txt_Message);
		return str;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public  void fn_clkAddExtnNos() throws Exception
	{
		try
		{
		GenericClass.clickElement(radiobtn_addExtsnNos);
		GenericClass.clickElement(btn_topSave);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_duplicateExtnName(String PENum) throws Exception
	{
		try
		{
			
		GenericClass.clickElement(radiobtn_addExtsnNames);
		GenericClass.sendKeys(txtbox_addExtensionNames,PENum);
		GenericClass.clickElement(btn_topSave);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_duplicateExtnNo(int iTestCaseRow) throws Exception
	{
		try
		{
			GenericClass.clickElement(radiobtn_addExtsnNos);
			GenericClass.sendKeys(txtbox_prefix, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix_PE)));
			GenericClass.sendKeys(txtbox_Extension, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_FromExtn_PE)));
			GenericClass.sendKeys(txtbox_to, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ToExtn_PE)));
			GenericClass.sendKeys(txtbox_Title, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TitlePE)));
			GenericClass.sendKeys(txtbox_Comments, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CommentsPE)));
			GenericClass.clickElement(btn_btmSave);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	
	public AuditTrailAddMultiplePE fn_clkAuditTrailLnk() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_AuditTrail);
		
		AuditTrailAddMultiplePE ATMPE=PageFactory.initElements(GenericClass.driver, AuditTrailAddMultiplePE.class);
		return ATMPE;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
}
