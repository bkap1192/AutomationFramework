package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Blocks;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.TestNG;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors.FloorsLandingPage;

public class AddBlockPage {


	public static BlocksLandingPage BLP=null;


	public static String value;

	@FindBy(xpath="//div[@id='popup_head']")
	public WebElement AddEditaBlock_title;

	@FindBy(xpath="//table[@class='popup_inner']//td[2]/input")
	public WebElement titleOfBlock_txt;

	@FindBy(xpath="//input[@value='Save']")
	public WebElement Save_btn;

	@FindBy(xpath="//input[@value='Cancel']")
	public WebElement Cancel_btn;

	@FindBy(xpath="//div[@class='padingtd']//td[@class='error']")
	public WebElement errorMessage;


	//public static String block_nme=GenericClass.generateRandomString();
    public static String block_nme;
    public static String  edited=GenericClass.generateRandomString();



    //private static AddBlockPage ABP=null;

	//private static BlockLandingPage BLPO=PageFactory.initElements(GenericClass.driver, BlockLandingPage.class);

	/**
	 * Input title name and click on save button.
	 * @return
	 * @throws Exception
	 */
	public String SaveBlockTitle() throws Exception{
		try{
		block_nme=GenericClass.generateRandomString();
		GenericClass.sendKeys(titleOfBlock_txt,block_nme);
		GenericClass.clickElement(Save_btn);
		}catch(Exception e){
			throw e;
		}
		return block_nme;
		}

	/**
	 * Input Duplicate block name and get error message.
	 * @param blockname
	 * @return  Error massage.
	 * @throws Exception
	 */
	public String SaveDuplTitle(String blockname) throws Exception{
		try{
		GenericClass.sendKeys(titleOfBlock_txt,blockname);
		GenericClass.clickElement(Save_btn);
		String error=GenericClass.getText(errorMessage);
		return error;
		}catch(Exception e){
			throw e;
		}
	    }

	/**
	 * To verify cancel and save button.
	 */
	public void fn_VerifyElements(){
		try{
			Assert.assertEquals(Cancel_btn.isDisplayed() && Cancel_btn.isEnabled(), true);
			Assert.assertEquals(Save_btn.isDisplayed() && Save_btn.isEnabled(), true);
		}catch(Exception e){
			throw e;
		}catch(AssertionError e){
			throw e;
		}
	    }
	
	public BlocksLandingPage AddingBlock(int iTestCaseRow,String Workbook) throws Exception{
		ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_BlockName),Workbook);
		GenericClass.sendKeys(titleOfBlock_txt, ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_BlockName)));
		GenericClass.clickElement(Save_btn);
		BlocksLandingPage BLP=PageFactory.initElements(GenericClass.driver, BlocksLandingPage.class);
		return BLP;
				
		}


	public BlocksLandingPage verify_AddBlockPage() throws Exception{
		String title=GenericClass.driver.getTitle();
		Assert.assertEquals(title, "Add Block");
		GenericClass.checkElementDisplay("Save", Save_btn);
		GenericClass.checkElementDisplay("Cancel", Cancel_btn);
		GenericClass.clickElement(Cancel_btn);
		return BLP;
	}
	
	/**
	 * Click on Save button without input data.
	 * @param Alerthandl
	 * @return
	 * @throws Exception
	 */
	public BlocksLandingPage save_btn(String Alerthandl) throws Exception{
		try{
        GenericClass.clickElement(Save_btn);
		GenericClass.ActionOnAlert(Alerthandl);
		GenericClass.driver.close();
		}catch(Exception e){
			throw e;
		}
		return BLP;
	   }

	/**
	 * Input data and click on cancel button.
	 * @param blockname
	 * @return
	 * @throws Exception
	 */
	public BlocksLandingPage cancelbtnData(String blockname) throws Exception{
		try{
		GenericClass.sendKeys(titleOfBlock_txt, blockname);
		GenericClass.clickElement(Cancel_btn);
		}catch(Exception e){
			throw e;
		}
		return BLP;
	    }

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String modifytitle() throws Exception{
     try{
    	 GenericClass.clickElement(titleOfBlock_txt);
	     GenericClass.sendKeys(titleOfBlock_txt, edited);
         GenericClass.clickElement(Save_btn);
     }catch(Exception e){
    	 throw e;
     }
	  return edited;
	}

	/**
	 * Modified block name and Click on cancel button.
	 * @return
	 * @throws Exception
	 */
	public String edit_cancel() throws Exception{
		try{
		GenericClass.sendKeys(titleOfBlock_txt, edited);
	    GenericClass.clickElement(Cancel_btn);
		}catch(Exception e){
			throw e;
		}
		return edited;
	}

	/**
	 * Click on cancel button.
	 * @return
	 * @throws Exception 
	 */
	public BlocksLandingPage Cancel() throws Exception{
		try{
		GenericClass.clickElement(Cancel_btn);
		}catch(NoSuchElementException e){
			Thread.sleep(2000);
			GenericClass.fn_ActionsClick(Cancel_btn);
		}catch(Exception e){
			throw e;
		}
		return BLP;
		}

	public void validation_check() throws Exception
	{
	GenericClass.clickElement(Save_btn);
	GenericClass.checkElementDisplay("Messsage",errorMessage);
	GenericClass.driver.close();
	}

}
