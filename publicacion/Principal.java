/*hecho por: Miguel Angel Perez Anacleto
   no realize la convercion del arreglo por un arraylist para mayor comodidad 
   pues para poder hacer la convercion tendria que hacer un arraylist para cada clase
*/
package publicacion;
import java.util.*;
public class Principal {
   static Object publicaciones [] = new Object[100];
   static int ctrlpub=0;
   static Scanner leer= new Scanner(System.in);
   public static void main(String[] args) {
      int opc,publi;
      System.out.println("PUBLICACIONES\n");
      do{
         System.out.println("\nMENU");
         System.out.println("[1] Dar de Alta una Publicacion ");
         System.out.println("[2] Mostrar Contenido ");
         System.out.println("[3] Salir ");
         System.out.print("Ingrese la Opcion a realizar[1-3]: ");
         opc= leer.nextInt();
         
         switch(opc){
            case 1: 
               System.out.print("\nIngrese el tipo de publicacion\n[1]Revista\n[2]Periodico\n[3]Libro\n ?=");
               publi= leer.nextInt();
               if(publi>0 && publi<4){
                   alta(publi);
               }
               else 
                  System.out.println("Opcion no valida"); 
               break;
            case 2:
               mostrarContenido();
               break;
            case 3:
               break;
            default: 
               System.out.println("Ingrese una opcion valida");
         }
      }
      while(opc!=3);
      System.out.print(" OPERACIONES TERMINADAS ");
   }
   public static void alta(int x){
      System.out.println("Captura de datos");
      String aux; 
      double f;
      int s;
      leer.nextLine();
      if(x==1){
         Revista revista = new Revista();
         System.out.print("ISSN: ");
         aux=leer.nextLine();
         revista.setISSN(aux);
         System.out.print("Titulo: ");
         aux=leer.nextLine();
         revista.setTitulo(aux);
         System.out.print("Precio: ");
         f=leer.nextDouble();
         revista.setPrecio(f);
         System.out.print("Numero: ");
         s=leer.nextInt();
         revista.setNumero(s);
         System.out.print("Año: ");
         s=leer.nextInt();
         revista.setAnio(s);
         System.out.print("Numero de paginas: ");
         s=leer.nextInt();
         revista.setNumpag(s);
         publicaciones [ctrlpub] = revista;
      }
      else if(x==3){
         Libro libro = new Libro();
         System.out.print("ISBN: ");
         aux=leer.nextLine();
         libro.setISBN(aux);
         System.out.print("Titulo: ");
         aux=leer.nextLine();
         libro.setTitulo(aux);
         System.out.print("Autor: ");
         aux=leer.nextLine();
         libro.setAutor(aux);
         System.out.print("Edicion: ");
         aux=leer.nextLine();
         libro.setEdicion(aux);
         System.out.print("Precio: ");
         f=leer.nextDouble();
         libro.setPrecio(f);
         System.out.print("Numero de paginas: ");
         s=leer.nextInt();
         libro.setNumpag(s);
         publicaciones [ctrlpub] = libro; 
      }
      else if(x==2){
         Periodico periodico= new Periodico();
         System.out.print("Titulo: ");
         aux=leer.nextLine();
         periodico.setTitulo(aux);
         System.out.print("Precio: ");
         f=leer.nextFloat();
         periodico.setPrecio(f);
         leer.nextLine();
         System.out.print("Fecha de Publicacion: ");
         aux=leer.nextLine();
         periodico.setFecha(aux);
         System.out.print("Editorial: ");
         aux=leer.nextLine();
         periodico.setEditorial(aux);
         System.out.print("Numero de paginas: ");
         s=leer.nextInt();
         periodico.setNumpag(s);
         publicaciones[ctrlpub] = periodico;
      }
      ctrlpub++;
   }     
   public static void mostrarContenido(){
      //Ahora mostramos el contenido del arreglo     
      
      //Mostrar el arreglo
      for(int i = 0; i < ctrlpub; i ++ ){
         System.out.println("  " + publicaciones [i].getClass());
         if(publicaciones[i] instanceof Revista){
            Revista rev1 = new Revista();
            
            rev1 = (Revista)publicaciones[i];
            System.out.println("----REVISTA----");
            System.out.println("ISSN " + rev1.getISSN());
            System.out.println("Titulo " + rev1.getTitulo());
            System.out.println("Precio " + rev1.getPrecio());
            System.out.println("Numero " + rev1.getNumero());
            System.out.println("Año " + rev1.getAnio());
            System.out.println("Numero de paginas " + rev1.getNumpag());
         }
         else if (publicaciones [i] instanceof Libro ){
            Libro lib = new Libro();
            lib = (Libro)publicaciones[i];
            System.out.println("---LIBRO---");
            System.out.println("ISBN " + lib.getISBN());
            System.out.println("Titulo " + lib.getTitulo());
            System.out.println("Precio " + lib.getPrecio());
            System.out.println("Edicion " + lib.getEdicion());
            System.out.println("Autor " + lib.getAutor());
            System.out.println("Numero de paginas " + lib.getNumpag());
         }
         else if (publicaciones [i] instanceof Periodico ){
            Periodico per = new Periodico();
            per = (Periodico)publicaciones[i];
            System.out.println("---PERIODICO---");
            System.out.println("Titulo " + per.getTitulo());
            System.out.println("Precio " + per.getPrecio());
            System.out.println("Editorial " + per.getEditorial());
            System.out.println("Fecha de publicacion " + per.getFecha());
            System.out.println("Numero de paginas " + per.getNumpag());
         }
      }
        
   }
}