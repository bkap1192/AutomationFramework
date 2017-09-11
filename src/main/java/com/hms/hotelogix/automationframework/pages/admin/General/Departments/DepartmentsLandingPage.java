package com.hms.hotelogix.automationframework.pages.admin.General.Departments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.UserManager.Users.EditUserPage;

public class DepartmentsLandingPage {
	
	
	
	@FindBy(xpath="//a[text()='Add a Department']")
	private WebElement AddaDepartment_Link;
	
	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[3]")
	public List<WebElement> Tr_count;
	
	@FindBy(xpath="//a[text()='Edit']")
	public WebElement Edit_link;
	
	@FindBy(xpath="//a[@title='Cancel']")
	public WebElement Cancel_IMG;
	
	@FindBy(xpath="//a[text()='Main']")
	public WebElement Main_Link;
	
	@FindBy(xpath="//input[@value='checkbox']")
	public WebElement Master_CB;
	
	@FindBy(xpath="//input[@name='id[]']")
	public List<WebElement> CheckboxColle_CB;
	
	@FindBy(xpath="//table[@class='list_viewnew']//table//td[2]/select")
	public WebElement ViewDropdown_section;
	
	@FindBy(xpath="//table[@class='list_viewnew']//th[3]/a[1]/img")
	public WebElement BlockNameDownwardArrow_btn;

	@FindBy(xpath="//table[@class='list_viewnew']//th[3]/a[2]")
	public WebElement BlockNameupwardArrow_btn;

	@FindBy(xpath="//table[@class='list_viewnew']//tr")
	public List<WebElement> All_Checkboxes;
	
	@FindBy(xpath="//table[@class='list_viewnew']//th[6]/a[1]")
	public WebElement StatusDownwardSort;

    @FindBy(xpath="//table[@class='list_viewnew']//th[6]/a[2]")
    public WebElement StatusUpwardSort;
	
    @FindBy(xpath="//table[@class='list_viewnew']//tr[2]/td[6]/a/img")
    public WebElement Icon1;
    
    @FindBy(xpath="//select[@name='maxEntries']")
    public WebElement View_DD;
    
    @FindBy(xpath="//select[@name='offset']")
    public WebElement Page_DD;
    
    @FindBy(xpath="//a[text()='Next>>']")
    public WebElement Next_Link;
    
    @FindBy(xpath="//a[text()='<<Previous']")
    public WebElement Previous_Link;
    
    @FindBy(xpath="//a[text()='AuditTrail']")
    public WebElement AuditTrail_Link;
    
    @FindBy(xpath="//a[text()='Delete Selected Department(s)']")
    public WebElement DeleteDepartment_Link;
	
	

    
    public String DepName;
    
    
    public String fn_GetSelectedOptionfromDropDown(WebElement dropdown){
    	try{
    		Select sobj=new Select(dropdown);
    		String option=sobj.getFirstSelectedOption().getText();
    		return option;
    	}catch(Exception e){
    		throw e;
    	}
    }
    
