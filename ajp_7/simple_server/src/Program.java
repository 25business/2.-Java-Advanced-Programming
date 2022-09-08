import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Program {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Listening...");
            Socket client = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String input_line = "";
            do {
                input_line = reader.readLine();
                System.out.println(input_line);
            } while(input_line != null && !input_line.trim().equals(""));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
