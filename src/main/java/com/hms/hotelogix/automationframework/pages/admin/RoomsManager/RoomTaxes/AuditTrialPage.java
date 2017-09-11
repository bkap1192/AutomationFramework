package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTaxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AuditTrialPage {

	
	
	
	
@FindBy(xpath="//td[@class='page-heading']")
public WebElement Title_AuditTrailPayMode;

@FindBy(xpath="html/body/table[3]/tbody/tr")
public List<WebElement> AllAudit;	


/**
 * As this method verifies the changes for audit trail.
 * @param changes : As it's changes done to the system.
 * @exception: throws exception if any occurs.
 * @author deepak.  
 */
public void fn_VerifyChanges(String changes){
String s=null;
try{
	
System.out.println(changes);	
int size=GenericClass.tr_count(AllAudit);
for(int i=2;i<=size;i++){
s=GenericClass.driver.findElement(By.xpath("html/body/table[3]/tbody/tr["+i+"]/td")).getText();	
if(s.contains(changes)){
	break;
}
}
Assert.assertTrue(s.contains(changes));
}
catch(Exception e){
throw e;	
}

}


	
	
}
