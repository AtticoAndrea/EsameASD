package it.unimol.esameASD.app;

import java.io.Serializable;

public class Associato implements Serializable {

    public static final long serialVersionUID = 1L;

    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private int numeroTessera;

    public Associato(String nome, String cognome, String email, String telefono, int numeroTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
        this.numeroTessera = numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public String toString() {
        return  "\n***************************\n" +
                "\nNOME: " + nome +
                "\nCOGNOME: " + cognome +
                "\nNUMERO TESSERA: " + numeroTessera +
                "\nTELEFONO: " + telefono +
                "\nEMAIL: " + email +
                "\n***************************\n";
    }
}
