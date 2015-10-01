

package blackjack.gui;

import java.awt.Component;
import java.awt.LayoutManager;
import java.util.LinkedList;
import javax.swing.JPanel;


public class PaivitettavaPaneeli extends JPanel implements Paivitettava {
    
    private LinkedList<Paivitettava> paivitettavat;
    
    public PaivitettavaPaneeli() {
        super();
        paivitettavat = new LinkedList<Paivitettava>();
    }
    
    public PaivitettavaPaneeli(LayoutManager lm) {
        super(lm);
        paivitettavat = new LinkedList<Paivitettava>();
    }

    @Override
    public Component add(Component c) {
        super.add(c);
        if(c instanceof Paivitettava && c != null) {
            Paivitettava p = (Paivitettava)c;
            paivitettavat.add(p);
        }
        return c;
    }
    
    @Override
    public void paivita() {
        for (Paivitettava p : paivitettavat) {
            p.paivita();
        }
    }
    
}
