package slide_show;


	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Arrays;
	import java.util.Date;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.junit.rules.Timeout;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	public class datepicker {
	
	    WebDriver driver;
	    WebDriverWait wait;
	   
	      
	    //List<String> MonthList=Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
	    @Test
	      public void method1()
	         {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Selenium_paths\\chromedriver.exe");
			 driver = new ChromeDriver();
	        
	          driver.manage().window().maximize();
	          wait=new WebDriverWait(driver,10);
	          driver.navigate().to("https://testing.xataka.com/admin");
	          //Login
	          driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("admin");
	          driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("tst4wslp2");
	          driver.findElement(By.xpath(".//*[@id='_submit']")).click();
	          driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	          driver.findElement(By.xpath(".//*[@id='special-post-button-197991']")).click();
	         
	          //Click on Featured post button
	         Select list=new Select(driver.findElement(By.xpath(".//*[@id='special-priority-197991']")));
	         list.selectByValue("5");
	         WebElement calendar=driver.findElement(By.xpath(".//*[@id='special-limit-date-197991']"));
	         calendar.click();
	        
	         List <WebElement> options=driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[5]/a"));
	         for(WebElement option:options)
	         {
	        if(option.getText().equals("12"))
	        {
	            option.click();
	        break;
	         }    
	         }
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	         driver.findElement(By.xpath(".//*[@id='save-special-post-197991']")).click();
	         }
	
	        
	          
	          }
	

	

