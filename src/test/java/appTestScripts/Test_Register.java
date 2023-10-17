package appTestScripts;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appPages.RegisterPage;
import configuration.Config;
import io.netty.handler.codec.http.HttpContentEncoder.Result;
import methods.Keywords;
import reporter.ExtentReporter;

public class Test_Register {
	
	int testResult;
	Keywords k = new Keywords();
	Properties pr = new Properties();
	String dataFilePath = "src\\test\\java\\testDataProviders\\testData.properties";
	
	
	
	  @BeforeTest 
	  public void testSetup() throws Exception
	  { 
		  ExtentReporter.extReportSetup();
		  FileReader fr = new FileReader(new File(dataFilePath));
		  pr.load(fr);
		  k.lanuchBrowser(pr.getProperty("browser"));
		  
	  }
	 
	@Test
	public void registration() {
		
		RegisterPage objPgRegister = new RegisterPage(Config.driver);
		k.navigateToURL(pr.getProperty("url"));
		ExtentReporter.testLog("Application launched");
		objPgRegister.enterFirstName(pr.getProperty("firstmame"));
		ExtentReporter.testLog("Firstname entered");
		objPgRegister.enterLastName(pr.getProperty("lastname"));
		ExtentReporter.testLog("Lastname entered");
		objPgRegister.enterAddress(pr.getProperty("address"));
		ExtentReporter.testLog("Address entered");
		objPgRegister.enterEmail(pr.getProperty("email"));
		ExtentReporter.testLog("Email entered");
		objPgRegister.enterPhNumber(pr.getProperty("phone"));
		ExtentReporter.testLog("Phone entered");
		objPgRegister.clickMaleRadio();
		ExtentReporter.testLog("Gender selected");
		objPgRegister.clickCricketChb();
		ExtentReporter.testLog("Hobies selected");
		objPgRegister.selectCountryDD(pr.getProperty("country"));
		ExtentReporter.testLog("Country selected");
		objPgRegister.selectBirthYearDD(pr.getProperty("year"));
		objPgRegister.selectBirthMonthDD(pr.getProperty("month"));
		objPgRegister.selectBirthDayDD(pr.getProperty("day"));
		ExtentReporter.testLog("DOB selected");
		objPgRegister.enterPassword(pr.getProperty("password"));
		objPgRegister.reenterPassword(pr.getProperty("password"));
		ExtentReporter.testLog("Passwotd set");
		objPgRegister.clickSubmitBtn();
		ExtentReporter.testLog("Submit clicked");
		objPgRegister.verifyEDITtestPresent();
		ExtentReporter.testLog("Validation successful");
	}
	@AfterTest
	public void endTest() {

		ExtentReporter.extReportFlusher();

	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
	}

}
