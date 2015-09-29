

package blackjack.gui;

import blackjack.logiikka.Blackjack;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;


public class EnterKuuntelija implements KeyListener {
    
    JTextField kentta;
    Blackjack peli;
    Component tulostus;
    
    public EnterKuuntelija(JTextField jta, Blackjack bj, Component c) {
        peli = bj;
        kentta = jta;
        tulostus = c;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            peli.setPanos(Integer.parseInt(kentta.getText()));
        }
        kentta.setText("");
        tulostus.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}
