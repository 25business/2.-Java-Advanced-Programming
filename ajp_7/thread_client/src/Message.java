import java.time.LocalTime;
import java.util.ArrayList;

public class Message {
    static ArrayList<Message> messages = new ArrayList<>();
    private String text;
    private LocalTime sent;
    private String user;

    public Message(LocalTime sent, String user, String text) {
        this.sent = sent;
        this.user = user;
        this.text = text;
    }

    public String toString() {
        return String.format("[%s] %s: %s",sent, user, text);
    }

    public static void put(Message message) {
        messages.add(message);
    }

    public static ArrayList<Message> all() {
        return messages;
    }
}
