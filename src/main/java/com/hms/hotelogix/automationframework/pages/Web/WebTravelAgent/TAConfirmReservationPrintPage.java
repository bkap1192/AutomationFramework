package com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class TAConfirmReservationPrintPage {

	@FindBy(xpath="//div[@id='printDiv']/table//table//tr//td[2]//strong")
	public  WebElement txt_ReservID;

	public  String reservID;

	public String fn_GetReservID()
	{try{
		String str=GenericClass.getText(txt_ReservID);
		String[] parts=str.split(" ");
		reservID=parts[4];
		return reservID;
	}catch(Exception e){
		throw e;
	}
	}
}
