package Assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AdminClass {
	  WebDriver driver;
	
	
	 
	  @BeforeTest
	  public void LaunchBrower() throws IOException {
		  
		    File src=new File("src/test/resources/DataSet/Data.properties");
		  
		    //create file input stream object	
			FileInputStream fis=new FileInputStream(src);
			
			//create properties file object to read property data
			Properties pro=new Properties();
			
			pro.load(fis);
		  
		    System.setProperty("webdriver.chrome.driver", "/Users/apple/Downloads/chromedriver");
		  
		    driver = new ChromeDriver();
		  
		    driver.get(pro.getProperty("url"));
		  
	  }
	  
	  
	  @Test(priority=1)	
	  public void verifylogin() throws IOException
		  {
			  
			File src=new File("src/test/resources/DataSet/Data.properties");
			  
			//create file input stream object	
		    FileInputStream fis=new FileInputStream(src);
				
			//create properties file object to read property data
		    Properties pro=new Properties();
				
			pro.load(fis);
		    //enter a valid login user name
		    driver.findElement(By.id("txtUsername")).sendKeys(pro.getProperty("Username"));
		    //enter a valid login password
			driver.findElement(By.id("txtPassword")).sendKeys(pro.getProperty("Password"));
			//click on login button
			driver.findElement(By.id("btnLogin")).click();
			}
	  
	  
	  //navigate to admin tab
	  @Test(priority=2)
	  public void verifyAdminTab()
	  {
		  
		    AdminPagePOM tab = new AdminPagePOM(driver);
		 
			driver.findElement(By.cssSelector("#menu_admin_viewAdminModule"));
			
			tab.clickOnAdminTab();
			
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			 
	  }
	  
	  //Search
	  @Test(priority=3)
	  public void Search()
	  {
		    AdminPagePOM tab = new AdminPagePOM(driver);
		    tab.EnterName("santosh");
			tab.UserRole("ESS");
			tab.EmployeeName("AAA Test");
			tab.Status("Enable");
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			tab.clickOnSearchButton();	 
			
		  
	  }
	  
	  
	  
	  
	  //for selecting check box
	  @Test(priority=4)
	 
		  public void checkBox()throws InterruptedException 
		  {
		  
		     List<WebElement> elements=driver.findElements(By.id("ohrmList_chkSelectRecord_15"));
		  
		  
		     int numberOfElements=elements.size();
		     for(int i=0;i<numberOfElements;i++){
		     //elements=driver.findElements(By.className("odd"));
		     elements.get(i).click();
		      }
		 

		      //After select checkbox click on add button
		  //    driver.findElement(By.id("btnAdd")).click();
		     
		  }
	  
	//for reset all search values
	 @Test(priority=5)
	  public void pageReset()
	  {
		  
		    AdminPagePOM tabclear = new AdminPagePOM(driver);
			tabclear.EnterName("");
			tabclear.UserRole("");
			tabclear.EmployeeName("");
			tabclear.Status("");
			tabclear.clickOnRestButton();	  
	  }
	}
	  