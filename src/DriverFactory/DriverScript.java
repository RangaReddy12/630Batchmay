package DriverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExcelFileUtil;
import CommonFunLibrary.CommonFunctions;
import Constant.PBConstant;

public class DriverScript extends PBConstant{
String inputpath="C:\\6.30Batch\\Selenium_FrameWorks\\TestInput\\Controller.xlsx";
String outputpath="C:\\6.30Batch\\Selenium_FrameWorks\\TestOutput\\Keyword.xlsx";
String TCSheet="TestCases";
String TSSheet="TestSteps";
ExtentReports report;
ExtentTest test;
@Test
public void statrTest()throws Throwable
{
	report=new ExtentReports("./ExtentReports/keyword.html");
	boolean res=false;
	String tcres=null;
	//access excel methods
	ExcelFileUtil xl=new ExcelFileUtil(inputpath);
//count no of rows in TCsheet
	int TCcount=xl.rowCount(TCSheet);
	//count no of rows in TSSheet
	int TScount=xl.rowCount(TSSheet);
	Reporter.log(TCcount+"    "+TScount,true);
	for(int i=1;i<=TCcount;i++)
	{
		//start test case here
		test=report.startTest("Keyword Framework");
	//read execute column from TCSheet
String execute=xl.getCellData(TCSheet, i, 2);
if(execute.equalsIgnoreCase("Y"))
{
//read tcid column from TCSheet
	String tcid=xl.getCellData(TCSheet, i, 0);
	for(int j=1;j<=TScount;j++)
	{
		//read description column from TSSheet
		String Description=xl.getCellData(TSSheet, j, 2);
	//read tsid column from TSsheet
String tsid=xl.getCellData(TSSheet, j, 0);
if(tcid.equalsIgnoreCase(tsid))
{
	//read keyword column from TSsheet
	String keyword=xl.getCellData(TSSheet, j, 3);
	if(keyword.equalsIgnoreCase("AdminLogin"))
	{
		//class login method
	res=CommonFunctions.verifyLogin("Admin", "Admin");
	test.log(LogStatus.INFO, Description);
	}
	else if(keyword.equalsIgnoreCase("NewBranchCreation"))
	{
	CommonFunctions.navigateBranches();
	res=CommonFunctions.verifyBranch("kadiri", "anantapur", "kadiri", "madanapalli", "tanakal", "12345", 1, 1, 1);
	test.log(LogStatus.INFO, Description);
	}
	else if(keyword.equalsIgnoreCase("UpdateBranch"))
	{
		CommonFunctions.navigateBranches();
		res=CommonFunctions.verifyupdatebranch("ameerpet", "hyderabad");
		test.log(LogStatus.INFO, Description);
	}
	else if(keyword.equalsIgnoreCase("AdminLogout"))
	{
		res=CommonFunctions.verifyLogout();
		test.log(LogStatus.INFO, Description);
	}
	String tsres=null;
	if(res)
	{
		//write as pass into results column
		tsres="Pass";
		xl.setCellData(TSSheet, j, 4, tsres, outputpath);
		test.log(LogStatus.PASS, Description);
	}
	else
	{
		//write as fail into results column
		tsres="Fail";
		xl.setCellData(TSSheet, j, 4, tsres, outputpath);
		test.log(LogStatus.FAIL, Description);
	}
	if(!tsres.equalsIgnoreCase("Fail"))
	{
		tcres=tsres;
	}
}
report.endTest(test);
report.flush();
}
//write into TCsheet
xl.setCellData(TCSheet, i, 3, tcres, outputpath);	
}
else
{
	//write as Blocked in results column
	xl.setCellData(TCSheet, i, 3, "Blocked", outputpath);
	
}
	}
	
}












}
