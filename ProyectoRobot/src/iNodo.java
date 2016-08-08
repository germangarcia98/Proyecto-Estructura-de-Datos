/*
 * Titulo: iNodo.java
 * Fecha: 04 de agosto de 2016
 * Descripcion: Interfaz para enmascarar todos los tipos de nodos, Proyecto de Estructura de Datos
 */

/**
 * @author German Humberto García Aguilar 15008
 * @author Antonio Jose Ixtecoc Hernandez 15582
 * @author Aldo Stefano Aguilar Nadalini 15170
 * @author Luis Arturo Najera Vasquez 15581
 * @author Esteban Alejandro Avalos Morales 15059
 */
public interface iNodo {
    public void setSiguiente(iNodo nodo);           //Asigna enlace a nodo siguiente
    public iNodo getSiguiente();                    //Retorna nodo siguiente
    public void setAnterior(iNodo nodo);            //Asigna enlace a nodo anterior
    public iNodo getAnterior();                     //Retorna nodo anterior
    public void takeStep();                         //Aumenta contador de pasos de nodo
    public void takeStepBack();                     //Decrementa contador de pasos de nodo
    public void setContador(int contador);          //Inicializa contador de pasos de nodo
    public int getContador();                       //Retorna contador de pasos de nodo
}