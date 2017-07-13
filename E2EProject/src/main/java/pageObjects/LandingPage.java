package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com
public class LandingPage {

	
	public WebDriver driver;
	
	By title=By.xpath(".//*[@id='searchContainer']/h1");
	By FlyingFrom=By.id("from");
	By FlyingTo=By.xpath("to");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}


	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement flyingFrom()
	{
		return driver.findElement(FlyingFrom);
	}
	
	public WebElement flyingTo()
	{
		return driver.findElement(FlyingTo);
	}
	
	
}
