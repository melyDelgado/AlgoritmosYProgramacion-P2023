/*
 *  * Mely Delgado 
 * O2023
 * Clase para darke funcionalidad a nuestra VistaTienda.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControladorTienda extends VistaTienda{
	
	public ControladorTienda(String titulo) {
		super(titulo);
		buscar.addActionListener(new EscuchaLeeArchivo());
		borrar.addActionListener(new EscuchaLimpiaCasillas());
	}
	
	public class EscuchaLeeArchivo implements ActionListener {
		public void actionPerformed (ActionEvent a) {
			Scanner lec;
			File miArchivo;
			ArrayList<String>lista= new ArrayList<String>();
			String nombreArchivo, producto, letraDada;
			int n;
			
			nombreArchivo= nombreAtxt.getText();
			letraDada= letratxt.getText();
			miArchivo= new File (nombreArchivo);
			try {
				lec= new Scanner(miArchivo);
				n= lec.nextInt();
				for(int i=0; i<n; i++) {
					producto= lec.next();
					if(producto.toLowerCase().startsWith(letraDada)) 
						lista.add(producto);
				}
			} catch (Exception e) {
				System.out.println(e.toString());
				e.printStackTrace();
			}
			productos.setText(lista.toString());
		}
	}
	
	public class EscuchaLimpiaCasillas implements ActionListener{
		
		public void actionPerformed (ActionEvent a) {
			letratxt.setText("");
			nombreAtxt.setText("");
		}
	}

	public static void main(String[] args) {
		ControladorTienda yo= new ControladorTienda("Tiendita");
	}

}
