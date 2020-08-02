class Singleton {
    // static variable single_instance of type Singleton
    private static Singleton single_instance = null;

    // variable of type String
    public String s;

    // private constructor restricted to this class itself
    private Singleton()
    {
        s = "singleton class  is class having only one object at a time";
    }

    // static method to create instance of Singleton class
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }
}

// Driver Class
class Main
{
    public static void main(String args[])
    {
        // instantiating Singleton class with variable x
        Singleton obj1 = Singleton.getInstance();

        // instantiating Singleton class with variable y
        Singleton obj2 = Singleton.getInstance();

        // instantiating Singleton class with variable z
        Singleton obj3 = Singleton.getInstance();

        // changing variable of instance obj1
        obj1.s = (obj1.s).toUpperCase();

        System.out.println("String from obj1 is " + obj1.s);
        System.out.println("String from obj2 is " + obj2.s);
        System.out.println("String from obj3 is " + obj3.s);
        System.out.println("\n");

        // changing variable of instance z
        obj2.s = (obj2.s).toLowerCase();

        System.out.println("String from obj1 is " + obj1.s);
        System.out.println("String from obj2 is " + obj2.s);
        System.out.println("String from obj3 is " + obj3.s);
        System.out.println("\n");
    }
}


