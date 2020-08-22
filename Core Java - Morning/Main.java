
import java.util.*;
import java.io.*; 
interface telephone_model{
    void make_call(String s);
    void terminate_call(); 
    void redial(); 
    void receive(String r); 
    void call_log(); 
}

class telephone implements telephone_model{
    
    public boolean on_call;
    public  Stack<String> stack = new Stack<String>(); 
    
    telephone(){
        on_call= false;
        stack.push("No calls made yet");
        
    }

    @Override
    public void make_call(String s)
    {
        String str;
        if(!on_call)
        {
            if(s.matches(" "))
            {
                System.out.println("Dial the number");
                int count=1;

                Scanner sc= new Scanner(System.in);   
                System.out.print("Enter 10 digit Mobile number: ");  
                str= sc.nextLine();
            }
            else{ str=s; }
            System.out.println("Calling: "+str+"...");
            stack.push(str);
            terminate_call();
            
        }
        else 
        {
            System.out.println("Already on call");
        }
        
    }

    @Override    
    public void terminate_call()
    {
    //   Instant start = Instant.now();
            System.out.println("Press E to end the call");
            Scanner sc= new Scanner(System.in);   
            String str= sc.nextLine();
            if(str.regionMatches(true,0,"E",0,1))
            {
                  System.out.println("Call Terminated...");
                on_call = false;
            }
    }

    @Override    
    public void redial()
    {
        if(!on_call)
        {
           String s = stack.peek(); 
           System.out.println("Redialling the last number in your list : "+s);
           make_call(s);
        }
    }

    @Override
    public void receive(String r)
    {
	    on_call = true;
        System.out.println(r+" is calling you");
        System.out.println("Press R to not take this call : Press Reject");
        Scanner sc= new Scanner(System.in);   
        String str= sc.nextLine();
        if(str.matches("R"))
        {
	    System.out.println("Call rejected from "+r);
        }
        else
        {
            System.out.println("Talking with "+r+" .....");
            terminate_call();
        }
    }  
    
    @Override
    public void call_log()
    {
        System.out.println("The call log is :"+stack);
    }
     
    
    
}
public class Main{
	public static void main(String[] args) {
	    telephone obj = new telephone();
	    obj.make_call(" ");
	    obj.redial();
	    obj.receive("7838316597");
	    obj.call_log();
	}
}