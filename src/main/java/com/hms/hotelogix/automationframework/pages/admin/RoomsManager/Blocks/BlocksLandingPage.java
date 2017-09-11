package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Blocks;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors.AddFloorPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.RoomsLandingPage;
import com.sun.media.Log;

public class BlocksLandingPage {

	private static BlocksLandingPage BLP=null;
	private static AdminHome AH;
//---	private static AddBlockPage ABP;
	WebElement masterCB;
//---	private static AuditTrialBlock ATB;


	@FindBy(xpath="//div[@class='headingtxt']/table//td[2]")
	public WebElement BlockList_title;
	
	@FindBy(xpath="//a[text()=' Rooms ']")
	public WebElement Rooms_Link;
	
	@FindBy(xpath="//a[text()='Add new']")
	public WebElement AddNew_Link;

	@FindBy(xpath="//div[@id='listing-icons']/ul//li[3]/a")
	public  WebElement AddaBlock_btn;

	@FindBy(xpath="//div[@id='listing-icons']/ul//li[2]/a")
	public  WebElement DeleteSelBlock_btn;

	@FindBy(xpath="//div[@id='listing-icons']/ul//li[1]/a")
	public  WebElement Cancel_btn;

	@FindBy(xpath="//table[@class='list_viewnew']//td[5]/a")
	public WebElement Edit_btn;

	@FindBy(xpath="//a[text()='Main']")
	public WebElement Main_link;

	@FindBy(xpath="//table[@class='list_viewnew']//th")
	public WebElement SerialNum_column;

	@FindBy(xpath="//table[@class='list_viewnew']//th[2]/input")
	public WebElement CheckBox_column;

	@FindBy(xpath="//table[@class='list_viewnew']//th[3]")
	public WebElement BlockName_column;

	@FindBy(xpath="//table[@class='list_viewnew']//th[3]/a[1]/img")
	public WebElement BlockNameDownwardArrow_btn;

	@FindBy(xpath="//table[@class='list_viewnew']//th[3]/a[2]")
	public WebElement BlockNameupwardArrow_btn;

	@FindBy(xpath="//table[@class='list_viewnew']//th[4]")
	public WebElement Rooms_column;

	@FindBy(xpath="//table[@class='list_viewnew']//th[5]")
	public WebElement Acction_column;

	@FindBy(xpath="//table[@class='list_viewnew']//th[6]")
	public WebElement Status_column;

	@FindBy(xpath="//table[@class='list_viewnew']//table//td/select")
	public WebElement PageDropdown_section;

	@FindBy(xpath="//table[@class='list_viewnew']//table//td[2]/select")
	public WebElement ViewDropdown_section;

	@FindBy(xpath="//table[@class='list_viewnew']//table//td[3]")
	public WebElement PreviousNext;

	@FindBy(xpath="//a[text()='AuditTrail']")
	public WebElement AuditTrail;

	@FindBy(xpath="//table[@class='list_viewnew']//th[2]/input")
	public WebElement MasterCheckBox;

	@FindBy(xpath="//table[@class='list_viewnew']//td[2]/input")
	public WebElement RecordCheckBox;

	@FindBy(xpath="//table[@class='list_viewnew']//td[3]")
	public WebElement frstBlock;

	@FindBy(xpath="//input[@type='checkbox']")
	public List<WebElement> select;

	@FindBy(xpath="//input[@type='checkbox' and @name='id[]']")
	public List<WebElement> All_Checkboxes;

	@FindBy(xpath="//div[@class='error_new']")
	public WebElement blockupdate_msg;

	@FindBy(xpath="//table[@class='list_viewnew']//th[6]/a[1]")
	public WebElement StatusDownwardSort;

    @FindBy(xpath="//table[@class='list_viewnew']//th[6]/a[2]")
    public WebElement StatusUpwardSort;

    @FindBy(xpath="//table[@class='list_viewnew']//tr//td[2]")
    public List<WebElement> chkbox_count;
    
