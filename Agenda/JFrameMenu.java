//Hecho por Miguel Angel Perez Anacleto

import javax.swing.*;
import java.awt.*;

public class JFrameMenu extends JFrame{
   Menu menu= new Menu();
   public JFrameMenu(){
      initComponents();
   }
   private void initComponents(){
      setSize(200,200);
      setTitle("MENU");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setContentPane(menu);
      setVisible(true);
   }
} 