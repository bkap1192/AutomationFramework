package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskContinueTrialPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Blocks.BlocksLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors.FloorsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.AddRoomTypePage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.RoomTypesLandingPage;

public class RoomsLandingPage {

	@FindBy(xpath="//a[text()='Add a Room']")
	public WebElement AddARoom_Link;
	
	@FindBy(xpath="//td/a[text()='Edit']")
	 public  WebElement link_Edit;
	
	@FindBy(xpath="//td/select[@name='rmTypeId']")
	 public  WebElement AllRoomTypes;
	
	@FindBy(xpath="//select[@name='maxEntries']")
	public  WebElement DD_View;
	
	@FindBy(xpath = "//table[@class='list_viewnew']/tbody/tr")
	public  List<WebElement> AllAttribute;
	
	@FindBy(xpath="//select[@name='blockId']")
	public  WebElement BlockFilter_DD;
	
	@FindBy(xpath="//a[text()='Add Multiple Room(s)']")
	public  WebElement AddMultipleRoom_Link;
	
	@FindBy(xpath="//select[@name='floorId']")
	public  WebElement FloorFilter_DD;
	
	@FindBy(xpath="//td[text()='Rooms List']")
	public  WebElement RoomListPage_Header;

	@FindBy(xpath="//a[text()='Cancel']")
	public  WebElement Cancel_Btn;

	@FindBy(xpath="//input[@value='Search']")
	public  WebElement Search_Btn;

	@FindBy(xpath="//a[text()='Main']")
	public  WebElement Link_Main;
	
	@FindBy(xpath="//a[text()='AuditTrail']")
	public  WebElement Link_AuditTrail;

	@FindBy(xpath="//input[@name='srchRmNameOrNo']")
	public  WebElement SearchRoom_TB;
	
	@FindBy(xpath="//select[@name='rmTypeId']")
	public  WebElement RoomTypeFilter_DD;
	
	@FindBy(xpath="//th[contains(text(),'Room Type')]")
	public  WebElement RoomType_TabCol;

	@FindBy(xpath="//th[text()='Block']")
	public  WebElement Block_TabCol;

	@FindBy(xpath="//th[text()='Floor']")
	public  WebElement Floor_TabCol;

	@FindBy(xpath="//th[text()='Action']")
	public  WebElement Action_TabCol;

	@FindBy(xpath="//th[contains(text(),'Status')]")
	public  WebElement Status_TabCol;
	
	@FindBy(xpath="//th[contains(text(),'Room Names/Numbers	')]")
	public  WebElement RoomNamesNumbers_TabCol;
	

	@FindBy(xpath="//form/table/tbody/tr[2]/td")
	public  WebElement Validation_Msg;
	
	@FindBy(xpath="//a[text()='Delete Selected Room(s)']")
	public  WebElement Btn_DeleteSelectedRooms;
	
	public  String ActiveRoomsStatus="on.GIF";
	
	@FindBy(xpath="//input[@name='checkbox5']")
	public WebElement CB_Master;
	
	@FindBy(xpath="//input[@name='ids[]']")
	public  List<WebElement> CB_AllRooms;
	
	@FindBy(xpath="//td[@class='main-field']")
	public  WebElement NoEntriesFound_Txt;
	
	@FindBy(xpath="//input[@name='ids[]']")
	public  List<WebElement> All_CB;
	
	@FindBy(xpath="//input[@name='checkbox5']")
	public  WebElement Master_CB;
	
	@FindBy(xpath="//table[@class='list_viewnew']//tr[1]/th[3]/a[1]/img")
	public  WebElement Btn_DownwardSortRoomNameNumbers;

