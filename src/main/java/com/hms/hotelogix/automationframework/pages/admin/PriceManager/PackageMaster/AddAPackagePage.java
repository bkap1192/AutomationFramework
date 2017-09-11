package com.hms.hotelogix.automationframework.pages.admin.PriceManager.PackageMaster;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AddAPackagePage {

	@FindBy(name="pkgNameMulTang[]")
	public  WebElement NamethePackage_ED;

	@FindBy(name="pkgShortName")
	public  WebElement PackageShortName_ED;

	@FindBy(name="minStay")
	public  WebElement LengthofStay_ED;

	@FindBy(name="descriptionMulTang[]")
	public  WebElement Description_ED;
	
	@FindBy(xpath="//input[@value='Save']")
	public  WebElement Save_BT;
	
	public static  String pkgName;
	
	public  void fillPkgDetails(int iTestCaseRow,String NoOfNights) throws Exception
	{
        try
        {
		GenericClass.sendKeys(LengthofStay_ED, NoOfNights);
        pkgName=GenericClass.generateRandomString();
		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PackageName), Workbook);
		GenericClass.sendKeys(NamethePackage_ED, pkgName);

		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PackageShortName), Workbook);
		GenericClass.sendKeys(PackageShortName_ED, pkgName);


		//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PackageDescription), Workbook);
		GenericClass.sendKeys(Description_ED, pkgName);


        }
        catch(Exception e)
        {
        	throw e;
        }
	}

	
	public  PackageMasterListPage clickOnSave() throws Exception
	{
		try
		{
			GenericClass.clickElement(Save_BT);
			PackageMasterListPage PML=PageFactory.initElements(GenericClass.driver, PackageMasterListPage.class);
			return PML;
		}
		catch(Exception e)
		{
			throw e;
		}
   }
}
