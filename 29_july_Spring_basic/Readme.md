# Mukesh Suthar 
### mukesh.suthar@accoliteindia.com

## Spring Basic assignments

1. Create Shape Interface 
      - done
1. Create two objects Triangle/Circle implementing the above interface
      - done
1. Create Point class with point x and point y
      - done
1. Triangle should have 3 point varaiables - PointA, PointB,PointC and 1 type variable(String)
      - done 
1. Circle should have 1 point variable- Center and 1 type variable(String)
      - done 
1. Create Beans for all the above classes
      - done
1. Assign Values to Triangle using SetterType
      - done
1. Assign Values to Circle using Constructor Type
      - done 
1. Make center variable as required in Circle
      - I made Triangle variable as required since its giving some error while using Constuctor Type value  assignning.
1. Make a map variable in triangle called PointMap and inject it using innerbean/bean in spring with meaningful values
      - done 
1. Make area functions in Circle and Triangle and add a Around aspect for this function using point cut
      - created area function for both Triangle and circle but using Around aspect directly area function giving an error of Spring NoSuchBeanDefinitionException. So i created AreaCollector class to call area method of triangle and circle class, and used around aspect to the AreaCollector class.
1. In around aspect , aslo print the JoinPoint.
      - done
1. Write a main class , to show all these features.
      - done