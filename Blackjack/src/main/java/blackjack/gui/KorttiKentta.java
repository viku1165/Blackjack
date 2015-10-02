

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
        orig = "<html>" + orig.replaceAll("\n", "<br>");
        orig = orig.replaceAll("HERTTA", "<font color = 'red'>\u2764</font>");
        orig = orig.replaceAll("RUUTU", "<font color = 'red'>\u2666</font>");
        orig = orig.replaceAll("RISTI", "\u2663");
        orig = orig.replaceAll("PATA", "\u2660");
        return orig;
    }
    
}
