package passwordApp;

/**
 *
 * @author Aaron
 */
public class Password {
    private final static int LONG_DEF = 8;
    private String contrasena;
    private int longitud;

    public Password {
        this(LONG_DEF);
    }
    
    public Passwordlongitud) {
        this.longitud = longitud;
        this.contrasena = generaPassword();
    }
    
    /**
     * Genera la contrase�a del objeto con la longitud que tenga
    */
    public void generarPassword() {
        String caracteresNum = "0123456789";
        String caracteresString = "abcdefghijklmn�opqrstuvwxyz";

        String todosCaracteres = caracteresNum + caracteresString + caracteresString.toUpperCase(); 

        this.contrasena = "";
        
        for (int i = 0; i < this.longitud; i++) {
            int aleatorio = (int) (Math.random() * todosCaracteres.length());
            
            char caracter = todosCaracteres.charAt(aleatorio);       
            this.contrasena += caracter;
        }
    }
    
    /**
     * Genera la contrase�a del objeto con la longitud que tenga 12 caracteres minimo y que siempre sea fuerte.
     * Para que sea fuerte debe tener m�s de 2 may�sculas, m�s de 1 min�scula y m�s de 5 n�meros
    */
    public void generarPasswordFuerte() {
        boolean esFuerte = false;

        while (!esFuerte) {
            generarPassword();

            esFuerte = esFuerte();
        }
    }
    
    /**
     * Devuelve un booleano si es fuerte o no, para que sea fuerte debe tener m�s de 2 may�sculas, m�s de 1 min�scula y m�s de 5 n�meros
     * @return boolean
    */
    public boolean esFuerte() {
        int mayusculas = 0;
        int minusculas = 0;
        int numeros = 0;

        for (char caracter : this.contrasena.toCharArray()) {
            if (Character.isUpperCase(caracter)) {
                mayusculas++;
            }
            else if (Character.isLowerCase(caracter)) {
                minusculas++;
            }
            else if (Character.isDigit(caracter)) {
                numeros++;
            }
        }

        return (mayusculas > 2 && minusculas > 1 && numeros > 5);
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public int getLongitud() {
        return this.longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
}
