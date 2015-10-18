

package blackjack.gui.kuuntelijat;

import blackjack.gui.komponentit.Viestikentta;
import blackjack.gui.komponentit.Paivityslista;
import blackjack.logiikka.Blackjack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * ActionListener-rajapinnan toteuttava luokka, joka käsittelee käyttöliittymän
 * komentopainikkeiden painallukset
 */
public class KomentoKuuntelija implements ActionListener {
    
    private Blackjack peli;
    private JButton hit;
    private JButton stand;
    private JButton tuplaus;
    private JButton split;
    private Paivityslista pvlista;
    private Viestikentta viesti;
    
    public KomentoKuuntelija(Blackjack bj, JButton hit, JButton stand, JButton dd, JButton s, Paivityslista pl, Viestikentta vk) {
        peli = bj;
        this.hit = hit;
        this.stand = stand;
        tuplaus = dd;
        split = s;
        pvlista = pl;
        viesti = vk;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!peli.panosAsetettu()) {
            return;
        }
        
        if (peli.kadetTyhjat()) {
            peli.alkujako();
            pvlista.paivita();
            viesti.uusiViesti("pelaa käyttäen alla olevia komentopainikkeita");
        } else if (!peli.ykkoskasiValmis() || (peli.splitattu() && !peli.splitKasiValmis())) {
            if (e.getSource() == hit) {
                peli.hit();
            } else if (e.getSource() == stand) {
                peli.stand();
            } else if (e.getSource() == tuplaus) {
                peli.tuplaa();
            } else if (e.getSource() == split && !peli.splitattu()) {
                peli.split();
            }
            pvlista.paivita();
        } else if (peli.jaaJakajalle()) {
            pvlista.paivita();
        } else if (!peli.valmisAlkujakoon()){
            viesti.uusiViesti(peli.resolve(false));
            if(peli.splitattu()) {
                viesti.uusiViesti(peli.resolve(true));
            }
            peli.setValmisAlkujakoon(true);
        } else {
            peli.tyhjaaKadet();
            peli.setPanos(0);
            pvlista.paivita();
            viesti.uusiViesti("Aseta panos ja paina Enter");
        }
    }
    
    
}
