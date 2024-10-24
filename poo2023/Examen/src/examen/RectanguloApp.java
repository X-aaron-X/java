package examen;

public class RectanguloApp {
    private String nombre;
    private double base;
    private double altura;

    /**
     * Constructor por defecto que inicialice los atributos a 0 y vacío
     */
    public RectanguloApp() {
        this.nombre = "";
        this.base = 0.0;
        this.altura = 0.0;
    }

    /**
     * Constructor que recibe la base y la altura y pone el nombre a vacío
     * @param base double
     * @param altura double
    */
    public RectanguloApp(double base, double altura) {
        this.nombre = "";
        this.base = base;
        this.altura = altura;
    }

    /**
     * Constructor que recibe los tres datos
     * @param nombre String
     * @param base double
     * @param altura double
    */
    public RectanguloApp(String nombre, double base, double altura) {
        this.nombre = nombre;
        this.base = base;
        this.altura = altura;
    }

    /**
     * Devuelve el área del rectángulo
     * @return double
    */
    public double getArea() {
        return base * altura;
    }

    /**
     * Devuelve una cadena conteniendo su nombre, su área y su altura
     * @return String
    */
    @Override
    public String toString() {
        return "- Nombre: " + nombre + "\n- Área: " + getArea() + "\n- Altura: " + altura;
    }

    /**
     * Devuelve un booleano indicando si el rectángulo es cuadrado
     * @return boolean
     */
    public boolean esCuadrado() {
        return base == altura;
    }

    /**
     * Devuelve el nombre
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Recibe el nombre
     * @param nombre string
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve la base
     * @return double
    */
    public double getBase() {
        return base;
    }
    
    /**
     * Recibe la base
     * @param base double
    */
    public void setBase(double base) {
        this.base = base;
    }
    
    /**
     * Recibe la la altura
     * @return double
    */
    public double getAltura() {
        return altura;
    }
    
    /**
     * Devuelve la altura
     * @param altura double
    */
    public void setAltura(double altura) {
        this.altura = altura;
    }
}

