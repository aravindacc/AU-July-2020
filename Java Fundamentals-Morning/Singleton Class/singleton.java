package java_fundamentals;


//implementing singleton class with getInstance() method
class singletonclass{
	
	//static variable obj of type singletonclass
	private static singletonclass obj=null;
	
	//variable of type string
	public String s;
	
	//restriction of constructor to only singletonclass class
	private singletonclass()
	{
		s="This is singleton class";
	}
	
	// static method to create instance of singletonclass class 
	public static singletonclass getInstance()
	{
		if(obj==null)
			obj=new singletonclass();
		return obj;
	}
}


//main class 
public class singleton {
	public static void main(String [] args)
	{
		// instantiating singletonclass class with variable instance1, instance2, instance3
		singletonclass instance1=singletonclass.getInstance();
		singletonclass instance2=singletonclass.getInstance();
		singletonclass instance3=singletonclass.getInstance();
		
		// changing variable of instance instance1 to uppercase
		instance1.s=(instance1.s).toUpperCase();
		
		System.out.println("String from instance1 is " + instance1.s); 
        System.out.println("String from instance2 is " + instance2.s); 
        System.out.println("String from instance3 is " + instance3.s); 
        System.out.println("\n"); 
        
        //// changing variable of instance instance3 to lowercase
        instance3.s = (instance3.s).toLowerCase(); 
        
        System.out.println("String from instance1 is " + instance1.s); 
        System.out.println("String from instance2 is " + instance2.s); 
        System.out.println("String from instance3 is " + instance3.s);
	}

}
