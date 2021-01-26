import java.util.ArrayList;
import java.util.Scanner;

public class telephone implements telephone_model{
    public boolean flag;
    public ArrayList <String> history = new ArrayList<String>();

    telephone(){
        flag= false;
        history.add("NO CALLS");

    }

    @Override
    public void call(String s)
    {
        String str;
        if(!flag)
        {
            if(s.matches(" "))
            {
                System.out.println("Dial the number");

                Scanner sc= new Scanner(System.in);
                System.out.print("enter 10 digit number: ");
                str= sc.nextLine();

            }
            else{ str=s; }
            System.out.println("Calling: "+str+"...");
           history.add(str);
            end_call();

        }
        else
        {
            System.out.println("Already on call");
        }

    }

    @Override
    public void end_call()
    {

        System.out.println("Press E to end the call");
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        if(str.equalsIgnoreCase("e"))
        {

            System.out.println("call terminated...");
            flag = false;
        }
    }

    @Override
    public void redial()
    {
        if(!flag)
        {
            String s = history.get(history.size()-1);
            System.out.println("Redialling the last number in your list : "+s);
            call(s);
        }
    }

    @Override
    public void receive_call(String r)
    {
       flag = true;
        System.out.println(r+" is calling you");
        System.out.println("Press R to not take this call : Press Reject");
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        if(str.matches("R"))
        {
            System.out.println("call rejected from "+r);
        }
        else
        {
            System.out.println("Talking to "+r+" .....");
            end_call();
        }
    }

    @Override
    public void log()
    {
        System.out.println("the call history is :"+history);
    }




}
