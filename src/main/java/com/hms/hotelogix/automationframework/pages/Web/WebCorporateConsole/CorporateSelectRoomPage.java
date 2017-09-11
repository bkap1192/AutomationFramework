package com.hms.hotelogix.automationframework.pages.Web.WebCorporateConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class CorporateSelectRoomPage {

	@FindBy(xpath="//form[@id='frmWebRes']//table//tr[2]/td/span")
    public  WebElement title_Section;

	@FindBy(xpath="//input[@value='Select']")
    public  WebElement btn_Select;


	public CorporateAddMoreRoomPage fn_SelectRoomandRate() throws Exception
	{
        GenericClass.clickElement(btn_Select);

        CorporateAddMoreRoomPage CARP=PageFactory.initElements(GenericClass.driver, CorporateAddMoreRoomPage.class);
        return CARP;

     }
}
