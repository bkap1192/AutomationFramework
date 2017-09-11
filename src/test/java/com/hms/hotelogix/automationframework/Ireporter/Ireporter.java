package com.hms.hotelogix.automationframework.Ireporter;


import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;

public class Ireporter implements IReporter{
	private static ExtentReports extent;
	public static ExtentTest test;
	
	
	
	public static void getstarttime(){
	//	test=RoomsTest.test;
		test.setStartedTime(new Date());
	}
	
	public static ExtentReports getExtent(){
		return extent = new ExtentReports("Reports\\" + File.separator + "ExtentReportTestNG.html", true);
	}
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
     //   extent = new ExtentReports("Report\\" + File.separator + "ExtentReportTestNG.html", true);
    	try{
    	extent =getExtent();
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
  
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
  
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }
        extent.flush();
        extent.close();
    	}catch(Exception e){
    		try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
    	    }
            }
  
    public void buildTestNodes(IResultMap tests, LogStatus status) throws Exception {
         if (tests.size() > 0) {
             for (ITestResult result : tests.getAllResults()) {
            	
                test = extent.startTest(result.getInstanceName().split("\\.")[7]+" :: "+result.getMethod().getMethodName());
                test.setStartedTime(getTime(result.getStartMillis()));
                 test.setEndedTime(getTime(result.getEndMillis()));
                 for (String group : result.getMethod().getGroups())
                     test.assignCategory(group);
                 if (result.getThrowable() != null) {
                	 test.log(status, test.addScreenCapture("E:\\AutomationFramework\\Snapshot\\"+ result.getMethod().getMethodName()+".jpg"),result.getThrowable());
                 }else{
                     test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                 } 
                 extent.endTest(test);
            }
            }
            }
  
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();        
    }

}
