package Task1;

////1.
////A Singleton class is a class which have only one object and there is a constructor which is private and there is a
////method known as getInstance() which is userdefined which return only same instance at every time...
//public class Singleton {
//    static Singleton refer=null;
//    int val=10;
//    private Singleton(){
//    }
//    static Singleton getInstance()
//    {
//        if(refer==null)
//        {
//            refer=new Singleton();
//        }
//        return refer;
//    }
//}

//2.
//We have three methods to make singleton class a thread safe
//1.Make a method getInstance to synchronise  Cons:Deadloacking,Low performance
//2.Initialise the instance of class at the time of class loading  Cons:It initialise the resources at beginning that's not best practice
//3.Use If loop and versatile variable and apply synchronisation on the object...  Cons:It has no cons without using extra IF
//public class Singleton {
//    static volatile Singleton refer=null;
//    int val=10;
//    static Object obj=new Object();
//    private Singleton(){
//    }
//    static Singleton getInstance()
//    {
//        if(refer==null)
//        {
//            synchronized (obj){
//                if(refer==null){
//                    refer=new Singleton();
//                }
//            }
//        }
//        return refer;
//    }
//}

////3.Double check locking
////Use If loop and versatile variable and apply synchronisation on the object...  Cons:It has no cons without using extra IF
//public class Singleton {
//    static volatile Singleton refer=null;
//    int val=10;
//    static Object obj=new Object();
//    private Singleton(){
//    }
//    static Singleton getInstance()
//    {
//        if(refer==null)
//        {
//            synchronized (obj){
//                if(refer==null){
//                    refer=new Singleton();
//                }
//            }
//        }
//        return refer;
//    }
//}

//4.Singleton using clone
public class Singleton implements Cloneable {
    private static Singleton refer = null;
    int val=10;
    private Singleton() {
    }
    //It will call at loading of class
    static {
        refer = new Singleton();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public static Singleton getInstance() {
        return refer;
    }
}
//It will create an instance of a Singleton class
//Singleton refer1 = Singleton.getInstance();
//It will return a create a new clone of that same class with different instance
//Singleton refer2 = (Singleton) refer1.clone();

