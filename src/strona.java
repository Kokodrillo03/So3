public class strona {

    private int adres;
    private int czas_bez_uz;
    private boolean ALRU;

    public strona (int adres){
        this.adres = adres;
        this.czas_bez_uz = 0;
        ALRU = false;
    }

    public int getAdres() {
        return adres;
    }

    public void setAdres(int adres) {
        this.adres = adres;
    }

    public int getCzas_bez_uz() {
        return czas_bez_uz;
    }

    public void setCzas_bez_uz(int czas_bez_uz) {
        this.czas_bez_uz = czas_bez_uz;
    }

    public boolean isALRU() {
        return ALRU;
    }

    public void setALRU(boolean ALRU) {
        this.ALRU = ALRU;
    }

    @Override
    public String toString() {
        return String.valueOf(adres);
    }
}
