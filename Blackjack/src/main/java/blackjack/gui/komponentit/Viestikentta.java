

package blackjack.gui.komponentit;


import java.awt.BorderLayout;
import java.awt.ScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * JPanel-ilmentymä, joka sisältää scrollattavan tekstialueen, johon voi lisätä
 * riveittäisiä viestejä.
 */
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
   
   /**
    * Lisää viestikenttään uudelle riville parametrina annetun viestin
    * @param str haluttu viesti
    */
   public void uusiViesti(String str) {
       viesti.append("\n" + str);
   }
   
   
}
