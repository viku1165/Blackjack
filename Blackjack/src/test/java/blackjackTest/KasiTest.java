

package blackjackTest;

import java.util.ArrayList;
import blackjack.blackjack.Kortti;
import blackjack.blackjack.Kasi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KasiTest {
    
    Kasi kasi;
    
    @Before
    public void setUp() {
        kasi = new Kasi();
    }
    
    @Test
    public void kasiLuodaanTyhjana() {
        ArrayList kortit = kasi.getOpen();
        int koko = kortit.size();
        Kortti sokea = kasi.getBlind();
        assertEquals(0, koko);
        assertEquals(null, sokea);
    }
    
    @Test
    public void piilokortinJakoToimii() {
        Kortti aceOfSpades = new Kortti(3,1);
        kasi.dealBlind(aceOfSpades);
        Kortti kadessa = kasi.getBlind();
        assertEquals("PATA ässä", kadessa.toString());
    }
    
    @Test
    public void avokorttienJakoToimii() {
        Kortti aceOfSpades = new Kortti(3,1);
        Kortti muu = new Kortti(3, 8);
        kasi.dealOpen(muu);
        kasi.dealOpen(aceOfSpades);
        ArrayList kadessa = kasi.getOpen();
        assertEquals(2, kadessa.size());
    }
    
    @Test
    public void avokorttienArvonLaskuOikein() {
        Kortti eka = new Kortti(3,2);
        Kortti muu = new Kortti(3, 8);
        kasi.dealOpen(muu);
        kasi.dealOpen(eka);
        int arvo = kasi.openValue();
        assertEquals(10, arvo);
    }
    
    @Test
    public void kokoKadenArvooikein() {
        Kortti eka = new Kortti(3,2);
        Kortti toka = new Kortti(1,5);
        Kortti muu = new Kortti(3, 8);
        kasi.dealOpen(muu);
        kasi.dealOpen(eka);
        kasi.dealBlind(toka);
        int arvo = kasi.blindValue();
        assertEquals(15, arvo);
    }
    
    @Test
    public void kokoKadenArvooikeinEiBlindia() {
        Kortti eka = new Kortti(3,2);
        Kortti muu = new Kortti(3, 8);
        kasi.dealOpen(muu);
        kasi.dealOpen(eka);
        int arvo = kasi.blindValue();
        assertEquals(10, arvo);
    }

}
