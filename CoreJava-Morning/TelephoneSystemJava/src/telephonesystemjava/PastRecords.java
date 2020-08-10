package telephonesystemjava;

public class PastRecords extends PlanDetails {
    private String cid;
    PlanDetails pdobj = new PlanDetails();

    PastRecords(String cid){
        this.cid=cid;
        System.out.println("Past record of Customer "+cid);	
    }

    void pastUsage(){
        System.out.println("This function will show the past  usage of customer: "+cid);
    }
}
