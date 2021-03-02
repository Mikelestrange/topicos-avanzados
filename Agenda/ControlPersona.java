//Hecho por Miguel Angel Perez Anacleto

import java.util.*;
public class ControlPersona{
   static ArrayList<Persona> Arrperson = new ArrayList<Persona>(); 
   private Persona objPersona;
   
   public void agregar(String nom, String ap, String tel, String dir,String cumple, String tipo){
    
      objPersona = new Persona();
    
      objPersona.setNombre(nom);
      objPersona.setApellidos(ap);
      objPersona.setTelefono(tel);
      objPersona.setDireccion(dir);
      objPersona.setCumpleaños(cumple);
      objPersona.setTipo(tipo);
      Arrperson.add(objPersona);
   }
   public void mod(String[][] info, int x){
      objPersona= new Persona();
      
      objPersona.setNombre(info[0][0]);
      objPersona.setApellidos(info[0][1]);
      objPersona.setTelefono(info[0][2]);
      objPersona.setDireccion(info[0][3]);
      objPersona.setCumpleaños(info[0][4]);
      objPersona.setTipo(info[0][5]);
      Arrperson.set(x , objPersona);
   }
   public void eli(int x){
      Arrperson.remove(x);
   }
   public ArrayList datos(){
      return Arrperson;
   }
   
   public void mostrar(){
   
      System.out.println("... Personas en la Agenda ...");
      Iterator<Persona> itrPersona = Arrperson.iterator();
      while(itrPersona.hasNext()){
	      Persona persona = itrPersona.next();
	      System.out.println(persona.getNombre() + "  "
			   + persona.getApellidos() + "  "
			   + persona.getTelefono() + "  "
			   + persona.getDireccion() + "  "
            + persona.getCumpleaños() + "  "
            + persona.getTipo());
      }
   }
}