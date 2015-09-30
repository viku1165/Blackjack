
package blackjack.gui;

import blackjack.logiikka.Blackjack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class HitListener implements ActionListener {
    
    private Blackjack peli;
    private JLabel tulostus;
    
    public HitListener(Blackjack bj, JLabel jl) {
        peli = bj;
        tulostus = jl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (peli.getPelaajanKasi().getCards().isEmpty()) {
            peli.alkujako();
            tulostus.setText(peli.toString());
        } else {
            peli.hit();
            tulostus.setText(peli.toString());
        }

    }        
    
}
