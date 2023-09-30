package poker;
//Clase Card
public class Card {
    //defino atributos tipo string en donde se van a almacenar los datos que se encontraran en la clase Deck, ademas asi nos lo piden en la actividad
    private String palo;
    private String color;
    private String valor;

    //Estoy creando instancias de las variables para separarlas de las locales
    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    //Defino el getter que me va a servir para hacer llamar a la variable del palo cuando se use en otras clases
    public String getPalo() {
        return palo;
    }
    //El metodo getter que va a traer la variable de color cuando se use en otras clases
    public String getColor() {
        return color;
    }
    //El metodo getter que me va a traer la variable de valor cuando se use en otras clases
    public String getValor() {
        return valor;
    }


    public String toString() {
        return palo + "," + color + "," + valor;
    }
}
