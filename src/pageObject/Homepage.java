package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {

	WebDriver driver;

	public Homepage(WebDriver driver) {

		this.driver = driver;
	}

	By attend = By.xpath("//span[(@class='MenuItem_menu-item__inner-wrapper__1trJ0')]/span[contains(text(), 'Attend')]");
	By workshop = By.xpath("//span[@class='MenuItem_subtitle__3LoiE']/span[contains(text(),'Workshops')]");
	By go = By.name("proceed");
	By home = By.linkText("Home");

	public void verifyTitle() {
		String title = driver.getTitle(); // get's the title of the page

		if (title.equals("WW (Weight Watchers): Weight Loss & Wellness Help | WW USA"))
			System.out.println("Title Asserted true: " + title);
		else
			System.out.println("Incorrect title and the correct title is " + title);

	}

	public WebElement attend() {
		return driver.findElement(attend);
	}

	public WebElement workshop() {
		return driver.findElement(workshop);
	}

}
