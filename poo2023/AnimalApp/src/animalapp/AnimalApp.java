package animalapp;

/**
 *
 * @author Aaron
 */
public class AnimalApp {
    public static void main(String[] args) {
        //Lo primero instanciamos los tres objetos de clase Animal
        Animal tigre = new Animal("Tigre","Carnívoro",40,300,120);
        Animal elefante = new Animal("Elefante","Hervíboro",50,6000,300);
        Animal jirafa = new Animal("Jirafa","Hervíboro",45,1000,600);

        //Declaro tres variables para almacenar las proporciones
        double proptigre, propelefante, propjirafa;

        tigre.obtenLongyPeso();
        elefante.obtenEspyAli();
        jirafa.obtenEspyAli();

        proptigre = tigre.proporcion();
        propelefante = elefante.proporcion();
        propjirafa = jirafa.proporcion();

        System.out.println("Las proporciones de tigre, elefante y jirafa son: " + proptigre + ", "+propelefante+" y "+propjirafa);
        tigre.esLongevo();
        elefante.esLongevo();
        jirafa.esLongevo();

        Pez trucha = new Pez("pez","comida");
        trucha.fijaTipo("Azul");
        trucha.fijaProfMax(150);
        
        System.out.println(trucha.toString());
    }
}
