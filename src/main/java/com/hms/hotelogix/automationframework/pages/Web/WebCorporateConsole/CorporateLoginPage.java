package com.hms.hotelogix.automationframework.pages.Web.WebCorporateConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class CorporateLoginPage {

	@FindBy(xpath="//label/input[@id='txtCode']")
	public  WebElement txtbx_loginId;

	@FindBy(xpath="//label/input[@id='txtUsername']")
	public  WebElement txtbx_emailAddress;

	@FindBy(xpath="//td/input[@id='txtPass']")
	public  WebElement txtbx_password;

	@FindBy(xpath="//td/input[@name='rememberOnMac']")
	public  WebElement ckbx_rememberPwd;

	@FindBy(xpath="//td/input[@value='Login']")
	public  WebElement btn_login;

	public  CorporateConsolePage fn_CorporateLogin(int iTestCaseRow) throws Exception
	{try{
		GenericClass.sendKeys(txtbx_loginId, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CorporateLoginID)));
         //String str1=		ExcelUtil.getCellData(iTestCaseRow, Constant.Col_CorporateEmailAddress);
		GenericClass.sendKeys(txtbx_emailAddress,ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_CorporateEmailAddress)));
		GenericClass.sendKeys(txtbx_password,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CoporatePassword)));
		GenericClass.clickElement(btn_login);

		CorporateConsolePage pageobj = PageFactory.initElements(GenericClass.driver, CorporateConsolePage.class);
		return pageobj;
	}catch(Exception e){
		throw e;
	}
	}
}
