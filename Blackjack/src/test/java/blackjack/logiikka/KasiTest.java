

package blackjack.logiikka;

import blackjack.logiikka.Pakka;
import java.util.ArrayList;
import blackjack.logiikka.Kortti;
import blackjack.logiikka.Kasi;
import blackjack.logiikka.Maa;
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
        kasi.jaa(aceOfSpades);
        assertEquals("PATA A", kasi.toString());
    }
    
    @Test
    public void kortinJakoPakastaToimii() {
        Pakka deck = new Pakka();
        kasi.jaa(deck);
        ArrayList kortit = kasi.getCards();
        int koko = kortit.size();
        assertEquals(1, koko);
 
    }
    
    @Test
    public void piilokorttiOnPiilossa() {
        Kortti eka = new Kortti(3,2);
        Kortti muu = new Kortti(3, 8);
        kasi.jaa(eka);
        kasi.jaa(muu);
        String str = kasi.toStringBlind();
        assertEquals("PATA 2 **", str);
    }
    
    @Test
    public void korttienArvonLaskuOikein() {
        Kortti eka = new Kortti(3,2);
        Kortti muu = new Kortti(3, 8);
        kasi.jaa(muu);
        kasi.jaa(eka);
        int arvo = kasi.getValue();
        assertEquals(10, arvo);
    }
    

    
    @Test
    public void kadenArvoOikeinAssallaAlle21() {
        Kortti eka = new Kortti(3,2);
        Kortti assa = new Kortti(3,1);
        kasi.jaa(assa);
        kasi.jaa(eka);
        int arvo = kasi.getValue();
        assertEquals(13, arvo);
    }

    @Test
    public void kadenArvoOikeinAssallaYli21Assia1() {
        Kortti eka = new Kortti(3,6);
        Kortti toka = new Kortti(1,5);
        Kortti assa = new Kortti(3,1);
        kasi.jaa(assa);
        kasi.jaa(eka);
        kasi.jaa(toka);
        int arvo = kasi.getValue();
        assertEquals(12, arvo);
    }
    
    @Test
    public void kadenArvoOikeinAssallaYli21Assia2() {
        Kortti eka = new Kortti(3,5);
        Kortti toka = new Kortti(1,5);
        Kortti assa = new Kortti(3,1);
        Kortti assa2 = new Kortti(3,1);
        kasi.jaa(assa);
        kasi.jaa(eka);
        kasi.jaa(toka);
        kasi.jaa(assa2);
        int arvo = kasi.getValue();
        assertEquals(12, arvo);
    }
    
}