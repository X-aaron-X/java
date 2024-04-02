package personaapp;

/**
 *
 * @author Aaron
 */
public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private double peso;
    private double altura;
    
    /**
     * Un constructor por defecto
    */
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dni = generarDNI();
        this.sexo = ' ';
        this.peso = 0;
        this.altura = 0;
    }
    
    /**
     * Un constructor con el nombre, edad y sexo, el resto por defecto
     * @param nombre
     * @param edad
     * @param sexo
    */
    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.dni = generarDNI();
        this.peso = 0;
        this.altura = 0;
    }
    
    /**
     * Un constructor con todos los atributos como parámetro
     * @param nombre
     * @param edad
     * @param sexo
     * @param peso
     * @param altura
    */
    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = generarDNI();
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public char getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n" +
               "Edad: " + this.edad + "\n" +
               "DNI: " + this.dni + "\n" +
               "Sexo: " + this.sexo + "\n" +
               "Peso: " + this.peso + "\n" +
               "Altura: " + this.altura;
    }
    
    /**
     * Genera un número aleatorio de 8 cifras, genera a partir de este su número su letra correspondiente. 
     * Este método será invocado cuando se construya el objeto. No será visible al exterior
     * @return String
    */
    private String generarDNI() {
        int numDni = (int) (Math.random() * 99999999) + 1;

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        char dniLetra = letras.charAt(numDni % 23);

        return String.format("%08d", numDni) + "-" + dniLetra;
    }
    
    /**
     * calculara si la persona está en su peso ideal (peso en kg/(altura^2  en m)), 
     * si esta fórmula devuelve un valor menor que 20, la función devuelve un -1, 
     * si devuelve un número entre 20 y 25 (incluidos), significa que está por debajo de su peso ideal la función devuelve un 0 
     * si devuelve un valor mayor que 25 significa que tiene sobrepeso, la función devuelve un 1
     * @return int
    */
    public int calcularIMC() {
        double imc = this.peso / (this.altura * this.altura);
        
        if (imc < 20) {
            return -1;
        }
        else if (imc >= 20 && imc <= 25) {
            return 0;
        }
        else {
            return 1;
        }
    }
    
    /**
     * Indica si es mayor de edad, devuelve un booleano
     * @return boolean
    */
    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }
    
    /**
     * Comprueba que el sexo introducido es correcto. Si no es correcto, será H. No será visible al exterior
     * @param sexo
     * @return 
     */
     private char comprobarSexo(char sexo) {
        return (sexo == 'M') ? sexo : 'H';
    }
}
