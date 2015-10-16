
package blackjack.logiikka;


public class Saannot {
    
    private int pakkoja;
    private boolean jakajaVoittaaTasurit;
    
    public Saannot() {
        pakkoja = 6;
        jakajaVoittaaTasurit = false;
    }
    
    public Saannot(int pakkoja, boolean tasapelitJakajalle) {
        this.pakkoja = pakkoja;
        jakajaVoittaaTasurit = tasapelitJakajalle;
    }
    
    public int getPakkoja() {
        return pakkoja;
    }
    
    public boolean jakajaVoittaaTasapelit() {
        return jakajaVoittaaTasurit;
    }
    

    
}
