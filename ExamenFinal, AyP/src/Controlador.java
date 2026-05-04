/*
 * Mely Delgado
 * O2023
 * Clase para darle vista a nuestra vista.
 */

import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Controlador extends Vista {
	
	public Controlador(String titulo) {
		super(titulo);
		aceptar.addActionListener(new EscuchaLeeArchivo());
	}
	
	public class EscuchaLeeArchivo implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent a) {
			Scanner lec;
			File miArchivo;
			ArrayList<String>palabrasArchivo= new ArrayList<String>();
			int n;
			String palabra, archivo;
			
			archivo=nombreAtxt.getText();
			miArchivo= new File(archivo);
			try {
				lec= new Scanner(miArchivo);
				n= lec.nextInt();
				for(int i=0; i<n; i++) {
					palabra= lec.next();
					if(palabra.length()>=5 && palabra.toLowerCase().contains("a"))
						palabrasArchivo.add(palabra);
				}
			} catch (Exception e) {
				System.out.println(e.toString());
				e.printStackTrace();
			}
			nombreAtxt.setText("");
			palabrasResp.setText(palabrasArchivo.toString());
		}
	}
	
    public static void main(String[] args) {
        Controlador yo = new Controlador("Editor de texto");
    }
}
