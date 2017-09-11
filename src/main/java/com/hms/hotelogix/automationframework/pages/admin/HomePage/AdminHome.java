package com.hms.hotelogix.automationframework.pages.admin.HomePage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.ConfirmLoginPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.General.DefaultSettings.DefaultSettingsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.General.Departments.DepartmentsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.General.InvoiceNumberSettings.InvoiceNumberSettingsLP;
import com.hms.hotelogix.automationframework.pages.admin.General.ListofCurrencies.ListofCurrenciesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.General.PayModes.PayModesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.PosManager.POSPoints.POSPointsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.CorporatePackages.ListOfPackagesCorporate;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.FrontdeskPackage.FrontDeskPackagesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.GroupTax.GroupTaxLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.PackageMaster.PackageMasterListPage;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.RoomPrices.RoomPriceListLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.TravelAgentPackages.ListOfPackagesTravelAgent;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.WebPackages.ListOfPackagesWeb;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities.AmenitiesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Blocks.BlocksLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.DisplayColors.DisplayColorsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors.FloorsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions.PhoneExtensionsListPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTaxes.RoomTaxesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.RoomTypesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.RoomsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.SortRooms.SortRoomsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.UserManager.Users.UsersLandingPage;

public class AdminHome {

	@FindBy(xpath="//span[@class='hotels']")
	public WebElement txt_hotelName;
	
	@FindBy(xpath="//a[text()='General']")
    public  WebElement General;
	
    @FindBy(xpath="//a[text()='Invoice Number Settings']")
    public  WebElement InvoiceNumberSettings;
	
    @FindBy(xpath="//a[text()='| Frontdesk']")
    public  WebElement Link_Frontdesk;
	
    @FindBy(xpath="//a[text()='Rooms Manager']")
	public  WebElement RoomsManager;
    
    @FindBy(xpath="//div[@id='nav-bg']//ul/li[5]/a")
	public  WebElement Rooms;
    
    @FindBy(xpath="//a[text()='Amenities']")
	public  WebElement Amenities;
    
    @FindBy(xpath="//a[text()='Room Types']")
	public  WebElement RoomTypes;
    
    @FindBy(xpath="//a[text()='Display Colors']")
    public  WebElement displayColors;
    
    @FindBy(xpath="//a[text()='Phone Extensions']")
    public  WebElement PhoneExtension;
    
    @FindBy(xpath="//tr/td[text()='Administrator Console']")
	public  WebElement AdminHome_title;
    
    @FindBy(xpath="//a[text()='Price Manager']")
	public  WebElement PriceManager_Link;
    
    @FindBy(xpath="//a[text()='Frontdesk (Packages)']")
	public  WebElement FrontDeskPackages_Link;
    
    @FindBy(xpath="//a[text()='Web (Packages)']")
	public  WebElement WebPackages_Link;
    
    @FindBy(xpath="//a[text()='Corporate (Packages)']")
    public  WebElement CorporatePkg;
    
    @FindBy(xpath="//a[text()='Travel Agent (Packages)']")
    public  WebElement TravelAgentPackage;
    
    @FindBy(xpath="//a[text()='Room Prices']")
	public  WebElement RoomPrices;
    
    @FindBy(xpath="//a[text()='Packages Master']")
	public  WebElement PackageMaster;
    
    @FindBy(xpath="//div[@id='nav-bg']//ul/li[2]/a")
	public  WebElement Blocks;
    
    @FindBy(xpath="//a[text()='Sort Rooms']")
    public  WebElement SortRooms_Link;
    
    @FindBy(xpath="//div[@id='nav-bg']//ul/li[3]/a")
	public  WebElement Floors;
    
    @FindBy(xpath="//a[text()='Departments']")
    private  WebElement Department_link;
    
    @FindBy(xpath="//a[text()='POS Manager']")
    public  WebElement POSManager;
    
    @FindBy(xpath="//a[text()='POS Points ']")
    public  WebElement POSPoints;
    
    @FindBy(xpath="//a[text()='User Manager']")
    private static  WebElement UserManager_link;
    
    @FindBy(xpath="//a[text()='Users']")
    private static WebElement User_link;
    
    @FindBy(xpath="//a[text()='Room Taxes']")
    public  WebElement RoomTaxes;
    
