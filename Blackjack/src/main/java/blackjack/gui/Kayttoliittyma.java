
package blackjack.gui;

import blackjack.logiikka.Blackjack;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class Kayttoliittyma implements Runnable {
    
    private JFrame frame;
    private Blackjack peli;
    private Paivityslista paivityslista;
    private Viestikentta viestikentta;
    
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
        paivityslista = new Paivityslista();
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
        JButton splittaa = new JButton("Split");
        panel.add(splittaa);        
        KomentoKuuntelija kk = new KomentoKuuntelija(peli, hit, stand, dd,splittaa, paivityslista,viestikentta);
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
        Voittokentta voitot = new Voittokentta(peli);
        panel.add(voitot);
        paivityslista.lisaa(voitot);

        JTextField panossyotto = new JTextField();
        panel.add(panossyotto);
        
        Panoskentta panostulostus = new Panoskentta(peli);
        panel.add(panostulostus);
        paivityslista.lisaa(panostulostus);

        EnterKuuntelija ek = new EnterKuuntelija(panossyotto,peli,viestikentta,paivityslista);
        panossyotto.addKeyListener(ek);
        
        return panel;
    }
    
    private JPanel tulostusKentat() {
        JPanel panel = new JPanel(new GridLayout(2,1));
        KorttiKentta kortit = new KorttiKentta(peli);
        panel.add(kortit);
        paivityslista.lisaa(kortit);
        viestikentta = new Viestikentta();
        panel.add(viestikentta);
        return panel;
    }
    

} 
