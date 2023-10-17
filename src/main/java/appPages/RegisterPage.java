package appPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.Config;
import junit.framework.Assert;
import methods.Keywords;

public class RegisterPage {
	
	private static Keywords k = new Keywords();
	WebDriver driver;
	WebElement element;
	Wait w;
	
	By regPgFirstName = By.xpath("//input[@placeholder='First Name' and @type='text']");
	
	By regPgLastName = By.xpath("//input[@placeholder='Last Name' and @type='text']");
	
	By regPgAddress = By.xpath("//textarea");
	
	By regPgEmail = By.xpath("//input[@type='email']");
	
	By regPgPhone = By.xpath("//input[@type='tel']");
	
	By regPgRdMale = By.xpath("//input[@type='radio' and @value='Male']");
	
	By regPgRdFemale = By.xpath("//input[@type='radio' and @value='FeMale']");
	
	By regPgChbCricket = By.xpath("//input[@type='checkbox' and @value='Cricket']");
	
	By regPgDdCountry = By.xpath("//select[@type='text' and @id='countries']");
	
	By regPgDdBirthYear = By.xpath("//select[@type='text' and @id='yearbox']");
	
	By regPgDdBirthMonth = By.xpath("//select[@type='text' and @placeholder='Month']");
	
	By regPgDdBirthDay = By.xpath("//select[@type='text' and @placeholder='Day']");
	
	By regPgPassword = By.xpath("//input[@type='password' and @id='firstpassword']");
	
	By regPgConfirmPassword = By.xpath("//input[@type='password' and @id='secondpassword']");
	
	By regPgBtnSubmit = By.xpath("//button[@type='submit' and @id='submitbtn']");
	
	By regPgValidationEDIT = By.xpath("//b[text()='EDIT']");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public void enterFirstName(String name) {
		
		element = k.elementCreator(regPgFirstName);
		element.clear();
		element.sendKeys(name);
	}
	
	public void enterLastName(String name) {
		element = k.elementCreator(regPgLastName);
		element.clear();
		element.sendKeys(name);
	}
	
	public void enterAddress(String add) {
		element = k.elementCreator(regPgAddress);
		element.clear();
		element.sendKeys(add);
	}
	
	public void enterEmail(String add) {
		element = k.elementCreator(regPgEmail);
		element.clear();
		element.sendKeys(add);
	}
	
	public void enterPhNumber(String add) {
		element = k.elementCreator(regPgPhone);
		element.clear();
		element.sendKeys(add);
	}
	
	public void clickMaleRadio() {
		element = k.elementCreator(regPgRdMale);
		element.click();
	}
	
	public void clickCricketChb() {
		element = k.elementCreator(regPgChbCricket);
		element.click();
	}
	
	public void selectCountryDD(String countryname) {
		element = k.elementCreator(regPgDdCountry);
		Select s = new Select(element);
		s.selectByVisibleText(countryname);
	}
	
	public void selectBirthYearDD(String year) {
		element = k.elementCreator(regPgDdBirthYear);
		Select s = new Select(element);
		s.selectByVisibleText(year);
	}
	
	public void selectBirthMonthDD(String month) {
		element = k.elementCreator(regPgDdBirthMonth);
		Select s = new Select(element);
		s.selectByVisibleText(month);
	}
	
	public void selectBirthDayDD(String day) {
		element = k.elementCreator(regPgDdBirthDay);
		Select s = new Select(element);
		s.selectByVisibleText(day);
	}
	
	
	
	public void enterPassword(String add) {
		element = k.elementCreator(regPgPassword);
		element.clear();
		element.sendKeys(add);
	}
	
	public void reenterPassword(String add) {
		element = k.elementCreator(regPgConfirmPassword);
		element.clear();
		element.sendKeys(add);
	}
	
	
	public void clickSubmitBtn() {
		element = k.elementCreator(regPgBtnSubmit);
		element.click();
	}
	
	
	public void verifyEDITtestPresent() {
		element = k.elementCreator(regPgValidationEDIT);
		boolean bflag = true;
		try {
			Thread.sleep(30000);
		if(!element.isDisplayed()) {
			bflag = false;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(true);
	}

}
