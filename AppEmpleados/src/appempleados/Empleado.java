package appempleados;

/**
 *
 * @author Aaron
 */
abstract class Empleado {
    private String nombre;
    private int edad;
    private double salario;
    public static final double PLUS = 300;
    
    /**
     * Contructor de nombre, edad y salario
     * @param nombre
     * @param edad
     * @param salario 
    */
    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return "- Nombre: " + nombre + "\n- Edad: " + edad + "\n- Salario: " + salario;
    }
    
    /**
     * Metodo abtracto para plus de los empleados
     * @void
    */
    public abstract void plus();
}