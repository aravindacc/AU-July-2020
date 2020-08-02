package telephonesystemjava;

public class Vodafone implements TelephoneSystem {
   
    @Override
    public void dial() {
        System.out.println("Calling from Vodafone.");
    }

    @Override
    public void recieve() {
        System.out.println("Recieved call in Vodafone.");
    }

    @Override
    public void cutCall() {
        System.out.println("Call has been disconnected.");
    }

    @Override
    public void pickUp() {
        System.out.println("Call has been picked up.");
    }
}
