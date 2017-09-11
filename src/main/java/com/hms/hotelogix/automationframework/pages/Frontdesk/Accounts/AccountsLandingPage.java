package com.hms.hotelogix.automationframework.pages.Frontdesk.Accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AccountsLandingPage {
	
	
	
	@FindBy(xpath="//a[text()='Chart of Accounts']")
	public WebElement Link_ChartsOfAccount; 
	
	@FindBy(xpath="//strong[text()='More..']")
	public WebElement Link_MoreforChartOfAccount;
	
	@FindBy(xpath="//a[text()='All Account']")
	public WebElement Link_AllAccount;
	
	@FindBy(xpath="//select[@name='maxEntries']")
	public WebElement DD_View;
	
	
/**
 * As this method is used for account code verification which we created.
 * @param accCode : It's account code which we added ,passed as an arg for searching in the table.
 * @return : As it returns the account code once it's found.
 * @throws Exception: If any occurs.
 * @author deepak
 */
public String fn_verifyAccountCode(String accCode) throws Exception{
String acCode=null;
try{
GenericClass.js_Click(Link_ChartsOfAccount);
Thread.sleep(1000);
GenericClass.clickElement(Link_AllAccount);
Thread.sleep(1000);
GenericClass.selectElement(DD_View, "All");
GenericClass.ActionOnAlert("Accept");
Thread.sleep(2000);
acCode=GenericClass.driver.findElement(By.xpath("//td[text()='"+accCode+"']")).getText();
Thread.sleep(2000);
}
catch(Exception e){
throw e;	
}
return acCode;
}
	
	
	
	
	
	
	

}
