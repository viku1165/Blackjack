

package blackjack.gui;

import blackjack.logiikka.Blackjack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class KomentoKuuntelija implements ActionListener {
    
    private Blackjack peli;
    private JButton hit;
    private JButton stand;
    private JButton tuplaus;
    private KorttiKentta kortit;
    private JTextField viesti;
    
    public KomentoKuuntelija(Blackjack bj, JButton hit, JButton stand, JButton dd, KorttiKentta tulostus, JTextField jtf) {
        peli = bj;
        this.hit = hit;
        this.stand = stand;
        tuplaus = dd;
        this.kortit = tulostus;
        viesti = jtf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean kasiLoppu = false;
        if (peli.kadetTyhjat()) {
            peli.alkujako();
            kortit.paivita();
            viesti.setText("pelaa käyttäen alla olevia komentopainikkeita");
        } else if (peli.kasiKesken()) {
            if (e.getSource() == hit) {
                peli.hit();
            } else if (e.getSource() == stand) {
                peli.stand();
            } else if (e.getSource() == tuplaus) {
                peli.tuplaa();
            }
            kortit.paivita();
        } else if (peli.jaaJakajalle()) {
            kortit.paivita();
        } else if (!kasiLoppu){
            viesti.setText(peli.resolve());
            kasiLoppu = true;
        } else {
            peli.tyhjaaKadet();
            peli.setPanos(0);
            kortit.paivita();
            viesti.setText("Aseta panos ja paina komentonappulaa");
        }
    }
    
    
}
