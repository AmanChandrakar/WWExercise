package main.java;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.FindWorkshop;
import pageObject.Homepage;
import pageObject.SearchResult;

public class Excercise2 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
	
	 
		String exePath = "src/resources/chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", exePath);
		
		driver = new ChromeDriver();
		
		// maximizes the window
		driver.manage().window().maximize(); 
		
		// implicit wait of 2 seconds
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;

		// . Step 1) Navigates to WW website
		driver.get("https://www.weightwatchers.com/us/");
		
		//. Step 2) Asserts the title of the page 
		Homepage homepage=new Homepage(driver);
		
		homepage.verifyTitle();
		//clicks the Attend icon at the top right corner
		
		homepage.attend().click();
		
		//. Step 3) Click on the Unlimited Workshops option
		homepage.workshop().click();
		
		FindWorkshop workshop =new FindWorkshop(driver);
		
		Thread.sleep(2000);
		
		// Step 4) asserts the title of the page
		workshop.verifyTitle();
						
		workshop.studio().click();
			
		// Step 5) Search zipcode 10011
		workshop.zipcode().sendKeys("10011");
		
		workshop.find().click();
		
		workshop.scroll_to_bottom();
		
		// Step 6) prints name and distance of studio
		Thread.sleep(3000);
		String name = workshop.print_title();
		System.out.println("The name of this page is "+name);
		
		Thread.sleep(3000);
		String distance = workshop.print_distance();
	    System.out.println("The distance of studio is "+distance);
	    
	    // Step 7) clicks first result and verify name matches with the previous screen
        workshop.first_studio().click();
	    
	    SearchResult result =new SearchResult(driver);
	    
	    result.verify_name(name);
	    
	    // Step 8) Print's Today's day of operation
	    result.print_today_operation_hours();
	    
	    String day = result.get_DayOfWeek();
	    
	    // Step 9) Method to print number of meetings for each person for a given day
	    result.printMeetings(day);
	    
	    driver.close();  	    
	
		
	}
	
}


