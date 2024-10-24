package puntoapp;

/**
 *
 * @author Aaron
 */
public class Linea {
    private Punto puntoA;
    private Punto puntoB;
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    /**
     * Constructor predeterminado que crea una línea con sus dos puntos como (0,0) y (0,0).
    */
    public Linea() {
    }
    
    // Constructor que le metes dos puntos
    public Linea(Punto puntoA, Punto puntoB) {
        this.puntoA = puntoA;
        this.puntoB = puntoB;
    }

    /**
     * Constructor que recibe como parámetros dos objetos de la clase Punto, que son utilizados para inicializar los atributos
     * @param puntoA
     * @param puntoB 
     */
    public Linea(double x1, double y1, double x2, double y2) {
        this.puntoA = new Punto(x1, y1);
        this.puntoB = new Punto(x2, y2);
    }

    public Punto getPuntoA() {
        return puntoA;
    }

    public void setPuntoA(Punto puntoA) {
        this.puntoA = puntoA;
    }

    public Punto getPuntoB() {
        return puntoB;
    }

    public void setPuntoB(Punto puntoB) {
        this.puntoB = puntoB;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }
    
    /**
     * 
     * @param moverDerecha
    */
    public void mueveDerecha(double moverDerecha) {
        puntoA.setCoordX(puntoA.getCoordX() + moverDerecha);
        puntoB.setCoordX(puntoB.getCoordX() + moverDerecha);
    }
    
    /**
     * Desplaza la línea a la izquierda la distancia que se indique
     * @param moverIzquierda 
    */
    public void mueveIzquierda(double moverIzquierda) {
        puntoA.setCoordX(puntoA.getCoordX() + moverIzquierda);
    }
    
    /**
     * Desplaza la línea hacia arriba la distancia que se indique
     * @param moverArriba
    */
    public void mueveArriba(double moverArriba) {
        
    }
    
    /**
     * Desplaza la línea hacia abajo la distancia que se indique
     * @param moverAbajo
    */
    public void mueveAbajo(double moverAbajo) {
        
    }
    
    /**
     * Método que nos permita mostrar la información de la línea de la siguiente forma: [puntoA,puntoB]
     * @return 
     */
    public String info() {
        
        return ",";
    }
}