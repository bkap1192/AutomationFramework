package com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class CashCounterPage {

	
	@FindBy(id="counter")
    public static WebElement Counter_DD;

    @FindBy(name="submit")
    public static WebElement Countinue_BT;

    public FrontdeskLandingPage fn_ClickContinueButton() throws Exception{

    	try
    	{
        GenericClass.selectElement(Counter_DD, "Default Counter (Open)");
        //GenericClass.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        GenericClass.clickElement(Countinue_BT);
        GenericClass.driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);

        FrontdeskLandingPage AHO = PageFactory.initElements(GenericClass.driver, FrontdeskLandingPage.class);
        return AHO;
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    }
}

