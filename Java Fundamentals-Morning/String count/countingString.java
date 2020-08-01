package java_fundamentals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class stringcount{
	
	
	private ArrayList<String> input;
	
	//constructor for stringcount class
	stringcount(ArrayList<String>input)
	{
		this.input=input;
	}
	
	public void showlist()
	{
		System.out.print("Hard coded list provided for demo: ");
		
        for(int i=0;i<input.size();i++)
            System.out.print(input.get(i)+" ");
	}
	
	public void countFunction()
	{
		
		HashMap<String,Integer> mp = new HashMap<>();

        for (String i : input) {
            Integer count = mp.get(i);
            mp.put(i, (count == null) ? 1 : count + 1);
        }

        for(Map.Entry<String,Integer> i:mp.entrySet())
        {
            System.out.print("\nCount of '"+i.getKey()+"' : "+i.getValue());
        }

	}
	
	
}


public class countingString {

	
	
	public static void main(String[] args) {
		
		
		ArrayList<String> provided=new ArrayList<>();

        //The values have been hard coded for demonstration

        //Initialization of input sting list
        provided.add("Neeraj");
        provided.add("Solanki");
        provided.add("neeraj");
        provided.add("Neeraj");
        provided.add("Kuldeep");
        provided.add("Neeraj");
        provided.add("solanki");

        
        stringcount obj= new stringcount(provided);
        
        obj.showlist();
        //Counting occurrence of each string in the list of input strings using object of class StringCounter
        obj.countFunction();

	}

}
