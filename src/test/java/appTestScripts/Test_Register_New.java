package appTestScripts;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import appPages.RegisterPage;
import configuration.Config;
import io.netty.handler.codec.http.HttpContentEncoder.Result;
import methods.Keywords;
import reporter.ExtentReporter;

public class Test_Register_New {
	
	public ExtentHtmlReporter htmlReporter;

	public ExtentReports extent;

	public ExtentTest test;
	
	int testResult;
	Keywords k = new Keywords();
	Properties pr = new Properties();
	String dataFilePath = "src\\test\\java\\testDataProviders\\testData.properties";
	
	
	
	@BeforeTest 
	  public void testSetup() throws Exception
	  { 
		  htmlReporter = new ExtentHtmlReporter("Extent_Report.html");
		  htmlReporter.config().setDocumentTitle("Test run report");
		  
		  extent= new ExtentReports();
		  extent.attachReporter(htmlReporter);
		  
		  //ExtentReporter.extReportSetup();
		  FileReader fr = new FileReader(new File(dataFilePath));
		  pr.load(fr);
		  k.lanuchBrowser(pr.getProperty("browser"));
		  
	  }
	 
	@Test
	public void registration() {
		
		test = extent.createTest("Registration Test");
		
		RegisterPage objPgRegister = new RegisterPage(Config.driver);
		
		k.navigateToURL(pr.getProperty("url"));
		
		test.log(Status.INFO, "Application Launched");
		
		objPgRegister.enterFirstName(pr.getProperty("firstmame"));
		
		objPgRegister.enterLastName(pr.getProperty("lastname"));
		
		objPgRegister.enterAddress(pr.getProperty("address"));
		
		objPgRegister.enterEmail(pr.getProperty("email"));
		
		objPgRegister.enterPhNumber(pr.getProperty("phone"));
		
		objPgRegister.clickMaleRadio();
		
		objPgRegister.clickCricketChb();
		
		objPgRegister.selectCountryDD(pr.getProperty("country"));
		
		objPgRegister.selectBirthYearDD(pr.getProperty("year"));
		
		objPgRegister.selectBirthMonthDD(pr.getProperty("month"));
		
		objPgRegister.selectBirthDayDD(pr.getProperty("day"));
		
		objPgRegister.enterPassword(pr.getProperty("password"));
		
		objPgRegister.reenterPassword(pr.getProperty("password"));
		
		test.log(Status.INFO, "Password set");
		
		objPgRegister.clickSubmitBtn();
		
		test.log(Status.INFO, "Form Sumbmitted");
		
		objPgRegister.verifyEDITtestPresent();
		
		test.log(Status.PASS, "Registration completed successfuly");
	}
	@AfterTest
	public void endTest(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName() + " : Fail");
			//test.log(Status.FAIL, "Reason: "+result.getThrowable());
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " : Pass");
			
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getName() + " : Skipped");
			
		}
		else
		{
			test.log(Status.FAIL, result.getName()+" : Aborted");
			//test.log(Status.FAIL, "Reason: "+result.getThrowable());
			
		}

		extent.flush();

	}

}
