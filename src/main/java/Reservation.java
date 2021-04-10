public class Reservation {
    //classe dove si riservano i "cazzo" di biglietti

    private Integer tickets;

    /*
    Stiamo usando synchronized e non volatile perchè ci permette anche mutua esclusione (no valori cachati, accesso diretto a memoria)
     */

    public Reservation(){
        tickets = 10;
    }


    public synchronized int prenotaPosto()
    {
        if(tickets > 0)
        {
            tickets--;
        }
        else
        {
            System.out.println("Posti esauriti!\n");
        }
        return 0;
    }

/*    public void diminuisciContatore()
    {
        this.tickets--;
    }*/


}
