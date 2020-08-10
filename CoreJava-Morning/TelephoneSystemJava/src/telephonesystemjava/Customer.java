package telephonesystemjava;

public class Customer extends PlanDetails {
    private String CustomerName= "Demo User", address= "default address ", govtid ="default proof";

    public String getCustomerName() {
        return CustomerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGovtid() {
        return govtid;
    }

    public void setGovtid(String govtid) {
        this.govtid = govtid;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void viewProfile() {
        System.out.println("Welcome customer.\n");
        return;
    }
}
