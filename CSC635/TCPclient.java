
import java.io.*;
import java.net.*;

public class TCPclient {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 8543);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(" Hello This is Kaialsh");
        pr.flush();

        // This is for two way communication server to client and client to server
        InputStreamReader inr = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(inr);

        String str = bf.readLine();
        System.out.println("server :" + str);
    }

}

