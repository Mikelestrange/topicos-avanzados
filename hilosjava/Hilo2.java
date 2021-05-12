package hilosjava;

public class Hilo2 extends Thread {

   int suma;
   int vector[]; 

   public Hilo2(int tama�o) {
      vector= new int[tama�o];
      for(int i = 0; i < tama�o; i++) {
         vector[i] = (int)(Math.random() * 100.0);
      }
   }
 
   public void run() {
      int cuadrado;
      System.out.println("Comienza el hilo 2\nVector:");
      for (int i = 0; i < vector.length; i++) {
         cuadrado= vector[i]*vector[i];
         System.out.printf("[2.%d] : %d  Cuadrado = %d\n",i+1,vector[i],cuadrado);
         suma += cuadrado;
      }
   }
}