
package blackjack.blackjack;


public class Blackjack {
    private Pakka deck;
    private Kasi jakaja;
    private Kasi pelaaja;
    private int panos;
    private int voitot;
    private boolean kasiKesken;
    private boolean ekaVuoro;
    
    public Blackjack(int pakkoja) {
        deck = new Pakka();
        for (int i = 1; i < pakkoja; i++) {
            Pakka uusi = new Pakka();
            deck.yhdista(uusi);
        }
        
        jakaja = new Kasi();
        pelaaja = new Kasi();
        voitot = 0;
        panos = 1;
        kasiKesken = true;
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
        tyhjaaKadet();
        pelaaja.jaa(deck);
        jakaja.jaa(deck);
        pelaaja.jaa(deck);
        jakaja.jaa(deck);
    }
    
    public void hit() {
        pelaaja.jaa(deck);
        if(pelaaja.getValue() >= 21) {
            kasiKesken = false;
        }
        ekaVuoro = false;
    }
    
    public void stand() {
        kasiKesken = false;
    }
    
    public void tuplaa() {
        if (ekaVuoro){
            panos = 2*panos;
            pelaaja.jaa(deck);
            kasiKesken = false;
        }
    }
    
    public String resolve() {
        while(jakaja.getValue() < 16) {
            jakaja.jaa(deck);
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
        if (jakaja.getValue() == pelaaja.getValue() ) {
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
        ekaVuoro = true;
    }
    
    public int getVoitot() {
        return voitot;
    }
    public boolean getEkaVuoro() {
        return ekaVuoro;
    }
    
}
