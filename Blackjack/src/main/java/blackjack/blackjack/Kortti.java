
package blackjack.blackjack;

/**
 * Luokka mallintaa yhtä korttipakan korttia
 * 
 */
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
    
    /**
     * Antaa kortin arvo Blackjackissä. Ässä palauttaa arvon 11.
     * 
     * @return kortin arvo Blackjackissä
     */
    public int bjArvo() {
        if(arvo > 10) {
            return 10;
        }
        if(arvo == 1) {
            return 11;
        }
        return arvo;
    }
    
    public Maa getMaa() {
    return maa;
    }
    
    @Override
    public String toString() {
        if (arvo == 1) {
            return maa + " A";
        }
        return maa + " " + arvo;
    }
}
