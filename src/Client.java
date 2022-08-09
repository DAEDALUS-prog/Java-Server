import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client start");
        Socket server = null;

        if (args.length == 0) {
            System.out.println("Using: Java Client Hostname");
            System.exit(-1);

        }

        System.out.println("Connect to server.." + args[0]);
        server = new Socket(args[0], 1234);

        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter out = new PrintWriter(server.getOutputStream(), true);
        BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

        String fUser;
        String fServer;

        while ((fUser = inu.readLine()) != null) {
            out.println(fUser);
            fServer = in.readLine();
            System.out.println(fServer);

            if (fUser.equalsIgnoreCase("close"))
                break;
            if (fUser.equalsIgnoreCase("exit"))
                break;
        }

        out.close();
        in.close();
        server.close();
        inu.close();
    }
}
