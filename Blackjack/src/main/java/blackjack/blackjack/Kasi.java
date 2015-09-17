

package blackjack.blackjack;

import java.util.ArrayList;


public class Kasi {
    private ArrayList<Kortti> cards;
    
    public Kasi() {
        cards = new ArrayList<>();
    }
    
    public void deal(Kortti card) {
        cards.add(card);
    }
    
    
     public void deal(Pakka deck) {
        cards.add(deck.nosta());
    }
    
    
    public int getValue() {
        int sum = 0;
        int assia = 0;
        for (Kortti card : cards) {
            sum += card.bjArvo();
            if(card.getArvo() == 1) {
                assia += 1;
            }
        }
        sum = FixAces(sum, assia);
        return sum;
    }
    
    
    // Jos käden arvo menee yli 21:n, vaihdetaan ässän arvoksi 11 sijasta 1
    public int FixAces(int arvo, int aces) {
        while(arvo > 21 && aces > 0) {
            arvo -= 10;
            aces -= 1;
        }
        return arvo;
    }
    
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
    
    public String toStringBlind() {
        String str = cards.get(0).toString();
        str = str + " **";
        return str;
    }
    
}
