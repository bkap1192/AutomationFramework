package com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class TASelectRoomPage {

	@FindBy(xpath="//form[@id='frmWebRes']//table//tr[2]/td/span")
    public  WebElement title_Section;

	@FindBy(xpath="//input[@value='Select']")
    public  WebElement btn_Select;


	public TAAddMoreRoomPage fn_SelectRoomandRate() throws Exception
	{try{
        GenericClass.clickElement(btn_Select);

        TAAddMoreRoomPage WARP=PageFactory.initElements(GenericClass.driver, TAAddMoreRoomPage.class);
        return WARP;
	}catch(Exception e){
		throw e;
	}
     }
}
