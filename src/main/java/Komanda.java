import java.util.ArrayList;
import java.util.List;

public class Komanda {
    private List<Zaidejas> zaidejai = new ArrayList<>();
    private String pavadinimas;
    private Treneris treneris;

    public Komanda(String pavadinimas, List<Zaidejas> zaidejai, Treneris treneris) {
        this.zaidejai = zaidejai;
        this.pavadinimas = pavadinimas;
        this.treneris = treneris;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public List<Zaidejas> getZaidejai() {
        return zaidejai;
    }

    public Treneris getTreneris() {
        return treneris;
    }
}
