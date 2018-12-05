package Assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageClass {
	        //driver variable
	          WebDriver driver;
	 
	 
 @BeforeTest(description= "launch webpage")
 public void Launchpage() {
	 	
	        //chrome driver path
		      System.setProperty("webdriver.chrome.driver", "/Users/apple/Downloads/chromedriver");
		
		
		      driver = new ChromeDriver();
		      driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		
		    //opening URL
	          driver.get("https://opensource-demo.orangehrmlive.com");
	 }
 
 @Test(description="Enters valid login data")
 public void LoginAdmin() throws IOException {
	  
	         File src= new File("./Login_Test.feature");
     
             FileInputStream fis=new FileInputStream(src);
     
             Properties pro=new Properties();
     
             pro.load(fis);
     
           //enter a valid login user name
	         driver.findElement(By.id("txtUsername")).sendKeys(pro.getProperty("Username"));
	       //enter a valid login password
		     driver.findElement(By.id("txtPassword")).sendKeys(pro.getProperty("Password"));
	  
 }

 //login page submit 
   @Test(description="Submit login credentials")
   public void loginsubmit()  {
	  
	         driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	       //click on login button
		     driver.findElement(By.id("btnLogin")).click();
	  
    }
}
