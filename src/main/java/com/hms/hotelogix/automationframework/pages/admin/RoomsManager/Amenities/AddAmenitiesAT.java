package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AddAmenitiesAT {

	@FindBy(xpath="//td[@class='page-heading']")
	public  WebElement header;

	@FindBy(xpath="//table[2]//tr[3]/td")
	public  WebElement titleRow;

	@FindBy(xpath="//table[2]//tr[2]/td")
	public  WebElement descRow;
	
	
	
	public String fn_verifyHeader() throws Exception
	{
		try
		{
		String str=GenericClass.getText(header);
		return str;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_verifyChangeHistory(String amntyName) throws Exception
	{
		try
		{
		String aTitle=GenericClass.getText(titleRow);
		Assert.assertTrue(aTitle.contains(amntyName));
		String aDesc=GenericClass.getText(descRow);
		Assert.assertTrue(aDesc.contains(amntyName));
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

