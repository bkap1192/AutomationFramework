package com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class WebGuestConsoleLandingPage
{

	@FindBy(xpath="//td[text()='Reservation Details ']")
	public  WebElement GuestReservationPageTitle;

@FindBy(xpath="//a[text()='Book Now']")
public  WebElement BookNowBtn;



public WebGuestStayDetailsPage ClickOnBookNow() throws Exception
{
	try
	{
	GenericClass.clickElement(BookNowBtn);
	 WebGuestStayDetailsPage WGS=PageFactory.initElements(GenericClass.driver,  WebGuestStayDetailsPage.class);
	return WGS;
	}
	catch(Exception e)
	{
		throw e;
	}
}

}
