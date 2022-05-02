import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ciągi {

    public static ArrayList<strona> generuj_ciag(int ilosc, int rozmiar_pamieci){
        ArrayList<strona> stronki = new ArrayList<>();
        Random random = new Random();
        stronki.add(new strona(random.nextInt(1,rozmiar_pamieci+1)));
        for(int i = 1; i < ilosc; i++){
            int a = random.nextInt(0,10);
            if(a == 0){
                stronki.add(new strona(random.nextInt(1,rozmiar_pamieci+1)));
            }else{
                stronki.add(new strona(random.nextInt(Math.max(stronki.get(i-1).getAdres()-Math.max(2,rozmiar_pamieci/10),1),Math.min(stronki.get(i-1).getAdres()+Math.max(2,rozmiar_pamieci/10),rozmiar_pamieci+1))));
            }
        }
        return stronki;
    }
}
