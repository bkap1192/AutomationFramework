package com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class TAAddMoreRoomPage {

	@FindBy(xpath="//input[@value='Confirm']")
    public  WebElement btn_Confirm;

	public TAConfirmReservationPage ClickOnConfirmBtn() throws Exception
	{try{
		GenericClass.clickElement(btn_Confirm);
		TAConfirmReservationPage WCR=PageFactory.initElements(GenericClass.driver,TAConfirmReservationPage.class );
		return WCR;
	}catch(Exception e){
		throw e;
	}
	}
}