    @FindBy(xpath="//a[text()='Group Tax']")
    public WebElement GroupTax;
    
    @FindBy(xpath="//a[text()='List of currencies']")
    public WebElement Link_ListOfCurrencies;
    
    @FindBy(xpath="//a[text()='Default Settings']")
    public WebElement Link_DefaultSetting;
    
    @FindBy(xpath="//a[text()='Pay Modes']")
    public WebElement Link_PayModes;
    
    public static   String hname;
    
    public String fn_verifyPageTitle() throws Exception
    {
    	try
    	{
       String str=GenericClass.driver.getTitle();
       //String str1=ExcelUtil.getCellData(iTestCaseRow, Constant.Col_ExpResult1);
        return str;
    	}
    	catch(AssertionError e)
    	{
    		throw e;
    	}
    }
    
    public  String verify_pgeHeader() throws Exception
    {
   	 try
   	 {
   	 String heading=GenericClass.getText(AdminHome_title);
   	 return heading;
   	 }
   	 catch(Exception e)
   	 {
   		 throw e;
   	 }
    }
    public String fn_getHotelName() throws Exception
    {
    	try
    	{
    	 hname=GenericClass.getText(txt_hotelName);
    	return hname;
    	}
    	catch(Exception e)
    	{
    		throw e;
    		
    	}
    }
    
