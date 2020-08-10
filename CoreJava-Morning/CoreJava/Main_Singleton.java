import java.util.*;
import java.lang.*;
import java.io.*;

public class Main_Singleton{
    public static void main(String args[]){
        Singleton obj = Singleton.create_obj();
        System.out.println("New Singleton Object: " + obj);
        
        Singleton obj1 = Singleton.create_obj();
        System.out.println("Same Singleton Object: " + obj1);
        
        try {
			Singleton obj2 = (Singleton) obj.clone();
			System.out.println("New Singleton Object using Clone: " + obj2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace(); 
		}
    }
}

class Singleton implements Cloneable {
    private volatile static Singleton singleton;
    
    Singleton(){
    }

    public static Singleton create_obj(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    System.out.println("Inside synchronized double checked locking block...");
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
    
    @Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
