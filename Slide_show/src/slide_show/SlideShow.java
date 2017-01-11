package slide_show;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SlideShow {
	String Text1 = "Entrevistas";
	String Text2 = "K800i×";
	String Text3 = "toshiba tg01×";
	int i = 1;

	@Test

	public void ReadWrite() throws IOException, InterruptedException, AWTException {

		Properties obj = new Properties();

		FileInputStream CallingObjfile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\Slideshow.properties");
		System.out.println(System.getProperty("user.dir") + "\\src\\dataFile.properties");

		obj.load(CallingObjfile);

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Selenium_paths\\chromedriver.exe");

		System.setProperty(obj.getProperty("Driver"), obj.getProperty("DriverPath"));

		WebDriver driver = new ChromeDriver();

		driver.get(obj.getProperty("url"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Robot robot = new Robot();
		driver.findElement(By.xpath(obj.getProperty("username_xpath"))).sendKeys(obj.getProperty("username_data"));

		driver.findElement(By.xpath(obj.getProperty("password_path"))).sendKeys(obj.getProperty("password_data"));

		driver.findElement(By.xpath(obj.getProperty("login"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(obj.getProperty("click_on_manu"))).click();

		driver.findElement(By.xpath(obj.getProperty("click_on_slide"))).click();

		driver.findElement(By.xpath(obj.getProperty("tittle"))).sendKeys(obj.getProperty("tittle_data"));

		driver.findElement(By.xpath(obj.getProperty("editor"))).sendKeys(obj.getProperty("editor_data"));

		driver.findElement(By.xpath(obj.getProperty("editor"))).click();

		driver.findElement(By.xpath(obj.getProperty("add_image"))).click();

		// driver.findElement(By.xpath(obj.getProperty("open_computer"))).click();

		WebElement element = driver.findElement(By.xpath(obj.getProperty("open_computer")));
		element.sendKeys(obj.getProperty("image_path"));

		driver.findElement(By.xpath(obj.getProperty("add"))).click();

		// driver.findElement(By.name("uploadSubmit"));
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("normal_add"))));

		driver.findElement(By.xpath(obj.getProperty("normal_add"))).click();
		Thread.sleep(10);

		driver.findElement(By.xpath(obj.getProperty("editor"))).click();

		driver.findElement(By.xpath(obj.getProperty("click_more"))).click();

		driver.findElement(By.xpath(obj.getProperty("editor"))).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		
		
		
		
		
		
		
		
		
		
		

		driver.findElement(By.xpath(obj.getProperty("click_publish"))).click();
		WebElement element2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("programar"))));

		driver.findElement(By.xpath(obj.getProperty("select_cat"))).click();

		driver.findElement(By.xpath(obj.getProperty("select_catagories"))).sendKeys(obj.getProperty("visibleText"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> options = driver.findElements(By.className("active-result"));
		System.out.println(options.size());

		for (WebElement option : options) {
			System.out.println(option.getText());
			System.out.println(option.getText().equalsIgnoreCase(Text1));

			if (option.getText().equalsIgnoreCase(Text1)) {
				System.out.println("Trying to select:" + Text1);
				option.click();
				break;
			}

		}

	/*	driver.findElement(By.xpath(obj.getProperty("auto_tag"))).sendKeys(obj.getProperty("visibleText1"));

		WebElement element4 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("normal_add2"))));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> options1 = driver.findElements(By.className("token-input-token"));
		System.out.println(options1.size());

		for (WebElement option : options1) {
			System.out.println(option.getText());
			System.out.println(option.getText().equalsIgnoreCase(Text1));

			if (option.getText().equalsIgnoreCase(Text2)) {
				System.out.println("Trying to select:" + Text2);
				option.click();
				break;
			}

		}

		driver.findElement(By.xpath(obj.getProperty("auto_product"))).sendKeys(obj.getProperty("visibleText2"));

		WebElement element5 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("normal_add2"))));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> options11 = driver.findElements(By.className("token-input-token"));
		System.out.println(options11.size());

		for (WebElement option : options11) {
			System.out.println(option.getText());
			System.out.println(option.getText().equalsIgnoreCase(Text1));

			if (option.getText().equalsIgnoreCase(Text3)) {
				System.out.println("Trying to select:" + Text3);
				option.click();
				break;

			}
		}*/
	}
}