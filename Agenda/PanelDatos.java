//Hecho por Miguel Angel Perez Anacleto

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelDatos extends JFrame implements ActionListener{
   JPanel panel;
   JButton btnGuardar,btnSalir;
   JTextField txtNombre, txtApellidos, txtTelefono,txtDireccion,txtCumple;
   JRadioButton amigo, conocido;
   ControlPersona datos = new ControlPersona();
   JFrameMenu jfm;
   public PanelDatos(){
      initComponents();     
   }
   private void initComponents(){
      setSize(500,200);
      setTitle("DATOS PERSONALES");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      JLabel lblNombre= new JLabel("Nombre: ",JLabel.RIGHT);
      txtNombre= new JTextField(20);
      panel= new JPanel();
      panel.setLayout(new GridLayout(7, 2));
      panel.add(lblNombre);
      panel.add(txtNombre);
      JLabel lblApellidos = new JLabel("Apellidos: ",JLabel.RIGHT);
      txtApellidos = new JTextField(30);
      panel.add(lblApellidos);
      panel.add(txtApellidos);
      JLabel lblTelefono = new JLabel("Celular: ",JLabel.RIGHT);
      txtTelefono = new JTextField(15);
      panel.add(lblTelefono);
      panel.add(txtTelefono);
      JLabel lblDireccion= new JLabel("Direccion Electronica: ",JLabel.RIGHT);
      txtDireccion = new JTextField(30);
      panel.add(lblDireccion);
      panel.add(txtDireccion);
      JLabel lblCumple= new JLabel("Fecha de cumpleaños: ",JLabel.RIGHT);
      txtCumple = new JTextField(20);
      panel.add(lblCumple);
      panel.add(txtCumple);
      ButtonGroup gpoBotones = new ButtonGroup();
      amigo = new JRadioButton("Amigo" ,true);
      conocido = new JRadioButton("Conocido" );
      gpoBotones.add(amigo);
      gpoBotones.add(conocido);
      
      panel.add(amigo);
      panel.add(conocido);

      btnGuardar= new JButton("Guardar");
      btnGuardar.addActionListener(this);
      btnSalir= new JButton("Salir");
      btnSalir.addActionListener(this);
      panel.add(btnGuardar);
      panel.add(btnSalir);
      
      setContentPane(panel);
      setVisible(true);
   }
   public void actionPerformed(ActionEvent e){
      String tipo="Amigo";
      if(conocido.isSelected())
         tipo="Conocido";
    
      if (e.getSource() == btnGuardar){
         if(txtNombre.getText() == null || txtNombre.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Debe de ir al menos el nombre de la persona",
            "Aviso", JOptionPane.INFORMATION_MESSAGE);
            txtNombre.requestFocus();
         }
         else
            if((txtTelefono.getText() == null ||txtTelefono.getText().isEmpty())&& (txtDireccion.getText() == null||txtDireccion.getText().isEmpty())){
               JOptionPane.showMessageDialog(null, "Se debe de colocar el teléfono o la direccion electronica de la persona",
               "Aviso", JOptionPane.INFORMATION_MESSAGE);
               txtTelefono.requestFocus();
            }
            else{
               datos.agregar(txtNombre.getText(), txtApellidos.getText(),
               txtTelefono.getText(),txtDireccion.getText(),txtCumple.getText(),tipo);
               JOptionPane.showMessageDialog(null, "Se guardarán los datos");	
               txtNombre.setText(null);
               txtApellidos.setText(null);
               txtTelefono.setText(null);
               txtDireccion.setText(null);
               txtCumple.setText(null);
               jfm = new JFrameMenu(); 
            }
      }
		if (e.getSource() == btnSalir) {
         jfm = new JFrameMenu(); 
      }
   }
}