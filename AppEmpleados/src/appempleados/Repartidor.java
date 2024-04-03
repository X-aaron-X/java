package appempleados;

/**
 *
 * @author Aaron
 */
public class Repartidor extends Empleado{
    private String zona;
    
    /**
     * Contructor de nombre, edad, salario, zona.
     * Herada de Empleado.
     * @param nombre
     * @param edad
     * @param salario
     * @param zona 
     */
    public Repartidor(String nombre, int edad, double salario, String zona) {
        super(nombre, edad, salario);
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n- Zona: " + zona + "\n\n";
    }
    
    /**
     * Si tiene menos de 25 y reparte en la ?zona 3?, este recibirá el plus
     * @void
     */
    @Override
    public void plus() {
        if (getEdad() < 25 && getZona().equals("zona 3")) {
            setSalario(getSalario() + PLUS);
        }
    }
}
