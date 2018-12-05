package Assignment2;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class iTestListener_Implements {
	
	public String strName;

	public String getName() {
		
		if(strName.equals("Tom"))
		  {
			  System.out.println("Pass");
		  }else
			  System.out.println("Fail");
		
		return strName;
	}

	public void setName(String strName) throws IOException {
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
		
		this.strName = strName;
		System.out.println("string name : "+strName);
		
	}
	
	

}
