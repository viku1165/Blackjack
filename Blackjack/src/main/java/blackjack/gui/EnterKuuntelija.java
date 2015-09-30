

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
    
    public EnterKuuntelija(JTextField jta, Blackjack bj, JLabel jl) {
        peli = bj;
        kentta = jta;
        panostulostus = jl;
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
        panostulostus.setText("Panos: " + peli.getPanos());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}
