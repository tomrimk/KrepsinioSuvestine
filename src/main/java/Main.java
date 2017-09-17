import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.remainderUnsigned;

public class Main {

    public static List<Zaidejas> komandosPasirinkimas(List<Zaidejas> pradinis, List<Zaidejas> galutinis, int skaicius){
        Scanner user_input = new Scanner(System.in);
        do{
            System.out.println("Pasirinkite žaidėjus: ");
            int i = 1;
            for (Zaidejas z: pradinis) {
                System.out.println(i + ". " + z.toString());
                i++;
            }

            int pasirinkimas = user_input.nextInt();

            galutinis.add(pradinis.get(pasirinkimas-1));
            pradinis.remove(pasirinkimas-1);
            skaicius--;
        } while(skaicius != 0);

        return galutinis;
    }

    public static List zmoniuPriskirimas(String failoPavadinimas, List galutinis, Boolean arZaidejas){
        try {
            // This will reference one line at a time
            String line = null;
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(failoPavadinimas);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] eile = line.split(" ");

                if (arZaidejas){
                    Zaidejas zaidejas = new Zaidejas(eile[0], eile[1], parseDouble(eile[2]), parseInt(eile[3]), parseInt(eile[4]));
                    galutinis.add(zaidejas);
                } else {
                    Teisejas teisejas = new Teisejas(eile[0], eile[1], parseInt(eile[2]), eile[3]);
                    galutinis.add(teisejas);
                }
            }
            // Always close files.
            bufferedReader.close();
        } catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            failoPavadinimas + "'");
        } catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + failoPavadinimas + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return galutinis;
    }

    public static Komanda komandosSudarymas(List pasirinktiZaidejai){
        Scanner user_input = new Scanner(System.in);
        System.out.println("Trenerio Vardas: ");
        String trenVardas = user_input.next();
        System.out.println("Trenerio pavarde: ");
        String trenPavarde = user_input.next();
        System.out.println("Komandos pavadinimas: ");
        String komandosPavadinimas = user_input.next();
        Komanda komanda = new Komanda(komandosPavadinimas,pasirinktiZaidejai, new Treneris(trenVardas, trenPavarde));
        return komanda;
    }

    public static void main(String[] args) {

        Taisykles taisykles = new Taisykles("Pražanga");
        int pasirinkimas = 0;
        List<Komanda> komandos = new ArrayList<>();
        List<Teisejas> teisejai = new ArrayList<>();
        List<Zaidejas> zaidejai = new ArrayList<>();
        List<Zaidejas> pirmosKomandosPasirinktiZaidejai = new ArrayList<>();
        List<Zaidejas> antrosKomandosPasirinktiZaidejai = new ArrayList<>();

        Scanner user_input = new Scanner(System.in);

        // The name of the file to open.
        String fileZaidejai = "C:/Users/Tomas/Desktop/PI15B/JAVA/PirmaUzduotis/zaidejai.txt";
        String fileTeisejai = "C:/Users/Tomas/Desktop/PI15B/JAVA/PirmaUzduotis/teisejai.txt";

        zmoniuPriskirimas(fileZaidejai, zaidejai, true);
        zmoniuPriskirimas(fileTeisejai, teisejai, false);

        System.out.println("Įveskite komandos žaidėjų skaičių: ");
        int zaidejuSkaicius = user_input.nextInt();

        System.out.println("Pirmos komandos registracija.");
        pirmosKomandosPasirinktiZaidejai = komandosPasirinkimas(zaidejai,pirmosKomandosPasirinktiZaidejai,zaidejuSkaicius);
        Komanda pirmaKomanda = komandosSudarymas(pirmosKomandosPasirinktiZaidejai);

        System.out.println("Antros komandos registracija.");
        antrosKomandosPasirinktiZaidejai = komandosPasirinkimas(zaidejai,antrosKomandosPasirinktiZaidejai, zaidejuSkaicius);
        Komanda antraKomanda = komandosSudarymas(antrosKomandosPasirinktiZaidejai);

        System.out.println("Pasirinkite teisėją: ");
        int ts = 1;
        for (Teisejas t:teisejai) {
            System.out.print(ts + ". ");
            System.out.println(t.toString());
            ts++;
        }

        int ivestasTeisejas = user_input.nextInt();
        Teisejas pasirinktasTeisejas = teisejai.get(ivestasTeisejas-1);

        System.out.println("Iveskite vietos pavadinimą, kurioje įvyks rungtynės: ");
        String ivestaArena = user_input.next();
        Arena arena = new Arena(ivestaArena);

        Rungtynes rungtynes = new Rungtynes(pirmaKomanda,antraKomanda,pasirinktasTeisejas,arena,taisykles);
        rungtynes.isNew();
        System.out.println("RUNGTYNĖS PRASIDĖJO");
        do {
            System.out.println("Pasirinkite veiksmą:\n" +
                    "1. Įmestas Dvitaškis\n" +
                    "2. Įmestas Tritaškis\n" +
                    "3. Įmesta Bauda\n" +
                    "4. Pražanga\n" +
                    "5. Minutės pertraukėlė\n" +
                    "6. Rungtynių pabaiga");
            pasirinkimas = user_input.nextInt();
            switch (pasirinkimas){
                case 1:
                    System.out.println("Dvitaškį įmetė numeris: ");
                    int zaidejoNumeris = user_input.nextInt();
                    rungtynes.pelnytiTaskai(zaidejoNumeris, 2);
//                    Dvitaskis
                    break;
                case 2:
//                    Tritaskis
                    System.out.println("Tritaškį įmetė numeris: ");
                    zaidejoNumeris = user_input.nextInt();
                    rungtynes.pelnytiTaskai(zaidejoNumeris, 3);
                    break;
                case 3:
//                    Bauda
                    System.out.println("Baudą įmetė numeris: ");
                    zaidejoNumeris = user_input.nextInt();
                    rungtynes.pelnytiTaskai(zaidejoNumeris, 1);
                    break;
                case 4:
                    System.out.println("Prasižengusio numeris: ");
                    zaidejoNumeris = user_input.nextInt();
                    System.out.println("Prasižengė prieš: ");
                    int priesNumeris = user_input.nextInt();
                    rungtynes.prasizengimas(zaidejoNumeris, priesNumeris);
//                    Prazanga
                    break;
                case 5:
//                    Minutes pertraukele
                    break;
                case 6:
                    rungtynes.toString();
//                    Rungtyniu pabaiga
                    break;
                default:
                    System.out.println("Tokio pasirinkimo nėra.");
                    break;
            }
        } while(pasirinkimas != 6);

    }
}
