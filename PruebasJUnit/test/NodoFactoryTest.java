
import static org.junit.Assert.fail;
import org.junit.Test;

/*
 * Titulo: NodoFactorytTest.java
 * Fecha: 06 de agosto de 2016
 * Descripcion: Prueba de la clase NodoFactoryTest, Proyecto de Estructura de Datos
 */

/**
 * @author German Humberto García Aguilar 15008
 * @author Antonio Jose Ixtecoc Hernandez 15582
 * @author Aldo Stefano Aguilar Nadalini 15170
 * @author Luis Arturo Najera Vasquez 15581
 * @author Esteban Alejandro Avalos Morales 15059


/**
 *
 * @author Luis Nájera
 */
public class NodoFactoryTest {
    

    /**
     * Test of buildNodo method, of class NodoFactory.
     */
    @Test
    public void testBuildNodo() {
        System.out.println("buildNodo");
        boolean left = false;
        boolean right = false;
        boolean front = false;
        iNodo expResult = null;
        iNodo result = NodoFactory.buildNodo(left, right, front);
        if (expResult != result){
            fail("The test case is a prototype.");
        }
    }
    
    /**
     * Test of buildNodo method, of class NodoFactory.
     */
    @Test
    public void testBuildNodo2() {
        System.out.println("buildNodo");
        boolean left = true;
        boolean right = true;
        boolean front = true;
        iNodo expResult = null;
        iNodo result = NodoFactory.buildNodo(left, right, front);
        if (expResult == result){
            fail("The test case is a prototype.");
        }
    }
    
    /**
     * Test of buildNodo method, of class NodoFactory.
     */
    @Test
    public void testBuildNodo3() {
        System.out.println("buildNodo");
        boolean left = false;
        boolean right = true;
        boolean front = false;
        iNodo expResult = null;
        iNodo result = NodoFactory.buildNodo(left, right, front);
        if (expResult == result){
            fail("The test case is a prototype.");
        }
    }
    
    /**
     * Test of buildNodo method, of class NodoFactory.
     */
    @Test
    public void testBuildNodo4() {
        System.out.println("buildNodo");
        boolean left = false;
        boolean right = false;
        boolean front = true;
        iNodo expResult = null;
        iNodo result = NodoFactory.buildNodo(left, right, front);
        if (expResult == result){
            fail("The test case is a prototype.");
        }
    }
    
    
    /**
     * Test of buildNodo method, of class NodoFactory.
     */
    @Test
    public void testBuildNodo5() {
        System.out.println("buildNodo");
        boolean left = true;
        boolean right = false;
        boolean front = false;
        iNodo expResult = null;
        iNodo result = NodoFactory.buildNodo(left, right, front);
        if (expResult == result){
            fail("The test case is a prototype.");
        }
    }
}
