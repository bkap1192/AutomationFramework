package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class EditPhoneExtension 
{

	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	public  WebElement heading_Page;
	
	@FindBy(xpath="//input[@name='extensionNo']")
	public WebElement txtbox_Extension;
	
	@FindBy(xpath="//textarea[@name='title']")
	public WebElement txtbox_Title;
	
	@FindBy(xpath="//textarea[@name='description']")
	public WebElement txtbox_Comments;
	
	@FindBy(xpath="//input[@name='btnSave2']")
	public WebElement btn_topSave;
	
	public String PETitle;
	
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
	
	
	public PhoneExtensionsListPage fn_EditPENum(String PE) throws Exception
	{
		try
		{
			PETitle=GenericClass.generateRandomString();
			Thread.sleep(4000);
		GenericClass.sendKeys(txtbox_Extension,PE );
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
	
	
	
}
