import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class Client {

    public static void main(String[] args) throws Exception {

        String input = "";
        String inputNumbers = "";
        String serversAddress;
        String sum;
        int serverPort;
        Integer n1, n2;

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Inserisci indirizzo e porta del server: ");
        input = userInput.readLine();

        serversAddress = input.split(":")[0];
        serverPort = Integer.parseInt(input.split(":")[1]);

        Socket serverSocket = new Socket(serversAddress, serverPort);

        System.out.println("Inserisci due interi: ");
        inputNumbers = userInput.readLine();

        n1 = Integer.parseInt(inputNumbers.split(" ")[0]);
        n2 = Integer.parseInt(inputNumbers.split(" ")[1]);


        /* Inizializza lo stream di output verso la socket */
        DataOutputStream outToServer = new DataOutputStream(serverSocket.getOutputStream());

        /* Inizializza lo stream di input dalla socket */
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

        String clientMessage = n1.toString() + " " + n2.toString() + "\n";

        outToServer.writeBytes(clientMessage);       //writeBytes funziona ed e' piu' figo perche' altrimenti l'altro metodo non funziona

        String serverMessage = inFromServer.readLine();

        System.out.println("La somma del server è: " + serverMessage);

        serverSocket.close();

    }

}


