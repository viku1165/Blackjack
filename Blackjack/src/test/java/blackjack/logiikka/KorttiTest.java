

package blackjack.logiikka;

import blackjack.logiikka.Kortti;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class KorttiTest {
    
    
    @Test
    public void korttiLuodaanOikein() {
        Kortti card = new Kortti(4,1);
        assertEquals("HERTTA A", card.toString());
    }
    
    @Test
    public void korttiLuodaanOikein2() {
        Kortti card = new Kortti(2,13);
        assertEquals("RISTI K", card.toString());
    }
    
    @Test
    public void kuvanArvo10() {
        Kortti card = new Kortti(2,11);
        int arvo = card.bjArvo();
        assertEquals(10, arvo);
    }
    
    @Test 
    public void assanArvo11() {
        Kortti card = new Kortti(2,1);
        int arvo = card.bjArvo();
        assertEquals(11, arvo);
    }
}
