package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagePOM {
	
    WebDriver driver;
	
	By username=By.id("txtUsername");
	By password=By.id("txtPassword");
	By loginbutton=By.id("btnLogin");
	
	
	
	public LoginPagePOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void typeUserName(String usrnm)
	{
		
		driver.findElement(username).sendKeys(usrnm);
		
		
	}

	public void typePassword(String passwd)
	{
		
		driver.findElement(password).sendKeys(passwd);
		
		
	}
	
	
	public void submitlogin()
	{
		
		driver.findElement(loginbutton).click();
		
		
	}

}
