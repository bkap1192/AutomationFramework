package com.hms.hotelogix.automationframework.pages.admin.PriceManager.GroupTax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AddGroupTaxPage {
	
	

	@FindBy(xpath="//form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[9]/td[1]")
	public WebElement AllTaxName;
	
	@FindBy(xpath="//form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[9]/td[1]/input")
	public List<WebElement> AllCheckBoxes;

	
	
public void GetTaxAndVerify(String taxtTitle) throws Exception{
ArrayList<String> taxes=new ArrayList<String>();
String allTax=AllTaxName.getText();
taxes.add(allTax);
Thread.sleep(2000);
Assert.assertEquals(allTax.contains(taxtTitle),true);
Reporter.log("Tax verified at group tax", true);
}



public void fn_verifyDeletedTax(String taxtTitle) throws Exception{
ArrayList<String> taxes=new ArrayList<String>();
String allTax=AllTaxName.getText();
taxes.add(allTax);
Thread.sleep(2000);
Assert.assertFalse(allTax.contains(taxtTitle));
Reporter.log("Tax not found", true);
}


public ArrayList<String> fn_getAllTaxes() throws Exception{
	
ArrayList<String> taxes=new ArrayList<String>();

try{
String allTax=AllTaxName.getText();
String arr[]=allTax.split("\n");
taxes.addAll(Arrays.asList(arr));
Thread.sleep(2000);
}
catch(Exception e){
throw e;
}
return taxes;
}




}
