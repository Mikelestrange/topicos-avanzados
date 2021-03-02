//Hecho por Miguel Angel Perez Anacleto

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MostrarDatos extends JPanel implements ActionListener{
   
   JTable tabla;
   JButton btnOk;
   JScrollPane scroll=new JScrollPane();
   ControlPersona cp=new ControlPersona();
   ArrayList<Persona> datosPer = new ArrayList<Persona>();
   
   public MostrarDatos(){
      datosPer=cp.datos();
      String titulos [] = {"Nombre","Apellidos","Telefono","Direccion Electronica","Cumpleaños","Tipo"};
      String info[][]=obtenerDatos();
      setLayout(new BorderLayout());
      
      tabla = new JTable(info,titulos);
      tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      scroll.setViewportView(tabla);
      add(scroll,BorderLayout.CENTER);
      btnOk= new JButton("Aceptar");
      btnOk.addActionListener(this);
      add(btnOk,BorderLayout.SOUTH);
   }
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnOk){
         JFrameMenu si = new JFrameMenu();
      }
   }
   private String [][] obtenerDatos (){
      int x=0;
      String informacion[][]= new String[datosPer.size()][6];
      Iterator<Persona> itrPersona = datosPer.iterator();
      while(itrPersona.hasNext()){
         Persona persona = itrPersona.next();
         informacion[x][0]=persona.getNombre(); 
         informacion[x][1]=persona.getApellidos();
         informacion[x][2]=persona.getTelefono();
         informacion[x][3]=persona.getDireccion(); 
         informacion[x][4]=persona.getCumpleaños();         
         informacion[x][5]=persona.getTipo();
         x++;
      }
      return informacion;
   }

}