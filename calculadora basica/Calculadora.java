//Autor: MIGUEL ANGEL PEREZ ANACLETO
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Calculadora extends JFrame{
   JTextField texto;
   double resultado;
	String operacion;
	JPanel panelNumeros, panelOperaciones;
	boolean nuevaOperacion = true;
	public Calculadora() {
		setSize(250, 400);
		setTitle("Calculadora Basica");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(new BorderLayout());
		texto = new JTextField("0", 20);
      texto.setLayout(new GridLayout(2, 1));
		texto.setHorizontalAlignment(JTextField.RIGHT);
		texto.setEditable(false);
		texto.setBackground(Color.ORANGE);
		panel.add("North", texto);

		panelNumeros = new JPanel();
		panelNumeros.setLayout(new GridLayout(6, 3));
      panelNumeros.setBackground(Color.white);
      
      botonNumero("9");
      botonNumero("8");
      botonNumero("7");
      botonNumero("6");
      botonNumero("5");
      botonNumero("4");
      botonNumero("3");
      botonNumero("2");
      botonNumero("1");
      botonNumero("0");
      botonNumero("00");
      botonNumero(".");
      botonNumero("");
      botonNumero("");
      botonNumero("");
      botonNumero("");
      botonNumero("");
      botonNumero("");      

		panel.add("Center", panelNumeros);

		panelOperaciones = new JPanel();
		panelOperaciones.setLayout(new GridLayout(6, 1));
      panelOperaciones.setBackground(Color.white);   
      botonOperacion("CE");
		botonOperacion("+");
		botonOperacion("-");
		botonOperacion("*");
		botonOperacion("/");
		botonOperacion("=");
      
		panel.add("East", panelOperaciones);

		validate();
	}
	private void botonNumero(String digito) {
		JButton boton = new JButton();
		boton.setText(digito);
      boton.setBackground(Color.WHITE);
		boton.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseReleased(MouseEvent evento) {
				JButton boton = (JButton) evento.getSource();
				numero(boton.getText());
			}
		});

		panelNumeros.add(boton);
	}
	private void botonOperacion(String operacion) {
		JButton boton = new JButton(operacion);
      if(operacion=="CE")
         boton.setBackground(Color.RED);
      else
         boton.setBackground(Color.GREEN);
		boton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				JButton boton = (JButton) evento.getSource();
				operacion(boton.getText());
			}
		});

		panelOperaciones.add(boton);
	}
	private void numero (String num) {
		if (texto.getText().equals("0") || nuevaOperacion) {
			texto.setText(num);
		} else {
			texto.setText(texto.getText() + num);
		}
		nuevaOperacion = false;
	}
	private void operacion(String op) {
		if (op.equals("=")) {
			calcularResultado();
		} else if (op.equals("CE")) {
			resultado = 0;
			texto.setText("");
			nuevaOperacion = true;
		} else {
			operacion = op;
			if ((resultado > 0) && !nuevaOperacion) {
				calcularResultado();
			} else {
				resultado = new Double(texto.getText());
			}
		}

		nuevaOperacion = true;
	}
	private void calcularResultado() {
		if (operacion.equals("+")) 
			resultado += new Double(texto.getText()); 
      else 
         if (operacion.equals("-")) 
		   	resultado -= new Double(texto.getText());
         else 
            if (operacion.equals("/")) 
			      resultado /= new Double(texto.getText());
            else 
               if (operacion.equals("*")) 
			         resultado *= new Double(texto.getText());
		texto.setText("" + resultado);
		operacion = "";
	}
}
