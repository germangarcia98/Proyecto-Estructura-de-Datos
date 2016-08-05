/*
 * Titulo: RobotMove.java
 * Fecha: 04 de agosto de 2016
 * Descripcion: Clase para movimientos de robot, Proyecto de Estructura de Datos
 */

/**
 * @author German Humberto García Aguilar 15008
 * @author Antonio Jose Ixtecoc Hernandez 15582
 * @author Aldo Stefano Aguilar Nadalini 15170
 * @author Luis Arturo Najera Vasquez 15581
 * @author Esteban Alejandro Avalos Morales 15059
 */
public class RobotMove implements iRobot{
    
    //Atributos
    //Arrays 2D de caminos de laberinto solo para Fase No.1. Remover en Fase No.2
    private int[][] step1;
    private int[][] step2;
    private int[][] step3;
    private int[][] step4;
    private int[][] step5;
    private int[][] step6;
    private int[][] step7;
    private int[][] step8;
    private int[][] step9;
    private int[][] step;       //Camino actual donde se encuentra robot
    private int[][] stepR;      //Camino a la derecha de bifurcacion
    private int[][] stepL;      //Camino a la izquierda de bifurcacion
    private int[][] stepF;      //Camino frontal de bifurcacion
    //Contadores
    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;
    //Sensores para FASE NO.2
    /*
    private Sensor SensorLeft;
    private Sensor SensorRight;
    private Sensor SensorFront;*/
    
    /**
     * Constructor de clase RobotMove
     * @param one
     * @param two
     * @param three
     * @param four
     * @param five
     * @param six
     * @param seven
     * @param eight
     * @param nine 
     */
    public RobotMove(int[][] one,int[][] two,int[][] three,int[][] four,int[][] five,int[][] six,int[][] seven,int[][] eight,int[][] nine){
        //Inicializaciones solo parte de simulacion Fase No.1. Remover par Fase No.2
        this.step1 = one;
        this.step2 = two;
        this.step3 = three;
        this.step4 = four;
        this.step5 = five;
        this.step6 = six;
        this.step7 = seven;
        this.step8 = eight;
        this.step9 = nine;
        this.step = step1;      //Asigna camino actual
        /* Inicializacion de sensores para Fase No.2
        this.SensorLeft = new Sensor();
        this.SensorRight = new Sensor();
        this.SensorFront = new Sensor();*/
        setSideSteps();         //Asigna caminos derivados de camino actual
    }

    /**
     * Metodo de chequeo por sensor de flanco izquierdo
     * @return 
     */
    @Override
    public boolean checkRight() {
        return step[count1][1] == 1; //Si es True, existe camino libre
        //return this.SensorLeft.pulse();       PARA FASE NO.2
    }

    /**
     * Metodo de chequeo por sensor de flanco derecho
     * @return 
     */
    @Override
    public boolean checkLeft() {
        return step[count1][0] == 1; //Si es True, existe camino libre
        //return this.SensorRight.pulse();       PARA FASE NO.2
    }

    /**
     * Metodo de chequeo por sensor de sector frontal
     * @return 
     */
    @Override
    public boolean checkFront() {
        return step[count1][2] == 1; //Si es True, existe camino libre
        //return this.SensorFront.pulse();       PARA FASE NO.2
    }

    /**
     * Metodo para que robot realice un paso
     * @param state 
     */
    @Override
    public void move(boolean state) {
        if (state){                                 //True: recorre nuevo camino, False: retrocede en camino utilizando memoria
            System.out.println("Step forward");
            count1 += 1;                            //Aumenta paso en instrucciones (Solo simulacion de Fase No.1)
        } else {
            System.out.println("Step backward");
        }
    }

    /**
     * Giro de robot a la derecha
     */
    @Override
    public void turnRight() {
        System.out.println("Turn right");
        count1 += 1;
    }

    /**
     * Giro de robot a la izquierda
     */
    @Override
    public void turnLeft() {
        System.out.println("Turn left");
        count1 += 1;
    }

    /**
     * Giro de robot a 180°
     */
    @Override
    public void rotate() {
        System.out.println("Turn around");
    }
    
    //-----------------------------------METODOS DE SIMULACION----------------------------------------------------
    
    /**
     * Metodo de SIMULACION: para cambiar de camino principal en bifurcaciones
     * @param state 
     */
    public void setNextStep(String state){
        //setSideSteps();
        count1 = 0;                             //Reinicio de contador de instrucciones para nuevo camino
        if (state.equals("left")){          
            this.step = this.stepL;             //Nuevo camino es bifurcacion a la izquierda
        } else if (state.equals("right")){
            this.step = this.stepR;             //Nuevo camino es bifurcacion a la derecha
        } else if (state.equals("front")){
            this.step = this.stepF;             //Nuevo camino es bifurcacion hacia enfrente
        }
    }
    
    /**
     * Metodo de SIMULACION: para cambiar camino principal despues de bifurcacion determinada en laberinto
     */
    public void changeHeadStep(){
        count2 += 1;
        if (count2 == 1){
            this.step = this.step1;
        } else if (count2 == 2){
            this.step = this.step3;
        } else if (count2 == 3){
            this.step = this.step5;
        } else if (count2 == 4){
            this.step = this.step7;
            //System.out.println("Step7");
        }
        setSideSteps();
    }
    
    /**
     * Metodo de SIMULACION: para cambiar camino principal despues de regresar desde otra bifurcacion bifurcacion determinada en laberinto
     */
    public void changeBackHeadStep(){
        count3 += 1;
        if (count3 == 1){
            this.step = this.step7;
        } else if (count3 == 2){
            this.step = this.step5;
        } else if (count3 == 3){
            this.step = this.step6;
        } else if (count3 == 4){
            this.step = this.step1;
            //System.out.println("Step1");
        }
        setSideSteps();
    }
    
    /**
     * Metodo de SIMULACION: para cambiar caminos de bifurcaciones al final de actual camino principal
     */
    public void setSideSteps(){
        if (this.step == this.step1){
            this.stepL = this.step2;
            this.stepR = this.step3;
            this.stepF = null;
        } else if (this.step == this.step2){
            this.stepL = null;
            this.stepR = null;
            this.stepF = null;
        } else if (this.step == this.step3){
            this.stepL = this.step5;
            this.stepR = this.step4;
            this.stepF = null;
        } else if (this.step == this.step4){
            this.stepL = null;
            this.stepR = null;
            this.stepF = null;
        } else if (this.step == this.step5){
            this.stepL = this.step6;
            this.stepR = this.step7;
            this.stepF = null;
        } else if (this.step == this.step6){
            this.stepL = null;
            this.stepR = null;
            this.stepF = null;
        } else if (this.step == this.step7){
            this.stepL = this.step8;
            this.stepR = this.step9;
            this.stepF = null;
        } else if (this.step == this.step8){
            this.stepL = null;
            this.stepR = null;
            this.stepF = null;
        } else if (this.step == this.step9){
            this.stepL = null;
            this.stepR = null;
            this.stepF = null;
        }
    }
    
    //-------------------------------------------------------------------------------------------------------
    
    //Setters y Getters
    
    /**
     * @param step the step to set
     */
    public void setStep(int[][] step) {
        this.step = step;
    }

    /**
     * @return the step
     */
    public int[][] getStep() {
        return step;
    }

    /**
     * @return the stepR
     */
    public int[][] getStepR() {
        return stepR;
    }

    /**
     * @return the stepL
     */
    public int[][] getStepL() {
        return stepL;
    }
}
