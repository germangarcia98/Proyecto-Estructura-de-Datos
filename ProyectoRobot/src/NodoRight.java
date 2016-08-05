/*
 * Titulo: NodoRight.java
 * Fecha: 04 de agosto de 2016
 * Descripcion: Clase de nodo de cruce derecho, Proyecto de Estructura de Datos
 */

/**
 * @author German Humberto García Aguilar 15008
 * @author Antonio Jose Ixtecoc Hernandez 15582
 * @author Aldo Stefano Aguilar Nadalini 15170
 * @author Luis Arturo Najera Vasquez 15581
 * @author Esteban Alejandro Avalos Morales 15059
 */
public class NodoRight implements iNodo{
        
    //Atributos
    private int Contador;               //Contador de pasos
    private iNodo nodoSiguiente;        //Enlace a nodo siguiente
    private iNodo nodoAnterior;         //Enlace a nodo anterior

    /**
     * Contructor de NodoRight
     */
    public NodoRight() {
        this.Contador = 0;
    }
    
    /**
     * Metodo TakeStep para aumento de contador de pasos dados por robot
     */
    @Override
    public void takeStep(){
        this.Contador += 1;
    }
    
    /**
     * Metodo TakeStepBack para decremento de contador de pasos dados por robot
     */
    @Override
    public void takeStepBack(){
        this.Contador = this.Contador  - 1;
    }
    
    //Setters y Getters

    /**
     * @return the Contador
     */
    @Override
    public int getContador() {
        return Contador;
    }

    /**
     * @param Contador the Contador to set
     */
    @Override
    public void setContador(int Contador) {
        this.Contador = Contador;
    }

    @Override
    public void setSiguiente(iNodo nodo) {
        this.nodoSiguiente = nodo;    
    }

    @Override
    public iNodo getSiguiente() {
        return this.nodoSiguiente;    
    }

    @Override
    public void setAnterior(iNodo nodo) {
        this.nodoAnterior = nodo;   
    }

    @Override
    public iNodo getAnterior() {
        return this.nodoAnterior;
    }
}
