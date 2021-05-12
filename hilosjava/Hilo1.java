package hilosjava;

public class Hilo1 extends Thread {

   int suma;
   int vector[]; 

   public Hilo1(int tama�o) {
      vector= new int[tama�o];
      for(int i = 0; i < tama�o; i++) {
         vector[i] = (int)(Math.random() * 100.0);
      }
   }
 
   public void run() {
      System.out.println("Comienza el hilo 1\nVector:");
      for (int i = 0; i < vector.length; i++) {
         System.out.printf("[1.%d] : %d\n",i+1,vector[i]);
         suma += vector[i];
      }
   }
}