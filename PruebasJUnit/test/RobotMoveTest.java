
import static org.junit.Assert.fail;
import org.junit.Test;

/*
 * Titulo: RobotMoveTest.java
 * Fecha: 06 de agosto de 2016
 * Descripcion: Prueba de la clase RobotMoveTest, Proyecto de Estructura de Datos
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
public class RobotMoveTest {
    int[][] matrix1 = {{1,0,0},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{1,1,0}};
    int[][] matrix2 = {{1,0,0},{0,0,1},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{0,0,0}};
    int[][] matrix3 = {{0,1,0},{0,0,1},{0,1,0},{0,0,1},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{0,0,1},{0,0,1},{1,1,0}};
    int[][] matrix4 = {{0,1,0},{0,0,1},{0,0,1},{0,1,0},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{0,0,0}};
    int[][] matrix5 = {{1,0,0},{0,0,1},{0,0,1},{1,0,0},{0,0,1},{0,1,0},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{0,0,1},{1,1,0}};
    int[][] matrix6 = {{1,0,0},{0,0,1},{0,0,0}};
    int[][] matrix7 = {{0,1,0},{0,0,1},{0,1,0},{0,0,1},{0,0,1},{1,0,0},{0,0,1},{1,0,0},{0,0,1},{0,1,0},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{1,1,0}};
    int[][] matrix8 = {{1,0,0},{0,0,1},{0,0,0}};
    int[][] matrix9 = {{0,1,0},{0,0,1},{0,1,0},{0,0,1},{0,0,1},{0,0,1},{1,0,0},{0,0,1},{1,1,1},{1,1,1}};
        

    /**
     * Test of checkRight method, of class RobotMove.
     */
    @Test
    public void testCheckRight() {
        System.out.println("checkRight");
        RobotMove instance = new RobotMove(matrix1,matrix2,matrix3,matrix4,matrix5,matrix6,matrix7,matrix8,matrix9);
        boolean expResult = false;
        boolean result = instance.checkRight();
        if (expResult!=result){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of checkLeft method, of class RobotMove.
     */
    @Test
    public void testCheckLeft() {
        System.out.println("checkLeft");
        RobotMove instance = new RobotMove(matrix1,matrix2,matrix3,matrix4,matrix5,matrix6,matrix7,matrix8,matrix9);
        boolean expResult = true;
        boolean result = instance.checkLeft();
        if (expResult!=result){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getStep method, of class RobotMove.
     */
    @Test
    public void testGetStep() {
        System.out.println("getStep");
        RobotMove instance = new RobotMove(matrix1,matrix2,matrix3,matrix4,matrix5,matrix6,matrix7,matrix8,matrix9);
        int[][] expResult = {{1,0,0},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{1,1,0}};
        int[][] result = instance.getStep();
        if (expResult==result){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getStepR method, of class RobotMove.
     */
    @Test
    public void testGetStepR() {
        System.out.println("getStepR");
        RobotMove instance = new RobotMove(matrix1,matrix2,matrix3,matrix4,matrix5,matrix6,matrix7,matrix8,matrix9);
        int[][] expResult = {{1,0,0},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{1,1,0}};
        int[][] result = instance.getStepR();
        if (expResult==result){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getStepL method, of class RobotMove.
     */
    @Test
    public void testGetStepL() {
        System.out.println("getStepL");
        RobotMove instance = new RobotMove(matrix1,matrix2,matrix3,matrix4,matrix5,matrix6,matrix7,matrix8,matrix9);
        int[][] expResult = {{1,0,0},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{1,1,0}};
        int[][] result = instance.getStepL();
        if (expResult==result){
            fail("The test case is a prototype.");
        }
    }
    
}
