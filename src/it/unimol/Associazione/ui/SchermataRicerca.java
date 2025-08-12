package it.unimol.Associazione.ui;

import it.unimol.Associazione.app.Associato;
import it.unimol.Associazione.app.GestoreAssociati;
import it.unimol.Associazione.exceptions.InvalidAssociatoException;

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
