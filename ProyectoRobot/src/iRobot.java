/*
 * Titulo: iRobot.java
 * Fecha: 04 de agosto de 2016
 * Descripcion: Interfaz para movimientos de robot, Proyecto de Estructura de Datos
 */

/**
 * @author German Humberto García Aguilar 15008
 * @author Antonio Jose Ixtecoc Hernandez 15582
 * @author Aldo Stefano Aguilar Nadalini 15170
 * @author Luis Arturo Najera Vasquez 15581
 * @author Esteban Alejandro Avalos Morales 15059
 */
public interface iRobot {
    public boolean checkRight();        //Metodo para que sensor chequee flanco derecho
    public boolean checkLeft();         //Metodo para que sensor chequee flanco izquierdo
    public boolean checkFront();        //Metodo para que sensor chequee sector frontal
    public void move(boolean state);    //Metodo para que robot ejecute un paso
    public void turnRight();            //Metodo para que robot gire a la derecha
    public void turnLeft();             //Metodo para que robot gire a la izquierda
    public void rotate();               //Metodo para que robot gire 180° sobre su eje
}
