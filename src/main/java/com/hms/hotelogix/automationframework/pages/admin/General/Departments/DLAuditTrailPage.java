package com.hms.hotelogix.automationframework.pages.admin.General.Departments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class DLAuditTrailPage {

	
	@FindBy(xpath="//table[2]//td")
    public WebElement titleAuditTrail;

    @FindBy(xpath="//table[3]//tr[2]/td")
    public WebElement changes1;

    @FindBy(xpath="//table[3]//tr[3]/td")
    public WebElement changes2;
    
    @FindBy(xpath="//table[3]//tr[4]/td")
    public WebElement changes3;


    
    
    public void verify_history(String name){
    	try{
        String str2=GenericClass.getText(changes1);
        Assert.assertTrue(str2.contains(name));
        GenericClass.driver.close();
    	}catch(Exception e){
    		throw e;
    	}
        }
    
}
