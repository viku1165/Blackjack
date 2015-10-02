
package blackjack.gui;

import blackjack.logiikka.Blackjack;
import javax.swing.JLabel;


public class Voittokentta extends JLabel implements Paivitettava {

    private Blackjack peli;
    
    public Voittokentta(Blackjack bj) {
        super("Voitot: " + bj.getVoitot());
        peli = bj;
    }
    
    @Override
    public void paivita() {
        super.setText("Voitot: " + peli.getVoitot());
    }
    
}
