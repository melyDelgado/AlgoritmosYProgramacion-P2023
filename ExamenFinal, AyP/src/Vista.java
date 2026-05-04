/*
 * Mely Delgado
 * O2023
 * Clase para dibujar la vista que nos dan en el examne final.
 */

import java.awt.*;
import javax.swing.*;

public class Vista extends JFrame{
	protected JLabel nombreA, palabras;
	protected JButton aceptar;
	protected JTextArea palabrasResp;
	protected JTextField nombreAtxt;
	protected JPanel vista;
	protected JScrollPane scroll;
	
	public Vista(String titulo) {
		super(titulo);
		nombreA= new JLabel("Ingresa nombre del archivo: ");
		palabras= new JLabel("Palabras con más de 5 caracteres y que contengan la letra a: ");
		aceptar= new JButton("Aceptar");
		palabrasResp= new JTextArea(6,4);
		nombreAtxt= new JTextField(15);
		scroll= new JScrollPane(palabrasResp);
		
		vista= new JPanel(new GridLayout (5, 1, 10, 5));
		vista.add(nombreA);
		vista.add(nombreAtxt);
		vista.add(palabras);
		vista.add(scroll);
		vista.add(aceptar);
		vista.setSize(this.getWidth(), 50);
		vista.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		palabrasResp.setEditable(false);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		this.add(vista);
		this.setVisible(true);
		this.setBounds(10,10,800,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
