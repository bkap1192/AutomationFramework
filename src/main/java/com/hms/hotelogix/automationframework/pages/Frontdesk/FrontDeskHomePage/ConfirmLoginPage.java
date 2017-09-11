package com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class ConfirmLoginPage {

	
	@FindBy(xpath="//a[text()='Continue with Trial']")
    public static WebElement CountinueWithTrail_BT;

    @FindBy(xpath="//td[@class='contentarea05']")
    public static WebElement text_TX;

    @FindBy(xpath="//td[@class='contentarea05']//a")
    public static WebElement Yes_BT;


    public static String text="Another user with the same username is already logged in to the system. Would you like to continue?";



    public CashCounterPage fn_ClickCountinueWithTrail_BT() throws Exception
    {
    	try
    	{
        String str=GenericClass.getText(text_TX);
        if(str.contains(text)){
            GenericClass.clickElement(Yes_BT);
        }else{
            System.out.println("Confirmation page not found");
        }
        GenericClass.clickElement(CountinueWithTrail_BT);
        GenericClass.driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
        CashCounterPage AHO = PageFactory.initElements(GenericClass.driver, CashCounterPage.class);
        return AHO;
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
        }
	
}
