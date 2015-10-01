

package blackjack.gui;

import blackjack.logiikka.Blackjack;
import javax.swing.JLabel;


public class KorttiKentta extends JLabel implements Paivitettava{
    
    private Blackjack peli;
    
    public KorttiKentta(Blackjack bj) {
        super();
        peli = bj;
    }
    
    public void paivita() {
        String text = peli.toString();
        super.setText(convert(peli.toString()));
    }
    
    private String convert(String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
    
}
