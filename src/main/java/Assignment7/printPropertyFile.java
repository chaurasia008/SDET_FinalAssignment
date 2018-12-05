package Assignment7;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.testng.annotations.Test;

public class printPropertyFile {
  @Test
  public void printdetail() throws IOException 
  {
	  
	  //get property file path
	  File src = new File("src/main/java/Assignment7/personaldetails.properties");
	  
	  FileInputStream fis = new FileInputStream(src);
	  
	  Properties pro = new Properties();
	  
	  pro.load(fis);

	 //set detail in string
	  Set<String> keys = pro.stringPropertyNames();
	  
	  //print string sing for loop
	  for(String key : keys)
	  {
		  System.out.println(key + " = "+ pro.getProperty(key));
	  }
	  
	  
  }
}
