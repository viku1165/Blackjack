

package blackjack.gui;

import blackjack.logiikka.Blackjack;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JTextField;


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
            if (peli.getPanos() == 0) {
                peli.setPanos(Integer.parseInt(kentta.getText()));
                kentta.setText("");
                pvlista.paivita();
                viesti.uusiViesti("panos asetettu, paina mitä paniketta jakaaksesi kortit");
            } else if (peli.kadetTyhjat()) {
                peli.alkujako();
                pvlista.paivita();
                viesti.uusiViesti("pelaa käyttäen alla olevia komentopainikkeita");
            } else if (peli.jaaJakajalle()) {
                pvlista.paivita();
            } else if (!peli.valmisAlkujakoon()){
                viesti.uusiViesti(peli.resolve(true));

                peli.setValmisAlkujakoon(true);
            } else {
                peli.tyhjaaKadet();
                peli.setPanos(0);
                pvlista.paivita();
                viesti.uusiViesti("Aseta panos ja paina komentonappulaa");
            }

            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}
