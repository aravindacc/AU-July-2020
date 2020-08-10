package telephonesystemjava;

public class PlanDetails {
    private String planName= " Demo Name ", feature= "Default feature of a plan";
    private int validity=10, rate=10;

    public String getplanName() {
        return planName;
    }
    
    public void setplanName(String name) {
        this.planName = name;
    }
    
    public String getFeature() {
        return feature;
    }
    
    public void setFeature(String feature) {
        this.feature = feature;
    }
    
    public int getValidity() {
        return validity;
    }
    
    public void setValidity(int validity) {
        this.validity = validity;
    }
    
    public int getRate() {
        return rate;
    }
    
    public void setRate(int rate) {
        this.rate = rate;
    }
}
