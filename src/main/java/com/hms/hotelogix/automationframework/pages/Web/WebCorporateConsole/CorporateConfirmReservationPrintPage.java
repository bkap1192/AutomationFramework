package com.hms.hotelogix.automationframework.pages.Web.WebCorporateConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class CorporateConfirmReservationPrintPage
{

	@FindBy(xpath="//div[@id='printDiv']/table//table//tr//td[2]//strong")
	public static WebElement txt_ReservID;

	public static String reservID;

	public String fn_GetReservID()
	{
		String str=GenericClass.getText(txt_ReservID);
		String[] parts=str.split(" ");
		reservID=parts[4];
		return reservID;
	}
}
