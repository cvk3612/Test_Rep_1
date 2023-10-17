package methods;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.utils.FileUtil;

import configuration.Config;

public class Keywords {
	
	private static long defaultWaitTime = 60;
	
	public void lanuchBrowser(String browsername) {
		if(browsername.equalsIgnoreCase("ch")||browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\broswers\\chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--start-maximized");
			Config.driver = new ChromeDriver(op);
		}
		else if(browsername.equalsIgnoreCase("ff")||browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src\\main\\java\\broswers\\geckodriver.exe");
			FirefoxOptions op = new FirefoxOptions();
			op.addArguments("--start-maximized");
			Config.driver = new FirefoxDriver(op);
		}
	}
	
	public void navigateToURL(String url) {
		Config.driver.navigate().to(url);
	}
	
	public void takeSnapShotOfStep(String dest) {
		TakesScreenshot ts = (TakesScreenshot)Config.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File finalFile = new File(dest);
		try {
			FileUtils.copyFile(source, finalFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebElement elementCreator(By locator) {
		
		WebElement element = Config.driver.findElement(locator);
		
		if(element == null) {
			waitForElement(element, defaultWaitTime);
			if(element == null) {
			System.out.println("Element not found");
			Config.driver.quit();
			}
		}
		return element;
	}
	
	@SuppressWarnings("deprecation")
	public void waitForElement(WebElement element, long sec) {
		Wait wait = new WebDriverWait(Config.driver, sec );
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		
	}
	
	public List<WebElement> findAllElements(By loc){
		List<WebElement> elements = Config.driver.findElements(loc);
		return elements;
 	}
	
	

}
