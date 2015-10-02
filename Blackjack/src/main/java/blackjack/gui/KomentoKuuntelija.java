

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
    private Paivityslista pvlista;
    private JTextField viesti;
    
    public KomentoKuuntelija(Blackjack bj, JButton hit, JButton stand, JButton dd, Paivityslista pl, JTextField jtf) {
        peli = bj;
        this.hit = hit;
        this.stand = stand;
        tuplaus = dd;
        pvlista = pl;
        viesti = jtf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (peli.kadetTyhjat()) {
            peli.alkujako();
            pvlista.paivita();
            viesti.setText("pelaa käyttäen alla olevia komentopainikkeita");
        } else if (peli.kasiKesken()) {
            if (e.getSource() == hit) {
                peli.hit();
            } else if (e.getSource() == stand) {
                peli.stand();
            } else if (e.getSource() == tuplaus) {
                peli.tuplaa();
            }
            pvlista.paivita();
        } else if (peli.jaaJakajalle()) {
            pvlista.paivita();
        } else if (!peli.valmisAlkujakoon()){
            viesti.setText(peli.resolve());
            peli.setValmisAlkujakoon(true);
        } else {
            peli.tyhjaaKadet();
            peli.setPanos(0);
            pvlista.paivita();
            viesti.setText("Aseta panos ja paina komentonappulaa");
        }
    }
    
    
}
