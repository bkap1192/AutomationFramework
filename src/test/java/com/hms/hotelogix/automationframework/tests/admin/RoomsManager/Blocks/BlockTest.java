package com.hms.hotelogix.automationframework.tests.admin.RoomsManager.Blocks;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtilHM;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtilsHMM;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Blocks.AddBlockPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Blocks.AuditTrialBlock;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Blocks.BlocksLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions.PhoneExtensionsListPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.AddRoomTypePage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.RoomTypesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddMultipleRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.RoomsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.SortRooms.SortRoomsLandingPage;

public class BlockTest {


 AdminLogin AL;
 AddBlockPage ABP;
 BlocksLandingPage BLAP=null;
 private HashMap<String, String> TDMap;
 public final String Block_Sheet = "Sheet1";
 private HashMap<String, HashMap<String, String>> TTDMap;
 
 
     @BeforeMethod
	 public void Login() throws Throwable{
	 
	  AL=GenericClass.fn_OpenAdmin("FF", "http://hotelogix.net/admine/login/login/");
	//  AL=GenericClass.fn_OpenAdmin("FF", "http://livestable.hx.local/admine/login/login/");
	  AdminHome AH=AL.adminlogin("12904","akash.khanna610@gmail.com","168c507d");
		//AdminHome AH=AL.adminlogin_12302();
	 }
  

