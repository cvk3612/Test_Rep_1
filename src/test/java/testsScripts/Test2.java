package testsScripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import methods.Keywords;
import reporter.ExtentReporter;

public class Test2 {

	@BeforeTest
	public void setUP() {

		ExtentReporter.extReportSetup();

	}
	@Test
	public void runTest() {

		ExtentReporter.extReportTestDesc("Google Launcher", "Functionality of hitting google search");
		Keywords k = new Keywords();
		k.lanuchBrowser("ch");
		ExtentReporter.testLog("Browser has been launched");
		k.navigateToURL("https://www.google.com");
		ExtentReporter.testLog("URL hit");

	}
	@AfterTest
	public void endTest() {

		ExtentReporter.extReportFlusher();

	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		ExtentReporter.testTearDown(result);
	}

}
