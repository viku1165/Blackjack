
package blackjack.gui;

import blackjack.logiikka.Blackjack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;


public class DoubleListener implements ActionListener {
    
    private Blackjack peli;
    private JLabel tulostus;
    
    public DoubleListener(Blackjack bj, JLabel jl) {
        peli = bj;
        tulostus = jl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        peli.tuplaa();
        tulostus.setText(peli.toString());
    }  
    
}
