package com.hms.hotelogix.automationframework.pages.Web.WebCorporateConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent.TAConfirmReservationPage;

public class CorporateAddMoreRoomPage
{

	@FindBy(xpath="//input[@value='Confirm']")
    public static WebElement btn_Confirm;

	public CorporateConfirmReservationPage ClickOnConfirmBtn() throws Exception
	{
		GenericClass.clickElement(btn_Confirm);
		CorporateConfirmReservationPage CCRP=PageFactory.initElements(GenericClass.driver,CorporateConfirmReservationPage.class );
		return CCRP;

	}
}
