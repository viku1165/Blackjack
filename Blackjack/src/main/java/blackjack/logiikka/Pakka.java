
package blackjack.logiikka;

import java.util.Stack;
import java.util.Collections;

/**
 * Usean kortin muodostama pino. Konstruktori luo täyden 52 kortin pakan.
 * Pakkoja voi yhdistellä toisiinsa.
 */

public class Pakka {
    Stack<Kortti> pakka;
    int alkukoko;
    
    public Pakka() {
        pakka = new Stack<Kortti>();
        for (int i = 1; i < 14; i++) {
            for (int j = 1; j < 5; j++) {
                pakka.push(new Kortti(j,i));
            }
        }
        this.sekoita();
        alkukoko = 52;
    }
    
    /**
     * Palauttaa ja poistaa pakastapakan päällimmäisen kortin.
     * @return pakasta nostettu kortti
     */
    public Kortti nosta() {        
        Kortti nosto = pakka.pop();
        return nosto;
    }
    
    /**
     * sekoittaa pakan Collecions.shuffle-metodia käyttäen
     */
    public void sekoita() {
        Collections.shuffle(pakka);
    }
    
    
    // Testaamisen helpottamiseksi
    public Stack getStack() {
        return pakka;
    }
    
    /**
     * Kertoo, onko pakka tyhjä.
     * 
     * @return totuusarvo väitteelle "Pakka on tyhjä"
     */
    public boolean tyhja() {
        return pakka.empty();
    }
    
    /**
     * Kertoo pakassa olevien korttien lukumäärän
     * @return pakan korttien lukumäärä
     */
    public int koko() {
        return pakka.size();
    }
    
    /**
     * Sekoittaa parametrina annetun pakan yhteen tämän pakan kanssa
     * 
     * @param toinen Tähän pakkaan yhdistettävä pakka
     */
    public void yhdista(Pakka toinen) {
        while(!toinen.tyhja()) {
            Kortti k = toinen.nosta();
            pakka.push(k);
        }
        sekoita();
        alkukoko += 52;
    }
    
    /**
     * Kertoo, onko pakasta jäljellä alle parametrinä annettu osuus alkuperäiseen kokoon nähden.
     * @param lim osuus, väliltä (0,1)
     * @return onko pakasta jäljellä vähemmän kuin osuuden verran
     */
    public boolean jaljellaAlle(double lim) {
        double jaljella = (double)koko() / alkukoko;
        return (jaljella < lim);
    }
    
}
