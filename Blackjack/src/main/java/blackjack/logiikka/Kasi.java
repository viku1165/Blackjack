

package blackjack.logiikka;

import java.util.ArrayList;

/**
 * Kuvaa pelaajan tai jakajan kättä Blackjack-pelissä
 *
 */
public class Kasi {
    private ArrayList<Kortti> cards;
    private boolean valmis;
    private int panos;
    
    /**
     * Luo uuden, tyhjän käden
     * 
     */
    public Kasi() {
        cards = new ArrayList<>();
        valmis = false;
        panos = 0;
    }
    
    /**
     * Lisää parametrina annetun kortin käteen
     * @param card lisättävä kortti 
     */
    public void jaa(Kortti card) {
        cards.add(card);
    }
    
    /**
     * Lisää käteen annetusta pakasta nostetun kortin
     * @param deck pakka, josta käteen jaetaan kortti
     */
     public void jaa(Pakka deck) {
        cards.add(deck.nosta());
    }
    
    /**
     * Laskee käden arvon Blackjackissä. Mikäli kädessä on ässiä, palautetaan
     * suurin alle 21 oleva arvo. Mikäli ei mahdollista arvo alle 21:n, palautetaan
     * pienin mahdollinen arvo
     * @return kortin Blackjack-arvo
     */
    public int getValue() {
        int sum = 0;
        int assia = 0;
        for (Kortti card : cards) {
            sum += card.bjArvo();
            if(card.getArvo() == 1) {
                assia += 1;
            }
        }
        sum = fixAces(sum, assia);
        return sum;
    }
    
    
    // Jos käden arvo menee yli 21:n, vaihdetaan ässän arvoksi 11 sijasta 1
    private int fixAces(int arvo, int aces) {
        while(arvo > 21 && aces > 0) {
            arvo -= 10;
            aces -= 1;
        }
        return arvo;
    }
    
    /**
     * Palauttaa käden sisältämät kortit ArrayList-muodossa
     * @return ArrayList lista käden sisältämistä korteista
     */
    public ArrayList getCards() {
        return cards;
    }
    
    @Override
    public String toString() {
        StringBuilder tulos = new StringBuilder(cards.get(0).toString());
        for (int i = 1; i < cards.size(); i++) {
            tulos.append("   " + cards.get(i).toString());
        }
        return tulos.toString();
    }
    
    /**
     * Käden merkkijonoesitys silloin, kun yksi jakajan kortti pitää esittää piilotettuna
     * @return Käden merkkijonoesitys, kun yksi kortti piilossa
     */
    public String toStringBlind() {
        String str = cards.get(0).toString();
        str = str + "  **";
        return str;
    }
    
    /**
     * Kertoo onko käsi tyhjä.
     * @return boolean onko käsi tyhjä
     */
    public boolean tyhja() {
        return cards.isEmpty();
    }
    
    
    public boolean bust() {
        return getValue() > 21;
    }
    
    /**
     * Kertoo, onko käteen jaettu lisäkortteja alkujaon jälkeen, siis onko
     * korttien lukumäärä kaksi. Huom! metodi ei siis varsinaisesti kerro, onko
     * kättä pelattu aiemmin, sillä passaamisen jälkeen metodi palauttaa edelleen
     * true
     * @return Kortteja kädessä = 2
     */
    public boolean ekaVuoro() {
        return cards.size() == 2;
    }
    
    /**
     * Asettaa valmis = true
     */
    public void valmista() {
        valmis = true;
    }
    
    public boolean valmis() {
        return valmis;
    }
    
    public void setPanos(int x) {
        panos = x;
    }
    
    public int getPanos() {
        return panos;
    }
    
    public void tuplaaPanos() {
        panos *= 2;
    }
    
    /**
     * Kertoo, onko käsi blackjack (ässä ja mikä tahansa 10 arvoinen kortti)
     * @return Onko käsi blackjack
     */
    public boolean blackjack() {
        return ekaVuoro() && getValue() == 21;
    }
    
}
