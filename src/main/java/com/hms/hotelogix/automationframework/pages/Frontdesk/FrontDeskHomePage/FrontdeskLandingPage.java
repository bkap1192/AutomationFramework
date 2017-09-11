package com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.Frontdesk.Accounts.AccountsLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontdeskPOS.SampleRestaurant.SampleRestaurantLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.Housekeeping.HousekeepingLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.Payment.AccountStatementLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ReservationSearchResult.ReservationSearchResultLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage.EnableEditingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage.GroupReservationPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage.GroupViewDetailPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.Web.WebConsole.WebReservationHomePage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.DisplayColors.DisplayColorsLandingPage;

public class FrontdeskLandingPage {

	@FindBy(xpath="//input[@value='Cancel']")
    public  WebElement Cancel_BT;
	
	@FindBy(xpath="//a[text()='Current']")
    public  WebElement Current_Link;
	
	@FindBy(xpath="//div[@id='panelSingleResShow']//strong")
	 public WebElement reservId;
	
	@FindBy(xpath="//input[@value='Perform Auto Night Audit']")
    public  WebElement AutoNightAuditBtn;
	
	@FindBy(xpath="//input[@id='txtResFrndLookup']")
    public  WebElement Search_ED;
	
	@FindBy(xpath="//input[@id='txtResFrndLookupAllChk']")
    public static WebElement Search_CB;

    @FindBy(xpath="//button[@id='txtResFrndLookupAllBtn-button']")
    public static WebElement SearchAll_BT;
    
    @FindBy(xpath="//button[@id='btnSrShowClose-button']")
    public WebElement btn_closeView;
    
    @FindBy(xpath="//a[text()='Sample Restaurant']")
    public  WebElement SampleRestaurant;
    
    @FindBy(xpath="//td[@class='headingNB']//img")
    public  WebElement img_RoomLegends;

    @FindBy(xpath="//table[@class='table-cellspacing-patch']//tr//td")
    public  WebElement RR_colorCode;

    @FindBy(xpath="//table[@class='table-cellspacing-patch']//tr[2]//td")
    public  WebElement CIR_colorCode;

    @FindBy(xpath="//table[@class='table-cellspacing-patch']//tr[3]//td")
    public  WebElement COR_colorCode;

    @FindBy(xpath="//table[@class='table-cellspacing-patch']//tr[4]//td")
    public  WebElement Temp_colorCode;

    @FindBy(xpath="//table[@class='table-cellspacing-patch']//tr[7]//td")
    public  WebElement Overbooked_colorCode;

    @FindBy(xpath="//div[@id='pnl-nav-links']//table//tr[4]//div")
    public  WebElement img_HousekeepingLegends;

    @FindBy(xpath="//div[@id='pnl-nav-links']//table//tr[6]//tr[2]/td")
    public  WebElement TouchupR_colorCode;

    @FindBy(xpath="//div[@id='pnl-nav-links']//table//tr[6]//tr[1]/td")
    public  WebElement DirtyR_colorCode;

    @FindBy(xpath="//div[@id='pnl-nav-links']//table//tr[6]//tr[5]/td")
    public  WebElement InspectR_colorCode;

    @FindBy(xpath="//div[@id='pnl-nav-links']//table//tr[6]//tr[6]/td")
    public  WebElement CleanR_colorCode;

    @FindBy(xpath="//div[@id='pnl-nav-links']//table//tr[6]//tr[7]/td")
    public  WebElement RepairR_colorCode;
    
    @FindBy(xpath="//a[text()='Housekeeping']")
    public   WebElement Housekeeping_Link;
    
    @FindBy(xpath="//table[@class='table-cellspacing-patch']//tr[5]//td")
    public  WebElement DNR_colorCode1;

    @FindBy(xpath="//div[@id='pnl-nav-links']//table//tr[6]//tr[3]/td")
    public  WebElement DNR_colorCode2;
    
    @FindBy(xpath="//a[contains(@onclick,'Tab_GroupRes(2)')]")
    public  WebElement groupLnk;
    
    @FindBy(xpath="//a[text()='Web Reservation']")
    public  WebElement link_WebReservation;
    
    @FindBy(xpath="//select[@id='noofRooms1']")
    public  WebElement roomDD;
    
    @FindBy(xpath="//select[@id='salutation']")
    public WebElement drpdwn_salutation;
    
    @FindBy(xpath="//input[@id='qrTxtFirstName']")
    public WebElement txtbox_firstName;
    
    @FindBy(xpath="//input[@id='qrTxtLastName']")
    public WebElement txtbox_lastName;
    
    @FindBy(xpath="//input[@id='qrTxtPhone']")
    public WebElement txtbox_phone;
    
    @FindBy(xpath="//input[@id='qrEmail']")
    public WebElement txtbox_email;
    
    @FindBy(xpath="//button[@id='qrBtnReserve-button']")
    public WebElement btn_reserve;
    
