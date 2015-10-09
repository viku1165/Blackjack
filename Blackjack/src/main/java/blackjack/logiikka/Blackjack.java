package blackjack.logiikka;

import java.util.ArrayList;

/**
 * Mallintaa Blackjack-peliä ja pitää kirjaa pelitilanteesta
 * 
 */
public class Blackjack {
    private Pakka deck;
    private Kasi jakaja;
    private Kasi pelaaja;
    private Kasi split;
    private int voitot;
    private boolean valmisAlkujakoon;
    private boolean splitattu;
    private int kierroksiaPelattu;
    
    /**
     * Luo Blackjack-pelin, jossa haluttu määrä pakkoja
     * @param pakkoja pelissä käytettävien pakkojen määrä
     */
    public Blackjack(int pakkoja) {
        deck = new Pakka();
        for (int i = 1; i < pakkoja; i++) {
            Pakka uusi = new Pakka();
            deck.yhdista(uusi);
        }
        
        jakaja = new Kasi();
        pelaaja = new Kasi();
        voitot = 0;
        valmisAlkujakoon = false;
        splitattu = false;
        kierroksiaPelattu = 0;
    }
    
    public void setPanos(int x) {
        pelaaja.setPanos(x);
    }
    
    public Kasi getJakajanKasi() {
        return jakaja;
    }
    
    public Kasi getPelaajanKasi() {
        return pelaaja;
    }
    
    /**
     * Suorittaa käden alkujaon, eli jakaa pelaajalle ja jakajalle kaksi korttia
     */
    public void alkujako() {
        pelaaja.jaa(deck);
        jakaja.jaa(deck);
        pelaaja.jaa(deck);
        jakaja.jaa(deck);
    }
       
    /**
     * Jakaa pelaajalle yhdenkortin lisää. Jos käden arvo ylittää tämän jälkeen
     * 21, on käsi pelaajan osalta kesken.
     */
    public void hit() {
        if(!pelaaja.valmis()) {
            pelaaja.jaa(deck);
            if(pelaaja.bust()){
                pelaaja.valmista();
            }
        } else if (splitattu) {
            if(!split.valmis()) {
                split.jaa(deck);
                if (split.bust()) {
                    split.valmista();
                }
            }
        }
    }
    
    /**
     * Lopettaa käden pelaajan osalta, kun pelaaja ei halua lisäkortteja.
     */
    public void stand() {
        if (!pelaaja.valmis()) {
            pelaaja.valmista(); 
        } else if (splitattu) {
            split.valmista();
        }
             
    }
    
    /**
     * Tuplaa käden panoksen, minkä jälkeen pelaajalle jaetaan vielä yksi kortti.
     * Käytettävissä vain pelaajan ensimmäisellä vuorolla.
     */
    public void tuplaa() {
        if (pelaaja.ekaVuoro() && !pelaaja.valmis()){
            pelaaja.tuplaaPanos();
            pelaaja.jaa(deck);
            pelaaja.valmista();
        } else if (splitattu) {
            if(split.ekaVuoro() && !split.valmis()) {
                split.tuplaaPanos();
                split.jaa(deck);
                split.valmista();
            }
        }
    }
    
    /**
     * Mikäli kädessä on pari, jakaa kortit erillisiin käsiin ja jakaa kumpaankin kortin
     */
    public void split() {
        if (pelaaja.ekaVuoro() && !splitattu) {
            ArrayList<Kortti> kortit = pelaaja.getCards();
            Kortti kortti1 = kortit.get(0);
            Kortti kortti2 = kortit.get(1);
            if (kortti1.getArvo() == kortti2.getArvo()) {
                pelaaja = new Kasi();
                pelaaja.jaa(kortti1);
                pelaaja.jaa(deck);
                split = new Kasi();
                split.jaa(kortti2);
                split.jaa(deck);

                splitattu = true;
            }
        }    
    }
    
