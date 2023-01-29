import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvidenceZakazniku {
    List<Zakaznik> zakaznici = new ArrayList<>();
    List<Zakaznik> seznamZakazniku = new ArrayList<>();

    public void nactiSoubor(String soubor, String ODDELOVAC){
        String nextLine = "";
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(soubor)))){
            while(scanner.hasNext()){
                nextLine = scanner.nextLine();
                String[] polozky = nextLine.split(ODDELOVAC);
                zakaznici.add(new Zakaznik(polozky[0], Integer.parseInt(polozky[1])));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Soubor: "+soubor+" nebyl nalezen"+e.getLocalizedMessage());
        }
    }
    public void zapisSoubor(String soubor, String ODDELOVAC){
        String radek = "";
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(soubor)))){
            for(Zakaznik zakaznik : zakaznici){
                radek = zakaznik.getJmeno()+ODDELOVAC+zakaznik.getPocetProdeju();
                writer.println(radek);
            }
        } catch (IOException e) {
            throw new RuntimeException("Chyba načítání do souboru: "+soubor);
        }
    }
    public void pridat(Zakaznik novyZakaznik){
        zakaznici.add(novyZakaznik);
    }
    public void odebrat(int index){
        zakaznici.remove(index);
    }

    public List<Zakaznik> getZakaznici() {
        return zakaznici;
    }
}
