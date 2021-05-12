package hilosjava;

public class Hilo3 extends Thread {

   int suma;
   float media;
   int vector[]; 

   public Hilo3(int tamaño) {
      vector= new int[tamaño];
      for(int i = 0; i < tamaño; i++) {
         vector[i] = (int)(Math.random() * 100.0);
      }
   }
 
   public void run() {
      int cuadrado;
      System.out.println("Comienza el hilo 3\nVector:");
      for (int i = 0; i < vector.length; i++) {
         cuadrado= vector[i]*vector[i];
         System.out.printf("[3.%d] : %d\n",i+1,vector[i]);
         suma += vector[i];
      }
      media= suma/vector.length;
   }
}