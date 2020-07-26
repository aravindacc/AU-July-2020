
package assignment;

interface Telephone
{
    public void dial();  // dialing call  all 10 digit
    public void recieve(); // recieving call
    public void cutCall(); // cutting call - put back holder of telephone
    public void ring();   // ringing 
    public void putOnHold(); // put on hold
    public void putOffHold(); // put back from hold
    public void pressNumber(); // pressing each number to dial - single digit
    public void pickUp();   // pickup the holder of telephone

    public boolean isConnected(); // check is connected to call
    public boolean isPickedUp(); // holder is pickedup or not 
    public boolean isOnHold(); // telephone is on hold or not
    public boolean isIdle(); // telephone is idle 
}

class BSNL_telephone implements Telephone
{
    public boolean Connected;
    public boolean PickedUp;
    public boolean OnHold;
    public boolean Idle;

    public BSNL_telephone() {
        Connected = false;
        PickedUp = false;
        OnHold = false;
        Idle = true;
    }
    
       
    @Override
    public void dial() {
        if(isIdle()){
            pickUp();
            pressNumber();
            System.out.println("Dialing call");
        }else
        {
            System.out.println("System is busy");
        }
        
    }

    @Override
    public void pressNumber() {
        System.out.println("PressNumber");
    }
    @Override
    public void recieve() {
        ring();
        pickUp();
        Connected= true;
        System.out.println("Recieved call");
    }

    @Override
    public void cutCall() {
        PickedUp = false;
        Idle = true;
        Connected = false;
        System.out.println("Cutting call");
    }

    @Override
    public void ring() {
        System.out.println("Ringing..........");
        
    }

    @Override
    public void putOnHold() {
        OnHold = true;
        System.out.println("put on hold");
    }

    @Override
    public boolean isConnected() {
        return Connected;
    }

    @Override
    public boolean isPickedUp() {
        return PickedUp;
    }

    @Override
    public boolean isOnHold() {
        return OnHold;
    }

    @Override
    public boolean isIdle() {
        return Idle;
    }

    @Override
    public void pickUp() {
        
        PickedUp = true;
        Idle = false;
        System.out.println("picking up");
    }

    @Override
    public void putOffHold() {
        OnHold = false;
        System.out.println("Continuing call");
    }

}

public class Telephone_example {
    public static void main(String[] args) {
        
        Telephone home = new BSNL_telephone();
        home.pickUp();
        home.dial();
        home.recieve();
        home.cutCall();
    }
}
