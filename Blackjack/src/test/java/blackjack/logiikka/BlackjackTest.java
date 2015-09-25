

package blackjack.logiikka;

import blackjack.logiikka.Kasi;
import blackjack.logiikka.Blackjack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BlackjackTest {
    
    private Blackjack bj;
    
    @Before
    public void setUp() {
        bj = new Blackjack(6);
        bj.alkujako();
    }
    
    @Test
    public void alkujakoToimii() {
        Kasi pelaaja = bj.getPelaajanKasi();
        Kasi jakaja = bj.getPelaajanKasi();
        assertEquals(2, pelaaja.getCards().size());
        assertEquals(2, jakaja.getCards().size());
    }
    
    @Test
    public void hitJakaaKortin() {
        bj.hit();
        Kasi pelaaja = bj.getPelaajanKasi();
        assertEquals(3, pelaaja.getCards().size());
    }
    
    @Test
    public void hitYli21PysayttaaKaden() {
        while(bj.kasiKesken()) {
            assertTrue(bj.getPelaajanKasi().getValue() < 22);
            bj.hit();
        }
        assertTrue(bj.getPelaajanKasi().getValue() >= 21);
    }
    
    @Test
    public void standPysayttaaKaden() {
        bj.stand();
        assertTrue(!bj.kasiKesken());
    }
    
    @Test
    public void tuplausPysayttaaKaden() {
        bj.tuplaa();
        assertTrue(!bj.kasiKesken());
    }
    
    @Test
    public void tuplausJakaaKortin() {
        bj.tuplaa();
        Kasi pelaaja = bj.getPelaajanKasi();
        assertEquals(3, pelaaja.getCards().size());
    }
    
    @Test
    public void tuplausTuplaaPanoksen() {
        bj.setPanos(1);
        bj.tuplaa();
        int panos = bj.getPanos();
        assertEquals(2, panos);
    }
    
    @Test
    public void kasienTyhjennysTyhjaaKadet() {
        bj.tyhjaaKadet();
        Kasi pelaaja = bj.getPelaajanKasi();
        Kasi jakaja = bj.getPelaajanKasi();
        assertEquals(0, pelaaja.getCards().size());
        assertEquals(0, jakaja.getCards().size());
    }
    
    @Test
    public void kasienTyhjennyksenJalkeenOnEkaVuoro() {
        bj.tyhjaaKadet();
        assertTrue(bj.getEkaVuoro());
    }
    
    @Test
    public void kasienTyhjennyksenJalkeenKasiKesken() {
        bj.tyhjaaKadet();
        assertTrue(bj.kasiKesken());
    }
    
}
