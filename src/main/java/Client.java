import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class Client {

    public static void main(String[] args) throws Exception {

        String data;

        //Create connection
        System.out.println("[+] Connecting to server...");
        Socket connection = new Socket("localhost", 6789);
        System.out.println("["+connection.getLocalPort()+"] Successfull connected to port: " + connection.getPort());

        //crete "file descriptor" for i/o
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        //read data from server
        data = inFromServer.readLine();
        System.out.println("["+connection.getLocalPort()+"] Result: " + data + "\n");

        connection.close();
    }

}


