package appPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import methods.Keywords;

public class FramesPage {
	
	private static Keywords k = new Keywords();
	WebDriver driver;
	WebElement element;
	
	
	By linkIFrameWithinIframe = By.xpath("//a[text()='Iframe with in an Iframe']");
	
	By homeLink = By.xpath("//ul[@class='nav navbar-nav navbar-right']/li/a[@class='active' and contains(text(),'Home')]");
	
	public FramesPage(WebDriver driver) {
		this.driver = driver;
	}

}
