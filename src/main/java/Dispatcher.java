import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Dispatcher {

    public static void main(String[] args) throws Exception {

        Socket connection = null;
        ServerSocket welcomeSocket = null;
        Reservation reservation;
        welcomeSocket = new ServerSocket(6789);             //qui il comportamento è strano, poichè crea già il canale di comunicazione e lo accetta pure
        reservation = new Reservation();

        while (true) {
            System.out.println("\n[+] Waiting for connection");
            connection = welcomeSocket.accept();
            System.out.println("[+] Connected with: " + connection.getInetAddress() + ":" + connection.getPort());

            // Per testare l'acquisizione e il mantenimento del lock su Reservation
            //WorkerRitardato newRitardato = new WorkerRitardato(connection, reservation);
            Worker newWorker = new Worker(connection, reservation);

            //newRitardato.start();
            newWorker.start();
        }

    }
}