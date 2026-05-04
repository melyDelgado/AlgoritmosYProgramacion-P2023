/*
 * Mely Delgado
 * O2023
 * Clase para probar los métodos creados en un liga de fantasy.
 */

import java.io.File;
import java.util.Scanner;

public class PruebaLiga {

	public static void main(String[] args) {
		Liga l1;
		boolean resp=true, altaResp=true, respAltaT=true, respAltaB=true, encontreE=true, respBajaT=true, respBajaB=true;
		Scanner lec;
		File miArchivo;
		int n;
		String nombreE, director, correo, nombreJ, equipo, pos, college, equipoContra;
		int numero, numTemp, byeWeek;
		char status;
		
		l1= new Liga("BFL", 2, 2, false);
		miArchivo= new File("Datos.txt");
		try {
			lec= new Scanner(miArchivo);
			n=lec.nextInt(); //n es el primer dato del archivo
			for(int i=0; i<n;i++) {
				nombreE=lec.next();
				director=lec.next();
				correo=lec.next();
				altaResp=l1.altaEquipo(nombreE, director, correo);
				if(altaResp)
					System.out.println("Alta equipo EXITOSA");
				else
					System.out.println("Alta de equipo NO EXITOSA");
				nombreJ=lec.next();
				equipo=lec.next();
				pos=lec.next();
				numero=lec.nextInt();
				college=lec.next();
				numTemp=lec.nextInt();
				byeWeek=lec.nextInt();
				equipoContra=lec.next();
				status=lec.next().charAt(0);
				respAltaT=l1.altaJugadorTitular(nombreE, nombreJ, equipo, pos, numero, college, numTemp, byeWeek, equipoContra, status);
				if(respAltaT)
					System.out.println("Alta jugador titular EXITOSA");
				else
					System.out.println("Alta jugador titular  NO EXITOSA");
				nombreJ=lec.next();
				equipo=lec.next();
				pos=lec.next();
				numero=lec.nextInt();
				college=lec.next();
				numTemp=lec.nextInt();
				byeWeek=lec.nextInt();
				equipoContra=lec.next();
				status=lec.next().charAt(0);
				respAltaB=l1.altaJugadorBanca(nombreE, nombreJ, equipo, pos, numero, college, numTemp, byeWeek, equipoContra, status);
				if(respAltaB)
					System.out.println("Alta jugador banca EXITOSA");
				else
					System.out.println("Alta jugador banca NO EXITOSA");
		}
			System.out.println(l1.toString());

		}catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

}