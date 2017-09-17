public class Teisejas {
    private String vardas;
    private String pavarde;
    private int amzius;
    private String tautybe;

    public Teisejas(){

    }

    public Teisejas(String vardas, String pavarde, int amzius, String tautybe) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.amzius = amzius;
        this.tautybe = tautybe;
    }

    @Override
    public String toString() {
        return "Vardas='" + vardas + '\'' +
                ", Pavarde='" + pavarde + '\'' +
                ", Amžius=" + amzius +
                ", Tautybė='" + tautybe + '\'';
    }
}