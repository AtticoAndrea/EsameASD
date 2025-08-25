package it.unimol.esameASD.ui;

import it.unimol.esameASD.app.Associato;
import it.unimol.esameASD.app.GestoreAssociati;
import it.unimol.esameASD.exceptions.InvalidAssociatoException;

import java.util.Scanner;

public class SchermataRicerca {

    private Scanner sc;
    private GestoreAssociati gestore;

    public SchermataRicerca(Scanner sc, GestoreAssociati gestore) {
        this.sc = sc;
        this.gestore = gestore;
    }

    public void esegui(){
        System.out.println("Inserisci il numero della tessera del socio da cercare:");
        int target = Integer.parseInt(sc.nextLine());
        try{
            System.out.println(gestore.getSocio(target));
        } catch(InvalidAssociatoException e) {
            System.err.println("Socio non trovato");
        }
    }

}
