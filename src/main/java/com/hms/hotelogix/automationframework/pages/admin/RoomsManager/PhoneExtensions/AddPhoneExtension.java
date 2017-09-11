package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class AddPhoneExtension 
{

	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	public  WebElement heading_Page;
	
	@FindBy(xpath="//td[@class='padingtd']//th")
	public WebElement txt_pageMsg;
	
	@FindBy(xpath="//input[@name='btnSave2']")
	public WebElement btn_topSave;
	
	@FindBy(xpath="//input[@name='Submit']")
	public WebElement btn_topCancel;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement btn_btmSave;
	
	@FindBy(xpath="//input[@value='Cancel']")
	public WebElement btn_btmCancel;
	
	@FindBy(xpath="//input[@name='extensionNo']")
	public WebElement txtbox_Extension;
	
	@FindBy(xpath="//textarea[@name='title']")
	public WebElement txtbox_Title;
	
	@FindBy(xpath="//textarea[@name='description']")
	public WebElement txtbox_Comments;
	
	@FindBy(xpath="//td[@class='padingtd']//tr[7]//td[2]")
	public WebElement txt_Note;
	
	@FindBy(xpath="//td//a[text()='Main']")
	public WebElement link_Main;
	
	@FindBy(xpath="//td/a[text()='AuditTrail']")
	public WebElement link_AuditTrail;
	
	@FindBy(xpath="//td/a[text()='Phone Extension List']")
	public WebElement link_PhoneExtension;
	
	@FindBy(xpath="//td[@class='error']")
    public WebElement txt_Message;
	
	public String PETitle;
	public String PENum;
	
	/**
	 * This method gets page header in a string variable 'str'
	 * Verifies it with expected result in test data
	 * @param iTestCaseRow :  Is used for test data
	 * @throws Exception,AssertionError
	 */
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
	
	
	/**
	 * This method verifies the presence of various elements on Add Phone Extension page
	 * @param iTestcaseRow : Is used for test data
	 * @throws Exception,AssertionError
	 */
	public void verify_pageElements(int iTestcaseRow) throws Exception
	{
		try
		{
		GenericClass.checkElementDisplay("Save btn at top", btn_topSave);
		GenericClass.checkElementDisplay("Cancel btn at top", btn_topCancel);
		GenericClass.checkElementDisplay("Save btn at bottom", btn_btmSave);
		GenericClass.checkElementDisplay("Cancel btn at bottom", btn_btmCancel);
		GenericClass.checkElementDisplay("Extension", txtbox_Extension);
		GenericClass.checkElementDisplay("Title", txtbox_Title);
		GenericClass.checkElementDisplay("Comments", txtbox_Comments);
		GenericClass.checkElementDisplay("Main", link_Main);
		GenericClass.checkElementDisplay("Audit Trail", link_AuditTrail);
		GenericClass.checkElementDisplay("Phone Extension List", link_PhoneExtension);
		String str=GenericClass.getText(txt_Note);
		Assert.assertEquals(str, ExcelUtil.getCellData(iTestcaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
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
	 * This method clicks on 'Main' link and navigates to Administrator Console home page
	 * @return: Object of AdmineHome page and initializes all its elements
	 * @throws Exception
	 */
	public AdminHome fn_clkMain() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_Main);
		AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
		return AH;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	/**
	 * This method clicks on 'Phone Extension List' link and navigates to PhoneExtensionListPage 
	 * @return: PhoneExtensionsListPage object and initializes all its elements
	 * @throws Exception
	 */
	public PhoneExtensionsListPage fn_clkPhoneExtsn() throws Exception
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
	
	
	public void fn_AddPhoneExtension() throws Exception{
		try{
			GenericClass.sendKeys(txtbox_Extension, GenericClass.GenerateRandomNumber(3));
			GenericClass.clickElement(btn_topSave);
		}catch(Exception e){
			throw e;
		}
	    }
	
	/**
	 * This method enters valid data for Phone Extension and clicks on 'Save' button at top right corner
	 * @param iTestCaseRow: Is used for test data
	 * @return: PhoneExtensionsListPage object and initializes all its elements
	 * @throws Exception
	 */
	public PhoneExtensionsListPage fn_validDataPhExtsn() throws Exception
	{
		try
		{
			PETitle=GenericClass.generateRandomString();
			PENum=GenericClass.GenerateRandomNumber(2);
			Thread.sleep(4000);
		GenericClass.sendKeys(txtbox_Extension,PENum );
		GenericClass.sendKeys(txtbox_Title, PETitle);
		GenericClass.sendKeys(txtbox_Comments, PETitle);
		GenericClass.clickElement(btn_topSave);
		PhoneExtensionsListPage PELP=PageFactory.initElements(GenericClass.driver, PhoneExtensionsListPage.class);
		return PELP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	/**
	 * This method enters valid data for Phone Extension and clicks on 'Save' button at the end of page
	 * @param iTestCaseRow: Is used for test data
	 * @return: PhoneExtensionsListPage object and initializes all its elements
	 * @throws Exception
	 */
	public PhoneExtensionsListPage fn_validDataPhExtsn1() throws Exception
	{
		try
		{
			PETitle=GenericClass.generateRandomString();
			PENum=GenericClass.GenerateRandomNumber(2);
			Thread.sleep(4000);
		GenericClass.sendKeys(txtbox_Extension, PENum);
		GenericClass.sendKeys(txtbox_Title, PETitle);
		GenericClass.sendKeys(txtbox_Comments, PETitle);
		Thread.sleep(4000);
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
	 * This method clicks on 'Save' button at top right corner of page
	 * @throws Exception
	 */
	public void fn_clkSave() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_topSave);
		}
		catch(NoSuchElementException e)
		{
		
			GenericClass.js_Click(btn_topSave);
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
	
	
	/**
	 * This method adds duplicate Phone Extension Number and clicks on 'Save' button
	 * @throws Exception
	 */
	public void fn_addDuplicatePE(String PENum) throws Exception
	{
		try
		{
		GenericClass.sendKeys(txtbox_Extension,PENum);
		GenericClass.clickElement(btn_topSave);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	/**
	 * This method adds Phone Extension Number only and clicks on 'Save' button
	 * @param iTestCaseRow: Is used for test data
	 * @return: PhoneExtensionsListPage object and initializes all its elements
	 * @throws Exception
	 */
	public PhoneExtensionsListPage fn_addPENumberOnly() throws Exception
	{
		try
		{
			PENum=GenericClass.GenerateRandomNumber(2);
		GenericClass.sendKeys(txtbox_Extension, PENum);
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
	 * This method adds valid data for Phone Extension number and clicks on 'Cancel' button at top right corner of the page
	 * Navigates to PhoneExtensionsListPage 
	 * @param iTestCaseRow: Is used for test data
	 * @return: PhoneExtensionsListPage object and initializes all its elements
	 * @throws Exception
	 */
	public PhoneExtensionsListPage addData_clkCancel(int iTestCaseRow) throws Exception
	{
		try
		{
			PETitle=GenericClass.generateRandomString();
		GenericClass.sendKeys(txtbox_Extension, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExtensionNumber)));
		GenericClass.sendKeys(txtbox_Title, PETitle);
		GenericClass.sendKeys(txtbox_Comments,PETitle);
		GenericClass.clickElement(btn_topCancel);
		
		PhoneExtensionsListPage PELP=PageFactory.initElements(GenericClass.driver, PhoneExtensionsListPage.class);
		return PELP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	/**
	 * This method adds valid data for Phone Extension number and clicks on 'Cancel' button at the end of the page
	 * Navigates to PhoneExtensionsListPage 
	 * @param iTestCaseRow: Is used for test data
	 * @return: PhoneExtensionsListPage object and initializes all its elements
	 * @throws Exception
	 */
	public PhoneExtensionsListPage addData_clkCancel1(int iTestCaseRow) throws Exception
	{
		try
		{
		GenericClass.sendKeys(txtbox_Extension, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExtensionNumber)));
		GenericClass.sendKeys(txtbox_Title, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TitlePE)));
		GenericClass.sendKeys(txtbox_Comments, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CommentsPE)));
		GenericClass.clickElement(btn_btmCancel);
		
		PhoneExtensionsListPage PELP=PageFactory.initElements(GenericClass.driver, PhoneExtensionsListPage.class);
		return PELP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public AuditTrailAddPE fn_clkAuditTrail() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_AuditTrail);
		
		AuditTrailAddPE ATA=PageFactory.initElements(GenericClass.driver, AuditTrailAddPE.class);
		return ATA;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
