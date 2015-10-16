

package blackjack.main;

import blackjack.logiikka.Blackjack;
import blackjack.gui.Kayttoliittyma;
import javax.swing.SwingUtilities;

public class Main {


    public static void main(String[] args) {
        // graafinen
        Kayttoliittyma kl = new Kayttoliittyma();
        SwingUtilities.invokeLater(kl);
        
    }
    
}
