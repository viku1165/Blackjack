
package blackjack.blackjack;

import java.util.Stack;
import java.util.Collections;

public class Pakka {
    Stack<Kortti> pakka;
    
    public Pakka() {
        pakka = new Stack<Kortti>();
        for (int i = 1; i < 14; i++) {
            for (int j = 1; j < 5; j++) {
                pakka.push(new Kortti(j,i));
            }
        }
        this.sekoita();
    }
    
    public Kortti nosta() {        
        Kortti nosto = pakka.pop();
        return nosto;
    }
    
    public void sekoita() {
        Collections.shuffle(pakka);
    }
    
    
    // Testaamisen helpottamiseksi
    public Stack getStack() {
        return pakka;
    }
    
    //turha?
    public boolean tyhja() {
        return pakka.empty();
    }
    
    public int koko() {
        return pakka.size();
    }
    
    public void yhdista(Pakka toinen) {
        while(!toinen.tyhja()) {
            Kortti k = toinen.nosta();
            pakka.push(k);
        }
        sekoita();
    }
    
}
