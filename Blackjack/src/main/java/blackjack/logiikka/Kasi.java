

package blackjack.logiikka;

import java.util.ArrayList;

/**
 * Kuvaa pelaajan tai jakajan kättä Blackjack-pelissä
 *
 */
public class Kasi {
    private ArrayList<Kortti> cards;
    
    public Kasi() {
        cards = new ArrayList<>();
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
        String tulos = cards.get(0).toString();
        for (int i = 1; i < cards.size(); i++) {
            tulos = tulos + " " + cards.get(i).toString();
        }
        return tulos;
    }
    
    /**
     * Käden merkkijonoesitys silloin, kun yksi jakajan kortti pitää esittää piilotettuna
     * @return Käden merkkijonoesitys, kun yksi kortti piilossa
     */
    public String toStringBlind() {
        String str = cards.get(0).toString();
        str = str + " **";
        return str;
    }
    
}
