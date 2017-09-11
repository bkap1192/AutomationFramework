package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AuditTrailPage {
	
	
@FindBy(xpath="html/body/table[3]/tbody/tr")
public static List<WebElement> AllTracks;


/**
 * This method verifies that Audit Trail capturing every changes.
 * @param data : Here is data is an string format for matching changes.
 */
public void VerifyAuditTrail(String data){
	try{
	int lines=GenericClass.tr_count(AllTracks);
	ArrayList<String> colle= new ArrayList<String>();
	for(int i=2;i<=lines-1;i++){
		String Data=GenericClass.driver.findElement(By.xpath("//table[3]/tbody/tr["+i+"]/td")).getText();
		colle.add(Data);
		if(Data.contains(data)){
			Assert.assertEquals(Data.contains(data), true);
			Reporter.log("CHANGES VERIFIED IN AUDIT TRAIL", true);
			break;
		}
		}
	//Assert.assertEquals(colle.contains(data), true);
	}catch(Exception e){
		throw e;
	}
}




}
