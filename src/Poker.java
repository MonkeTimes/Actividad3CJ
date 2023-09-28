//Clase Poker (main)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        //Inicializa una nueva variable de tipo deck e inicializa las 52 cartas
        Deck deck = new Deck();
        //Revuelve las cartas llamado el metodo shuffle de la clase deck
        deck.shuffle();

        //Variables que van a crear el scanner para introducir datos y el booleano para determinar cuantas veces se va a hacer el procedimiento
        Scanner lectura = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            //mientras no se elija la cuarta opcion sigue el programa
            System.out.println("\nElija una acción:");
            System.out.println("1. Tomar una carta del tope del deck");
            System.out.println("2. Seleccionar una carta al azar");
            System.out.println("3. Repartir una mano de 5 cartas");
            System.out.println("4. Salir");

            //Lector del teclado
            int opcion = lectura.nextInt();

            //Switch break que manda a llamar los metodos de la clase deck
            switch (opcion) {
                case 1:
                    deck.head();
                    break;
                case 2:
                    deck.pick();
                    break;
                case 3:
                    deck.hand();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una acción válida.");
            }
        }

        //Despliega este mensaje cuando se selecciona la opcion 4
        System.out.println("¡Gracias por jugar!");
    }
}
