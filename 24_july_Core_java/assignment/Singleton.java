package assignment;

class SingletonExample implements Cloneable 
{
      // static will make single intance per class
      static SingletonExample instance;
      
      // value used to check all the object refer to same instace
      public int value;

      // private constructor to  stop creating object outside of class 
      private SingletonExample()
      {
            instance = null;
      }
      
      // return instance of this class
      public static SingletonExample getInstance()
      {
            // if instance is not created then create new instance 
            // else it will return previous instance
            if(instance == null)
            {
                  // synchronized block for locking area for single thread at a time
                  synchronized(SingletonExample.class)
                  {
                        // dual check for stop synchronizing block for everytime getInstance called
                        if(instance == null)
                              instance = new SingletonExample();
                  }
            }
            return instance;
      }

      // clone function to return copy of instance 
      @Override
      public Object clone()throws CloneNotSupportedException{  
	      return (SingletonExample)super.clone();  
      }


      // printing the value
      public void print()
      {
            System.out.println(value);
      }
}

public class Singleton{
      public static   void main(String []args) {
            System.out.println("Singleton Class example");
            
            // creating instance first time 
            SingletonExample obj = SingletonExample.getInstance();
            // assign value to object to check whether same intance refer by differents objects
            obj.value = 50;
            obj.print(); // 50

            // creating object for second time 
            SingletonExample obj1 = SingletonExample.getInstance();
            obj1.print(); // should print 50

            try
            {
                  // cloning of object
                SingletonExample obj2 = (SingletonExample) obj1.clone();
                obj2.print();  // should return 50
            }
            catch(CloneNotSupportedException err)
            {
                System.err.println("Error "+err.getMessage());
            }
      

      }
}