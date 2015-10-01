
package blackjack.gui;

import blackjack.logiikka.Blackjack;
import blackjack.tekstikayttoliittyma.Tekstikayttoliittyma;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class Kayttoliittyma implements Runnable {
    
    private JFrame frame;
    private Blackjack peli;
    private KorttiKentta kortit;
    private JTextField viestikentta;
    
    public Kayttoliittyma(Blackjack bj) {
        peli = bj;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Blackjack");
        frame.setPreferredSize(new Dimension(700,500));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container cont) {
        cont.add(tulostusKentat());
        cont.add(voitotJaPanokset(), BorderLayout.NORTH);
        cont.add(luoNapit(),BorderLayout.SOUTH);
    }
        
    private JPanel luoNapit() {
        JPanel panel = new JPanel(new GridLayout(1,3));
        JButton hit = new JButton("Hit");
        panel.add(hit);
        JButton stand = new JButton("Stand");
        panel.add(stand);
        JButton dd = new JButton("Double down");
        panel.add(dd);
        KomentoKuuntelija kk = new KomentoKuuntelija(peli, hit, stand, dd, kortit,viestikentta);
        hit.addActionListener(kk);
        stand.addActionListener(kk);
        dd.addActionListener(kk);
        return panel;
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    private JPanel voitotJaPanokset() {
        
        JPanel panel = new JPanel(new GridLayout(1,3));
        String voitot = "Voitot: " + peli.getVoitot();
        panel.add(new JLabel(voitot));

        JTextField panoskentta = new JTextField();
        panel.add(panoskentta);
        
        JLabel panostxt = new JLabel("Panos: " + peli.getPanos());
        panel.add(panostxt);

        EnterKuuntelija ek = new EnterKuuntelija(panoskentta,peli,panostxt,viestikentta);
        panoskentta.addKeyListener(ek);
        
        return panel;
    }
    
    private JPanel tulostusKentat() {
        JPanel panel = new JPanel(new GridLayout(2,1));
        kortit = new KorttiKentta(peli);
        panel.add(kortit);
        viestikentta = new JTextField("Aseta panos ja paina komentonappulaa");
        viestikentta.setEditable(false);
        panel.add(viestikentta);
        return panel;
    }
    

} 
