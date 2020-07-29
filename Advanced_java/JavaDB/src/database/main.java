package database;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.sql.*;
import java.util.List;

class sql_query{
    //creating table in database
    public static void createTable(){
        try{
            Connection con = getConnection();
            Statement stmt =  con.createStatement();
            stmt.execute("create table student("
                    + "id int primary key,"
                    + "name varchar(50),"
                    + "surname varchar(30),"
                    + "gender varchar(1),"
                    + "marks float)");
//            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT Exist student(id int Not NULL Auto_INCREMENT,first varchar(255),last varchar(255),PRIMARY KEY(id) )");
//            create.executeUpdate();
        }catch(Exception e){System.out.println(e);}
    }
    //for connecting with database
    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/student";
            String username = "root";
            String password = "Sonu8709@";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        } catch(Exception e){System.out.println(e);}


        return null;

    }
    //function for insert row in database
    public void insertRow(int roll_num,String first_name,String middle_name, String last_name,String gender, float marks){
        try{
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into student values (?,?,?,?,?)");
            stmt.setInt(1, roll_num);
            stmt.setString(2, first_name+middle_name);
            stmt.setString(3, last_name);
            stmt.setString(4, gender);
            stmt.setFloat(5, marks);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //function for display row in database
    public void displayTable(){
        try{
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet row = stmt.executeQuery("select * from student");
            while(row.next()){
                System.out.print(row.getInt("id")+" "+row.getString("name")+" "+row.getString("surname")+" "+row.getString("gender")+" "+row.getFloat("marks")+ "\t");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}

public class main {
    public static void main(String[] args) throws Exception {
        sql_query sq = new sql_query();
        sq.createTable();

        try {
            // reading input.txt file
            File data = new File("/home/rajdeep/Desktop/Accolite_Assignment/Advanced_java/input.txt");
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(data);

            // reading input from xml file
            List<Node> nodes = document.selectNodes("/class/student");

            for (Node node : nodes) {
                int roll_num = Integer.parseInt(node.valueOf("@rollno"));
                String first_name =  node.selectSingleNode("name/firstname").getText();
                String middle_name =  node.selectSingleNode("name/middlename").getText();
                String last_name =  node.selectSingleNode("name/lastname").getText();

                String gender =  node.selectSingleNode("gender").getText();
                float marks = Float.parseFloat(node.selectSingleNode("marks").getText());


                //insert row in database
                sq.insertRow(roll_num, first_name, middle_name, last_name, gender, marks);
            }
            //display every row of database
            sq.displayTable();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

