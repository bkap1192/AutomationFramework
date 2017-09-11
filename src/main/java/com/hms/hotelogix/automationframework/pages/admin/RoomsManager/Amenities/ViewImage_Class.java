package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ViewImage_Class {

	@FindBy(xpath="//div[@align='center']/img")
	public  WebElement image;
	
	
	public void fn_verifyImage()
	{
		try
		{
		String src2=image.getAttribute("src");
		Assert.assertTrue(src2.contains(AddAmenity.src1));
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
}
