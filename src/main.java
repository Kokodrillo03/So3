import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj dlugosc ciagu testowego");
        int dlug = Integer.parseInt(scan.nextLine());
        System.out.println("Podaj romiar pamieci");
        int pam = Integer.parseInt(scan.nextLine());
        System.out.println("Podaj ilość ramek");
        int ramki = Integer.parseInt(scan.nextLine());
        ArrayList<strona> strony = ciągi.generuj_ciag(dlug,pam);
        System.out.println("Optymalna ilosc bledow strony wynosi: "+Algorytmy.OPT(strony,ramki));
        System.out.println("Ilość błędów storny dla algorytmu FIFO wynosi: "+Algorytmy.FIFO(strony,ramki));
        System.out.println("Ilość błędów storny dla algorytmu RAND wynosi: "+Algorytmy.RAND(strony,ramki));
        System.out.println("Ilość błędów storny dla algorytmu LRU wynosi: "+Algorytmy.LRU(strony,ramki));
        System.out.println("Ilość błędów storny dla algorytmu optymalizowanego LRU wynosi: "+Algorytmy.AprLRU(strony,ramki));
    }
}
