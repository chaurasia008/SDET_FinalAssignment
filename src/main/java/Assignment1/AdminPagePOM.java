package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPagePOM {
	
WebDriver driver;
	
	By AdminTab = By.id("menu_admin_viewAdminModule");
	By enterName = By.id("searchSystemUser_userName");
	By UserRole =By.id("searchSystemUser_userType");
	By EmployeeName=By.id("searchSystemUser_employeeName_empName");
	By Status=By.id("searchSystemUser_status");
	By searchButton = By.cssSelector("[name='_search']");
	By resetButton = By.cssSelector("[name='_reset']");
	By checkBox = By.className("[name='chkSelectRow[]']");
	By Addbtn = By.cssSelector("[name='btnAdd']");
	
	public AdminPagePOM(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickOnAdminTab()
	{
		driver.findElement(AdminTab).click();
	}
	
	public void EnterName(String name)
	{
		driver.findElement(enterName).sendKeys(name);
	}
	
	
	public void UserRole(String role)
	{
		driver.findElement(UserRole).sendKeys(role);
	}
	
	public void EmployeeName(String empname)
	{
		driver.findElement(EmployeeName).sendKeys(empname);
	}
	
	public void Status(String status)
	{
		driver.findElement(Status).sendKeys(status);
	}
	
	public void clickOnSearchButton()
	{
		driver.findElement(searchButton).click();
	}
	
	public void clickOnRestButton()
	{
		driver.findElement(resetButton).click();
	}
	
	public void selectcheckbox()
	{
		driver.findElement(checkBox).click();
	}
	
	public void selectAdd()
	{
		driver.findElement(Addbtn).click();
	}

}
