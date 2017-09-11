package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTaxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class AddRoomTaxPage {

	
	@FindBy(xpath="//div[@id='heading_new']/div[1]/table/tbody/tr/td[2]")
	public WebElement Txt_PageHeader;
	
	@FindBy(xpath="//form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th")
	public WebElement Txt_DetailFillUp;
	
	@FindBy(xpath="//div[@id='listing-icons']/ul/li[2]/input")
	public WebElement Btn_SaveAtTop;
	
	@FindBy(xpath="//div[@id='listing-icons']/ul/li[1]/input")
	public WebElement Btn_CancelAtTop;
	
	@FindBy(xpath="//input[@value='Save Tax']")
	public WebElement Btn_SaveAtBottom;
	
	@FindBy(xpath="//input[@value='Cancel']")
	public WebElement Btn_CancelAtBottom;
	
	@FindBy(xpath="//input[@id='taxNameMulName_0']")
	public WebElement TxtBox_TaxTitle;
	
	@FindBy(xpath="//input[@id='taxShortName']")
	public WebElement TxtBox_TaxShortNumber;
	
	@FindBy(xpath="//select[@id='accountCodeId']")
	public WebElement DD_AccountCode;
	
	@FindBy(xpath="//a[@id='addNewAccountCode']")
	public WebElement Link_AddAccountCode;
	
	@FindBy(xpath="//div[@id='accountCodeBox']/table/tbody/tr[2]/td[2]/input")
	public WebElement TxtBox_AccountName;
	
	@FindBy(xpath="//div[@id='accountCodeBox']/table/tbody/tr[3]/td[2]/input")
	public WebElement TxtBox_AccountCode;
	
	@FindBy(xpath="html/body/div[5]/div[11]/div/button[1]")
	public WebElement Btn_SaveAccCode;
	
	@FindBy(xpath="html/body/div[5]/div[11]/div/button[2]")
	public WebElement Btn_Cancel;
	
	@FindBy(xpath="html/body/div[5]/div[1]/button")
	public WebElement Btn_ClosePopUp;
	
	@FindBy(xpath="//textarea[@id='descriptionMulDes_0']")
	public WebElement TxtArea_Description;
	
	@FindBy(xpath="//input[@id='slabChargeTypePV']")
	public WebElement RB_PercentageTaxType;
	
	@FindBy(xpath="//input[@id='slabChargeTypeFV']")
	public WebElement RB_FixedAmtTaxType;
	
	@FindBy(xpath="//input[@id='woSlabTaxAmount']")
	public WebElement TxtBox_TaxAmountForTaxType;
	
	@FindBy(xpath="//select[@id='slabTaxAppliedOnPV']")
	public WebElement DD_CalculationRuleforPV;
	
	@FindBy(xpath="//a[text()='Add Slab(s)']")
	public WebElement Link_AddSlabs;
	
	@FindBy(xpath="//a[text()='Main']")
	public WebElement Link_Main;
	
	@FindBy(xpath="//form/table/tbody/tr[1]/td/div[2]/table/tbody/tr/td/a[2]")
	public WebElement Link_RoomTaxList;
	
	@FindBy(xpath="//a[text()='AuditTrail']")
	public WebElement Link_AuditTrail;
	
	@FindBy(xpath="//select[@id='slabTaxAppliedOnPV']/option")
	public List<WebElement> AllCalculationRule; 
	
	@FindBy(xpath="//select[@id='slabTaxAppliedOnFV']")
	public WebElement DD_CalculationRuleFV;
	
	@FindBy(xpath="//input[@id='adultChildChk']")
	public WebElement CB_AdultChildTax;
	
	@FindBy(xpath="//select[@id='childAdultDrpdwn']")
	public WebElement DD_ChildAdult;
	
	@FindBy(xpath="//td[@class='error']")
	public WebElement Msg_Error;
	
	@FindBy(xpath="//span[text()='Add New Account Code']")
	public WebElement Txt_HeaderAccountCode;
	
	@FindBy(xpath="//span[@id='errorMsg']")
	public WebElement Txt_ErrorMsg;
	
	@FindBy(xpath="//strong[contains(text(),'Tax Applicable when')]")
	public WebElement TxtSlab_TaxApplicableWhen;
	
	@FindBy(xpath="//strong[contains(text(),'Tax Applicable when')]")
	public WebElement Txt_slabApplicable;
	
	@FindBy(xpath="//tr[@id='hdSlbAddTbl']/td[2]")
	public WebElement Txt_RangeCol;
	
	@FindBy(xpath="//input[contains(@id,'slbMinAmount_')]")
	public WebElement TxtBx_SlabAmtRange;
	
	@FindBy(xpath="//input[contains(@id,'slbTaxAmount_')]")
	public WebElement TxtBx_SlabTaxAmt;
	
	@FindBy(xpath="//div[@class='admin-delete-img']")
	public WebElement Link_DeleteSlabImg;
	
	@FindBy(xpath="//a[text()='Add Slab(s)']")
	public WebElement Link_AddSlab;
	
	@FindBy(xpath="//img[@id='showCalFrom']")
	public WebElement Link_ActivateCal;
	
	@FindBy(xpath="//input[@id='adultChildChk']")
	public WebElement CB_AdultChild;
	
	@FindBy(xpath="//select[@id='childAdultDrpdwn']")
	public WebElement DD_PaxType;
	
	public String accountName;
	public String accountCode;
	public String taxTitle;
	public String taxId;
	
	
	/**
	 * As this method verifies page elements of Add room Tax page.
	 * @throws Exception: If any occurs.
	 * @author deepak	
	 */
	public void VerifyPageElement() throws Exception{
	try{
		GenericClass.checkElementDisplay("Page Header Displaying",Txt_PageHeader);
		GenericClass.checkElementDisplay("Detail fill up text",Txt_DetailFillUp);
		GenericClass.checkElementDisplay("Save button at top",Btn_SaveAtTop);
		GenericClass.checkElementDisplay("Cancel Button At Top",Btn_CancelAtTop);
		GenericClass.checkElementDisplay("Save button at bottom",Btn_SaveAtBottom);
		GenericClass.checkElementDisplay("Cancel Button At bottom",Btn_CancelAtBottom);
		GenericClass.checkElementDisplay("Tax titlebox",TxtBox_TaxTitle);
		GenericClass.checkElementDisplay("Tax short number tetx box",TxtBox_TaxShortNumber);
		GenericClass.checkElementDisplay("Account code drop down",DD_AccountCode);
		GenericClass.checkElementDisplay("Add account code link",Link_AddAccountCode);
		GenericClass.checkElementDisplay("Description Text",TxtArea_Description);
		GenericClass.checkElementDisplay("Radio box for % tax type",RB_PercentageTaxType);
		GenericClass.checkElementDisplay("Radio box for Fixed tax type",RB_FixedAmtTaxType);
		GenericClass.checkElementDisplay("Tax amount text box",TxtBox_TaxAmountForTaxType);
		GenericClass.checkElementDisplay("Calculation dropdown",DD_CalculationRuleforPV);
		GenericClass.checkElementDisplay("Add slabs link",Link_AddSlabs);
		GenericClass.checkElementDisplay("Main link",Link_Main);
		GenericClass.checkElementDisplay("Room Tax list Link",Link_RoomTaxList);
		GenericClass.checkElementDisplay("Audit Trail link",Link_AuditTrail);
	}
	catch(Exception e){
	throw e;
	}
	}
	
	
	/**
	 * As this method clicks on main link.
	 * @return : As it returns the initialized AdminHome Page.
	 * @author deepak
	 */
	public AdminHome ClickOnMainLink(){
	try{
		GenericClass.clickElement(Link_Main);	
	}
	catch(Exception e){
	e.printStackTrace();
	}
	AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
	return AH;
	}
	
	
	/**
	 * As this method clicks on Room Tax List link.
	 * @return : As it returns initialized RoomTaxesLanding Page
	 * @author deepak
	 */
	public RoomTaxesLandingPage ClickOnRoomTaxListLink(){
	try{
	GenericClass.clickElement(Link_RoomTaxList);
	}
	catch(Exception e){
	e.printStackTrace();
	}
	RoomTaxesLandingPage RTLP=PageFactory.initElements(GenericClass.driver,RoomTaxesLandingPage.class);
	return RTLP;
	}
	
	
	/**
	 * As this method verifies the calculation rule based on tax type.
	 * @param calcRule : It's calculation rule which is passed as an arg.
	 * @param typeTax: It's type of tax for which we need to verify the calculation rule.
	 * @return: As it returns the calculation rule as a string.
	 * @throws Exception: If any occurs.
	 * @author deepak
	 */
	public String VerifyCalcRuleForTaxType(String calcRule,String typeTax) throws Exception{
	String CalRule=null;
	try{
	if(typeTax=="percentage"){
	GenericClass.clickElement(RB_PercentageTaxType);
	}
	else if(typeTax=="fix"){
	GenericClass.clickElement(RB_FixedAmtTaxType);
	}
	for(int i=1;i<=AllCalculationRule.size()-1;i++){
	CalRule=AllCalculationRule.get(i).getText();
		if(CalRule.equals(calcRule)){
		break;
	}
	}
	}
	catch(Exception e){
	e.printStackTrace();
	}
	return CalRule;
	}

	
	/**
	 * As this method creates the account code.
	 *@throws Exception: If any occurs.
	 *@author deepak.
	 */
	public void CreateAccountCode() throws Exception{
	try{
	accountName=GenericClass.generateRandomString();
	accountCode=GenericClass.generateRandomString();
	GenericClass.clickElement( Link_AddAccountCode);
	GenericClass.sendKeys(TxtBox_AccountName, accountName);
	GenericClass.sendKeys(TxtBox_AccountCode, accountCode);
	GenericClass.clickElement(Btn_SaveAccCode);
	Thread.sleep(2000);
	}
	catch(Exception e){
	throw e;
	}
	}

	
	/**
	 * As this method adds the tax.	
	 * @param iTestCaseRow: As this is arg which is passed for test data handling.
	 * @param taxType: Its tax type which needs to be passed as an arg either <b>Percentage</b> or <b>fix</b>
	 * @param calcRule: Its calculation rule which is passed as an arg.
	 * @param ele : its WebELement which is used to perform any action like <b>Save Tax</b> or <b> Cancel</b> operations. 
	 * @return: As it returns the initialized RoomTaxesLanding Page.
	 * @author deepak
	 * @throws Exception 
	 */
	public RoomTaxesLandingPage fn_addTax(int iTestCaseRow,String taxType,String calcRule,WebElement ele) throws Exception{
	try{
	taxTitle=GenericClass.generateRandomString();
	taxId=GenericClass.generateRandomString();
	if(taxType.equalsIgnoreCase("percentage")){
	GenericClass.clickElement(RB_PercentageTaxType);
	GenericClass.sendKeys(TxtBox_TaxTitle,taxTitle);
	GenericClass.sendKeys(TxtBox_TaxShortNumber,taxId);
	Thread.sleep(2000);
	CreateAccountCode();
	Thread.sleep(2000);
	GenericClass.sendKeys(TxtArea_Description,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
	GenericClass.sendKeys(TxtBox_TaxAmountForTaxType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxAmount)));
	GenericClass.selectElement(DD_CalculationRuleforPV, calcRule);
	GenericClass.clickElement(ele);
	}
	else if(taxType.equalsIgnoreCase("fix")){
	GenericClass.clickElement(RB_FixedAmtTaxType);
	GenericClass.sendKeys(TxtBox_TaxTitle,taxTitle);
	GenericClass.sendKeys(TxtBox_TaxShortNumber,taxId);
	CreateAccountCode();
	Thread.sleep(2000);
	GenericClass.sendKeys(TxtArea_Description,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
	GenericClass.sendKeys(TxtBox_TaxAmountForTaxType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxAmount)));
	GenericClass.selectElement(DD_CalculationRuleFV, calcRule);
	GenericClass.clickElement(ele);		
	}
	}
	catch(Exception e){
	throw e;	
	}
	RoomTaxesLandingPage RTP=PageFactory.initElements(GenericClass.driver, RoomTaxesLandingPage.class);
	return RTP;
	}
	
	
	/**
	 * As this method adds a tax based on pax type.
	 * @param iTestCaseRow : As this parameter is used for handling test data from external file.
	 * @param SaveBtn : Its save button,which is passed as an arg.
	 * @return : As it returns initialized RoomTaxesLanding Page.
	 * @throws Exception : If any occurs.
	 * @author deepak
	 */
	public RoomTaxesLandingPage AddTaxBasedOnPaxType(int iTestCaseRow,WebElement SaveBtn) throws Exception{
	RoomTaxesLandingPage RTLP=null;
	try{
	taxTitle=GenericClass.generateRandomString();
	taxId=GenericClass.generateRandomString();
	GenericClass.sendKeys(TxtBox_TaxTitle, taxTitle);
	GenericClass.sendKeys(TxtBox_TaxShortNumber, taxId);
	GenericClass.sendKeys(TxtArea_Description,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
	CreateAccountCode();
	Thread.sleep(2000);
	GenericClass.sendKeys(TxtBox_TaxAmountForTaxType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxAmount)));
	Thread.sleep(3000);
	GenericClass.clickElement(RB_FixedAmtTaxType);
	GenericClass.selectElement(DD_CalculationRuleFV, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule)));
	GenericClass.clickElement(CB_AdultChildTax);
	GenericClass.selectElement(DD_ChildAdult,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PaxType)));
	GenericClass.clickElement(SaveBtn);
	}
	catch(Exception e){
	e.printStackTrace();
	}
	RTLP=PageFactory.initElements(GenericClass.driver, RoomTaxesLandingPage.class);
	return RTLP;
	}

	
	/**
	 * As this method saves room taxes with duplicate tax title.
	 * 
	 * @param iTestCaseRow : As it's parameter for test data handling.
	 * @param taxTitle: It's tax title which is added earlier passed as an arg.
	 * @return : As it returns validation message in string format after saving with duplication tax title.
	 * @throws Exception : If any occurs.
	 * @author deepak.
	 */
	public String fn_verifyDuplicateTaxTitleMessage(int iTestCaseRow,String taxTitle) throws Exception{
		try{
		Thread.sleep(2000);
		GenericClass.sendKeys(TxtBox_TaxTitle, taxTitle);
		GenericClass.sendKeys(TxtBox_TaxShortNumber, "TS1");
		CreateAccountCode();
		
		GenericClass.sendKeys(TxtArea_Description,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
		GenericClass.clickElement(RB_PercentageTaxType);
		GenericClass.sendKeys(TxtBox_TaxAmountForTaxType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxAmount)));
		GenericClass.selectElement(DD_CalculationRuleforPV, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule)));
		GenericClass.clickElement(Btn_SaveAtBottom);
		Thread.sleep(2000);
		return GenericClass.getText(Msg_Error);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * As this method verifies the account code pop up elements.
	 * @throws Exception 
	 * 	@author deepak
	 */
	public void fn_verifyAccountCodePopUpElements() throws Exception{
	try{
	GenericClass.checkElementDisplay("Txt_HeaderAccountCode", Txt_HeaderAccountCode);
	GenericClass.checkElementDisplay("TxtBox_AccountName", TxtBox_AccountName);
	GenericClass.checkElementDisplay("TxtBox_AccountCode", TxtBox_AccountCode);
	GenericClass.checkElementDisplay("Btn_SaveAccCode", Btn_SaveAccCode);
	GenericClass.checkElementDisplay("Btn_Cancel", Btn_Cancel);
	GenericClass.checkElementDisplay("Btn_ClosePopUp", Btn_ClosePopUp);
	}
	catch(Exception e){
		throw e;
	}
	}
	
	
	/**
	 * 
	 * @param iTestCaseRow
	 * @param taxId
	 * @return
	 * @throws Exception
	 * @author deepak
	 */
	public String fn_VerifyDuplicateTaxIdMessage(int iTestCaseRow,String taxId) throws Exception{
		GenericClass.sendKeys(TxtBox_TaxTitle, "Tax1");
		GenericClass.sendKeys(TxtBox_TaxShortNumber, taxId);
		CreateAccountCode();
		GenericClass.sendKeys(TxtArea_Description,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
		GenericClass.clickElement(RB_PercentageTaxType);
		GenericClass.sendKeys(TxtBox_TaxAmountForTaxType, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxAmount)));
		GenericClass.selectElement(DD_CalculationRuleforPV, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CalculationRule)));
		GenericClass.clickElement(Btn_SaveAtBottom);
		Thread.sleep(2000);
		return GenericClass.getText(Msg_Error);
	}

	
	/**
	 * As this method enters the duplicate account code.
	 * @param acCode: As this is duplicate account code which is passed as an arg. 
	 * @return : As it returns the error message in string format. 
	 * @throws Exception: If any occurs.
	 * @author deepak
	 */
	public String fn_VerifyDuplicateAccountCode(String acCode) throws Exception{
	String errMsg=null;
	try{
	GenericClass.clickElement(Link_AddAccountCode);
	GenericClass.sendKeys(TxtBox_AccountName, GenericClass.generateRandomString());
	GenericClass.sendKeys(TxtBox_AccountCode, acCode);
	GenericClass.clickElement(Btn_SaveAccCode);
	errMsg=GenericClass.getText(Txt_ErrorMsg);
	}
	catch(Exception e){
	throw e;	
	}
	return errMsg;
	}

	/**
	 * As this method verifies the slab table elements once clicked on Add Slabs link.
	 * @throws Exception: If any occurs.
	 * @author deepak
	 */
	public void fn_verifySlabTableElement() throws Exception{
	try{
	GenericClass.clickElement(Link_AddSlabs);
	GenericClass.checkElementDisplay("TxtSlab_TaxApplicableWhen", TxtSlab_TaxApplicableWhen);
	GenericClass.checkElementDisplay("Txt_slabApplicable", Txt_slabApplicable);
	GenericClass.checkElementDisplay("Txt_RangeCol", Txt_RangeCol);
	GenericClass.checkElementDisplay("TxtBx_SlabAmtRange", TxtBx_SlabAmtRange);
	GenericClass.checkElementDisplay("TxtBx_SlabAmt", TxtBx_SlabTaxAmt);
	GenericClass.checkElementDisplay("Link_DeleteSlabImg", Link_DeleteSlabImg);
	GenericClass.checkElementDisplay("Link_ActivateCal", Link_ActivateCal);
	GenericClass.checkElementDisplay("Link_AddSlab", Link_AddSlab);
	}
	catch(Exception e){
	throw e;	
	}
	}
	
	
	/**
	 * As this method clicks on date . 
	 * @param date: As its date to be selected.
	 * @throws Exception: If any occurs.
	 * @author deepak
	 */
	public void fn_clickOnDate(String date) throws Exception{
	try{
	GenericClass.clickElement(Link_ActivateCal);
	int size=GenericClass.driver.findElements(By.xpath("//table[@id='cal1']/tbody/tr/td/a")).size();
	System.out.println("Number of days are"  +(size-1));
	GenericClass.driver.findElements(By.xpath("//table[@id='cal1']/tbody/tr/td/a")).get(Integer.parseInt(date)-1).click();
	//GenericClass.driver.findElements(By.xpath("//a[text()='"+date+"']"))
	}
	catch(Exception e){
	throw e;
	}
	}

	
	/**
	 * As this method adds the slab tax.
	 * @param iTestCaseRow: As this parameter for test data handling.
	 * @param taxType: As it's tax type whether fixed or percentage. 
	 * @param calcRule : As it's calculation rule which is passed as an arg.
	 * @param ele: As its element for submit the form.
	 * @return: As it returns the initialized {@link RoomTaxesLandingPage}. 
	 * @throws Exception: If any occurs.
	 * @author deepak
	 */
	public RoomTaxesLandingPage fn_AddSlabTax(int iTestCaseRow,String taxType,String calcRule,WebElement ele) throws Exception{
	try{
	GenericClass.clickElement(Link_AddSlabs);
	taxTitle=GenericClass.generateRandomString();
	taxId=GenericClass.generateRandomString();	
	if(taxType.equalsIgnoreCase("percentage")){     
	GenericClass.clickElement(RB_PercentageTaxType);
	GenericClass.sendKeys(TxtBox_TaxTitle,taxTitle);
	GenericClass.sendKeys(TxtBox_TaxShortNumber,taxId);
	CreateAccountCode();
	Thread.sleep(2000);
	GenericClass.sendKeys(TxtArea_Description,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
	GenericClass.selectElement(DD_CalculationRuleforPV, calcRule);
	GenericClass.sendKeys(TxtBx_SlabAmtRange, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_SlabAmountRange)));
	GenericClass.sendKeys(TxtBx_SlabTaxAmt, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxAmount)));

	fn_clickOnDate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ActivationDateForSlab)));
	GenericClass.clickElement(ele);
	}
	else if(taxType.equalsIgnoreCase("fix")){
	GenericClass.clickElement(RB_FixedAmtTaxType);
	GenericClass.sendKeys(TxtBox_TaxTitle,taxTitle);
	GenericClass.sendKeys(TxtBox_TaxShortNumber,taxId);
	CreateAccountCode();
	Thread.sleep(2000);
	GenericClass.sendKeys(TxtArea_Description,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
	GenericClass.selectElement(DD_CalculationRuleFV, calcRule);
	GenericClass.sendKeys(TxtBx_SlabAmtRange, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_SlabAmountRange)));
	GenericClass.sendKeys(TxtBx_SlabTaxAmt, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxAmount)));

	fn_clickOnDate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ActivationDateForSlab)));
	GenericClass.clickElement(ele);		
	}
	}
	catch(Exception e){
	throw e;	
	}
	RoomTaxesLandingPage RTLP=PageFactory.initElements(GenericClass.driver, RoomTaxesLandingPage.class);
	return RTLP;
	}
	
	
	public RoomTaxesLandingPage fn_addSlabforPerPersonPerNightSessionAlongWithPaxType(int iTestCaseRow,WebElement saveBtn) throws Exception{
		try{
		taxTitle=GenericClass.generateRandomString();
		taxId=GenericClass.generateRandomString();
		String pax=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PaxType));	
		if(pax.equals("")){
		GenericClass.sendKeys(TxtBox_TaxTitle,taxTitle);
		GenericClass.sendKeys(TxtBox_TaxShortNumber,taxId);
		CreateAccountCode();
		Thread.sleep(2000);
		GenericClass.sendKeys(TxtArea_Description,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
		GenericClass.clickElement(RB_FixedAmtTaxType);
		GenericClass.selectElement(DD_CalculationRuleFV, "Per Person Per Night/Session");
		GenericClass.clickElement(Link_AddSlabs);
		GenericClass.sendKeys(TxtBx_SlabTaxAmt, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxAmount)));
		fn_clickOnDate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ActivationDateForSlab)));
		GenericClass.clickElement(saveBtn);		
		}
		else{
		GenericClass.sendKeys(TxtBox_TaxTitle,taxTitle);
		GenericClass.sendKeys(TxtBox_TaxShortNumber,taxId);
		CreateAccountCode();
		Thread.sleep(2000);
		GenericClass.sendKeys(TxtArea_Description,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
		GenericClass.clickElement(RB_FixedAmtTaxType);
		GenericClass.selectElement(DD_CalculationRuleFV, "Per Person Per Night/Session");
		GenericClass.clickElement(CB_AdultChild);
		GenericClass.selectElement(DD_PaxType, pax);
		GenericClass.clickElement(Link_AddSlabs);
		GenericClass.sendKeys(TxtBx_SlabTaxAmt, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TaxAmount)));
		fn_clickOnDate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ActivationDateForSlab)));
		GenericClass.clickElement(saveBtn);	
		}
		}
		catch(Exception e){
		throw e;	
		}
		RoomTaxesLandingPage RTLP=PageFactory.initElements(GenericClass.driver, RoomTaxesLandingPage.class);
		return RTLP;
		}

	
	/**
	 * As this method clicks on audit trail link.	
	 * @return: As it returns initialized {@link AuditTrialPage} page.
	 * @throws Exception: If any occurs.
	 * @author deepak
	 */
	public AuditTrialPage fn_clickOnAuditTrailLink() throws Exception{
	try{
	GenericClass.clickElement(Link_AuditTrail);	
	}
	catch(Exception e){
	throw e;	
	}
	AuditTrialPage ATP=PageFactory.initElements(GenericClass.driver, AuditTrialPage.class);
	return ATP;
	}
}
