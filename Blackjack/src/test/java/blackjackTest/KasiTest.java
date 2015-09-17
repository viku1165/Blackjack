

package blackjackTest;

import java.util.Random;
import blackjack.blackjack.Pakka;
import java.util.ArrayList;
import blackjack.blackjack.Kortti;
import blackjack.blackjack.Kasi;
import blackjack.blackjack.Maa;
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
        ArrayList kortit = kasi.getCards();
        int koko = kortit.size();
        assertEquals(0, koko);
    }
    
    @Test
    public void kortinJakoToimii() {
        Kortti aceOfSpades = new Kortti(3,1);
        kasi.deal(aceOfSpades);
        assertEquals("PATA A", kasi.toString());
    }
    
    @Test
    public void kortinJakoPakastaToimii() {
        Pakka deck = new Pakka();
        kasi.deal(deck);
        ArrayList kortit = kasi.getCards();
        int koko = kortit.size();
        assertEquals(1, koko);
 
    }
    
    @Test
    public void piilokorttiOnPiilossa() {
        Kortti eka = new Kortti(3,2);
        Kortti muu = new Kortti(3, 8);
        kasi.deal(eka);
        kasi.deal(muu);
        String str = kasi.toStringBlind();
        assertEquals("PATA 2 **", str);
    }
    
    @Test
    public void korttienArvonLaskuOikein() {
        Kortti eka = new Kortti(3,2);
        Kortti muu = new Kortti(3, 8);
        kasi.deal(muu);
        kasi.deal(eka);
        int arvo = kasi.getValue();
        assertEquals(10, arvo);
    }
    

    
    @Test
    public void kadenArvoOikeinAssallaAlle21() {
        Kortti eka = new Kortti(3,2);
        Kortti assa = new Kortti(3,1);
        kasi.deal(assa);
        kasi.deal(eka);
        int arvo = kasi.getValue();
        assertEquals(13, arvo);
    }

    @Test
    public void kadenArvoOikeinAssallaYli21Assia1() {
        Kortti eka = new Kortti(3,6);
        Kortti toka = new Kortti(1,5);
        Kortti assa = new Kortti(3,1);
        kasi.deal(assa);
        kasi.deal(eka);
        kasi.deal(toka);
        int arvo = kasi.getValue();
        assertEquals(12, arvo);
    }
    
    @Test
    public void kadenArvoOikeinAssallaYli21Assia2() {
        Kortti eka = new Kortti(3,5);
        Kortti toka = new Kortti(1,5);
        Kortti assa = new Kortti(3,1);
        Kortti assa2 = new Kortti(3,1);
        kasi.deal(assa);
        kasi.deal(eka);
        kasi.deal(toka);
        kasi.deal(assa2);
        int arvo = kasi.getValue();
        assertEquals(12, arvo);
    }
    
}