    @FindBy(xpath="//span[@class='closebtn']")
    public WebElement btn_closeReserv; 
    
    @FindBy(xpath="//div[@id='contextmenu']//ul//li[2]/a")
    public  WebElement rightClk_checkIn;
    
    @FindBy(xpath="//span[@id='btnSrShowEditDetails']")
    public  WebElement btn_ViewDetails;
    
    @FindBy(xpath="//div[@class='room']")
    public  List<WebElement> AllRooms;
    
    @FindBy(xpath="//div[@class='bd']//li[6]/a")
    public  WebElement DNROption;

    @FindBy(xpath="//textarea[@id='txtDnrComment']")
    public  WebElement CommentsForDNR;
	
    @FindBy(xpath="//button[@id='btnDNRSave-button']")
    public  WebElement SubmitDNR;
    
    @FindBy(xpath="//a[text()='Accounts']")
    public WebElement Link_Account;
    
    @FindBy(xpath="//select[@id='qrSelAdult']")
	public WebElement DD_Adult;
	
	@FindBy(xpath="//select[@id='qrSelChildren']")
	public WebElement DD_Child;
	
	@FindBy(xpath="//select[@id='qrSelRateType']")
	public WebElement DD_RateType;
	
	@FindBy(xpath="//a[text()='View Details']")
    public WebElement Link_ViewDetails;
	
	@FindBy(xpath="//div[@id='PanelQuickRes']/div[3]/table/tbody/tr/td[3]/a[3]")
	public WebElement Link_GroupRes;
	
	@FindBy(xpath="//a[text()='Payments']")
    public WebElement Link_Payments;
	
	@FindBy(xpath="//button[@id='qrBtnReserve-button']")
	public WebElement Btn_Reserve;

    public String fname;
	public String lname;
	public String phno;
	public String email;
	public String title;
	public  String resvId;
	public String resTitle;
	
	public void fn_fillAddQuickResrvDetails(int iTestCaseRow) throws Exception
	 {
		 try
		 {
	 	Set<String> handles = GenericClass.driver.getWindowHandles();

	 	int count = handles.size();

	 	Thread.sleep(2000);
	     WebElement ele2=GenericClass.driver.findElement(By.xpath("//input[@id='qrTxtFirstName']"));
	     GenericClass.js_Sendkey(ele2, GenericClass.generateRandomString());
	     //ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_FirstName), Workbook);
	    // GenericClass.js_Sendkey(ele2, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_FirstName)));

	 	WebElement ele3 = GenericClass.driver.findElement(By.xpath("//select[@id='salutation']"));
//	 	System.out.println(value);
	 	Select select = new Select(ele3);
	 	select.selectByValue("Mr.");

	 	Thread.sleep(2000);

	 	WebElement ele4=GenericClass.driver.findElement(By.xpath("//input[@id='qrTxtLastName']"));
	 	//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_LastName), Workbook);
	 	GenericClass.js_Sendkey(ele4, GenericClass.generateRandomString());
	 	//	mouse.mouseUp(c);


	 	Thread.sleep(1500);

	 	WebElement ph=GenericClass.driver.findElement(By.xpath("//input[@id='qrTxtPhone']"));
	 	GenericClass.sendKeys(ph, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PhoneNumber)));

	 	Thread.sleep(2000);


	 	WebElement email=GenericClass.driver.findElement(By.xpath("//input[@id='qrEmail']"));
	 	//ExcelUtil.setCellData(GenericClass.generateRandomString()+"@gmail.com", iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Email), Workbook);
	 	GenericClass.sendKeys(email, GenericClass.generateRandomString()+"@gmail.com");

