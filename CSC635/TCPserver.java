
import java.io.*;
import java.net.*;

public class TCPserver {


    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8543);
        Socket s = ss.accept();

        System.out.println("Client Connected");

        InputStreamReader inr = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(inr);

        String str = bf.readLine();
        System.out.println("client :" + str);

        // This is for two way communication server to client and client to server
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(" Hello This is Server Mr.Dhakal");
        pr.flush();
    }

}
