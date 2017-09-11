package com.hms.hotelogix.automationframework.pages.admin.General.InvoiceNumberSettings;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class EditPOSInvoiceNumber 
{
	
	@FindBy(xpath="//div[@id='popup_head']")
	public WebElement page_header;

	@FindBy(xpath="//input[@name='prefix']")
	public WebElement txtbox_Prefix;
	
	@FindBy(xpath="//input[@name='cusFolioNo']")
	public WebElement txtbox_StartSeriesNo;
	
	@FindBy(xpath="//input[@value='Save']")
	public WebElement btn_Save;
	
	@FindBy(xpath="//input[@value='Cancel']")
	public WebElement btn_Cancel;
	
	@FindBy(xpath="//table[@class='popup_inner']//i")
	public WebElement txt_prefixMsg;
	
	public String verify_pageHeader()
	{
		try
		{
		String text=GenericClass.getText(page_header);
		return text;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_verifyPageElements() throws Exception
	{
		try
		{
		GenericClass.checkElementDisplay("Prefix", txtbox_Prefix);
		GenericClass.checkElementDisplay("Starting Series No", txtbox_StartSeriesNo);
		GenericClass.checkElementDisplay("Save", btn_Save);
		GenericClass.checkElementDisplay("Cancel", btn_Cancel);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public String fn_getPrefixTxt()
	{
		try
		{
		String str=GenericClass.getText(txt_prefixMsg);
		return str;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public InvoiceNumberSettingsLP fn_editPOSPrefix(int iTestCaseRow) throws Exception
	{
		try
		{
		GenericClass.sendKeys(txtbox_Prefix, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix)));
		GenericClass.sendKeys(txtbox_StartSeriesNo, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber)));
		
		GenericClass.clickElement(btn_Save);
		
		InvoiceNumberSettingsLP INLP=PageFactory.initElements(GenericClass.driver, InvoiceNumberSettingsLP.class);
		
		return INLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_fillPOSDetails(int iTestCaseRow) throws Exception
	{
		try
		{
		GenericClass.sendKeys(txtbox_Prefix, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix)));
		GenericClass.sendKeys(txtbox_StartSeriesNo, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber)));
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public String fn_verifyAlert()
	{
		try
		{
		String str=GenericClass.Alert_Accept();
		return str;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public InvoiceNumberSettingsLP fn_clkCancelBtn() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_Cancel);
		}
		catch(Exception e)
		{
			throw e;
		}
		InvoiceNumberSettingsLP INLP=PageFactory.initElements(GenericClass.driver, InvoiceNumberSettingsLP.class);
		
		return INLP;

	}
	
	
	
	
	
	
	
	
	
	
	
}