    @FindBy(xpath="//table[@class='list_viewnew']//tr//td[3]")
    public List<WebElement> Tr_count;

    @FindBy(xpath="//table[@class='list_viewnew']")
    public WebElement tabletrs;

    @FindBy(xpath="//table[@class='list_viewnew']//td[3]")
    public WebElement data;

    @FindBy(xpath="//table[@class='list_viewnew']//table//td[3]/a")
    public WebElement NextLink;

    @FindBy(xpath="//table[@class='list_viewnew']//table//td[3]/a[1]")
    public WebElement PreviousLink;

    @FindBy(xpath="//table[@class='list_viewnew']//table//td[3]")
    public WebElement previousLink;

    @FindBy(xpath="//table[@class='list_viewnew']//td[1]")
    public WebElement Fst_block;

    @FindBy(xpath="//table[@class='list_viewnew']//tr[2]/td[1]")
    public WebElement Secnd_block;

    @FindBy(xpath="//table[@class='list_viewnew']//td[6]/a/img")
    public WebElement status;

    @FindBy(xpath="//table[@class='list_viewnew']//tr[2]/td[6]/a/img")
    public WebElement Icon1;


    public static String exp_msg="- Block "+'"'+AddBlockPage.edited+'"'+" Saved successfully.";
    private String savemsg="- Block "+'"'+AddBlockPage.block_nme+'"'+" Saved successfully.";


    
    
    
    /**
     * To verify any name in DropDown.
     * @param collection
     * @param blockname
     */
    public void fn_CheckblocknameinDropDown(WebElement collection, String blockname){
    	try{
    		Select sobj=new Select(collection);
    		Iterator<WebElement> colle=sobj.getOptions().iterator();
    		while(colle.hasNext()==true){
    			String str=colle.next().getText();
    			Assert.assertEquals(str.equalsIgnoreCase(blockname),false);
    		}
    	}catch(Exception e){
    		throw e;
    	}
        }
    
    
	/**
	 * 
	 * @return
	 */
    public String verify_pge(){
    	try{
    	String heading=GenericClass.getText(BlockList_title);
    	return heading;
    	}catch(Exception e){
    		throw e;
    	}
        }


    public String  verify_SaveMsg(){
    	try{
    	String actual=GenericClass.getText(blockupdate_msg);
    	return actual;
    	}catch(Exception e){
    		throw e;
    	}
    }

/**
 * Select View drop down for seeing All records.
 * @throws InterruptedException
 */
    public String viewAll() throws InterruptedException{
    	try{
    	GenericClass.selectElement(ViewDropdown_section, "All");
    	return GenericClass.ActionOnAlert("Dismiss");
    	}catch(Exception e){
    		throw e;
    	}
    }

    /**
     * To Verify Added Blockname.
     * @param blockname
     */
    public void verify_addedBlock(String blockname){
    	try{
    	int tblecount=GenericClass.tr_count(chkbox_count);
    	for(int i=2;i<=tblecount;i++){
    		String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
    		  if(data.contains(blockname)){
    			Assert.assertEquals(data.contains(blockname),true);
    			break;
    		  }
    	     }
	    	}catch(Exception e){
	    		throw e;
	    	}
	        }
   
    
	/**
	 * To verify next link in block landing page.
	 * @return
	 * @throws Exception
	 */
	public void next_link() throws Exception{
	       try{
	    	GenericClass.selectElement(ViewDropdown_section, "1");
	        String first=GenericClass.getText(Fst_block);
	    	GenericClass.clickElement(NextLink);
	    	 String second=GenericClass.getText(Secnd_block);
	    	 Assert.assertEquals(first.equals(second),false);
	        }catch(Exception e){
	    	   throw e;
	        }
	        }
	