		@Test(priority=1,groups={"P0","BlockTest"},description="To Verify Navigation to Block List Page.")
		public void HMS8685() throws Throwable{
			try{
			TTDMap=ExcelUtilsHMM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet);
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			AdminHome AH=new AdminHome();
			AH.fn_NavigateBlocks();
			GenericClass.driver.getTitle();
			Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("BlockPage_Title"));
			System.out.println("--------HMS-1512 Executed---------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
	
		@Test(priority=2, groups={"P1","BlockTest"},description="To verify room link under Rooms column and page navigated on RoomList page.")
		public void HMS8556() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			String a=GenericClass.GetCurrentWindowID();
			AddBlockPage ABP=BLP.AddBlock_click();
		    GenericClass.windowHandle(a);
		    ABP.SaveBlockTitle();
		    Thread.sleep(2000);
			GenericClass.Switch_Parent_Window(a);
			BLP.fn_ClickonRoomORAddRoom_Link(BLP.Rooms_Link);
			Thread.sleep(2000);
			Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("RoomListPage_Title"));
			System.out.println("--------HMS-8856 Executed---------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
	
		@Test(priority=3, groups={"P1","BlockTest"},description="To verifying the functionality of 'Add new ' link on Block List Page under Rooms column. Page navigated on 'Add/Edit a Room page'.")
		public void HMS8557() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			String a=GenericClass.GetCurrentWindowID();
			AddBlockPage ABP=BLP.AddBlock_click();
		    GenericClass.windowHandle(a);
		    ABP.SaveBlockTitle();
			GenericClass.Switch_Parent_Window(a);
			BLP.fn_ClickonRoomORAddRoom_Link(BLP.AddNew_Link);
			Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("AddRoomPage_Title"));
			System.out.println("--------HMS-8857 Executed---------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
		@SuppressWarnings("static-access")
		@Test(priority=4, groups={"P1","BlockTest"},description="To click on 'Add New' link and Add new room, Validate all reflection points.")
		public void HMS9095() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			AddRoomsPage ARP=BLP.fn_ClickonRoomORAddRoom_Link(BLP.AddNew_Link);
			String randomname=GenericClass.generateRandomString();
			RoomsLandingPage rlp=ARP.fn_AddRoom(randomname, TDMap.get("Description_ED"));
			rlp.fn_VerifyTableForRooms(randomname);
			SortRoomsLandingPage srlp=AH.fn_navigateToSortRooms();
			srlp.VerifyRoom(randomname);
			PhoneExtensionsListPage plp=AH.fn_NavigateToPhoneExtPage();
			plp.VerifyAddedRoom(randomname);
			System.out.println("----------HMS-8856 Executed---------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
		@Test(priority=5, groups={"P1","BlockTest"},description="To validate Alert massage after select All option.")
		public void HMS9092() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			String alerttext=BLP.viewAll();
			Assert.assertEquals(alerttext, TDMap.get("Alert_TX"));
			System.out.println("----------HMS-9092 Executed---------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
	
		@Test(priority=6, groups={"P1","BlockTest"},description="To validate Ok and Cancel button in Alert massage after ")
		public void HMS9093_HMS9094() throws Throwable{
            try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			GenericClass.selectElement(BLP.ViewDropdown_section, "All");
			GenericClass.ActionOnAlert("Dismiss");
			Thread.sleep(2000);
			GenericClass.selectElement(BLP.ViewDropdown_section, "All");
			GenericClass.ActionOnAlert("Accept");
			System.out.println("----------HMS-9093-HMS-9094 Executed---------");
            } catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
		@Test(priority=7, groups={"P0","BlockTest"},description="To validate Navigate on 'Block List' page.")
		public void HMS8832() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			String title=BLP.verify_pge();
			Assert.assertEquals(title, TDMap.get("BlockPage_Title"));
			System.out.println("----------HMS-8832 Executed----------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
		@Test(priority=8, groups={"P1","BlockTest"},description="To validate 'Add/Edit a Block' page after click on Add a Block button.")
		public void HMS8834() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			AddBlockPage ABP=BLP.AddBlock_click();
		    GenericClass.switchToWindowHandle(TDMap.get("AddBlockPage_Title"));
		    Assert.assertEquals(TDMap.get("AddBlockPage_Header"), ABP.AddEditaBlock_title.getText());
		    GenericClass.driver.close();
			System.out.println("----------HMS-8834 Executed----------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}

		}
		
		@Test(priority=9, groups={"P1","BlockTest"},description="To verify all elements on 'Add/Edit a Block' page.")
		public void HMS8835() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
		    AddBlockPage ABP=BLP.AddBlock_click();
		    GenericClass.switchToWindowHandle(TDMap.get("AddBlockPage_Title"));
		    ABP.fn_VerifyElements();
		    GenericClass.driver.close();
			System.out.println("----------HMS-8835 Executed----------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		  }
		
		
		@Test(priority=10, groups={"P2","BlockTest"},description="To Verify cancel button of alert box after select block and click on 'DELETE SELECTED BLOCK(S)' button.")
		public void HMS8686() throws Throwable{
			try{
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			String blockname=BLP.delete_block("Dismiss");
			String str=GenericClass.getText(BLP.frstBlock);
			Assert.assertEquals(str,blockname);
			System.out.println("---------HMS-8686 Executed--------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
     
		@SuppressWarnings("static-access")
		@Test(priority=11, groups={"P2","BlockTest"},description="Delete Block and reflected point verified.")
		public void HMS8687() throws Throwable{
			try{
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			String blockname=BLP.delete_block("Accept");
			BLP.fn_VerifyDeletedBlockName(blockname);
			RoomTypesLandingPage RTL=AH.fn_NavigateRoomTypes();
			AddRoomTypePage ATP=RTL.fn_NavigateAddRoomTypes();
			BLP.fn_CheckblocknameinDropDown(ATP.drpdwn_RoomareaBlock, blockname);
			RoomsLandingPage  RLP=AH.fn_NavigateRooms();
			BLP.fn_CheckblocknameinDropDown(RLP.BlockFilter_DD, blockname);
			AddMultipleRoomsPage AMR=RLP.ClickOnAddMultipleRoom_Link();
			BLP.fn_CheckblocknameinDropDown(AMR.Drpdwn_BlockType, blockname);
			System.out.println("---------HMS-8687 Executed--------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
		@Test(priority=12, groups={"P1","BlockTest"},description="To verify check all Elements in 'Block List' Page.")
		public void HMS1512() throws Throwable{
			try{
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			BLP=BLP.check_elements();
			System.out.println("--------HMS-1512 Executed---------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
		@Test(priority=13, groups={"P1","BlockTest"},description="Add Block with valid data and verify reflected points.")
		public void HMS1513() throws Throwable{
			try{
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			String a=GenericClass.GetCurrentWindowID();
			AddBlockPage ABP=BLP.AddBlock_click();
		    GenericClass.windowHandle(a);
		    String blockname=ABP.SaveBlockTitle();
			GenericClass.Switch_Parent_Window(a);
			String actual=BLP.verify_SaveMsg();
			Assert.assertEquals(actual.contains(blockname),true);
			BLP.viewAll();
			BLP.verify_addedBlock(blockname);
			System.out.println("-------------HMS-1513 Executed-------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}

		@Test(priority=14, groups={"P2","BlockTest"},description="Add block with duplicate data. Error massage 'Following ERRORS occurred during submission! - Duplicate Block Name' verified.")
		public void HMS1514() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			String a=GenericClass.GetCurrentWindowID();
			AddBlockPage ABP=BLP.AddBlock_click();
			GenericClass.windowHandle(a);
			String blockname=ABP.SaveBlockTitle();
			GenericClass.Switch_Parent_Window(a);
			BLP.AddBlock_click();
			GenericClass.windowHandle(a);
		    String error=ABP.SaveDuplTitle(blockname);
		    Assert.assertTrue(error.contains(TDMap.get("Error_msg")));
			GenericClass.Switch_Parent_Window(a);
			System.out.println("-----------HMS-1514 Executed-------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}

		@Test(priority=15, groups={"P2","BlockTest"},description="Add block without data. Error message 'Please Enter Block Title' verified.")
		public void HMS1515() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			String a=GenericClass.GetCurrentWindowID();
			AddBlockPage ABP=BLP.AddBlock_click();
			GenericClass.windowHandle(a);
			ABP.save_btn("Accept");
			Assert.assertEquals(GenericClass.value, TDMap.get("Error_msg"));
		    GenericClass.Switch_Parent_Window(a);
		    System.out.println("-----------HMS-1515 Executed--------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
		@Test(priority=16, groups={"P2","BlockTest"},description="To verify Cancel button in Add/Edit a Block page.")
		public void HMS5843() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			String a=GenericClass.GetCurrentWindowID();
			AddBlockPage ABP=BLP.AddBlock_click();
			GenericClass.windowHandle(a);
		    ABP.Cancel();
		    GenericClass.Switch_Parent_Window(a);
		    Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("BlockPage_Title"));
		    System.out.println("------------HMS-5843 Executed-------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}

		@Test(priority=17, groups={"P2","BlockTest"},description="To Cancel button in Add a Block page.")
		public void HMS1516() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			String a=GenericClass.GetCurrentWindowID();
			AddBlockPage ABP=BLP.AddBlock_click();
		    GenericClass.windowHandle(a);
		    ABP.cancelbtnData(TDMap.get("BlockName_ED"));
			GenericClass.Switch_Parent_Window(a);
			Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("BlockPage_Title"));
			BLP.verify_addedBlock(TDMap.get("BlockName_ED"));
			System.out.println("-------------HMS-1516 Executed----------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
		@Test(priority=18, groups={"P2","BlockTest"},description="To verify 'CANCEL' Button on Blocks List page.")
		public void HMS1518() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
		    BLP.cancel_btn();
		    Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("AdminHomePage_Title"));
			System.out.println("-------------HMS-1518 Executed-------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
			
		}
		
		@Test(priority=19, groups={"P1","BlockTest"},description="To verify 'Main' link for BLOCK LIST in a Block.")
		 public void HMS1519_HMS5867() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			 BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			 BLP.mainLink_btn();
			 Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("AdminHomePage_Title"));
			 System.out.println("-------------HMS-1519 Executed---------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
      @Test(priority=20, groups={"P2","BlockTest"},description="To verify all check boxes to select and deselect.")
     public void HMS5854_HMS8837() throws Throwable{
    	  try{
    	  AdminHome AH=new AdminHome();
		 BlocksLandingPage BLP=AH.fn_NavigateBlocks();
	     BLP.SelectAll_checkbox();
		 System.out.println("-------------HMS5854_HMS8837 Executed----------------");
    	  } catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
        }

		@Test(priority=21, groups={"P2","BlockTest"},description="To Verify Select and Deselect Master Check Box.")
		public void HMS1520_HMS8836() throws Throwable{
			try{
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
		    BLP.master_checkbox();
		    System.out.println("-----------HMS1520_HMS8836 Executed----------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		   }

		@Test(priority=22, groups={"P0","BlockTest"},description="Edit any block name and varified all reflected points.")
		public void HMS1521() throws Throwable{
			try{
			AdminHome AH=new AdminHome();
			 BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			 String a=GenericClass.GetCurrentWindowID();
		     AddBlockPage ABP=BLP.edit_block();
		     GenericClass.windowHandle(a);
		     String modifyed=ABP.modifytitle();
		     GenericClass.Switch_Parent_Window(a);
		     String Succesfullymsg=BLP.editBlock_Msg();
		     Assert.assertEquals(Succesfullymsg.contains(modifyed),true);
		     BLP.viewAll();
		     BLP.verify_editedBlock(modifyed);
		     System.out.println("-------------HMS-1521 Executed------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}

		@Test(priority=23, groups={"P2","BlockTest"},description="To verify Cancel Button in Edit a Block page after edit block name.")
		public void HMS1522() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();	 
			 BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			 String a=GenericClass.GetCurrentWindowID();
		     AddBlockPage ABP=BLP.edit_block();
		     GenericClass.windowHandle(a);
		     String modifyblocknme=ABP.edit_cancel();
		     GenericClass.Switch_Parent_Window(a);
		     Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("BlockPage_Title"));
		     BLP.verify_ModidfyedBlock(modifyblocknme);
		     System.out.println("-------------HMS-1522 Executed------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
	
		
		@Test(priority=24, groups={"P2","BlockTest"},description="Sorted Block to Clicking Upward and Downward Arrow.")
		public void HMS1523_HMS8688() throws Throwable{
			try{
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			BLP.Sort_BlockTitle();
			System.out.println("-------------HMS1523_HMS8688 Executed--------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}

		@Test(priority=25, groups={"P2","BlockTest"},description="To verify Next Link in BLOCK LIST page.")
		public void HMS1570() throws Throwable{
			try{
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			BLP.next_link();
		    System.out.println("-------------HMS-1570 Executed-----------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}

		@Test(priority=26, groups={"P1","BlockTest"},description="To verify Previous Link in BLOCK LIST page.")
		public void HMS5872() throws Throwable{
			try{
			AdminHome AH=new AdminHome();
			  BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			  BLP.previous_link();
			  System.out.println("----------HMS-5872 Executed----------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
		@Test(priority=27, groups={"P2","BlockTest"},description="To verify Page dropdown in Block List Page.")
		public void HMS5880() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			String pagenumber=BLP.Page_dropdown(TDMap.get("PageNumber_DD"));
			Assert.assertEquals(pagenumber, TDMap.get("PageNumber_DD"));
			System.out.println("--------------HMS-5880 Executed-------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
		@Test(priority=28, groups={"P1","BlockTest"},description="Deactivate Block and verified reflected point.")
		public void HMS5876() throws Throwable{
			try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			BLP.blockStatus(TDMap.get("ActiveStatus_SR"),TDMap.get("DeActiveStatus_SR"));
			System.out.println("--------------HMS-5876 Executed------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
	  @Test(priority=29, groups={"P1","BlockTest"},description="To verify View records per page in Block List.")
	  public void HMS5881() throws Throwable{
		  try{
		  String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Block_Path, Block_Sheet,TC_ID);
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			BLP.view(TDMap.get("ViewRecord_DD"));
			System.out.println("-------HMS-5881 Executed--------");
		  } catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
	      }
	  
		@Test(priority=30, groups={"P1","BlockTest"},description="To click on Audit Trail link and check updated history in audittrail page.")                                    
		public void HMS5879() throws Throwable{
			try{
			AdminHome AH=new AdminHome();
			    BlocksLandingPage BLP=AH.fn_NavigateBlocks();
				String a=GenericClass.GetCurrentWindowID();
				AddBlockPage ABP=BLP.AddBlock_click();
				GenericClass.windowHandle(a);
				ABP.SaveBlockTitle();
				GenericClass.Switch_Parent_Window(a);
			    AuditTrialBlock ATB=BLP.auditTrial();
			    GenericClass.windowHandle(a);
				ATB.auditTrailHistory();
			    GenericClass.Switch_Parent_Window(a);
				System.out.println("-----------HMS-5879 Executed-------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		  
		@Test(priority=31, groups={"P1","BlockTest"},description="To verify Sort by Status by clicking downward and upward arrow.")
		public void HMS1524_HMS8689() throws Throwable{
			try{
			AdminHome AH=new AdminHome();
			BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			BLP.SortBlock_ByStatus();
			System.out.println("---------HMS1524_HMS8689 Executed--------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		    }
		
		@Test(priority=32, groups={"P1","BlockTest"},description="To Verify 'ADD A BLOCK' button on Block List page.")
		public void HMS8555() throws Throwable{
			try{
			AdminHome AH=new AdminHome();
			 BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			 String a=GenericClass.GetCurrentWindowID();
			 AddBlockPage ABP=BLP.AddBlock_click();
			 GenericClass.windowHandle(a);
			 ABP.verify_AddBlockPage();
			 GenericClass.Switch_Parent_Window(a);
			 
			// BlocksLandingPage.verify_pge();
			 System.out.println("-------------HMS-8555 Executed------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		}
		
		@Test(priority=33, groups={"P2","BlockTest"},description="To verify alert massage after select any blockname and click on delete button.")
		public void HMS1517() throws Throwable{
			try{
			 AdminHome AH=new AdminHome();
			 BlocksLandingPage BLP=AH.fn_NavigateBlocks();
			 BLP.delete_block("Dismiss");
		     System.out.println("-------------------HMS-1517 Executed----------------");
			} catch (Throwable e){
				GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				throw e;
			}
		   }
	
		@AfterMethod
		public void closeApp() throws Throwable{
			Set<String> handles = GenericClass.driver.getWindowHandles();
			for(String windowId: handles){
				GenericClass.driver.switchTo().window(windowId);
				GenericClass.driver.close();
			}
		    }



}
