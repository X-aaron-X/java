package animalapp;

/**
 *
 * @author Aaron
 */
public class Animal {
    private String especie;
    private String alimentacion;
    private int longevidad;
    private int maxPeso;
    private int maxAltura;
    
//constructores
    public Animal(String especie, String alimentacion, int longevidad, int maxPeso, int maxAltura){
        this.especie = especie;
        this.alimentacion = alimentacion;
        this.longevidad = longevidad;
        this.maxPeso = maxPeso;
        this.maxAltura = maxAltura;
    }
    
     public Animal(String especie, String alimentacion){
        this.especie = especie;
        this.alimentacion = alimentacion;
        this.longevidad = 0;
        this.maxPeso = 0;
        this.maxAltura = 0;
    }
    public void fijaEspyAli (String especie, String alimentacion){
        this.especie = especie;
        this.alimentacion = alimentacion;
    }
    public void fijaLongyPeso (int longevidad, int maxPeso){
        this.longevidad = longevidad;
        this.maxPeso = maxPeso;
    }
    public void obtenLongyPeso(){
        System.out.println("El animal puede vivir " + this.longevidad + " años y alcanzar un peso máximo de " + this.maxPeso);
    }
    public void obtenEspyAli(){
        System.out.println("El animal pertenece a la especie " + this.especie + " y se alimenta de " + this.alimentacion);
    }
    public double proporcion(){
        double propor,a,p;
        a = this.maxAltura;
        p = this.maxPeso;
        propor =  a / p;
        return propor;
    }
    public void esLongevo(){
        if (this.longevidad > 40) System.out.println("Animal  muy longevo");
        else System.out.println("Que vida más triste!");
                
    }
}