    /**
     * Jakaa jakajan käteen kortin, jos jakajan käden arvo alle 17.
     * @return boolean jaettiinko kortti
     */
    public boolean jaaJakajalle() {
        if (jakaja.getValue() < 17) {
            jakaja.jaa(deck);
            return true;
        }
        return false;
    }
    
    /**
     * Määrittää pelin käden voittajan. Metodin suorittamisen jälkeen käsi on loppu
     * ja voidaan suorittaa seuraava alkujako.
     * @param kasitellaanSplit Jos true, niin metodi käsittelee split-käden, muutoin pelaajan "ensimmäisen" käden
     * @return String viesti, joka kertoo käden voittajan
     */
    public String resolve(boolean kasitellaanSplit) {
        if (kasitellaanSplit) {
            valmisAlkujakoon = true;
        } else if (!splitattu) {
            valmisAlkujakoon = true;
        }
        
        Kasi kasiteltava = pelaaja;
        if (kasitellaanSplit) {
            kasiteltava = split;
        }
        
        if(kasiteltava.getValue() > 21) {
            if (jakaja.getValue() > 21) {
                return "tasapeli";
            } else {
                voitot -= kasiteltava.getPanos();
                return "jakaja voittaa";
            }
        }
        if (jakaja.getValue() > 21) {
            voitot += kasiteltava.getPanos();
            return "pelaaja voittaa";
        }
        if (jakaja.getValue() > kasiteltava.getValue() ) {
            voitot -= kasiteltava.getPanos();
            return "jakaja voittaa";
        }
        if (jakaja.getValue() == kasiteltava.getValue() ) {
            return "tasapeli";
        }
        voitot += kasiteltava.getPanos();
        return "pelaaja voittaa";
    }
    
    //käsien setterit resolve():n testaamiseen
    public void setPelaajanKasi(Kasi kasi) {
        pelaaja = kasi;
    }
    
    public void setJakajanKasi(Kasi kasi) {
        jakaja = kasi;
    }
    
    
    /**
     * Aloittaa uuden käden, eli tyhjää kädet ja nollaa pelitilannetta kuvaavat
     * boolean-muuttujat kasiKesken, ekaVuoro ja valmisAlkuJakoon.
     */
    public void tyhjaaKadet() {
        jakaja = new Kasi();
        pelaaja = new Kasi();
        valmisAlkujakoon = false;
        splitattu = false;
    }
    
    public int getVoitot() {
        return voitot;
    }

    
    @Override
    public String toString() {
        if (!pelaaja.tyhja()) {
            StringBuilder viesti = new StringBuilder("Jakaja:\n");
            if(!pelaaja.valmis()) {
                viesti.append(jakaja.toStringBlind() + "\n");
            } else {
                viesti.append(jakaja.toString() + "\n");
            }       
    //        System.out.println("summa " + peli.getJakajanKasi().getValue());
            viesti.append("Pelaaja:\n");
//            viesti.append("Panos " + pelaaja.getPanos() + "\n");
            viesti.append("panos " + pelaaja.getPanos() + "\n");
            viesti.append(pelaaja);
    //        System.out.println("summa " + peli.getPelaajanKasi().getValue());
            if(splitattu) {
                viesti.append("Panos " + split.getPanos() + "\n");
                viesti.append(split);
            }
            
            return viesti.toString();
        }
        return "";
    }
    
    
    /**
     * Kertoo, onko pelissä jaettu kortteja, eli ovatko pelin kädet tyhjiä
     * @return boolean ovatko kädet tyhjät
     */
    public boolean kadetTyhjat() {
        return pelaaja.tyhja();
    }
    
    public boolean valmisAlkujakoon() {
        return valmisAlkujakoon;
    }
    
    public void setValmisAlkujakoon(boolean b) {
        valmisAlkujakoon = b;
    }
    
    public boolean ykkoskasiValmis() {
        return pelaaja.valmis();
    }
    
    public boolean splitKasiValmis() {
        return split.valmis();
    }
    
    public boolean splitattu() {
        return splitattu;
    }
    
}
