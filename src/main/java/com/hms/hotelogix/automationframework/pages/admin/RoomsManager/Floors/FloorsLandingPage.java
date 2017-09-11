package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.EditRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.RoomsLandingPage;

public class FloorsLandingPage {
	//FloorLandingPage FLP;
	AdminHome AH;
	AddFloorPage AFP;
	public static String record;
	public static String fname;
	public static String floor2del;
	
	
	@FindBy(xpath="//table[@class='list_viewnew']//tr/td[6]/a/img")
	public  WebElement Icon1;

	@FindBy(xpath="//div[@class='headingtxt']/table//td[2]")
	public  WebElement FloorList_title;

	@FindBy(xpath="//a[text()='Add a Floor']")
	public  WebElement AddaFloor_btn;

	@FindBy(xpath="//div[@id='listing-icons']/ul//li[2]/a")
	public  WebElement DeleteSelFloor_btn;

	@FindBy(xpath="//div[@id='listing-icons']/ul//li[1]/a")
	public  WebElement Cancel_btn;

	@FindBy(xpath="//a[text()='Main']")
	public  WebElement Main_link;

	@FindBy(xpath="//table[@class='list_viewnew']//th")
	public  WebElement SerialNum_column;

	@FindBy(xpath="//table[@class='list_viewnew']//th[2]/input")
	public   WebElement CheckBox_column;

	@FindBy(xpath="//table[@class='list_viewnew']//th[3]")
	public  WebElement Floors_column;

	@FindBy(xpath="//table[@class='list_viewnew']//th[3]/a[1]/img")
	public  WebElement FloorsDownwardArrow_btn;

	@FindBy(xpath="//table[@class='list_viewnew']//th[3]/a[2]/img")
	public  WebElement FloorsUpwardArrow_btn;

	@FindBy(xpath="//table[@class='list_viewnew']//th[4]")
	public  WebElement Rooms_column;

	@FindBy(xpath="//table[@class='list_viewnew']//th[5]")
	public  WebElement Acction_column;

	@FindBy(xpath="//table[@class='list_viewnew']//th[6]")
	public  WebElement Status_column;

	@FindBy(xpath="//table[@class='list_viewnew']//table//td/select")
	public  WebElement PageDropdown_section;

	@FindBy(xpath="//table[@class='list_viewnew']//table//td[2]/select")
	public  WebElement ViewDropdown_section;

	@FindBy(xpath="//table[@class='list_viewnew']//table//td[3]")
	public  WebElement PreviousNext;

	@FindBy(xpath="//a[text()='AuditTrail']")
	public  WebElement AuditTrail;

	@FindBy(xpath="//table[@class='list_viewnew']//th[2]/input")
	public  WebElement MasterCheckBox;

	@FindBy(xpath="//table[@class='list_viewnew']//th[6]/a[1]/img")
	public  WebElement StatusDownwardArrow;

    @FindBy(xpath="//table[@class='list_viewnew']//th[6]/a[2]/img")
    public  WebElement StatusUpwardArrow;


    @FindBy(xpath="//form[@name='frmListView']/table//td[1]")
    public  WebElement Floor_SavedSucessMsg;

    @FindBy(xpath="//table[@class='list_viewnew']//td[2]/input")
    public  WebElement FirstRow_CheckBox;

    @FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
    public  List<WebElement> tr_count;



    @FindBy(xpath="//table[@class='list_viewnew']")
    public  WebElement tabletrs;

    @FindBy(xpath="//input[@type='checkbox' and @name='id[]']")
	public   List<WebElement> All_Checkboxes;

    @FindBy(xpath="//table[@class='list_viewnew']//td[2]/input")
	public  WebElement RecordCheckBox;

    @FindBy(xpath="//table[@class='list_viewnew']//td[5]/a")
	public   WebElement Edit_btn;

     @FindBy(xpath="//form[@name='frmListView']/table//td")
     public  WebElement Update_Msg;

