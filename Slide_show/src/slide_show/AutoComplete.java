package slide_show;


	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class AutoComplete {
	    WebDriver driver;
	    WebDriverWait wait;
	    String Text1="gdfg";
	    int i=1;

	    
	    @BeforeTest
	    public void method1()
	    {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Selenium_paths\\chromedriver.exe");
			 driver = new ChromeDriver();
	        driver.get("https://www.google.co.in/?gfe_rd=cr&ei=vixzWO2wAe3x8Aepj7PwDA");
	        driver.manage().window().maximize();
	      //  wait=new WebDriverWait(driver,10);
	        
	        
	    }
	    
	    @Test
	    public void method2()
	    {
	        
	                
	        
	        driver.findElement(By.xpath(".//*[@id='lst-ib']")).sendKeys("S");;
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	     
	        List <WebElement> options=driver.findElements(By.className("sbsb_c"));
	        System.out.println(options.size());
	        
	        for(WebElement option : options)
	        {
	            System.out.println(option.getText());
	                                             //..............Select by matching the inserted string.............
	        if(option.getText().equals(Text1))
	        {
	            System.out.println("Trying to select:" +Text1);
	        option.click();
	        break;
	        
	        }     
	            
	                                            //................Select by INDEX.................
	            options.get(1).click();
	            break;
	        }
	     }
	    
	}


