package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.DisplayColors;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class DisplayColorsLandingPage
{

	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	public  WebElement heading_page;

	@FindBy(xpath="//td/input[@name='Submit322']")
	public  WebElement btn_SaveChanges;

	@FindBy(xpath="//td/input[@name='Submit3222']")
	public  WebElement btn_Cancel;

	@FindBy(xpath="//div[@id='listing-icons']//li[2]/input")
	public  WebElement btn_Save;

	@FindBy(xpath="//div[@id='listing-icons']//li[1]/input")
	public  WebElement btn_Cancel2;

	@FindBy(xpath="//tr/td/a")
 	public  WebElement link_Main;

	@FindBy(xpath="//a[text()='AuditTrail']")
	public  WebElement link_AuditTrail;

	@FindBy(xpath="//td[@class='padingtd']//th")
	public  WebElement section_ColorFD;

	@FindBy(xpath="//td[@class='padingtd']//tr[4]//th")
	public  WebElement section_HousekeepingStatus;

	@FindBy(xpath="//td[@class='padingtd']//tr[7]//th")
	public  WebElement section_AlphabetFD;

	//@FindBy(xpath="//td[@class='padingtd']//table//tr[4]//table//tr")
	@FindBy(xpath="//td[@class='padingtd']/table/tbody/tr[1]/td/table/tbody/tr[4]/td/table/tbody/tr")
	public  List<WebElement> tr_count1;

	@FindBy(xpath="//td[@class='padingtd']/table/tbody/tr[4]/td/table/tbody/tr[4]/td/table/tbody/tr")
	public  List<WebElement> count_housekeeping;

	@FindBy(xpath="//td[@class='padingtd']/table/tbody/tr[7]/td/table/tbody/tr[4]/td/table/tbody/tr")
	public  List<WebElement> count_AlphabetCode;

	@FindBy(xpath="//td[@class='error']")
	public  WebElement msg_Save;

	@FindBy(xpath="//td[@class='padingtd']//table//tr[4]//tr//div")
	public  WebElement drpdwn_ReservedRoom;

	@FindBy(xpath="//div[@class='yui-module yui-overlay']//div[2]")
	public  WebElement RR_Color1;

	@FindBy(xpath="//div[@class='yui-module yui-overlay']//div[3]")
	public  WebElement RR_Color2;

	@FindBy(xpath="//div[@class='yui-module yui-overlay']//div[8]")
	public  WebElement RR_Color3;

	@FindBy(xpath="//td[@class='padingtd']//tr[7]//table//tr[4]//table//tr")
	public  List<WebElement> tr_count2;

	@FindBy(xpath="//td[@class='padingtd']//table//tr[4]//tr[3]//div")
	public  WebElement drpdwn_CheckedinRoom;

	@FindBy(xpath="//div[@class='yui-module yui-overlay']//div[2]")
	public  WebElement CI_Color1;

	@FindBy(xpath="//td[@class='padingtd']//table//tr[4]//tr[4]//div")
	public  WebElement drpdwn_CheckedoutRoom;

	@FindBy(xpath="//div[@class='yui-module yui-overlay']//div[1]")
	public  WebElement CO_Color1;

	@FindBy(xpath="//td[@class='padingtd']//table//tr[4]//tr[5]//div")
	public  WebElement drpdwn_TempRoom;

	@FindBy(xpath="//div[@class='yui-module yui-overlay']//div[5]")
	public  WebElement Temp_Color1;

	@FindBy(xpath="//td[@class='padingtd']//table//tr[4]//tr[6]//div")
	public  WebElement drpdwn_OverbookedRoom;

	@FindBy(xpath="//div[@class='yui-module yui-overlay']//div[6]")
	public  WebElement Overbooked_Color1;

	@FindBy(xpath="//div[@id='show5']")
	public  WebElement drpdwn_TouchupRoom;

	@FindBy(xpath="//div[@id='block51']")
	public  WebElement Touchup_Color1;

	@FindBy(xpath="//div[@id='show6']")
	public  WebElement drpdwn_DirtyRoom;

	@FindBy(xpath="//div[@id='block53']")
	public  WebElement Dirty_Color1;

	@FindBy(xpath="//div[@id='show7']")
	public  WebElement drpdwn_InspectRoom;

	@FindBy(xpath="//div[@id='block52']")
	public  WebElement Inspect_Color1;

	@FindBy(xpath="//div[@id='show8']")
	public  WebElement drpdwn_CleanRoom;

	@FindBy(xpath="//div[@id='block54']")
	public  WebElement Clean_Color1;

	@FindBy(xpath="//div[@id='show9']")
	public  WebElement drpdwn_RepairRoom;

	@FindBy(xpath="//div[@id='block55']")
	public  WebElement Repair_Color1;

	@FindBy(xpath="//div[@id='show10']")
	public  WebElement drpdwn_DNRoom;

	@FindBy(xpath="//div[@id='block56']")
	public  WebElement DNR_Color1;

	@FindBy(xpath="//td[@class='padingtd']//table//tr[2]//td[3]/input")
	public  WebElement txtbx_TABooking;

	@FindBy(xpath="//td[@class='padingtd']//table//tr[3]//td[3]/input")
	public  WebElement txtbx_CorpBooking;

	@FindBy(xpath="//td[@class='padingtd']//table//tr[4]//tr[4]//td[3]/input")
	public  WebElement txtbx_OnlineWBooking;

	@FindBy(xpath="//td[@class='padingtd']//table//tr[4]//tr[5]//td[3]/input")
	public  WebElement txtbx_GroupBooking;

	@FindBy(xpath="//td[@class='padingtd']//table//tr[4]//tr[6]//td[3]/input")
	public  WebElement txtb_OtherGDSBooking;

//	@FindBy(xpath="//div[@class='yui-module yui-overlay']//div[2]")
//	public static WebElement CheckedinR_Color1;

	@FindBy(xpath="//a[text()='| Frontdesk']")
	public  WebElement link_Frontdesk;

	/**
	 *
	 * Method gets page header in a variable and verifies it
	 * @param iTestCaseRow : Is used for test data.
	 * @return
	 * @throws Exception,AssertionError
	 */


	public void fn_verifyPageHeader(int iTestCaseRow) throws Exception
	{
		try
		{
		String str=GenericClass.getText(heading_page);
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

	/**
	 *
	 * Method gets 'Manage Display Colors' page title and verifies it
	 * @param iTestCaseRow : Is used for test data.
	 * @return
	 * @throws Exception,AssertionError
	 */

	public void fn_verifyPageTitle(int iTestCaseRow) throws Exception
	{
		try
		{
			String str=GenericClass.driver.getTitle();
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

	/**
	 *
	 * Method checks display of various elements on 'Manage Display Colors' page
	 * @param iTestCaseRow : Is used for test data.
	 * @return
	 * @throws Exception,AssertionError
	 */


	public void fn_CheckElements(int iTestCaseRow) throws Exception
	{
		try
		{
             GenericClass.checkElementDisplay("Save button at top", btn_Save);
             GenericClass.checkElementDisplay("Cancel button at top", btn_Cancel2);
             GenericClass.checkElementDisplay("Save button at bottom", btn_SaveChanges);
             GenericClass.checkElementDisplay("Cancel button at bottom", btn_Cancel);
             String str1=GenericClass.getText(section_ColorFD);

             Assert.assertEquals(str1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));

             String str2=GenericClass.getText(section_HousekeepingStatus);

             Assert.assertEquals(str2, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));

             String str3=GenericClass.getText(section_AlphabetFD);

             Assert.assertEquals(str3, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		}
		catch(NoSuchElementException e)
		{
			throw e;
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}

/**
 * Method verifies color code drop down
 * under 'Select Color Coding of Room status for the Front Desk tape chart' section
 * @param
 * @return
 * @throws Exception
 */



	public void verifyDropdown_RoomStatus()
	{
		try
		{
              int count=GenericClass.tr_count(tr_count1);
              for(int i=2;i<=count;i++)
              {
            	  String text=GenericClass.driver.findElement(By.xpath("//div[@class=' yui-skin-sam']//table//tr[3]/td//tr//table//tr[4]//table//tr["+i+"]//td[2]")).getText();
            	  String atr=GenericClass.driver.findElement(By.xpath("//div[@class=' yui-skin-sam']//table//tr[3]/td//tr//table//tr[4]//table//tr["+i+"]//td[4]/div")).getAttribute("class");
                  Assert.assertEquals(atr, "drpdwn");
              }


		}
		catch(Exception e)
		{
			throw e;
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}



	/**
	 * Method verifies color code drop down
	 * under 'Select Color Coding of Housekeeping status' section
	 * @param
	 * @return
	 * @throws Exception
	 */
	public void verifyDropdown_HousekeepingStatus()
	{
		try
		{
              int count=GenericClass.tr_count(count_housekeeping);
              for(int i=2;i<=count;i++)
              {
            	  String text=GenericClass.driver.findElement(By.xpath("//div[@class=' yui-skin-sam']//table//tr[3]/td//tr[4]//table//tr[4]//table//tr["+i+"]//td[2]")).getText();
            	  String atr=GenericClass.driver.findElement(By.xpath("//div[@class=' yui-skin-sam']//table//tr[3]/td//tr[4]//table//tr[4]//table//tr["+i+"]//td[4]/div")).getAttribute("class");
                  Assert.assertEquals(atr, "drpdwn");

              }

		}
		catch(Exception e)
		{
			throw e;
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}


	/**
	 * Method verifies alphabet code textbox
	 * under 'Select Alphabet Coding for the Front Desk tape chart' section
	 * @param
	 * @return
	 * @throws Exception
	 */

	public void verifyTextbox_AlphabetCode()
	{
		try
		{
              int count=GenericClass.tr_count(count_housekeeping);
              for(int i=2;i<count-1;i++)
              {
            	  String text=GenericClass.driver.findElement(By.xpath("//div[@class=' yui-skin-sam']//table//tr[3]/td//tr[7]//table//tr[4]//table//tr["+i+"]//td[2]")).getText();
            	  String atr=GenericClass.driver.findElement(By.xpath("//div[@class=' yui-skin-sam']//table//tr[3]/td//tr[7]//table//tr[4]//table//tr["+i+"]//td[3]/input")).getAttribute("type");
                  Assert.assertEquals(atr, "text");

              }

		}
		catch(Exception e)
		{
			throw e;
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}



	/**
	 * Method clicks on 'Save Changes' button at the end of the page
	 * @param
	 * @return
	 * @throws Exception
	 */


	 public void fn_clkSaveChangesBtn() throws Exception
	 {
		 try
		 {
			 GenericClass.clickElement(btn_SaveChanges);
		 }
		 catch(NoSuchElementException e)
		 {
			 Thread.sleep(2000);
			 GenericClass.js_Click(btn_SaveChanges);
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 }


	 /**
	  *
	  * Method verifies meassage being displayed on clicking 'Save Changes' button
	  * @param
	  * @return
	  * @throws AssertionError
	  */


	 public void fn_verifySuccessfulSaveMsg(int iTestCaseRow) throws Exception
	 {
		 try
		 {
               String str=GenericClass.getText(msg_Save);
               Assert.assertEquals(str,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		 }
		 catch(AssertionError e)
		 {
			 throw e;
		 }
	 }

	 /**
	  * Method clicks on Main link and Navigates to Admine Console home page
	  * @param
	  * @returns Object of AdminHome class
	  * @throws Exception
	  */


	 public AdminHome fn_clkMainLink() throws Exception
	 {
		 try
		 {
		 GenericClass.clickElement(link_Main);
		 }
		 catch(NoSuchElementException e)
		 {
			 Thread.sleep(2000);
			 GenericClass.js_Click(link_Main);

		 }
		 catch(Exception e)
		 {
			 throw e;
		 }

		 AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
		 return AH;

	 }


	 /**
	  * Method changes Color Code for 'Reserved Rooms' and Saves it with 'Save Changes' button
	  * @param
	  * @return value of colorCode
	  * @throws Exception
	  */




	 public static String str;
	 public static String colorCode=null;

	 public String  ReservedRoom_ColorChange() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_ReservedRoom);
               GenericClass.clickElement(RR_Color1);
               str=GenericClass.driver.findElement(By.xpath("//td[@class='padingtd']//table//tr[4]//table//tr[2]//td[5]/div")).getAttribute("style");
		       colorCode=GenericClass.driver.findElement(By.xpath("//div[@class='yui-module yui-overlay']//div[2]")).getAttribute("onclick");
		       GenericClass.clickElement(btn_SaveChanges);
		 }

		 catch(Exception e)
		 {
			 throw e;
		 }
		 return colorCode;
	 }


	 /**
	  * Method verifies color change under 'Select Alphabet Coding for the Front Desk tape chart' section
	  * @param
	  * @return
      * @throws AssertionError
	  */


	 public void verify_RRColorchange()
	 {
		 try
		 {
         int count=GenericClass.tr_count(tr_count2);
         for(int i=2;i<=count;i++)
         {
        	 String atr=GenericClass.driver.findElement(By.xpath("//td[@class='padingtd']//tr[7]//table//tr[4]//table//tr["+i+"]//div[@class='rs rs1']")).getAttribute("style");
             Assert.assertEquals(atr, str);
         }
		 }
		 catch(AssertionError e)
		 {
			 throw e;
		 }
	 }

	/**
	 * Method changes Color Code for 'Reserved Rooms' and Saves it with 'Save' button
	 * @param
	 * @return value of colorCode
	 * @throws Exception
	 */



	 public String  ReservedRoom_ColorChange1() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_ReservedRoom);
               GenericClass.clickElement(RR_Color2);
               str=GenericClass.driver.findElement(By.xpath("//td[@class='padingtd']//table//tr[4]//table//tr[2]//td[5]/div")).getAttribute("style");
		       colorCode=GenericClass.driver.findElement(By.xpath("//div[@class='yui-module yui-overlay']//div[3]")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Save);
		 }

		 catch(Exception e)
		 {
			 throw e;
		 }
		 return colorCode;
	 }


	 /**
	  * Method changes Color Code for 'Checked-in Rooms' amd saves it with 'Save' button
	  * @param
	  * @return value of colorCode
	  * @throws Exception
	  */


	 public String  CheckedinRoom_ColorChange() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_CheckedinRoom);
               GenericClass.clickElement(CI_Color1);
               str=GenericClass.driver.findElement(By.xpath("//td[@class='padingtd']//table//tr[4]//table//tr[2]//td[5]/div")).getAttribute("style");
		       colorCode=GenericClass.driver.findElement(By.xpath("//div[@class='yui-module yui-overlay']//div[2]")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Save);
		 }

		 catch(Exception e)
		 {
			 throw e;
		 }
		 return colorCode;
	 }

	 /**
	  * Method changes Color Code for 'Checked-out Rooms' and saves it with 'Save' button
	  * @param
	  * @return value of colorCode
	  * @throws Exception
	  */



	 public String  CheckedoutRoom_ColorChange() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_CheckedoutRoom);
               GenericClass.clickElement(CO_Color1);
               str=GenericClass.driver.findElement(By.xpath("//td[@class='padingtd']//table//tr[4]//table//tr[2]//td[5]/div")).getAttribute("style");
		       colorCode=GenericClass.driver.findElement(By.xpath("//div[@class='yui-module yui-overlay']//div[1]")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Save);
		 }

		 catch(Exception e)
		 {
			 throw e;
		 }
		 return colorCode;
	 }

	 /**
	  * Method changes Color Code for 'Temp Rooms' and saves it with 'Save' button
	  * @param
	  * @return value of colorCode
	  * @throws Exception
	  */


	 public String  TempRoom_ColorChange() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_TempRoom);
               GenericClass.clickElement(Temp_Color1);
               str=GenericClass.driver.findElement(By.xpath("//td[@class='padingtd']//table//tr[4]//table//tr[2]//td[5]/div")).getAttribute("style");
		       colorCode=GenericClass.driver.findElement(By.xpath("//div[@class='yui-module yui-overlay']//div[5]")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Save);
		 }

		 catch(Exception e)
		 {
			 throw e;
		 }
		 return colorCode;
	 }

	 /**
	  * Method changes Color Code for 'Overbooked Rooms' and saves it with 'Save' button
	  * @param
	  * @return value of colorCode
	  * @throws Exception
	  */


	 public String  OverbookedRoom_ColorChange() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_OverbookedRoom);
               GenericClass.clickElement(Overbooked_Color1);
               str=GenericClass.driver.findElement(By.xpath("//td[@class='padingtd']//table//tr[4]//table//tr[2]//td[5]/div")).getAttribute("style");
		       colorCode=GenericClass.driver.findElement(By.xpath("//div[@class='yui-module yui-overlay']//div[6]")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Save);
		 }

		 catch(Exception e)
		 {
			 throw e;
		 }
		 return colorCode;
	 }

    /**
     * Method  changes Color Code for 'Touch-up Rooms' and saves it with 'Save' button
     * @param
     * @return value of colorCode
     * @throws Exception
     */

	 public String  TouchupRoom_ColorChange() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_TouchupRoom);
               GenericClass.clickElement(Touchup_Color1);
               str=GenericClass.driver.findElement(By.xpath("//div[@id='clrblock5']")).getAttribute("style");
		       colorCode=GenericClass.driver.findElement(By.xpath("//div[@id='block51']")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Save);
		 }

		 catch(Exception e)
		 {
			 Thread.sleep(2000);
			 GenericClass.js_Click(drpdwn_TouchupRoom);
             GenericClass.js_Click(Touchup_Color1);
             str=GenericClass.driver.findElement(By.xpath("//div[@id='clrblock5']")).getAttribute("style");
		     colorCode=GenericClass.driver.findElement(By.xpath("//div[@id='block51']")).getAttribute("onclick");
		     GenericClass.js_Click(btn_Save);

		 }
		 return colorCode;
	 }

	 /**
	  * Method  changes Color Code for 'Dirty Rooms' and saves it with 'Save' button
	  * @param
	  * @return value of colorCode
	  * @throws Exception
	  */

	 public String  DirtyRoom_ColorChange() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_DirtyRoom);
               GenericClass.clickElement(Dirty_Color1);
               str=GenericClass.driver.findElement(By.xpath("//div[@id='clrblock6']")).getAttribute("style");
		       colorCode=GenericClass.driver.findElement(By.xpath("//div[@id='block53']")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Save);
		 }

		 catch(Exception e)
		 {
			 Thread.sleep(2000);
			 GenericClass.js_Click(drpdwn_DirtyRoom);
             GenericClass.js_Click(Dirty_Color1);
             str=GenericClass.driver.findElement(By.xpath("//div[@id='clrblock6']")).getAttribute("style");
		     colorCode=GenericClass.driver.findElement(By.xpath("//div[@id='block53']")).getAttribute("onclick");
		     GenericClass.js_Click(btn_Save);

		 }
		 return colorCode;
	 }


	 /**
	  * Method  changes Color Code for 'Inspect Rooms' and saves it with 'Save' button
	  * @param
	  * @return value of colorCode
	  * @throws Exception
	  */
	 public String  InspectRoom_ColorChange() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_InspectRoom);
               GenericClass.clickElement(Inspect_Color1);
               str=GenericClass.driver.findElement(By.xpath("//div[@id='clrblock7']")).getAttribute("style");
		       colorCode=GenericClass.driver.findElement(By.xpath("//div[@id='block52']")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Save);
		 }

		 catch(Exception e)
		 {
			 Thread.sleep(2000);
			 GenericClass.js_Click(drpdwn_InspectRoom);
             GenericClass.js_Click(Inspect_Color1);
             str=GenericClass.driver.findElement(By.xpath("//div[@id='clrblock7']")).getAttribute("style");
		     colorCode=GenericClass.driver.findElement(By.xpath("//div[@id='block52']")).getAttribute("onclick");
		     GenericClass.js_Click(btn_Save);

		 }
		 return colorCode;
	 }

	 /**
	  * Method  changes Color Code for 'Clean Rooms' and saves it with 'Save' button
	  * @param
	  * @return value of colorCode
	  * @throws Exception
	  */
	 public String  CleanRoom_ColorChange() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_CleanRoom);
               GenericClass.clickElement(Clean_Color1);
               str=GenericClass.driver.findElement(By.xpath("//div[@id='clrblock8']")).getAttribute("style");
		       colorCode=GenericClass.driver.findElement(By.xpath("//div[@id='block54']")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Save);
		 }

		 catch(Exception e)
		 {
			 Thread.sleep(2000);
			 GenericClass.js_Click(drpdwn_CleanRoom);
             GenericClass.js_Click(Clean_Color1);
             str=GenericClass.driver.findElement(By.xpath("//div[@id='clrblock8']")).getAttribute("style");
		     colorCode=GenericClass.driver.findElement(By.xpath("//div[@id='block54']")).getAttribute("onclick");
		     GenericClass.js_Click(btn_Save);

		 }
		 return colorCode;
	 }

	 /**
	  * Method  changes Color Code for 'Repair Rooms' and saves it with 'Save' button
	  * @param
	  * @return value of colorCode
	  * @throws Exception
	  */

	 public String  RepairRoom_ColorChange() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_RepairRoom);
               GenericClass.clickElement(Repair_Color1);
               str=GenericClass.driver.findElement(By.xpath("//div[@id='clrblock9']")).getAttribute("style");
		       colorCode=GenericClass.driver.findElement(By.xpath("//div[@id='block55']")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Save);
		 }

		 catch(Exception e)
		 {
			 Thread.sleep(2000);
			 GenericClass.js_Click(drpdwn_RepairRoom);
             GenericClass.js_Click(Repair_Color1);
             str=GenericClass.driver.findElement(By.xpath("//div[@id='clrblock9']")).getAttribute("style");
		     colorCode=GenericClass.driver.findElement(By.xpath("//div[@id='block55']")).getAttribute("onclick");
		     GenericClass.js_Click(btn_Save);

		 }
		 return colorCode;
	 }


	 /**
	  * Method  changes Color Code for 'Do Not Reserve (DNR)' and saves it with 'Save' button
	  * @param
	  * @return value of colorCode
	  * @throws Exception
	  */

	 public String  DNRoom_ColorChange() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_DNRoom);
               GenericClass.clickElement(DNR_Color1);
               str=GenericClass.driver.findElement(By.xpath("//div[@id='clrblock10']")).getAttribute("style");
		       colorCode=GenericClass.driver.findElement(By.xpath("//div[@id='block56']")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Save);
		 }

		 catch(Exception e)
		 {
			 Thread.sleep(2000);
			 GenericClass.js_Click(drpdwn_DNRoom);
             GenericClass.js_Click(DNR_Color1);
             str=GenericClass.driver.findElement(By.xpath("//div[@id='clrblock10']")).getAttribute("style");
		     colorCode=GenericClass.driver.findElement(By.xpath("//div[@id='block56']")).getAttribute("onclick");
		     GenericClass.js_Click(btn_Save);

		 }
		 return colorCode;
	 }

	 public static String Code;


	 /**
	  *
	  * Method changes alphabet code for TA Booking and saves it
	  * @param iTestCaseRow : Is used for test data.
	  * @return
	  * @throws Exception
	  */
	 public void TABooking_codeChange(int iTestCaseRow) throws Exception
	 {

		 try
		 {
		 GenericClass.sendKeys(txtbx_TABooking, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AlphabetCodeFD)));
		 GenericClass.clickElement(btn_Save);
		 }
		 catch(NoSuchElementException e)
		 {
			 GenericClass.js_Click(btn_Save);
		 }
	 }

    /**
     *
     * Method fetches changes code and verifies it
     * @param iTestCaseRow : Is used for test data.
     * @return value of Code
     * @throws Exception
     */
     public String verify_TACodeChange(int iTestCaseRow) throws Exception
     {
    	 try
    	 {
    		 Code=GenericClass.driver.findElement(By.xpath("//div[@id='travelAgentBooking']")).getText();
         Assert.assertTrue(Code.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AlphabetCodeFD))));
    	 }
    	 catch(AssertionError e)
    	 {
    		 throw e;
    	 }
         return Code;
     }


     /**
	  *
	  * Method changes alphabet code for Corporate Booking and saves it
	  * @param iTestCaseRow : Is used for test data.
	  * @return
	  * @throws Exception
	  */
	 public void CorporateBooking_codeChange(int iTestCaseRow) throws Exception
	 {

		 try
		 {
		 GenericClass.sendKeys(txtbx_CorpBooking, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AlphabetCodeFD)));
		 GenericClass.clickElement(btn_Save);
		 }
		 catch(NoSuchElementException e)
		 {
			 GenericClass.js_Click(btn_Save);
		 }
	 }


	 /**
     *
     * Method fetches changes code and verifies it
     * @param iTestCaseRow : Is used for test data.
     * @return value of Code
     * @throws Exception
     */
     public String verify_CorpCodeChange(int iTestCaseRow) throws Exception
     {
    	 try
    	 {
    		 Code=GenericClass.driver.findElement(By.xpath("//div[@id='corporateBooking']")).getText();
         Assert.assertTrue(Code.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AlphabetCodeFD))));
    	 }
    	 catch(AssertionError e)
    	 {
    		 throw e;
    	 }
         return Code;
     }



	 /**
	  *
	  * Method changes alphabet code for Online/Web Booking and saves it
	  * @param iTestCaseRow : Is used for test data.
	  * @return
	  * @throws Exception
	  */
	 public void OnlineWebBooking_codeChange(int iTestCaseRow) throws Exception
	 {

		 try
		 {
		 GenericClass.sendKeys(txtbx_OnlineWBooking, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AlphabetCodeFD)));
		 GenericClass.clickElement(btn_Save);
		 }
		 catch(NoSuchElementException e)
		 {
			 GenericClass.js_Click(btn_Save);
		 }
	 }


	 /**
     *
     * Method fetches changes code and verifies it
     * @param iTestCaseRow : Is used for test data.
     * @return value of Code
     * @throws Exception
     */
     public String verify_OnlineCodeChange(int iTestCaseRow) throws Exception
     {
    	 try
    	 {
    		 Code=GenericClass.driver.findElement(By.xpath("//div[@id='onlineWebBooking']")).getText();
         Assert.assertTrue(Code.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AlphabetCodeFD))));
    	 }
    	 catch(AssertionError e)
    	 {
    		 throw e;
    	 }
         return Code;
     }

	 /**
	  *
	  * Method changes alphabet code for Group Booking and saves it
	  * @param iTestCaseRow : Is used for test data.
	  * @return
	  * @throws Exception
	  */
	 public void GroupBooking_codeChange(int iTestCaseRow) throws Exception
	 {

		 try
		 {
		 GenericClass.sendKeys(txtbx_GroupBooking, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AlphabetCodeFD)));
		 GenericClass.clickElement(btn_Save);
		 }
		 catch(NoSuchElementException e)
		 {
			 GenericClass.js_Click(btn_Save);
		 }
	 }

	 /**
     *
     * Method fetches changes code and verifies it
     * @param iTestCaseRow : Is used for test data.
     * @return value of Code
     * @throws Exception
     */
     public String verify_GroupCodeChange(int iTestCaseRow) throws Exception
     {
    	 try
    	 {
    		 Code=GenericClass.driver.findElement(By.xpath("//div[@id='groupBookingCode']")).getText();
         Assert.assertTrue(Code.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AlphabetCodeFD))));
    	 }
    	 catch(AssertionError e)
    	 {
    		 throw e;
    	 }
         return Code;
     }



	 /**
	  *
	  * Method changes alphabet code for Group Booking and saves it
	  * @param iTestCaseRow : Is used for test data.
	  * @return
	  * @throws Exception
	  */
	 public void OtherGDSBooking_codeChange(int iTestCaseRow) throws Exception
	 {

		 try
		 {
		 GenericClass.sendKeys(txtb_OtherGDSBooking, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AlphabetCodeFD)));
		 GenericClass.clickElement(btn_Save);
		 }
		 catch(NoSuchElementException e)
		 {
			 GenericClass.js_Click(btn_Save);
		 }
	 }

	 /**
     *
     * Method fetches changes code and verifies it
     * @param iTestCaseRow : Is used for test data.
     * @return value of Code
     * @throws Exception
     */
     public String verify_OtherGDSCodeChange(int iTestCaseRow) throws Exception
     {
    	 try
    	 {
    		 Code=GenericClass.driver.findElement(By.xpath("//div[@id='otherBookingCode']")).getText();
         Assert.assertTrue(Code.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AlphabetCodeFD))));
    	 }
    	 catch(AssertionError e)
    	 {
    		 throw e;
    	 }
         return Code;
     }


     /**
     *
     * Method gets code for Reserved and Assigned rooms in a variable Code
     * @param
     * @return value of Code
     * @throws Exception
     */
     public String get_ReservedAssignedCodeChange() throws Exception
     {
    	 try
    	 {
    		 Code=GenericClass.driver.findElement(By.xpath("//div[@id='reserveAssignRoom']/span")).getText();
             //Assert.assertTrue(Code.contains(ExcelUtil.getCellData(iTestCaseRow, Constant.Col_AlphabetCodeFD)));
    	 }
    	 catch(Exception e)
    	 {
    		 throw e;
    	 }
         return Code;
     }


     /**
      * This method changes color code for Reserved Rooms under 'Select Color Coding of Room status for the Front Desk tape chart' section
      * Clicks on 'Cancel' button at the bottom of 'Manage Display Colors' page
      * @param
      * @return
      * @throws Exception
      */
     public void  ReservedRoom_ColorChangeCancel() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_ReservedRoom);
               GenericClass.clickElement(RR_Color1);
              // str=GenericClass.driver.findElement(By.xpath("//td[@class='padingtd']//table//tr[4]//table//tr[2]//td[5]/div")).getAttribute("style");
		       //colorCode=GenericClass.driver.findElement(By.xpath("//div[@class='yui-module yui-overlay']//div[3]")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Cancel);
		 }

		 catch(NoSuchElementException e)
		 {
			 Thread.sleep(2000);
			 GenericClass.js_Click(drpdwn_ReservedRoom);
			 GenericClass.js_Click(RR_Color1);
			 GenericClass.js_Click(btn_Cancel);
		 }

	 }



     /**
      * This method changes color code for Reserved Rooms under 'Select Color Coding of Room status for the Front Desk tape chart' section
      * Clicks on 'Cancel' button at the top right corner of 'Manage Display Colors' page
      * @param
      * @return
      * @throws Exception
      */
     public void  ReservedRoom_ColorChangeCancelTop() throws Exception
	 {
		 try
		 {
               GenericClass.clickElement(drpdwn_ReservedRoom);
               GenericClass.clickElement(RR_Color1);
              // str=GenericClass.driver.findElement(By.xpath("//td[@class='padingtd']//table//tr[4]//table//tr[2]//td[5]/div")).getAttribute("style");
		       //colorCode=GenericClass.driver.findElement(By.xpath("//div[@class='yui-module yui-overlay']//div[3]")).getAttribute("onclick");
		       GenericClass.clickElement(btn_Cancel2);
		 }

		 catch(NoSuchElementException e)
		 {
			 Thread.sleep(2000);
			 GenericClass.js_Click(drpdwn_ReservedRoom);
			 GenericClass.js_Click(RR_Color1);
			 GenericClass.js_Click(btn_Cancel2);
		 }

	 }



     /**
      * This method clicks on Audit Trail link and navigates to 'Audit Trail - Displaycolor' window
      * @param
      * @return Object of DisplayColorsAuditTrail class
      * @throws Exception
      */
     public DisplayColorsAuditTrail click_AuditTrailLnk() throws Exception
     {
    	 try
    	 {
    	 GenericClass.clickElement(link_AuditTrail);
    	 }
    	 catch(NoSuchElementException e)
    	 {
    		 Thread.sleep(2000);
    		 GenericClass.js_Click(link_AuditTrail);
    	 }
    	 DisplayColorsAuditTrail DCAT=PageFactory.initElements(GenericClass.driver, DisplayColorsAuditTrail.class);
    	 return DCAT;
     }


     /**
      * Method gets color code corresponding to Checked-in rooms before any change in code
      * @param
      * @return
      * @throws Exception
      */
     public void fn_getColorCode() throws Exception
     {
    	 try
    	 {
    	 GenericClass.clickElement(drpdwn_CheckedinRoom);
         str=GenericClass.driver.findElement(By.xpath("//td[@class='padingtd']//table//tr[4]//table//tr[2]//td[5]/div")).getAttribute("style");
	     String a=GenericClass.driver.findElement(By.xpath("//div[@class='yui-module yui-overlay']//div[2]")).getAttribute("onclick");
	     String[] parts=a.split("'");
	     colorCode=parts[1];
    	 }
    	 catch(Exception e)
    	 {
    		 throw e;
    	 }

     }

     public static String str1;
	 public static String colorCode1;


	 /**
	  * Method changes Checked-in Room's display color  and gets code in a variable colorCode1
	  * @param
	  * @return
	  * @throws Exception
	  */
     public void ChangeColor_AuditTrail() throws Exception
     {
    	 try
    	 {
    	 GenericClass.clickElement(drpdwn_CheckedinRoom);
         GenericClass.clickElement(RR_Color3);
         str1=GenericClass.driver.findElement(By.xpath("//td[@class='padingtd']//table//tr[4]//table//tr[2]//td[5]/div")).getAttribute("style");
	     String b=GenericClass.driver.findElement(By.xpath("//div[@class='yui-module yui-overlay']//div[8]")).getAttribute("onclick");
	     String[] parts=b.split("'");
	     colorCode1=parts[1];
	     GenericClass.clickElement(btn_Save);
    	 }
    	 catch(NoSuchElementException e)
    	 {
    		 GenericClass.js_Click(drpdwn_CheckedinRoom);
    		 GenericClass.js_Click(RR_Color3);
    		 String b=GenericClass.driver.findElement(By.xpath("//div[@class='yui-module yui-overlay']//div[8]")).getAttribute("onclick");
    	     String[] parts=b.split("'");
    	     colorCode1=parts[1];
    	     GenericClass.js_Click(btn_Save);
    	 }
     }
}
