package Assignment3;


class Cars  
{ 
    // the cars class has two fields 
    public int gear; 
    public int speed; 
          
    // the cars class has one constructor 
    public Cars(int gear, int speed) 
    {  
        this.gear = gear; 
        this.speed = speed; 
    } 
          
    // the Cars class has three methods 
    public void applyBrake(int decrement) 
    { 
        speed -= decrement; 
    } 
          
    public void speedUp(int increment) 
    { 
        speed += increment; 
    } 
      
    // toString() method to print info of Cars 
    public String toString()  
    { 
        return("No of gears are "+gear +"\n" + "speed of Car is "+speed); 
    }  
} 
  
// derived class 
class SedanCars extends Cars  
{ 
      
    // the SedanCars subclass adds one more field 
    public int seatHeight; 
  
    // the SedanCars subclass has one constructor 
    public SedanCars(int gear,int speed,int startHeight) 
    { 
        // invoking base-class(Cars) constructor 
        super(gear, speed); 
        seatHeight = startHeight; 
    }  
          
    // the SedanCars subclass adds one more method 
    public void setHeight(int newValue) 
    { 
        seatHeight = newValue; 
    }  
      
    // overriding toString() method of cars to print more info 
    @Override
    public String toString()  
    { 
          
        return (super.toString()+ "\n seat height is "+seatHeight); 
    } 
      
} 
  
// driver class 
public class SuperSubClass 
{ 
    public static void main(String args[])  
    { 
        // using superclass reference 
        // first approach 
    	Cars mb2 = new SedanCars(6, 200, 20); 
          
        // using subclass reference( ) 
        // second approach 
    	SedanCars mb1 = new SedanCars(5, 100, 25); 
          
        System.out.println("Driver's seat height of first Car is " + mb1.seatHeight); 
              
        // In case of overridden methods always subclass method will be executed 
        System.out.println(mb1.toString()); 
        System.out.println(mb2.toString()); 
  
        
  
    } 
} 