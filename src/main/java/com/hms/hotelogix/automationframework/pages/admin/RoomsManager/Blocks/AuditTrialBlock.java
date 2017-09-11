package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AuditTrialBlock {

	private static AuditTrialBlock ATB;


	@FindBy(xpath="//table[2]//td")
	public static WebElement titleAuditTrail;

	@FindBy(xpath="//table[2]//tr[2]/td")
	public static WebElement changes1;

	@FindBy(xpath="//table[2]//tr[3]/td")
	public static WebElement changes2;








public AuditTrialBlock verifyTitle() throws Exception{

		GenericClass.checkElementDisplay("Audit Trail",titleAuditTrail);
		String title=GenericClass.getText(titleAuditTrail);
		System.out.println(title);
		if(title.equals(titleAuditTrail)){
			System.out.println("Its title for the page");
		}else{
			System.out.println("somthing went wrong");
		}
		return ATB;
}

	/**
	 * To verify Created or Updated history in Audittrail page.
	 * @return
	 */
	public AuditTrialBlock auditTrailHistory(){
        try{
		String str=GenericClass.getText(changes1);
		Assert.assertEquals(str.contains(GenericClass.value),true);
        }catch(Exception e){
        	throw e;
        }catch(AssertionError e){
        	throw e;
        }
		GenericClass.driver.close();
		return ATB;
	    }







}
