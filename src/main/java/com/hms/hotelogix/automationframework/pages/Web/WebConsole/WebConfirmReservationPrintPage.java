package com.hms.hotelogix.automationframework.pages.Web.WebConsole;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class WebConfirmReservationPrintPage {

	@FindBy(xpath="//div[@id='printDiv']/table//table//tr//td[2]//strong")
	public  WebElement txt_ReservID;
	
	
	public  String reservID;
	public static String rid;
	public static ArrayList<String> al1=new ArrayList<String> ();
	
	public String fn_GetReservID()
	{try{
		String str=GenericClass.getText(txt_ReservID);
		String[] parts=str.split(" ");
		reservID=parts[2];
		return reservID;
	}catch(Exception e){
		throw e;
	}
	}
	
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
