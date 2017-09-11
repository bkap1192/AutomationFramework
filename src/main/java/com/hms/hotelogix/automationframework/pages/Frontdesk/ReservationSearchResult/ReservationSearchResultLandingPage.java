package com.hms.hotelogix.automationframework.pages.Frontdesk.ReservationSearchResult;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class ReservationSearchResultLandingPage {

	
	@FindBy(xpath="//table[@id='roomPoTableId']//td")
    public  WebElement RecordLink;



    public ViewDetailsPage fn_ClickOnSearchedRecord() throws Exception
    {try{
        GenericClass.clickElement(RecordLink);
        ViewDetailsPage VDP=PageFactory.initElements(GenericClass.driver, ViewDetailsPage.class);
        return VDP;
    }catch(Exception e){
    	throw e;
    }
    }
}
