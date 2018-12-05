package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignLeavePOM {
	
WebDriver driver;
	
	By AssignLeave = By.id("menu_leave_assignLeave");
	By EmployeeName = By.id("assignleave_txtEmployee_empName");
	By LeaveType = By.id("assignleave_txtLeaveType");
	By FromDate = By.id("assignleave_txtFromDate");
	By ToDate = By.id("assignleave_txtToDate");
	By AssignButton= By.cssSelector("assignBtn");
	
	public AssignLeavePOM(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickOnAssignLeaveTab()
	{
		driver.findElement(AssignLeave).click();
	}
	
	public void employeeName(String name)
	{
		driver.findElement(EmployeeName).sendKeys(name);
	}
	
	
	public void leaveType(String lvtype)
	{
		driver.findElement(LeaveType).sendKeys(lvtype);
	}
	
	
	
	public void FromDate(String fdate)
	{
		driver.findElement(FromDate).sendKeys(fdate);
	}
	
	public void ToDate(String tdate)
	{
		driver.findElement(ToDate).sendKeys(tdate);
	}
	
	public void clickOnAssignButton()
	{
		driver.findElement(AssignButton).click();
	}
	

}
