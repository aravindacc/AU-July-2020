/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kavita Goodwani
 */
import java.util.*;
public class Count_Strings {

    public static void main(String[] args) {
        
        System.out.println("Enter the number of strings you wish to enter");
        Scanner sc= new Scanner( System.in);
        int n=sc.nextInt();
        sc.nextLine();
        List<String> strings;
        System.out.println("Enter the Strings");
        strings = new ArrayList<String>();
        for(int i=0;i<n;i++)
        {
            strings.add(sc.next());
        }
        HashMap<String,Integer> mp = new HashMap<String,Integer> ();
        for(int i=0;i<n;i++) {
            if (!mp.containsKey(strings.get(i)))
                mp.put(strings.get(i), 1);
            else
                mp.put(strings.get(i), mp.get(strings.get(i)) + 1);
        }
        for(Map.Entry<String,Integer> m:mp.entrySet())
        {
            System.out.println("The String "+m.getKey()+" has occured "+m.getValue()+" times");
        }


    }
}
