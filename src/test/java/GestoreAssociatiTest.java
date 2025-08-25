import it.unimol.esameASD.app.Associato;
import it.unimol.esameASD.app.GestoreAssociati;
import it.unimol.esameASD.exceptions.InvalidAssociatoException;
import org.junit.Test;
import static org.junit.Assert.*;

public class GestoreAssociatiTest {

    //bisogna eseguire prima add test e poi remove test
    @Test
    public void addTest()throws InvalidAssociatoException {
        GestoreAssociati g = GestoreAssociati.getInstance();
        Associato a = new Associato("Test Nome", "Test Cognome", "Test email",
                "test telefono", 0 );
        g.addSocio(a);
        Associato a2 = g.getSocio(0);
        assertEquals("Test Nome", a2.getNome());
        assertEquals("Test Cognome", a2.getCognome());
        assertEquals("Test email", a2.getEmail());
        assertEquals("test telefono", a2.getTelefono());
    }

    @Test
    public void removeTest() throws InvalidAssociatoException {
        GestoreAssociati g = GestoreAssociati.getInstance();
        Associato a = new Associato("Test Nome", "Test Cognome", "Test email",
                "test telefono", 0 );
        g.removeSocio(a);
        assertThrows(InvalidAssociatoException.class, () -> {
            g.getSocio(0);
        });
    }

}