     @FindBy(xpath="//table[@class='list_viewnew']//td[3]")
     public  WebElement Fst_Floor;

     @FindBy(xpath="//table[@class='list_viewnew']//tr[2]/td[3]")
     public  WebElement Secnd_Floor;

     @FindBy(xpath="//table[@class='list_viewnew']//table//td[3]/a[1]")
     public  WebElement Previous_Link;

     @FindBy(xpath="//table[@class='list_viewnew']//table//td[3]/a")
     public  WebElement Next_Link;

     @FindBy(xpath="//table[@class='list_viewnew']//td[6]/a/img")
     public  WebElement status;

     @FindBy(xpath="//input[@name='id[]']")
     public  List<WebElement> All_Checkbox;

     @FindBy(xpath="//table[@class='list_viewnew']//tbody//tr[2]//td[4]//a[1]")
     public  WebElement Rooms_Link;

    @FindBy(xpath="//a[text()='Add new']")
    public  WebElement AddNew_Link;
	
	@FindBy(xpath="//a[@title='Add a Floor']")
	public WebElement link_AddAFloor;
	
	
	
	
public AddFloorPage ClickOnAddFloorLink() throws Exception{
GenericClass.clickElement(link_AddAFloor);
AddFloorPage AFP=PageFactory.initElements(GenericClass.driver, AddFloorPage.class);
return AFP;
}
	

public RoomsLandingPage AddFloors(int iTestCaseRow,String Workbook) throws Exception{
	for (int i=0;i<=1;i++){
		String a=GenericClass.GetCurrentWindowID();
		Thread.sleep(3000);
		AddFloorPage AFP=ClickOnAddFloorLink();
		Thread.sleep(3000);
		GenericClass.windowHandle(a);
		Thread.sleep(3000);
		AFP.AddingFloor(iTestCaseRow,Workbook);
		Thread.sleep(3000);
		GenericClass.Switch_Parent_Window(a);
		Thread.sleep(3000);
	}
	
	new AdminHome().fn_NavigateRooms();
	RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver, RoomsLandingPage.class);
	return RLP;
}


