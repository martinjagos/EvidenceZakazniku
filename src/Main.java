public class Main {
    public static void main(String[] args) {
        EvidenceZakazniku evidence = new EvidenceZakazniku();
        Zakaznik zakaznik1 = new Zakaznik("Petr Rychlý", 10);
        Zakaznik zakaznik2 = new Zakaznik("Petr Pomalý", 1);

        evidence.nactiSoubor("vstup.txt",":");

        evidence.odebrat(evidence.getZakaznici().size()-1);

        evidence.pridat(zakaznik1);
        evidence.pridat(zakaznik2);

        evidence.zapisSoubor("vystup.txt", ":");


    }
}
