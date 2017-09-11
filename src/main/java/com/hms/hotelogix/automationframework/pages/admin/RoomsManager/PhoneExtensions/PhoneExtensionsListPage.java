package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions;

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

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.ConfirmLoginPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class PhoneExtensionsListPage 
{

	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	public  WebElement heading_Page;
	
	@FindBy(xpath="//li/a[@title='Add a Extension']")
    public  WebElement btn_AddAExtension;
	
	@FindBy(xpath="//li/a[@title='Add Multiple Extension(s)']")
	public WebElement btn_AddMutlipleExtension;
	
	@FindBy(xpath="//li/a[@title='Delete Selected Extension(s)']")
	public WebElement btn_DeleteSelectedExtension;
	
	@FindBy(xpath="//li/a[@title='Cancel']")
	public WebElement btn_Cancel;
	
	@FindBy(xpath="//input[@value='Save Selected']")
	public WebElement btn_SaveSelected;
	
	@FindBy(xpath="//td[@class='breadcurms_new']/a[text()='Main']")
    public  WebElement link_Main;
	
	@FindBy(xpath="//td/a[text()='Edit']")
    public  WebElement link_Edit;
	
	@FindBy(xpath="//td[text()='<<Previous | Next>>']")
    public  WebElement txt_PreviousNext;

    @FindBy(xpath="//table//tr[4]/td//a[text()='AuditTrail']")
    public  WebElement link_AuditTrail;
    
    @FindBy(xpath="//tr//td//a[text()='<<Previous']")
    public  WebElement link_Previous;

    @FindBy(xpath="//td[text()='<<Previous | ']")
    public  WebElement text_Previous;
    
    @FindBy(xpath="//table[@class='list_viewnew']//table//tr//td/a[text()='Next>>']")
    public  WebElement link_Next;
	
    @FindBy(xpath="//td/select[@name='offset']")
    public  WebElement drpdwn_Page;

    @FindBy(xpath="//table[@class='list_viewnew']//table//td")
    public WebElement txt_pgeDrpdown;
    
    @FindBy(xpath="//select[@name='maxEntries']")
    public  WebElement drpdwn_View;
    
    @FindBy(xpath="//table[@class='list_viewnew']//th")
    public  WebElement col_Hash;
    
    @FindBy(xpath="//table[@class='list_viewnew']//th[3]")
    public  WebElement col_Extension;
    
    @FindBy(xpath="//table[@class='list_viewnew']//th[4]")
    public  WebElement col_Title;
    
    @FindBy(xpath="//table[@class='list_viewnew']//th[5]")
    public  WebElement col_Room;
    
    @FindBy(xpath="//table[@class='list_viewnew']//th[6]")
    public  WebElement col_Department;
    
    @FindBy(xpath="//table[@class='list_viewnew']//th[7]")
    public  WebElement col_Action;
  
    @FindBy(xpath="//table[@class='list_viewnew']//th[8]")
    public  WebElement col_Status;
    
    @FindBy(xpath="//form[@name='frmListView']//table//tr[2]/td")
    public WebElement txt_SaveMsg;
    
    @FindBy(xpath="//table[@class='list_viewnew']//tr")
    public List<WebElement> rowcount;
    
    @FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[3]")
    public WebElement txt_PE1;
    
	@FindBy(xpath="//input[@name='ids[]']")
	public  List<WebElement> CheckBoxList;
	
	@FindBy(xpath="//td[@id='col_1']")
    public  WebElement col_1_text;
	
	@FindBy(xpath="//tr//td[8]//a/img")
    public  WebElement img_Status;
	
	@FindBy(xpath="//table[@class='list_viewnew']//th[8]/a[1]/img")
	public  WebElement btn_PEStatusDownward;

    @FindBy(xpath="//table[@class='list_viewnew']//th[8]/a[2]")
    public  WebElement btn_PEStatusUpward;
    
    @FindBy(xpath="//table[@class='list_viewnew']//tbody//table//tbody//td")
    public WebElement text_pageDrpdwn;
  
    @FindBy(xpath="<<Previous | ")
    public WebElement txt_previous;
    
    @FindBy(xpath="//table[@class='list_viewnew'][1]/tbody/tr[2]/td[5]/select")
	public WebElement RoomType_DD;
    
    @FindBy(xpath="//select[starts-with(@name,'department')]")
	public WebElement Department_DD;
    
    @FindBy(xpath="//a[text()='| Frontdesk']")
	public WebElement Link_FrontDesk;
	
    public static String txt_PENumber1;
    
    @FindBy(xpath="//table[@class='list_viewnew']//tr")
	public List<WebElement> TrCount;
    
    
	/**
	 * This method gets page header in a variable str
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
	 * This method gets page title in a String variable
	 * Verifies it with test data
	 * @param iTestCaseRow: Is used for test data
	 * @throws Exception,AssertionError
	 */
	public String verify_pageTitle() throws Exception
	{
		try
		{
		String str=GenericClass.driver.getTitle();
		return str;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	/**
	 * This method verifies presence of various elements on Phone Extension List page
	 * @throws Exception
	 */
	public void verify_pageElements() throws Exception
	{
		try
		{
		GenericClass.checkElementDisplay("Add A Extension", btn_AddAExtension);
		GenericClass.checkElementDisplay("Add Multiplt Extension", btn_AddMutlipleExtension);
		GenericClass.checkElementDisplay("Delete Selected Extension", btn_DeleteSelectedExtension);
		GenericClass.checkElementDisplay("Cancel", btn_Cancel);
		GenericClass.checkElementDisplay("Save Selected", btn_SaveSelected);
		GenericClass.checkElementDisplay("Main", link_Main);
		GenericClass.checkElementDisplay("Edit", link_Edit);
		GenericClass.checkElementDisplay("Audit Trail", link_AuditTrail);
		//GenericClass.checkElementDisplay("<<Previous | Next>>", txt_PreviousNext);
		GenericClass.checkElementDisplay("Hash", col_Hash);
		GenericClass.checkElementDisplay("Extension", col_Extension);
		GenericClass.checkElementDisplay("Title", col_Title);
		GenericClass.checkElementDisplay("Room", col_Room);
		GenericClass.checkElementDisplay("Department", col_Department);
		GenericClass.checkElementDisplay("Action", col_Action);
		GenericClass.checkElementDisplay("Status", col_Status);
		GenericClass.checkElementDisplay("Page", drpdwn_Page);
		GenericClass.checkElementDisplay("View records per page", drpdwn_View);
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	public void fn_viewAll()
	{
		try
		{
		GenericClass.selectElement(drpdwn_View, "All");
		GenericClass.Alert_Accept();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	
	/**
	 * This method clicks on 'ADD A EXTENSION' button
	 * Navigates to AddPhoneExtension page
	 * @return : Object of AddPhoneExtension page and initializes all its elements
	 * @throws Exception
	 */
	public AddPhoneExtension fn_navigateToAddPhoneExtnsn() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_AddAExtension);
		AddPhoneExtension APE=PageFactory.initElements(GenericClass.driver, AddPhoneExtension.class);
		return APE;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	/**
	 * This method get message being displayed on successful save
	 * Compares it with expected message from test data
	 * @param iTestCaseRow: Is used for test data
	 * @throws Exception,AssertionError
	 */
	public String verify_saveMsg() throws Exception
	{
		try
		{
		String str=GenericClass.getText(txt_SaveMsg);
		return str;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public String verify_saveMultplExtsnMsg() throws Exception
	{
		try
		{
		String str=GenericClass.getText(txt_SaveMsg);
		return str;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	
	/**
	 * This method calculates tr count and gets Extsn Numb txt in a variable 'PENumb'
	 * Verifies its 'Status' and display of drop down under 'Room' and 'Department' column
	 * @param iTestCaseRow: Is used for test data
	 * @throws Exception,AssertionError
	 */
	public void verify_savedPhoneExtsn(String PE,int iTestCaseRow) throws Exception
	{
		try
		{
			ArrayList<String> arr=new ArrayList<>();
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count;i++)
		{
			String PENumb=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			arr.add(PENumb);
			if(PENumb.equals(PE))
			{
				Assert.assertEquals(PENumb, PE);
				String src=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]//img")).getAttribute("src");
				Assert.assertTrue(src.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
				WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[5]/select"));
				String tag1=ele.getTagName();
				Assert.assertEquals(tag1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
				WebElement ele1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/select"));
				String tag2=ele1.getTagName();
				Assert.assertEquals(tag2, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
				break;
			}
		}
		Assert.assertEquals(arr.contains(PE), true);
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
	 * This method stores text of 1st Phone Extension number displayed in the list
	 * Stores it in string variable 'txt_PENumber1'
	 * @throws Exception 
	 */
	public void fn_getPENum1()
	{
		try
		{
		txt_PENumber1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td[3]")).getText();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public AddMultiplePhoneExtension fn_navigateToAddMultiplePhExtnsn() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_AddMutlipleExtension);
		
		AddMultiplePhoneExtension AMPE=PageFactory.initElements(GenericClass.driver, AddMultiplePhoneExtension.class);
		return AMPE;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public void verify_savedMultplPhExtsn(int iTestCaseRow) throws Exception
	{
		try
		{
	    String arr= ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExtensionNames));	
		ArrayList<String> l1=new ArrayList<>();
	    String[] arr1=arr.split(",");
	    l1.add(arr1[0]);
	    l1.add(arr1[1]);
	    
	    int count1=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count1-2;i++)
		{
			String PENumb=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			ArrayList<String> l2=new ArrayList<>();
			l2.add(PENumb);
			if(PENumb.contains(arr1[0]) ||PENumb.contains(arr1[1])==true)
			{
				Assert.assertEquals(PENumb.contains(arr1[0]) ||PENumb.contains(arr1[1]),true);
				String src=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]//img")).getAttribute("src");
				Assert.assertTrue(src.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))));
				WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[5]/select"));
				String tag1=ele.getTagName();
				Assert.assertEquals(tag1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
				WebElement ele1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/select"));
				String tag2=ele1.getTagName();
				Assert.assertEquals(tag2, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
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
	
	
	public void verify_savedExtsnNo(int iTestCaseRow) throws Exception
	{
		try
		{
	    String Pre= ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix_PE));	
		String toExt=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ToExtn_PE));
	    //ArrayList<String> l1=new ArrayList<>();
	    //String[] arr1=arr.split(",");
	    //l1.add(Pre+frmExt);
	    //l1.add(arr1[1]);
	    
	    int count1=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count1-2;i++)
		{
			String PENumb=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			ArrayList<String> l2=new ArrayList<>();
			l2.add(PENumb);
			if(PENumb.contains(Pre+toExt)==true)
			{
				Assert.assertEquals(PENumb.contains(Pre+toExt),true);
				String src=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]//img")).getAttribute("src");
				Assert.assertTrue(src.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))));
				WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[5]/select"));
				String tag1=ele.getTagName();
				Assert.assertEquals(tag1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
				WebElement ele1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/select"));
				String tag2=ele1.getTagName();
				Assert.assertEquals(tag2, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
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
	
	
	
	
	
	public void fn_verifyDeletePEPopup(String PENum) throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<>();	
		
		    int count1=GenericClass.tr_count(rowcount);
        for(int i=2;i<=count1;i++)
        {
        	String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText(); 
            arr.add(data);
        	if(data.equals(PENum))
            {
        		Assert.assertEquals(data.contains(PENum), true);         
            	GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input")).click();	
        		GenericClass.clickElement(btn_DeleteSelectedExtension);
        		String str=GenericClass.Alert_Dismiss();
        		Assert.assertEquals(str.equals("Do you really want to delete the selected records?"), true);
                break;
            }
		}
        Assert.assertEquals(arr.contains(PENum), true);
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
	
	
	public void fn_DeletePEPopupAccept(String PENum) throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<>();	
		
		    int count1=GenericClass.tr_count(rowcount);
        for(int i=2;i<=count1;i++)
        {
        	String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText(); 
            arr.add(data);
        	if(data.equals(PENum))
            {
        		Assert.assertEquals(data.contains(PENum), true);         
            	GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input")).click();	
        		GenericClass.clickElement(btn_DeleteSelectedExtension);
        		GenericClass.Alert_Accept();
                break;
            }
		}
        Assert.assertEquals(arr.contains(PENum), true);
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
	
	
	
	public String fn_verifyDeletePEAcceptMsg() throws Exception
	{
		try
		{
		String str=GenericClass.getText(txt_SaveMsg);
		//System.out.println(str);
		//System.out.println("- Phone extension Number(s) "+'"'+ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExtensionNumber))+'"'+" deleted Successfully");
		return str;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void fn_verifyDeletedPE(String PENum) throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<>();
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count-3;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			arr.add(data);
			
		}
		Assert.assertEquals(arr.contains(PENum), false);
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
	
	
	public void fn_clkDeletePEPopupCancel() throws Exception
	{
		try
		{
		txt_PENumber1=txt_PE1.getText();
		GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td[2]/input")).click();
		GenericClass.clickElement(btn_DeleteSelectedExtension);
		GenericClass.Alert_Dismiss();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_verifyDeleteCancelClk()
	{
		try
		{
		ArrayList<String> arr=new ArrayList<>();
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count-3;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			arr.add(data);
			
		}
		Assert.assertEquals(arr.contains(txt_PENumber1), true);
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
	
	
	public AdminHome fn_clkCancelBtn() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_Cancel);
		
		AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
		return AH;
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
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count-3;i++)
		{
			WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input"));
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
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count-3;i++)
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
	
	public void fn_deselectIndividualCB()
	{
		try
		{
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count-3;i++)
		{
			WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input"));
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
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count-3;i++)
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
	
	public EditPhoneExtension fn_clkEditBtn() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_Edit);
		
		EditPhoneExtension EPE=PageFactory.initElements(GenericClass.driver, EditPhoneExtension.class);
		return EPE;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public EditPhoneExtension fn_EditPE(String PE) throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<>();
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			arr.add(data);
			if(data.equals(PE))
			{
				Assert.assertEquals(data.equals(PE), true);
				GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();
				break;
			}
		}
		Assert.assertEquals(arr.contains(PE), true);
		
		EditPhoneExtension EPE=PageFactory.initElements(GenericClass.driver, EditPhoneExtension.class);
		return EPE;
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
	
	
	public void fn_verifyDeactiveStatus(int iTestCaseRow) throws Exception
	{
		try
		{
			
		int count=GenericClass.tr_count(rowcount);
		String text=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td")).getText();
		if(text.equalsIgnoreCase(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))))
		{
			AddPhoneExtension APE=fn_navigateToAddPhoneExtnsn();
			APE.fn_validDataPhExtsn();			
		}
		
		for(int i=2;i<=count;i++)
		{
			String src=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]//img")).getAttribute("src");
			if(src.endsWith(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))))
			{
				GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).click();
				break;
			}
				
	    String value1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]//img")).getAttribute("src");
	    Assert.assertTrue(value1.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3))));
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
	
	
	public void fn_verifyActiveStatus(int iTestCaseRow) throws Exception
	{
		try
		{
			
		int count=GenericClass.tr_count(rowcount);
		String text=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td")).getText();
		if(text.equalsIgnoreCase(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))))
		{
			AddPhoneExtension APE=fn_navigateToAddPhoneExtnsn();
			APE.fn_validDataPhExtsn();			
		}
		
		for(int i=2;i<=count;i++)
		{
			String src=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]//img")).getAttribute("src");
			if(src.endsWith(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))))
			{
				GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).click();
				break;
			}
				
	    String value1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]//img")).getAttribute("src");
	    Assert.assertTrue(value1.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3))));
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
	

	
	public void fn_clkSaveSelectedBtn() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_SaveSelected);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_verifyPEPresence(int iTestCaseRow) throws Exception
	{
		try
		{
		//int count=GenericClass.tr_count(rowcount);
		String text=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td")).getText();
		if(text.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))))
		{
			Assert.assertEquals(text.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
			AddPhoneExtension APE=fn_navigateToAddPhoneExtnsn();
			APE.fn_validDataPhExtsn();			
		}
		fn_verifySaveSelectedTxt(iTestCaseRow);
		
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
	
	
	public void fn_verifySaveSelectedTxt(int iTestCaseRow) throws Exception
	{
		try
		{
		//ArrayList<String> arr=new ArrayList<>();
		int count=GenericClass.tr_count(rowcount);
		//fn_verifyPEPresence(iTestCaseRow);		
		for(int i=2;i<=count;i++)
		{
			txt_PENumber1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			//arr.add(data);
//			if(data.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExtensionNumber))))
//			{
				//Assert.assertEquals(data.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExtensionNumber))), true);
				WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[5]/select"));
				Select sel=new Select(ele);
				sel.selectByIndex(1);
				WebElement ele1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/select"));
				Select sel1=new Select(ele1);
				sel1.selectByIndex(1);
				WebElement ele2=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input"));
                if(ele2.isSelected()!=true)
                {
                	ele2.click();
                }
				break;				
//			}
		}
		//Assert.assertEquals(arr.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExtensionNumber))), true);
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
	
	
	public void fn_verifySaveSelectedMsg(int iTestCaseRow) throws Exception
	{
		try
		{
		String str=GenericClass.getText(txt_SaveMsg);
		//System.out.println(str);
		//System.out.println("- Phone extension Number(s) "+'"'+txt_PENumber1+'"'+" mapped Successfully");
		Assert.assertEquals(str.equals("- Phone extension Number(s) "+'"'+txt_PENumber1+'"'+" mapped Successfully"), true);
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
	
	
	public AdminHome fn_clkMainLnk() throws Exception
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
	
	
	public void fn_checkForPE(int iTestCaseRow) throws Exception
	{try{
		String text=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td")).getText();
		if(text.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))))
		{
			Assert.assertEquals(text.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
			AddPhoneExtension APE=fn_navigateToAddPhoneExtnsn();
			APE.fn_validDataPhExtsn();			
		}
	}
	catch(Exception e)
	{
		throw e;
	}
	}
	
	
	
	
	public void fn_verifyViewDropdown(String DropdownValueForView)
	{
		//GenericClass.selectElement(View_Dropdown, DropdownValueForView);
	    try
	    {
		Select sel = new Select(drpdwn_View);
	    sel.selectByVisibleText(DropdownValueForView);


		int count=GenericClass.CheckBox_Count(CheckBoxList);
		String count1=Integer.toString(count);
//		if(DropdownValueForView.equals(count1))
//		{
//
//			System.out.println(DropdownValueForView +" record selected per page to view ");
//		}
		Assert.assertEquals(DropdownValueForView.equals(count1), true);
		Assert.assertEquals(link_Next.isEnabled(), true);
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
	
	
	
	public  void verify_pageDropdown(int iTestCaseRow) throws Exception
	{
		try
		{
			int count=GenericClass.tr_count(rowcount);
			if(count<=5==true)
			{
				Assert.assertTrue(count<=5);
				AddPhoneExtension APE=fn_navigateToAddPhoneExtnsn();
				APE.fn_validDataPhExtsn();			

			}
		 GenericClass.selectElement(drpdwn_View, "1");
		 //GenericClass.selectElement(page_dropdown, "4");		 
	 	 String a=GenericClass.selectElementByvalue(drpdwn_Page, "2");
		 String columntxt=GenericClass.getText(col_1_text);
		 System.out.println(columntxt);
		 boolean columnobj=columntxt.contains(a);
		 System.out.println(columnobj);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void verify_nextLnk(int iTestCaseRow) throws Exception
	{

		try
		{
			
			int count=GenericClass.tr_count(rowcount);
			if(count<=5==true)
			{
				Assert.assertTrue(count<=5);
				AddPhoneExtension APE=fn_navigateToAddPhoneExtnsn();
				APE.fn_validDataPhExtsn();			

			}
			
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

	
	public void fn_verifyDisabledNextLnk(int iTestCaseRow) throws Exception
	{
		try
		{
			int count=GenericClass.tr_count(rowcount);
			if(count<=5==true)
			{
				Assert.assertTrue(count<=5);
				AddPhoneExtension APE=fn_navigateToAddPhoneExtnsn();
				APE.fn_validDataPhExtsn();			

			}
			
			 GenericClass.selectElement(drpdwn_View, "All");
			 GenericClass.Alert_Accept();

			 String str=GenericClass.getText(text_pageDrpdwn);
				String[] arr=str.split("of");
				String str1=arr[1];
	/*	Select select=new Select(drpdwn_Page);
	    select.selectByVisibleText(str1);
		String nexttext=GenericClass.getText(col_1_text);*/
		//int actual=Integer.parseInt(nexttext);
		Assert.assertEquals(str1.trim(), "1");
		
		Assert.assertEquals(txt_PreviousNext.isDisplayed(), true);
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
	
	
	
	
	public void fn_clkPreviousLnk(int iTestCaseRow) throws Exception
	{
		try
		{
			//GenericClass.selectElement(drpdwn_View, "1");
			GenericClass.selectElement(drpdwn_Page, "1");
			Select sel=new Select(drpdwn_Page);
			String txt=sel.getFirstSelectedOption().getText();
            Assert.assertEquals(txt.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
			boolean b=link_Previous.isDisplayed();
		Assert.assertEquals(b,false);
		}
		catch(AssertionError e)
		{
			throw e;
		}catch(NoSuchElementException e){
			boolean v=link_Previous.isDisplayed();
			Assert.assertFalse(v);
		}
	}
	
	
	public  void fn_verifyDisabledPreviousLnk(int iTestCaseRow) throws Exception
	{
		try
		{
			

			int count=GenericClass.tr_count(rowcount);
			if(count<=5==true)
			{
				Assert.assertTrue(count<=5);
				AddPhoneExtension APE=fn_navigateToAddPhoneExtnsn();
				APE.fn_validDataPhExtsn();			

			}
			
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
	
	
	public AuditTrailPELandingPage fn_clkAuditTrail() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_AuditTrail);
		
		AuditTrailPELandingPage ATLP=PageFactory.initElements(GenericClass.driver, AuditTrailPELandingPage.class);
		return ATLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public void sortStatus_DownwardArrowClk(int iTestCaseRow) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(rowcount);
		if(count<=5==true)
		{
			Assert.assertTrue(count<=5);
			AddPhoneExtension APE=fn_navigateToAddPhoneExtnsn();
			APE.fn_validDataPhExtsn();			

		}
		
		GenericClass.sortstatus_Downward(drpdwn_View, "100", img_Status, btn_PEStatusDownward, CheckBoxList, "//table[@class='list_viewnew']//tr//td[3]", "//table[@class='list_viewnew']//tr/td[8]/a/img");
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public void sortStatus_UpwardArrowClk(int iTestCaseRow) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(rowcount);
		if(count<=5==true)
		{
			Assert.assertTrue(count<=5);
			AddPhoneExtension APE=fn_navigateToAddPhoneExtnsn();
			APE.fn_validDataPhExtsn();			
		}		
		GenericClass.sortstatus_Upward(drpdwn_View, "100", btn_PEStatusUpward, CheckBoxList, "//table[@class='list_viewnew']//tr//td[3]", "//table[@class='list_viewnew']//tr/td[8]/a/img");
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	/**
	 * This method verifies added room in Phone Extension module.	
	 * @param s : As this parameter needs to be passed as room name /number.
	 * @throws Exception
	 */
	public ConfirmLoginPage VerifyAddedRoom(String s) throws Exception{
		ArrayList<String> rooms=new ArrayList<String>();
		try{
		List<WebElement> AllRoom=GenericClass.GetAllTheValueFromDropDown(RoomType_DD);
		for(int i=0;i<=AllRoom.size()-1;i++){
			String addedRoom=AllRoom.get(i).getText();
			rooms.add(addedRoom);
			if(addedRoom.equals(s)){
				Assert.assertEquals(true, addedRoom.equals(s));
				break;
			 }
		     }
		Thread.sleep(2000);
		Assert.assertEquals(rooms.contains(s),true);
		Reporter.log("ADDED ROOM VERIFIED IN PHONE EXTENSION MODULE",true);
		//GenericClass.clickElement(Link_FrontDesk);
		}catch(Exception e){
			e.printStackTrace();
		}
		return PageFactory.initElements(GenericClass.driver, ConfirmLoginPage.class);
	    }
		
	
	public ArrayList<String> fn_VerifyDepartmentnameInDropDown(){
		try{
			ArrayList<String> depcollec=new ArrayList<String>();
			Select sobj=new Select(Department_DD);
			List<WebElement> colle=sobj.getOptions();
			for(WebElement we : colle){
				depcollec.add(we.getText());
			}
			return depcollec;
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	public ConfirmLoginPage fn_ClickandNavigateOnFrontDesk() throws Exception{
		try{
			 GenericClass.clickElement(Link_FrontDesk);
			return PageFactory.initElements(GenericClass.driver, ConfirmLoginPage.class);
		}catch(Exception e){
			throw e;
		}
	}
	
	public void fn_CheckPhoneExtention() throws Exception{
		try{
			int count=TrCount.size();
			if(count<6==true){
				GenericClass.clickElement(btn_AddAExtension);
				AddPhoneExtension APE=PageFactory.initElements(GenericClass.driver, AddPhoneExtension.class);
				APE.fn_AddPhoneExtension();
			}
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	public ArrayList<String> VerifyDeletedRoom() throws Exception{
		try{
			ArrayList<String> coll= new ArrayList<String>();
			List<WebElement> AllRoom=GenericClass.GetAllTheValueFromDropDown(RoomType_DD);
			for(int i=0;i<=AllRoom.size()-1;i++){
			String addedRoom=AllRoom.get(i).getText();
				coll.add(addedRoom);
	             }
		        return coll;
				}catch(Exception e){
					throw e;
				}
                }
}
	

