package com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.Web.WebConsole.WebConfirmReservationPrintPage;

public class WebGuestConfirmReservationPage
{
	@FindBy(xpath="//span[text()='Confirm your Booking / Payments']")
public  WebElement ConfirmBookingPageTitle;

	@FindBy(xpath="//select[@id='salutation']")
    public  WebElement drpdwn_Salutation;

	@FindBy(xpath="//input[@id='fName']")
    public  WebElement txtbx_FirstName;

	 @FindBy(xpath="//input[@id='lName']")
	 public  WebElement txtbx_LastName;

	    @FindBy(xpath="//input[@id='telNo']")
	    public  WebElement txtbx_TelephoneNum;

	    @FindBy(xpath="//input[@id='mobNo']")
	    public  WebElement txtbx_MobileNum;

	    @FindBy(xpath="//input[@id='email']")
	    public  WebElement txtbx_Email;

	    @FindBy(xpath="//input[@id='comfemail']")
	    public  WebElement txtbx_ConfirmEmail;

	    @FindBy(xpath="//input[@id='address']")
	    public  WebElement txtbx_Address;

	    @FindBy(xpath="//select[@name='countryId']")
	    public  WebElement drpdwn_Country;

	    @FindBy(xpath="//select[@id='stateId']")
	    public  WebElement drpdwn_State;

	    @FindBy(xpath="//input[@id='city']")
	    public  WebElement txtbx_City;

	    @FindBy(xpath="//input[@id='zip']")
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
	    public static WebElement txtbx_ExpYear;

	    @FindBy(xpath="//input[@id='confirmByCCBtn']")
	    public static WebElement btn_ConfirmByCreditCard;

	    @FindBy(xpath="//form[@id='frmWebRes']//table//tbody/tr/td/h3/strong")
	    public static WebElement txt_BookingConfirmPage;


	    /**
	     * This method fill guest details regarding booking on GuestConfirReservationPage
	     * @param iTestCaseRow : : Is used for test data.
	     * @return : As it returns GuestConfirmReservationPrintPage and initialize all its element.
	     * @throws Exception
	     */
		public WebGuestConfirmReservationPrintPage ConfirmBooking1(int iTestCaseRow,String Workbook) throws Exception
		{

			try
			{

			GenericClass.selectElement(drpdwn_Salutation, "Mr.");
			Thread.sleep(3000);


	        ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GuestFirstName),Workbook);
			GenericClass.sendKeys(txtbx_FirstName, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GuestFirstName)));


			ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GuestLastName),Workbook);
			GenericClass.sendKeys(txtbx_LastName, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GuestLastName)));

			Thread.sleep(3000);

//			String str=ExcelUtil.setCellData(GenericMethods.getStayezeeUserName(GenericMethods.randomUniqueString()+"@stayezee.com"), iTestCaseRow, Constant.Col_EmailAddressUsername);

//			ExcelUtil.setCellData(str, iTestCaseRow, Constant.Col_ConfirmGuestMailId);


			GenericClass.sendKeys(txtbx_TelephoneNum, "8506853589");
			GenericClass.sendKeys(txtbx_MobileNum, "1213456");

			GenericClass.sendKeys(txtbx_Email, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_GuestMailId)));
			GenericClass.sendKeys(txtbx_ConfirmEmail, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ConfirmGuestMailId)));

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
			}
		catch(NoSuchElementException e)
		{
			throw e;
		}
			WebGuestConfirmReservationPrintPage GRPP=PageFactory.initElements(GenericClass.driver, WebGuestConfirmReservationPrintPage.class);
			return GRPP;
		}

		public String VerifyTitle() throws Exception
		{
			try
			{
		String title=GenericClass.getText(ConfirmBookingPageTitle);
		return title;
			}
			catch(Exception e)
			{
				throw e;
			}
		}

		
		public WebGuestConfirmReservationPrintPage ConfirmBooking(int iTestCaseRow) throws Exception{
			
			try
			{
				GenericClass.clickElement(chkbx_TermsCondition);
				GenericClass.clickElement(rbtn_CreditCard);
				GenericClass.selectElement(drpdwn_CardType, "Visa");
				GenericClass.sendKeys(txtbx_NameOnCard, "visa");
				GenericClass.sendKeys(txtbx_CardNumber, "4111111111111111");
				GenericClass.sendKeys(txtbx_CVC, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CVC)));
				GenericClass.sendKeys(txtbx_ExpMonth, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpiryMonth)));
				GenericClass.sendKeys(txtbx_ExpYear, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpiryYear)));
				GenericClass.clickElement(btn_ConfirmByCreditCard);
			Thread.sleep(2000);
			WebGuestConfirmReservationPrintPage WCRP=PageFactory.initElements(GenericClass.driver, WebGuestConfirmReservationPrintPage.class);
			return WCRP;
			}
			catch(Exception e)
			{
				throw e;
			}
			
		}

}
