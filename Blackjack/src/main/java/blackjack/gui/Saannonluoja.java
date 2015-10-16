
package blackjack.gui;

import blackjack.logiikka.Saannot;


public class Saannonluoja {
    
    private Saannot saannot;
    
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
