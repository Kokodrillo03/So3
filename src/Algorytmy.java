import java.util.ArrayList;
import java.util.Random;

public class Algorytmy {

    static Random random = new Random();

    public static int FIFO(ArrayList<strona> strony, int ilosc_ramek){
        ArrayList<strona> zapytania = new ArrayList<>(strony);
        strona[] ramki = new strona[ilosc_ramek];
        int bledy = 0;
        for(strona s : zapytania){
            boolean flag = false;
            for(int i = 0; i < ramki.length; i++){
                if(ramki[i] == null) {
                    flag = true;
                    ramki[i]=s;
                    bledy ++;
                    break;
                }else if(ramki[i].getAdres() == s.getAdres()){
                    flag=true;
                }
            }
            if(!flag){
                bledy ++;
                int maksind = 0;
                for(int i = 0; i < ramki.length; i++){
                    if(ramki[i]!=null){
                        if(ramki[i].getCzas_bez_uz()>ramki[maksind].getCzas_bez_uz())maksind = i;
                    }
                }
                ramki[maksind]=s;
            }
            for(int i = 0; i < ramki.length; i ++){
                if(ramki[i]!=null)ramki[i].setCzas_bez_uz(ramki[i].getCzas_bez_uz()+1);
            }
        }
        return bledy;
    }

    public static int OPT(ArrayList<strona> strony, int ilosc_ramek){
        ArrayList<strona> zapytania = new ArrayList<>(strony);
        strona[] ramki = new strona[ilosc_ramek];
        int bledy = 0;
        for(int j = 0; j < zapytania.size(); j++){
            boolean flag = false;
            for(int i = 0; i < ramki.length; i++){
                if(ramki[i] == null) {
                    flag = true;
                    ramki[i]=zapytania.get(j);
                    bledy ++;
                    break;
                }else if(ramki[i].getAdres() == zapytania.get(j).getAdres()){
                    flag=true;
                }
            }
            if(!flag){
                bledy ++;
                int maksind = 0;
                int maks = 0;
                for(int i =0; i < ramki.length;i++){
                    int temp = 0;
                    if(ramki[i]!=null){
                        for(int m = j+1; m < zapytania.size(); m++){
                            if(zapytania.get(m).getAdres()==ramki[i].getAdres())break;
                            temp++;
                        }
                        if(temp>maks){
                            maks=temp;
                            maksind = i;
                        }
                    }
                }
                ramki[maksind] = zapytania.get(j);
            }
            for(int i = 0; i < ramki.length; i ++){
                if(ramki[i]!=null)ramki[i].setCzas_bez_uz(ramki[i].getCzas_bez_uz()+1);
            }
        }
        return bledy;
    }
    public static int RAND(ArrayList<strona> strony, int ilosc_ramek){
        ArrayList<strona> zapytania = new ArrayList<>(strony);
        strona[] ramki = new strona[ilosc_ramek];
        int bledy = 0;
        for(strona s : zapytania){
            boolean flag = false;
            for(int i = 0; i < ramki.length; i++){
                if(ramki[i] == null) {
                    flag = true;
                    ramki[i]=s;
                    bledy ++;
                    break;
                }else if(ramki[i].getAdres() == s.getAdres()){
                    flag=true;
                }
            }
            if(!flag){
                bledy ++;
                ramki[random.nextInt(0,ramki.length)]=s;
            }
            for(int i = 0; i < ramki.length; i ++){
                if(ramki[i]!=null)ramki[i].setCzas_bez_uz(ramki[i].getCzas_bez_uz()+1);
            }
        }
        return bledy;
    }
    public static int LRU(ArrayList<strona> strony, int ilosc_ramek){
        ArrayList<strona> zapytania = new ArrayList<>(strony);
        strona[] ramki = new strona[ilosc_ramek];
        int bledy = 0;
        for(strona s : zapytania){
            boolean flag = false;
            for(int i = 0; i < ramki.length; i++){
                if(ramki[i] == null) {
                    flag = true;
                    ramki[i]=s;
                    bledy ++;
                    break;
                }else if(ramki[i].getAdres() == s.getAdres()){
                    flag=true;
                    ramki[i].setCzas_bez_uz(0);
                }
            }
            if(!flag){
                bledy ++;
                int maksind = 0;
                for(int i = 0; i < ramki.length; i++){
                    if(ramki[i]!=null){
                        if(ramki[i].getCzas_bez_uz()>ramki[maksind].getCzas_bez_uz())maksind = i;
                    }
                }
                ramki[maksind]=s;
            }
            for(int i = 0; i < ramki.length; i ++){
                if(ramki[i]!=null)ramki[i].setCzas_bez_uz(ramki[i].getCzas_bez_uz()+1);
            }
        }
        return bledy;
    }

    public static int AprLRU(ArrayList<strona> strony, int ilosc_ramek){
        ArrayList<strona> zapytania = new ArrayList<>(strony);
        strona[] ramki = new strona[ilosc_ramek];
        int bledy = 0;
        for(strona s : zapytania){
            boolean flag = false;
            for(int i = 0; i < ramki.length; i++){
                if(ramki[i] == null) {
                    flag = true;
                    ramki[i]=s;
                    bledy ++;
                    break;
                }else if(ramki[i].getAdres() == s.getAdres()){
                    flag=true;
                    ramki[i].setALRU(true);
                }
            }
            if(!flag){
                bledy ++;
                int maksind = 0;
                boolean flagg = false;
                if(ramki[0]!=null&&!ramki[0].isALRU())flagg=true;
                for(int i = 0; i < ramki.length; i++){
                    if(ramki[i]!=null){
                        if(ramki[i].getCzas_bez_uz()>ramki[maksind].getCzas_bez_uz() && !ramki[i].isALRU()){
                            maksind = i;
                            flagg = true;
                        }
                    }
                }
                if(!flagg){
                    for(int i = 0; i < ramki.length; i++){
                        if(ramki[i]!=null){
                            if(ramki[i].getCzas_bez_uz()>ramki[maksind].getCzas_bez_uz()){
                                maksind = i;
                            }
                        }
                    }
                }
                ramki[maksind]=s;
                for(int i = 0; i < ramki.length; i ++){
                    if(ramki[i]!=null)ramki[i].setALRU(false);
                }
            }
            for(int i = 0; i < ramki.length; i ++){
                if(ramki[i]!=null)ramki[i].setCzas_bez_uz(ramki[i].getCzas_bez_uz()+1);
            }
        }
        return bledy;
    }


}
