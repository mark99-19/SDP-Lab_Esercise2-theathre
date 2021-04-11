public class Reservation {
    //classe dove si riservano i "cazzo" di biglietti

    private Integer tickets;

    /*
    Stiamo usando synchronized e non volatile perchè ci permette anche mutua esclusione (no valori cachati, accesso diretto a memoria)
     */

    public Reservation(){
        this.tickets = 1;
    }


    public synchronized int prenotaPosto()
    {
        if(tickets > 0) return tickets;
        else return 0;
    }

/*    public void diminuisciContatore()
    {
        this.tickets--;
    }*/


}
