package animalapp;

/**
 *
 * @author Aaron
 */
public class Pez extends Animal{
    private int profMax;
    private String tipo;
    
    /**
     * A�ade los m�todos fijaProfMax, obtenProfMax, fijaTipo y obtenTipo y un constructor con siete par�metros
     * @param especie
     * @param alimentacion
     * @param longevidad
     * @param maxPeso
     * @param maxAltura
     * @param profMax
     * @param tipo 
     */
    public Pez(String especie, String alimentacion, int longevidad, int maxPeso, int maxAltura, int profMax, String tipo) {
        super(especie, alimentacion, longevidad, maxPeso, maxAltura);
        this.profMax = profMax;
        this.tipo = tipo;
    }
    
    /**
     * A�ade tambi�n un constructor por defecto utilizando el constructor del padre que desees (recuerda que Animal no tiene ese constructor).
     * @param especie
     * @param alimentacion 
     */
    public Pez(String especie, String alimentacion) {
        super("", "");
        this.profMax = 0;
        this.tipo = "";
    }

    public int obtenProfMax() {
        return profMax;
    }

    public void fijaProfMax(int profMax) {
        this.profMax = profMax;
    }

    public String obtenTipo () {
        return tipo;
    }

    public void fijaTipo (String tipo) {
        this.tipo = tipo;
    }
       
    /**
     * Por �ltimo, sobreescribe el m�todo toString
     * @return String
     */
    @Override
    public String toString() {
        return "El pez es de tipo " + obtenTipo() +" y alcanza una profundidad m�xima de " + obtenProfMax() + " metros";
    }
}
