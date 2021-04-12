public class Reservation {
    //classe dove si riservano i biglietti per il teatro

    private Integer tickets;

    /*
    Stiamo usando synchronized e non volatile perchè ci permette anche mutua esclusione (no valori cachati, accesso diretto a memoria)
     */

    public Reservation(){
        this.tickets = 1;
    }


    public int controllaPosti()
    {
        if(tickets > 0) return tickets;
        else return 0;
    }

    public boolean prenotaPosto()
    {
        if(tickets > 0) {
            tickets--;
            return true;
        }

        return false;
    }

}
