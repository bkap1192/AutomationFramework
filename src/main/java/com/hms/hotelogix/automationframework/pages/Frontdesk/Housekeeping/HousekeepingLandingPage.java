package com.hms.hotelogix.automationframework.pages.Frontdesk.Housekeeping;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.DisplayColors.DisplayColorsLandingPage;

public class HousekeepingLandingPage {

	@FindBy(xpath="(//div[@class='technology closedlanguage'])[2]")
	public  WebElement img_RRColorCode;

	@FindBy(xpath="//div[@class='thelanguage']//td[1]")
	public  WebElement RR_code;

	@FindBy(xpath="//div[@class='thelanguage']//tr[2]//td")
	public  WebElement CIR_code;

	@FindBy(xpath="//div[@class='thelanguage']//tr[6]//td")
	public  WebElement COR_code;

	@FindBy(xpath="(//div[@class='technology closedlanguage'])[3]")
	public  WebElement img_HSLegends;

	@FindBy(xpath="//div[@id='bodyContainer']//table//tr[13]//table//tr[2]/td")
	public  WebElement Touchup_colorCode;

	@FindBy(xpath="//div[@id='bodyContainer']//table//tr[13]//table//tr[1]/td")
	public  WebElement Dirty_colorCode;

	@FindBy(xpath="//div[@id='bodyContainer']//table//tr[13]//table//tr[5]/td")
	public  WebElement Inspect_colorCode;

	@FindBy(xpath="//div[@id='bodyContainer']//table//tr[13]//table//tr[6]/td")
	public  WebElement Clean_colorCode;

	@FindBy(xpath="//div[@id='bodyContainer']//table//tr[13]//table//tr[7]/td")
	public  WebElement Repair_colorCode;
	
	@FindBy(xpath="//div[@class='thelanguage']//tr[4]//td")
	public  WebElement DNR_colorCode1;

	@FindBy(xpath="//div[@id='bodyContainer']//table//tr[13]//table//tr[3]/td")
	public  WebElement DNR_colorCode2;
	
	@FindBy(xpath="//tbody[@class='yui-dt-data']/tr")
	public List<WebElement> AllRooms;
	
