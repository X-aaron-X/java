package puntoapp;

/**
 *
 * @author Aaron
 */
public class Punto {
    private double coordX;
    private double coordY;
    
    /**
     * Constructor predeterminado que crea un punto con las coordenadas 0,0
    */
    public Punto() {
        this.coordX = 0.0;
        this.coordY = 0.0;
    }
    
    /**
     * Constructor que recibe como parámetros dos números
     * @param coordX
     * @param coordY 
     */
    public Punto(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }
}
