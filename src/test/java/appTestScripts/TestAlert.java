package appTestScripts;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appPages.AlertPage;
import appPages.RegisterPage;
import configuration.Config;
import methods.Keywords;
import reporter.ExtentReporter;

public class TestAlert {

	int testResult;
	Keywords k = new Keywords();
	Properties pr = new Properties();
	String dataFilePath = "src\\test\\java\\testDataProviders\\alertData.properties";

	@BeforeTest
	public void testSetup() throws Exception {
		ExtentReporter.extReportSetup();
		FileReader fr = new FileReader(new File(dataFilePath));
		pr.load(fr);
		k.lanuchBrowser(pr.getProperty("browser"));

	}

	@Test
	public void handleAlert() {

		AlertPage objPgAlert = new AlertPage(Config.driver);
		k.navigateToURL(pr.getProperty("url"));
		objPgAlert.clickContnueBtn();
		objPgAlert.acceptAlert();

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
