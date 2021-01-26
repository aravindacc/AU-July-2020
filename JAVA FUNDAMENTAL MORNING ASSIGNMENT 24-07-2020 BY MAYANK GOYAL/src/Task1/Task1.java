package Task1;

public class Task1 {
    public static void main(String args[])
    {
        //Here we call getInstance method to get instance of the class but we get same instance at every time
        Singleton a=Singleton.getInstance();
        Singleton b=Singleton.getInstance();
        Singleton c=Singleton.getInstance();
        Singleton d=Singleton.getInstance();
        // print value at every instance
        System.out.println(a.val+" "+b.val+" "+c.val+" "+d.val);
        //Update value at instance of a
        a.val=a.val+10;
        //But here we find that it get update at all instance when we change at any instance of singleton class
        System.out.println(a.val+" "+b.val+" "+c.val+" "+d.val);
        b.val=b.val+10;
        System.out.println(a.val+" "+b.val+" "+c.val+" "+d.val);
        c.val=c.val+10;
        System.out.println(a.val+" "+b.val+" "+c.val+" "+d.val);
    }
}
/*OUTPUT:-
"C:\Program Files\Java\jdk1.8.0_231\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.4\lib\idea_rt.jar=49524:C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.4\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_231\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\rt.jar;C:\Users\SHASHANK GOYAL\IdeaProjects\Java_project\out\production\Java_project" Task1.Task1
        10 10 10 10
        20 20 20 20
        30 30 30 30
        40 40 40 40

        Process finished with exit code 0
*/