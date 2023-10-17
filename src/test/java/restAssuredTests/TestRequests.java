package restAssuredTests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import reporter.ExtentReporter;
import restAssuredMethods.RestAssuredKeywords;

public class TestRequests {
	
	Properties pr = new Properties();
	String dataFilePath = "src\\test\\java\\testDataProviders\\requestData.properties";
	
	
	
	  @BeforeTest 
	  public void testSetup() throws Exception
	  { 
		  ExtentReporter.extReportSetup();
		  FileReader fr = new FileReader(new File(dataFilePath));
		  pr.load(fr);
	  }  
	  @Test
	  public void getRequestValidation() {
		  RestAssuredKeywords.getRequest(pr.getProperty("getRequestURL"));
		  ExtentReporter.testLog("Get Request validation successfull");
		  RestAssuredKeywords.postRequest(pr.getProperty("getRequestURL"), pr.getProperty("postRequestParameters"));
		  ExtentReporter.testLog("Post Request validation successfull");
		  RestAssuredKeywords.putRequest(pr.getProperty("getRequestURL"), pr.getProperty("putRequestParameters"));
		  ExtentReporter.testLog("Put Request validation successfull");
		  RestAssuredKeywords.deleteRequest(pr.getProperty("getRequestURL"));
		  ExtentReporter.testLog("Delete Request validation successfull");
	  }
	  
	  @AfterTest
		public void endTest() {

			ExtentReporter.extReportFlusher();

		}
	  
	  TestAPI obj = new TestAPI("Peter");

}