    public void fn_ValidateAnyOneCheckBox() throws Exception{
    	try{
    		CheckboxColle_CB.get(0).click();
    		Assert.assertEquals(CheckboxColle_CB.get(0).isSelected(),true);
    		Thread.sleep(1000);
    		CheckboxColle_CB.get(0).click();
    		Assert.assertEquals(CheckboxColle_CB.get(0).isSelected(),false);
    	}catch(Exception e){
    		throw e;
    	}
        }
    
    
    public DLAuditTrailPage fn_ClickAuditTrail() throws Exception{
    	try{
    		GenericClass.clickElement(AuditTrail_Link);
    	}catch(Exception e){
    		throw e;
    	}
    	return PageFactory.initElements(GenericClass.driver, DLAuditTrailPage.class);
    }
    
    
    public String fn_DeletedDepartment(String Action) throws Exception{
    	try{
    		DepName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]/td[3]")).getText();
    		CheckboxColle_CB.get(0).click();
    		GenericClass.clickElement(DeleteDepartment_Link);
    		String alerttext=GenericClass.ActionOnAlert(Action);
    		return alerttext;
    	}catch(Exception e){
    		throw e;
    	}
    }
    
    
    public void fn_SelectnumofRecord(String record){
    	try{
    		GenericClass.selectElement(View_DD, record);
    	}catch(Exception e){
    		throw e;
    	}
        }
    
    
    public void fn_VerifyPageDD(String pagenum){
    	try{
    		GenericClass.selectElement(Page_DD, pagenum);
    	}catch(Exception e){
    		throw e;
    	}
        }
    
    
	public void fn_VerifyMasterCheckbox() throws Exception{
		try{
			if(Master_CB.isSelected()==false){
				GenericClass.clickElement(Master_CB);
			}
			for(WebElement we : CheckboxColle_CB){
				Assert.assertEquals(we.isSelected(), true);
			}
			Thread.sleep(1000);
			GenericClass.clickElement(Master_CB);
			for(WebElement we : CheckboxColle_CB){
				Assert.assertEquals(we.isSelected(), false);
			}
		}catch(Exception e){
			throw e;
		}
	    }
	
	public String fn_ActiveAndDeactiveDepName() throws Exception{
		try{
			String depname=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]/td[3]")).getText();
			String status=Icon1.getAttribute("src");
			if(status.endsWith("on.GIF")){
				GenericClass.clickElement(Icon1);
			}
			return depname;
		}catch(Exception e){
			throw e;
		}
	    }
	
	public void Sort_DepartmentTitle() throws Exception{
	     GenericClass.sortingName_Downward(ViewDropdown_section, "100", BlockNameDownwardArrow_btn, All_Checkboxes, "//table[@class='list_viewnew']//tr//td[3]");
	     Thread.sleep(2000);
	     GenericClass.sortingName_Upward(ViewDropdown_section, "100", BlockNameupwardArrow_btn, All_Checkboxes, "//table[@class='list_viewnew']//tr//td[3]");
	}

	public void SortDepartment_ByStatus() throws Exception{
		GenericClass.sortstatus_Downward(ViewDropdown_section, "100", Icon1, StatusDownwardSort, All_Checkboxes,"//table[@class='list_viewnew']//tr/td[3]", "//table[@class='list_viewnew']//tr/td[6]/a/img");
		Thread.sleep(2000);
		GenericClass.sortstatus_Upward(ViewDropdown_section, "100", StatusUpwardSort, All_Checkboxes,"//table[@class='list_viewnew']//tr/td[3]","//table[@class='list_viewnew']//tr/td[6]/a/img");
	}
	
	
	public void fn_VerifyLinkOrButton(WebElement element) throws Exception{
		try{
		GenericClass.clickElement(element);
		}catch(Exception e){
			throw e;
		}
	   }
	
	public EditDepartmentPage fn_ClickEditDepartment() throws Exception{
		try{
			GenericClass.clickElement(Edit_link);
		}catch(Exception e){
			throw e;
		}
		EditDepartmentPage ADP=PageFactory.initElements(GenericClass.driver, EditDepartmentPage.class);
	     return ADP;
	    }
	
	public AddaDepartmentPage fn_ClickAddaDepartment() throws Exception{
		try{
			GenericClass.clickElement(AddaDepartment_Link);
		}catch(Exception e){
			throw e;
		}
		AddaDepartmentPage ADP=PageFactory.initElements(GenericClass.driver, AddaDepartmentPage.class);
	     return ADP;
	}
	
	
	public ArrayList<String> fn_VerifyCreatedDepartment(String departmen){
		try{
			ArrayList<String> departments=new ArrayList<String>();
			for(int i=0; i<=Tr_count.size()-1;i++){
				String department=Tr_count.get(i).getText();
				departments.add(department);
				if(department.equalsIgnoreCase(departmen)){
					Assert.assertEquals(department, departmen);
					break;
				}
			}
			return departments;
		}catch(Exception e){
			throw e;
		}
	}

	public ArrayList<String> fn_VerifyDepartmentnames(){
		try{
			ArrayList<String> depcollec=new ArrayList<String>();
			for(WebElement we : Tr_count){
				depcollec.add(we.getText());
			}
			return depcollec;
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	
}