	@FindBy(xpath="//table[@class='list_viewnew']//tr[1]/th[3]/a[2]/img")
	public  WebElement Btn_UpwardSortRoomNameNumbers;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr[1]/th[4]/a[1]/img")
	public  WebElement Btn_DownwardSortRoomTypes;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr[1]/th[4]/a[2]/img")
	public  WebElement Btn_UpwardSortRoomTypes;

	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]/td[8]/a/img")
	public  WebElement Icon1;

	@FindBy(xpath="//table/tbody/tr[3]/td/table/tbody/tr[1]/th[8]/a[1]/img")
	public  WebElement Btn_DownwardSortStatus;

	@FindBy(xpath="//table/tbody/tr[3]/td/table/tbody/tr[1]/th[8]/a[2]/img")
	public  WebElement Btn_UpwardSortStatus;

	@FindBy(xpath="//select[@name='offset']")
	public  WebElement DD_Page;

	@FindBy(xpath="//a[text()='Next>>']")
	public  WebElement Link_Next;

	@FindBy(xpath="//a[text()='<<Previous']")
	public  WebElement Link_Previous;
	
	@FindBy(xpath="//td[text()='<<Previous | Next>>']")
	public  WebElement Txt_PreviousNext;

	@FindBy(xpath="//td[text()='<<Previous | ']")
	public  WebElement Txt_DeactivePreviousLink;

	@FindBy(xpath="//td/a[text()='Edit']")
	public  WebElement Edit;

   
	
	
	ArrayList<String> al=new ArrayList<>();
	
	public AddRoomsPage ClickOnAddRoomLink() throws Exception
	 {
		 try
		 {
	 GenericClass.clickElement(AddARoom_Link);
		 }
		 catch(NoSuchElementException e)
		 {
			 Thread.sleep(2000);
			 GenericClass.js_Click(AddARoom_Link);
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
		 AddRoomsPage ARP=PageFactory.initElements(GenericClass.driver, AddRoomsPage.class);
		 return ARP;
	 }
	
	public  EditRoomsPage editlnk() throws Exception
	 {
		 try
		 {
		 GenericClass.clickElement(link_Edit);
		 EditRoomsPage addroomobj=PageFactory.initElements(GenericClass.driver, EditRoomsPage.class);
		 return addroomobj;
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 }
	
	public  void RoomTypeFilter_AddedRT(String rtName) throws Exception
	  {
	     try
	     {
		  Select select = new Select(AllRoomTypes);
		  List<WebElement> options = select.getOptions();
		  for(WebElement we:options)
		  {
			  String txt=we.getText();
		   if(txt.equals(rtName))
		   {
			   Assert.assertTrue(txt.equals(rtName));
			   System.out.println("Added room type name is being dispayed on Rooms List page.");
			   break;
		   }
		  }
	     }
	     catch(AssertionError e)
	     {
	    	 throw e;
	     }
	     catch(Exception e)
	     {
	    	 throw e;
	     }
	  }
	
	 public void RoomTypeFilter_DeletedRT(String rtName) throws Exception
	  {

		  try
		  {
	  	Select sel=new Select(AllRoomTypes);
	  	int size=sel.getOptions().size();
	  	for(int i=0;i<size;i++)
	  	{
	  		String str=sel.getOptions().get(i).getText();
	  		al.add(str);
	  	}

	  	Assert.assertFalse(al.contains(rtName));
		  }
		  catch(AssertionError e)
		  {
			  throw e;
		  }
		  catch(Exception e)
		  {
			  throw e;
		  }
	  }
	 
	 public String verify_RoomTypeNameFilter()
	  {try{
		  Select sel=new Select(AllRoomTypes);
		  String text=sel.getFirstSelectedOption().getText();
	      return text;
	  }catch(Exception e){
		  throw e;
	  }
	  }
	
	 
	 public  void RoomTypeFilter_EditedRT(String rtName) throws Exception
	  {try{
		 // WebElement dropdown = GenericClass.driver.findElement(By.name("rmTypeId"));
		  Select select = new Select(AllRoomTypes);
		  List<WebElement> options = select.getOptions();
		  for(WebElement we:options)
		  {
		   //System.out.println(we.getText());
			  String txt=we.getText();
		   if(txt.equals(rtName))
		   {
			   Assert.assertEquals(txt.equals(rtName), true);
			   break;
		   }
		  }
	  }catch(AssertionError e){
		  throw e;
	  }catch(Exception e){
		  throw e;
	  }
	  }
	 
	 
	 public  void RoomTypeFilter_DeactiveRT(String rtName) throws Exception
	  {
		  try
		  {
		 // WebElement dropdown = GenericClass.driver.findElement(By.name("rmTypeId"));
		  Select select = new Select(AllRoomTypes);
		  List<WebElement> options = select.getOptions();
		  for(WebElement we:options)
		  {
		   //System.out.println(we.getText());
			  String txt=we.getText();
		      Assert.assertFalse(txt.contains(rtName));
		  }
		  }
		  catch(AssertionError e)
		  {
			  throw e;
		  }
		  catch(Exception e)
		  {
			  throw e;
		  }
	  }

	 
	 public  void RoomTypeFilter_ActiveRT(String rtName) throws Exception
	  {
		  try
		  {
		 // WebElement dropdown = GenericClass.driver.findElement(By.name("rmTypeId"));
		  Select select = new Select(AllRoomTypes);
		  List<WebElement> options = select.getOptions();
		  for(WebElement we:options)
		  {
		   //System.out.println(we.getText());
			  String txt=we.getText();
			  if(txt.equals(rtName))
			  {
		      Assert.assertTrue(txt.contains(rtName));
		      break;
			  }
		  }
		  }
		  catch(AssertionError e)
		  {
			  throw e;
		  }
		  catch(Exception e)
		  {
			  throw e;
		  }
	  }
	 
	 public void fn_VerifyTableForRooms(String roomname){
			GenericClass.selectElement(DD_View, "All");
			GenericClass.ActionOnAlert("Accept");
			try {
				int from = GenericClass.tr_count(AllAttribute);
				for (int i = 2; i <= from - 1; i++) {

					String attr = GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[" + i + "]/td[3]")).getText().trim();
					if(attr.equalsIgnoreCase(roomname)){
						Assert.assertEquals(attr.equalsIgnoreCase(roomname),true);
						break;
					}
					Reporter.log("ROOM IS NOT PERSENT", true);
				     }
					} catch (Exception e) {
							e.printStackTrace();
					}
					}
	 
	 
	 public AddMultipleRoomsPage ClickOnAddMultipleRoom_Link() throws Exception{
			GenericClass.clickElement(AddMultipleRoom_Link);
			AddMultipleRoomsPage AMR=PageFactory.initElements(GenericClass.driver,	AddMultipleRoomsPage.class );
			return AMR;
		}

	 
	 
	 public void VerifyAddedRoom(String s) throws Exception {
			ArrayList<String> rooms=new ArrayList<String>();
		          try {
					int from = GenericClass.tr_count(AllAttribute);
					for (int i = 2; i <= from - 1; i++) {
						String attr = GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[" + i + "]/td[3]")).getText().trim();
						rooms.add(attr);
						if (attr.equals(s)) {
							String src=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[" + i + "]/td[8]/a/img")).getAttribute("src");
							Assert.assertEquals(src.endsWith(ActiveRoomsStatus),true);
							Reporter.log("ADDED ROOM IS ACTIVATE", true);
							Assert.assertEquals(attr,s);
							Reporter.log("ADDED ROOM IS PERSENT IN ROOM LIST LANDING PAGE.", true);
							break;
						}
		                }
		                Thread.sleep(2000);
		              Assert.assertEquals(rooms.contains(s),true);
					}catch (Exception e) {
						throw e;
					}
					}
	 
	 
	 /**
		 * This methods verifies all the element on the Room Landing page.
		 * @throws Exception
		 */
		public void VerifyElement() throws Exception{
			GenericClass.checkElementDisplay("Add room Link is visible",AddARoom_Link);
			GenericClass.checkElementDisplay("Add multiple room Link is visible",AddMultipleRoom_Link);
			GenericClass.checkElementDisplay("Cancel Button is visible",Cancel_Btn);
			GenericClass.checkElementDisplay("Search button is visible",Search_Btn);
			GenericClass.checkElementDisplay("Main_Link is visible",Link_Main);
			GenericClass.checkElementDisplay("Edit_Link is visible",link_Edit);
			//GenericClass.checkElementDisplay("PreviousNext_Lin is visible",PreviousNext_Link);
			GenericClass.checkElementDisplay("AuditTrail_Link is visible",Link_AuditTrail);
			GenericClass.checkElementDisplay("SearchRoom_TB is visible",SearchRoom_TB);
			GenericClass.checkElementDisplay("RoomTypeFilter_DDis visible",RoomTypeFilter_DD);
			GenericClass.checkElementDisplay("BlockFilter_DD is visible",BlockFilter_DD);
			GenericClass.checkElementDisplay("FloorFilter_DD is visible",FloorFilter_DD);
			GenericClass.checkElementDisplay("RoomNamesNumbers_TabCol is visible",RoomNamesNumbers_TabCol);
			GenericClass.checkElementDisplay("RoomType_TabCol is visible",RoomType_TabCol);
			GenericClass.checkElementDisplay("Block_TabColn is visible",Block_TabCol);
			GenericClass.checkElementDisplay("Floor_TabCol is visible",Floor_TabCol);
			GenericClass.checkElementDisplay("Action_TabCol is visible",Action_TabCol);
			GenericClass.checkElementDisplay("Status_TabCol is visible",Status_TabCol);
		}
		
		/**
		 * This is formatting message for validation that the room added successfully.
		 * @param s : Here s is room name.
		 * @return : As it returns proper validation message for added room along with room name.
		 */
		public String ValidationFormat(String s){
			String fst="- Room ";
			String scnd="\""+ s+"\" ";
			String thrd="Saved Successfully";
			String res= fst+scnd+thrd;
			return res;
		}
		
		/**
		 * This method for Deleting the room.
		 * @throws Exception 
		 * @iTestCaseRow  : This gives the test case id so that we can get the value from Excel file using test case id.
		 */
		public void DeleteRooms(String room) throws Exception{
			try {
				int from = GenericClass.tr_count(AllAttribute);
				for (int i = 2; i <= from - 1; i++) {
					String attr = GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[" + i + "]/td[3]")).getText().trim();
					boolean res=attr.equals(room);
					if(res==true){
						 GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[" + i + "]/td[2]/input")).click();
						 GenericClass.clickElement(Btn_DeleteSelectedRooms);
						 break;
					}
				    }
			        } catch (Exception e) {
		               throw e;
			         }
		             }
		
		/**
		 * This method for Verifying Rooms on the Rooms Landing page.
		 * @return 
		 */
		public ArrayList<String> VerifyTableForRooms(){
			GenericClass.selectElement(DD_View, "All");
			GenericClass.ActionOnAlert("Accept");
			try {
				ArrayList<String> coll=new ArrayList<String>();
				int from = GenericClass.tr_count(AllAttribute);
				for (int i = 2; i <= from - 1; i++) {
					String attr = GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[" + i + "]/td[3]")).getText().trim();
					coll.add(attr);
				}
				return coll;
			    } catch (Exception e) {
				     throw e;
			    }
		        }
		
		/**
		 * This is Method for creating formatting message for validation that the room deleted successfully.
		 * @param s : Here s is room name.
		 * @return : As it returns proper validation message for deleted room along with room name.
		 */
		public String ValidationFormatForDelete(String s){
			String fst="- Room Name(s) / Number(s) ";
			String scnd="\""+ s+"\" ";
			String thrd="deleted Successfully";
			String res= fst+scnd+thrd;
			return res;
		}
		
		 public void fn_CheckRoomType(int itestrow) throws Exception{
			  try{
				  List<WebElement> we=new Select(RoomTypeFilter_DD).getOptions();
				 int coun=we.size();
				  if(coun==2){
					  RoomTypesLandingPage RLP=new AdminHome().fn_NavigateRoomTypes();
					  AddRoomTypePage ATP=RLP.fn_NavigateAddRoomTypes();
					 ATP.fn_CreateRoomtype(itestrow);
					 ATP.fn_clkSave();
					 new AdminHome().fn_NavigateRooms();
				  }
			  }catch(Exception e){
				  throw e;
			  }
		      }
		 
		 /**
		  * This method search the rooms.
		  * @param s : Here s is the room name to search.
		  * @throws Exception
		  */
		 public void SearchRoomInRoomList(String s) throws Exception{
		 	GenericClass.sendKeys(SearchRoom_TB, s);
		 	GenericClass.clickElement(Search_Btn);
		 }
		 
		 public void fn_DeleteOccupaiedRoom(String alerthandle) throws Exception{
				try{
					GenericClass.selectElement(DD_View, "All");
					GenericClass.ActionOnAlert(alerthandle);
					int count=All_CB.size();
					All_CB.get(count-1).click();
					GenericClass.clickElement(Btn_DeleteSelectedRooms);
					GenericClass.ActionOnAlert(alerthandle);
				}catch(Exception e){
					throw e;
				}
			    }
		 
		 /**
		  * This method gets all the dropdown value.
		  * @param ele : Here ele is dropdown element.
		  * @return As it returns the counts for total number of value.
		  */
		 public int GetCountForDropdownValues(WebElement ele){
		  List<WebElement> listValues=GenericClass.GetAllOptionFromDropdown(ele);
		 return listValues.size();

		 }

		 
		 
		 /**
		  * This method Checks floor availability.
		  * @param ele : Here ele is dropdown .
		  * @param iTestCaseRow : This method for handling test data using test case id.
		  * @return : As it returns FloorsLandingPage and initialize its all element
		  * @throws Exception
		  */
		 public FloorsLandingPage CheckFloorAvailability(WebElement ele,int iTestCaseRow,String Workbook) throws Exception{
		 	if(GetCountForDropdownValues(ele)<=2){

		 	FloorsLandingPage flp=new AdminHome().fn_NavigateToFloors();
		 	flp.AddFloors(iTestCaseRow,Workbook);


		 	}

			FloorsLandingPage FLP=PageFactory.initElements(GenericClass.driver,FloorsLandingPage.class );
			return FLP;
}
		 
		 
		 /**
		  * This method Checks Block availability.
		  * @param ele : Here ele is dropdown .
		  * @param iTestCaseRow : This method for handling test data using test case id.
		  * @return : As it returns BlockLandingPage and initialize its all element
		  * @throws Exception
		  */
		 public BlocksLandingPage CheckBlockAvailability(WebElement ele,int iTestCaseRow,String Workbook) throws Exception{
		 	if(GetCountForDropdownValues(ele)<=2){
		 		BlocksLandingPage BLP=new AdminHome().fn_NavigateBlocks();
		 		BLP.AddBlocks(iTestCaseRow,Workbook);
		 		}
		 	BlocksLandingPage BLP=PageFactory.initElements(GenericClass.driver,BlocksLandingPage.class );
		 	return BLP;
		 }
		 
		 
		 /**
		  * This method for ensuring that all the checkboxes are selected
		  * @throws Exception
		  */
		 public void VerifyMasterCheckBox() throws Exception{
		 	try{
		 	GenericClass.selectElement(DD_View, "All");
		 	GenericClass.ActionOnAlert("Accept");
		 	GenericClass.clickElement(Master_CB);
		 	Thread.sleep(2000);
		 	for(WebElement l: All_CB){
		 	    Assert.assertEquals(l.isSelected(), true);
		 	}
		 	}catch(Exception e){
		 		throw e;
		 	}

		 }
		 
		 /**
		  * This Method ensures that Master check box properly functioning.
		  * @throws Exception
		  */
		 public void VerifyDeselect() throws Exception{
		 	try{
		 	GenericClass.selectElement(DD_View, "All");
		 	GenericClass.ActionOnAlert("Accept");
		 	GenericClass.clickElement(Master_CB);
		 	for(WebElement l: All_CB){
		 	    Assert.assertEquals(l.isSelected(), true);
		 	}
		 	Thread.sleep(2000);
		 	GenericClass.clickElement(Master_CB);
		 	for(WebElement m: All_CB){
		 		 Assert.assertEquals(m.isSelected(), false);
		 	}
		 	}catch(Exception e){
		 		throw e;
		 	}

		 }
		 
		 /**
		  * This method selects the room to edit.
		  * @param roomToEdit : Here we need to pass the room which we want to delete.
		  * @return : As it returns EditRoomsPage And initialize all its element
		  */
		 public EditRoomsPage SelectRoomToEdit(String roomToEdit){
		 	try {
		 		int from = GenericClass.tr_count(AllAttribute);
		 		for (int i = 2; i <= from - 1; i++) {
		 			String attr = GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[" + i + "]/td[3]")).getText().trim();
		 			if (attr.equals(roomToEdit)) {
		 				 GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[" + i + "]/td[2]/input")).click();
		 				 GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[" + i + "]/td[7]/a")).click();
		 				 break;
		 			}
		 		    }
		 	        }catch (Exception e) {
		 		     e.printStackTrace();
		 			}
		 			EditRoomsPage ERP=PageFactory.initElements(GenericClass.driver, EditRoomsPage.class);
		 			return ERP;
		 			}
		 
		 /**
		  * This method change the Pos attribute status whether its activated or deactivated.
		  * @param clickOnStatus : This is a parameter where we need to pass the Room name/number for activating or deactivating.
		  * @return As it returns src value for that particular pos attribute.
		  * @throws Exception 
		  */
		   public String  ChangeStatus(String clickOnStatus ) throws Exception{
		 	   try{
		 		   String  status =null;
		 		int from = GenericClass.tr_count(AllAttribute);
		 		for (int i = 2; i <= from - 1; i++) {
		 			String attr = GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[" + i + "]/td[3]")).getText().trim();
		 			boolean res=attr.equals(clickOnStatus);
		 			if(res==true){
		 				 WebElement we=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[" + i + "]/td[8]/a/img"));
		 				 status=we.getAttribute("src");
		 				 we.click();
		 				 Thread.sleep(2000);
		 				  break;
		 			  }
		 		      }
		 		     return status;
		 			  }catch (Exception e){
		 			  throw e;
		 			   }
		 				
		                 }
		   
		   public void fn_DeactivateOccupiedRoom(String alerthandle) throws Exception{
				try{
					GenericClass.selectElement(DD_View, "All");
					GenericClass.ActionOnAlert(alerthandle);
					int count=All_CB.size();
					 GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+count+"]/td[8]/a/img")).click();
					 Thread.sleep(2000);
					 
				}catch(Exception e){
					throw e;
				}
			}
		   
		   
		   /**
		    * This method ensures that downward arrow sort button works fine for room numbers/name.
		    * @throws Exception
		    */
		   public void DownwardSortByStatus() throws Exception{
		   	try{
			   GenericClass.sortstatus_Downward(DD_View, "100", Icon1, Btn_DownwardSortStatus, All_CB, "//table[@class='list_viewnew']/tbody//tr//td[3]", "//table[@class='list_viewnew']//td[8]/a/img");
		   	}catch(Exception e){
		   		throw e;
		   	}
		   	}

		   /**
		    * This method ensures that Upward arrow sort button works fine for room numbers/name.
		    * @throws Exception
		    */
		   public void UpwardSortByStatus() throws Exception{
		   	 try{
			   GenericClass.sortstatus_Upward(DD_View, "100", Btn_DownwardSortStatus, All_CB, "//table[@class='list_viewnew']/tbody//tr//td[3]", "//table[@class='list_viewnew']//td[8]/a/img");
		   	 }catch(Exception e){
		   		 throw e;
		   	 }
		   	 }


		   /**
		    * This method ensures that we are in Administrator Home page after clicking on Main link.
		    * @return : As it returns the Admin Home page and initializes all its elements on that page.
		    * @throws Exception
		    */
		   public AdminHome ClickOnMainLink() throws Exception{
		 try{
			   GenericClass.clickElement(Link_Main);
		   AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
		   return AH;
		 }catch(Exception e){
			 throw e;
		 }
		   }



		   public void VerifyPageDropdown() throws InterruptedException{
		   try{
			   List<WebElement> ele=GenericClass.GetAllTheValueFromDropDown(DD_Page);
		   	int size=ele.size();
		   	System.out.println("Here is page drop down valuyes"+size);
		   	for(int i=0;i<=ele.size()-1;i++){
		   		if(i==0){
		   			GenericClass.isEnable("Next link is enable", Link_Next);
		   			Assert.assertTrue(GenericClass.isEnable("Next link is enable", Link_Next));
		   			Reporter.log("For the first value of page dropdown next link is enable ", true);
		   		}

		   		if(i==ele.size()-1){
		   			GenericClass.selectElement(DD_Page, Integer.toString(size));
		   			Thread.sleep(2000);
		   			GenericClass.isEnable("previous link is enable", Link_Previous);

		   			Assert.assertTrue(GenericClass.isEnable("previous link is enable", Link_Previous));
		   			Reporter.log("For the last value of page dropdown next link is enable ", true);
		   		}

		   	}
		   }catch(Exception e){
			   throw e;
		   }
		   }


		   public AuditTrailPage ClickOnAuditTrailLink() throws Exception{
				try{
			   GenericClass.clickElement(Link_AuditTrail);
				AuditTrailPage ATP=PageFactory.initElements(GenericClass.driver, AuditTrailPage.class);
				return ATP;
				}catch(Exception e){
					throw e;
				}
			}
		   
		   
		   public  FrontdeskContinueTrialPage fn_clickOnFrontdeskLink(){
			   try{
			   GenericClass.driver.findElement(By.xpath("//a[contains(@href,'frontdeskautologin')]")).click();	
			   }
			   catch(Exception e){
			   throw e;	
			   }
			   FrontdeskContinueTrialPage FCTP=PageFactory.initElements(GenericClass.driver, FrontdeskContinueTrialPage.class);
			   return FCTP;
			   }
}
