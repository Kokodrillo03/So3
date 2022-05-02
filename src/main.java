import java.util.ArrayList;

public class main {
    public static void main(String[] args){
        ArrayList<strona> strony = ciągi.generuj_ciag(1000,10);
        System.out.println(Algorytmy.FIFO(strony,3));
        System.out.println(Algorytmy.OPT(strony,3));
        System.out.println(Algorytmy.RAND(strony,3));
        System.out.println(Algorytmy.LRU(strony,3));
        System.out.println(Algorytmy.AprLRU(strony,3));
    }
}
