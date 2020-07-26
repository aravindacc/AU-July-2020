/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
       
        HashMap count = new HashMap<Character,Integer >(); 
        for (char c : paragraph.toCharArray()) {
            Integer occur = (Integer) count.get(c);
            if(occur==null)
                occur = 0;
            count.put(c, (occur+1));
        }
        System.out.println(count.entrySet());
    }
    
}
