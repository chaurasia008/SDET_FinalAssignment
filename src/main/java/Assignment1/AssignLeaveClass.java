package Assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class AssignLeaveClass {
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
		  
	  //enter a valid login user name
	  driver.findElement(By.id("txtUsername")).sendKeys(pro.getProperty("Username"));
	  //enter a valid login password
	  driver.findElement(By.id("txtPassword")).sendKeys(pro.getProperty("Password"));
	  //click on login button
	  driver.findElement(By.id("btnLogin")).click();
		
	}
	  
	  
 //navigate to assign leave tab and enter required values
  @Test(priority=1)
  public void verifyAssignLeaveTab()
   {
    WebElement mnuElement;
			
	mnuElement = driver.findElement(By.cssSelector("#menu_leave_viewLeaveModule"));
			
	//WebElement submnuElement;
	//submnuElement = driver.findElement(By.cssSelector("insert selector here"));

	Actions builder = new Actions(driver);
	// Move cursor to the Main Menu Element
	builder.moveToElement(mnuElement).perform();
			
			
	// Pause 25 Seconds for submenu to be displayed
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		  
	AssignLeavePOM tab = new AssignLeavePOM(driver);
		 
	driver.findElement(By.cssSelector("#menu_leave_assignLeave"));
			
	tab.clickOnAssignLeaveTab();
	tab.employeeName("santosh");
	tab.leaveType("FMLA US");
			
	DateFormat dateFormat2 = new SimpleDateFormat("dd"); 
    Date date2 = new Date();

    String today = dateFormat2.format(date2); 
    driver.findElement(By.id("assignleave_txtFromDate")).click();
    //find the calendar
    WebElement dateWidget = driver.findElement(By.id("assignleave_txtFromDate"));  
    List<WebElement> columns=dateWidget.findElements(By.id("assignleave_txtFromDate"));  

    //comparing the text of cell with today's date and clicking it.
    for (WebElement cell : columns)
      {
       if (cell.getText().equals(today))
         {
           cell.click();
              //break;
             }
         tab.FromDate("columns") ;
           
         DateFormat dateFormat3 = new SimpleDateFormat("dd"); 
         Date date3 = new Date();

         String todayto = dateFormat3.format(date3);
             
         driver.findElement(By.id("assignleave_txtToDate")).click();
         //find the calendar
         WebElement dateWidget1 = driver.findElement(By.id("assignleave_txtToDate"));  
         List<WebElement> columns1=dateWidget1.findElements(By.id("assignleave_txtToDate"));  

         //comparing the text of cell with today's date and clicking it.
         for (WebElement cell1 : columns1)
           {
            if (cell1.getText().equals(todayto))
             {
              cell1.click();
               //break;
                }
             }
	     tab.ToDate("columns1");
			
		 driver.findElement(By.id("assignBtn")).click();
			// select assign button
		 tab.clickOnAssignButton();	  
	       }
	  
	   } 
}
