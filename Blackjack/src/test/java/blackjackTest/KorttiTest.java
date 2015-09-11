

package blackjackTest;

import blackjack.blackjack.Kortti;
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
        assertEquals("HERTTA ässä", card.toString());
    }
    
    @Test
    public void korttiLuodaanOikein2() {
        Kortti card = new Kortti(2,13);
        assertEquals("RISTI 13", card.toString());
    }
    
}
