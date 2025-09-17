
/**
 * Simple message with sender and receiver
 *
 * @author  robertfisch
 * @version 01/02/2011 09:39:16
 */
public class Message {

    private String data;

    private Email sender;
    private Email receiver;

    public Message(Email pSender, Email pReceiver, String pData) {
        sender = pSender;
        receiver = pReceiver;
        data = pData;
    }

    public String toString() {
        return sender + " -> " + receiver;
    }
}