	public void verify_RRColorCode() throws Exception
	{
		try
		{
			Thread.sleep(2000);
	   GenericClass.js_Click(img_RRColorCode);
	//   Actions actobj=new Actions(GenericClass.driver);
	//   actobj.moveToElement(img_RRColorCode);
	//   Thread.sleep(2000);
	//   actobj.click().build().perform();
	   Thread.sleep(2000);
	   String code=RR_code.getAttribute("bgcolor");
	   String[] code1=code.split("#");
	   String part=code1[1];
	   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
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
	
	public void verify_CIRColorCode() throws Exception
	{
		try
		{
			Thread.sleep(2000);
	   GenericClass.js_Click(img_RRColorCode);
	//   Actions actobj=new Actions(GenericClass.driver);
	//   actobj.moveToElement(img_RRColorCode);
	//   Thread.sleep(2000);
	//   actobj.click().build().perform();
	   Thread.sleep(2000);
	   String code=CIR_code.getAttribute("bgcolor");
	   String[] code1=code.split("#");
	   String part=code1[1];
	   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(NoSuchElementException e)
		{
			GenericClass.clickElement(img_RRColorCode);
			 Thread.sleep(2000);
			   String code=CIR_code.getAttribute("bgcolor");
			   String[] code1=code.split("#");
			   String part=code1[1];
			   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	
	public void verify_CORColorCode() throws Exception
	{
		try
		{
			Thread.sleep(2000);
	   GenericClass.js_Click(img_RRColorCode);
	//   Actions actobj=new Actions(GenericClass.driver);
	//   actobj.moveToElement(img_RRColorCode);
	//   Thread.sleep(2000);
	//   actobj.click().build().perform();
	   Thread.sleep(2000);
	   String code=COR_code.getAttribute("bgcolor");
	   String[] code1=code.split("#");
	   String part=code1[1];
	   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(NoSuchElementException e)
		{
			GenericClass.clickElement(img_RRColorCode);
			Thread.sleep(2000);
			   String code=COR_code.getAttribute("bgcolor");
			   String[] code1=code.split("#");
			   String part=code1[1];
			   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}

	
	
	public void verify_TouchupColorCode() throws Exception
	{
		try
		{
			Thread.sleep(2000);
	   GenericClass.js_Click(img_HSLegends);
	//   Actions actobj=new Actions(GenericClass.driver);
	//   actobj.moveToElement(img_RRColorCode);
	//   Thread.sleep(2000);
	//   actobj.click().build().perform();
	   Thread.sleep(2000);
	   String code=Touchup_colorCode.getAttribute("bgcolor");
	   String[] code1=code.split("#");
	   String part=code1[1];
	   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(NoSuchElementException e)
		{
			GenericClass.clickElement(img_HSLegends);
			Thread.sleep(2000);
			   String code=Touchup_colorCode.getAttribute("bgcolor");
			   String[] code1=code.split("#");
			   String part=code1[1];
			   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	
	public void verify_DirtyColorCode() throws Exception
	{
		try
		{
			Thread.sleep(2000);
	   GenericClass.js_Click(img_HSLegends);
	//   Actions actobj=new Actions(GenericClass.driver);
	//   actobj.moveToElement(img_RRColorCode);
	//   Thread.sleep(2000);
	//   actobj.click().build().perform();
	   Thread.sleep(2000);
	   String code=Dirty_colorCode.getAttribute("bgcolor");
	   String[] code1=code.split("#");
	   String part=code1[1];
	   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(NoSuchElementException e)
		{
			GenericClass.clickElement(img_HSLegends);
			Thread.sleep(2000);
			   String code=Dirty_colorCode.getAttribute("bgcolor");
			   String[] code1=code.split("#");
			   String part=code1[1];
			   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}

	/**
	 * @param Method verifies Inspect room color code  under 'House Status Legends'
	 * @throws Exception,AssertionError
	 */

	public void verify_InspectColorCode() throws Exception
	{
		try
		{
			Thread.sleep(2000);
	   GenericClass.js_Click(img_HSLegends);
	//   Actions actobj=new Actions(GenericClass.driver);
	//   actobj.moveToElement(img_RRColorCode);
	//   Thread.sleep(2000);
	//   actobj.click().build().perform();
	   Thread.sleep(2000);
	   String code=Inspect_colorCode.getAttribute("bgcolor");
	   String[] code1=code.split("#");
	   String part=code1[1];
	   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(NoSuchElementException e)
		{
			GenericClass.clickElement(img_HSLegends);
			Thread.sleep(2000);
			   String code=Inspect_colorCode.getAttribute("bgcolor");
			   String[] code1=code.split("#");
			   String part=code1[1];
			   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}

	/**
	 * @param Method verifies Clean room color code  under 'House Status Legends'
	 * @throws Exception,AssertionError
	 */
	public void verify_CleanColorCode() throws Exception
	{
		try
		{
			Thread.sleep(2000);
	   GenericClass.js_Click(img_HSLegends);
	//   Actions actobj=new Actions(GenericClass.driver);
	//   actobj.moveToElement(img_RRColorCode);
	//   Thread.sleep(2000);
	//   actobj.click().build().perform();
	   Thread.sleep(2000);
	   String code=Clean_colorCode.getAttribute("bgcolor");
	   String[] code1=code.split("#");
	   String part=code1[1];
	   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(NoSuchElementException e)
		{
			GenericClass.clickElement(img_HSLegends);
			Thread.sleep(2000);
			   String code=Clean_colorCode.getAttribute("bgcolor");
			   String[] code1=code.split("#");
			   String part=code1[1];
			   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}


	/**
	 * @param Method verifies Repair room color code  under 'House Status Legends'
	 * @throws Exception,AssertionError
	 */
	public void verify_RepairColorCode() throws Exception
	{
		try
		{
			Thread.sleep(2000);
	   GenericClass.js_Click(img_HSLegends);
	//   Actions actobj=new Actions(GenericClass.driver);
	//   actobj.moveToElement(img_RRColorCode);
	//   Thread.sleep(2000);
	//   actobj.click().build().perform();
	   Thread.sleep(2000);
	   String code=Repair_colorCode.getAttribute("bgcolor");
	   String[] code1=code.split("#");
	   String part=code1[1];
	   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(NoSuchElementException e)
		{
			GenericClass.clickElement(img_HSLegends);
			Thread.sleep(2000);
			   String code=Repair_colorCode.getAttribute("bgcolor");
			   String[] code1=code.split("#");
			   String part=code1[1];
			   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}

	
	public void verify_DNRColorCode1() throws Exception
	{
		try
		{
			Thread.sleep(2000);
	   GenericClass.js_Click(img_RRColorCode);
	//   Actions actobj=new Actions(GenericClass.driver);
	//   actobj.moveToElement(img_RRColorCode);
	//   Thread.sleep(2000);
	//   actobj.click().build().perform();
	   Thread.sleep(2000);
	   String code=DNR_colorCode1.getAttribute("bgcolor");
	   String[] code1=code.split("#");
	   String part=code1[1];
	   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));

		}
		catch(NoSuchElementException e)
		{
			GenericClass.clickElement(img_RRColorCode);
			Thread.sleep(2000);
			   String code=DNR_colorCode1.getAttribute("bgcolor");
			   String[] code1=code.split("#");
			   String part=code1[1];
			   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}



	/**
	 * @param Method verifies DNR room color code  under 'House Status Legends'
	 * @throws Exception,AssertionError
	 */
	public void verify_DNRColorCode2() throws Exception
	{
		try
		{
			Thread.sleep(2000);
	   GenericClass.js_Click(img_RRColorCode);
	//   Actions actobj=new Actions(GenericClass.driver);
	//   actobj.moveToElement(img_RRColorCode);
	//   Thread.sleep(2000);
	//   actobj.click().build().perform();
	   Thread.sleep(2000);
	   String code=DNR_colorCode2.getAttribute("bgcolor");
	   String[] code1=code.split("#");
	   String part=code1[1];
	   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
	   GenericClass.js_Click(img_RRColorCode);
		}
		catch(NoSuchElementException e)
		{
			GenericClass.clickElement(img_RRColorCode);
			Thread.sleep(2000);
			   String code=DNR_colorCode2.getAttribute("bgcolor");
			   String[] code1=code.split("#");
			   String part=code1[1];
			   Assert.assertTrue(DisplayColorsLandingPage.colorCode.contains(part));
			   GenericClass.js_Click(img_RRColorCode);
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}

	
	public void VerifyRoom(String s) throws Exception{
		try{
			ArrayList<String> rooms=new ArrayList<String>();
			int sie=AllRooms.size();
		for(int i=1;i<=AllRooms.size();i++){
			String Room=GenericClass.driver.findElement(By.xpath("//tbody[@class='yui-dt-data']/tr["+i+"]/td[2]/div")).getText();
			rooms.add(Room);
			if(Room.equals(s)){
				Assert.assertEquals(true, Room.equals(s));
				break;
				}
		}
		Thread.sleep(2000);
		Assert.assertEquals(rooms.contains(s),true);
		Reporter.log("ROOM_VERIFIED_IN_HOUSEKEEPING_MODULE", true);
		}catch(Exception e){
			e.printStackTrace();
		}
	    }
	
	
	public void VerifyDeletedRoom(String s) {
		try{
	   for(int i=0;i<=AllRooms.size()-1;i++){
			AllRooms=GenericClass.driver.findElements(By.xpath("//tbody[@class='yui-dt-data']/tr"));
			String Room=AllRooms.get(i).findElement(By.xpath("//tbody[@class='yui-dt-data']/tr["+(i+1)+"]/td[2]/div")).getText();
				Assert.assertEquals(false, Room.equals(s));
		}
		}catch(Exception e){
			throw e;
		}
	    }
	
	public void VerifyDeactivatedRoom(String s) throws Exception{
		try{
			ArrayList<String> colle=new ArrayList<String>();
			for(int i=0;i<=AllRooms.size()-1;i++){
				AllRooms=GenericClass.driver.findElements(By.xpath("//tbody[@class='yui-dt-data']/tr"));
				String Room=AllRooms.get(i).findElement(By.xpath("//tbody[@class='yui-dt-data']/tr["+(i+1)+"]/td[2]/div")).getText();
				colle.add(Room);
				Assert.assertFalse(s.equals(Room));
			}
			Assert.assertFalse(colle.contains(s));
		}catch(Exception e){
			throw e;
		}
			Reporter.log("Room is deactivated and not found",true);
	    }

	
}
