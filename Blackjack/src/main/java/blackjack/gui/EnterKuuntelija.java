

package blackjack.gui;

import blackjack.logiikka.Blackjack;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class EnterKuuntelija implements KeyListener {
    
    JTextField kentta;
    Blackjack peli;
    JLabel panostulostus;
    JTextField viesti;
    
    public EnterKuuntelija(JTextField jta, Blackjack bj, JLabel jl, JTextField viesti) {
        peli = bj;
        kentta = jta;
        panostulostus = jl;
        this.viesti = viesti;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean kasiLoppu = false;
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (peli.getPanos() == 0) {
                peli.setPanos(Integer.parseInt(kentta.getText()));
                kentta.setText("");
                panostulostus.setText("Panos: " + peli.getPanos());
                viesti.setText("panos asetettu, paina mitä paniketta jakaaksesi kortit");
            } //else if (peli.kadetTyhjat()) {
//                peli.alkujako();
//                kortit.paivita();
//                viesti.setText("pelaa käyttäen alla olevia komentopainikkeita");
//            } else if (peli.jaaJakajalle()) {
//                kortit.paivita();
//            } else if (!kasiLoppu){
//                viesti.setText(peli.resolve());
//                kasiLoppu = true;
//            } else {
//                peli.tyhjaaKadet();
//                peli.setPanos(0);
//                kortit.paivita();
//                viesti.setText("Aseta panos ja paina komentonappulaa");
//            }
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}
