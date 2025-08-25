package it.unimol.esameASD.app;


import it.unimol.esameASD.exceptions.InvalidAssociatoException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GestoreAssociati implements Serializable {

    public static final long serialVersionUID = 1L;

    private static GestoreAssociati instance;
    private Map<Integer, Associato> associati;

    public static GestoreAssociati getInstance() {
        try(
                FileInputStream fis = new FileInputStream("gestoreAssociati.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            instance = (GestoreAssociati) ois.readObject();
        }
        catch (FileNotFoundException e){
            instance = new GestoreAssociati();
        }
        catch (IOException e){
            System.err.println("IO Exception");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            System.err.println("ClassNotFoundException");
            e.printStackTrace();
        }
        return instance;
    }

    private GestoreAssociati() {
        associati = new HashMap<Integer, Associato>();
    }

    public void addSocio(Associato associato) throws InvalidAssociatoException {
        if(associato == null || isPresent(associato)){
            throw new InvalidAssociatoException();
        } else {
            associati.put(associato.getNumeroTessera(), associato);
            save();
        }

    }

    public Associato getSocio(int numeroTessera) throws InvalidAssociatoException {
        if(isPresent(numeroTessera)){
            return associati.get(numeroTessera);
        } else {
            throw new InvalidAssociatoException();
        }
    }

    public void removeSocio(int numeroTessera) throws InvalidAssociatoException {
        if(isPresent(numeroTessera)){
            associati.remove(numeroTessera);
            save();
        } else {
            throw new InvalidAssociatoException();
        }
    }

    public void removeSocio(Associato associato) throws InvalidAssociatoException {
        if(isPresent(associato.getNumeroTessera())){
            associati.remove(associato.getNumeroTessera());
            save();
        } else {
            throw new InvalidAssociatoException();
        }
    }

    public void printSoci(){
        for(Associato associato : associati.values()){
            System.out.println(associato);
        }
    }

    private boolean isPresent(Associato associato) {
        return associati.containsKey(associato.getNumeroTessera());
    }

    private boolean isPresent(int numeroTessera) {
        return associati.containsKey(numeroTessera);
    }

    private void save(){
        try(
                FileOutputStream fos = new FileOutputStream("gestoreAssociati.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(this);
        }
        catch (IOException e){
            System.err.println("IO Exception");
            e.printStackTrace();
        }
    }


}

