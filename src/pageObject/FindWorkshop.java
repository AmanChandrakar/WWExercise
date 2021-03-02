package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindWorkshop {
	WebDriver driver;

	public FindWorkshop(WebDriver driver) {

		this.driver = driver;

	}

	By studio = By.xpath("//span[contains(text(), 'Studio')]");
	By zipcode = By.xpath("//input[@id='location-search']");
	By find = By.xpath("//button[@id='location-search-cta']");
	By studios = By.cssSelector("div.container-3SE46");
	By studioName = By.cssSelector("div.linkContainer-1NkqM");
	By studioDistance = By.xpath("//span[@class='distance-OhP63']");

	public void verifyTitle() {
         
		String title = driver.getTitle(); // get's the title of the page
		
		// Question2. Step 4) asserts the title of the page
		if (title.equals("Find WW Studios & Meetings Near You | WW USA"))
			System.out.println("Title Asserted true: " + title);
		else
			System.out.println("Incorrect Title2 and correct Title2 is " + title);
    }

	public WebElement studio() {
		return driver.findElement(studio);
	}

	public WebElement zipcode() {
		return driver.findElement(zipcode);
	}

	public WebElement find() {
		return driver.findElement(find);
	}

	public void scroll_to_bottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public String print_title() {
		
		List<WebElement> studiosList = driver.findElements(studios);
		WebElement element1 = studiosList.get(0).findElement(studioName);
		String name = element1.getText();
		return name;
		
		
	}
	
	public String print_distance() {
		
		java.util.List<WebElement> studiosList = driver.findElements(studios);
		WebElement element2 = studiosList.get(0).findElement(studioDistance);
		String distance = element2.getText();
		return distance;
		
	}
	
	public WebElement first_studio() {
		
		List<WebElement> studiosList = driver.findElements(studios);
		WebElement element1 = studiosList.get(0).findElement(studioName);
		return element1;
		
	}
}
