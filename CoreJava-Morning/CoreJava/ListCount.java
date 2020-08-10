import java.util.*;
import java.lang.*;
import java.io.*;

public class ListCount{
    public static void main(String args[]){
        Map<String, Integer> countList = new HashMap<String, Integer>();
        List<String> list = new ArrayList<String>();
        String arr[] = {"a", "b", "a", "c", "z", "c", "u", "x", "x", "a"};
        
        for (String a : arr) {
            list.add(a);
        }
        System.out.println(list);
        
        for (String i : list) {
            if(countList.containsKey(i)){
                int j = countList.get(i);
                countList.put(i, j + 1);
            }
            else
                countList.put(i, 1);
        } 
        
        System.out.println(countList);
    }
}
