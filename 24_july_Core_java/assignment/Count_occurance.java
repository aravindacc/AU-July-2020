
package assignment;

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

public class Count_occurance {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        
        // taking input from user
        System.out.println("Enter String paragraph : ");
        String paragraph = sc.nextLine();
       
        // create HashMap to keep record of occurance 
        HashMap count = new HashMap<Character,Integer>(); 


        // for loop for each character in paragraph string 
        for (char c : paragraph.toCharArray()) {
        
            // get occurance of character of string in hashmap 
            // it will return null if character is not present before in hashmap
            Integer occur = (Integer) count.get(c);


            // if occurance of character  is null, make it zero
            if(occur==null)
                occur = 0;

            // put back incresed occurance in hashmap
            count.put(c, (occur+1));
        }

        //printing hashmap 
        System.out.println(count.entrySet());
    }
    
}
