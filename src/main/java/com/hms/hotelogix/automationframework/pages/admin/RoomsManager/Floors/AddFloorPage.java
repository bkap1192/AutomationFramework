package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AddFloorPage
{
	
	//FloorLandingPage FLP;
	AddFloorPage AFP;
	public static String value;
	public static String editFloor;
	public static String edtdFloor;




	@FindBy(xpath="//div[text()='Add/Edit a floor']")
	public WebElement Title;
	
	@FindBy(xpath="//input[@class='input-style3']")
	public WebElement Title_Box;
	
	@FindBy(xpath="//input[@value='Save']")
	public WebElement Save_Btn;
	
	@FindBy(xpath="//input[@value='Cancel']")
	public WebElement Cancel_Btn;
	
	@FindBy(xpath="//td[@class='error']")
	public WebElement Duplicate_Msg;
	
	@FindBy(xpath="//input[@name='floorName']")
    public WebElement TxtBx_FloorName;

    @FindBy(xpath="//input[@value='Save']")
    public WebElement Btn_Save;
    
    



    public FloorsLandingPage AddingFloor(int iTestCaseRow,String WorkBook) throws Exception{
    	ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_FloorName),WorkBook);
    	GenericClass.sendKeys(TxtBx_FloorName, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_FloorName)));
    	GenericClass.clickElement(Btn_Save);
    	FloorsLandingPage FLP=PageFactory.initElements(GenericClass.driver, FloorsLandingPage.class);
    	return FLP;

    	}



public FloorsLandingPage fn_AddFloor(String floorname, WebElement saveorcancelbutton) throws Exception{
	try{
		GenericClass.sendKeys(TxtBx_FloorName, floorname);
		GenericClass.clickElement(saveorcancelbutton);
		}catch(Exception e){
			throw e;
		}
		FloorsLandingPage FLP=PageFactory.initElements(GenericClass.driver, FloorsLandingPage.class);
		return FLP;
   }


	public String fn_Editfloor(WebElement element, String sValue) throws Exception{
		try{
			GenericClass.sendKeys(element, sValue);
			GenericClass.clickElement(Save_Btn);
			return sValue;
		}catch(Exception e){
			throw e;
		}
	    }

}
