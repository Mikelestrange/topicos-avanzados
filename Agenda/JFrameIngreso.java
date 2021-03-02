//Hecho por Miguel Angel Perez Anacleto

import javax.swing.*;
import java.awt.*;

public class JFrameIngreso extends JFrame{
   Ingreso pi = new Ingreso();
   public JFrameIngreso(){
      initComponents();
      
   }
   private void initComponents(){
      setSize(300,200);
      setTitle("Usuario y contaseña");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setContentPane(pi);
      setVisible(true);
   }
} 