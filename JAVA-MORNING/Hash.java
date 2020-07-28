import java.util.*;

public class Hash {
    public static void main(String[] args) {

        Scanner sc= new Scanner( System.in);
        int n=sc.nextInt();
        sc.nextLine();
        List<String> strings = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            strings.add(sc.next());
        }
        HashMap<String,Integer> mp = new HashMap<>();
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
// OUTPUT
//6
//        AMAN
//        AMAN
//        SHUBHAM
//        ASHISH
//        SHUBHAM
//        RAHUL
//        The String RAHUL has occured 1 times
//        The String ASHISH has occured 1 times
//        The String AMAN has occured 2 times
//        The String SHUBHAM has occured 2 times
//
//        Process finished with exit code 0
