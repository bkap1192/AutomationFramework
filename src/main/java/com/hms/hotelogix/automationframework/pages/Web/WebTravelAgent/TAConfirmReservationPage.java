package com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class TAConfirmReservationPage {

	@FindBy(xpath="//select[@id='salutationGcc']")
    public  WebElement drpdwn_Salutation;

    @FindBy(xpath="//input[@id='fNameGcc']")
    public  WebElement txtbx_FirstName;

    @FindBy(xpath="//input[@id='lNameGcc']")
    public  WebElement txtbx_LastName;

    @FindBy(xpath="//input[@id='telNoGcc']")
    public  WebElement txtbx_TelephoneNum;

    @FindBy(xpath="//input[@id='mobNoGcc']")
    public  WebElement txtbx_MobileNum;

    @FindBy(xpath="//input[@id='emailGcc']")
    public  WebElement txtbx_Email;

    @FindBy(xpath="//input[@id='comfemailGcc']")
    public  WebElement txtbx_ConfirmEmail;

    @FindBy(xpath="//input[@id='addressGcc']")
    public  WebElement txtbx_Address;

    @FindBy(xpath="//select[@name='countryIdGcc']")
    public  WebElement drpdwn_Country;

    @FindBy(xpath="//select[@id='stateIdGcc']")
    public  WebElement drpdwn_State;

    @FindBy(xpath="//input[@id='cityGcc']")
    public  WebElement txtbx_City;

    @FindBy(xpath="//input[@id='zipGcc']")
    public  WebElement txtbx_Zip;

    @FindBy(xpath="//textarea[@id='webNotes']")
    public  WebElement PreferenceTextArea;

    @FindBy(xpath="//input[@id='canPolicy']")
    public  WebElement chkbx_TermsCondition;

    @FindBy(xpath="//input[@id='radCc']")
    public  WebElement rbtn_CreditCard;

    @FindBy(xpath="//select[@name='cardType']")
    public  WebElement drpdwn_CardType;

    @FindBy(xpath="//input[@id='nameOnCard']")
    public  WebElement txtbx_NameOnCard;

    @FindBy(xpath="//input[@id='ccNo']")
    public  WebElement txtbx_CardNumber;

    @FindBy(xpath="//input[@id='cvc']")
    public  WebElement txtbx_CVC;

    @FindBy(xpath="//input[@id='expMonth']")
    public  WebElement txtbx_ExpMonth;

    @FindBy(xpath="//input[@id='expYear']")
    public  WebElement txtbx_ExpYear;

    @FindBy(xpath="//input[@id='confirmByCCBtn']")
    public  WebElement btn_ConfirmByCreditCard;

    @FindBy(xpath="//form[@id='frmWebRes']//table//tbody/tr/td/h3/strong")
    public  WebElement txt_BookingConfirmPage;
	
	public TAConfirmReservationPrintPage ConfirmBooking1(int iTestCaseRow,String Workbook) throws Exception
	{try{
		GenericClass.selectElement(drpdwn_Salutation, "Mr.");
		Thread.sleep(3000);

        //ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GuestFirstName),Workbook);
        GenericClass.sendKeys(txtbx_FirstName,GenericClass.generateRandomString());


		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GuestLastName),Workbook);
		GenericClass.sendKeys(txtbx_LastName, GenericClass.generateRandomString());

		Thread.sleep(3000);

		GenericClass.sendKeys(txtbx_TelephoneNum, "8506853589");
		GenericClass.sendKeys(txtbx_MobileNum, "1213456");

		String mailId=GenericClass.generateRandomString()+"@gmail.com";
		
		//GenericClass.sendKeys(txtbx_Email, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GuestMailId)));
		GenericClass.sendKeys(txtbx_Email, mailId);

		//GenericClass.sendKeys(txtbx_ConfirmEmail, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ConfirmGuestMailId)));
		GenericClass.sendKeys(txtbx_ConfirmEmail, mailId);
		
		GenericClass.selectElement(drpdwn_Country, "India");
		Thread.sleep(3000);
		GenericClass.selectElement(drpdwn_State, "Delhi");
		Thread.sleep(3000);
		GenericClass.sendKeys(txtbx_Address,"Delhi");
		GenericClass.sendKeys(txtbx_City, "Delhi");
		GenericClass.sendKeys(txtbx_Zip, "110096");
		//GenericClass.sendKeys(PreferenceTextArea, "Need Newspaper");
		GenericClass.clickElement(chkbx_TermsCondition);
		Thread.sleep(3000);
		GenericClass.clickElement(rbtn_CreditCard);
		Thread.sleep(3000);
		GenericClass.selectElement(drpdwn_CardType, "Visa");
		Thread.sleep(3000);
		GenericClass.sendKeys(txtbx_NameOnCard, "visa");
		GenericClass.sendKeys(txtbx_CardNumber, "4111111111111111");
		GenericClass.sendKeys(txtbx_CVC, "111");
		GenericClass.sendKeys(txtbx_ExpMonth, "12");
		GenericClass.sendKeys(txtbx_ExpYear, "2018");
		GenericClass.clickElement(btn_ConfirmByCreditCard);
		Thread.sleep(5000);
		TAConfirmReservationPrintPage TCRP=PageFactory.initElements(GenericClass.driver, TAConfirmReservationPrintPage.class);
		return TCRP;
	}catch(Exception e){
		throw e;
	}

	}
}
