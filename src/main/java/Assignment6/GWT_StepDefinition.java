package Assignment6;

//import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GWT_StepDefinition {
	
	public WebDriver driver;
	
	@Given("^a list of numbers ([^\"]*) and ([^\"]*) and ([^\"]*)$")
    public void GivenNumbers(int a, int b, int c) throws Throwable {
           
 
    
    File src= new File("./GWT_FeatureFile.feature");
    
    FileInputStream fis=new FileInputStream(src);
    
    Properties pro=new Properties();
    
       pro.load(fis);
       
       
       //get url from property file

    driver.get(pro.getProperty("a"));
    driver.get(pro.getProperty("b"));
    driver.get(pro.getProperty("c"));
    
    int sum=a+b+c;
    
    System.out.println("Multiplication is : "+sum);

    }

    @When("^I Multiply them ([^\"]*) and ([^\"]*) and ([^\"]*)$")
    public void MUL(int a, int b, int c) throws Throwable {
           
           File src= new File("./AQ6_GWTFeature.feature");
           
           FileInputStream fis=new FileInputStream(src);
           
           Properties pro=new Properties();
           
              pro.load(fis);
              
              
              //get url from property file

           driver.get(pro.getProperty("a"));
           driver.get(pro.getProperty("b"));
           driver.get(pro.getProperty("c")); 
           
           int result = a*b*c;
           System.out.println("Multiplication is : "+result);

    }


	@Then("^should I get (\\d+)$")
	public void should_I_get(int expectedSum) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Value is :"+expectedSum);
	}


}