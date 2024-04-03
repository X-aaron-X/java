package appempleados;

/**
 *
 * @author Aaron
 */
public class Comercial extends Empleado{
    private double comision;
    
    /**
     * Contructor de nombre, edad, salario, comision.
     * Herada de Empleado.
     * @param nombre
     * @param edad
     * @param salario
     * @param comision 
     */
    public Comercial(String nombre, int edad, double salario, double comision) {
        super(nombre, edad, salario);
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n- Comisión: " + comision + "\n\n";
    }
    
    /**
     * Si tiene más de 30 años y cobra una comisión de más de 200 euros, se le aplicara el plus
     * @void
     */
    @Override
    public void plus() {
        if (getEdad() > 30 && getComision() > 200) {
            setSalario(getSalario() + PLUS);
        }
    }
}
