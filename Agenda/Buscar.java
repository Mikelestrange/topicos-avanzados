//Hecho por Miguel Angel Perez Anacleto

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Buscar extends JFrame implements ActionListener{
   ControlPersona cp=new ControlPersona();
   ArrayList<Persona> datosPer = new ArrayList<Persona>();
   JButton btnAceptar,btnCancelar, btnOk,btnMod,btnEliminar,btnGuardar,btnSalir,boton1,boton2;
   JTextField txtBuscar,txtNombre, txtApellidos, txtTelefono,txtDireccion,txtCumple;
   JFrameMenu jfm;
   JTable tabla;
   JPanel panel,panelOpc;
   JScrollPane scroll=new JScrollPane();
   JRadioButton amigo, conocido;
   boolean yo =false;
   int x;
   static String info[][],tipo="Amigo";
   public Buscar(){
      setSize(300,200);
      setTitle("Buscar");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new GridLayout(2,2));
      JLabel lblBuscar= new JLabel("Nombre: ",JLabel.RIGHT);
      txtBuscar = new JTextField(20);
      panel= new JPanel();
      panel.add(lblBuscar);
      panel.add(txtBuscar);

      btnAceptar= new JButton("Aceptar");
      btnAceptar.addActionListener(this);
      btnCancelar= new JButton("Cancelar");
      btnCancelar.addActionListener(this);
      panel.add(btnAceptar);
      panel.add(btnCancelar);
      setContentPane(panel);
      setVisible(true);
   }
   public void actionPerformed(ActionEvent e){
      if (e.getSource()==boton1){
         cp.eli(x-1);
         jfm= new JFrameMenu();
      }
      else{ 
         if (e.getSource()==boton2)
            jfm= new JFrameMenu();
      }
      if (e.getSource() == btnAceptar){
         if(txtBuscar.getText() == null || txtBuscar.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Debe de ingresar al menos el nombre de la persona",
            "Aviso", JOptionPane.INFORMATION_MESSAGE);
            txtBuscar.requestFocus();
         }
         else{
            
            mostrar();
            txtBuscar.setText(null);
         }
      }
      else
		   if (e.getSource() == btnCancelar) {
            jfm = new JFrameMenu(); 
       }
      if (e.getSource() == btnOk){
         jfm = new JFrameMenu();
      }
      else{ 
         if (e.getSource() == btnMod){         
            datos();
         }
         else 
            if (e.getSource() == btnEliminar){
               eliminar();
            }
      }       
      if (e.getSource() == btnGuardar){
         if(conocido.isSelected()){
            tipo="Conocido";
         }
         else{ 
            tipo="Amigo";
         }
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
               info[0][0]=txtNombre.getText();
               info[0][1]=txtApellidos.getText();
               info[0][2]=txtTelefono.getText();
               info[0][3]=txtDireccion.getText();
               info[0][4]=txtCumple.getText();
               info[0][5]= tipo;
               cp.mod(info,x-1);

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
   public void mostrar(){
      datosPer=cp.datos();
      info=buscarAr();
      if(yo){
         busqueda();
      }
      else{
         jfm =new JFrameMenu();
      }
   }
   public String [][] buscarAr(){
      int i=-1;
      x=0;
      String informacion[][]= new String[1][6],nom=txtBuscar.getText();
      Iterator<Persona> itrPersona = datosPer.iterator();
      while(itrPersona.hasNext()&& i==-1){
         Persona persona = itrPersona.next();
         if (nom.equals(persona.getNombre())){
            yo= true;
            i=0;
            
            informacion[i][0]=persona.getNombre(); 
            informacion[i][1]=persona.getApellidos();
            informacion[i][2]=persona.getTelefono();
            informacion[i][3]=persona.getDireccion(); 
            informacion[i][4]=persona.getCumpleaños();         
            informacion[i][5]=persona.getTipo();
         } 
         x++;
      }
      if(yo==false){
         JOptionPane.showMessageDialog(null, "No existen registros de este contacto",
            "Aviso", JOptionPane.INFORMATION_MESSAGE);
      }
      return informacion;
   }

   public void busqueda(){
      panel= new JPanel();
      String titulos [] = {"Nombre","Apellidos","Telefono","Direccion Electronica","Cumpleaños","Tipo"};
      setSize(300, 200);
      setTitle("Busqueda");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      panel.setLayout(new BorderLayout());
      
      tabla= new JTable(info,titulos);
      tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      scroll.setViewportView(tabla);
      panel.add(scroll,BorderLayout.CENTER);
      btnMod= new JButton("Modificar");
      btnMod.addActionListener(this);
      btnEliminar= new JButton("Eliminar");
      btnEliminar.addActionListener(this);
      btnOk= new JButton("Salir");
      btnOk.addActionListener(this);
      panelOpc= new JPanel();
      panelOpc.setLayout(new GridLayout(1, 3));
      panelOpc.add(btnMod);
      panelOpc.add(btnEliminar);      
      panelOpc.add(btnOk);
      panel.add(panelOpc,BorderLayout.SOUTH);
      setContentPane(panel);
      setVisible(true);
   }
   public void datos(){
      
      setSize(500,200);
      setTitle("DATOS PERSONALES");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      JLabel lblNombre= new JLabel("Nombre: ",JLabel.RIGHT);
      txtNombre= new JTextField(20);
      txtNombre.setText(info[0][0]);
      panel= new JPanel();
      panel.setLayout(new GridLayout(7, 2));
      panel.add(lblNombre);
      panel.add(txtNombre);
      JLabel lblApellidos = new JLabel("Apellidos: ",JLabel.RIGHT);
      txtApellidos = new JTextField(30);
      txtApellidos.setText(info[0][1]);
      panel.add(lblApellidos);
      panel.add(txtApellidos);
      JLabel lblTelefono = new JLabel("Celular: ",JLabel.RIGHT);
      txtTelefono = new JTextField(15);
      txtTelefono.setText(info[0][2]);
      panel.add(lblTelefono);
      panel.add(txtTelefono);
      JLabel lblDireccion= new JLabel("Direccion Electronica: ",JLabel.RIGHT);
      txtDireccion = new JTextField(30);
      txtDireccion.setText(info[0][3]);
      panel.add(lblDireccion);
      panel.add(txtDireccion);
      JLabel lblCumple= new JLabel("Fecha de cumpleaños: ",JLabel.RIGHT);
      txtCumple = new JTextField(20);
      txtCumple.setText(info[0][4]);
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
   public void eliminar(){
      setSize(500,200);
      setTitle("DESICION");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      boton1= new JButton("SI");
      boton2= new JButton("NO");
      JTextField texto= new JTextField("¿Desea Eliminar contacto?");
      JLabel lblNombre= new JLabel("Nombre: ",JLabel.RIGHT);
      panel= new JPanel();
      panel.setLayout(new GridLayout(2, 2));
      panel.add(texto);
      panelOpc=new JPanel();
      panelOpc.setLayout(new GridLayout(1, 2));
      boton1.addActionListener(this);
      boton2.addActionListener(this);
      panelOpc.add(boton1);
      panelOpc.add(boton2);
      panel.add(panelOpc);
      setContentPane(panel);
      setVisible(true);
   }
}