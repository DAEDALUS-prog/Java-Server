import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Start Server!");

        BufferedReader in = null;
        PrintWriter out = null;

        ServerSocket server = null;
        Socket client = null;

        try {
            server = new ServerSocket(1234);
        } catch (IOException ex) {
            System.out.println("Error connect to <1234> PORT");
            System.exit(-1);
        }

        try {
            System.out.println("Waiting connect!");
            client = server.accept();
            System.out.println("Client connect...");
        } catch (IOException ex) {
            System.out.println("Error connect to SERVER!");
            System.exit(-1);
        }

        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);

        String input;
        String output;

        System.out.println("Wait messages..");
        while ((input = in.readLine()) != null) {
            if (input.equalsIgnoreCase("exit"))
                break;
            out.println("Server " + input);
            System.out.println(input);
        }

        out.close();
        in.close();
        server.close();
        client.close();

    }
}