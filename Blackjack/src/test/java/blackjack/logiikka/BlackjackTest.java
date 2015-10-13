

package blackjack.logiikka;

import blackjack.logiikka.Kasi;
import blackjack.logiikka.Blackjack;
import java.util.ArrayList;
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
        while(bj.getPelaajanKasi().blackjack()) {
            bj.tyhjaaKadet();
            bj.alkujako();
        }
    }
    
    @Test
    public void alkujakoToimii() {
        Kasi pelaaja = bj.getPelaajanKasi();
        Kasi jakaja = bj.getPelaajanKasi();
        assertEquals(2, pelaaja.getCards().size());
        assertEquals(2, jakaja.getCards().size());
    }
    
    @Test
    public void panoksenAsettaminenToimii() {
        bj.setPanos(1);
        int panos = bj.getPelaajanKasi().getPanos();
        assertEquals(1, panos);
    }
    
    @Test
    public void hitJakaaKortin() {
        bj.hit();
        Kasi pelaaja = bj.getPelaajanKasi();
        assertEquals(3, pelaaja.getCards().size());
    }
    
    //Testaa osittain myös Pakka-luokan juttuja
    @Test
    public void pakkaSekoittuuUudelleen() {
        bj = new Blackjack(1);
        Pakka deck = bj.getPakka();
        for (int i = 0; i < 35; i++) {
            deck.nosta();
        }
        bj.alkujako();
        deck = bj.getPakka();
        assertEquals(48, deck.koko());
    }
    
    @Test
    public void hitYli21PysayttaaKaden() {
        while(!bj.getPelaajanKasi().bust()) {
            assertTrue(bj.getPelaajanKasi().getValue() < 22);
            bj.hit();
        }
        assertTrue(bj.getPelaajanKasi().getValue() >= 21);
    }
    
    @Test
    public void standPysayttaaKaden() {
        bj.stand();
        assertTrue(bj.getPelaajanKasi().valmis());
    }
    
    @Test
    public void tuplausPysayttaaKaden() {
        bj.tuplaa();
        assertTrue(bj.getPelaajanKasi().valmis());
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
        int panos = bj.getPelaajanKasi().getPanos();
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
    public void kasienTyhjennyksenJalkeenKasiKesken() {
        bj.tyhjaaKadet();
        assertTrue(!bj.getPelaajanKasi().valmis());
    }
    
    //resolvea
    
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
        
        assertEquals("tasapeli", bj.resolve(false));
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
        
        assertEquals("tasapeli", bj.resolve(false));
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
        
        assertEquals("pelaaja voittaa", bj.resolve(false));
    }
    
    @Test
    public void resolveMaksaaVoitot() {
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
        
        bj.setPanos(1);
        bj.resolve(false);
        
        assertEquals(1, bj.getVoitot(), 0.001);
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
        
        assertEquals("jakaja voittaa", bj.resolve(false));
    }
    
    @Test
    public void resolveVeloittaaTappiot(){
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
        
        bj.setPanos(1);
        bj.resolve(false);
        
        assertEquals(-1, bj.getVoitot(), .001);
    }           
    
    private void jaaPelaajalleBlackjack() {
        Kortti Assa = new Kortti(3,1);
        Kortti kymppi1 = new Kortti(1, 10);
        Kortti kymppi2 = new Kortti(2,10);
        
        Kasi pelaaja = new Kasi();
        Kasi jakaja = new Kasi();
        
        pelaaja.jaa(Assa);
        pelaaja.jaa(kymppi1);
        jakaja.jaa(kymppi1);
        jakaja.jaa(kymppi2);
        
        bj.setJakajanKasi(jakaja);
        bj.setPelaajanKasi(pelaaja);
    }
    
    @Test
    public void resolvePelaajaVoittaaBlackjackilla() {
        jaaPelaajalleBlackjack();
        
        assertEquals("pelaaja voittaa Blackjackilla", bj.resolve(false));
    }
    
    @Test
    public void resolveBlackjackPalauttaa3per2() {
        jaaPelaajalleBlackjack();
        bj.setPanos(2);
        bj.resolve(false);
        assertEquals(3, bj.getVoitot(),0.001);
    }
    //Testaamattomia resolve-tapauksia: (koska toteutustapa voi muuttua)
    //  -pelaaja bustaa, jakaja ei
    
    //splittiä
    
    private void jaaPari() {
        Kortti eka  = new Kortti(1,4);
        Kortti toka = new Kortti(2,4);
        
        Kasi kasi = new Kasi();
        kasi.jaa(eka);
        kasi.jaa(toka);
        bj.setPelaajanKasi(kasi);
    }
    
    @Test
    public void splitLuoUudenKaden() {
        jaaPari();
        
        bj.split();
        Kasi kasi = bj.getSplitKasi();
        
        assertNotNull(kasi);
    }
    
    @Test
    public void splitAsettaaSplitattuTrue() {
        jaaPari();
        
        bj.split();
        
        assertTrue(bj.splitattu());
    }
    
    @Test
    public void splitEiToimiIlmanParia() {
        ArrayList<Kortti> kortit = bj.getPelaajanKasi().getCards();
        while (kortit.get(0).bjArvo() == kortit.get(1).bjArvo()) {
            setUp();
        }
        
        bj.split();
        
        assertTrue(!bj.splitattu());
    }
    
    @Test
    public void splitEiSplittaaEkanVuoronJalkeen() {
        jaaPari();
        bj.hit();
        bj.split();
        assertTrue(!bj.splitattu());
    }
    
    @Test
    public void splitinJalkeenHitEkaanKateen() {
        jaaPari();
        bj.split();
        bj.hit();
        Kasi kasi = bj.getPelaajanKasi();
        assertEquals(3, kasi.getCards().size());
    }
    
    @Test
    public void splitinJalkeenTokaanKateenHit() {
        jaaPari();
        bj.split();
        bj.getPelaajanKasi().valmista();
        bj.hit();
        Kasi kasi = bj.getSplitKasi();
        assertEquals(3, kasi.getCards().size());
    }
    
    @Test 
    public void tuplausTuplaaSplitinPanoksen() {
        jaaPari();
        bj.split();
        bj.getPelaajanKasi().valmista();
        Kasi kasi = bj.getSplitKasi();
        kasi.setPanos(1);
        bj.tuplaa();
        assertEquals(2, kasi.getPanos());
    }
    
}
