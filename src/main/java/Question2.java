package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Question2 {
	// static String exePath =
	// "C:\\Users\\chand\\Downloads\\chromedriver_win32\\chromedriver.exe";

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		String exePath = "src/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximizes the window

		// Question2. Step 1) Navigates to WW website
		driver.get("https://www.weightwatchers.com/us/");
		String title = driver.getTitle(); // get's the title of the page

		
		//Question2. Step 2) Asserts the title of the page 
        if(title.equals("WW (Weight Watchers): Weight Loss & Wellness Help | WW USA"))
		    System.out.println("Title Asserted true: " + title); 
        else
		    System.out.println("Incorrect title and the correct title is " + title);
		driver.findElement(By.xpath("//span[(@class='MenuItem_menu-item__inner-wrapper__1trJ0')]/span[contains(text(), 'Attend')]")) .click(); //clicks the Attend icon at the top right corner
		Thread.sleep(1000);
		
		//Question2. Step 3) Click on the Unlimited Workshops option
		 driver.findElement(By.xpath("//span[@class='MenuItem_subtitle__3LoiE']/span[contains(text(),'Workshops')]")).click(); // clicks the Unlimited Workshops option
		 WebDriverWait wait = new WebDriverWait(driver, 130);
		 Thread.sleep(1000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='buttonText-3DCCO' and contains(text(),'Studio')]"))); //explicit wait till the element is visible 
		 String title2 = driver.getTitle(); //get's the title of new page

		//Question2. Step 4) asserts the title of the page 
		 if (title2.equals("Find WW Studios & Meetings Near You | WW USA"))
			 System.out.println("Title Asserted true: " + title2);
		 else
			 System.out.println("Incorrect Title2 and correct Title2 is " + title2);
		 driver.findElement(By.xpath("//span[contains(text(), 'Studio')]")).click(); //clicks on studio
		
		//Question2. Step 5) Search zipcode 10011
		 driver.findElement(By.xpath("//input[@id='location-search']")).sendKeys("10011");
		 driver.findElement(By.xpath("//button[@id='location-search-cta']")).click(); // clicks on find
		 Thread.sleep(1000);
		
         JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //scroll the page till the bottom of the page List<WebElement> studios =
		 Thread.sleep(1000);
		 List<WebElement> studios = driver.findElements(By.xpath("//div[@class='container-3SE46']")); //saves all web elements of search results
		 Thread.sleep(2000);
		 try
		 {
			 //Thread.sleep(2000);
			 WebElement titleWebElement = studios.get(0).findElement(By.cssSelector("div.linkContainer-1NkqM")); //saves web elements for the first's search result studio
			 String title1 = titleWebElement.getText(); // get name of first element
			 String distance = studios.get(0).findElement(By.xpath("//span[@class='distance-OhP63']")).getText(); //saves the distance of the first element of search result
			 WebElement element = driver.findElement(By.xpath("//input[@class='input input-3TfT5']"));
			 js.executeScript("arguments[0].scrollIntoView();", element);
			 
			 //Question2) Step 6) prints name and distance of studio
			 System.out.println(title1);
			 System.out.println(distance);
			 
			 //Question2) Step 7) clicks first result and verify name matches with the previous screen
			 titleWebElement.click();
			 Thread.sleep(1000);
			 //String title3 = driver.getTitle(); // get's title of the page
			 //System.out.println(title3); // prints title of the page
			 String studioName = driver.findElement(By.xpath("//h1[contains(@class,'locationName')]")).getText();
			 if (title1.contentEquals(studioName)) // asserts name
					System.out.println("Studio name maches");
			 else
					System.out.println("Studio name does not mache");
			 driver.findElement(By.cssSelector(".hours-IVyrp")).click();
		 }
		 catch (org.openqa.selenium.StaleElementReferenceException ex)
		 {
			// Thread.sleep(2000);
			 WebElement titleWebElement = studios.get(0).findElement(By.cssSelector("div.linkContainer-1NkqM")); //saves all web elements of search results in studio
			 String title1 = titleWebElement.getText(); // get name of first element
			 String distance = studios.get(0).findElement(By.xpath("//span[@class='distance-OhP63']")).getText(); //saves the distance of the first element of search result
			 WebElement element = driver.findElement(By.xpath("//input[@class='input input-3TfT5']"));
			 js.executeScript("arguments[0].scrollIntoView();", element);
			 
			 //Question2) Step 6) prints name and distance of studio
			 System.out.println(title1);
			 System.out.println(distance);
			 
			 //Question2) Step 7) clicks first result and verify name matches with the previous screen
			 titleWebElement.click();
			 Thread.sleep(1000);
			 String title3 = driver.getTitle(); // get's title of the page
			 System.out.println(title3); // prints title of the page
			 String studioName = driver.findElement(By.xpath("//h1[contains(@class,'locationName')]")).getText();
			 if (title1.contentEquals(studioName)) // asserts name
					System.out.println("Studio name maches");
			 else
					System.out.println("Studio name does not mache");
			 driver.findElement(By.cssSelector(".hours-IVyrp")).click();
		 }
		 
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int tempDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // get's the day of the week
		System.out.println("Current Day of Week is: " + tempDayOfWeek); // prints day of the week
		int dayOfWeek = tempDayOfWeek - 1;
		List<WebElement> week = driver.findElements(By.cssSelector(".day-CZkDC")); // saves the web element for each day
		String day;
		// Question2. Step 8) Print's Today's day of operation
		for (int i = 0; i <= week.size(); i++) {

			if (i == dayOfWeek) // get's today's day
			{
				day = week.get(i).findElement(By.cssSelector("div.dayName-CTNC6")).getText(); // get's Today's Day text
				String businessHr = week.get(i).findElement(By.cssSelector("div.times-fms3v")).getText();	// get's Today's hours of operation																					
				System.out.println("Today is "+day+" and today's hour's of operation is " + businessHr); // print it
				
			}

		}
		 
		String todayMeeting = printMeetings("TUE");
		System.out.println(todayMeeting);
		driver.close();
	}

	// Question2 Step 9) Method to print number of meetings for each person for a given day
	static String printMeetings(String DayOfWeek) {
		String dayOfTheWeek = DayOfWeek;
		String S = "";
		List<WebElement> schedules = driver.findElements(By.xpath("//div[@class='day-NhBOb']")); // saves the web elements for all the schedules for every day of week
		for (WebElement schedule : schedules) {
			String day = schedule.findElement(By.cssSelector(".dayName-1UpF5")).getText(); // get's day from the list
			if (day.equals(dayOfTheWeek)) // asserts day matches with day passed in the method
			{
				ArrayList<String> tempList = new ArrayList<String>(); // create an array list object
				List<WebElement> meetings = schedule.findElements(By.xpath(".//div[@class='meeting-14qIm']")); // saves web element for all meetings in a given day
				for (WebElement meeting : meetings) 
				{
					String name = meeting.findElement(By.xpath(".//span[2]")).getText(); // gets the name of the person for a meeting
					tempList.add(name); // add name to the list
				}
				Map<String, Integer> countMap = new HashMap<>(); // creates a map(key,value) object
				for (String item : tempList) // traverse through all names in the list
				{
					if (countMap.containsKey(item)) // checks if map key contains the name
					{
						countMap.put(item, countMap.get(item) + 1); // adds the name in key and name count to value
					} else {
						countMap.put(item, 1); // else set the key as name and the value as 1
					}
				}
				// String S = "";
				for (Map.Entry<String, Integer> P : countMap.entrySet()) {
					S += P.getKey() + " " + P.getValue(); // saves the key value i.e. name and meeting count in required format in a string
					S += "\n";
				}

			}

		}
		return S; // return string
	}
}
