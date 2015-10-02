
package blackjack.gui;

import java.util.LinkedList;


public class Paivityslista implements Paivitettava{

    private LinkedList<Paivitettava> lista;
    
    public Paivityslista() {
        lista = new LinkedList<Paivitettava>();
    }
    
    public void lisaa(Paivitettava p){
        lista.add(p);
    }    
    
    @Override
    public void paivita() {
        for (Paivitettava p : lista) {
            p.paivita();
        }
    }
    
    
}
