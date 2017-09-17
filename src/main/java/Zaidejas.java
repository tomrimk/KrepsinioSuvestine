public class Zaidejas {
    private String vardas;
    private String pavarde;
    private double ugis;
    private int amzius;
    private int numeris;

    public Zaidejas(String vardas, String pavarde, double ugis, int amzius, int numeris) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.ugis = ugis;
        this.amzius = amzius;
        this.numeris = numeris;
    }

    public int getNumeris() {
        return numeris;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    @Override
    public String toString() {
        return "Vardas='" + vardas + '\'' +
                ", Pavarde='" + pavarde + '\'' +
                ", Ūgis=" + ugis +
                ", AmŽius=" + amzius +
                ", Žaidėjo numeris=" + numeris;
    }
}
