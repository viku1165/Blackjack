
package blackjack.blackjack;


public class Blackjack {
    private Pakka deck;
    private Kasi jakaja;
    private Kasi pelaaja;
    private double panos;
    private double voitot;
    private boolean kasiKesken;
    
    public Blackjack() {
        deck = new Pakka();
        jakaja = new Kasi();
        pelaaja = new Kasi();
        voitot = 0;
        panos = 1;
        kasiKesken = true;
    }
    
    public void setPanos(double x) {
        panos = x;
    }
    
    public Kasi getJakajanKasi() {
        return jakaja;
    }
    
    public Kasi getPelaajanKasi() {
        return pelaaja;
    }
    
    public void alkujako() {
        tyhjaaKadet();
        pelaaja.deal(deck);
        jakaja.deal(deck);
        pelaaja.deal(deck);
        jakaja.deal(deck);
    }
    
    public void hit() {
        pelaaja.deal(deck);
        if(pelaaja.getValue() >= 21) {
            kasiKesken = false;
        }
    }
    
    public void stay() {
        kasiKesken = false;
    }
    
    public void tuplaa() {
        panos = 2*panos;
        pelaaja.deal(deck);
        kasiKesken = false;
    }
    
    public String resolve() {
        while(jakaja.getValue() < 16) {
            jakaja.deal(deck);
        }
        
        if(pelaaja.getValue() > 21) {
            if (jakaja.getValue() > 21) {
                return "tasapeli";
            } else {
                voitot -= panos;
                return "jakaja voittaa";
            }
        }
        if (jakaja.getValue() > 21) {
            voitot += panos;
            return "pelaaja voittaa";
        }
        if (jakaja.getValue() > pelaaja.getValue() ) {
            voitot -= panos;
            return "jakaja voittaa";
        }
        if (jakaja.getValue() > pelaaja.getValue() ) {
            return "tasapeli";
        }
        voitot += panos;
        return "pelaaja voittaa";
    }
    
    public boolean kasiKesken() {
        return kasiKesken;
    }
    
    public void tyhjaaKadet() {
        jakaja = new Kasi();
        pelaaja = new Kasi();
        kasiKesken = true;
    }
    
    public double getVoitot() {
        return voitot;
    }
    
}
