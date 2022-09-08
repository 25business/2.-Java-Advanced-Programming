import java.net.ServerSocket;
import java.net.Socket;

public class Program {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            while(true) {
                Socket client = server.accept();
                ClientThread ct = new ClientThread(client);
                ct.start();
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
