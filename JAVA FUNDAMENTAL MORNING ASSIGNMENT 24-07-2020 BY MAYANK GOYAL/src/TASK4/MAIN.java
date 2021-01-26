package TASK4;
import java.util.ArrayList;
import java.util.List;

interface TELEPHONE {
    void DIAL(String num);
    void PRESS_BUTTON(int num);
    void CALL(String num);
    void MAKECALL();
}
interface DETAILS{
    void CALL_HISTORY();
    void ADD_INTO_CALLHISTORY(String num);
}
class FUNCTION implements TELEPHONE, DETAILS
{
    private List<String> list=new ArrayList<>();
    @Override
    public void DIAL(String num) {
        System.out.print("You Dial=");
        for(int i=0;i<num.length();i++){
            PRESS_BUTTON(Integer.parseInt(String.valueOf(num.charAt(i))));
        }
        System.out.println();
    }

    @Override
    public void PRESS_BUTTON(int num) {
        System.out.print(num);
    }

    @Override
    public void CALL(String num) {
        DIAL(num);
        ADD_INTO_CALLHISTORY(num);
    }

    @Override
    public void MAKECALL() {
        System.out.println("You clicked on call");
    }

    @Override
    public void CALL_HISTORY() {
        System.out.println("YOUR CALL HISTORY");
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }

    @Override
    public void ADD_INTO_CALLHISTORY(String num) {
        this.list.add(num);
    }
}
public class MAIN {
    public static void main(String args[]){
        FUNCTION F=new FUNCTION();
        F.CALL("9643574584");
        F.MAKECALL();
        F.CALL("8700018221");
        F.MAKECALL();
        F.CALL("8468944888");
        F.MAKECALL();
        F.CALL_HISTORY();
    }
}


/*OUTPUT:-
"C:\Program Files\Java\jdk1.8.0_231\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.4\lib\idea_rt.jar=59913:C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.4\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_231\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\rt.jar;C:\Users\SHASHANK GOYAL\IdeaProjects\Java_project\out\production\Java_project" Task3
You Dial=9643574584
You clicked on call
You Dial=8700018221
You clicked on call
You Dial=8468944888
You clicked on call
YOUR CALL HISTORY
9643574584
8700018221
8468944888

Process finished with exit code 0

 */
