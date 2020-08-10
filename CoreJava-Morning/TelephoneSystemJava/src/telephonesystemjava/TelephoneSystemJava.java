package telephonesystemjava;
import java.util.Scanner;

public class TelephoneSystemJava {
    public static void main(String[] args) {
        while(true) {
            System.out.println("----------Our Options------------");
            System.out.println("1. Customer Profile \n2. View Operators \n3. Close");
            System.out.println("------------------------");
            Scanner sc=new Scanner(System.in);
            int c=sc.nextInt();
            switch(c) {
            case 1: 
                Customer cobj = new Customer();
                cobj.viewProfile();
                break;
            case 2:
                System.out.println("Choose option: \n1. Airtel "
                                + "\n2. Vodafone ");
                int opchoice = sc.nextInt();
                switch(opchoice) {
                case 1:
                    System.out.println("Choose option: \n 1. Normal Customer "
                                + "\n 2. Special Customer ");
                    Airtel opobj = new Airtel();
                    int custType = sc.nextInt();
                    String str = "Special";
                    
                    switch(custType){
                        case 1:
                            opobj.viewAllPlans();
                            break;
                        case 2:
                            opobj.viewAllPlans(str);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Choose option: \n 1. Dial "
                                + "\n 2. Receive " + "\n 3. Pick Up " + "\n 4. Cut Call ");
                    Vodafone opobj1 = new Vodafone();
                    int optionType = sc.nextInt();
                    
                    switch(optionType){
                        case 1:
                            opobj1.dial();
                            break;
                        case 2:
                            opobj1.recieve();
                            break;
                        case 3:
                            opobj1.pickUp();
                            break;
                        case 4:
                            opobj1.cutCall();
                            break;
                    }
                    break;
                }
                break;
            case 3: 
                System.out.println("Thank you for using our service.");
                return;

            default: 
                System.out.println("Enter a valid option.");
            }		
	}
    }
}