	 	Thread.sleep(2000);
	 	GenericClass.driver.findElement(By.xpath("//button[@id='qrBtnReserve-button']")).click();
//	 	String text=GenericMethods.getText(tooltip);
//	 	System.out.println(text);


		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 	//Thread.sleep(50000);
	 }

	
	
	public void fn_ClickCancelButton() throws Exception
    {
    	try
    	{
        GenericClass.clickElement(Cancel_BT);
        GenericClass.ActionOnAlert("Accept");
    	}
    	catch(WebDriverException e)
    	{
    		Thread.sleep(4000);
    		GenericClass.js_Click(Cancel_BT);
    		GenericClass.Alert_Accept();
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    }
	
	 public void fn_clickCurrentLnk() throws Exception
	    {
	    	try
	    	{
	    	GenericClass.clickElement(Current_Link);
	    	Thread.sleep(4000);
	    	}
	    	catch(Exception e)
	    	{
	    		throw e;
	    	}
	    }
	
	 
	 
	 public String fn_getReservId() throws Exception
	 {
		 try
		 {
	    WebElement ele1=GenericClass.driver.findElement(By.cssSelector("div.rs-new"));
	    Boolean b=ele1.isDisplayed();
	    System.out.println(b);
	    String ele=ele1.getAttribute("class");
	    if(b.equals(true))
	    {
	    	Assert.assertTrue(true);
	 	   System.out.println("Reservation has been successfully saved on tapechart");
	 	   Actions obj=new Actions(GenericClass.driver);
	 	   obj.click(ele1).build().perform();
	 	   String str=GenericClass.getText(reservId);
	 	   String[] arr=str.split(" ");
	 	  resvId=arr[3];
	 	   	     
	    }
	    

	  return resvId;
		 }
		 catch(AssertionError e)
		 {
			 throw e;
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 }

	 
	 public void fn_AutoNightAudit1() throws Exception
	 {
	 	try
	 	{
	 	GenericClass.js_Click(AutoNightAuditBtn);
	 	}
	 	catch(Exception e)
	 	{
	 		throw e;
	 	}
	 }
	 
	 
	 
	 public void fn_createFDReserv(String roomtype,String from,String to)
	 {
	 	 List<WebElement> ele=GenericClass.driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
	 	   int RTsize=ele.size();
	 	   for(int j=0;j<=RTsize-1;j++)
	 	   {
	 		   int k=j+1;
	 	       String str=ele.get(j).getText().trim();
	 	      
	 	       if(str.trim().equals(roomtype))
	 	           {
	 	              Assert.assertEquals(str, roomtype);
	 	              
	 	             WebElement ele2= GenericClass.driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+from+"]"));
	 	             WebElement ele3= GenericClass.driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+to+"]"));

	                Actions act=new Actions(GenericClass.driver);
	                  
	                  
	                  
	                  act.dragAndDrop(ele2, ele3).build().perform(); 
	                 
	 	              break;
	 	           }
	 	   }	     
	 }
	 
	 
	 
	 public ReservationSearchResultLandingPage  fn_SearchReservationID(String ReservationID) throws Exception{
	        
	    	try
	    	{
	    		Thread.sleep(4000);
	    	GenericClass.clickElement(Current_Link);
	        Thread.sleep(2000);
	        Actions acobj= new Actions(GenericClass.driver);
	        Thread.sleep(2000);
	       // Search_ED.clear();
	        acobj.sendKeys(Search_ED, ReservationID).build().perform();
	        //GenericClass.sendKeys(Search_ED, ReservationID);
	        GenericClass.clickElement(Search_CB);
	        GenericClass.clickElement(SearchAll_BT);
	        ReservationSearchResultLandingPage RSLP=PageFactory.initElements(GenericClass.driver, ReservationSearchResultLandingPage.class);
	           return RSLP;
	    	}
	    	catch(WebDriverException e)
	    	{
	    		Thread.sleep(4000);
	    		GenericClass.clickElement(Current_Link);
	    		Thread.sleep(2000);
	            Actions acobj= new Actions(GenericClass.driver);
	            Thread.sleep(2000);
	            Search_ED.clear();
	            acobj.sendKeys(Search_ED, ReservationID).build().perform();
	            //GenericClass.sendKeys(Search_ED, ReservationID);
	            GenericClass.clickElement(Search_CB);
	            GenericClass.clickElement(SearchAll_BT);
	            ReservationSearchResultLandingPage RSLP=PageFactory.initElements(GenericClass.driver, ReservationSearchResultLandingPage.class);
	               return RSLP;
	    	}
	    	catch(Exception e)
	    	{
	    		throw e;
	    	}
	    }

	 
	 public void fn_clkClose() throws Exception
	 {
		 try
		 {
		 GenericClass.clickElement(btn_closeView);
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 }
	 
	 
	 public SampleRestaurantLandingPage ClickToSampleRestaurant() throws Exception{


		 try{
	    	GenericClass.clickElement(SampleRestaurant);

	    	SampleRestaurantLandingPage SRL=PageFactory.initElements(GenericClass.driver,SampleRestaurantLandingPage.class );
	    	return SRL;
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	    }
	 
	 public void verify_RRColorCode() throws Exception
	 {
	 	try
	 	{
	    GenericClass.clickElement(img_RoomLegends);
	    Thread.sleep(1000);
	    String code=RR_colorCode.getAttribute("bgcolor");
	    String[] code1=code.split("#");
	    String part=code1[1];
	    Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(NoSuchElementException e)
	 	{
	 		GenericClass.js_Click(img_RoomLegends);
	 		Thread.sleep(1000);
	 		String code=CIR_colorCode.getAttribute("bgcolor");
	 		String[] code1=code.split("#");
	 		String part=code1[1];
	 		Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(AssertionError e)
	 	{
	 		throw e;
	 	}

	 }
	 
	 public  HousekeepingLandingPage ClickOnHouseleepingLink() throws Exception{
		 try{
		 GenericClass.clickElement(Housekeeping_Link);
		 HousekeepingLandingPage HLP=PageFactory.initElements(GenericClass.driver,HousekeepingLandingPage.class);
		 return HLP;
		 }catch(Exception e){
			 throw e;
		 }

		 }
	 
	 public void verify_CIColorCode() throws Exception
	 {
	 	try
	 	{
	    GenericClass.clickElement(img_RoomLegends);
	    Thread.sleep(1000);
	    String code=CIR_colorCode.getAttribute("bgcolor");
	    String[] code1=code.split("#");
	    String part=code1[1];
	    Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(NoSuchElementException e)
	 	{
	 		Thread.sleep(1000);
	 		GenericClass.js_Click(img_RoomLegends);
	 		String code=CIR_colorCode.getAttribute("bgcolor");
	 		String[] code1=code.split("#");
	 		String part=code1[1];
	 		Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));

	 	}
	 	catch(AssertionError e)
	 	{
	 		throw e;
	 	}
	 }
	 
	 
	 public void verify_COColorCode() throws Exception
	 {
	 	try
	 	{
	    GenericClass.clickElement(img_RoomLegends);
	    Thread.sleep(1000);
	    String code=COR_colorCode.getAttribute("bgcolor");
	    String[] code1=code.split("#");
	    String part=code1[1];
	    Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(NoSuchElementException e)
	 	{

	 		Thread.sleep(1000);
	 		GenericClass.js_Click(img_RoomLegends);
	 		String code=COR_colorCode.getAttribute("bgcolor");
	 		String[] code1=code.split("#");
	 		String part=code1[1];
	 		Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(AssertionError e)
	 	{
	 		throw e;
	 	}
	 }
	 
	 
	 public void verify_TempColorCode() throws Exception
	 {
	 	try
	 	{
	    GenericClass.clickElement(img_RoomLegends);
	    Thread.sleep(1000);
	    String code=Temp_colorCode.getAttribute("bgcolor");
	    String[] code1=code.split("#");
	    String part=code1[1];
	    Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(Exception e)
	 	{

	 		Thread.sleep(1000);
	 		GenericClass.js_Click(img_RoomLegends);
	 		String code=Temp_colorCode.getAttribute("bgcolor");
	 		String[] code1=code.split("#");
	 		String part=code1[1];
	 		Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(AssertionError e)
	 	{
	 		throw e;
	 	}
	 }
	 
	 
	 public void verify_OverbookedColorCode() throws Exception
	 {
	 	try
	 	{
	    GenericClass.clickElement(img_RoomLegends);
	    Thread.sleep(1000);
	    String code=Overbooked_colorCode.getAttribute("bgcolor");
	    String[] code1=code.split("#");
	    String part=code1[1];
	    Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(Exception e)
	 	{

	 		Thread.sleep(1000);
	 		GenericClass.js_Click(img_RoomLegends);
	 		String code=Overbooked_colorCode.getAttribute("bgcolor");
	 		String[] code1=code.split("#");
	 		String part=code1[1];
	 		Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}

	 catch(AssertionError e)
	 	{
		 throw e;
	 	}
	 }
	 
	 
	 public void verify_TouchupRColorCode() throws Exception
	 {
	 	try
	 	{
	    GenericClass.clickElement(img_HousekeepingLegends);
	    Thread.sleep(1000);
	    String code=TouchupR_colorCode.getAttribute("bgcolor");
	    String[] code1=code.split("#");
	    String part=code1[1];
	    Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(NoSuchElementException e)
	 	{
	 		GenericClass.js_Click(img_HousekeepingLegends
	 				);
	 		Thread.sleep(1000);
	 		String code=TouchupR_colorCode.getAttribute("bgcolor");
	 		String[] code1=code.split("#");
	 		String part=code1[1];
	 		Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(AssertionError e)
	 	{
	 		throw e;
	 	}

	 }
	 
	 
	 
	 public void verify_DirtyRColorCode() throws Exception
	 {
	 	try
	 	{
	    GenericClass.clickElement(img_HousekeepingLegends);
	    Thread.sleep(1000);
	    String code=DirtyR_colorCode.getAttribute("bgcolor");
	    String[] code1=code.split("#");
	    String part=code1[1];
	    Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(NoSuchElementException e)
	 	{
	 		GenericClass.js_Click(img_HousekeepingLegends
	 				);
	 		Thread.sleep(1000);
	 		String code=DirtyR_colorCode.getAttribute("bgcolor");
	 		String[] code1=code.split("#");
	 		String part=code1[1];
	 		Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(AssertionError e)
	 	{
	 		throw e;
	 	}
	 }

	 /**
	  * Method verifies color change for Inspect Rooms under Housekeeping Legends'
	  * @throws Exception,AssertionError
	  */

	 public void verify_InspectRColorCode() throws Exception
	 {
	 	try
	 	{
	    GenericClass.clickElement(img_HousekeepingLegends);
	    Thread.sleep(1000);
	    String code=InspectR_colorCode.getAttribute("bgcolor");
	    String[] code1=code.split("#");
	    String part=code1[1];
	    Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(NoSuchElementException e)
	 	{
	 		GenericClass.js_Click(img_HousekeepingLegends
	 				);
	 		Thread.sleep(1000);
	 		String code=InspectR_colorCode.getAttribute("bgcolor");
	 		String[] code1=code.split("#");
	 		String part=code1[1];
	 		Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(AssertionError e)
	 	{
	 		throw e;
	 	}
	 }


	 /**
	  * Method verifies color change for Clean Rooms under Housekeeping Legends'
	  * @throws Exception,AssertionError
	  */

	 public void verify_CleanRColorCode() throws Exception
	 {
	 	try
	 	{
	    GenericClass.clickElement(img_HousekeepingLegends);
	    Thread.sleep(1000);
	    String code=CleanR_colorCode.getAttribute("bgcolor");
	    String[] code1=code.split("#");
	    String part=code1[1];
	    Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(NoSuchElementException e)
	 	{
	 		GenericClass.js_Click(img_HousekeepingLegends
	 				);
	 		Thread.sleep(1000);
	 		String code=CleanR_colorCode.getAttribute("bgcolor");
	 		String[] code1=code.split("#");
	 		String part=code1[1];
	 		Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(AssertionError e)
	 	{
	 		throw e;
	 	}
	 }


	 /**
	  * Method verifies color change for Repair Rooms under Housekeeping Legends'
	  * @throws Exception,AssertionError
	  */

	 public void verify_RepairRColorCode() throws Exception
	 {
	 	try
	 	{
	    GenericClass.clickElement(img_HousekeepingLegends);
	    Thread.sleep(1000);
	    String code=RepairR_colorCode.getAttribute("bgcolor");
	    String[] code1=code.split("#");
	    String part=code1[1];
	    Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(NoSuchElementException e)
	 	{
	 		GenericClass.js_Click(img_HousekeepingLegends
	 				);
	 		Thread.sleep(1000);
	 		String code=RepairR_colorCode.getAttribute("bgcolor");
	 		String[] code1=code.split("#");
	 		String part=code1[1];
	 		Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 	}
	 	catch(AssertionError e)
	 	{
	 		throw e;
	 	}
	 }
	 
	 public void verify_DNRColorCode1() throws Exception
	 {
	 	try
	 	{
	    GenericClass.clickElement(img_RoomLegends);
	    Thread.sleep(1000);
	    String code=DNR_colorCode1.getAttribute("bgcolor");
	    String[] code1=code.split("#");
	    String part=code1[1];
	    Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	    GenericClass.clickElement(img_RoomLegends);
	 	}
	 	catch(NoSuchElementException e)
	 	{
	 		GenericClass.js_Click(img_RoomLegends);
	 		Thread.sleep(1000);
	 		String code=DNR_colorCode1.getAttribute("bgcolor");
	 		String[] code1=code.split("#");
	 		String part=code1[1];
	 		Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 		GenericClass.clickElement(img_RoomLegends);
	 	}
	 	catch(AssertionError e)
	 	{
	 		throw e;
	 	}
	 }




	 /**
	  * Method verifies color change for Do Not Reserve under Housekeeping Legends'
	  * @throws Exception,AssertionError
	  */

	 public void verify_DNRColorCode2() throws Exception
	 {
	 	try
	 	{
	    GenericClass.clickElement(img_HousekeepingLegends);
	    Thread.sleep(1000);
	    String code=DNR_colorCode2.getAttribute("bgcolor");
	    String[] code1=code.split("#");
	    String part=code1[1];
	    Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	    GenericClass.clickElement(img_HousekeepingLegends);
	 	}
	 	catch(NoSuchElementException e)
	 	{
	 		GenericClass.js_Click(img_HousekeepingLegends
	 				);
	 		Thread.sleep(1000);
	 		String code=DNR_colorCode2.getAttribute("bgcolor");
	 		String[] code1=code.split("#");
	 		String part=code1[1];
	 		Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	 		GenericClass.clickElement(img_HousekeepingLegends);
	 	}
	 	catch(AssertionError e)
	 	{
	 		throw e;
	 	}
	 }
	 
	 
	 public EnableEditingPage fn_clkGroupLnk() throws Exception
	 {
		 try
		 {
		 GenericClass.clickElement(groupLnk);
	     Thread.sleep(7000);
		 }
		 catch(NoSuchElementException e)
		 {
			 GenericClass.js_Click(groupLnk);
		 }
	     EnableEditingPage EEP=PageFactory.initElements(GenericClass.driver, EnableEditingPage.class);
	     return EEP;

	 }
	 
	 public void fn_verifyReservation(int iTestCaseRow) throws Exception
	 {
		 try
		 {
	 	WebElement ele1=GenericClass.driver.findElement(By.cssSelector("div.rs-new"));
	 	String str=ele1.getAttribute("title");
	 	Assert.assertTrue(str.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AlphabetCodeFD))));
	 	   Boolean b=ele1.isDisplayed();
	 	   System.out.println(b);
	 	   String ele=ele1.getAttribute("class");
	 	   if(b.equals(true))
	 	   {
	 		   System.out.println("Reservation has been successfully saved on tapechart and changed alphabet code for the same is being displayed");
	 	   }

	 	   else
	 	   {
	 		   System.out.println("Reservation failed");
	 	   }
		 }
		 catch(AssertionError e)
		 {
			 throw e;
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 }
	 
	 
	 /**
	  * As this methods verifies newly made reservation.
	  * 
	  * @throws Exception : if any occurs.
	  * @author deepak
	  */
	 public void fn_verifyReservation() throws Exception{
	 try{
	     Thread.sleep(1000);
	     WebElement ele1=GenericClass.driver.findElement(By.cssSelector("div.rs-new"));
	     Boolean b=ele1.isDisplayed();
	     System.out.println(b);
	     String ele=ele1.getAttribute("class");
	     Thread.sleep(1000);
	     resvId=ele1.getAttribute("resrvid");
	     Thread.sleep(1000);
	     title=ele1.getAttribute("title");
	     Thread.sleep(1000);
	     System.out.println("title is " + title);
	 if(b.equals(true)){
	      System.out.println("Reservation has been successfully saved on tapechart");
	 }
	 else{
	     System.out.println("Reservation failed");
	  }
	  }
	 catch(Exception e){
	 	throw e;
	  }
	  }
	 
	 public  WebReservationHomePage fn_WebReservationLink() throws Exception
	 {try{
		 GenericClass.clickElement(link_WebReservation);
	     WebReservationHomePage WRP = PageFactory.initElements(GenericClass.driver, WebReservationHomePage.class);
	     return WRP;
	 }catch(Exception e){
		 throw e;
	 }
	 }
	 
	 
	 
	 public void fn_fillAddQuickResrv(String noOfRooms) throws Exception
	 {try{
	 	//Set<String> handles = GenericClass.driver.getWindowHandles();

		 Thread.sleep(3000);
	 	GenericClass.selectElement(roomDD, noOfRooms);
	 	//int count = handles.size();
	 	Select select = new Select(drpdwn_salutation);
	 	select.selectByValue("Mr.");
	 	Thread.sleep(2000);
	    GenericClass.js_Sendkey(txtbox_firstName, GenericClass.generateRandomString());
	 	GenericClass.js_Sendkey(txtbox_lastName, GenericClass.generateRandomString());
	 	Thread.sleep(1500);

	 	GenericClass.sendKeys(txtbox_phone, GenericClass.GenerateRandomNumber(3));
	 	Thread.sleep(2000);


	 	GenericClass.sendKeys(txtbox_email,GenericClass.generateRandomString()+"@gmail.com");
	 	Thread.sleep(2000);

	 	GenericClass.clickElement(btn_reserve);
	 }catch(Exception e){
		 throw e;
	 }

	 }
	 
	 
	 public void fn_clkClose1() throws Exception
	    {

	    	try
	    	{
	    	GenericClass.clickElement(btn_closeReserv);
	    	}
	    	catch(Exception e)
	    	{
	    		throw e;
	    	}
	    }
	 
	 
	 public void fn_verifyReservedAssigned() throws Exception
	 {try{
	 	WebElement ele1=GenericClass.driver.findElement(By.cssSelector("div.rs-new"));
	 	Actions action = new Actions(GenericClass.driver);
		action.contextClick(ele1).build().perform();
		GenericClass.clickElement(rightClk_checkIn);
		GenericClass.ActionOnAlert("Accept");
		Thread.sleep(4000);
	 }catch(Exception e){
		 throw e;
	 }
	 }
	 
	 /**
	  * 
	  * 
	  * @param ele : As it takes WebElement as an args.
	  * @throws Exception : if any occurs.
	  * @author deepak
	  */
	  public void fn_rightClickOnReservation(WebElement ele) throws Exception{
	     	try{
	     	Thread.sleep(1000);
	     	Actions action = new Actions(GenericClass.driver);
	     	action.contextClick(ele).build().perform();
	     	}
	     	catch(Exception e){
	     		
	     	throw e;
	     	}
	     		
	     	}
	  
	  /**
	   * 
	   * 
	   * @return : As it returns initialized {@link CheckinCard} page 
	   * @throws Exception : if any occurs.
	   */
	  public CheckinCard fn_clickCheckIn() throws Exception{
	  try{
	      	
	  GenericClass.clickElement(rightClk_checkIn);
	  Thread.sleep(2000);
	  GenericClass.ActionOnAlert("Accept");
	  Thread.sleep(2000);
	  }
	  catch(Exception e){
	   throw e;
	  }
	  CheckinCard CC=PageFactory.initElements(GenericClass.driver, CheckinCard.class);
	  return CC;
	  }    
	   
	 
	 public ViewDetailsPage fn_ReservWithTax() throws Exception
	 {
	    WebElement ele1=GenericClass.driver.findElement(By.cssSelector("div.rs-new"));
	    Boolean b=ele1.isDisplayed();
	    System.out.println(b);
	    String ele=ele1.getAttribute("class");
	    if(b.equals(true))
	    {
	 	   System.out.println("Reservation has been successfully saved on tapechart");
	 	   Actions obj=new Actions(GenericClass.driver);
	 	   obj.contextClick(ele1).build().perform();
	 	  GenericClass.clickElement(btn_ViewDetails);
	    }
	    else
	    {
	 	   System.out.println("Reservation failed");
	    }

	 Thread.sleep(6000);
	 ViewDetailsPage VDP=PageFactory.initElements(GenericClass.driver, ViewDetailsPage.class);
	 return VDP;
	 }
	 
	 
	 public CheckinCard fn_rghtClkChkIn() throws Exception
	 {try{
	 	WebElement ele1=GenericClass.driver.findElement(By.cssSelector("div.rs-new"));
	 	Actions action = new Actions(GenericClass.driver);
		action.contextClick(ele1).build().perform();

		GenericClass.js_Click(rightClk_checkIn);
		//Thread.sleep(3000);
		//GenericMethods.ActionOnAlert("Accept");
		//GenericClass.Alert_Accept();
		Thread.sleep(6000);
		CheckinCard CC=PageFactory.initElements(GenericClass.driver, CheckinCard.class);
		return CC;
	 }catch(Exception e){
		 throw e;
	 }
	 }
	 
	 
	 /**
	  * This method verifies added room in frontdesk.
	  * @param s : As this method takes an argument room name/number.
	  * @return : As it returns WebElement corresponding to added room.
	  * @throws Exception
	  */
	 public WebElement VerifyRoomInFrontdesk(String s ) throws Exception{
	 try{
		 WebElement ele=GenericClass.driver.findElement(By.xpath("//div[@title='"+s+"']"));
	 Assert.assertEquals(true, ele.isDisplayed());
	 Reporter.log("Frontdesk Room verified", true);
	 return ele;
	 }catch(Exception e){
		 throw e;
	 }
	 }
	 
	 
	 public void VerifyDeletedRoomInFrontdesk(String s){
			try{
			for(int i=0;i<=AllRooms.size()-1;i++){
		        String rname=AllRooms.get(i).getAttribute("title");
		        Assert.assertFalse(rname.equals(s));
			}
			}catch(Exception e){
				throw e;
			}
		    }
	 
	 /**
	  * This method ensures that room is deactivate.
	  * @param s : s Is room name which we need to pass as an arguments.
	  */
	 public void VerifyDeactivatedRoom(String s){
	 	try{
	 	for(int i=0;i<=AllRooms.size()-1;i++){
	         String rname=AllRooms.get(i).getAttribute("title");
	         Assert.assertFalse(rname.equals(s));
	       }
	 	}catch(Exception e){
	 		throw e;
	 	}
	 	Reporter.log(s+"Room is deactivated.", true);
	 }

	 
	 public void WindowScroll()
	    {
	    JavascriptExecutor jsx = (JavascriptExecutor)GenericClass.driver;
	    jsx.executeScript("scroll(250, 0)");
	    }


  
	  public WebElement fn_GetWebelementforDNR(String room) throws Exception{
	    	try{
	    		WebElement we=null;
	    		for(int i=1;i<=AllRooms.size()-1;i++){
	        		String rname=AllRooms.get(i).getAttribute("title");
	        		if(rname.equals(room)){
	        			Thread.sleep(2000);
	        			 we=AllRooms.get(i);
	        			break;
	        			}}
	    		return we;
	    	}catch(Exception e){
	    		throw e;
	    	}
	        }

	  
	  public void MarkDNRToRoom(WebElement ele) throws Exception{
			Actions a=new Actions(GenericClass.driver).contextClick(ele);
			a.build().perform();
			Thread.sleep(1000);
			String s=GenericClass.getText(DNROption);
			Thread.sleep(1000);
			a.click(DNROption).build().perform();
			Thread.sleep(1000);
			GenericClass.js_Sendkey(CommentsForDNR, "Do Not Reserve");
			Thread.sleep(1000);
			GenericClass.clickElement(SubmitDNR);
			Thread.sleep(1000);
		}
	  
	  /**
	   * This method ensures that room is activated in frontdesk.
	   * @param s : Here s is an room name for which we need to check active or not.
	   */
	 public void VerifyActivatedRoom(String s){
	 	for(int i=0;i<=AllRooms.size()-1;i++){
	         String rname=AllRooms.get(i).getAttribute("title");

	         if(rname.equals(s)){
	         	   Assert.assertTrue(rname.equals(s));
	         	   break;
	         }

	 }
	 	Reporter.log(s+"Room is Activated.", true);

	 	}

	 public AccountsLandingPage fn_clickOnAccountsLink() throws Exception{
		 try{
		 GenericClass.clickElement(Link_Account);	
		 }
		 catch(Exception e){
		 throw e;	
		 }
		 AccountsLandingPage ASL=PageFactory.initElements(GenericClass.driver, AccountsLandingPage.class);
		 return ASL;
		 }
	 
	 public void fn_createFDReserv(String from,String to)
	 {try{
		 WebElement we1=GenericClass.driver.findElement(By.xpath("//div[contains(@id,'crossblock')]["+from+"]"));
		   WebElement we2=GenericClass.driver.findElement(By.xpath("//div[contains(@id,'crossblock')]["+to+"]"));
	     Actions act=new Actions(GenericClass.driver);
	     act.dragAndDrop(we1, we2).build().perform(); 
	 }catch(Exception e){
		 throw e;
	 }
	 }
	 
	 public GroupReservationPage FillQuickResvsForm(int iTestCaseRow,WebElement eleToClick) throws Exception{
			try{
		fname=GenericClass.generateRandomString();
		lname=GenericClass.generateRandomString();
		phno=GenericClass.generateRandomString();
		email=GenericClass.generateRandomString();
		Thread.sleep(1000);

		String adultForRes=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AdultForRes));
		Thread.sleep(2000);
		GenericClass.selectElement(DD_Adult, adultForRes);
		Thread.sleep(2000);
		GenericClass.selectElement(DD_Child, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ChildForRes)));
		Thread.sleep(2000);
		GenericClass.selectElement(DD_RateType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ResRateType)));
		Thread.sleep(2000);
		GenericClass.selectElement(roomDD, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomsToBook)));
		Thread.sleep(2000);
		GenericClass.selectElement(drpdwn_salutation, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Salutation)));
		Thread.sleep(2000);
		GenericClass.sendKeys(txtbox_firstName, fname);
		Thread.sleep(2000);
		GenericClass.sendKeys(txtbox_lastName,lname);	
		Thread.sleep(2000);
		GenericClass.sendKeys(txtbox_phone,  phno);
		Thread.sleep(2000);
		GenericClass.sendKeys(txtbox_email, email);
		Thread.sleep(2000);
		GenericClass.clickElement(eleToClick);
		Thread.sleep(2000);
		}
		catch(Exception e){

		throw e;
		}
			
		GroupReservationPage SRP=PageFactory.initElements(GenericClass.driver, GroupReservationPage.class);
		return SRP;

		}

	 
	 /**
	     * 
	     * @param rid : As it takes reservation id as an args.
	     * @return : As it returns initialized Webelement.
	     * @throws Exception : if any occurs.
	     * @author deepak
	     */
	public WebElement  getWebElement(String rid) throws Exception{
	  WebElement ele=null;
	 try{
	   System.out.println("Reserve ID is _ " + rid);
	   Thread.sleep(1000);
	   ele=GenericClass.driver.findElement(By.xpath("//div[@resrvid='"+rid+"']"));
	   Thread.sleep(2000);
	   resTitle=ele.getAttribute("title");
	 }
	catch(Exception e){
	throw e;
	}
	 return ele;
	}
	 
	
	public GroupViewDetailPage fn_clickOnViewDetailPage() throws Exception{
		try{
		GenericClass.clickElement(Link_ViewDetails);
		}
		catch(Exception e){
			throw e;
		}
		GroupViewDetailPage GVDP=PageFactory.initElements(GenericClass.driver, GroupViewDetailPage.class);
		return GVDP;
		}
	 
	public AccountStatementLandingPage fn_clickOnPayment() throws Exception{
		try{
		GenericClass.clickElement(Link_Payments);
		}
		catch(Exception e){
		throw e;
		}
		AccountStatementLandingPage ASLP=PageFactory.initElements(GenericClass.driver, AccountStatementLandingPage.class);
		return ASLP;
		}
	
	public FrontdeskLandingPage FillQuickResForm(int iTestCaseRow) throws Exception{
		try{
		
	fname=	GenericClass.generateRandomString();
	lname=GenericClass.generateRandomString();
	phno=GenericClass.generateRandomString();
	email=GenericClass.generateRandomString();
	Thread.sleep(2000);
	GenericClass.selectElement(DD_Adult, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AdultForRes)));
	Thread.sleep(2000);
	GenericClass.selectElement(DD_Child, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ChildForRes)));
	Thread.sleep(2000);
	GenericClass.selectElement(DD_RateType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ResRateType)));
	Thread.sleep(2000);
	GenericClass.selectElement(roomDD, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomsToBook)));
	Thread.sleep(2000);
	GenericClass.selectElement(drpdwn_salutation, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Salutation)));
	Thread.sleep(2000);
	GenericClass.sendKeys(txtbox_firstName, fname);
	Thread.sleep(2000);
	GenericClass.sendKeys(txtbox_lastName,lname);	
	Thread.sleep(2000);
	GenericClass.sendKeys(txtbox_phone,  phno);
	Thread.sleep(2000);
	GenericClass.sendKeys(txtbox_email, email);
	Thread.sleep(2000);
	 GenericClass.clickElement(Btn_Reserve);
	 Thread.sleep(2000);
		}
		catch(Exception e){
			
			throw e;
		}

	FrontdeskLandingPage FP=PageFactory.initElements(GenericClass.driver, FrontdeskLandingPage.class);
	return FP;

	}
	
}
