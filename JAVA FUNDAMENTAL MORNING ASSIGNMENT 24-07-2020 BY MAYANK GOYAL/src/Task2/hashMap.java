package Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hashMap {
    public static void main(String args[])
    {
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();//Creating HashMap
        List<Character> list=new ArrayList<>();
        String s=new String("in this string we will found the occurence of each character");
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        for(int i=0;i<list.size();i++){
            if(map.containsKey(list.get(i))){
                map.put(list.get(i),map.get(list.get(i))+1);
            }
            else{
                map.put(list.get(i),1);
            }
        }
        for(HashMap.Entry m : map.entrySet()){
            if(m.getKey()==" ")
            {
                System.out.println("space="+m.getValue());
            }
            System.out.println(m.getKey()+"="+m.getValue());
        }
    }
}
/*OUTPUT:-
"C:\Program Files\Java\jdk1.8.0_231\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.4\lib\idea_rt.jar=55589:C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.4\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_231\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\rt.jar;C:\Users\SHASHANK GOYAL\IdeaProjects\Java_project\out\production\Java_project" Task2.hashMap
 =10
a=3
c=6
d=1
e=6
f=2
g=1
h=4
i=4
l=2
n=4
o=3
r=4
s=2
t=4
u=2
w=2

Process finished with exit code 0

 */