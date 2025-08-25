package it.unimol.esameASD.ui;


import it.unimol.esameASD.app.Associato;
import it.unimol.esameASD.app.GestoreAssociati;
import it.unimol.esameASD.exceptions.InvalidAssociatoException;

import java.util.Scanner;

public class SchermataInserimento {

    private Scanner sc;
    private GestoreAssociati gestore;

    public SchermataInserimento(Scanner sc, GestoreAssociati associati) {
        this.sc = sc;
        this.gestore = associati;
    }

    public void esegui(){
        Associato socio = gestisciInput();
        try{
            gestore.addSocio(socio);
        } catch (InvalidAssociatoException e){
            System.err.println("Errore durante l'inserimento");
        }
    }

    private Associato gestisciInput() {
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Cognome: ");
        String cognome = sc.nextLine();
        System.out.println("Numero tessera: ");
        int numeroTessera = Integer.parseInt(sc.nextLine());
        System.out.println("Telefono: ");
        String telefono = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        return new Associato(nome, cognome, email, telefono, numeroTessera);
    }
}

