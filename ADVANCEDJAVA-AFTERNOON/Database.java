import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Database {
    public static void main(String[] args)
    {


        try {
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/accolite","root","9163531971Aa@");
            Statement stmt=con.createStatement();


            String sql = "CREATE TABLE MARKS " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " surname VARCHAR(255), " +
                    " gender VARCHAR(255), " +
                    " marks INTEGER not NULL,  " +
                    " PRIMARY KEY ( id ))";

            boolean rs1=stmt.execute(sql);

            String query = " insert into marks (id, name, surname, gender, marks)"
                    + " values (?, ?, ?, ?, ?)";
            PreparedStatement insert= con.prepareStatement(query);
            File inputFile = new File("C:\\Users\\AMAN\\Desktop\\java prgms\\accolite\\src\\input.txt");
            SAXReader reader = new SAXReader();
            Document document = reader.read( inputFile );

            System.out.println("Root element :" + document.getRootElement().getName());

            Element classElement = document.getRootElement();
            System.out.println("Here we are");

            List<Node> nodes;
            nodes = document.selectNodes("/class/student" );
            System.out.println("----------------------------");

            for (Node node : nodes) {


                List <String> columns = Arrays.asList(node.valueOf("@rollno"),node.selectSingleNode("name/firstname").getText()+node.selectSingleNode("name/middlename").getText(),node.selectSingleNode("name/lastname").getText(),node.selectSingleNode("gender").getText(),node.selectSingleNode("marks").getText());
                for (int n = 0 ; n < columns.size() ; n++) {
                    insert.setString(n+1, columns.get(n));
                }
                insert.execute();
            }
         }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}


