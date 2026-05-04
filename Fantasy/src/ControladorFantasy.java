/*
 * Mely Delgado
 * O2023
 * Clase para controlar lo que pasa en la vista de nuestro proyecto.
 */

import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextField;


public class ControladorFantasy  extends VistaFantasy{
	private Liga miLiga;
	String infoE;
	
	public ControladorFantasy(String nombre) {
		super(nombre);
		miLiga= new Liga("BFL", 2, 5, false);
		lecturaArchivo();
		    
		vistaLiga.addActionListener(new EscuchaVeLiga());
		altaEquipo.addActionListener(new EscuchaAltaEquipo());
		bajaEquipo.addActionListener(new EscuchaBajaEquipo());
		buscaEquipo.addActionListener(new EscuchaBuscaEquipo());
		altaJT.addActionListener(new EscuchaAltaJugadorTitular());
		altaJB.addActionListener(new EscuchaAltaJugadorBanca());
		bajaJT.addActionListener(new EscuchaBajaJugadorTitular());
		bajaJB.addActionListener(new EscuchaBajaJugadorBanca());
		buscaJT.addActionListener(new EscuchaBusquedaJugadorTitular());
		buscaJB.addActionListener(new EscuchaBusquedaJugadorBanca());
		altaStatsJT.addActionListener(new EscuchaAltaStatsJugadorTitular());
		altaStatsJB.addActionListener(new EscuchaAltaStatsJugadorBanca());
		altaJuego.addActionListener(new EscuchaAltaJuego());
		eliminaC.addActionListener(new EscuchaEliminaCorredorTitular());
		eliminaR.addActionListener(new EscuchaEliminaReceptorTitular());
		listaCollege.addActionListener(new EscuchaListaTitularesCollege());
		eliminaBW.addActionListener(new EscuchaEliminaTitularesByeWeek());
		cambiaTB.addActionListener(new EscuchaCambiaTitularPorBanca());
		bLimpiaT.addActionListener(new EscuchaLimpia());
	}
	
	public void limpiaEquipo() {
		nombreEtxt.setText("");
		directortxt.setText("");
		correotxt.setText("");
		partidotxt.setText("");
		resultadotxt.setText("");
		mejorDefCorrtxt.setText("");
		mejorDefRectxt.setText("");
		collegeListatxt.setText("");
		eliminaByeWeektxt.setText("");
	}
	
	public void limpiaJugador() {
		nombreEtxt.setText("");
		nombreJtxt.setText("");
		equipotxt.setText("");
		postxt.setText("");
		collegetxt.setText("");
		numerotxt.setText("");
		equipoContratxt.setText("");
		numTemptxt.setText("");
		statustxt.setText("");
		byeWeektxt.setText("");
		statstxt.setText("");
		semanatxt.setText("");	
	}

	public class Escucha Tan implement ActionListener{
		public void actionPerformed(ActionEvent a) {

	
	public class EscuchaVeLiga implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String resp;
		
		info.setText("");
		info.setText("");
		resp=miLiga.toString();
		info.setText(resp);
		//equipo.setEnabled(true);
		}	
	}
	
	public class EscuchaAltaEquipo implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, directorE, correoE;
		int equipos, semanas;
		boolean visibleLiga, resp;
		
