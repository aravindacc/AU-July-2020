import java.io.File;

public class sample{

    public static void main(String args[]){

        File Files = new File("/home/rajdeep/Desktop/Accolite_Assignment/Advanced_java");
        int Count = Files.list().length;
        System.out.println("No. Of Files: " +Count);

    }

}