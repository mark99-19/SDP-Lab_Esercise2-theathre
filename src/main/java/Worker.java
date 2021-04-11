import java.net.*;
import java.io.*;

public class Worker extends Thread {
    private Socket connection = null;
    private Reservation reservation = null;
    //private BufferedReader inFromServer;
    private DataOutputStream outToClient;

    public Worker(Socket s, Reservation res) throws Exception
    {
        connection = s;
        reservation = res;
        // inFromServer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        outToClient = new DataOutputStream(connection.getOutputStream());

    }

    public void run()
    {
        Integer postiLiberi = null;
        boolean prenotato = false;

        System.out.println(String.format("[+] Processo %d creato.", this.getId()));

        try {
            synchronized (reservation){
                postiLiberi = reservation.controllaPosti();
                if(postiLiberi > 0) {
                    System.out.println(String.format("[+] %d: Posti liberi = %d", this.getId(), postiLiberi));
                    prenotato = reservation.prenotaPosto();
                    if (prenotato) {
                        outToClient.writeBytes("Posto prenotato!" + "\n");
                    }
                } else {
                    System.out.println(String.format("[+] %d: Biglietti esauriti.", this.getId()));
                    outToClient.writeBytes("Posti esauriti cazzo!" + "\n");
                }
            };

            connection.close();

        }
        catch(Exception e) {
            e.printStackTrace();
            //System.err.println(e);
        }

    }

}
