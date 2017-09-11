package com.hms.hotelogix.automationframework.pages.Frontdesk.FrontdeskPOS.SampleRestaurant;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class ConfirmOrderPage {

	@FindBy(xpath="//input[@id='conOrderBtn']")
	public  WebElement ConfirmOrderBtn;

	public ConfirmOrderPage1 ConfirmOrder() throws Exception
	{

		try
		{
	GenericClass.clickElement(ConfirmOrderBtn);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(1000);
			GenericClass.js_Click(ConfirmOrderBtn);
		}
		catch(Exception e)
		{
			throw e;
		}
	ConfirmOrderPage1 COP1=PageFactory.initElements(GenericClass.driver,ConfirmOrderPage1.class);
	return COP1;

	}
}
