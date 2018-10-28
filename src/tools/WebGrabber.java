package tools;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebGrabber {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void getPageValues(){
		
		driver.get("any url");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		List<WebElement> myLinks = driver.findElements(By.tagName("a"));
		
		for(WebElement ele: myLinks){
			if(ele.getText().toUpperCase().contains("some text".toUpperCase())){
				ele.click();
			}
		}
	}
}
