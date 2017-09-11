package com.hms.hotelogix.automationframework.pages.admin.General.InvoiceNumberSettings;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
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

public class InvoiceNumberSettingsLP 
{

	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	public  WebElement heading_Page;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[3]//td")
	public WebElement section_Frontdesk;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[4]//td/table//tr[2]//a")
	public WebElement link_FDEdit;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[4]//td/table//tr/th")
	public WebElement headers_FDPrefix;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[4]//td/table//tr/th[2]")
	public WebElement headers_FDStartSeriesNo;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[4]//td/table//tr/th[3]")
	public WebElement headers_FDAction;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[5]//td")
	public WebElement section_PaymentReceipt;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[6]//td/table//tr[2]//a")
	public WebElement link_PREdit;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[6]//td/table//tr/th")
    public WebElement headers_PRPrefix;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[6]//td/table//tr/th[2]")
	public WebElement headers_PRStartSeriesNo;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[6]//td/table//tr/th[3]")
	public WebElement headers_PRAction;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[7]//td")
	public WebElement section_POSPoint;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[8]//td/table//tr[2]//a")
	public WebElement link_POSEdit;
		
	@FindBy(xpath="//a[text()='<<Previous']")
	public WebElement link_POSPrevious;	
	
	@FindBy(xpath="//a[text()='Next>>']")
	public WebElement link_POSNext;
	
	@FindBy(xpath="//td[text()='<<Previous | Next>>']")
	public WebElement text_PrevNext;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[8]//td/table//tr/th")
	public WebElement headers_hash;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[8]//td/table//tr[2]/td")
	public WebElement colm_SNo;
	
	@FindBy(xpath="(//table[@class='list_viewnew'])[3]//tr//a[text()='Edit']")
	public List<WebElement> rowcount_POSTable;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[8]//td/table//tr/th[2]")
	public WebElement headers_POSPoint;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[8]//td/table//tr[2]/td[2]")
	public WebElement text_frstPOSPt;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[8]//td/table//tr/th[3]")
	public WebElement headers_POSShortName;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[8]//td/table//tr/th[4]")
	public WebElement headers_POSPrefix;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[8]//td/table//tr/th[5]")
	public WebElement headers_POSStartSeriesNo;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[8]//td/table//tr/th[6]")
	public WebElement headers_POSAction;
	
	@FindBy(xpath="//select[@name='offset']")
	public WebElement drpdown_POSPage;
	
	@FindBy(xpath="//select[@name='maxEntries']")
	public WebElement drpdown_POSView;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[8]//td/table//tr/th[2]//img")
	public WebElement arrow_POSPtDownward;
	
	@FindBy(xpath="//form[@id='frmListView']//table//tr[8]//td/table//tr/th[2]//a[2]/img")
	public WebElement arrow_POSPtUpward;
		
	@FindBy(xpath="//form[@id='frmListView']//table//tr[10]//td")
	public WebElement section_CustomSettings;
	
	@FindBy(xpath="//div[@class='fields']//strong")
	public WebElement label_AddHotelID;
	
	@FindBy(xpath="//div[@class='fields']//td[2]//input")
	public WebElement rb_No;
	
	@FindBy(xpath="//div[@class='fields']//td[2]//label[2]//input")
	public WebElement rb_Yes;
	
	@FindBy(xpath="//input[@value='Save Changes']")
	public WebElement btn_SaveChanges;
	
	@FindBy(xpath="//td[@class='breadcurms_new']/a[text()='Main']")
    public  WebElement link_Main;
	
	@FindBy(xpath="//table//tr[3]/td//a[text()='AuditTrail']")
    public  WebElement link_AuditTrail;
	
	@FindBy(xpath="(//table[@class='list_viewnew'])[3]//tr")
	public List<WebElement> rowcount;
	

	@FindBy(xpath="(//table[@class='list_viewnew'])[3]")
	public WebElement table;
	
	@FindBy(xpath="//td[@class='error']")
	public WebElement txt_saveMsg;
	
