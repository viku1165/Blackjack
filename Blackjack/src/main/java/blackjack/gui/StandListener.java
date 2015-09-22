

package blackjack.gui;

import blackjack.blackjack.Blackjack;
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
