import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket client;
    private PrintWriter writer;
    private BufferedReader reader;
    private boolean is_running;

    public ClientThread(Socket client) throws IOException {
        this.client = client;
        this.writer = new PrintWriter(client.getOutputStream(), true);
        this.reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.is_running = true;
    }


    public void run() {
        while(is_running) {
            try {
                String operation = reader.readLine();
                Response response = new Response();
                if(operation.equals("!ALL")) {
                    response.command = "!ALL";
                    response.messages = Message.all();
                    writer.println(ResponseParser.to_json(response));
                } else if(operation.equals("!PUT")) {
                    response.command = "!PUT";
                    writer.println(ResponseParser.to_json(response));
                    String message_json = reader.readLine();
                    Response message_put = ResponseParser.from_json(message_json);
                    Message.put(message_put.messages.get(0));
                    response.command = "!SAVED";
                    writer.println(ResponseParser.to_json(response));
                } else if(operation.equals("!END")) {
                    is_running = false;
                    response.command = "!END";
                    writer.println(ResponseParser.to_json(response));
                }
                else {
                    response.command = "!INVALID";
                    writer.println(ResponseParser.to_json(response));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                is_running = false;
            }
        }
        try {
            reader.close();
            writer.close();
            client.close();
        } catch (Exception ex) {}
    }
}
