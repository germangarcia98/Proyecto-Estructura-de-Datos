/*
 * Titulo: BackTrack.java
 * Fecha: 04 de agosto de 2016
 * Descripcion: Clase para recorrido de laberinto, Proyecto de Estructura de Datos
 */

/**
 * @author German Humberto García Aguilar 15008
 * @author Antonio Jose Ixtecoc Hernandez 15582
 * @author Aldo Stefano Aguilar Nadalini 15170
 * @author Luis Arturo Najera Vasquez 15581
 * @author Esteban Alejandro Avalos Morales 15059
 */
public class BackTrack {
    
    //Atributos
    private RobotMove Robot;        //Robot del laberinto
    private Lista Path;             //Lista donde se guardaran nodos del camino
    private boolean left;           //Guarda estado de flanco izquierdo de robot (True: no hay pared, False: si hay pared)
    private boolean right;          //Guarda estado de flanco derecho de robot (True: no hay pared, False: si hay pared)
    private boolean front;          //Guarda estado de sector frontal de robot (True: no hay pared, False: si hay pared)
    private int count = 0;          //Contador de veces que se registran tres sectores libres. (Si se detecta dos veces seguidas se detiene el programa porque laberinto termino)
    private boolean state;          //Si State es True: robot esta avanzando analizando sectores, si es False: robot esta retrodeciendo utilizando datos de memoria.
    
    /**
     * Constructor de clase BackTrack
     * @param one       //Simulacion de laberinto: Camino No.1
     * @param two       //Simulacion de laberinto: Camino No.2
     * @param three     //Simulacion de laberinto: Camino No.3
     * @param four      //Simulacion de laberinto: Camino No.4
     * @param five      //Simulacion de laberinto: Camino No.5
     * @param six       //Simulacion de laberinto: Camino No.6
     * @param seven     //Simulacion de laberinto: Camino No.7
     * @param eight     //Simulacion de laberinto: Camino No.8
     * @param nine      //Simulacion de laberinto: Camino No.9
     */
    public BackTrack(int[][] one,int[][] two,int[][] three,int[][] four,int[][] five,int[][] six,int[][] seven,int[][] eight,int[][] nine){
        
        //Inicializacion de robot
        //Para Fase No.2 de proyecto, ya no sera necesario ingreso de arrays a robot
        this.Robot = new RobotMove(one,two,three,four,five,six,seven,eight,nine);
        
        //Inicializacion de estados
        this.left = true;
        this.right = true;
        this.front = true;
        
        //Primera actualizacion de estados de recorrido. Se activan sensores
        updateStates();
        
        //Creacion de nueva lista en donde se almacenaran nodos del recorrido
        this.Path = new Lista(this.left,this.right,this.front);     //Se almacena primer nodo de lista (cabeza) con datos del primer analisis de sensores
        
        //Si frente esta despejado
        if (!this.left && !this.right && this.front){
            state = true;                                   //Robot avanza analizando
            this.Path.getNodoActual().takeStep();           //Aumenta contador de nodo actual. Representa paso hacia enfrente
            this.Robot.move(state);                         //Si State es True: robot realiza paso hacia adelante
        } else {
            if (this.Path.getNodoActual() instanceof NodoChoice){                   //Si primer nodo es Nodo de bifurcacion, dependiendo tipo de ramificacion a seguir realizar accion (Nodo Left: girar izquierda, NodoRight: girar derecha, NodoFront: avanzar hacia adelante
                NodoChoice nodoChoice = (NodoChoice) this.Path.getNodoActual();     
                if (nodoChoice.isStateRight()){                             //Si existe ramificacion a la derecha
                    this.Path.setNodoActual(nodoChoice.getNodoRight());     //Nodo actual es nodo de cruce a derecha
                    this.Robot.turnRight();                                 //Robot gira a la derecha
                } else if (nodoChoice.isStateLeft()){                       //Si existe ramificacion a la izquierda
                    this.Path.setNodoActual(nodoChoice.getNodoLeft());      //Nodo actual es nodo de cruce a izquierda
                    this.Robot.turnLeft();                                  //Robot gira a la izquierda
                } else if (nodoChoice.isStateFront()){                      //Si existe ramificacion hacia enfrente
                    this.Path.setNodoActual(nodoChoice.getNodoFront());     //Nodo actual es nodo de avance frontal
                    this.Robot.move(state);                                 //Robot toma paso hacia entrente
                    this.Path.getNodoActual().takeStep();                   //Se aumenta contador de pasos en nodo actual
                } 
            } else if (this.Path.getNodoActual() instanceof NodoLeft){
                this.Robot.turnLeft();                                      //Si el primer nodo es Nodo de cruce izquierdo, girar a la izquierda
            } else if (this.Path.getNodoActual() instanceof NodoRight){
                this.Robot.turnRight();                                     //Si el primer nodo es Nodo de cruce derecha, girar a la derecha
            }
        }
        while (count < 2){
            execute();                                                      //Mientras que laberinto no termine, ejecutar avance
        }
    }
    
