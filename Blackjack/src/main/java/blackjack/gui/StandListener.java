

package blackjack.gui;

import blackjack.logiikka.Blackjack;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;


public class StandListener implements ActionListener{
    
    private Blackjack peli;
    private JLabel tulostus;
    
    public StandListener(Blackjack bj, JLabel jl) {
        peli = bj;
        tulostus = jl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        peli.stand();
        tulostus.setText(peli.toString());
    }  
    
}
