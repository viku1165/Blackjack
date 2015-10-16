
package blackjack.gui;

import blackjack.logiikka.Saannot;
import javax.swing.JFrame;


public class Saannonluoja {
    
    private Saannot saannot;
    
    public Saannonluoja() {
        saannot = new Saannot();
    }
    
    public void luoIkkuna() {
        Saantoikkuna ikkuna = new Saantoikkuna(this);
        ikkuna.run();
    }
    
    public void setSaannot(Saannot s){
        this.saannot = s;
    }
    
    public Saannot getSaannot() {
        return saannot;
    }
   
}
