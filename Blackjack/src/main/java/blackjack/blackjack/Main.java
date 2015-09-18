

package blackjack.blackjack;


public class Main {


    public static void main(String[] args) {
        // TODO code application logic here
        Blackjack bj = new Blackjack(6);
        Tekstikayttoliittyma tkl = new Tekstikayttoliittyma(bj);
        tkl.pelaa();
    }
    
}
