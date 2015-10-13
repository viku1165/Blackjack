

package blackjack.gui.komponentit;

/**
 * Rajapinta, jonka edustajat ovat käyttöliittymäkomponentteja, joita voi päivittää
 * vastaamaan nykyistä pelitilannetta.
 */
public interface Paivitettava{
    
    /**
     * Päivittää komponentin vastaamaan pelitilannetta.
     */
    public void paivita();
}
