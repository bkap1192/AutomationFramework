package com.hms.hotelogix.automationframework.pages.Frontdesk.FrontdeskPOS.SampleRestaurant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class SampleRestaurantLandingPage {

	@FindBy(xpath="//div[@id='showTotAmountSymbolId']")
	public  WebElement TotalAmtWithCurSym;

	@FindBy(xpath="//div[@class='product-div']/div")
	public  WebElement FeaturedProductName_BT;

	@FindBy(xpath="//input[@value='Generate Order']")
	public  WebElement GenerateOrder_BT;

	public ConfirmOrderPage fn_GenerateOrder() throws Exception
	{
		try
		{
		Thread.sleep(8000);
	    GenericClass.clickElement(FeaturedProductName_BT);
	    Thread.sleep(4000);
	    GenericClass.js_Click(GenerateOrder_BT);
	    Thread.sleep(5000);
	    ConfirmOrderPage COP=PageFactory.initElements(GenericClass.driver, ConfirmOrderPage.class);
	    return COP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
