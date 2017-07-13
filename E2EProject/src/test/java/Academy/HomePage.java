package Academy;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username,String Password) throws IOException
	{

		//one is inheritance

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		log.info("Landed on Loginpage Successfully");
		/*LandingPage l=new LandingPage(driver);
		l.getLogin().click(); //driver.findElement(By.css()
		
*/		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
          
		//log.info(text);
		
		lp.getLogin().click();
		log.info("Logged In Successfully");
		
		}
	
	@Test
	
	public void validateAppTitle() throws IOException
	{
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//one is inheritance
		// creating object to that class and invoke methods of it
		LandingPage l=new LandingPage(driver);
		//compare the text from the browser with actual text.- Error..
		Assert.assertEquals(l.getTitle().getText(), "Search For Your Flight");
		 log.info("Title validated Successfully");
		 System.out.println("Test completed");
	}
	
	@Test(dataProvider="flightSearchData")
	
	public void flightSearch(String Flyingfrom, String Flyingto) throws IOException, InterruptedException
	{
	
		LandingPage l=new LandingPage(driver);
         l.flyingFrom().sendKeys(Flyingfrom);
         Thread.sleep(20000);
         List<WebElement> optionsToSelect = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
          
         String textToSelect= "Delhi, India  (DEL)";
         for(WebElement option : optionsToSelect){
             System.out.println(option);
             if(option.getText().equals(textToSelect)) {
                 System.out.println("Trying to select: "+textToSelect);
                 option.click();
                 break;
             }
         }
         l.flyingTo().sendKeys(Flyingto);
		 log.info("Title validated Successfully");
		 System.out.println("Test completed");
	}

	@AfterTest
	public void teardown()
	{
		
		/*driver.close();
		driver=null;*/
		
	}

	
	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[1][2];
		//0th row
		data[0][0]="ANNRENNER";
		data[0][1]="ANNR";
		//data[0][2]="Restrcited User";
		
		/*//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		data[1][2]= "Non restricted user";*/
		
		return data;

		
	}
	
	
	@DataProvider
	public Object[][] flightSearchData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] fsdata=new Object[1][2];
		//0th row
		fsdata[0][0]="Delhi, India  (DEL)";
		fsdata[0][1]="Delhi, India  (DEL)";
		//data[0][2]="Restrcited User";
		
		/*//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		data[1][2]= "Non restricted user";*/
		
		return fsdata;

		
	}
	
}
