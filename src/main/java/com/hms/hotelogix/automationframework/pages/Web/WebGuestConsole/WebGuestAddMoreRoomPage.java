package com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class WebGuestAddMoreRoomPage
{

	@FindBy(xpath="//select[@name='noOfRoomSelBox[0]']")
    public  WebElement drpdwn_NoOfRooms;

	@FindBy(xpath="//input[@value='Confirm']")
    public  WebElement btn_Confirm;

	public void fn_selectNoOfRooms()
	{try{
		Select sel=new Select(drpdwn_NoOfRooms);
		sel.selectByValue("2");
	}catch(Exception e){
		throw e;
	}
	}

	public WebGuestConfirmReservationPage ClickOnConfirmBtn() throws Exception
	{try{
		GenericClass.clickElement(btn_Confirm);
		WebGuestConfirmReservationPage GRP=PageFactory.initElements(GenericClass.driver,WebGuestConfirmReservationPage.class );
		return GRP;
	}catch(Exception e){
		throw e;
	}
	}
}
