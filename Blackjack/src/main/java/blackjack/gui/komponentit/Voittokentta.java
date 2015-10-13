
package blackjack.gui.komponentit;

import blackjack.logiikka.Blackjack;
import javax.swing.JLabel;

/**
 * Päivitettävä JLabel, joka näyttää pelin voitot.
 */
public class Voittokentta extends JLabel implements Paivitettava {

    private Blackjack peli;
    
    /**
     * Luo uuden Voittokentän.
     * @param bj peli, jonka voitoista pidetään kirjaa.
     */
    public Voittokentta(Blackjack bj) {
        super();
        peli = bj;
        this.setText("Voitot: " + voitot());
    }
    
    @Override
    public void paivita() {
        super.setText("Voitot: " + voitot());
    }
    
    private String voitot() {
        double voitot = peli.getVoitot();
        if (voitot == Math.floor(voitot)) {
            int v = (int) voitot;
            return Integer.toString(v);
        }
        return Double.toString(voitot);
    }
    
}
