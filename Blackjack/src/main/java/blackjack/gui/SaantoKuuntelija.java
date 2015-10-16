
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
    private JRadioButton tasuritJakajalle;
    private JFrame saantoikkuna;
    private Saannonluoja s;

    
    public SaantoKuuntelija(JSpinner spinner, JRadioButton jakajalle, JFrame saannot, Saannonluoja sl) {
        pakat = spinner;
        tasuritJakajalle = jakajalle;
        saantoikkuna = saannot;
        s = sl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int pakkoja = (Integer) pakat.getValue();
        boolean jakajaVoittaa = tasuritJakajalle.isSelected();
        Saannot saannot = new Saannot(pakkoja, jakajaVoittaa);
        s.setSaannot(saannot);
        saantoikkuna.dispose();
    }
}
