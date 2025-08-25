package it.unimol.esameASD.ui;


import it.unimol.esameASD.app.GestoreAssociati;
import it.unimol.esameASD.exceptions.InvalidAssociatoException;

import java.util.Scanner;

public class SchermataRimozione {

    private Scanner sc;
    private GestoreAssociati gestore;

    public SchermataRimozione(Scanner sc, GestoreAssociati gestore) {
        this.sc = sc;
        this.gestore = gestore;
    }

    public void esegui(){
        System.out.println("Inserisci il numero della tessera del socio da rimuovere:");
        int target = Integer.parseInt(sc.nextLine());
        try {
            gestore.removeSocio(target);
        } catch(InvalidAssociatoException e){
            System.err.println("Numero tessera non presente");
        }
    }
}