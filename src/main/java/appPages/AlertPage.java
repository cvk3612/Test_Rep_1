package appPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import methods.Keywords;

public class AlertPage {
		
		private static Keywords k = new Keywords();
		WebDriver driver;
		WebElement element;
		
		By continueBtn = By.xpath("//*[contains(text(),'click the button to display an  alert box')]");
		
		public AlertPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void clickContnueBtn() {
			element = k.elementCreator(continueBtn);
			element.click();
		}
		
		public void acceptAlert() {
			
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
		}

}
