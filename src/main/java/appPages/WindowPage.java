package appPages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import methods.Keywords;

public class WindowPage {
	
	private static Keywords k = new Keywords();
	WebDriver driver;
	WebElement element;
	
	
	By clickBtn = By.xpath("//button[contains(text(),'    click   ')]");
	
	By homeLink = By.xpath("//ul[@class='nav navbar-nav navbar-right']/li/a[@class='active' and contains(text(),'Home')]");
	
	public WindowPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnBtn() {
		element = k.elementCreator(clickBtn);
		element.click();
	}
	
	public void switchToNewWindow(String title) {
		
		String parentWindow = driver.getWindowHandle();
		Set<String> wins = driver.getWindowHandles();
		for(String s:wins) {
			driver.switchTo().window(s);
			if(!(s==parentWindow) && driver.getTitle().equalsIgnoreCase(title)) {
				break;
			}
		}
	}
	
	public void clickHomeLink() {
		element = k.elementCreator(homeLink);
		element.click();
	}
	
	public void switchToParentWindow() {
		driver.switchTo().defaultContent();
	}

}
