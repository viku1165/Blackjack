
package blackjack.gui;

import blackjack.logiikka.Saannot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;


public class SaantoKuuntelija implements ActionListener {
    
    private JSpinner pakat;
    private ButtonGroup tasapelit;
    private JRadioButton tasuritJakajalle;
    private JFrame ikkuna;
    private Saannonluoja s;
    
    public SaantoKuuntelija(JSpinner spinner, ButtonGroup bg1, JRadioButton jakajalle, JFrame frame, Saannonluoja sl) {
        pakat = spinner;
        tasapelit = bg1;
        tasuritJakajalle = jakajalle;
        ikkuna = frame;
        s = sl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int pakkoja = (Integer) pakat.getValue();
        boolean jakajaVoittaa = tasapelit.getSelection().equals(tasuritJakajalle);
        Saannot saannot = new Saannot(pakkoja, jakajaVoittaa);
        s.setSaannot(saannot);
        ikkuna.dispose();
    }
}
