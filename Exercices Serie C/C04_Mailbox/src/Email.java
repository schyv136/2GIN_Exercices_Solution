
import java.util.ArrayList;

/**
 * Represents an Email Account with an Inbox and an Sent Box
 *
 * @author robertfisch
 * @version 01/02/2011 09:38:01
 */
public class Email {

    private String email;

    private ArrayList<Message> alInbox = new ArrayList<>();
    private ArrayList<Message> alSent = new ArrayList<>();

    public Email(String pEmail) {
        email = pEmail;
    }

    public void sendMessage(Email pReceiver, String data) {
        Message m = new Message(this, pReceiver, data);
        alSent.add(m);
        pReceiver.receiveMessage(m);
    }

    public void receiveMessage(Message pMessage) {
        alInbox.add(pMessage);
    }

    public String toString() {
        return email;
    }
}
