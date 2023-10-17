package appPages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import methods.Keywords;

public class DatepickerPage {
	
	private static Keywords k = new Keywords();
	WebDriver driver;
	WebElement element;
	List<WebElement> elements;
	
	
	By calendarBtn = By.xpath("//img[contains(@src,'calendar')]");
	
	By monthPickerTxt = By.xpath("//span[@class='ui-datepicker-month']");
	
	By yearPickerTxt = By.xpath("//span[@class='ui-datepicker-year']");
	
	By calPrevBtn = By.xpath("//span[text()='Prev']");
	
	By allcells = By.xpath("//table//tbody/tr/td");
	
	public DatepickerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnBtn() {
		element = k.elementCreator(calendarBtn);
		element.click();
	}
	
	public void selectDate(String way, String year, String month, String day) {
		if(way.equalsIgnoreCase("current")) {
			elements = k.findAllElements(allcells);
			for(WebElement el:elements) {
				String curDay = el.getText();
				if(curDay.trim().equalsIgnoreCase(day.trim())){
					el.click();
					break;
				}
				
			}
		}
		
		else if(way.equalsIgnoreCase("back")) {
			
		}
	}
	
	
	
	

}