public void check_elements() throws Exception {
	try{
		
		
	 	 GenericClass.checkElementDisplay("Floor List Title",FloorList_title);
	 	 GenericClass.checkElementDisplay("Add Floor Button",AddaFloor_btn);
	 	 GenericClass.checkElementDisplay("Delete button",DeleteSelFloor_btn);
	 	 GenericClass.checkElementDisplay("Cancel button",Cancel_btn);
	 	 GenericClass.checkElementDisplay("Main Link",Main_link);
	 	 GenericClass.checkElementDisplay("Serial Number col",SerialNum_column);
	 	 GenericClass.checkElementDisplay("CheckBox column",CheckBox_column);
	 	 GenericClass.checkElementDisplay("Floors Column",Floors_column);
	 	 GenericClass.checkElementDisplay("Downward arrow for Floor column",FloorsDownwardArrow_btn);
	 	 GenericClass.checkElementDisplay("Upward arrow for Floor column",FloorsUpwardArrow_btn);
	 	 GenericClass.checkElementDisplay("Action column",Acction_column);
	 	 GenericClass.checkElementDisplay("Rooms column",Rooms_column);
	 	 GenericClass.checkElementDisplay("status column",Status_column);
	     GenericClass.checkElementDisplay("Page dropdown",PageDropdown_section);
	 	 GenericClass.checkElementDisplay("view dropdown",ViewDropdown_section);
	 	 GenericClass.checkElementDisplay("Previous Next",PreviousNext);
	 	 GenericClass.checkElementDisplay("Audit Trail",AuditTrail);
	
	}catch(Exception e){
		throw e;
	}
	 }

	/**
	 * Click on Add Button for landing on AddFloorPage.
	 * @return
	 * @throws Exception
	 */
	public AddFloorPage Click_AnyButtonOrLink(WebElement buttonorlink) throws Exception{
	    try{
		GenericClass.clickElement(buttonorlink);
	    }catch(Exception e){
	    	throw e;
	    }
		AddFloorPage AFP=PageFactory.initElements(GenericClass.driver, AddFloorPage.class);
		return AFP;
	   }

	public AddRoomsPage fn_ClickAddNew_Link() throws Exception{
		try{
			GenericClass.clickElement(AddNew_Link);
		}catch(Exception e){
			throw e;
		}
		AddRoomsPage arp=PageFactory.initElements(GenericClass.driver, AddRoomsPage.class);
		return arp;
	}
	
	public AuditTrailPage fn_ClickAuditTrail_Link() throws Exception{
		try{
			GenericClass.clickElement(AuditTrail);
		}catch(Exception e){
			throw e;
		}
		AuditTrailPage arp=PageFactory.initElements(GenericClass.driver, AuditTrailPage.class);
		return arp;
	}

	public void VerifyAdd_Floor() throws InterruptedException{
	
		String saved =	GenericClass.getText(Floor_SavedSucessMsg);
		System.out.println(saved);
		GenericClass.selectElement(ViewDropdown_section,"All");
		GenericClass.ActionOnAlert("Accept");
		int num=GenericClass.tr_count(All_Checkbox);
		for(int i=1;i<=num;i++){
		String floor=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
		if(floor.equalsIgnoreCase(AddFloorPage.value)){
			System.out.println(floor+ "Verified in Floor landing Page.");
			break;
		}else{
			System.out.println("Floor not found");
		}

		}
	}
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<String> fn_VerifyAddedFloor() throws Exception{
		try{
			ArrayList<String> ARR=new ArrayList<String>();
			GenericClass.selectElement(ViewDropdown_section, "All");
			GenericClass.alert_handle();
		       int trcount=GenericClass.tr_count(tr_count);
		        for(int i=2;i<trcount;i++){
		         String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[3]")).getText();
		         ARR.add(data);
		        }
			    return ARR;
		}catch(Exception e){
			throw e;
		}
	}
	
	public void SortFloors() throws Exception{
		try{
		GenericClass.sortingName_Downward(ViewDropdown_section, "100", FloorsDownwardArrow_btn, All_Checkboxes, "//table[@class='list_viewnew']//tr/td[3]");
		Thread.sleep(2000);
		GenericClass.sortingName_Upward(ViewDropdown_section, "100",FloorsUpwardArrow_btn, All_Checkboxes, "//table[@class='list_viewnew']//tr/td[3]");
		}catch(Exception e){
			throw e;
		}
		}
	
	public void SortByStatus() throws Exception{
		try{
		GenericClass.sortstatus_Downward(ViewDropdown_section, "100", Icon1, StatusDownwardArrow, All_Checkboxes, "//table[@class='list_viewnew']//tr/td[3]", "//table[@class='list_viewnew']//tr/td[6]/a/img");
		Thread.sleep(2000);
		GenericClass.sortstatus_Upward(ViewDropdown_section, "100", StatusUpwardArrow,  All_Checkboxes,"//table[@class='list_viewnew']//tr/td[3]", "//table[@class='list_viewnew']//tr/td[6]/a/img");
		}catch(Exception e){
			throw e;
		}
		}
	
	 /**
     * To verify any name in DropDown.
     * @param collection
     * @param blockname
     */
    public List<String> fn_CheckblocknameinDropDown(WebElement collection){
    	try{
    		ArrayList<String> ARR=new ArrayList<String>();
    		ARR.removeAll(ARR);
    		Select sobj=new Select(collection);
    		Iterator<WebElement> colle=sobj.getOptions().iterator();
    		while(colle.hasNext()==true){
    			String str=colle.next().getText();
    			ARR.add(str);
    		}
    		return ARR;
    	}catch(Exception e){
    		throw e;
    	}
        }
	
    /**
     * Get records after select the numbers of record in Dropdown.
     * @throws Exception 
     */
    public int fn_VerifyPageDropdown(WebElement Pagedd, WebElement record, String page, String recor) throws Exception{
    	try{
    		GenericClass.selectElement(record, recor);
    		GenericClass.selectElement(Pagedd, page);
    		Thread.sleep(2000);
    		int trcount=GenericClass.tr_count(tr_count);
    		return trcount;
    	}catch(Exception e){
    		throw e;
    	}
        }
    
    /**
     * Get records after select the numbers of record in Dropdown.
     * @throws Exception 
     */
    public int fn_VerifyRecordDropdown(WebElement we, String indexnum) throws Exception{
    	try{
    		GenericClass.selectElement(we, indexnum);
    		Thread.sleep(2000);
    		int trcount=GenericClass.tr_count(tr_count);
    		return trcount;
    	}catch(Exception e){
    		throw e;
    	}
        }
    
    /**
     * To verify activate and deactivate status of floor. 
     * @param status
     * @throws Exception
     */
    public void fn_ActivateAndDeactivateFirstFloor(String status) throws Exception{
    	try{
    		if(Icon1.getAttribute("src").endsWith(status)){
    			Icon1.click();
    		}
            Thread.sleep(2000);
    	}catch(Exception e){
    		throw e;
    	}
        }
    
    /**
     * Get first floor name.
     * @return
     */
    public String fn_GetFirstFloorname(){
    	try{
    		String floorname=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr[2]//td[3]")).getText();
    		return floorname;
    	}catch(Exception e){
    		throw e;
    	}
    }
    
    /**
     * To Add all Floor name in Array list.
     * @param floornme
     * @return
     * @throws InterruptedException
     */
    public ArrayList<String> VerifyDeletedFloor(String floornme) throws InterruptedException{
    	try{
    		ArrayList<String> ARR=new ArrayList<String>();
    		ARR.removeAll(ARR);
            int trcount=GenericClass.tr_count(tr_count);
            for(int i=2;i<trcount;i++){
            String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[3]")).getText();
            ARR.add(data);
            if(data.contains(floornme)){
	        	   GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[2]/input")).click();
	           }
               }
            return ARR;
    	}catch(Exception e){
    		throw e;
    	}
	
    }
	
    
    /**
     * Verify to select and deselect Checkboxs.
     * @return
     * @throws InterruptedException
     */
 	public void SelectAll_checkbox() throws InterruptedException{
 		try{
 		for(int i=0; i<=All_Checkboxes.size()-1; i++){
 			WebElement we=All_Checkboxes.get(i);
 			we.click();
 			boolean check=we.isSelected();
 			Assert.assertTrue(check);
 	        }
 			Thread.sleep(5000);
 		for(int i=0; i<=All_Checkboxes.size()-1; i++){
 			WebElement we=All_Checkboxes.get(i);
 			we.click();
 			boolean check=we.isSelected();
 			Assert.assertFalse(check);
 		  }
 		}catch(Exception e){
 			throw e;
 		}
         }
 	/**
	 * Select Master Check-box and verify all check boxes is selected or not.
	 * @throws Exception
	 */
	public void master_checkbox() throws Exception{
		try{
		GenericClass.clickElement(CheckBox_column);
		for(int i=0; i<=All_Checkboxes.size()-1; i++){
			WebElement we=All_Checkboxes.get(i);
			boolean check=we.isSelected();
			Assert.assertTrue(check);
	        }
			Thread.sleep(5000);
		GenericClass.clickElement(CheckBox_column);
		for(int i=0; i<=All_Checkboxes.size()-1; i++){
			WebElement we=All_Checkboxes.get(i);
			boolean check=we.isSelected();
			Assert.assertFalse(check);
		  }
		}catch(Exception e){
			throw e;
		}
	    }
 
 	
	   }

