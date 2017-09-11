package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class SortAmenitiesPage
{

	@FindBy(xpath="//table[@class='table-content']//tr")
	public  List<WebElement> row_count;

	@FindBy(xpath="//tr/td[@class='page-heading']")
	public WebElement header_page;
	
	@FindBy(xpath="//input[@name='Submit332']")
	public  WebElement btn_Save;
	
	@FindBy(xpath="//input[@name='Submit3322']")
	public  WebElement btn_Cancel;
	
	@FindBy(xpath="//table[@class='table-content']//td[2]")
	public WebElement col_Amenities;
	
	@FindBy(xpath="//table[@class='table-content']//td[3]")
	public WebElement col_SortOder;
	
	@FindBy(xpath="//tr//td[3]/input")
	public static WebElement order_txtfield;
	
	ArrayList<String> l2=new ArrayList<String>();


	public String verify_pageHeader() throws Exception
	{
		try
		{
		String str=GenericClass.getText(header_page);
        return str;
		}		
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public  void verify_SortAmenitiesPage(int iTestCaseRow) throws Exception
	{
		try
		{
		GenericClass.checkElementDisplay("Save",btn_Save);
		GenericClass.checkElementDisplay("Cancel",btn_Cancel);
		String exp1=GenericClass.getText(col_Amenities);
		Assert.assertEquals(exp1,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		String exp2=GenericClass.getText(col_SortOder);
		Assert.assertEquals(exp2, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		}
		catch(AssertionError e){
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	/**
	 * This method calculates count of row count on SortAmenitiesPage
	 * Store amenity's name in an Array list 'l2' in order to verify attached amenities
	 * @return l2: Array List of amenities to a room type
	 * @throws Exception
	 */
	public ArrayList<String> fn_getAmenitiesName()
	{
		try
		{
		int count=GenericClass.tr_count(row_count);
        for(int i=3;i<count;i++)
        {
        	String str=GenericClass.driver.findElement(By.xpath("//table[@class='table-content']//tr["+i+"]//td[2]")).getText();
        	l2.add(str);
        }
      return l2;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	/**
	 * This method compares values contained in two Array List 'l2' and 'l1'
	 * Verifies whether amenities attached to a room type are being displayed or not
	 * @throws AssertionError,Exception
	 */
	public void verify_RTAmenities()
	{
		try
		{
		Assert.assertEquals(l2, AddRoomTypePage.l1);
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
	
	/*public void verify_RTAmenities1()
	{
		try
		{
		Assert.assertEquals(l2, EditRoomType.l1);
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}*/
	
	
	public  RoomTypesLandingPage fn_SaveSortAmenities(int iTestCaseRow) throws Exception
	{
		
		try
		{
		GenericClass.clickElement(order_txtfield);
		order_txtfield.clear();
		GenericClass.sendKeys(order_txtfield, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_SortOrder)));
		GenericClass.clickElement(btn_Save);
		
		RoomTypesLandingPage RTLPpageObj = PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RTLPpageObj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public static String RTName;
	
	public String fn_getRTName()
	{
		try
		{
		String str=GenericClass.getText(header_page);
        String[] arr=str.split(" ");
        RTName=arr[3];
        
        return RTName;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public RoomTypesLandingPage fn_clkCancelBtn() throws Exception
	{
		try
		{
		GenericClass.clickElement(btn_Cancel);
		RoomTypesLandingPage RTP=PageFactory.initElements(GenericClass.driver, RoomTypesLandingPage.class);
		return RTP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
