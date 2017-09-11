package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.DisplayColors;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class DisplayColorsAuditTrail
{

	@FindBy(xpath="//table[3]//tr")
	public  List<WebElement> tr_count;

	/**
	 * This method verifies changed history of 'Audit Trail-Displaycolors' window
	 * @param
	 * @return
	 * @throws Exception,AssertionError
	 */

	public void verify_ChangedHistory()
	{
		try
		{
		int count=GenericClass.tr_count(tr_count);
        for(int i=2;i<=count;i++)
        {
        	String str=GenericClass.driver.findElement(By.xpath("//table[3]//tr["+i+"]/td")).getText();
        	System.out.println(str);
        	Assert.assertTrue(str.contains( DisplayColorsLandingPage.colorCode1+" changed from "+DisplayColorsLandingPage.colorCode));
            break;
        }
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
