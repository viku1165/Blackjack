
package blackjack.gui.komponentit;

import java.util.LinkedList;

/**
 * Lista Paivitettava-ilmentymiä, jotka voi päivittää kerralla.
 */
public class Paivityslista implements Paivitettava{

    private LinkedList<Paivitettava> lista;
    
    /**
     * Luo uuden, tyhjän listan.
     */
    public Paivityslista() {
        lista = new LinkedList<Paivitettava>();
    }
    
    /**
     * Lisää listaan uuden päivitettävän.
     * @param p Lisattava
     */
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
