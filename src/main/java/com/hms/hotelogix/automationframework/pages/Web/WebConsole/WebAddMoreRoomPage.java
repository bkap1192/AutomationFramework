package com.hms.hotelogix.automationframework.pages.Web.WebConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent.TAConfirmReservationPage;

public class WebAddMoreRoomPage
{

	@FindBy(xpath="//input[@value='Confirm']")
    public static WebElement btn_Confirm;

	@FindBy(xpath="//select[@name='noOfRoomSelBox[0]']")
    public static WebElement drpdwn_NoOfRooms;


	public WebConfirmReservationPage ClickOnConfirmBtn() throws Exception
	{
		GenericClass.clickElement(btn_Confirm);
		WebConfirmReservationPage WCR=PageFactory.initElements(GenericClass.driver,WebConfirmReservationPage.class );
		return WCR;

	}

	public WebConfirmReservationPage fn_selectNoOfRooms()
	{
		Select sel=new Select(drpdwn_NoOfRooms);
		sel.selectByValue("2");
		WebConfirmReservationPage WCR=PageFactory.initElements(GenericClass.driver,WebConfirmReservationPage.class );
		return WCR;
	}
}
