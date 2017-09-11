package com.hms.hotelogix.automationframework.pages.emailaccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class EmailAccountLoginPage {

	@FindBy(xpath="//input[@name='login_username']")
	public  WebElement UserName;

	@FindBy(xpath="//input[@name='secretkey']")
	public  WebElement PasswdField;

	@FindBy(xpath="//input[@value='Login']")
	public  WebElement Login;
	
	@FindBy(xpath="//input[@id='Email']")
	public  WebElement UserMailId;

	@FindBy(xpath="//input[@id='Passwd']")
	public  WebElement Password;

	@FindBy(xpath="//input[@id='signIn']")
	public  WebElement SignInBtn;
	
	@FindBy(xpath="//input[@id='next']")
	public  WebElement NextButton;
	
	public void DoSquirrelMailLogin(int iTestCaseRow) throws Exception
	{
		try
		{
			GenericClass.sendKeys(UserName, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_InboxId)));
			GenericClass.sendKeys(PasswdField, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_InboxPassword)));
			GenericClass.clickElement(Login);
//		EmailHomePage EHP=PageFactory.initElements(GenericMethods.driver, EmailHomePage.class);
//		return EHP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void DoGmailLogin(int iTestCaseRow) throws Exception{

		try
		{
			GenericClass.sendKeys(UserMailId, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_InboxId)));
			GenericClass.clickElement(NextButton);
				Thread.sleep(8000);
				GenericClass.sendKeys(Password, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_InboxPassword)));
				System.out.println(SignInBtn.isEnabled());
				System.out.println(SignInBtn.isDisplayed());
				Actions a=new Actions(GenericClass.driver);
				//a.click(SignInBtn);
				GenericClass.js_Click(SignInBtn);
				Thread.sleep(2000);
				//GenericMethods.js_Click(GenericMethods.driver.findElement(By.xpath("//span[text()='Stay signed in']")));
				//Thread.sleep(2000);
				//GenericMethods.js_Click(GenericMethods.driver.findElement(By.xpath("//span[text()='Sign in']")));
				//Thread.sleep(2000);
//				EmailHomePage EHP=PageFactory.initElements(GenericMethods.driver, EmailHomePage.class);
//				return EHP;
		}
		catch(Exception e)
		{
			throw e;
			}
			}
	
	
	
	public EmailHomePage DoSpecificEmailLogin(int iTestCaseRow) throws Exception
	{
		try
		{
		String url=GenericClass.driver.getCurrentUrl();
		if(url.contains("http://mail.stayezee.com/squirrelmail/src/login.php"))
		{
			 //EmailAccountLoginPage EAP=new EmailAccountLoginPage();
			DoSquirrelMailLogin(iTestCaseRow);
		}
		else
		{
			DoGmailLogin(iTestCaseRow);
		}
		
		EmailHomePage EHP=PageFactory.initElements(GenericClass.driver, EmailHomePage.class);
		return EHP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
}
