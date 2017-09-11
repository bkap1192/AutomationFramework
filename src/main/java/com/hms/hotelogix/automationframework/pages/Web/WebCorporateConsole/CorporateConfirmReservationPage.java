package com.hms.hotelogix.automationframework.pages.Web.WebCorporateConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.Web.WebTravelAgent.TAConfirmReservationPrintPage;

public class CorporateConfirmReservationPage
{
	@FindBy(xpath="//select[@id='salutationGcc']")
    public static WebElement drpdwn_Salutation;

    @FindBy(xpath="//input[@id='fNameGcc']")
    public static WebElement txtbx_FirstName;

    @FindBy(xpath="//input[@id='lNameGcc']")
    public static WebElement txtbx_LastName;

    @FindBy(xpath="//input[@id='telNoGcc']")
    public static WebElement txtbx_TelephoneNum;

    @FindBy(xpath="//input[@id='mobNoGcc']")
    public static WebElement txtbx_MobileNum;

    @FindBy(xpath="//input[@id='emailGcc']")
    public static WebElement txtbx_Email;

    @FindBy(xpath="//input[@id='comfemailGcc']")
    public static WebElement txtbx_ConfirmEmail;

    @FindBy(xpath="//input[@id='addressGcc']")
    public static WebElement txtbx_Address;

    @FindBy(xpath="//select[@name='countryIdGcc']")
    public static WebElement drpdwn_Country;

    @FindBy(xpath="//select[@id='stateIdGcc']")
    public static WebElement drpdwn_State;

    @FindBy(xpath="//input[@id='cityGcc']")
    public static WebElement txtbx_City;

    @FindBy(xpath="//input[@id='zipGcc']")
    public static WebElement txtbx_Zip;

    @FindBy(xpath="//textarea[@id='webNotes']")
    public static WebElement PreferenceTextArea;

    @FindBy(xpath="//input[@id='canPolicy']")
    public static WebElement chkbx_TermsCondition;

    @FindBy(xpath="//input[@id='radCc']")
    public static WebElement rbtn_CreditCard;


    @FindBy(xpath="//select[@name='cardType']")
    public static WebElement drpdwn_CardType;

    @FindBy(xpath="//input[@id='nameOnCard']")
    public static WebElement txtbx_NameOnCard;

    @FindBy(xpath="//input[@id='ccNo']")
    public static WebElement txtbx_CardNumber;

    @FindBy(xpath="//input[@id='cvc']")
    public static WebElement txtbx_CVC;

    @FindBy(xpath="//input[@id='expMonth']")
    public static WebElement txtbx_ExpMonth;

    @FindBy(xpath="//input[@id='expYear']")
    public static WebElement txtbx_ExpYear;

    @FindBy(xpath="//input[@id='confirmByCCBtn']")
    public static WebElement btn_ConfirmByCreditCard;

    @FindBy(xpath="//form[@id='frmWebRes']//table//tbody/tr/td/h3/strong")
    public static WebElement txt_BookingConfirmPage;


	public CorporateConfirmReservationPrintPage ConfirmBooking1(int iTestCaseRow,String Workbook) throws Exception
	{

		GenericClass.selectElement(drpdwn_Salutation, "Mr.");
		Thread.sleep(3000);

        //ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GuestFirstName),Workbook);
		GenericClass.sendKeys(txtbx_FirstName, GenericClass.generateRandomString());


		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GuestLastName),Workbook);
		GenericClass.sendKeys(txtbx_LastName, GenericClass.generateRandomString());


		Thread.sleep(3000);

		
//		String str=ExcelUtil.setCellData(GenericMethods.getStayezeeUserName(GenericMethods.randomUniqueString()+"@stayezee.com"), iTestCaseRow, Constant.Col_EmailAddressUsername);
//
//		ExcelUtil.setCellData(str, iTestCaseRow, Constant.Col_ConfirmGuestMailId);
//

	    Thread.sleep(3000);

		GenericClass.sendKeys(txtbx_TelephoneNum, "8506853589");
		GenericClass.sendKeys(txtbx_MobileNum, "1213456");

		
		String mailId=GenericClass.generateRandomString()+"@gmail.com";
		GenericClass.sendKeys(txtbx_Email, mailId);
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
		CorporateConfirmReservationPrintPage CRPP=PageFactory.initElements(GenericClass.driver, CorporateConfirmReservationPrintPage.class);
		return CRPP;


	}


}
