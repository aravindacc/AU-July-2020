
package advancejava;

import java.io.File;
import java.util.Scanner;



public class AdvanceJava {

    public static int[] getFileName(File f, String displacement)
    {
        //Printing current directory 
        System.out.println(displacement+"---D : "+f.getName());
        
        // depth distance for recursive directory or files 
        displacement += "   |";
        
        // list of files in rectory 
        File list[] = f.listFiles();
        
        // variable to count files and dirctory (in Same Directory) 
        int fileCount =0, DirectoryCount = 0;
        
        // variable to count files and dirctory (Total count Same + Child count) 
        int RfileCount =0, RDirectoryCount = 0;
        
        
        for (File file : list) {
            // if file object is directory 
            // then checks file and directory in this directory first
            if(file.isDirectory())
            {
                DirectoryCount++;
                RDirectoryCount++;// increase count of directoory
                
                int val[] = getFileName(file,displacement);
                RfileCount += val[0];
                RDirectoryCount += val[1];
            }else
            {
                fileCount++;// increae count of files
                RfileCount++;
                System.out.println(displacement +"---F : "+ file.getName());
            }
        }
        // printing total number of files and directory
        System.out.print(displacement+"(File : "+fileCount);
        System.out.println(" ,Directory : "+DirectoryCount+")");
        
        // printing total number of files and directory(Recursive)
        System.out.print(displacement+"(Total File : "+RfileCount);
        System.out.println(" ,Directory : "+RDirectoryCount+")");
        
        return new int[]{RfileCount,RDirectoryCount};
    }
    
    public static void main(String[] args) {
        
        // Take input from user 
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter path : ");
        String path = sc.nextLine();
        
        
        File f = new File(path);
        
        getFileName(f,""); //  function to get child files and directory
    }
    
}
