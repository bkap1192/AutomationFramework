package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AuditTrailAddMultiplePE 
{

	@FindBy(xpath="//table[2]//tr")
	public  WebElement title_AuditTrail;

	@FindBy(xpath="//table[3]//tr[2]")
	public  WebElement title_PE;

	@FindBy(xpath="//table[2]//tr")
	public  List<WebElement> tr_count;
	
	
	public void verify_ChangedHistory(String value,String PENum) throws Exception
	{
        int count=GenericClass.tr_count(tr_count);
        for(int i=2;i<=count;i++)
        {
            String str=GenericClass.driver.findElement(By.xpath("//table[2]//tr["+i+"]/td/b")).getText();
            if(str.equals(value))
            {
            	String data=GenericClass.driver.findElement(By.xpath("//table[2]//tr["+i+"]/td")).getText();
                String[] parts=data.split(" ");
                String text=parts[7];
                if(text.contains(PENum))
                {
            	Assert.assertEquals(text.contains(PENum),true);
            	
                break;
                }
            }
            
        }

        
	}

}
