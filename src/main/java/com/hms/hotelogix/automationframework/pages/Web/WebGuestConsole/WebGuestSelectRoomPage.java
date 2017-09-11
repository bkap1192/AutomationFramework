package com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class WebGuestSelectRoomPage
{

	@FindBy(xpath="//input[@value='Select']")
	public  WebElement RoomToSelect;


	/**
	 * This method for selecting rooms,Package
	 * @return As it returns WebAddMoreRoomPage for further operations.
	 * @throws Exception
	 */
     public WebGuestAddMoreRoomPage SelectRoom() throws Exception
     {try{
     GenericClass.clickElement(RoomToSelect);
     WebGuestAddMoreRoomPage WMR=PageFactory.initElements(GenericClass.driver,WebGuestAddMoreRoomPage.class);
     return WMR;
     }catch(Exception e){
    	 throw e;
     }
}

}
