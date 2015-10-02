
package blackjack.gui;

import blackjack.logiikka.Blackjack;
import javax.swing.JLabel;


public class Panoskentta extends JLabel implements Paivitettava {

    private Blackjack peli;
    
    public Panoskentta(Blackjack bj) {
        super("Panos: " + bj.getPanos());
        peli = bj;
    }
    
    @Override
    public void paivita() {
        super.setText("Panos: " + peli.getPanos());
    }
    
}
