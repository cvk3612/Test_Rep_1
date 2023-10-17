package appTestScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass1 {
	
	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "G:\\MylockedfolderG\\ChromeDriver\\chromedriver.exe");
	ChromeOptions op = new ChromeOptions();
	op.setAcceptInsecureCerts(true);
	WebDriver driver = new ChromeDriver(op);
	String objXpath = "//*[local-name()='svg' and @class='goxjub']";
	String txtBoxCss = "input.gLFyf";
	String linkCss = "a[href='https://www.netflix.com/ca/']";
	driver.manage().window().maximize();
	driver.get("https://www.google.com");
	
	@SuppressWarnings("deprecation")
	Wait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(objXpath))));
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath(objXpath)));
	act.build().perform();
	
	driver.findElement(By.cssSelector(txtBoxCss)).sendKeys("netflix"+"\n");
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(linkCss)));
	
	driver.findElement(By.cssSelector(linkCss)).click();
	
	try {
		Thread.sleep(10000);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	String parentWindow = driver.getWindowHandle();
	Set<String> allWindows = driver.getWindowHandles();
	for(String s:allWindows) {
		driver.switchTo().window(s);
		String currentWinTitle = driver.getTitle();
		if(currentWinTitle.equalsIgnoreCase("test")) {
			break;
		}
	}
	driver.switchTo().defaultContent();
	
	String frameLocator = "";
	//driver.switchTo().frame(frameElement);
	
	}
}
