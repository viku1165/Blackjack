
package blackjack.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;


public class Saantoikkuna implements Runnable{

    private JFrame frame;
    private Saannonluoja sl;
    
    public Saantoikkuna(Saannonluoja s) {
        s = sl;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Blackjack");
        frame.setPreferredSize(new Dimension(200,400));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);    
    }
    
    public void luoKomponentit(Container c) {
        JPanel panel = new JPanel(new GridLayout(5,2));
        
        panel.add(new JLabel("Pakkojen maara"));
        panel.add(new JLabel()); //tyhjä solu
        SpinnerNumberModel PakkaSpinner = new SpinnerNumberModel(6, 1, 10, 1);
        JSpinner spinner = new JSpinner(PakkaSpinner);
        panel.add(spinner);
        
        panel.add(new JLabel()); //tyhjä solu
        panel.add(new JLabel("tasapelit"));
        panel.add(new JLabel()); //tyhjä solu
        ButtonGroup jakajaNappulat = new ButtonGroup();
        JRadioButton normi = new JRadioButton("panos palautetaan", true);
        JRadioButton jakaja = new JRadioButton("jakaja voittaa");
        jakajaNappulat.add(normi);
        jakajaNappulat.add(jakaja);
        panel.add(normi);
        panel.add(jakaja);
        
        panel.add(new JLabel()); //tyhjä solu
        JButton kayta = new JButton("Käytä");
        panel.add(kayta);
        
        SaantoKuuntelija sk = new SaantoKuuntelija(spinner, jakajaNappulat, jakaja, frame, sl);
        kayta.addActionListener(sk);
        
        c.add(panel);
    }
    
}
