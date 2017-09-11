package com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;


public class FrontdeskContinueTrialPage {

	
	public static String text="Another user with the same username is already logged in to the system. Would you like to continue?";


    @FindBy(xpath="//a[text()='Continue with Trial']")
    public static WebElement CountinueWithTrail_BT;

    @FindBy(xpath="//strong[contains(text(),'Another user with the same username')]")
    public static WebElement text_TX;

    @FindBy(xpath="//td[@class='contentarea05']//a")
    public static WebElement Yes_BT;	
	
	
	
	
    
public CashCounterPage fn_ClickCountinueWithTrail_BT() throws Exception{
try{
String str=GenericClass.getText(text_TX);
  if(str.contains(text)){
      Assert.assertEquals(str.contains(text), true);
      GenericClass.clickElement(Yes_BT);
     }
        GenericClass.clickElement(CountinueWithTrail_BT);
        GenericClass.driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
       
        }
    	
        catch(Exception e)
    	{
        	throw e;
    	}
    	 CashCounterPage AHO = PageFactory.initElements(GenericClass.driver, CashCounterPage.class);
         return AHO;
}
    
    
    
    
    
    
    
    
    
    
    
}
