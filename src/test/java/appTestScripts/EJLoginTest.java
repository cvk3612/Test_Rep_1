package appTestScripts;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appPages.EJLoginPage;
import appPages.RegisterPage;
import configuration.Config;
import io.netty.handler.codec.http.HttpContentEncoder.Result;
import methods.Keywords;
import reporter.ExtentReporter;

public class EJLoginTest {
	
	Keywords k = new Keywords();
	Properties pr = new Properties();
	String dataFilePath = "src\\test\\java\\testDataProviders\\EJLoginPageData.properties";
	
	  @BeforeTest 
	  public void testSetup() throws Exception
	  { 
		  FileReader fr = new FileReader(new File(dataFilePath));
		  pr.load(fr);
		  k.lanuchBrowser(pr.getProperty("browser"));
		  k.navigateToURL(pr.getProperty("url"));
	  }
	 
	@Test
	public void loginTest() {
		
		EJLoginPage objEJLP = new EJLoginPage(Config.driver);
		objEJLP.inputUserNameTB(pr.getProperty("username"));
		objEJLP.inputPasswordTB(pr.getProperty("password"));
		objEJLP.selectCountryDD(pr.getProperty("country"));
		objEJLP.clickEmpRB();
		objEJLP.clickLoginBT();
	}
	

}
