

package blackjack.gui;


import java.awt.BorderLayout;
import java.awt.ScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class Viestikentta extends JPanel {
    
    JTextArea viesti;
    
   public Viestikentta() {
       super();
       viesti = new JTextArea("aseta panos ja paina Enter",10,60);
       viesti.setEditable(false);
       this.add(viesti, BorderLayout.CENTER);
       
       lisaaScroll();
   }
   
   private void lisaaScroll() {
       JScrollPane scroll = new JScrollPane(viesti);
       scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       this.add(scroll);
   }
   
   public void uusiViesti(String str) {
       viesti.append("\n" + str);
   }
   
   
}
