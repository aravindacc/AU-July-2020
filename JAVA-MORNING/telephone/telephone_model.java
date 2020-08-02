public interface telephone_model {
    void call(String s); // Making a call by taking input of 10 digit number
    void end_call(); //Ending the call
    void redial(); // Redialling the last number dialled
    void receive_call(String r); // Recieving a call
    void log(); // Shows dial call history of user
}
