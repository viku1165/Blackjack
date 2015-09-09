
package blackjack.blackjack;


public class Kortti {
        
    private Maa maa;
    private int arvo;
    
    public Kortti(int no, int arvo) {
        if (no == 1) {
            maa = Maa.RUUTU;
        } else if (no == 2) {
            maa = Maa.RISTI;
        } else if (no == 3) {
            maa = Maa.PATA;
        } else if (no == 4) {
            maa = Maa.HERTTA;
        }
        this.arvo = arvo;
    }
    
    public int getArvo() {
        return arvo;
    }
    
    public Maa getMaa() {
    return maa;
    }
    
    @Override
    public String toString() {
        return maa + " " + arvo;
    }
}
