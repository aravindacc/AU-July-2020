package assignment;

class SingletonExample implements Cloneable 
{
      static SingletonExample instance;
      public int value;
      private SingletonExample()
      {
            instance = null;
      }
      
      public static SingletonExample getInstance()
      {
            if(instance == null)
            {
                  synchronized(SingletonExample.class)
                  {
                        if(instance == null)
                              instance = new SingletonExample();
                  }
            }
            return instance;
      }
      
      @Override
      public Object clone()throws CloneNotSupportedException{  
	return (SingletonExample)super.clone();  
      }
      public void print()
      {
            System.out.println(value);
      }
}

public class Singleton{
      public static   void main(String []args) {
            System.out.println("Singleton Class example");
            SingletonExample obj = SingletonExample.getInstance();
            obj.value = 50;
            obj.print();

            SingletonExample obj1 = SingletonExample.getInstance();
            obj1.print();

            try
            {
                SingletonExample obj2 = (SingletonExample) obj1.clone();
                obj2.print();
            }
            catch(CloneNotSupportedException err)
            {
                System.err.println("Error "+err.getMessage());
            }
      

      }
}