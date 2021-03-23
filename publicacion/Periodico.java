//hecho por: Miguel Angel Perez Anacleto
package publicacion;

public class Periodico extends Publicacion implements Periodicidad
{
    private String fechaPub,editorial;
    
    public String getFecha(){
     return fechaPub;
    }
    
    public void setFecha(String fecha){
        fechaPub = fecha;
    }
    
    public String getEditorial(){
     return editorial;
    }
    
    public void setEditorial(String edi){
        editorial = edi;
    }    
   @Override
    public String getPeriodicidad()//implementación del método
    {
     return periodicidad;
    }
        
  }