	/**
	 * To verify Privious link in block landing page.
	 * @throws Exception
	 */
    public void previous_link() throws Exception {
        try{
    	  GenericClass.selectElement(ViewDropdown_section, "1");
    	   GenericClass.clickElement(NextLink);
    	   String second=GenericClass.getText(Secnd_block);
    	   GenericClass.clickElement(PreviousLink);
    	   String first=GenericClass.getText(Fst_block);
    	   Assert.assertEquals(second.equals(first),false);
        }catch(Exception e){
        	throw e; 
        }
        }

   /**
    * 
    * @param pagenum
    * @return
    */
    public String Page_dropdown(String pagenum){
    	try{
    	GenericClass.selectElement(ViewDropdown_section, "1");
    	String pagenumber=GenericClass.selectElementByvalue(PageDropdown_section, pagenum);
    	return pagenumber;
    	}catch(Exception e){
    		throw e;
    	}
		
        }

/**
 * Check All elements of BlocksLandingPage.
 * @return
 * @throws Exception
 */
 public BlocksLandingPage check_elements() throws Exception {
   try{
	 GenericClass.checkElementDisplay("Block List Title",BlockList_title);
	 GenericClass.checkElementDisplay("Add Block Button",AddaBlock_btn);
	 GenericClass.checkElementDisplay("Delete button",DeleteSelBlock_btn);
	 GenericClass.checkElementDisplay("Cancel button",Cancel_btn);
	 GenericClass.checkElementDisplay("Main Link",Main_link);
	 GenericClass.checkElementDisplay("Serial Number col",SerialNum_column);
	 GenericClass.checkElementDisplay("CheckBox column",CheckBox_column);
	 GenericClass.checkElementDisplay("Block name",BlockName_column);
	 GenericClass.checkElementDisplay("downward arrow sort",BlockNameDownwardArrow_btn);
	 GenericClass.checkElementDisplay("upward arrow",BlockNameupwardArrow_btn);
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
	 return BLP;
   }
 
	 /**
	  * 
	  * @return
	  * @throws Exception
	  */
	 public String editBlock_Msg() throws Exception{
	    try{
	 	 String str1=GenericClass.getText(blockupdate_msg);
	    // Assert.assertEquals(str1, exp_msg);
	     System.out.println(GenericClass.getText(blockupdate_msg));
	     return str1;
	    }catch(Exception e){
	    	throw e;
	    }
	    }
	 
 /**
  * Verify modifyed block name in block table.
  * @param modifyedname
  */
 public void  verify_editedBlock(String modifyedname) {
    try{
 	int tblecount=GenericClass.tr_count(chkbox_count);
 	for(int i=2;i<=tblecount;i++){
 		String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
 		if(data.contains(modifyedname)){
 			Assert.assertEquals(data.contains(modifyedname),true);
 			break;
 		}
 	    }
    }catch(Exception e){
    	throw e;
    }
    }
 
 public void  verify_ModidfyedBlock(String modifyedname) {
	    try{
	 	int tblecount=GenericClass.tr_count(chkbox_count);
	 	for(int i=2;i<=tblecount;i++){
	 		String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	 			Assert.assertEquals(data.contains(modifyedname),false);
	 			
	 		}
	    }catch(Exception e){
	    	throw e;
	    }
	    }
	 
 
	/**
	 * Click on AddBlock Button.
	 * @return
	 * @throws Exception
	 */
	 public AddBlockPage AddBlock_click() throws Exception {
	  try{
		  GenericClass.clickElement(AddaBlock_btn);
	  }catch(NoSuchElementException e){
		  Thread.sleep(2000);
		  GenericClass.fn_ActionsClick(AddaBlock_btn);
	  }catch(Exception e){
		  throw e;
	  }
		 AddBlockPage ABP=PageFactory.initElements(GenericClass.driver, AddBlockPage.class);
		 return ABP;
	   }


 public BlocksLandingPage Cancel(){
		Cancel_btn.click();
		return BLP;


	}

 /**
  * Click on main link for navigating Admin home page.
  * @return
  * @throws Exception
  */
    public AdminHome mainLink_btn() throws Exception{
    		try{
			GenericClass.clickElement(Main_link);
			}catch(NoSuchElementException e){
				Thread.sleep(2000);
				GenericClass.fn_ActionsClick(Main_link);
			}catch(Exception e){
				throw e;
			}
 	         return AH;
           }



	/**
	 * Click on cancel button for landing on Admine homepage.
	 * @return
	 * @throws Exception
	 */
	public AdminHome cancel_btn() throws Exception{
		try{
		GenericClass.clickElement(Cancel_btn);
		}catch(NoSuchElementException e){
			Thread.sleep(2000);
			GenericClass.fn_ActionsClick(Cancel_btn);
		}catch(Exception e){
			throw e;
		}
		return AH;
	    }


	/**
	 * 
	 * @param alertcommand
	 * @return 
	 * @throws Exception
	 */
	public  String delete_block(String alertcommand) throws Exception{
		try{
	    String blk_name=GenericClass.getText(frstBlock);
		GenericClass.clickElement(RecordCheckBox);
		GenericClass.clickElement(DeleteSelBlock_btn);
		GenericClass.ActionOnAlert(alertcommand);
		return blk_name;
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
			//we.click();
			boolean check=we.isSelected();
			Assert.assertTrue(check);
	        }
			Thread.sleep(5000);
		GenericClass.clickElement(CheckBox_column);
		for(int i=0; i<=All_Checkboxes.size()-1; i++){
			WebElement we=All_Checkboxes.get(i);
		//	we.click();
			boolean check=we.isSelected();
			Assert.assertFalse(check);
		  }
		}catch(Exception e){
			throw e;
		}
	    }

