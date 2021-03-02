//Hecho por Miguel Angel Perez Anacleto

import javax.swing.*;
import java.awt.*;

public class JFrameMostrar extends JFrame{

   MostrarDatos mostrar = new MostrarDatos();
     
   public JFrameMostrar(){  
      initComponents();
   }
   
   private void initComponents(){
      setSize(300, 200);
      setTitle("Contactos Registrados");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setContentPane(mostrar);
      setVisible(true);
   }   
}