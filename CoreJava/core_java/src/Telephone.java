abstract class Telephone {
        public abstract void dial();
        public abstract void call();
        public abstract void callHistory();
        public abstract void pressButton();
        public abstract void cutCall();
        public abstract void pick();
}

class landline extends Telephone
{
    public boolean Connected;
    public boolean recieved;
    public boolean idle;


    public void telephone() {
        Connected = false;
        recieved = false;
        idle = true;

    }


    @Override
    public void dial() {

        if(idle){

            System.out.println("calling");
            pressButton();
        }else
        {
            System.out.println("Busy");
        }

    }

    @Override
    public void pressButton() {
        idle = false;

        System.out.println("try to call");
        call();
    }

    @Override
    public void call() {

       System.out.println("Recieved call");
        pick();
    }
    @Override
    public void pick() {
        recieved = true;
        Connected = true;
        System.out.println("call is connected");
        cutCall();
    }
    @Override
    public void cutCall() {
        recieved = false;
        Connected = false;
        idle = true;
        System.out.println("disconnect call");
    }
    @Override
    public void callHistory() {
        if(idle){
        System.out.println("call history is printed");
        }
        else{
            System.out.println("not idle");
        }
    }
}

class Telephone_example {
    public static void main(String[] args) {

        Telephone phone = new landline();
        phone.dial();
        phone.pressButton();
        phone.call();
        phone.pick();
        phone.cutCall();
        phone.callHistory();
    }
}
