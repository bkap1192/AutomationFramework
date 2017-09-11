package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class ViewImage_ClassRT {
	@FindBy(xpath="//div[@align='center']/img")
	public  WebElement image;

	/**
		 * This method fetch image's 'src' value in a variable and then verifies it
		 * @throws AssertionError,Exception
		 */
		public void fn_verifyImage(String src)
		{
			try
			{
			String src2=image.getAttribute("src");
			Assert.assertTrue(src2.endsWith(src));
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
