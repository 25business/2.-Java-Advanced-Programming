import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 5000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("[1] Current Date and Time\n[2] Calculator\n[!END] End");
                writer.println(scanner.nextLine());
                String response = reader.readLine();
                System.out.println("Server responded: " + response);
                if (response.equals("!CALC")) {
                    System.out.println("Enter first number: ");
                    writer.println(scanner.nextLine());
                    System.out.println("Enter second number: ");
                    writer.println(scanner.nextLine());
                    System.out.println("Result: " + reader.readLine());
                } else if (response.equals("!END")) {
                    break;
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
