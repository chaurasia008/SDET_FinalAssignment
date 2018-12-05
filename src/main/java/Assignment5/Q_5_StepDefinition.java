package Assignment5;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Q_5_StepDefinition {
	 
	public WebDriver driver;

    @Given("^I open my application$")
    public void i_open_my_application() throws Throwable {
           
    	System.setProperty("webdriver.chrome.driver", "/Users/apple/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().fullscreen();
		
		driver.get("https://opensource-demo.orangehrmlive.com");

    driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
    
    File src= new File("./LoginScenario.feature");
    
    FileInputStream fis=new FileInputStream(src);
    
    Properties pro=new Properties();
    
       pro.load(fis);
       
       //get url from property file
    driver.get(pro.getProperty("url"));

      

    }
    

    @And( "^ I login with following credentials ([^\"]*) and ([^\"]*)$")
    
     
     public void I_login_with_following_credentials(String Username, String Password) throws Throwable {
           
            File src= new File("./LoginScenario.feature");
                  
                  FileInputStream fis=new FileInputStream(src);
                  
                  Properties pro=new Properties();
                  
                     pro.load(fis);
                    
            driver.findElement(By.id(pro.getProperty("EnterUsername"))).sendKeys(Username);
           //driver.findElement(By.id("user_login")).sendKeys(Username);
                  
                  //driver.findElement(By.id("user_pass")).sendKeys(Password);
                  driver.findElement(By.id(pro.getProperty("EnterPassword"))).sendKeys(Password);
           
                  
                  //driver.findElement(By.id("wp-submit")).click();
                  driver.findElement(By.id(pro.getProperty("loginbutton"))).click();
    }




    @And("^validate landing Page ([^\"]*)$")

    public void validate_landing_page(String PageTitle) throws Throwable {
           
           
           //Explicit Wait for landing page 
           
           WebDriverWait  wait = new WebDriverWait  (driver,45);
           
           File src= new File("./LoginScenario.feature");
           
           FileInputStream fis=new FileInputStream(src);
           
           Properties pro=new Properties();
           
              pro.load(fis);

           //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-users")));
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pro.getProperty("UserMenu"))));  
    
           String Getpagetitle = driver.getTitle();
           
           //Verify using assert(Actual title using getTitle method,Expected title passed in feature file);
           
           org.testng.Assert.assertEquals(Getpagetitle,PageTitle);
           
           }

}
