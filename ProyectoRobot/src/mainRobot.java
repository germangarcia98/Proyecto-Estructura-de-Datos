/*
 * Titulo: mainRobot.java
 * Fecha: 05 de agosto de 2016
 * Descripcion: Clase principal para correr simulacion de robot en laberinto, Proyecto de Estructura de Datos
 */

/**
 * @author German Humberto García Aguilar 15008
 * @author Antonio Jose Ixtecoc Hernandez 15582
 * @author Aldo Stefano Aguilar Nadalini 15170
 * @author Luis Arturo Najera Vasquez 15581
 * @author Esteban Alejandro Avalos Morales 15059
 */
public class mainRobot {
    /**
     * Metodo estatico MAIN
     * @param args argumentos
     */
    public static void main(String[] args){
        //Codigos de caminos de laberinto de la simulacion
        int[][] matrix1 = {{1,0,0},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{1,1,0}};
        int[][] matrix2 = {{1,0,0},{0,0,1},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{0,0,0}};
        int[][] matrix3 = {{0,1,0},{0,0,1},{0,1,0},{0,0,1},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{0,0,1},{0,0,1},{1,1,0}};
        int[][] matrix4 = {{0,1,0},{0,0,1},{0,0,1},{0,1,0},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{0,0,0}};
        int[][] matrix5 = {{1,0,0},{0,0,1},{0,0,1},{1,0,0},{0,0,1},{0,1,0},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{1,0,0},{0,0,1},{0,0,1},{0,0,1},{1,1,0}};
        int[][] matrix6 = {{1,0,0},{0,0,1},{0,0,0}};
        int[][] matrix7 = {{0,1,0},{0,0,1},{0,1,0},{0,0,1},{0,0,1},{1,0,0},{0,0,1},{1,0,0},{0,0,1},{0,1,0},{0,0,1},{0,1,0},{0,0,1},{1,0,0},{0,0,1},{1,1,0}};
        int[][] matrix8 = {{1,0,0},{0,0,1},{0,0,0}};
        int[][] matrix9 = {{0,1,0},{0,0,1},{0,1,0},{0,0,1},{0,0,1},{0,0,1},{1,0,0},{0,0,1},{1,1,1},{1,1,1}};
        //Inicializacion de algoritmo BackTrack para que robot salga del algoritmo
        BackTrack Track = new BackTrack(matrix1,matrix2,matrix3,matrix4,matrix5,matrix6,matrix7,matrix8,matrix9);
    }
}
