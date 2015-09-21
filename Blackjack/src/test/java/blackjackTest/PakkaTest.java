
package blackjackTest;

import java.util.Stack;
import blackjack.blackjack.Maa;
import blackjack.blackjack.Kortti;
import blackjack.blackjack.Pakka;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PakkaTest {
    
    Pakka deck;
    
    @Before
    public void setUp() {
        deck = new Pakka();
    }
    
    @Test
    public void pakassa52Korttia() {
        Stack pino = deck.getStack();
        int koko = pino.size();
        assertEquals(52, koko);
    }
    
    @Test
    public void maatLuodaanOikein() {
        int ruutuja = 0;
        int risteja = 0;
        int patoja = 0;
        int herttoja = 0;
        
        for (int i = 0; i < 52; i++) {
            Kortti card = deck.nosta();
            if (card.getMaa() == Maa.RUUTU) {
                ruutuja += 1;
            } else if (card.getMaa() == Maa.RISTI) {
                risteja += 1;
            } else if (card.getMaa() == Maa.PATA) {
                patoja += 1;
            } else if (card.getMaa() == Maa.HERTTA) {
                herttoja += 1;
            }            
        }
        
        assertEquals(13, ruutuja);
        assertEquals(13, risteja);
        assertEquals(13, patoja);
        assertEquals(13, herttoja);
    }
    
    @Test
    public void arvotLuodaanOikein() {
        int[] taul = new int[13];
        
        for (int i = 0; i < 52; i++) {
            Kortti card = deck.nosta();
            int arvo = card.getArvo();
            taul[arvo-1] +=1;
        }
        
        int[] exp = {4,4,4,4,4,4,4,4,4,4,4,4,4};
        assertArrayEquals(exp, taul);
    }
    
    @Test
    public void sekoitusToimii() {
        boolean ok = false;
        for (int i = 0; i < 52; i++) {
            Kortti card = deck.nosta();
            if (card.getArvo() != i%13) {
                ok = true;
                break;
            }
            if (i < 13 && card.getMaa() != Maa.RUUTU) {
                ok = true;
                break;
            }
            if (i >= 13 && i < 26 && card.getMaa() != Maa.RISTI) {
                ok = true;
                break;
            }
            if (i >= 26 && i < 39 && card.getMaa() != Maa.RISTI) {
                ok = true;
                break;
            }
            if (i >= 39 && card.getMaa() != Maa.RISTI) {
                ok = true;
                break;
            }
        }
        assertTrue(ok);
    }
    
    @Test
    public void tyhjaToimii1() {        
        assertTrue(!deck.tyhja());
    }
    
    @Test
    public void tyhjaToimii2() {
        for(int i = 0; i < 52; i++) {
            deck.nosta();
        }
        assertTrue(deck.tyhja());
    }
    
    @Test
    public void yhdistaminenToimii() {
        Pakka deck2 = new Pakka();
        deck.yhdista(deck2);
        int i = 0;
        while(!deck.tyhja()) {
            deck.nosta();
            i++;
        }
        assertEquals(104, i);
    }
}
