package pageObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResult {
	
	WebDriver driver;

	public SearchResult(WebDriver driver) {

		this.driver = driver;
	}
	
	By studioName = By.xpath("//h1[contains(@class,'locationName')]");
	By hours = By.cssSelector(".hours-IVyrp");
	By days = By.cssSelector(".day-CZkDC");
	By dayText = By.cssSelector("div.dayName-CTNC6");
	By hour = By.cssSelector("div.times-fms3v");
	By tempschedules = By.xpath("//div[@class='day-NhBOb']");
	By tempday = By.cssSelector(".dayName-1UpF5");
	By tempmeetings = By.xpath(".//div[@class='meeting-14qIm']");
	By tempname = By.xpath(".//span[2]");
	
	public void verify_name(String name) {
		 
		 String studioName1 = driver.findElement(studioName).getText();
		
		 if (name.contentEquals(studioName1)) // asserts name
				System.out.println("Studio name matches");
		 else
				System.out.println("Studio name does not mache");
		 
		 }
	
	
	
	public void print_today_operation_hours() {
		
		driver.findElement(hours).click(); // expands business hour
		
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		
		int tempDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // get's the day of the week
		
		int dayOfWeek = tempDayOfWeek - 1;
		
		List<WebElement> week = driver.findElements(days); // saves the web element for each day
		
		String day1;
		
		// Question2. Step 8) Print's Today's day of operation
		for (int i = 0; i <= week.size(); i++) {

			if (i == dayOfWeek) // get's today's day
			{
				day1 = week.get(i).findElement(dayText).getText(); // get's Today's Day text
				String businessHr = week.get(i).findElement(hour).getText();	// get's Today's hours of operation																					
				System.out.println("Today is "+day1+" and today's hours of operation is " + businessHr); // print it
				
			}

		}
	}
	
	public String get_DayOfWeek()
	{
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		String dow = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US); // day of week in Mon format
		
		return(dow);
		
	}
	
	public void printMeetings(String DayOfWeek) {
		
		String dayOfTheWeek = DayOfWeek;
		
		String S = "";
		
		List<WebElement> schedules = driver.findElements(tempschedules); // saves the web elements for all the schedules for every day of week
		
		for (WebElement schedule : schedules) 
		{
			String day = schedule.findElement(tempday).getText(); // get's day from the list
			
			if (day.equalsIgnoreCase(dayOfTheWeek)) // asserts day matches with day passed in the method
			{
				ArrayList<String> tempList = new ArrayList<String>(); // create an array list object
				
				List<WebElement> meetings = schedule.findElements(tempmeetings); // saves web element for all meetings in a given day
				
				for (WebElement meeting : meetings) 
				{
					String name = meeting.findElement(tempname).getText(); // gets the name of the person for a meeting
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
		System.out.println(S); // print meetings
	}
}
