

package blackjack.gui;

import blackjack.logiikka.Blackjack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class KomentoKuuntelija implements ActionListener {
    
    private Blackjack peli;
    private JButton hit;
    private JButton stand;
    private JButton tuplaus;
    private JLabel tulostus;
    
    public KomentoKuuntelija(Blackjack bj, JButton hit, JButton stand, JButton dd, JLabel tulostus) {
        peli = bj;
        this.hit = hit;
        this.stand = stand;
        tuplaus = dd;
        this.tulostus = tulostus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (peli.getPelaajanKasi().tyhja()) {
            peli.alkujako();
            tulostus.setText(peli.toString());
        } else if (peli.kasiKesken()) {
            if (e.getSource() == hit) {
                peli.hit();
            } else if (e.getSource() == stand) {
                peli.stand();
            } else if (e.getSource() == tuplaus) {
                peli.tuplaa();
            }
            tulostus.setText(peli.toString());
        } else {
            while (peli.jaaJakajalle()) {
                tulostus.setText(peli.toString());
            }
            tulostus.setText(peli.resolve());
        }
    }
    
    
}
