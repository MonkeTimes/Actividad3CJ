//Clase Deck
//Importo estas bibliotecas debido a que necesito utilizar distintos comandos relacionados, arraylist para crear las listas que contienen los datos de las cartas
import java.util.ArrayList;
//Collections para llamar al metodo shuffle el cual me va a permitir barajear las cartas o mas bien cambiar el orden de la lista de cards cuando empieza el programa
import java.util.Collections;
//ayuda a hacer listas, esta se utiliza por dos motivos, para cumplir con el requerimiento de la actividad debido a que esta biblioteca es parte de los collections framework y almacenan los arraylist creados cuando se crea el mazo y cuando se descartan cartas
import java.util.List;
//Se utiliza cuando se usa el metodo pick para que eliga una carta aleatoria en el mazo creado en la lista de card
import java.util.Random;
public class Deck {
    //creo las variables que van a almacenar los arraylists creados
    private List<Card> cards;
    private List<Card> discardedCards;

    //Creo el metodo deck el cual va a iniciar cada que se inicie el programa
    public Deck() {
        //inicio un arraylist para que se almacenen las 52 cartas, tanto para las que estan en mazo como las descartadas, hay que destacar que el arraylist es card y la lista donde se van a almacenar para que se usen en los siguientes metodos
        cards = new ArrayList<>();
        discardedCards = new ArrayList<>();
        //Aqui almaceno en un array palos y valores, en palos pongo las cuatro posibles atributos de una carta y en valores los posibles numeros
        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        // Aqui es en donde se inicializan las 52 cartas con un for, la razon por la que no cree un array con los dos colores es por este bucle, si lo hubiera intentado inicializar antes ese valor entonces me hubiera fallado este bucle iterando dos veces adicionales por los colores
        // Creo un for que recorre todos los valores de palos y los asigna a un variable llamada palo
        for (String palo : palos) {
            //Lo mismo que lo anterior pero con los valores
            for (String valor : valores) {
                // Aqui lo que ocurre es que se determina si el palo es corazones o diamantes y en caso de ser verdad lo pone de color rojo, en caso de que no lo pone de color negro
                String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? "Rojo" : "Negro";
                // En esta parte guarda el dato que se crea en el bucle, por ejemplo el primer registro que guardaria en card seria treboles, 2 y negro porque al recorre todos los arrays y guarda un dato de cada uno hasta que llega a los 52 cartas y les asigna los colores de la forma que mencione antes
                cards.add(new Card(palo, color, valor));
            }
        }
    }

    public void shuffle() {
        //Esta es el metodo que con la funcion shuffle de la biblioteca collections permite mezclar todos los registros dentro de una lista
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (!cards.isEmpty()) {
            //Bucle que sucede siempre que haya un registro en la lista de cartas, este por cada registro que se quita del array de cartas lo agrega al de las cartas desechadas
            Card card = cards.remove(0);
            discardedCards.add(card);
            System.out.println(card);
            //Se indica cuantas quedan
            System.out.println("Quedan " + cards.size() + " cartas en deck");
        } else {
            //Si ya no hay menciona que esta vacio
            System.out.println("El deck está vacío.");
        }
    }

    public void pick() {
        if (!cards.isEmpty()) {
            //En este elige un dato aleatorio de la lista de cartas
            Random random = new Random();
            //Aqui guarda este dato aleatorio en una variable llamada randomIndex y de la extension total de la lista de cartas
            int randomIndex = random.nextInt(cards.size());
            //Aqui guarda en card el valor aleatorio y ese mismo valor lo elimina de la lista de la cartas
            Card card = cards.remove(randomIndex);
            //Agrega esa carta a la lista de cartas descartadas
            discardedCards.add(card);
            //imprime en consola la carta que salio
            System.out.println(card);
            //Menciona cuantas cartas quedan
            System.out.println("Quedan " + cards.size() + " cartas en deck");
        } else {
            //Si no hay cartas hace este mensaje
            System.out.println("El deck está vacío.");
        }
    }

    public void hand() {
        //Metodo que consigue 5 cartas y las imprime en pantalla
        //Solo funciona si hay mas de 5 cartas o solo 5, en otro caso desplega el mensaje que aparece en else
        if (cards.size() >= 5) {
            //Bucle que hace lo mismo que el metodo de arriba pero 5 veces seguidas
            for (int i = 0; i < 5; i++) {
                //Quita las variables que se encuentran en el index creado
                Card card = cards.remove(0);
                //Agrega esos valores en el array de cartas desechadas
                discardedCards.add(card);
                //Imprime las cartas que se consiguieron
                System.out.println(card);
            }
            System.out.println("Quedan " + cards.size() + " cartas en deck");
        } else {
            System.out.println("No hay suficientes cartas para repartir una mano.");
        }
    }

    public int size() {
        return cards.size();
    }

    public int discardedSize() {
        return discardedCards.size();
    }
}
