import java.util.HashMap;
import java.util.*;
public class stringCount {

    static void wordCount(String inputString)
    {

        String str = inputString ;
        String[] arrOfStr = str.split(" ");

        HashMap<String, Integer> charCountMap
                = new HashMap<String, Integer>();




        // checking each char of strArray
        for (String s : arrOfStr) {
            if (charCountMap.containsKey(s)) {
                charCountMap.put(s, charCountMap.get(s) + 1);
            }
            else {
                charCountMap.put(s, 1);
            }
        }


        for (Map.Entry entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
public static void main(String[] args){
    String str = "input_string";
    wordCount(str);


}

}
