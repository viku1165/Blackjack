
package blackjack.logiikka;

/**
 * Mallintaa Blackjack-peliä ja pitää kirjaa pelitilanteesta
 * 
 */
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
        panos = 0;
        kasiKesken = true;
    }
    
    public void setPanos(int x) {
        panos = x;
    }
    
    public int getPanos() {
        return panos;
    }
    
    public Kasi getJakajanKasi() {
        return jakaja;
    }
    
    public Kasi getPelaajanKasi() {
        return pelaaja;
    }
    
    /**
     * Suorittaa käden alkujaon, eli jakaa pelaajalle ja jakajalle kaksi korttia
     */
    public void alkujako() {
        tyhjaaKadet();
        pelaaja.jaa(deck);
        jakaja.jaa(deck);
        pelaaja.jaa(deck);
        jakaja.jaa(deck);
    }
       
    /**
     * Jakaa pelaajalle yhdenkortin lisää. Jos käden arvo ylittää tämän jälkeen
     * 21, on käsi pelaajan osalta kesken.
     */
    public void hit() {
        pelaaja.jaa(deck);
        if(pelaaja.getValue() >= 21) {
            kasiKesken = false;
        }
        ekaVuoro = false;
    }
    
    /**
     * Lopettaa käden pelaajan osalta, kun pelaaja ei halua lisäkortteja.
     */
    public void stand() {
        kasiKesken = false;
    }
    
    /**
     * Tuplaa käden panoksen, minkä jälkeen pelaajalle jaetaan vielä yksi kortti.
     * Käytettävissä vain pelaajan ensimmäisellä vuorolla.
     */
    public void tuplaa() {
        if (ekaVuoro){
            panos = 2*panos;
            pelaaja.jaa(deck);
            kasiKesken = false;
        }
    }
    
    /**
     * Käden ollessa pelaajan osalta ohi, pelaa käden jakajan osalta, määrittää
     * voittajan ja päivittää pelaajan voittojen arvon.
     * @return String viesti, joka kertoo käden voittajan
     */
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
    
    /**
     * Aloittaa uuden käden, eli tyhjää kädet ja nollaa pelitilannetta kuvaavat
     * boolean-muuttujat kasiKesken ja ekaVuoro.
     */
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