		nombreEquipo=nombreEtxt.getText();
		directorE=directortxt.getText();
		correoE=correotxt.getText();
		resp=miLiga.altaEquipo(nombreEquipo, directorE, correoE);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("ALTA EQUIPO EXITOSA");
		else 
			notasResp.setText("ALTA EQUIPO NO EXITOSA");
		limpiaEquipo();
		}	
	}
	
	public class EscuchaBajaEquipo implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, directorE, correoE;
		int equipos, semanas;
		boolean visibleLiga, resp;
		
		nombreEquipo=nombreEtxt.getText();
		resp=miLiga.bajaEquipo(nombreEquipo);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("ALTA EQUIPO EXITOSA");
		else 
			notasResp.setText("ALTA EQUIPO NO EXITOSA");
		limpiaEquipo();
		}	
	}
	
	public class EscuchaBuscaEquipo implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo;
		boolean resp;
		
		nombreEquipo=nombreEtxt.getText();;
		resp=miLiga.buscaEquipo(nombreEquipo);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("EL EQUIPO SI ESTÁ");
		else 
			notasResp.setText("EL EQUIPO NO ESÁ");
		limpiaEquipo();
		}	
	}
	
	public class EscuchaAltaJugadorTitular implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, nombreJugador, nombreEquipoJ, posicion, collegeJ, numeroJugador, equipoEnContra, numeroTemporada, byeWeekJugador;
		int numJug, byeWeekJug, numeroTemp;
		boolean resp;
		char statusJug;
		
		nombreEquipo=nombreEtxt.getText();
		nombreJugador=nombreJtxt.getText();
		nombreEquipoJ=equipotxt.getText();
		posicion=postxt.getText();
		collegeJ=collegetxt.getText();
		numeroJugador=numerotxt.getText();
		numJug=Integer.parseInt(numeroJugador);
		equipoEnContra=equipoContratxt.getText();
		numeroTemporada=numTemptxt.getText();
		numeroTemp=Integer.parseInt(numeroTemporada);
		byeWeekJugador=byeWeektxt.getText();
		byeWeekJug=Integer.parseInt(byeWeekJugador);
		statusJug=statustxt.getText().charAt(0);
		resp=miLiga.altaJugadorTitular(nombreEquipo, nombreJugador, nombreEquipoJ, posicion, numJug, collegeJ, numeroTemp, byeWeekJug, equipoEnContra, statusJug);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("ALTA JUGADOR TITULAR EXITOSA");
		else 
			notasResp.setText("ALTA JUGADOR TITULAR NO EXITOSA");
		limpiaJugador();
		}	
	}
	
	public class EscuchaAltaJugadorBanca implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, nombreJugador, nombreEquipoJ, posicion, collegeJ, numeroJugador, equipoEnContra, numeroTemporada, byeWeekJugador;
		int numJug, byeWeekJug, numeroTemp;
		boolean resp;
		char statusJug;
		
		nombreEquipo=nombreEtxt.getText();
		nombreJugador=nombreJtxt.getText();
		nombreEquipoJ=equipotxt.getText();
		posicion=postxt.getText();
		collegeJ=collegetxt.getText();
		numeroJugador=numerotxt.getText();
		numJug=Integer.parseInt(numeroJugador);
		equipoEnContra=equipoContratxt.getText();
		numeroTemporada=numTemptxt.getText();
		numeroTemp=Integer.parseInt(numeroTemporada);
		byeWeekJugador=byeWeektxt.getText();
		byeWeekJug=Integer.parseInt(byeWeekJugador);
		statusJug=statustxt.getText().charAt(0);
		resp=miLiga.altaJugadorBanca(nombreEquipo, nombreJugador, nombreEquipoJ, posicion, numJug, collegeJ, numeroTemp, byeWeekJug, equipoEnContra, statusJug);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("ALTA JUGADOR BANCA EXITOSA");
		else 
			notasResp.setText("ALTA JUGADOR BANCA NO EXITOSA");
		limpiaJugador();
		}	
	}
	
	public class EscuchaBajaJugadorTitular implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, nombreJugador;
		boolean resp;
		
		nombreEquipo=nombreEtxt.getText();
		nombreJugador=nombreJtxt.getText();
		resp=miLiga.bajaJugadorTitular(nombreEquipo, nombreJugador);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("BAJA JUGADOR TITULAR EXITOSA");
		else 
			notasResp.setText("BAJA JUGADOR TITULAR NO EXITOSA");
		limpiaJugador();
		}	
	}
	
	public class EscuchaBajaJugadorBanca implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, nombreJugador;
		boolean resp;
		
		nombreEquipo=nombreEtxt.getText();
		nombreJugador=nombreJtxt.getText();
		resp=miLiga.bajaJugadorBanca(nombreEquipo, nombreJugador);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("BAJA JUGADOR BANCA EXITOSA");
		else 
			notasResp.setText("BAJA JUGADOR BANCA NO EXITOSA");
		limpiaJugador();
		}	
	}
	
	public class EscuchaBusquedaJugadorTitular implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, nombreJugador;
		boolean resp;
		
		nombreEquipo=nombreEtxt.getText();
		nombreJugador=nombreJtxt.getText();
		resp=miLiga.busquedaJugadorTitular(nombreEquipo, nombreJugador);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("EL JUGADOR TITULAR SI ESTÁ");
		else 
			notasResp.setText("EL JUGADOR TITULAR NO ESTÁ");
		limpiaJugador();
		}	
	}
	
	public class EscuchaBusquedaJugadorBanca implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, nombreJugador;
		boolean resp;
		
		nombreEquipo=nombreEtxt.getText();
		nombreJugador=nombreJtxt.getText();
		resp=miLiga.busquedaJugadorBanca(nombreEquipo, nombreJugador);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("EL JUGADOR BANCA SI ESTÁ");
		else 
			notasResp.setText("EL JUGADOR BANCA NO ESTÁ");
		limpiaJugador();
		}	
	}
	
	public class EscuchaAltaStatsJugadorTitular implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, nombreJugador, statsJugador, semanaStatsJugador;
		double statsJug;
		int semanaStatsJug;
		boolean resp;
		
		nombreEquipo=nombreEtxt.getText();
		nombreJugador=nombreJtxt.getText();
		statsJugador=statstxt.getText();
		statsJug=Double.parseDouble(statsJugador);
		semanaStatsJugador=semanatxt.getText();
		semanaStatsJug=Integer.parseInt(semanaStatsJugador);
		resp=miLiga.altaStatsJugadorTitular(nombreEquipo, nombreJugador, statsJug, semanaStatsJug);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("ALTA STATS TITULAR EXITOSA");
		else 
			notasResp.setText("ALTA STATS TITULAR NO EXITOSA");
		limpiaJugador();
		}	
	}
	
	public class EscuchaAltaStatsJugadorBanca implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, nombreJugador, statsJugador, semanaStatsJugador;
		double statsJug; 
		int semanaStatsJug;
		boolean resp;
		
		nombreEquipo=nombreEtxt.getText();
		nombreJugador=nombreJtxt.getText();
		statsJugador=statstxt.getText();
		statsJug=Double.parseDouble(statsJugador);
		semanaStatsJugador=semanatxt.getText();
		semanaStatsJug=Integer.parseInt(semanaStatsJugador);
		resp=miLiga.altaStatsJugadorBanca(nombreEquipo, nombreJugador, statsJug, semanaStatsJug);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("ALTA STATS BANCA EXITOSA");
		else 
			notasResp.setText("ALTA STATS BANCA NO EXITOSA");
		limpiaJugador();
		}	
	}
	
	public class EscuchaAltaJuego implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, nombreJugador, semanaPartidoEquipo;
		int semanaPartidoE;
		char resultadoPartidoE;
		boolean resp;
		
		nombreEquipo=nombreEtxt.getText();
		nombreJugador=nombreJtxt.getText();
		semanaPartidoEquipo=partidotxt.getText();
		semanaPartidoE=Integer.parseInt(semanaPartidoEquipo);
		resultadoPartidoE=resultadotxt.getText().charAt(0);
		resp=miLiga.altaJuego(nombreEquipo, resultadoPartidoE, semanaPartidoE);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("ALTA JUEGO EXITOSA");
		else 
			notasResp.setText("ALTA JUEGO NO EXITOSA");
		limpiaEquipo();
		}	
	}
	
	public class EscuchaEliminaCorredorTitular implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, mejorDefensaCorredores;
		ArrayList<String>resp=new ArrayList<String>();
		
		nombreEquipo=nombreEtxt.getText();
		mejorDefensaCorredores=mejorDefCorrtxt.getText();
		resp=miLiga.eliminaCorredorTitularPorDefensa(nombreEquipo, mejorDefensaCorredores);
		notasResp.setText("");
		notasResp.setText("Los corredores eliminados por defensa son: "+resp);
		limpiaEquipo();
		}	
	}
	
	public class EscuchaEliminaReceptorTitular implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, mejorDefensaReceptores;
		ArrayList<String>resp=new ArrayList<String>();
		
		nombreEquipo=nombreEtxt.getText();
		mejorDefensaReceptores=mejorDefRectxt.getText();
		resp=miLiga.eliminaReceptorTitularPorDefensa(nombreEquipo, mejorDefensaReceptores);
		notasResp.setText("");
		notasResp.setText("Los receptores eliminados por defensa son: "+resp);
		limpiaEquipo();
		}	
	}
	
	public class EscuchaListaTitularesCollege implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, collegeParaLista;
		ArrayList<String>resp=new ArrayList<String>();
		
		nombreEquipo=nombreEtxt.getText();
		collegeParaLista=collegeListatxt.getText();
		resp=miLiga.listaJugadoresCollege(nombreEquipo, collegeParaLista);
		notasResp.setText("");
		notasResp.setText("La lista de los jugadores que están en el college es: "+resp);
		limpiaEquipo();
		}	
	}
	
	public class EscuchaEliminaTitularesByeWeek implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, byeWeekParaEliminar;
		int byeWeekParaEli;
		ArrayList<String>resp=new ArrayList<String>();
		
		nombreEquipo=nombreEtxt.getText();
		byeWeekParaEliminar=eliminaByeWeektxt.getText();
		byeWeekParaEli=Integer.parseInt(byeWeekParaEliminar);
		resp=miLiga.eliminaTitularPorByeWeek(nombreEquipo, byeWeekParaEli);
		notasResp.setText("");
		notasResp.setText("Los titulares eliminados por que están en su byeWeek son: "+resp);
		limpiaEquipo();
		}	
	}
	
	public class EscuchaCambiaTitularPorBanca implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String nombreEquipo, nombreJugadorTitular, nombreJugadorBanca;
		boolean resp;
		
		nombreEquipo=nombreEtxt.getText();
		nombreJugadorTitular=nombreJtxt.getText();
		nombreJugadorBanca=nombreJtxt.getText();
		resp=miLiga.cambiaTitularPorBanca(nombreEquipo, nombreJugadorTitular, nombreJugadorBanca);
		notasResp.setText("");
		if(resp==true)
			notasResp.setText("CAMBIO EXITOSO");
		else 
			notasResp.setText("CAMBIO NO EXITOSO");
		limpiaJugador();
		}	
	}
	
	public class EscuchaLimpia implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			nombreEtxt.setText("");
			directortxt.setText("");
			correotxt.setText("");
			partidotxt.setText("");
			resultadotxt.setText("");
			mejorDefCorrtxt.setText("");
			mejorDefRectxt.setText("");
			collegeListatxt.setText("");
			eliminaByeWeektxt.setText("");
			nombreJtxt.setText("");
			equipotxt.setText("");
			postxt.setText("");
			collegetxt.setText("");
			numerotxt.setText("");
			equipoContratxt.setText("");
			numTemptxt.setText("");
			statustxt.setText("");
			byeWeektxt.setText("");
			statstxt.setText("");
			semanatxt.setText("");
		}	
	}
	
	private void lecturaArchivo() {
		Scanner lec;
		File miArchivo;
		int n;
		String nombreE, director, correo, nombreJ, equipo, pos, college, equipoContra;
		int numero, numTemp, byeWeek;
		char status;
		boolean resp=true, altaResp=true, respAltaT=true, respAltaB=true, encontreE=true, respBajaT=true, respBajaB=true;
		Liga l1;
		
		l1= new Liga ("Lfl", 5, 5, true);
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
				respAltaB=miLiga.altaJugadorBanca(nombreE, nombreJ, equipo, pos, numero, college, numTemp, byeWeek, equipoContra, status);
				if(respAltaB)
					System.out.println("Alta jugador banca EXITOSA");
				else
					System.out.println("Alta jugador banca NO EXITOSA");
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
		}catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
	}
	}
a
    public static void main(String[] args) {
        ControladorFantasy yo = new ControladorFantasy("Fantasy");
    }
}
