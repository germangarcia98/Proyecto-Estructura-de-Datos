/*
 * Titulo: NodoChoice.java
 * Fecha: 04 de agosto de 2016
 * Descripcion: Clase para nodo de bifurcaciones en laberinto, Proyecto de Estructura de Datos
 */

/**
 * @author German Humberto García Aguilar 15008
 * @author Antonio Jose Ixtecoc Hernandez 15582
 * @author Aldo Stefano Aguilar Nadalini 15170
 * @author Luis Arturo Najera Vasquez 15581
 * @author Esteban Alejandro Avalos Morales 15059
 */
public class NodoChoice implements iNodo{
    
    //Atributos
    private NodoLeft NodoLeft;          //Nodo de ramificacion izquierda
    private NodoRight NodoRight;        //Nodo de ramificacion derecha
    private NodoFront NodoFront;        //Nodo de ramificacion frontal
    private boolean StateLeft;          //Estado de ramificacion izquierda. True: camino habilitado, False: inhabilitado
    private boolean StateRight;         //Estado de ramificacion derecha. True: camino habilitado, False: inhabilitado
    private boolean StateFront;         //Estado de ramificacion frontal. True: camino habilitado, False: inhabilitado
    private iNodo nodoAnterior;         //Nodo anterior de bifurcacion
    
    /**
     * Constructor NodoChoice
     * @param left estado de cruce izquierdo
     * @param right estado de cruce derecho
     * @param front estado de cruce enfrente
     */
    public NodoChoice(boolean left,boolean right,boolean front){
        if (left){
            this.NodoLeft = new NodoLeft();         //Si existe camino izquierdo
            this.NodoLeft.setAnterior(this);
        }
        if (right){
            this.NodoRight = new NodoRight();       //Si existe camino derecho
            this.NodoRight.setAnterior(this);
        }
        if (front){
            this.NodoFront = new NodoFront();       //Si existe camino frontal
            this.NodoFront.setAnterior(this);
        }
        this.StateLeft = left;                      //Cambio de estados de ramificaciones
        this.StateRight = right;
        this.StateFront = front;
    }
    
    //Setters y Getters

    /**
     * @return the NodoLeft
     */
    public NodoLeft getNodoLeft() {
        return NodoLeft;
    }

    /**
     * @return the NodoRight
     */
    public NodoRight getNodoRight() {
        return NodoRight;
    }

    /**
     * @return the NodoFront
     */
    public NodoFront getNodoFront() {
        return NodoFront;
    }

    /**
     * @return the StateLeft
     */
    public boolean isStateLeft() {
        return StateLeft;
    }

    /**
     * @return the StateRight
     */
    public boolean isStateRight() {
        return StateRight;
    }

    /**
     * @return the StateFront
     */
    public boolean isStateFront() {
        return StateFront;
    }

    /**
     * @return the nodoAnterior
     */
    public iNodo getNodoAnterior() {
        return nodoAnterior;
    }

    /**
     * @param NodoLeft the NodoLeft to set
     */
    public void setNodoLeft(NodoLeft NodoLeft) {
        this.NodoLeft = NodoLeft;
    }

    /**
     * @param NodoRight the NodoRight to set
     */
    public void setNodoRight(NodoRight NodoRight) {
        this.NodoRight = NodoRight;
    }

    /**
     * @param NodoFront the NodoFront to set
     */
    public void setNodoFront(NodoFront NodoFront) {
        this.NodoFront = NodoFront;
    }

    /**
     * @param StateLeft the StateLeft to set
     */
    public void setStateLeft(boolean StateLeft) {
        this.StateLeft = StateLeft;
    }

    /**
     * @param StateRight the StateRight to set
     */
    public void setStateRight(boolean StateRight) {
        this.StateRight = StateRight;
    }

    /**
     * @param StateFront the StateFront to set
     */
    public void setStateFront(boolean StateFront) {
        this.StateFront = StateFront;
    }

    /**
     * @param nodoAnterior the nodoAnterior to set
     */
    public void setNodoAnterior(iNodo nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }

    @Override
    public void setSiguiente(iNodo nodo) {
        //Empty    
    }

    @Override
    public iNodo getSiguiente() {
        return null;    
    }

    @Override
    public void setAnterior(iNodo nodo) {
        this.nodoAnterior = nodo;
    }

    @Override
    public iNodo getAnterior() {
        return this.nodoAnterior;
    }

    @Override
    public void takeStep() {
        //Empty
    }

    @Override
    public void takeStepBack() {
        //Empty
    }

    @Override
    public void setContador(int contador) {
        //Empty
    }

    @Override
    public int getContador() {
        return 0;
    }
}
