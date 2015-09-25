

package blackjack.gui;

import blackjack.logiikka.Blackjack;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StandListener implements ActionListener{
    
    private Blackjack peli;

    
    public StandListener(Blackjack bj) {
        peli = bj;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        peli.stand();

    }  
    
}
