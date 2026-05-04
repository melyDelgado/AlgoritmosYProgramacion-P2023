/*
 * Mely Delgado
 * O2023
 * Clase para dibujar la clase tienda.
 */

import java.awt.*;

import javax.swing.*;

public class VistaTienda extends JFrame{
	JLabel nombreA, letra;
	JTextField nombreAtxt, letratxt;
	JButton buscar, borrar;
	JTextArea productos;
	JPanel vistaProductos;
	
	public VistaTienda(String titulo) {
		super(titulo);
		nombreA= new JLabel("Nombre del Archivo:");
		letra= new JLabel("Letra:");
		nombreAtxt= new JTextField(15);
		letratxt= new JTextField(15);
		buscar= new JButton("Buscar");
		borrar= new JButton("Borrar");
		productos= new JTextArea(6,4);
		
		
		vistaProductos= new JPanel(new GridLayout(4, 2, 10, 5));
		vistaProductos.add(nombreA);
		vistaProductos.add(nombreAtxt);
		vistaProductos.add(letra);
		vistaProductos.add(letratxt);
		vistaProductos.add(buscar);
		vistaProductos.add(borrar);
		vistaProductos.add(productos);
		
		this.add(vistaProductos);
		this.setVisible(true);
		this.setBounds(10,10, 500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
