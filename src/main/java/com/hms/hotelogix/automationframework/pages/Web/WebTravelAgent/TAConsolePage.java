package com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class TAConsolePage {

	@FindBy(xpath="//img[@id='calIn']")
    public  WebElement img_CheckINCalender;

	@FindBy(xpath="//input[@id='non']")
    public  WebElement txtbx_Night;

    @FindBy(xpath="//table[@id='webresCalPopup_t']//tbody//tr//td//a")
    public  WebElement link_CheckInCalenderDate;

    @FindBy(xpath="//img[@id='calOut']")
    public  WebElement img_CheckOutCalender;

    @FindBy(xpath="//table[@id='webresCalPopup_t']//tbody//tr//td//a")
    public  List<WebElement> DateCollection;

    @FindBy(name="noOfAdult")
    public  WebElement drpdwn_Adult;

    @FindBy(name="Submit")
    public  WebElement btn_CheckAvalibility;

	public TASelectRoomPage fn_CheckAvability() throws Exception
	{try{
    	//GenericMethods.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		Thread.sleep(6000);
        GenericClass.clickElement(img_CheckINCalender);
        GenericClass.clickElement(link_CheckInCalenderDate);
        GenericClass.js_Sendkey(txtbx_Night, "1");
        Calendar cal = Calendar.getInstance();
        System.out.println("current date: " + cal.getTime());
        cal.add(Calendar.DATE, 1);
        Date dob=cal.getTime();
        String st=dob.toString();
        String[] parts=st.split(" ");
        String parts2=parts[2];
        System.out.println(parts2);
        Thread.sleep(2000);
        GenericClass.js_Click(img_CheckOutCalender);
        for(WebElement date: DateCollection )
        {
            String strobj=date.getText();
            if(parts2.contains(strobj)){
            date.click();
            break;
        }
        }
        GenericClass.selectElement(drpdwn_Adult, "1");
        GenericClass.clickElement(btn_CheckAvalibility);

        TASelectRoomPage WSP =  PageFactory.initElements(GenericClass.driver, TASelectRoomPage.class);
        return WSP;
	}catch(Exception e){
		throw e;
	}

	}
}
