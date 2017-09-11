package com.hms.hotelogix.automationframework.pages.Web.WebConsole;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.Web.WebCorporateConsole.CorporateLoginPage;
import com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole.WebGuestConsoleLoginPage;
import com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent.TALoginPage;

public class WebReservationHomePage
{

	@FindBy(xpath="//table[@id='web_res_id1']//td//a[2]")
	public  WebElement link_TravleAgent;

	@FindBy(xpath="//table[@id='web_res_id1']//td//a[1]")
	public  WebElement link_Corporate;

	@FindBy(xpath="//table[@id='web_res_id1']//td//a[3]")
	public  WebElement link_Guest;

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

	public  TALoginPage fn_NavigateToTAConsole() throws Exception
		{
		try{
		Thread.sleep(3000);
			GenericClass.clickElement(link_TravleAgent);
			TALoginPage pageobj=PageFactory.initElements(GenericClass.driver, TALoginPage.class);
			return pageobj;
		}catch(Exception e){
			throw e;
		}
		}


/**
 * @param Method clicks on COrporate link and
 * @param Navigates to Corporate Login Page
 * @return Object of CorporateLoginPage class
 * @throws Exception
 */
	public  CorporateLoginPage fn_NavigateToCorpConsole() throws Exception
	{
		GenericClass.clickElement(link_Corporate);
		CorporateLoginPage pageobj=PageFactory.initElements(GenericClass.driver, CorporateLoginPage.class);
		return pageobj;
	}


	/**
	 * @param Method fetch system's current date and check for room availability
	 * @return
	 * @throws Exception
	 */
	public WebSelectRoomPage fn_CheckAvability() throws Exception
	{
		try
		{
			Thread.sleep(4000);
    	//GenericMethods.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
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

        WebSelectRoomPage CRSP =  PageFactory.initElements(GenericClass.driver, WebSelectRoomPage.class);
        return CRSP;
		}
		catch(Exception e)
		{
			throw e;
		}


	}

	/**
	 * @param Method clicks on Guest link and
	 * @param Navigates to Guest Login Page
	 * @return Object of GuestLoginPage class
	 * @throws Exception
	 */
		public  WebGuestConsoleLoginPage fn_NavigateToGuestConsole() throws Exception
		{
			GenericClass.clickElement(link_Guest);
			WebGuestConsoleLoginPage pageobj=PageFactory.initElements(GenericClass.driver, WebGuestConsoleLoginPage.class);
			return pageobj;
		}
}