	/**
	 * To verify Deleted block name.
	 * @param deletedblockname
	 */
	public void fn_VerifyDeletedBlockName(String deletedblockname){
		try{
			int size=Tr_count.size();
			for(int i=1; i<=size-1;i++){
				String we=Tr_count.get(i).getText();
				Assert.assertEquals(we.equalsIgnoreCase(deletedblockname),false);
			}
		}catch(Exception e){
			throw e;
		}
	    }
	
	/**
	 * Click on edit button of any individual block name.
	 * @return
	 * @throws Exception
	 */
	public AddBlockPage edit_block() throws Exception{
	    try{
	     GenericClass.clickElement(Edit_btn);
	    }catch(NoSuchElementException e){
	    	Thread.sleep(2000);
	    	GenericClass.fn_ActionsClick(Edit_btn);
	    }catch(Exception e){
	    	throw e;
	    }
		 AddBlockPage ABP=PageFactory.initElements(GenericClass.driver, AddBlockPage.class);
		return ABP;
	
      }

	/**
	 * Click on Audit trail link of BlockLandingPage.
	 * @return
	 * @throws Exception
	 */
	public AuditTrialBlock auditTrial() throws Exception{
	  try{
		GenericClass.clickElement(AuditTrail);
	  }catch(NoSuchElementException e){
		  Thread.sleep(2000);
		  GenericClass.fn_ActionsClick(AuditTrail);
	  }catch(Exception e){
		  throw e;
	  }
		AuditTrialBlock ATB=PageFactory.initElements(GenericClass.driver,AuditTrialBlock.class);
		return ATB;
	  }

