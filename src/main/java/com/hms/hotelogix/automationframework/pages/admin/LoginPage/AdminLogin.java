package com.hms.hotelogix.automationframework.pages.admin.LoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class AdminLogin {

	@FindBy(xpath="//input[@id='hotelCodeId']")
	public static WebElement Hotel_Code;

	@FindBy(xpath="//input[@id='userNameId']")
	public static WebElement Username;

	@FindBy(xpath="//input[@id='passwordId']")
	public static WebElement Password;

	@FindBy(xpath="//input[@name='Submit52']")
	public static WebElement Login;

	@FindBy(xpath="//onput[@id='txtCaptcha']")
	public WebElement txtbox_captcha;
	

	public AdminHome adminlogin(String hotelID,String username, String password) throws Exception
	{
    	//ExcelUtil.getCellData(iTestCaseRow, Constant.Col_HotelCode);
		GenericClass.sendKeys(Hotel_Code, hotelID);


        //ExcelUtil.getCellData(iTestCaseRow, Constant.Col_EmailAddressUsername);
		GenericClass.sendKeys(Username, username);

        //ExcelUtil.getCellData(iTestCaseRow, Constant.Col_Password);
		GenericClass.sendKeys(Password, password);
		

		GenericClass.clickElement(Login);
        GenericClass.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MINUTES);
		AdminHome AH = PageFactory.initElements(GenericClass.driver, AdminHome.class);
		return AH;

	}

}
