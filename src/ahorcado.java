import java.util.Scanner;
import java.util.Random;

public class ahorcado {

    public static void main(String[] args) {
        final int intentotal = 7; // Constante con fallos limitados
        int intentos = 0;
        int aciertos = 0;
        // Para leer por teclado
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        char resp;
        // Random para agarrar una palabra al azar
        Random ram = new Random();
        // Creamos array de palabras y le asignamos una aleatoria
        String arrayPalabras[] = {"amor", "armonia", "esquizofobico", "letra", "perro", "lento", "cama", "mujer", "desarrollador", "taza", "cancion", "regla", "playa", "mar", "patineta", "pantalon", "auto", "cerveza", "telefono", "llave", "cargador", "volcan", "ciencia", "silla", "asiento", "computadora", "pulmon", "sopa", "zorro", "lengua", "manteca", "celular", "mendoza"};
        do {
            // Desarmamos la palabra y la guardamos en un array de caracteres
            int alea = ram.nextInt(33);
            char[] desarmada = desarma(arrayPalabras[alea]);
            char[] copia = desarma(arrayPalabras[alea]); // Aux para despues.
            // Array para imprimir en pantalla
            char[] turesp = new char[desarmada.length];

            // Rellenamos palabras con guiones
            for (int i = 0; i < turesp.length; i++) {
                turesp[i] = '_';
            }

            System.out.println("Adivina la palabra!");
            System.out.println("Sólo tienes 7 intentos.");

            // Mientras que no nos pasemos con los intentos y no la acertemos...
            while (intentos < intentotal && aciertos != turesp.length) {
                imprimeOculta(turesp);
                // Preguntamos carateres por teclado
                System.out.println("\nIntroduce una letra: ");
                resp = leer.next().toLowerCase().charAt(0);
                // Recorremos el array y comprobamos si se ha producido un acierto
                for (int i = 0; i < desarmada.length; i++) {
                    if (resp == turesp[i]) {
                        System.out.println("La letra ingresada ya se ingresó anteriormente.");
                        intentos--;
                        break;
                    }else {
                        if (desarmada[i] == resp) {
                            turesp[i] = desarmada[i];
                            desarmada[i] = ' ';
                            aciertos++;
                            intentos--;
                        }
                    }
                }
                intentos++;
                System.out.println("Quedan: "+ (intentotal-intentos)+ " intentos");
            }

            // Si hemos acertado todas imprimimos un mensaje
            if (aciertos == turesp.length) {
                System.out.print("\nFelicidades!! Acertaste la palabra: ");
                imprimeOculta(turesp);
            } else {
                System.out.print("\nPerdiste! la palabra era: ");
                for (int i = 0; i < copia.length; i++) {
                    System.out.print(copia[i] + " ");
                }
            }

            // Reseteamos contadores
            intentos = 0;
            aciertos = 0;
            // Preguntamos al usuario si quiere volver a jugar
            resp = pregunta("\n\nQuieres volver a jugar?", leer);
        } while (resp != 'n');

    }

    // Esto desarma el String en un array de caracteres.
    private static char[] desarma(String palazar) {
        char[] letras;
        letras = new char[palazar.length()];
        for (int i = 0; i < palazar.length(); i++) {
            letras[i] = palazar.charAt(i);
        }
        return letras;
    }

    // Esto imprime la palabra con espacios
    private static void imprimeOculta(char[] turesp) {

        for (int i = 0; i < turesp.length; i++) {
            System.out.print(turesp[i] + " ");
        }
    }

    //Esto nos pregunta si queremos volver a jugar y comprueba los caractere introducidos
    public static char pregunta(String men, Scanner leer) {
        char resp;
        System.out.println(men + " (s/n)");
        resp = leer.next().toLowerCase().charAt(0);
        while (resp != 's' && resp != 'n') {
            System.out.println("Error! solo se admite S o N");
            resp = leer.next().toLowerCase().charAt(0);
        }
        return resp;
    }
}