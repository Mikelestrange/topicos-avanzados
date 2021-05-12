//Hecho por: Miguel Angel Perez Anacleto
package hilosjava;
import java.util.Scanner;

public class Principal{

    public static void main(String[] args) {
        Hilo1 uno;
        Hilo2 dos;
        Hilo3 tres;
        int tamaño;
        Scanner leer = new Scanner(System.in);

        System.out.println("HILOS");
        System.out.println("Ingrese el tamaño de un vector: ");
        tamaño = leer.nextInt();
        uno = new Hilo1(tamaño);
        dos = new Hilo2(tamaño);
        tres = new Hilo3(tamaño);
        uno.start();
        dos.start();
        tres.start();
        try {
            uno.join(); 
            dos.join();
            tres.join();
        } 
        catch (InterruptedException e) {
        }
        System.out.println("Suma del vector del Hilo 1: " + uno.suma);
        System.out.println("Suma de cuadrados del vector del Hilo 2: " + dos.suma);
        System.out.println("Media del vector del Hilo 3: " + tres.media);
    }
}