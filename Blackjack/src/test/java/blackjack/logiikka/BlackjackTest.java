

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
    
    @Test
    public void resolveAntaaTasapelinKunMolemmatYli21() {
        Kortti kymppi1 = new Kortti(1, 10);
        Kortti kymppi2 = new Kortti(2,10);
        Kortti kax = new Kortti(1,2);
        
        Kasi pelaaja = new Kasi();
        Kasi jakaja = new Kasi();
        
        pelaaja.jaa(kymppi1);
        pelaaja.jaa(kymppi2);
        pelaaja.jaa(kax);
        jakaja.jaa(kymppi1);
        jakaja.jaa(kymppi2);
        jakaja.jaa(kax);
        
        bj.setJakajanKasi(jakaja);
        bj.setPelaajanKasi(pelaaja);
        
        assertEquals("tasapeli", bj.resolve());
    }
    
    @Test
    public void resolveAntaaTasatilanteessaTasapelin() {
        Kortti kymppi1 = new Kortti(1, 10);
        Kortti kymppi2 = new Kortti(2,10);
        
        Kasi pelaaja = new Kasi();
        Kasi jakaja = new Kasi();
        
        pelaaja.jaa(kymppi1);
        pelaaja.jaa(kymppi2);
        jakaja.jaa(kymppi1);
        jakaja.jaa(kymppi2);
        
        bj.setJakajanKasi(jakaja);
        bj.setPelaajanKasi(pelaaja);
        
        assertEquals("tasapeli", bj.resolve());
    }
    
    @Test
    public void resolvePelaajaVoittaaKunJakajaYli21() {
        Kortti kymppi1 = new Kortti(1, 10);
        Kortti kymppi2 = new Kortti(2,10);
        Kortti kax = new Kortti(1,2);
        
        Kasi pelaaja = new Kasi();
        Kasi jakaja = new Kasi();
        
        pelaaja.jaa(kymppi1);
        pelaaja.jaa(kymppi2);
        jakaja.jaa(kymppi1);
        jakaja.jaa(kymppi2);
        jakaja.jaa(kax);
        
        bj.setJakajanKasi(jakaja);
        bj.setPelaajanKasi(pelaaja);
        
        assertEquals("pelaaja voittaa", bj.resolve());
    }
    
    @Test
    public void resolvePelaajaLahempana21() {
        Kortti kymppi1 = new Kortti(1, 10);
        Kortti kymppi2 = new Kortti(2,10);
        Kortti ysi = new Kortti(3,9);
        
        Kasi pelaaja = new Kasi();
        Kasi jakaja = new Kasi();
        
        pelaaja.jaa(kymppi1);
        pelaaja.jaa(kymppi2);
        jakaja.jaa(kymppi1);
        jakaja.jaa(ysi);
        
        bj.setJakajanKasi(jakaja);
        bj.setPelaajanKasi(pelaaja);
        
        assertEquals("pelaaja voittaa", bj.resolve());
    }
    
    @Test
    public void resolveJakajaVoittaaKunLahempana21() {
        Kortti kymppi1 = new Kortti(1, 10);
        Kortti kymppi2 = new Kortti(2,10);
        Kortti ysi = new Kortti(3,9);
        
        Kasi pelaaja = new Kasi();
        Kasi jakaja = new Kasi();
        
        pelaaja.jaa(kymppi1);
        pelaaja.jaa(ysi);
        jakaja.jaa(kymppi1);
        jakaja.jaa(kymppi2);
        
        bj.setJakajanKasi(jakaja);
        bj.setPelaajanKasi(pelaaja);
        
        assertEquals("jakaja voittaa", bj.resolve());
    }
    
    //Testaamattomia resolve-tapauksia: (koska toteutustapa voi muuttua)
    //  -pelaaja bustaa, jakaja ei
}