	/**
	 * Click on Active or Deactive icon as per user prefences and verify it.
	 * @param activestatus
	 * @param deactivatestatus
	 * @return
	 * @throws Exception
	 */
	public void blockStatus(String activestatus, String deactivatestatus) throws Exception{
		try{
		  String attr=status.getAttribute("src");
		  Assert.assertEquals(attr.endsWith(activestatus), true);
			Thread.sleep(2000);
			  GenericClass.clickElement(status);
			  Thread.sleep(2000);
			  String attr1=status.getAttribute("src");
			  Assert.assertEquals(attr1.endsWith(deactivatestatus), true);
			  Thread.sleep(2000);
			  GenericClass.clickElement(status);
		}catch(Exception e){
			throw e;
		}
		}


/*public BlockLandingPage view1RecordPerPage() throws Exception{

	GenericClass.selectElement( ViewDropdown_section, "1");
 count=GenericClass.CheckBox_Count(All_Checkboxes);

	return BLP;

}

public BlockLandingPage viewAllRecordPerPage() throws Exception
{
	GenericClass.selectElement( ViewDropdown_section, "All");
	GenericClass.alert_handle();
 allcount=	GenericClass.CheckBox_Count(All_Checkboxes);



	return BLP;

}*/


public BlocksLandingPage verifyRecordPage() throws InterruptedException
{
	GenericClass.selectElement( ViewDropdown_section, "1");
    int  count=GenericClass.CheckBox_Count(All_Checkboxes);
    System.out.println(count);

    GenericClass.selectElement( ViewDropdown_section, "All");
    GenericClass.alert_handle();
    int allcount=	GenericClass.CheckBox_Count(All_Checkboxes);
    System.out.println(allcount);

	if(count==allcount)
	{
		System.out.println("you have only two records");
	}
	else
		System.out.println("you havr more than two records");

	return BLP;

}

	/**
	 * To verify View dropdown.
	 */
	    public void view(String recordperpage){
	    	try{
		  GenericClass.selectElement(ViewDropdown_section, recordperpage);
		  Integer size=All_Checkboxes.size();
		  Assert.assertEquals(size<=20,true);
	      }catch(Exception e){
	    		throw e;
	    	}
	      }

/**
 * To verify block title.
 * @throws Exception
 */
public void Sort_BlockTitle() throws Exception{
     GenericClass.sortingName_Downward(ViewDropdown_section, "100", BlockNameDownwardArrow_btn, All_Checkboxes, "//table[@class='list_viewnew']//tr//td[3]");
     Thread.sleep(2000);
     GenericClass.sortingName_Upward(ViewDropdown_section, "100", BlockNameupwardArrow_btn, All_Checkboxes, "//table[@class='list_viewnew']//tr//td[3]");
}

public void SortBlock_ByStatus() throws Exception{
	GenericClass.sortstatus_Downward(ViewDropdown_section, "100", Icon1, StatusDownwardSort, All_Checkboxes,"//table[@class='list_viewnew']//tr/td[3]", "//table[@class='list_viewnew']//tr/td[6]/a/img");
	Thread.sleep(2000);
	GenericClass.sortstatus_Upward(ViewDropdown_section, "100", StatusUpwardSort, All_Checkboxes,"//table[@class='list_viewnew']//tr/td[3]","//table[@class='list_viewnew']//tr/td[6]/a/img");
}


public RoomsLandingPage AddBlocks(int iTestCaseRow,String Workbook) throws Exception {
	for (int i=0;i<=1;i++){
		String a=GenericClass.GetCurrentWindowID();
		Thread.sleep(3000);
		AddBlockPage AFP=AddBlock_click();
		Thread.sleep(3000);
		GenericClass.windowHandle(a);
		Thread.sleep(3000);
		AFP.AddingBlock(iTestCaseRow,Workbook);
		Thread.sleep(3000);
		GenericClass.Switch_Parent_Window(a);
		Thread.sleep(3000);
	}
	
	new AdminHome().fn_NavigateRooms();
	RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver, RoomsLandingPage.class);
	return RLP;
	
}

/**
 * Click on Room link in particular block name.
 * @throws Exception
 */
	public AddRoomsPage fn_ClickonRoomORAddRoom_Link(WebElement we) throws Exception{
		try{
			GenericClass.clickElement(we);
		}catch(Exception e){
			throw e;
		}
		AddRoomsPage ARP=PageFactory.initElements(GenericClass.driver, AddRoomsPage.class);
		return ARP;
	    }

}
