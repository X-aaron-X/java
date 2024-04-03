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
        return super.toString() + "\n- Comisi�n: " + comision + "\n\n";
    }
    
    /**
     * Si tiene m�s de 30 a�os y cobra una comisi�n de m�s de 200 euros, se le aplicara el plus
     * @void
     */
    @Override
    public void plus() {
        if (getEdad() > 30 && getComision() > 200) {
            setSalario(getSalario() + PLUS);
        }
    }
}
