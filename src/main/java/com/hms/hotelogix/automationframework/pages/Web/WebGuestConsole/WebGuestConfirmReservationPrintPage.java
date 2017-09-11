package com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class WebGuestConfirmReservationPrintPage
{

	@FindBy(xpath="//div[@id='printDiv']/table//table//tr//td[2]//strong")
	public static WebElement txt_ReservID;

	
	@FindBy(xpath="//strong[contains(text(),'Reservation Id#')]")
	public static WebElement ReservationId;
	
	
public String GetReservationId() throws Exception
{
	try
	{
String text=GenericClass.getText(ReservationId);
String rid=text.split(" ")[2];
//String rid=text.substring(text.length()-8, text.length());
return rid;
	}
	catch(Exception e)
	{
		throw e;
	}
}
	
	
	
	public static String reservID;

	public String fn_GetReservIDG()
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
