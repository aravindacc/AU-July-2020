/*
Please change at line 26: Mysql server, Database, Username , password
Please change at line 117: update "input.txt" path


*/

package advancejava;
import java.sql.*;
import com.mysql.jdbc.Driver;
import java.io.File;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
 
class database 
{
    Connection con;
    
    // default constructor, it connect to database 
    public database()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            // update servername, port, database name, username , password according to yoour use
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java","root","");  
        }catch(Exception err)
        {
            System.out.println(err.getMessage());
        }
    }
    
    
    // create table student with all field 
    public void addTable()
    {
        try{
            Statement stmt =  con.createStatement();
            stmt.execute("create table student("
                       + "id int primary key,"
                       + "name varchar(30),"
                       + "surname varchar(20),"
                       + "gender varchar(6),"
                       + "marks float)");
        }catch(Exception err){
            System.out.println(err.getMessage());
        }
    }
    
    // inserting row into student tables 
    public void addRow(int rollno, String Firstname, String Middlename, String Lastname,String gender, float marks)
    {
        try {
            // prepared statements to avoid sql injection 
            PreparedStatement stmt = con.prepareStatement("insert into student values (?,?,?,?,?)");
            // setting placeholder value in prepared statements 
            stmt.setInt(1, rollno);
            stmt.setString(2, Firstname+" "+Middlename);
            stmt.setString(3, Lastname);
            stmt.setString(4, gender);
            stmt.setFloat(5, marks);
            // executing statements
            if(stmt.executeUpdate()>0)
                System.out.println("Inserted Successfully");
            else
                System.out.println("Insertion failed");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //printing database student table data 
    public void printTableData()
    {
        try {
            Statement stmt = con.createStatement();
            ResultSet datatset =  stmt.executeQuery("select * from student");
            while (datatset.next()) {
                System.out.print(datatset.getInt("id")+"\t");
                System.out.print(datatset.getString("name")+"\t");
                System.out.print(datatset.getString("surname")+"\t");
                System.out.print(datatset.getString("gender")+"\t");
                System.out.println(datatset.getFloat("marks")+"\t");
                
            }
        } catch (Exception e) {
            System.out.println("Can't fetch student detials : "+e.getMessage());
        }
    }
    
    public void close()
    {
        try{
            con.close();
        }catch(Exception er)
        {
            System.out.println(er.getMessage());
        }
    }

}


public class DB_XML_parser {
    public static void main(String[] args) {
        // database class used for doing database functions
        // it connect to mysql database 
        database mysql_db =  new database();
        
        // addTable function will create Student table 
        mysql_db.addTable();
        
        
        try {
            // reading input.txt file- you must change path depend on your location 
            File xmlfile = new File("C:\\Users\\mahendra\\Desktop\\Accolite\\Training\\11_java_advance\\AdvanceJava\\src\\advancejava\\input.txt");
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(xmlfile);
                    
            // loading all students information from xml 
            List<Node> nodes = document.selectNodes("/class/student");
            
            for (Node node : nodes) {
                // getting attribute value of rollno 
                int rollno = Integer.parseInt(node.valueOf("@rollno"));
                // getting child element name/firstname, middlename, lastname 
                String fname =  node.selectSingleNode("name/firstname").getText();
                String mname =  node.selectSingleNode("name/middlename").getText();
                String lname =  node.selectSingleNode("name/lastname").getText();
                // getting gender, marks 
                String gender =  node.selectSingleNode("gender").getText();
                float marks = Float.parseFloat(node.selectSingleNode("marks").getText());
                
                //database funtion to insert row in table
                mysql_db.addRow(rollno, fname, mname, lname, gender, marks);
            }
            
            // database function to print table data
            mysql_db.printTableData();
            
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally
        {
            mysql_db.close();
        }
    }
}
