package telephone;



public interface telephone_interface {
	
	public void dialingUser(String input); //dialing to a number
	public void redial(); // redialing the number
	public void recievCall(String s); //receiving call
	public void terminateCall();  // cut the call
    public void callLog(); //shows the call log

}
