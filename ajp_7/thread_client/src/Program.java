import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Enter username:");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        boolean is_running = true;
        try {
            Socket client = new Socket("10.20.10.118", 5000);
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while(is_running) {
                System.out.println("""
                        [!ALL] Get all messages
                        [!PUT] Send a message
                        [!END] End application""");
                String operation = input.nextLine();
                writer.println(operation);
                String response_json = reader.readLine();
                Response response = ResponseParser.from_json(response_json);
                switch (response.command) {
                    case "!ALL":
                        System.out.println("--- ALL MESSAGES ---");
                        for(Message m : response.messages) {
                            System.out.println(m);
                        }
                        break;
                    case "!PUT":
                        System.out.println("Enter your message:");
                        String text = input.nextLine();
                        Message m = new Message(LocalTime.now(),username,text);
                        Response put_response = new Response();
                        put_response.messages = new ArrayList<>();
                        put_response.messages.add(m);
                        writer.println(ResponseParser.to_json(put_response));
                        reader.readLine();
                        System.out.println("Message has been saved!");
                        break;
                    case "!INVALID":
                        System.err.println("You have entered invalid command!");
                        break;
                    case "!END": default:
                        System.out.println("You have exited the application.");
                        is_running = false;
                }
            }
            reader.close();
            writer.close();
            client.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
