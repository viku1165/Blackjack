
package blackjack.gui;

import blackjack.blackjack.Blackjack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HitListener implements ActionListener {
    
    private Blackjack peli;
    
    public HitListener(Blackjack bj) {
        peli = bj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        peli.hit();
    }        
    
}
