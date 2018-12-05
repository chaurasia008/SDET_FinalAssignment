package Assignment4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Call_List_Methods {
	
public static List<String> myMethod() throws IOException {
		
		List<String> listStrings = new ArrayList<String>();
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
		 
		  
		  return listStrings;
		
	}


	//method definition for another list
	public static List<String> myMethod1() throws IOException{
		
		List<String> listStrings1 = new ArrayList<String>();
		
		File src = new File("src/main/resources/logindetails.properties");
		  
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
		return listStrings1;
	}

}
