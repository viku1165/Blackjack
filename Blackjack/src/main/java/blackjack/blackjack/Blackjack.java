
package blackjack.blackjack;


public class Blackjack {
    private Pakka deck;
    private Kasi jakaja;
    private Kasi pelaaja;
    private double panos;
    private double voitot;
    
    public Blackjack() {
        deck = new Pakka();
        jakaja = new Kasi();
        pelaaja = new Kasi();
        voitot = 0;
        panos = 1;
    }
    
    public void setPanos(int x) {
        panos = x;
    }
    
    public Kasi getJakajanKasi() {
        return jakaja;
    }
    
    public Kasi getPelaajanKasi() {
        return pelaaja;
    }
    
    public void alkujako() {
        pelaaja.dealOpen(deck);
        jakaja.dealOpen(deck);
        pelaaja.dealOpen(deck);
        jakaja.dealBlind(deck);
    }
    
    public void hit() {
        pelaaja.dealOpen(deck);
        if(pelaaja.getValue() >= 21) {
            resolve();
        }
    }
    
    
    public void resolve() {
        while(jakaja.getValue() < 16) {
            jakaja.dealOpen(deck);
        }
        
        if(pelaaja.getValue() > 21) {
            if (jakaja.getValue() > 21) {
                // tasapeli
            } else {
                //jakajan voitto
            }
        }
        if (jakaja.getValue() > 21) {
           // pelaajan voitto
        }
        
    }
    
}
