import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    public int getPirmosKomandosTaskuSkaicius() {
        return pirmosKomandosTaskuSkaicius;
    }

    public int getAntrosKomandosTaskuSkaicius() {
        return antrosKomandosTaskuSkaicius;
    }

    public void setPirmosKomandosTaskuSkaicius(int pirmosKomandosTaskuSkaicius) {
        this.pirmosKomandosTaskuSkaicius = pirmosKomandosTaskuSkaicius;
    }

    public void setAntrosKomandosTaskuSkaicius(int antrosKomandosTaskuSkaicius) {
        this.antrosKomandosTaskuSkaicius = antrosKomandosTaskuSkaicius;
    }

    public void isNew(){
        File f = new File("C:/Users/Tomas/Desktop/PI15B/JAVA/PirmaUzduotis/rungtyniuLog.txt");
        f.delete();
    }

    public void pelnytiTaskai(int numeris, int taskuSkaicius){
        String fileName = "C:/Users/Tomas/Desktop/PI15B/JAVA/PirmaUzduotis/rungtyniuLog.txt";
        FileWriter fw = null;
        BufferedWriter bw = null;
        String content = "";
        try {
            fw = new FileWriter(fileName, true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < pirmaKomanda.getZaidejai().size(); i++) {
                if (pirmaKomanda.getZaidejai().get(i).getNumeris() == numeris){
                    setPirmosKomandosTaskuSkaicius(pirmosKomandosTaskuSkaicius + taskuSkaicius);
                    content = pirmaKomanda.getZaidejai().get(i).getVardas() + " " +
                            pirmaKomanda.getZaidejai().get(i).getPavarde() + " Pelnė " + taskuSkaicius + " taškus. " +
                            " Rezultatas: " + getPirmosKomandosTaskuSkaicius() + " - " + getAntrosKomandosTaskuSkaicius();
                    break;
                }
            }
            for (int i = 0; i < antraKomanda.getZaidejai().size(); i++) {
                if (antraKomanda.getZaidejai().get(i).getNumeris() == numeris){
                    setAntrosKomandosTaskuSkaicius(antrosKomandosTaskuSkaicius + taskuSkaicius);
                    content = antraKomanda.getZaidejai().get(i).getVardas() + " " +
                            antraKomanda.getZaidejai().get(i).getPavarde() + " Pelnė " + taskuSkaicius + " taškus. " +
                            " Rezultatas: " + getPirmosKomandosTaskuSkaicius() + " - " + getAntrosKomandosTaskuSkaicius();;

                    break;
                }
            }
            bw.write(content);
            bw.newLine();

        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        if(pirmosKomandosTaskuSkaicius >= antrosKomandosTaskuSkaicius){
            return pirmaKomanda + " " + pirmosKomandosTaskuSkaicius + " - "
                    + antrosKomandosTaskuSkaicius + " " + antraKomanda + "\nLaimi " + pirmaKomanda;
        } else {
            return pirmaKomanda + " " + pirmosKomandosTaskuSkaicius + " - "
                    + antrosKomandosTaskuSkaicius + " " + antraKomanda + "\nLaimi " + antraKomanda;
        }
    }
}
