

package blackjack.blackjack;

import java.util.Scanner;


public class Tekstikayttoliittyma {
    private Blackjack peli;
    private Scanner scan;
    
    public Tekstikayttoliittyma(Blackjack bj) {
        peli = bj;
        scan = new Scanner(System.in);
    }
    
    public void pelaa() {
        while(true) {
            System.out.println("Voitot: " + peli.getVoitot());
            System.out.println("Aseta Panos");
            double panos = Double.parseDouble(scan.nextLine());
            peli.setPanos(panos);
            peli.alkujako();            
            
            while (peli.kasiKesken()) {                
                tulostaKadet();
                kysy();
            }
            String viesti = peli.resolve();
            tulostaKadet();
            System.out.println(viesti);
            System.out.println("jatketaanko? k/e");
            String vs = scan.nextLine();
            if (vs.equals("e")) {
                break;
            }
        }    
    }
    
    public void tulostaKadet() {
        System.out.println("Jakaja:");
        if(peli.kasiKesken()) {
            System.out.println(peli.getJakajanKasi().toStringBlind());
        } else {
            System.out.println(peli.getJakajanKasi().toString());
        }       
        System.out.println("summa " + peli.getJakajanKasi().getValue());
        System.out.println("Pelaaja:");
        System.out.println(peli.getPelaajanKasi());
        System.out.println("summa " + peli.getPelaajanKasi().getValue());
    }
    
    public void kysy() {
        System.out.println("Hit, Stay or Double down");
        String komento = scan.nextLine();
        if (komento.equalsIgnoreCase("hit") || komento.equalsIgnoreCase("h")) {
            peli.hit();
        } else if (komento.equalsIgnoreCase("stay") || komento.equalsIgnoreCase("s")) {
            peli.stay();
        } else if (komento.equalsIgnoreCase("Double") || komento.equalsIgnoreCase("d")) {
            peli.tuplaa();
        } else {
            System.out.println("Väärä komento");
            kysy();
        }
    }
    
}