	public  String POSPt;
	
	
	public String verify_pageHeader()
	{
		try
		{
		String str=GenericClass.getText(heading_Page);
		return str;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_verifyPageElements() throws Exception
	{
		try
		{
		GenericClass.checkElementDisplay("section_Frontdesk", section_Frontdesk);
		GenericClass.checkElementDisplay("section_POS", section_POSPoint);
		GenericClass.checkElementDisplay("section_CustomSettings", section_CustomSettings);
		GenericClass.checkElementDisplay("Main", link_Main);
		GenericClass.checkElementDisplay("Audit Trail", link_AuditTrail);
		GenericClass.checkElementDisplay("Edit", link_FDEdit);
		GenericClass.checkElementDisplay("FD_Prefix", headers_FDPrefix);
		GenericClass.checkElementDisplay("FD_StartSeries", headers_FDStartSeriesNo);
		GenericClass.checkElementDisplay("FD_Action", headers_FDAction);
		GenericClass.checkElementDisplay("POS_Edit", link_POSEdit);
		GenericClass.checkElementDisplay("POS_Prefix",headers_POSPrefix);
		GenericClass.checkElementDisplay("POS_StartSeries", headers_POSStartSeriesNo);
		GenericClass.checkElementDisplay("POS_ShortName", headers_POSShortName);
		GenericClass.checkElementDisplay("POS_Action", headers_POSAction);
		GenericClass.checkElementDisplay("PR_Edit", link_PREdit);
		GenericClass.checkElementDisplay("PR_Prefix", headers_PRPrefix);
		GenericClass.checkElementDisplay("PR_StartSeries", headers_PRStartSeriesNo);
		GenericClass.checkElementDisplay("PR_Action", headers_PRAction);
		GenericClass.checkElementDisplay("POS_drpdwnPage", drpdown_POSPage);
		GenericClass.checkElementDisplay("POS_drpdwnView", drpdown_POSView);
		GenericClass.checkElementDisplay("label", label_AddHotelID);
		GenericClass.checkElementDisplay("radiobtn_Yes", rb_Yes);
		GenericClass.checkElementDisplay("radiobtn_No", rb_No);
		GenericClass.checkElementDisplay("Save Changes", btn_SaveChanges);
		}
		catch(NoSuchElementException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public AdminHome fn_clkMainLnk() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_Main);
		
		AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
		return AH;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public EditFDInvoiceNumber fn_clkFDEditLnk() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_FDEdit);
		
		EditFDInvoiceNumber EIN=PageFactory.initElements(GenericClass.driver, EditFDInvoiceNumber.class);
		return EIN;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public void fn_verifyEditedFDPrefix(int iTestCaseRow) throws Exception
	{
		try
		{
			//System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix)));
		String str1=GenericClass.driver.findElement(By.xpath("//form[@id='frmListView']//table//tr[4]//td/table//tr[2]//td")).getText();
		Assert.assertEquals(str1.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix))), true);
		
		
		//System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber)));
		String str2=GenericClass.driver.findElement(By.xpath("//form[@id='frmListView']//table//tr[4]//td/table//tr[2]/td[2]")).getText();
		Assert.assertEquals(str2.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber))), true);
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
	
	
	public EditPRInvoiceNumber fn_clkPREditLnk() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_PREdit);
		
		EditPRInvoiceNumber EPRI=PageFactory.initElements(GenericClass.driver, EditPRInvoiceNumber.class);
		return EPRI;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_verifyEditedPRPrefix(int iTestCaseRow) throws Exception
	{
		try
		{
			//System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix)));
		String str1=GenericClass.driver.findElement(By.xpath("//form[@id='frmListView']//table//tr[6]//td/table//tr[2]//td")).getText();
		Assert.assertEquals(str1.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix))), true);
		
		
		//System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber)));
		String str2=GenericClass.driver.findElement(By.xpath("//form[@id='frmListView']//table//tr[6]//td/table//tr[2]/td[2]")).getText();
		Assert.assertEquals(str2.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber))), true);
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
	
	
	
	
	public void fn_POSPtDownwardSort() throws Exception
	{
		try
		{
		List<WebElement> counteditlink=table.findElements(By.linkText("Edit"));
		//int val=counteditlink.size();
		//System.out.println(val);
		GenericClass.sortingName_Downward(drpdown_POSView, "100", arrow_POSPtDownward, counteditlink, "(//table[@class='list_viewnew'])[3]//tr/td[2]");
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public void fn_POSPtUpwardSort() throws Exception
	{
		List<WebElement> counteditlink=table.findElements(By.linkText("Edit"));
		
		GenericClass.sortingName_Upward(drpdown_POSView, "100", arrow_POSPtUpward, counteditlink, "(//table[@class='list_viewnew'])[3]//tr/td[2]");
	}
	
	
	
	public EditPOSInvoiceNumber clk_editPOSLink() throws Exception
	{
		try
		{
		 POSPt=GenericClass.getText(text_frstPOSPt);
		GenericClass.clickElement(link_POSEdit);
		
		EditPOSInvoiceNumber EPOS=PageFactory.initElements(GenericClass.driver, EditPOSInvoiceNumber.class);
		return EPOS;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	

	
	public void fn_verifyEditedPOSPrefix(int iTestCaseRow) throws Exception
	{
		try
		{
			//System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix)));
		    ArrayList<String> arr=new ArrayList<String>();
			GenericClass.selectElement(drpdown_POSView, "All");
			GenericClass.Alert_Accept();
			int count=GenericClass.tr_count(rowcount_POSTable);
		for(int i=2;i<=count+1;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("(//table[@class='list_viewnew'])[3]//tr["+i+"]//td[2]")).getText();
		    arr.add(data);
		    if(data.equals(POSPt))
		    {
		    	String prefix=GenericClass.driver.findElement(By.xpath("(//table[@class='list_viewnew'])[3]//tr["+i+"]//td[4]")).getText();
				Assert.assertEquals(prefix.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix))), true);

				String invNum=GenericClass.driver.findElement(By.xpath("(//table[@class='list_viewnew'])[3]//tr["+i+"]//td[5]")).getText();
				Assert.assertEquals(invNum.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber))), true);
	            break;
		    }
		   Assert.assertEquals(arr.contains(POSPt), true);
		
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
		 GenericClass.selectElement(drpdown_POSView, "1");
		 //GenericClass.selectElement(page_dropdown, "4");
	 	 String a=GenericClass.selectElementByvalue(drpdown_POSPage, "2");
		 String columntxt=GenericClass.getText(colm_SNo);
		 System.out.println(columntxt);
		 boolean columnobj=columntxt.contains(a);
		 System.out.println(columnobj);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public void chk_PreviousEnablity()
	{
		try
		{
		boolean value=link_POSPrevious.isDisplayed();
		Assert.assertEquals(value, true);
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	
	public void verify_viewDropdown(String DropdownValueForView)
	{
		try
		{
		GenericClass.selectElement(drpdown_POSView, DropdownValueForView);
		Integer count=GenericClass.tr_count(rowcount_POSTable);
		
		Assert.assertEquals(count.toString(), DropdownValueForView);
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	
	
	public void verify_nxtLnkEnability(String viewDDValue) throws Exception
	{

		try
		{
			GenericClass.selectElement(drpdown_POSView, viewDDValue);
			Assert.assertEquals(text_PrevNext.isDisplayed(), true);
			//Assert.assertEquals(text_PrevNext.isEnabled(), false);			
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

	
	public void verify_nextLnk(String viewDDValue) throws Exception
	{
		try{
		GenericClass.selectElement(drpdown_POSView, viewDDValue);
		Assert.assertEquals(link_POSNext.isDisplayed(), true);
		Assert.assertEquals(link_POSNext.isEnabled(), true);
		 Select select=new Select(drpdown_POSPage);
	     String selectedoption=select.getFirstSelectedOption().getText();
	     int actlvalue=Integer.parseInt(selectedoption);
	     int expvalue=actlvalue+1;
		 
		 GenericClass.clickElement(link_POSNext);
		 //System.out.println(selectedoption);
		String nexttext=select.getFirstSelectedOption().getText();
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

	
	
	public void verify_PreviousLnkEnability(String viewDDValue) throws Exception
	{

		try
		{
			GenericClass.selectElement(drpdown_POSView, viewDDValue);
			Assert.assertEquals(text_PrevNext.isDisplayed(), true);
			//Assert.assertEquals(text_PrevNext.isEnabled(), false);
			
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
	 * This method clicks on 'Previous' link on 'Amenities List' page and verifies it
	 * @throws Exception,AssertionError
	 */
	public  void verify_previousLnk() throws Exception
	{
		try
		{
		 GenericClass.selectElement(drpdown_POSView, "1");
		// GenericClass.clickElement(link_POSNext);
		 GenericClass.selectElement(drpdown_POSPage, "2");
		 Select next1=new Select(drpdown_POSPage);
		 String nextobj=next1.getFirstSelectedOption().getText();
		 int act2value=Integer.parseInt(nextobj);
		 GenericClass.clickElement(link_POSPrevious);
		 Select previous1=new Select(drpdown_POSPage);
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

	
	
	public boolean verify_defaultCustomSetting()
	{
		try
		{
		boolean value=rb_No.isSelected();
		return value;
		}
		catch(Exception e) 
		{
			throw e;
		}
	}
	
	
	public void clk_YesRBCustomSetting() throws Exception
	{
		try
		{
		GenericClass.clickElement(rb_Yes);
		GenericClass.clickElement(btn_SaveChanges);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public String verify_saveMsg()
	{
		try
		{
		String text=GenericClass.getText(txt_saveMsg);
		return text;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void clk_NoRBCustomSetting() throws Exception
	{
		try
		{
		GenericClass.clickElement(rb_No);
		GenericClass.clickElement(btn_SaveChanges);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public AuditTrailINS fn_clkAuditTrailLnk() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_AuditTrail);
		
		AuditTrailINS AT=PageFactory.initElements(GenericClass.driver, AuditTrailINS.class);
		return AT;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public EditPOSInvoiceNumber fn_clkSampleRestEdit(int iTestCaseRow) throws Exception
	{
		try
		{
/*		GenericClass.selectElement(drpdown_POSView, "All");
		GenericClass.Alert_Accept();
*/		int count=GenericClass.tr_count(rowcount_POSTable);
        for(int i=2;i<=count+1;i++)
        {
			String data=GenericClass.driver.findElement(By.xpath("(//table[@class='list_viewnew'])[3]//tr["+i+"]//td[2]")).getText();
		    if(data.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))))
		    {
		    	GenericClass.driver.findElement(By.xpath("(//table[@class='list_viewnew'])[3]//tr["+i+"]//td[6]/a")).click();
	            break;
		    }
        }
        
		EditPOSInvoiceNumber EPOS=PageFactory.initElements(GenericClass.driver, EditPOSInvoiceNumber.class);
		return EPOS;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public void fn_verifyEditedSampleRestPrefix(int iTestCaseRow) throws Exception
	{
		try
		{
			//System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix)));
		    ArrayList<String> arr=new ArrayList<String>();
			GenericClass.selectElement(drpdown_POSView, "All");
			GenericClass.Alert_Accept();
			int count=GenericClass.tr_count(rowcount_POSTable);
		for(int i=2;i<=count+1;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("(//table[@class='list_viewnew'])[3]//tr["+i+"]//td[2]")).getText();
		    arr.add(data);
		    if(data.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))))
		    	
		    {
		    	String prefix=GenericClass.driver.findElement(By.xpath("(//table[@class='list_viewnew'])[3]//tr["+i+"]//td[4]")).getText();
				Assert.assertEquals(prefix.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix))), true);

				String invNum=GenericClass.driver.findElement(By.xpath("(//table[@class='list_viewnew'])[3]//tr["+i+"]//td[5]")).getText();
				Assert.assertEquals(invNum.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber))), true);
	            break;
		    }
		
		}	
		   //Assert.assertEquals(arr.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

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
	
	public void fn_verifyBlankSampleRestPrefix(int iTestCaseRow) throws Exception
	{
		try
		{
			//System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix)));
		    ArrayList<String> arr=new ArrayList<String>();
			GenericClass.selectElement(drpdown_POSView, "All");
			GenericClass.Alert_Accept();
			int count=GenericClass.tr_count(rowcount_POSTable);
		for(int i=2;i<=count+1;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("(//table[@class='list_viewnew'])[3]//tr["+i+"]//td[2]")).getText();
		    arr.add(data);
		    if(data.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))))
		    	
		    {
		    	String prefix=GenericClass.driver.findElement(By.xpath("(//table[@class='list_viewnew'])[3]//tr["+i+"]//td[4]")).getText();
				Assert.assertEquals(prefix.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

				String invNum=GenericClass.driver.findElement(By.xpath("(//table[@class='list_viewnew'])[3]//tr["+i+"]//td[5]")).getText();
				Assert.assertEquals(invNum.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber))), true);
	            break;
		    }
		
		}	
		   //Assert.assertEquals(arr.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);

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
	
	
	
}
