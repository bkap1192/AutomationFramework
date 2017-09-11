package com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;



public class WebGuestStayDetailsPage {
	
	
	
	@FindBy(xpath="//img[@id='calIn']")
    public  WebElement CheckINCalender_IMG;
    
    @FindBy(xpath="//input[@id='non']")
    public  WebElement NightEditBox_ED;
    
    @FindBy(xpath="//table[@id='webresCalPopup_t']//tbody//tr//td//a")
    public  WebElement CheckInCalenderDate_Link;
    
    @FindBy(xpath="//img[@id='calOut']")
    public  WebElement CheckOutCalender_IMG;
    
    @FindBy(name="noOfAdult")
    public  WebElement Adult_DD;
    
    @FindBy(name="Submit")
    public  WebElement CheckAvalibility_BT;
    
    @FindBy(xpath="//td[text()='Stay Details']")
    public  WebElement StayDetailTitle;
   


@FindBy(xpath="//table[@id='webresCalPopup_t']//tbody//tr//td//a")
    public static List<WebElement> DateCollection;




public WebGuestSelectRoomPage fn_CheckAvability() throws Exception
{
	try
	{
		GenericClass.clickElement(CheckINCalender_IMG);
        GenericClass.clickElement(CheckInCalenderDate_Link);
        GenericClass.sendKeys(NightEditBox_ED, "1");
        Calendar cal = Calendar.getInstance();
        System.out.println("current date: " + cal.getTime());
        cal.add(Calendar.DATE, 1);
        Date dob=cal.getTime();
        String st=dob.toString();
        String[] parts=st.split(" ");
        String parts2=parts[2];
        System.out.println(parts2);
        GenericClass.clickElement(CheckOutCalender_IMG);
        for(WebElement date: DateCollection ){
            String strobj=date.getText();
            if(parts2.contains(strobj)){
            date.click();
            break;
        }
        }
        GenericClass.selectElement(Adult_DD, "1");
        GenericClass.clickElement(CheckAvalibility_BT);
        
        WebGuestSelectRoomPage WSR=PageFactory.initElements(GenericClass.driver, WebGuestSelectRoomPage.class);
        return WSR;
	}
	catch(Exception e)
	{
		throw e;
	}
	
	}


public String ValidateTitle() throws Exception
{
	try
	{
      String act=GenericClass.getText(StayDetailTitle).trim();
      return act;
    }
	catch(Exception e)
	{
		throw e;
	}
}
}

	