    public ConfirmLoginPage ClickOnFrontdeskLink() throws Exception
    {
    	try
    	{
 	   GenericClass.clickElement(Link_Frontdesk);
 	   ConfirmLoginPage CLP=PageFactory.initElements(GenericClass.driver, ConfirmLoginPage.class);
 	   return CLP;
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
 }
    
    
	public InvoiceNumberSettingsLP fn_NavigateInvNumSettingPage() throws Exception
	{
		try
		{
		GenericClass.mouseOverElement(General);
		GenericClass.clickElement(InvoiceNumberSettings);
		
		InvoiceNumberSettingsLP INS=PageFactory.initElements(GenericClass.driver, InvoiceNumberSettingsLP.class);
		return INS;
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	
	public  RoomsLandingPage fn_NavigateRooms() throws Exception
	{
		try
		{
				GenericClass.mouseOverElement(RoomsManager);
				GenericClass.clickElement(Rooms);

				RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver, RoomsLandingPage.class);
			    return RLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	/**
	 * This method mouse hover over 'ROOMS MANAGER' and clicks on 'AMENTIIES'
	 * Navigates to AmenitiesLandingPage
	 * @return Object of AmenitiesLandingPage class and initializes all its elements
	 * @throws Exception
	 */
	public  AmenitiesLandingPage fn_NavigateAmenities() throws Exception
	{
		try
		{
	   GenericClass.mouseOverElement(RoomsManager);
	   GenericClass.clickElement(Amenities);
		}
		catch(NoSuchElementException e)
		{
			GenericClass.mouseOverElement(RoomsManager);
			GenericClass.js_Click(Amenities);
		}
		catch(Exception e)
		{
			throw e;
		}
	   AmenitiesLandingPage AmenitiesLandingPageobj = PageFactory.initElements(GenericClass.driver, AmenitiesLandingPage.class);
	   return AmenitiesLandingPageobj;

	}
	
	
	/**
	 * This method  mouse hover over 'ROOMS MANAGER' and clicks on 'ROOM TYPES'
	 * Navigates to RoomTypesLandingPage
	 * @return Object of RoomTypesLandingPage class and initializes all its elements
	 * @throws Exception
	 */
	public  RoomTypesLandingPage fn_NavigateRoomTypes() throws Exception
	{
		try
		{
	   GenericClass.mouseOverElement(RoomsManager);
	   GenericClass.clickElement(RoomTypes);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(2000);
			GenericClass.js_Click(RoomTypes);
		}
	   RoomTypesLandingPage RoomtypeLandingPageobj = PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
	   return RoomtypeLandingPageobj;

	}

	
	public DisplayColorsLandingPage fn_NavigateDisplayColors() throws Exception
	{
		try
		{
		GenericClass.mouseOverElement(RoomsManager);
		GenericClass.clickElement(displayColors);
		}
		catch(Exception e)
		{
			throw e;
		}
		DisplayColorsLandingPage DCP=PageFactory.initElements(GenericClass.driver, DisplayColorsLandingPage.class);
		return DCP;
	}
	
	public PhoneExtensionsListPage fn_NavigateToPhoneExtPage() throws Exception
	{

		try
		{
		GenericClass.mouseOverElement(RoomsManager);
		GenericClass.clickElement(PhoneExtension);
		
		PhoneExtensionsListPage PELP=PageFactory.initElements(GenericClass.driver, PhoneExtensionsListPage.class);
		return PELP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public  FrontDeskPackagesLandingPage fn_NavigateFrontdeskPackages() throws Exception
	{
		try
		{
		GenericClass.mouseOverElement(PriceManager_Link);
		GenericClass.clickElement(FrontDeskPackages_Link);

		FrontDeskPackagesLandingPage BMLP = PageFactory.initElements(GenericClass.driver, FrontDeskPackagesLandingPage.class);
	   return BMLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public ListOfPackagesWeb fn_NavigateWebPackages() throws Exception
	{
		try
		{
		GenericClass.mouseOverElement(PriceManager_Link);
		GenericClass.clickElement(WebPackages_Link);

		ListOfPackagesWeb WPLP = PageFactory.initElements(GenericClass.driver, ListOfPackagesWeb.class);
	   return WPLP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	public  ListOfPackagesCorporate fn_NavigateCorporatePackages() throws Exception
	{
		try
		{
		GenericClass.mouseOverElement(PriceManager_Link);
		GenericClass.clickElement(CorporatePkg);
		ListOfPackagesCorporate LCPobj=PageFactory.initElements(GenericClass.driver,ListOfPackagesCorporate.class );
		return LCPobj;
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	
	public ListOfPackagesTravelAgent fn_NavigateToTAPkg() throws Exception
	{
		try
		{
		GenericClass.mouseOverElement(PriceManager_Link);
	    GenericClass.clickElement(TravelAgentPackage);

	    ListOfPackagesTravelAgent LTA=PageFactory.initElements(GenericClass.driver, ListOfPackagesTravelAgent.class);
	    return LTA;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public  RoomPriceListLandingPage fn_NavigateRoomPrices() throws Exception
	{
		try
		{
		GenericClass.mouseOverElement(PriceManager_Link);
		GenericClass.clickElement(RoomPrices);

		RoomPriceListLandingPage RPL=PageFactory.initElements(GenericClass.driver, RoomPriceListLandingPage.class);
	    return RPL;
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	
	
	public PackageMasterListPage fn_NavigateToPackageMaster() throws Exception
	{
		try
	    {
		GenericClass.mouseOverElement(PriceManager_Link);
		GenericClass.clickElement(PackageMaster);
		PackageMasterListPage PML=PageFactory.initElements(GenericClass.driver, PackageMasterListPage.class);
		return PML;
	    }
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public  BlocksLandingPage fn_NavigateBlocks() throws Exception {
		try{
			GenericClass.mouseOverElement(RoomsManager);
			GenericClass.clickElement(Blocks);
		} catch(NoSuchElementException e) {
			Thread.sleep(2000);
			GenericClass.mouseOverElement(RoomsManager);
			GenericClass.clickElement(Blocks);
		} catch(Exception e) {
			throw e;
		}
			BlocksLandingPage BLPO = PageFactory.initElements(GenericClass.driver, BlocksLandingPage.class);
			return BLPO;
        }

	
	/**
	 * This method Navigates to sort rooms page.
	 * @return : As it returns SortRoomsLandingPage and initializes all its element.
	 * @throws Exception
	 */
	public  SortRoomsLandingPage fn_navigateToSortRooms() throws Exception{

		GenericClass.mouseOverElement(RoomsManager);
		GenericClass.clickElement(SortRooms_Link);
		SortRoomsLandingPage SRL=PageFactory.initElements(GenericClass.driver, SortRoomsLandingPage.class);
		return SRL;
		}
	
	
	public  FloorsLandingPage fn_NavigateToFloors() throws Exception{
		GenericClass.mouseOverElement(RoomsManager);
		GenericClass.clickElement(Floors);
		FloorsLandingPage FLP=PageFactory.initElements(GenericClass.driver, FloorsLandingPage.class);
		return FLP;
	}
	
	public DepartmentsLandingPage fn_NavigateDepartments() throws Exception{
    	try{
    	GenericClass.mouseOverElement(General);
    	GenericClass.clickElement(Department_link);
    	}catch(Exception e){
    		throw e;
    	}
    	DepartmentsLandingPage DLP=PageFactory.initElements(GenericClass.driver, DepartmentsLandingPage.class);
    	return DLP;
       }
	
	
	public  POSPointsLandingPage fn_NavigateToPosPoint() throws Exception{
try{
		GenericClass.mouseOverElement(POSManager);
		GenericClass.clickElement(POSPoints);
		POSPointsLandingPage PPL=PageFactory.initElements(GenericClass.driver, POSPointsLandingPage.class);
		return PPL;
}catch(Exception e){
	throw e;
}
	}

	
	public UsersLandingPage fn_NavigateUsers() throws Exception{
    	try{
    	GenericClass.mouseOverElement(UserManager_link);
    	GenericClass.clickElement(User_link);
    	}catch(Exception e){
    		throw e;
    	}
    	UsersLandingPage ULP=PageFactory.initElements(GenericClass.driver, UsersLandingPage.class);
    	return ULP;
       }
	
	public RoomTaxesLandingPage fn_NavigateToRoomTaxes() throws Exception{
		try{
		GenericClass.mouseOverElement(RoomsManager);
		GenericClass.clickElement(RoomTaxes);
		RoomTaxesLandingPage RTLP=PageFactory.initElements(GenericClass.driver, RoomTaxesLandingPage.class);
		return RTLP;
		}catch(Exception e){
			throw e;
		}
		}
	
	/**
	 * This methods navigates to the group tax page.
	 * @return: As it returns GroupTaxLandingPage and initialize all its elements.
	 */
	public GroupTaxLandingPage fn_NavigateToGroupTax(){
	 try{
	    	
	    	GenericClass.mouseOverElement(PriceManager_Link);
	    	GenericClass.clickElement(GroupTax);
	    	}
	    	catch(NoSuchElementException nse){
	    		nse.getMessage().toString();
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
	    	GroupTaxLandingPage GTLP=PageFactory.initElements(GenericClass.driver, GroupTaxLandingPage.class);
	    	return GTLP;
	    	
	    }
	    
	/**
	 * As this method for navigating to {@link ListofCurrenciesLandingPage} class.    
	 * @return : As it returns the initialized {@link ListofCurrenciesLandingPage} class.
	 * @throws Exception: If any occurs.
	 * @author deepak
	 */
	public ListofCurrenciesLandingPage fn_navigateToListOfCurrenciesPage() throws Exception{
	try{
	GenericClass.mouseOverElement(General);
	GenericClass.clickElement(Link_ListOfCurrencies);
	}
	catch(Exception e){
	throw e;	
	}
	ListofCurrenciesLandingPage LOCLP=PageFactory.initElements(GenericClass.driver, ListofCurrenciesLandingPage.class);
	return LOCLP;
	}
	
	
	/**
	  * As this method for navigating to default setting page.   
	  * @return : As it returns initialized {@link DefaultSettingsLandingPage} class.
	  * @throws Exception : If any occurs.
	  * @author deepak
	  */
	public DefaultSettingsLandingPage fn_navigateToDefaultSettingPage() throws Exception{
		try{
		GenericClass.mouseOverElement(General);	
		GenericClass.clickElement(Link_DefaultSetting);
		
	}
	catch(Exception e){
		throw e;
	}
	DefaultSettingsLandingPage DSLP=PageFactory.initElements(GenericClass.driver, DefaultSettingsLandingPage.class);
	return DSLP;
	}
	
	
	public  PayModesLandingPage fn_NavigateToPayModes(){
		try{
			GenericClass.mouseOverElement(General);
			GenericClass.clickElement(Link_PayModes);
		}
		catch(NoSuchElementException nse){
			nse.getMessage().toString();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		PayModesLandingPage PMLP=PageFactory.initElements(GenericClass.driver, PayModesLandingPage.class);
		return PMLP;

		}
}
