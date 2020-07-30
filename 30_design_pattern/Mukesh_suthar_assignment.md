### Mukesh Suthar - mukesh.suthar@accoliteindia.com
## Structural Design Pattern  - Private class data design (Private implementation)

Private class data is used to control access to class attributes.
When you make any class with no private attributes, these attributes can be modified even when you don't want it to modify. You can control the modification of variable using this design pattern.
It allow to keep data seperatly from method who is using data makes it more better readability and unnderstanding. Some of varable we need to writes once which we can not make final, using this
pattern allows to create thoose type of data variable.

* It reduces data exposure by limiting its visibility.
* It reduces number of class attribute by putting them into signle class object. 
* It seperate data and methods in different classes.
* It provides new type of final attributes, allowing modification only once.

#### Implementation 
You can implement this pattern by creating a separate data class and make object of this data class into main class. 
Variables in data class must be private and can only accessible by getter and setter methods.
Target class access data class member by using data class object and getter and setter methods.

#### Example 
**Without Private Class data**
```
class Reactangle 
{
  private double Lenght;
  private double Width;
  
  Rectangle()
  {
    this.Length = 50.10;
    this.Width = 40.20;
  }
  
  public double area()
  {
    return this.Length*this.Width;
  }
}
```

The private attributes Length and Width above should not change after the Reactangle() constructor, but doing methods of class Reactangle can still modify them.

The excess exposure of the attributes creates a type of tight coupling between methods that access those attributes. 
To reduce the visibility of the attributes and thus reduce the coupling, implement the private class data design pattern, as follows: 

**With Private Class Data**
```
class ReactangleData
{
  private double Length;
  private double Width;
  
  ReactangleData(double Length, double Width)
  {
    this.Length = Length;
    this.Width = Width;
  }
  public double getLength()
  {
    return this.Length;
  }
  
  public double getWidth()
  {
    return this.Width;
  }
}

class Reactangle extends ReactangleData 
{
  ReactangleData data;
  Rectangle()
  {
      this.data = new ReactangleData(50.10, 40.50);
  }
  
  public void area()
  {
    return this.data.getLength() * this.data.getWidth();
  }
}
```

The Reactangle class in the above code has an attribute of type ReactangleData to encapsulate the attributes previously exposed to all of the methods of
the class Reactangle. That encapsulation prevents methods
from changing the attributes after the Reactangle() constructor. Note, however, that any method of Reactangle can still retrieve the values of the encapsulated
attributes.
