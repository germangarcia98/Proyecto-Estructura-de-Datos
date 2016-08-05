/*
 * Titulo: NodoFactory.java
 * Fecha: 04 de agosto de 2016
 * Descripcion: Clase Factoria para creacion de nodos de laberinto dependiendo tipo de cruce, Proyecto de Estructura de Datos
 */

/**
 * @author German Humberto García Aguilar 15008
 * @author Antonio Jose Ixtecoc Hernandez 15582
 * @author Aldo Stefano Aguilar Nadalini 15170
 * @author Luis Arturo Najera Vasquez 15581
 * @author Esteban Alejandro Avalos Morales 15059
 */
public class NodoFactory {
    
    /**
     * Metodo estatico buildNodo para construccion de nodos
     * @param left estado de flanco izquierdo
     * @param right estado de flanco derecho
     * @param front estado de sector frontal
     * @return 
     */
    public static iNodo buildNodo(boolean left, boolean right,boolean front){
        iNodo nodoNuevo = null;
        if (left && !right && !front){
            nodoNuevo = new NodoLeft();                                         //Si solo existe camino izquierdo, construir nodo izquierdo
            System.out.println("Nuevo Nodo Left");
        } else if (!left && right && !front){
            nodoNuevo = new NodoRight();                                        //Si solo existe camino derecho, construir nodo derecho
            System.out.println("Nuevo Nodo Right");
        } else if (!left && !right && front){
            nodoNuevo = new NodoFront();                                        //Si solo existe camino frontal, construir nodo frontal
            System.out.println("Nuevo Nodo Front");
        } else if ( (!left && right && front) || (left && !right && front)){
            nodoNuevo = new NodoChoice(left,right,front);                       //Si existen dos caminos a la vez, construir nodo de bifurcacion
            System.out.println("Nuevo Nodo Choice");
        } else if ( (left && right && !front) || (left && right && front)){     //Si existen dos o mas caminos a la vez, construir nodo de bifurcacion
            nodoNuevo = new NodoChoice(left,right,front);
            System.out.println("Nuevo Nodo Choice");
        } 
        return nodoNuevo;                                                       //Retorno de nuevo nodo creado
    }
}
