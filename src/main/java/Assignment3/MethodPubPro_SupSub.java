package Assignment3;


class Company {
	 
	protected void address() {
		String str = "UHG,Sector-39,GGN";
		
		System.out.println("This is My office Address:"+str);
	}
}
  
class Home extends Company {
 
	public void address() {
		String str1 = "Sector39, GGN";
		super.address(); // invokes the super class method
		
		
		System.out.println("This is my Home Address..." +str1);
	}
}


public class MethodPubPro_SupSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Company reference but Home object
		Company str = new Home(); 
		
		// runs the method in Company class
		//str.address();
		
		// Runs the method in eBay class
		str.address();
		
		

	}

}