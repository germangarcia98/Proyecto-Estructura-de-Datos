/*
 * Titulo: Lista.java
 * Fecha: 04 de agosto de 2016
 * Descripcion: Clase lista para guardar nodos de memoria de trayecto de laberinto, Proyecto de Estructura de Datos
 */

/**
 * @author German Humberto García Aguilar 15008
 * @author Antonio Jose Ixtecoc Hernandez 15582
 * @author Aldo Stefano Aguilar Nadalini 15170
 * @author Luis Arturo Najera Vasquez 15581
 * @author Esteban Alejandro Avalos Morales 15059
 */
public class Lista{
    
    //Atributos
    private iNodo cabeza;                                                       //Primer nodo de la lista
    private iNodo nodoActual;                                                   //Nodo donde se posiciona actualmente el programa
    private int length = 1;                                                     //Tamanio de la lista de nodos
    
    /**
     * Constructor
     * @param left estado de flanco izquierdo de robot
     * @param right estado de flanco derecho de robot
     * @param front estado de sector frontal de robot
     */
    public Lista(boolean left, boolean right,boolean front){
        this.cabeza = NodoFactory.buildNodo(left, right, front);                //Dependiendo de estados, creacion de tipo de nodo correspondiente con NodoFactory
        this.nodoActual = this.cabeza;                                          //Nodo actual es cabeza, estado inicial.
    }
    
    /**
     * Metodo addNodo para agregar nuevo nodo a Lista
     * @param left estado de flanco izquierdo de robot
     * @param right estado de flanco derecho de robot
     * @param front estado de sector frontal de robot
     */
    public void addNodo(boolean left, boolean right,boolean front){
        if (this.cabeza == null){                                               //Si lista esta vacia
            this.cabeza = NodoFactory.buildNodo(left, right, front);            //Crea nodo cabeza
        } else {
            while (this.nodoActual.getSiguiente() != null){
                this.nodoActual = this.nodoActual.getSiguiente();               //Ciclo para llegar a ultimo nodo en la lista
            }
            if (this.nodoActual instanceof NodoChoice){                         //Si nuevo nodo es nodo de bifurcacion
                this.nodoActual.setSiguiente(NodoFactory.buildNodo(left, right, front));
                NodoChoice choice = (NodoChoice) this.nodoActual.getSiguiente();
                choice.setNodoLeft((NodoLeft) NodoFactory.buildNodo(true, false, false));      //Crear nodos de ramificaciones
                choice.setNodoRight((NodoRight) NodoFactory.buildNodo(false, true, false));
                choice.setNodoFront((NodoFront) NodoFactory.buildNodo(false, false, true));
            } else {
                this.nodoActual.setSiguiente(NodoFactory.buildNodo(left, right, front));      //De lo contrario, crear nodo correspondiente 
            }
            iNodo nodoAnterior = this.nodoActual;                               //Nodo actual se vuelve nodo anterior de nodo creado. Lista doble enlace
            this.nodoActual = this.nodoActual.getSiguiente();                   //Nuevo nodo creado es ahora nodo actual
            this.nodoActual.setAnterior(nodoAnterior);                          //Guardado de nodo anterior
        }
        this.length += 1;                                                       //Aumento de tamanio de lista
    }
    
    //Setters y Getters
    
    /**
     * Metodo getNodo
     * @return retorna nodoActual
     */
    public iNodo getNodo(){
        if (this.cabeza != null){
            iNodo nodoActual = this.cabeza;
            this.cabeza = this.cabeza.getSiguiente();
            return nodoActual;
        } else {
            return null;
        }
    }
    
    /**
     * Metodo isEmpty
     * @return retorna estado de lista
     */
    public boolean isEmpty(){
        if (length == 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the cabeza
     */
    public iNodo getCabeza() {
        return cabeza;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(iNodo cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the nodoActual
     */
    public iNodo getNodoActual() {
        return nodoActual;
    }

    /**
     * @param nodoActual the nodoActual to set
     */
    public void setNodoActual(iNodo nodoActual) {
        this.nodoActual = nodoActual;
    }
}