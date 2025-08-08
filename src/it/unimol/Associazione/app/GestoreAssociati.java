package it.unimol.Associazione.app;

import it.unimol.Associazione.exceptions.InvalidAssociatoException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GestoreAssociati implements Serializable {

    public static final long serialVersionUID = 1L;

    private static GestoreAssociati instance;
    private Map<Integer, GestoreAssociati> associati;

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
        associati = new HashMap<Integer, GestoreAssociati>();
    }

    public void addSocio(Associato associato) throws InvalidAssociatoException {

    }


}
