package telephone;
import java.util.*;
import java.io.*;

class telephone implements telephone_interface{
	
	public boolean connected;
    public boolean pickedUp;
    public boolean onHold;
    public boolean idle;
    public Stack<String>stack=new Stack<String>();
    
    public telephone() {
        connected = false;
        pickedUp = false;
        onHold = false;
        idle = true;
        stack.push("no call made");
    }
    
       
    @Override
    public void dialingUser(String input) 
    {
        String str;
        if(connected==false)
        {
        	if(input==" ")
        	{
        		Scanner sc=new Scanner(System.in);
        		System.out.println("enter 10 digit number");
            	str=sc.nextLine();
        	}
        	else {
        		str=input;
        	}
        	System.out.print("Making a call to number " + str + " ");
        	stack.push(str);
        	terminateCall();
        		
        }
        else
        {
        	System.out.print("Can't make call! Already on another call");
        }
    }

    @Override
	public void terminateCall() {
		System.out.print("Press 1 to terminate call");
		Scanner sc=new Scanner(System.in);
		int str=sc.nextInt();
		if(str==1)
		{
			System.out.print("call disconnected");
			connected=false;
		}
	}

    @Override
    public void redial() {
		if(!connected)
		{
			String str=stack.peek();
			if(str.matches("no call made"))
			{
				System.out.println("No number recently dialed");
			}
			else
			{
				System.out.print("Redialling  the current contacted number");
				dialingUser(str);
			}
			
		}
		
	}

	@Override
	public void recievCall(String input) 
	{
		
		connected=true;
		System.out.print(input +" is calling you");
		System.out.println("Press 0 to not take this call | Press 1 to take this call");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		if(str.matches("0"))
		{
			System.out.println("Call rejected");
			connected =true;
		}
		else if(str.matches("1"))
		{
			System.out.println("Call connected");
		}
		
	}




	@Override
    public void callLog()
    {
        System.out.println("the call history is :"+stack);
    }
    

    
}
public class telephoneClass {
	
	public static void main(String[] args)
	{
		telephone user1 =new telephone();
		user1.dialingUser(" ");
		user1.recievCall("9896053269");
		user1.callLog();
		user1.redial();
		user1.terminateCall();
	}
}
















