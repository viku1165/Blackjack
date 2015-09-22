

package blackjack.blackjack;

import blackjack.gui.Kayttoliittyma;
import javax.swing.SwingUtilities;

public class Main {


    public static void main(String[] args) {
        // graafinen
        Blackjack bj = new Blackjack(6);
        Kayttoliittyma kl = new Kayttoliittyma(bj);
        SwingUtilities.invokeLater(kl);
        
//        Tekstikayttoliittyma       
//        Blackjack bj = new Blackjack(6);
//        Tekstikayttoliittyma tkl = new Tekstikayttoliittyma(bj);
//        tkl.pelaa();
    }
    
}
