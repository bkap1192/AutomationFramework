package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class AmenitiesLandingPage {

	
	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	 public  WebElement heading_Page;
	
	@FindBy(xpath="//tr/td/a")
  	 public WebElement link_Main;
	
	
	@FindBy(xpath="//td[@class='editicon']/a")
	public  WebElement link_Edit;

	@FindBy(xpath="//select[@name='maxEntries']")
	public  WebElement drpdwn_View;
	
	@FindBy(xpath="//td/a[text()='Next>>']")
    public  WebElement link_Next;

    @FindBy(xpath="//td/a[text()='<<Previous']")
    public WebElement link_Previous;
    
    @FindBy(xpath="//td/a[text()='AuditTrail']")
	public  WebElement link_AuditTrailALP;

    @FindBy(xpath="//li/a[@title='Delete Selected Amenities']/img")
	public  WebElement btn_DeleteSelectedAmenities_imageBT;

	@FindBy(xpath="//li/a[@title='Add an Amenity ']")
	public  WebElement btn_AddAnAminity;

	@FindBy(xpath="//li/a[@title='Cancel']")
	public  WebElement btn_cancel;
	
	@FindBy(xpath="//select[contains(@onchange,'Navigate(this.value);')]")
	public  WebElement drpdwn_Page;
	
	@FindBy(xpath="//input[@name='Submit']")
    public  WebElement btn_Search;
	
	@FindBy(xpath="//div[@class='error_new']")
	public  WebElement errorMessage;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	 public  List<WebElement> tr_count;
	
	@FindBy(xpath="//input[@name='searchTitle']")
	public  WebElement txtbx_Search;
	
	@FindBy(xpath="//tr//td[@class='main-field']")
	public  WebElement amenities_name1;
	
	@FindBy(xpath="//input[@id='id_1']")
	public  WebElement chkbx_checkBox1;
	
	@FindBy(xpath="//input[@type='checkbox']")
	 public  List<WebElement> checkBox;
	
	@FindBy(xpath="//input[@name='checkbox5']")
	 public  WebElement chkbx_Master;
	
	@FindBy(xpath="//table[@class='list_viewnew']//th[3]/a[1]/img")
	public  WebElement btn_AmenityNameDownwardArrow;

	@FindBy(xpath="//table[@class='list_viewnew']//th[3]/a[2]")
	public WebElement btn_AmenityNameupwardArrow;
	
	@FindBy(xpath="//input[@name='ids[]']")
	public  List<WebElement> chkbx_AllcheckBox;
	
	@FindBy(xpath="//table[@class='list_viewnew']//th[6]/a[1]")
	public  WebElement StatusDownwardSort;

    @FindBy(xpath="//table[@class='list_viewnew']//th[6]/a[2]")
    public  WebElement StatusUpwardSort;

    @FindBy(xpath="//table[@class='list_viewnew']//tr[2]/td[6]/a/img")
    public WebElement Icon1;

    @FindBy(xpath="//td[@id='col_1']")
    public WebElement frstcolumn;
	
	public  String data;
	public  String amenitiesName;
	public  String amenityN1;

	/**
	 * This method gets page header in a variable and verifies it
	 * @param iTestCaseRow : Is used for test data.
	 * @throws AssertionError,Exception
	 */

	public String fn_verifyPageHeader() throws Exception
	{
		try
		{
        String text=GenericClass.getText(heading_Page);
        return text;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_verifyAmenitiesElements() throws Exception
	{
		try
		{
		GenericClass.checkElementDisplay("Main", link_Main);
		GenericClass.checkElementDisplay("Edit",link_Edit);
		GenericClass.checkElementDisplay("Audit Trail", link_AuditTrailALP);
		GenericClass.checkElementDisplay("Add an Amenity", btn_AddAnAminity);
		GenericClass.checkElementDisplay("Delete selected amenity", btn_DeleteSelectedAmenities_imageBT);
		GenericClass.checkElementDisplay("Cancel", btn_cancel);
		GenericClass.checkElementDisplay("Page dropdown", drpdwn_Page);
		GenericClass.checkElementDisplay("View records per page", drpdwn_View);
		GenericClass.checkElementDisplay("Search", btn_Search);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	/**
	 * This method clicks on 'ADD AN AMENITY' button and navigates to 'Add/Edit Amenity' page
	 * @return Object of AddEditAmenity page
	 * @throws Exception
	 */

	public  AddAmenity fn_NavigatetoAddAmenity() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_AddAnAminity);
		}
		catch(NoSuchElementException e)
		{
			GenericClass.js_Click(btn_AddAnAminity);
		}
		catch(Exception e)
		{
			throw e;
		}

		AddAmenity AddEdit_Amenityobj= PageFactory.initElements(GenericClass.driver, AddAmenity.class);
		return AddEdit_Amenityobj;
	}
	
	
	public String alertTextMessage() throws Exception
	{

		try
		{
		String alertText = GenericClass.getText(errorMessage);
		return alertText;
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	public String checkAmenitiesInList(String amntyName) throws Exception
	{

		try
		{
		GenericClass.selectElement(drpdwn_View, "100");
		Thread.sleep(3000);
        int trcount=GenericClass.tr_count(tr_count);

        for(int i=2;i<trcount;i++)
        {
        data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[3]")).getText();
        Assert.assertEquals(data, amntyName);
        break;     
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
        return data;
    }
	
	public EditAmenity fn_clkEdit() throws Exception
	{try{
		GenericClass.clickElement(link_Edit);
		EditAmenity EAP=PageFactory.initElements(GenericClass.driver, EditAmenity.class);
		return EAP;
	}catch(Exception e){
		throw e;
	}
	}
	
	
	public void fn_viewAll() throws Exception
	{
		try
		{
			Thread.sleep(1000);
		    GenericClass.selectElement(drpdwn_View, "All");
		    GenericClass.ActionOnAlert("Accept");

		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void fn_verifyCancelRTBtn(String amntyName,String value) throws Exception
	{
		try
		{
		fn_viewAll();
		GenericClass.sendKeys(txtbx_Search,amntyName);
		GenericClass.clickElement(btn_Search);
		String str=GenericClass.getText(amenities_name1);
		Assert.assertEquals(str,value);
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(NoSuchElementException e)
		{
			throw e;
		}

	}
	
	
	public void fn_verifyDeletePopup(int iTestCaseRow) throws Exception
	{
		try
		{
		GenericClass.clickElement(chkbx_checkBox1);
		amenitiesName = GenericClass.getText(amenities_name1);
		GenericClass.clickElement(btn_DeleteSelectedAmenities_imageBT);
		String message=GenericClass.ActionOnAlert("");
		System.out.println("message on alert   :"+message);
		if(message.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))))
		{
			System.out.println("Popup message matched");
			Assert.assertTrue(message.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
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

	
	public void fn_verifyDeleteDismiss() throws Exception
	{
		try
		{
		GenericClass.clickElement(chkbx_checkBox1);
		amenitiesName = GenericClass.getText(amenities_name1);
		GenericClass.clickElement(btn_DeleteSelectedAmenities_imageBT);
		GenericClass.ActionOnAlert("Dismiss");
		boolean value=chkbx_checkBox1.isSelected();
		Assert.assertEquals(value, true);
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	
	
	public void fn_verifyDeleteAccept(String amntyName) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(checkBox);
		for(int i=2;i<=count;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			if(data.equals(amntyName))
			{
				WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input"));
				ele.click();
				break;
			}
		}

		GenericClass.clickElement(btn_DeleteSelectedAmenities_imageBT);
		GenericClass.ActionOnAlert("Accept");
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	
	public String fn_verifyDeleteMsg() throws Exception
	{

		try
		{
	  String str=GenericClass.getText(errorMessage);
	  return str;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	
	public AdminHome fn_CancelBtnClk() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_cancel);
		}
		catch(NoSuchElementException e)
		{
			GenericClass.js_Click(btn_cancel);
		}
		catch(Exception e)
		{
			throw e;
		}
		AdminHome AH=PageFactory.initElements(GenericClass.driver,AdminHome.class);
		return AH;
	}

	
	public  AdminHome fn_mainLink() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_Main);
		}
		catch(NoSuchElementException e)
		{
			GenericClass.js_Click(link_Main);
		}
		catch(Exception e)
		{
			throw e;
		}
		AdminHome adminpageobj=	PageFactory.initElements(GenericClass.driver,	AdminHome.class);
		return adminpageobj;
	}
	
	
	public void fn_searchExistingAmenity() throws Exception
	{
		try
		{
		String str=GenericClass.getText(amenities_name1);
	  	GenericClass.sendKeys(txtbx_Search, str);
	  	GenericClass.clickElement(btn_Search);
	  	String str1=GenericClass.getText(amenities_name1);
	  	Assert.assertEquals(str1, str);
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	
	public void fn_searchNonExistingAmenity(int iTestCaseRow) throws Exception
	{

	    try
	    {
		GenericClass.sendKeys(txtbx_Search, GenericClass.generateRandomString());
	  	GenericClass.clickElement(btn_Search);
	  	String str=GenericClass.getText(amenities_name1);
	  	Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	    }
	    catch(AssertionError e)
	    {
	    	throw e;
	    }
	}

	
	public void fn_selectIndividualCB()
	{
		try
		{
		int count=GenericClass.tr_count(checkBox);
		for(int i=2;i<=count;i++)
		{
			WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input"));
			ele.click();
		}
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	/**
	 * This method checks checkbox corresponding to every amenity for isSelected() method
	 * @throws AssertionError
	 */
	public void fn_verifySelect()
	{
		try
		{
		int count=GenericClass.tr_count(checkBox);
		for(int i=2;i<=count;i++)
		{
			WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input"));
			boolean value=ele.isSelected();
			Assert.assertEquals(value, true);
		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}

	
	
	public void fn_deselectIndividualCB()
	{
		try
		{
		int count=GenericClass.tr_count(checkBox);
		for(int i=2;i<=count;i++)
		{
			WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input"));
			ele.click();
		}
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	/**
	 * This method checks checkbox corresponding to every amenity for isSelected() method in case when checkboxes are unchecked
	 * @throws AssertionError
	 */
	public void fn_verifyDeselect()
	{
		try
		{
		int count=GenericClass.tr_count(checkBox);
		for(int i=2;i<=count;i++)
		{
			WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[2]/input"));
			boolean value=ele.isSelected();
			Assert.assertEquals(value, false);
		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	
	public  void fn_MasterCB() throws Exception
	{
		try
		{
		GenericClass.clickElement(chkbx_Master);
		}
		catch(NoSuchElementException e)
		{
			GenericClass.js_Click(chkbx_Master);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_sortNameAsce() throws Exception
	{try{
		GenericClass.sortingName_Downward(drpdwn_View, "100",btn_AmenityNameDownwardArrow , chkbx_AllcheckBox, "//table[@class='list_viewnew']//tr/td[3]");
	}catch(Exception e){
		throw e;
	}
	}


	public void fn_sortNameDesc() throws Exception
	{try{
		GenericClass.sortingName_Upward(drpdwn_View, "100", btn_AmenityNameupwardArrow, chkbx_AllcheckBox, "//table[@class='list_viewnew']//tr/td[3]");
	}catch(Exception e){
		throw e;
	}
	}

	
	public void fn_sortStatusAsce() throws Exception
	{try{
	  GenericClass.sortstatus_Downward(drpdwn_View, "100", Icon1, StatusDownwardSort,chkbx_AllcheckBox , "//table[@class='list_viewnew']//tr/td[3]", "//table[@class='list_viewnew']//tr/td[6]/a/img");
	}catch(Exception e){
		throw e;
	}
	}


	public void fn_sortStatusDesc() throws Exception
	{try{
	  GenericClass.sortstatus_Upward(drpdwn_View, "100", StatusUpwardSort, chkbx_AllcheckBox, "//table[@class='list_viewnew']//tr/td[3]", "//table[@class='list_viewnew']//tr/td[6]/a/img");
	}catch(Exception e){
		throw e;
	}
	}
	
	public AddAmenity Image_EditAmenity(String amntyName) throws Exception
	{
		try
		{
	int count=GenericClass.tr_count(chkbx_AllcheckBox)+1;
	for(int i=2;i<count;i++)
	{
		String Am=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
		if(Am.equals(amntyName))
		{
		  GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[5]/a")).click();
		  break;
		}
	}
		}
		catch(Exception e)
		{
			throw e;
		}
	AddAmenity AEA=PageFactory.initElements(GenericClass.driver, AddAmenity.class);
	return AEA;
	}

	
	public  void verify_activeStatus(String amntyName) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(checkBox);
		for(int i=2;i<=count;i++)
		{
	      WebElement element=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]"));
	      amenityN1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	        if(amenityN1.contains(amntyName))
	          {
	            String value=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]//img")).getAttribute("src");
	             if(value.contains("off.GIF"))
	                {
	                  element.click();
	                  Thread.sleep(4000);
	                }

	          }


	    String value1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]//img")).getAttribute("src");
	    Assert.assertTrue(value1.contains("on.GIF"));
	    break;
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
	
	
	public  void verify_pageDropdown()
	{
		try
		{
		 GenericClass.selectElement(drpdwn_View, "1");
		 //GenericClass.selectElement(page_dropdown, "4");
	 	 String a=GenericClass.selectElementByvalue(drpdwn_Page, "2");
		 String columntxt=GenericClass.getText(frstcolumn);
		 System.out.println(columntxt);
		 boolean columnobj=columntxt.contains(a);
		 System.out.println(columnobj);
		 Assert.assertEquals(columnobj, true);
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	
	public void verify_viewDropdown(String DropdownValueForView)
	{
		//GenericClass.selectElement(View_Dropdown, DropdownValueForView);
	    try
	    {
		Select sel = new Select(drpdwn_View);
	    sel.selectByVisibleText(DropdownValueForView);


		int count=GenericClass.CheckBox_Count(chkbx_AllcheckBox);
		String count1=Integer.toString(count);
		if(DropdownValueForView.equals(count1)){

			System.out.println(DropdownValueForView +" record selected per page to view ");
		}else System.out.println("OOP's something went wrong!");
	    }
	    catch(Exception e)
	    {
	    	throw e;
	    }
	}
	
	
	public void verifyMsg_ViewAll(int iTestCaseRow) throws Exception
	{
		try
		{
		GenericClass.selectElement(drpdwn_View, "All");
		String str=GenericClass.ActionOnAlert("");
		Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
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
	
	
	public void viewAll_DismissAlert(int iTestCaseRow) throws Exception
	{
		try
		{
	    GenericClass.selectElement(drpdwn_View, "All");
	    GenericClass.ActionOnAlert("Dismiss");
	    Select sel=new Select(drpdwn_View);
	    String str=sel.getFirstSelectedOption().getText();
	    Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
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
	
	
	public void viewAll_AcceptAlert(int iTestCaseRow) throws Exception
	{
		try
		{
	    GenericClass.selectElement(drpdwn_View, "All");
	    GenericClass.ActionOnAlert("Accept");
	    Select sel=new Select(drpdwn_Page);
	    String str=sel.getFirstSelectedOption().getText();
	    String str1=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1));
	    Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
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
	
	
	public void verify_nextLnk() throws Exception
	{

		try
		{
			 Select select=new Select(drpdwn_Page);
		     String selectedoption=select.getFirstSelectedOption().getText();
		     int actlvalue=Integer.parseInt(selectedoption);
		     int expvalue=actlvalue+1;
			 GenericClass.selectElement(drpdwn_View, "1");
			 GenericClass.clickElement(link_Next);
			 //System.out.println(selectedoption);
			 String nexttext=GenericClass.getText(frstcolumn);
			 int actual=Integer.parseInt(nexttext);
			 Assert.assertEquals(actual, expvalue);
			 //System.out.println(nextobj);
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
	
	
	public  void verify_previousLnk() throws Exception
	{
		try
		{
		 GenericClass.selectElement(drpdwn_View, "5");
		 GenericClass.clickElement(link_Next);
		 Select next1=new Select(drpdwn_Page);
		 String nextobj=next1.getFirstSelectedOption().getText();
		 int act2value=Integer.parseInt(nextobj);
		 GenericClass.clickElement(link_Previous);
		 Select previous1=new Select(drpdwn_Page);
		 String previousobj=previous1.getFirstSelectedOption().getText();
		 int act3value=Integer.parseInt(previousobj);
		 int exp3value=act2value-1;
		 Assert.assertEquals(act3value, exp3value);
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

	
	public AuditTrailALP fn_clkAuditTrail() throws Exception
	{
		try
		{
	    	GenericClass.clickElement(link_AuditTrailALP);
		}
		catch(NoSuchElementException e)
		{
			GenericClass.js_Click(link_AuditTrailALP);
		}
		catch(Exception e)
		{
			throw e;
		}

		AuditTrailALP AALP=PageFactory.initElements(GenericClass.driver, AuditTrailALP.class);
	    return AALP;
	}
	
	public  void verify_deactiveStatus(String amntyName) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(checkBox);
		for(int i=2;i<=count;i++)
		{
	      WebElement element=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]"));
	      amenityN1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	        if(amenityN1.contains(amntyName))
	          {
	            String value=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]//img")).getAttribute("src");
	             if(value.contains("on.GIF"))
	                {
	                  element.click();
	                  Thread.sleep(4000);
	                }

	          }


	    String value1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]//img")).getAttribute("src");
	    Assert.assertTrue(value1.contains("off.GIF"));
	    break;
		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e ;
		}

	}
}

