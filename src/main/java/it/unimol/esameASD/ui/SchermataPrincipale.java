package it.unimol.esameASD.ui;


import it.unimol.esameASD.app.GestoreAssociati;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SchermataPrincipale {

    private GestoreAssociati gestore;

    public SchermataPrincipale() {
        gestore = GestoreAssociati.getInstance();
    }

    public void esegui(){
        boolean esci;
        do{
            printMenu();
            esci = gestisciInput();
        }while(!esci);
    }

    private void printMenu() {
        System.out.println("\nGESTORE SOCI: ");
        System.out.println("1. Inserisci un socio.");
        System.out.println("2. Rimuovi un socio.");
        System.out.println("3. Cerca un socio.");
        System.out.println("4. Stampa elenco soci.");
        System.out.println("0. Esci");
    }

    private boolean gestisciInput() {
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        int scelta = Integer.parseInt(sc.nextLine());
        switch (scelta) {
            case 1:
                avviaSchermataInserimento(sc);
                return false;
            case 2:
                avviaSchermataRimozione(sc);
                return false;
            case 3:
                avviaSchermataRicerca(sc);
                return false;
            case 4:
                gestore.printSoci();
                return false;
            case 0:
                System.out.println("Uscita...");
                return true;
            default:
                System.err.println("Scelta non valida");
                return false;
        }
    }

    private void avviaSchermataInserimento(Scanner sc) {
        SchermataInserimento si = new SchermataInserimento(sc, gestore);
        si.esegui();

    }

    private void avviaSchermataRimozione(Scanner sc) {
        SchermataRimozione sr = new SchermataRimozione(sc, gestore);
        sr.esegui();
    }

    private void avviaSchermataRicerca(Scanner sc) {
        SchermataRicerca sr = new SchermataRicerca(sc, gestore);
        sr.esegui();
    }
}

