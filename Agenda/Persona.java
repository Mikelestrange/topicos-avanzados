//Hecho por Miguel Angel Perez Anacleto

public class Persona{
   private String Nombre;
   private String Apellidos;
   private String Telefono;
   private String Direccion;
   private String Cumplea�os;
   private String Tipo;
   public String getNombre(){
      return Nombre;
   }
   public void setNombre(String nombre){
      this.Nombre = nombre;
   }
   public String getApellidos(){
      return Apellidos;
   }
   public void setApellidos(String apellidos){
      this.Apellidos = apellidos;
   }
   public String getTelefono(){
      return Telefono;
   }
   public void setTelefono(String telefono){
      this.Telefono = telefono;
   }
   public String getDireccion(){
      return Direccion;
   } 
   public void setDireccion(String direccion){
      this.Direccion = direccion;
   }
   public String getCumplea�os(){
      return Cumplea�os;
   }
   public void setCumplea�os(String cumplea�os){
      this.Cumplea�os = cumplea�os;
   }
   public String getTipo(){
      return Tipo;
   }
   public void setTipo(String tipo){
      this.Tipo = tipo;
   }      
}