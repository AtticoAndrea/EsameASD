package it.unimol.Associazione.app;

public class Associato {

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
}
