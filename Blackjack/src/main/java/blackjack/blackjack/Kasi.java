

package blackjack.blackjack;

import java.util.ArrayList;


public class Kasi {
    private Kortti blind;
    private ArrayList<Kortti> open;
    
    public Kasi() {
        open = new ArrayList<>();
        blind = null;
    }
    
    public void dealOpen(Kortti card) {
        open.add(card);
    }
    
    public void dealBlind(Kortti card) {
        blind = card;
    }
    
    public int openValue() {
        int sum = 0;
        int assia = 0;
        for (Kortti card : open) {
            sum += card.bjArvo();
            if(card.getArvo() == 1) {
                assia += 1;
            }
        }
        sum = FixAces(sum, assia);
        return sum;
    }
    
    public int blindValue() {
        int sum = openValue();
        if (blind == null) {
            return sum;
        }
        sum += blind.bjArvo();
        if(blind.getArvo() == 1) {
            sum = FixAces(sum, 1);
        }
        return sum;
    }
    
    
    // Jos käden arvo menee yli 21:n, vaihdetaan ässän arvoksi 11 sijasta 1
    public int FixAces(int arvo, int aces) {
        while(arvo > 21 && aces > 0) {
            arvo -= 10;
        }
        return arvo;
    }
    
    public Kortti getBlind() {
        return blind;
    }
    
    public ArrayList getOpen() {
        return open;
    }
    
}
