import java.util.ArrayList;
import java.util.List;

public class Rungtynes {
    private Komanda pirmaKomanda;
    private Komanda antraKomanda;
    private Teisejas teisėjas = new Teisejas();
    private int pirmosKomandosTaskuSkaicius = 0;
    private int antrosKomandosTaskuSkaicius = 0;
    private Arena arena;
    private Taisykles taisykles;

    public Rungtynes(Komanda pirmaKomanda, Komanda antraKomanda, Teisejas teisėjas, Arena arena, Taisykles taisykles) {
        this.pirmaKomanda = pirmaKomanda;
        this.antraKomanda = antraKomanda;
        this.teisėjas = teisėjas;
        this.arena = arena;
        this.taisykles = taisykles;
    }

    public void setPirmosKomandosTaskuSkaicius(int pirmosKomandosTaskuSkaicius) {
        this.pirmosKomandosTaskuSkaicius = pirmosKomandosTaskuSkaicius;
    }

    public void setAntrosKomandosTaskuSkaicius(int antrosKomandosTaskuSkaicius) {
        this.antrosKomandosTaskuSkaicius = antrosKomandosTaskuSkaicius;
    }

    @Override
    public String toString() {
        if(pirmosKomandosTaskuSkaicius > antrosKomandosTaskuSkaicius){
            return pirmaKomanda + " " + pirmosKomandosTaskuSkaicius + " - "
                    + antrosKomandosTaskuSkaicius + " " + antraKomanda + "\nLaimi " + pirmaKomanda;
        } else {
            return pirmaKomanda + " " + pirmosKomandosTaskuSkaicius + " - "
                    + antrosKomandosTaskuSkaicius + " " + antraKomanda + "\nLaimi " + antraKomanda;
        }
    }
}
