package Assignment2;

import java.io.IOException;

import org.testng.annotations.Test;

public class testNGListener {
	
	String strName;
	
	iTestListener_Implements obj_testlistener = new iTestListener_Implements();
	
	
  @Test(priority=1)
  public void testListenerPass() throws IOException 
  {
	  obj_testlistener.setName("Tom");
	  
	  
  }
  
  @Test(priority=2)
  public void testListenerFail() throws IOException
  {
	  
	  
	  obj_testlistener.getName();
	  
	  System.out.println("Dashboard : "+obj_testlistener.getName());
	  
  }


}
