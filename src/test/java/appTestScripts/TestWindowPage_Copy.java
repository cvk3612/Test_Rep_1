package appTestScripts;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appPages.AlertPage;
import appPages.WindowPage;
import configuration.Config;
import methods.Keywords;
import reporter.ExtentReporter;

public class TestWindowPage {
	
	int testResult;
	Keywords k = new Keywords();
	Properties pr = new Properties();
	String dataFilePath = "src\\test\\java\\testDataProviders\\windowTest.properties";

	@BeforeTest
	public void testSetup() throws Exception {
		ExtentReporter.extReportSetup();
		FileReader fr = new FileReader(new File(dataFilePath));
		pr.load(fr);
		k.lanuchBrowser(pr.getProperty("browser"));

}
	
	@Test
	public void windowSwitchTest() {

		WindowPage objPgWindow = new WindowPage(Config.driver);
		k.navigateToURL(pr.getProperty("url"));
		objPgWindow.clickOnBtn();
		objPgWindow.switchToNewWindow("Sakinalium | Home");
		try {
		Thread.sleep(30000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		objPgWindow.clickHomeLink();
		objPgWindow.switchToParentWindow();

	}
	
	@AfterTest
	public void endTest() {

		ExtentReporter.extReportFlusher();

	}

	/*
	 * @AfterMethod public void tearDown(ITestResult result) {
	 * ExtentReporter.testTearDown(result); }
	 */

}