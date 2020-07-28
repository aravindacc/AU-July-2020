package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inScanner = new Scanner(System.in);
        System.out.print("Enter input path:");
        String filePath = inScanner.next();

        CountFiles gf = new CountFiles();
        System.out.println(gf.getFile(filePath));
    }

}
