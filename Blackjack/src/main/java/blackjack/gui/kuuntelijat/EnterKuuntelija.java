

package blackjack.gui.kuuntelijat;

import blackjack.gui.komponentit.Viestikentta;
import blackjack.gui.komponentit.Paivityslista;
import blackjack.logiikka.Blackjack;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * KeyListener-rajapinnan toteutus, joka käsittelee Enterillä annetut komennot,
 * esimerkiksi asettaa panoksen.
 */

public class EnterKuuntelija implements KeyListener {
    
    JTextField kentta;
    Blackjack peli;
    Viestikentta viesti;
    Paivityslista pvlista;
    
    public EnterKuuntelija(JTextField jta, Blackjack bj, Viestikentta viesti, Paivityslista pl) {
        peli = bj;
        kentta = jta;
        this.viesti = viesti;
        pvlista = pl;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!peli.panosAsetettu()) {
                int panos = 0;
                try {
                    panos = Integer.parseInt(kentta.getText());
                } catch (Exception x) {
                    viesti.uusiViesti("Panoksen tulee olla positiivinen kokonaisluku");
                    return;
                }
                if (panos <= 0) {
                    viesti.uusiViesti("Panoksen tulee olla positiivinen kokonaisluku");
                    return;
                }
                peli.setPanos(panos);
                kentta.setText("");
                pvlista.paivita();
                viesti.uusiViesti("panokseksi asetettu " + peli.getPelaajanKasi().getPanos() + ", paina mitä tahansa paniketta jakaaksesi kortit");
            } else if (peli.kadetTyhjat()) {
                peli.alkujako();
                pvlista.paivita();
                viesti.uusiViesti("pelaa käyttäen alla olevia komentopainikkeita");
            }
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}
