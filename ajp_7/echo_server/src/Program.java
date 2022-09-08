import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Listening...");
            Socket client = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            String client_message ="";
            do {
                client_message = reader.readLine();
                if (client_message.equals("1")) {
                    writer.println(LocalDateTime.now().toString());
                } else if(client_message.equals("2")) {
                    System.out.println("Preparing to send !CALC");
                    writer.println("!CALC");
                    System.out.println("Sent !CALC");
                    int a = Integer.parseInt(reader.readLine());
                    System.out.println("Received a.");
                    int b = Integer.parseInt(reader.readLine());
                    System.out.println("Received b.");
                    writer.println(a + b);
                    System.out.println("Sent a+b.");
                } else if(client_message.equals("!END")) {
                    writer.println("!END");
                }
            }while(!client_message.equals("!END"));
            reader.close();
            writer.close();
            client.close();
            server.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
