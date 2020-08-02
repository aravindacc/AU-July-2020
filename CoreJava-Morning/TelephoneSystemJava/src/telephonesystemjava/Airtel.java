package telephonesystemjava;

public class Airtel extends Operator {
    @Override
    public void viewAllPlans() {
        System.out.println("plans for airtel operator");
    }
    
//    Overloading method
    public void viewAllPlans(String planType) {
        System.out.println("plans for airtel operator special customers.");
    }
}
