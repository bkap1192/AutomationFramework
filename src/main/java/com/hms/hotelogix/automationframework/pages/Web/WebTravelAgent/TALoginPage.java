package com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class TALoginPage {

	@FindBy(xpath="//tbody//tr[2]//td[text()='Travel Agent Login ']")
	public  WebElement title;

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


	/**
	 * Method enters loginId,Email Address,Password and clicks on Login button
	 * @param iTestCaseRow : Is used for test data.
	 * @return
	 * @throws Exception
	 */
	public  TAConsolePage fn_TALogin(int iTestCaseRow) throws Exception
	{try{
		GenericClass.sendKeys(txtbx_loginId, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TALoginID)));
         //String str1=		ExcelUtil.getCellData(iTestCaseRow, Constant.Col_TAEmailAddress);
		GenericClass.sendKeys(txtbx_emailAddress,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TAEmailAddress)));
		GenericClass.sendKeys(txtbx_password,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TAPassword)));
		GenericClass.clickElement(btn_login);

		TAConsolePage pageobj = PageFactory.initElements(GenericClass.driver, TAConsolePage.class);
		return pageobj;
	}catch(Exception e){
		throw e;
	}
	}
}
