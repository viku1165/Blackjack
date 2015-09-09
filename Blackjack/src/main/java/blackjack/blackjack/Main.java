

package blackjack.blackjack;


public class Main {


    public static void main(String[] args) {
        // TODO code application logic here
        Pakka pakka = new Pakka();
        Kortti nostettu = pakka.nosta();
        System.out.println(nostettu.toString());
        nostettu = pakka.nosta();
        System.out.println(nostettu.toString());
        nostettu = pakka.nosta();
        System.out.println(nostettu.toString());
    }
    
}
