package appPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import methods.Keywords;

public class EJLoginPage {
	
	private static Keywords k = new Keywords();
	WebDriver driver;
	WebElement element;
	
	By LPTBusername = By.xpath("//input[@name='uname']");
	By LPTBpassword = By.id("pwd");
	By LPDDcountry = By.xpath("//select");
	By LPRBemployee = By.xpath("//input[@value='EMPLOYEE']");
	By LPBTlogin = By.xpath("//input[@name='imageField']");
	
	public EJLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
    public void inputUserNameTB(String name) {
		
		element = k.elementCreator(LPTBusername);
		element.clear();
		element.sendKeys(name);
	}
    
    public void inputPasswordTB(String name) {
		
		element = k.elementCreator(LPTBpassword);
		element.clear();
		element.sendKeys(name);
	}
    
    public void selectCountryDD(String country) {
    	element = k.elementCreator(LPDDcountry);
    	Select s = new Select(element);
    	s.selectByVisibleText(country);
    }
    
    public void clickEmpRB() {
		element = k.elementCreator(LPRBemployee);
		element.click();
	}

    public void clickLoginBT() {
		element = k.elementCreator(LPBTlogin);
		element.click();
	}

}
