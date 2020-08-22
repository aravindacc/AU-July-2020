class Singleton
{
 private static Singleton single_instance = null;
 public String s;
 private Singleton()
 {
 s = "First String";
 }
 public static Singleton getInstance()
 {
 if (single_instance == null)
 single_instance = new Singleton();
 return single_instance;
 }
}
public class Singleton_Example
{
 public static void main(String[] args) {
 Singleton x = Singleton.getInstance();
 Singleton y = Singleton.getInstance();
 Singleton z = Singleton.getInstance();
 x.s = (x.s).toUpperCase();
 System.out.println("String from Singleton Class Object x is " + x.s);
 System.out.println("String from Singleton Class Object y is " + y.s);
 System.out.println("String from Singleton Class Object z is " + z.s);
 System.out.println("\n");
 z.s = (z.s).toLowerCase();
 System.out.println("String from Singleton Class Object x is " + x.s);
 System.out.println("String from Singleton Class Object y is " + y.s);
 System.out.println("String from Singleton Class Object z is " + z.s);
 }
}