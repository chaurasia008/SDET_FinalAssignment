package Assignment8;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLinks {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "/Users/apple/Downloads/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		File src= new File("src/main/resources/logindetails.properties");
	      
	      FileInputStream fis=new FileInputStream(src);
	      
	      Properties pro=new Properties();
	      
	      pro.load(fis);
	      
	        //enter a valid login user name
		    driver.findElement(By.id("txtUsername")).sendKeys(pro.getProperty("Username"));
		    //enter a valid login password
			driver.findElement(By.id("txtPassword")).sendKeys(pro.getProperty("Password"));
            //
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			//click on login button
		    driver.findElement(By.id("btnLogin")).click();
		    
		    //
		    Thread.sleep(5000);
		    
		    String url1 =  driver.getCurrentUrl();
		    
		    System.out.println("on landinf page:"+url1);
		    
		    List<WebElement> links = driver.findElements(By.tagName("a"));
		    
		    System.out.println("Total links are" +links.size());
		    
		    //loop to store all links
		    for (int i=0; i<links.size();i++)
		    {
		    	WebElement ele = links.get(i);
		    	
		    	//
		    	String url = ele.getAttribute("href");
		    	
		    	verifyLink(url);
		    	
		    }
		    
		 }
	
	public static void verifyLink(String urlLink)
	{
		try {
			URL link = new URL(urlLink);
			HttpURLConnection httpConn = (HttpURLConnection)link.openConnection();
			
			httpConn.setConnectTimeout(5000);
			
			httpConn.connect();
			if(httpConn.getResponseCode()==200)
			{
				System.out.println("url links"+ "--->"+"url is good"+httpConn.getResponseMessage());
			}
			if(httpConn.getResponseCode()==404)
			{
				System.out.println("url links"+ "--->"+"url is not good"+httpConn.getResponseMessage());
			}
		
		}catch (Exception e) {
			
		}
	}
	

}
