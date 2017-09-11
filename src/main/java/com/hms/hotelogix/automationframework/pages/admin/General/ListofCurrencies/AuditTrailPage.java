package com.hms.hotelogix.automationframework.pages.admin.General.ListofCurrencies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AuditTrailPage {

	
	@FindBy(xpath="html/body/table[3]/tbody/tr")
	public List<WebElement> AllAudit;
	
/**
 * String changes : Changes happen to system.
 * @param changes : It's changes which is done to while adding currency to the hotel. 
 * @author deepak               
 */
public void fn_VerifyChanges(String changes){
		String s=null;
try{
	int size=GenericClass.tr_count(AllAudit);
	for(int i=2;i<=size;i++){
	 s=GenericClass.driver.findElement(By.xpath("html/body/table[3]/tbody/tr["+i+"]/td")).getText();	
	if(s.contains(changes)){
		break;
	}
	}
	Assert.assertTrue(s.contains(changes));
	Reporter.log("As changes done to the List of module." + s, true);
}
catch(Exception e){
	throw e;	
}
	
}






}