   /**
    * Metodo Execute para realizr acciones del robot
    */ 
    public void execute(){
        
        //Chequear lados del robot
        updateStates();
        
        //Si enfrente esta despejado
        if (!this.left && !this.right && this.front){
            state = true;
            this.Path.getNodoActual().takeStep();               //Aumentar contador de pasos de nodo actual
            this.Robot.move(state);                             //Si State: True, mover robot hacia adelante
        } else if (!this.left && !this.right && !this.front){   //Si todos los lados estan cerrados
            state = false;                                      //State es falso, indica proceso de retroceso
            this.Robot.rotate();                                //Giro de 180° del robot
            while (true){
                while (this.Path.getNodoActual().getContador() != 0){       //Mientras contador de pasos de nodo actual no sea cero
                    this.Path.getNodoActual().takeStepBack();               //Disminuir contador de pasos de nodo actual
                    Robot.move(state);                                      //Si State: Falso, tomar un paso de retroceso (no es retroceso literal del robot)
                }
                if (this.Path.getNodoActual() instanceof NodoLeft){                         //Si nodo actual es nodo de cruce a la izquierda
                    if (this.Path.getNodoActual().getAnterior() instanceof NodoChoice){     //Y si dicho nodo es ramificacion de nodo de bifurcacion
                        this.Robot.turnLeft();                                              //Girar a la izquierda para posicionarse en posicion inicial en la bifurcacion
                        NodoChoice node = (NodoChoice) this.Path.getNodoActual().getAnterior();
                        node.setStateLeft(false);                                           //Eliminar ramificacion a la izquierda de nodo de bifurcacion
                    } else {
                        this.Robot.turnRight();                                             //De lo contrario, girar a la derecha para retroceder en cruce
                    }
                } else if (this.Path.getNodoActual() instanceof NodoRight){                 //Si nodo actual es nodo de cruce a la derecha
                    if (this.Path.getNodoActual().getAnterior() instanceof NodoChoice){     //Y si dicho nodo es ramificacion de nodo de bifurcacion
                        this.Robot.turnRight();                                             //Girar a la derecha para posicionarse en posicion inicial en la bifurcacion
                        NodoChoice node = (NodoChoice) this.Path.getNodoActual().getAnterior();
                        node.setStateRight(false);                                          //Eliminar ramificacion a la derecha de nodo de bifurcacion
                    } else {
                        this.Robot.turnLeft();                                              //De lo contrario, girar a la izquierda para retroceder en cruce 
                    }
                } else if (this.Path.getNodoActual() instanceof NodoFront){                 //Si nodo actual es nodo de avance frontal
                    if (this.Path.getNodoActual().getAnterior() instanceof NodoChoice){     //Y si dicho nodo es ramificacion de nodo de bifurcacion
                        this.Robot.rotate();                                                //Rotar 180° para posicionarse en posicion inicial en la bifurcacion
                        NodoChoice node = (NodoChoice) this.Path.getNodoActual().getAnterior();
                        node.setStateFront(false);                                          //Eliminar ramificacion frontal de nodo de bifurcacion
                    } else {
                        //Nunca se ejecuta
                    }
                }
                
                //Cambiar nodo actual a nodo anterior para seguir retrocediendo en camino utilizando pasos guardados en memoria
                this.Path.setNodoActual(this.Path.getNodoActual().getAnterior());
                
                //Si nuevo nodo actual es un nodo de bifurcacion
                if (this.Path.getNodoActual() instanceof NodoChoice){
                    NodoChoice nodoChoice = (NodoChoice) this.Path.getNodoActual();
                    if (nodoChoice.isStateRight()){                             //Si ramificacion derecha de nodo de bifurcacion esta activada
                        this.Path.setNodoActual(nodoChoice.getNodoRight());     //Nuevo nodo actual es nodo de cruce derecha
                        this.Robot.setNextStep("right");                        //Cambiar a camino derecho correspondiente en la secuencia de laberinto. ESTO NO SE UTILIZARA EN FASE NO.2
                        this.Robot.turnRight();                                 //Robot gira a la derecha
                        //System.out.println("R");
                        state = true;                                           //State cambia de nuevo a avance frontal
                        break;                                                  //TERMINA CICLO DE RETROCESO------------
                    } else if (nodoChoice.isStateLeft()){                       //Si ramificacion izquierda de nodo de bifurcacion esta activada
                        this.Path.setNodoActual(nodoChoice.getNodoLeft());      //Nuevo nodo actual es nodo de cruce izquierda
                        this.Robot.setNextStep("left");                         //Cambiar a camino izquierdo correspondiente en la secuencia de laberinto. ESTO NO SE UTILIZARA EN FASE NO.2
                        this.Robot.turnLeft();                                  //Robot gira a la izquierda
                        //System.out.println("L");
                        state = true;                                           //State cambia de nuevo a avance frontal
                        break;                                                  //TERMINA CICLO DE RETROCESO-----------
                    } else if (nodoChoice.isStateFront()){                      //Si ramificacion frontal de nodo de bifurcacion esta activada
                        this.Path.setNodoActual(nodoChoice.getNodoFront());     //Nuevo nodo actual es nodo de avance frontal
                        this.Robot.setNextStep("front");                        //Cambiar a camino frontal correspondiente en la secuencia de laberinto. ESTO NO SE UTILIZARA EN FASE NO.2
                        //System.out.println("F");
                        state = true;                                           //State cambia de nuevo a avance frontal
                        break;                                                  //TERMINA CICLO DE RETROCESO-----------
                    } else {
                        this.Path.setNodoActual(nodoChoice.getAnterior());      //Si ninguna bifurcacion activada, seguir retrocediendo bifurcacion anterior
                        //this.Robot.changeBackHeadStep();                      //Retornar a anterior camino principal en laberinto
                    }
                }
            }
        } else {
            state = true;                                                       //State es True: avance frontal del robot
            
            //Si todos los lados libres, robot salio del laberinto. Terminar programa.
            if (this.left && this.right && this.front){
                System.out.println("He salido del laberinto!");
                System.exit(0);                                                 //SALIDA DE PROGRAMA
            }
            
            //Crear nuevo nodo de cruce o de bifurcacion dependiendo estados de flancos del robot. Nodo creado es nuevo nodo actual
            this.Path.addNodo(this.left, this.right, this.front);
            
            //Si nuevo nodo actual es nodo de bifurcacion
            if (this.Path.getNodoActual() instanceof NodoChoice){
                this.Robot.changeHeadStep();                                    //Realizar cambio de camino principal de laberinto donde se encuentra robot
                NodoChoice nodoChoice = (NodoChoice) this.Path.getNodoActual();
                if (nodoChoice.isStateLeft()){                                  //Si ramificacion izquierda de nodo de bifurcacion esta activada
                    this.Path.setNodoActual(nodoChoice.getNodoLeft());          //Nuevo nodo actual es nodo de cruce izquierda
                    this.Robot.setNextStep("left");                             //Cambiar a camino izquierdo correspondiente en la secuencia de laberinto. ESTO NO SE UTILIZARA EN FASE NO.2
                    this.Robot.turnLeft();                                      //Robot gira a la izquierda----------
                } else if (nodoChoice.isStateRight()){                          //Si ramificacion derecha de nodo de bifurcacion esta activada
                    this.Path.setNodoActual(nodoChoice.getNodoRight());         //Nuevo nodo actual es nodo de cruce derecha
                    this.Robot.setNextStep("right");                            //Cambiar a camino derecho correspondiente en la secuencia de laberinto. ESTO NO SE UTILIZARA EN FASE NO.2
                    this.Robot.turnRight();                                     //Robot gira a la derecha------------
                } else if (nodoChoice.isStateFront()){                          //Si ramificacion frontal de nodo de bifurcacion esta activada
                    this.Path.setNodoActual(nodoChoice.getNodoFront());         //Nuevo nodo actual es nodo de avance frontal
                    this.Robot.setNextStep("front");                            //Cambiar a camino frontal correspondiente en la secuencia de laberinto. ESTO NO SE UTILIZARA EN FASE NO.2
                    this.Robot.move(state);                                     //Robot avanza hacia enfrente--------
                    this.Path.getNodoActual().takeStep();                       //Se aumenta contador de pasos de nodo actual
                } 
            } else if (this.Path.getNodoActual() instanceof NodoLeft){          //En cambio, si nuevo nodo es de cruce izquierda
                this.Robot.turnLeft();                                          //Solo girar a la izquierda
                //EN CORRIDA REAL, REALIZAR:
                //this.Robot.move(state);                                       //Robot avanza hacia enfrente--------
                //this.Path.getNodoActual().takeStep(); 
            } else if (this.Path.getNodoActual() instanceof NodoRight){         //En cambio, si nuevo nodo es de cruce derecha
                this.Robot.turnRight();                                         //Solo girar a la izquierda
                //EN CORRIDA REAL, REALIZAR:
                //this.Robot.move(state);                                       //Robot avanza hacia enfrente--------
                //this.Path.getNodoActual().takeStep(); 
            }
        }
    }
    
    
    /**
     * Metodo para actualizar estado de recorrido
     */
    public void updateStates(){
        //Robot.setStep(steps[this.numStep]);
        this.left = Robot.checkLeft();          //Llama a chequeo de lado izquierdo. (Sensor izquierdo de robot)
        this.right = Robot.checkRight();        //Llama a chequeo de lado derecho. (Sensor derecho de robot)
        this.front = Robot.checkFront();        //Llama a chequeo de sector frontal. (Sensor frontal de robot)
    }   
    
    //Setters y Getters

    /**
     * @return the Robot
     */
    public RobotMove getRobot() {
        return Robot;
    }

    /**
     * @return the Path
     */
    public Lista getPath() {
        return Path;
    }

    /**
     * @return the left
     */
    public boolean isLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public boolean isRight() {
        return right;
    }

    /**
     * @return the front
     */
    public boolean isFront() {
        return front;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param Robot the Robot to set
     */
    public void setRobot(RobotMove Robot) {
        this.Robot = Robot;
    }

    /**
     * @param Path the Path to set
     */
    public void setPath(Lista Path) {
        this.Path = Path;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * @param right the right to set
     */
    public void setRight(boolean right) {
        this.right = right;
    }

    /**
     * @param front the front to set
     */
    public void setFront(boolean front) {
        this.front = front;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
}
