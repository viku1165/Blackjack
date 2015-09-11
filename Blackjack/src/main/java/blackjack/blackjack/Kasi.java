

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
        for (Kortti card : open) {
            sum += card.getArvo();
        }
        return sum;
    }
    
    public int blindValue() {
        int ov = openValue();
        if (blind == null) {
            return ov;
        }
        return ov + blind.getArvo();
    }
    
    public Kortti getBlind() {
        return blind;
    }
    
    public ArrayList getOpen() {
        return open;
    }
    
}
