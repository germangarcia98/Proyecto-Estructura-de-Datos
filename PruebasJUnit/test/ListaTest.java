
import static org.junit.Assert.fail;
import org.junit.Test;

/*
 * Titulo: ListaTest.java
 * Fecha: 06 de agosto de 2016
 * Descripcion: Prueba de la clase Lista, Proyecto de Estructura de Datos
 */

/**
 * @author German Humberto García Aguilar 15008
 * @author Antonio Jose Ixtecoc Hernandez 15582
 * @author Aldo Stefano Aguilar Nadalini 15170
 * @author Luis Arturo Najera Vasquez 15581
 * @author Esteban Alejandro Avalos Morales 15059


/**
 *
 * 
 */
public class ListaTest {
    
    
    /**
     * Test of getNodo method, of class Lista.
     */
    @Test
    public void testGetNodo() {
        System.out.println("getNodo");
        Lista instance = new Lista(true,true,true);
        iNodo expResult = null;
        iNodo result = instance.getNodo();
        if (expResult == result){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isEmpty method, of class Lista.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Lista instance = new Lista(true,true,true);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        if (expResult != result){
            fail("The test case is a prototype.");
        }
    }


    /**
     * Test of getLength method, of class Lista.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Lista instance = new Lista (true, true, true);
        int expResult = 1;
        int result = instance.getLength();
        if (expResult != result){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getNodoActual method, of class Lista.
     */
    @Test
    public void testGetNodoActual() {
        System.out.println("getNodoActual");
        Lista instance = new Lista(true,true,true);
        iNodo expResult = null;
        iNodo result = instance.getNodoActual();
        if (expResult == result){
            fail("The test case is a prototype.");
        }
    }

    
    
}
