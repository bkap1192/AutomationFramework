package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Amenities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class EditAmenity {

	@FindBy(xpath="//tbody/tr//td/input")
	public  WebElement amenityName;
	
	@FindBy(xpath="//div//input[@name='Submit52']")
	public WebElement btn_CancelTop;
	
	@FindBy(xpath="//td/input[@name='Submit5']")
	public  WebElement btn_SaveBottom;
	
	public String amntyName;
	
	public AmenitiesLandingPage fn_editCancelRT() throws Exception
	{
		try
		{
			amntyName=GenericClass.generateRandomString();
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AmenitiesTitle), Workbook);
		GenericClass.sendKeys(amenityName, amntyName);
		GenericClass.clickElement(btn_CancelTop);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(1000);
			//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AmenitiesTitle), Workbook);
			GenericClass.sendKeys(amenityName, amntyName);
			GenericClass.js_Click(btn_CancelTop);
		}
		catch(Exception e)
		{
			throw e;
		}
		AmenitiesLandingPage ALP=PageFactory.initElements(GenericClass.driver,AmenitiesLandingPage.class);
		return ALP;

	}
	
	
	public AmenitiesLandingPage fn_EditAmenity() throws Exception
	{
		try
		{
			amntyName=GenericClass.generateRandomString();
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AmenitiesTitle), Workbook);
		GenericClass.sendKeys(amenityName, amntyName);

		GenericClass.clickElement(btn_SaveBottom);
		}
		catch(Exception e)
		{
			throw e;
		}

		AmenitiesLandingPage ALP=PageFactory.initElements(GenericClass.driver,AmenitiesLandingPage.class);
		return ALP;
	}
	
	
}
