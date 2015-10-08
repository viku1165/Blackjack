

package blackjack.gui;

import javax.swing.JTextArea;


public class Viestikentta extends JTextArea {
    
   public Viestikentta() {
       super("Aseta panos ja paina Enter");
       super.setEditable(false);
   }
   
   public void uusiViesti(String viesti) {
       super.append("\n" + viesti);
   }
   
}
