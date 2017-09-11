package com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class WebGuestConsoleLoginPage
{

	@FindBy(xpath="//input[@id='txtGuestId']")
	public  WebElement GuestIdTextField;

	@FindBy(xpath="//input[@id='txtUsername']")
	public  WebElement UserMailTextField;

	@FindBy(xpath="//input[@id='txtPass']")
	public  WebElement PasswordField;

	@FindBy(xpath="//input[@value='Login']")
	public  WebElement LoginBtn;

	public WebGuestConsoleLandingPage DoLogin(String id,String user,String pwd) throws Exception{

		try
		{
		System.out.println(GuestIdTextField.isEnabled());
		System.out.println(GuestIdTextField.isDisplayed());
	GenericClass.sendKeys(GuestIdTextField, id);
	GenericClass.sendKeys(UserMailTextField, user);
	GenericClass.sendKeys(PasswordField, pwd);
	GenericClass.clickElement(LoginBtn);
	WebGuestConsoleLandingPage WGC=PageFactory.initElements(GenericClass.driver,WebGuestConsoleLandingPage.class );
	return WGC;

	}
		catch(Exception e)
		{
			throw e;
			
		}
	}

}
