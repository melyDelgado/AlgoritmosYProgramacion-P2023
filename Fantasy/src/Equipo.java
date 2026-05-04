/*
 * Mely Delgado
 * O2023
 * Clase para describir a un equipo, dar de alta jugadores, dar de baja en base a muchos facotres y para poder tomar decisiones en base a las estadísticas, bye week, etc.
 */

import java.util.ArrayList;
import java.util.Objects;

public class Equipo implements Comparable<Equipo> {
	private String nombre; //Nombre del equipo
	private String director; //Persona que lo controla.
	private String correo;
	private Jugador[] titulares;
	private Jugador[] banca; 
	private char[] juegos;
	private final int MAX_TITULAR = 5;
	private final int MAX_BANCA = 5;
	private final int MAX_JUEGOS = 5;
	private int ocupadosT;
	private int ocupadosB;

	public Equipo(String nombre) {
		titulares = new Jugador[MAX_TITULAR];
		banca = new Jugador[MAX_BANCA];
		juegos = new char[MAX_JUEGOS];
		ocupadosT= 0;
		ocupadosB=0;
		this.nombre=nombre;
	}

	public Equipo(String nombre, String director, String correo) {
		this(nombre);
		this.nombre = nombre;
		this.director = director;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDirector() {
		return director;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public int compareTo(Equipo otro) {
		int resp;

		if (nombre.equals(otro.nombre))
			resp = 0;
		else if (nombre.compareToIgnoreCase(otro.nombre) > 0)
			resp = 89;
		else
			resp = -8;
		return resp;
	}

	public String toString() {
		StringBuilder sb= new StringBuilder();
		
		sb.append("\nEquipo");
		sb.append("\nNombre: "+nombre);
		sb.append("\nDirector: "+director);
		sb.append("\nCorreo: "+correo);
		sb.append("\nTitulares:");
		for(int i=0;i<MAX_TITULAR; i++) 
			sb.append("\n"+(i+1)+". "+titulares[i]);
		sb.append("\nBanca: ");
		for(int j=0;j<MAX_BANCA; j++)
			sb.append("\n"+(j+1)+". "+banca[j]);
		sb.append("\nJuegos:");
		for(int l=0;l<MAX_JUEGOS; l++)
			sb.append("\n"+(l+1)+". "+juegos[l]);
		sb.append("\n");
		return sb.toString();
	}
	
	//Método para dar de alta un jugador titular, que puede jugar en otras semanas pero ahora está fuera del juego. Usamos el manejador arreglos genéricos.
	public boolean altaJugadorTitular(String nombre, String equipo, String pos, int numero, String college, int numTemp, int byeWeek, String equipoContra, char status) {
		boolean resp;
		Jugador uno;
		int posT;
		
		if(ocupadosT<MAX_TITULAR){
			uno=new Jugador(nombre, equipo, pos, numero, college, numTemp, byeWeek, equipoContra, status);
			posT=ManejadorArreglosGenericos.buscaSecuencialOrdenada(titulares, ocupadosT, uno);
			if(posT==-1 && uno.getStatus()=='A') {
				resp=true;
				titulares[ocupadosT]= uno;
				ocupadosT++;
			}
			else
				resp=false;
		}
		else
			resp=false;
		return resp;
	}
	
	//Método para dar de alta un jugador en la banca, que puede jugar en otras semanas pero ahora está fuera del juego. Usamos el manejador arreglos genéricos.
	public boolean altaJugadorBanca(String nombre, String equipo, String pos, int numero, String college, int numTemp, int byeWeek, String equipoContra, char status) { 	
		boolean resp;
		Jugador uno;
		int posT;
		
		if(ocupadosB<MAX_BANCA){
			uno=new Jugador(nombre, equipo, pos, numero, college, numTemp, byeWeek, equipoContra, status);
			posT=ManejadorArreglosGenericos.buscaSecuencialOrdenada(banca, ocupadosB, uno);
			if(posT==-1 && uno.getStatus()=='O') {
				resp=true;
				banca[ocupadosB]= uno;
				ocupadosB++;
			}
			else
				resp=false;
		} else
			resp=false;
		return resp;
	}	
	
	//Método para dar de baja un jugador titular usando el ManejadorArreglosGenéricos. 
	public boolean bajaJugadorTitular(String nombre) { 	
		boolean resp=false;
		int i=0, pos;
		Jugador uno;
		
		uno= new Jugador(nombre);
		pos=ManejadorArreglosGenericos.buscaSecuencialOrdenada(titulares, ocupadosT, uno);
		if(pos!=-1) {
			resp=true;
			titulares[pos]=null;
			ManejadorArreglosGenericos.unCorrimientoIzq(titulares, ocupadosT, pos);
			ocupadosT--;
		}
		else
			resp=false;
		
		return resp;
	}
	
	 //Método para dar de baja un jugador que esta en la banca con MaejadorArreglosGenéricos.
	public boolean bajaJugadorBanca(String nombre) {
		boolean resp=false;
		int i=0, pos;
		Jugador uno;
		
		uno= new Jugador(nombre);
		pos=ManejadorArreglosGenericos.buscaSecuencialOrdenada(banca, ocupadosB, uno);
		if(pos!=-1) {			
			resp=true;
			banca[pos]=null;
			ManejadorArreglosGenericos.unCorrimientoIzq(banca, ocupadosB, pos);
			ocupadosB--;
		}
		else
			resp=false;
		return resp;
	}	
	
	//Método para buscar un jugador titular.
	public boolean busquedaJugadorTitular(String nombre) { 
		int i=0;
		boolean encontre=false;
		
		while(i<ocupadosT && !encontre) {
			if(titulares[i].getNombre().equals(nombre))
				encontre = true;
			else
				encontre=false;
			i++;
		}
		return encontre;
	}
	
	//Método para buscar un jugador en la banca.
	public boolean busquedaJugadorBanca(String nombre) { 
		int i=0;
		boolean encontre=false;
		
		while(i<ocupadosB && !encontre) {
			if(banca[i].getNombre().equals(nombre))
				encontre = true;
			else
				encontre=false;
			i++;
		}
		return encontre;
	}
	
	//Método para dar de alta stats a los jugadores titulares.
	public boolean altaStatsJugadorTitular(String nombre, double stat, int semana) { 
		boolean resp=false, encontre=false; 
		int i=0, pos = 0;
		
		if(semana<=MAX_JUEGOS) {
			while(i<ocupadosT && !encontre) {
				if(titulares[i].getNombre().equals(nombre)) {
					encontre=true;
					pos=i;
				}
				if(encontre && i<=MAX_JUEGOS) {
					resp=true;
					titulares[pos].altaStats(stat, semana);
				}
				i++;
			}
		}
		return resp;
	}
	
	//Método para dar de alta stats a los jugadores banca.
	public boolean altaStatsJugadorBanca(String nombre, double stat, int semana) { 
		boolean resp=false, encontre=false; 
		int i=0, pos = 0;
		
		if(semana<=MAX_JUEGOS) {
			while(i<ocupadosB && !encontre) {
				if(titulares[i].getNombre().equals(nombre)) {
					encontre=true;
					pos=i;
				}
				if(encontre && i<=MAX_JUEGOS) {
					resp=true;
					banca[pos].altaStats(stat, semana);
				}
				i++;
			}
		}
		return resp;
	}
	
	//Método para decir si el equipo ganó o perdió.
	public boolean altaJuego(char resultado, int partido) {
		boolean resp;
		
		if(partido<=MAX_JUEGOS) {
			resp=true;
			juegos[partido-1]=resultado;
		}
		else
			resp=false;
		return resp;
	}
	
	//Método para eliminar a los corredores titulares que van contra una defensa difícil y regresa una lista, para que sepas que jugadores eliminó. Si está vaciío, no eliminó nada.
	public ArrayList<String> bajaCorredorTitularPorDefensa(String equipoContra) { 
		ArrayList<String>corredoresEliminados= new ArrayList<String>();
		
		for(int i=0; i<ocupadosT; i++) {
			if(titulares[i].getEquipoContra().equals(equipoContra) && titulares[i].getPos().equals("RB")) {
				corredoresEliminados.add(titulares[i].getNombre());
				titulares[i]=null; 
				ManejadorArreglosGenericos.unCorrimientoIzq(titulares, ocupadosT, i);
				ocupadosT--;
			}
		}
		return corredoresEliminados;
	}
	
	//Método para eliminar a los receptores titulares que van contra una defensa difícil y regresa una lista, para que sepas que jugadores eliminó. Si está vaciío, no eliminó nada.
	public ArrayList<String> bajaReceptorTitularPorDefensa(String equipoContra) { 
		ArrayList<String>receptoresEliminados= new ArrayList<String>();
		
		for(int i=0; i<ocupadosT; i++) {
			if(titulares[i].getEquipoContra().equals(equipoContra) && titulares[i].getPos().equals("WR")) {
				receptoresEliminados.add(titulares[i].getNombre());
				titulares[i]=null; 
				ManejadorArreglosGenericos.unCorrimientoIzq(titulares, ocupadosT, i);
				ocupadosT--;
			}
		}
		return receptoresEliminados;
	}
	
	//Método para eliminar a los jugadores que están en su byeWeek, y regresa una lista de los jugadores que eliminó. Si está vacía, no eliminó a nadie.
	public ArrayList<String> eliminaTitularPorByeWeek(int byeWeek) { 
		ArrayList<String>eliminadosPorByeWeek= new ArrayList<String>();
		
		for(int i=0; i<ocupadosT; i++) {
			if(titulares[i].getByeWeek()==byeWeek) {
				eliminadosPorByeWeek.add(titulares[i].getNombre());
				titulares[ocupadosT-1]=null; 
				ManejadorArreglosGenericos.unCorrimientoIzq(titulares, ocupadosT, i);
				ocupadosT--;
			}
		}
		return eliminadosPorByeWeek;
	}
	
	//Método que genera una lista para almacenar a los jugadores dados de alta, con el mismo college, y regresa la lista de los nombres de los jugadores.
	public ArrayList<String> listaJugadoresTitularesCollege(String college) { 
		ArrayList<String>titularesCollege= new ArrayList<String>();
		
		for(int i=0;i<ocupadosT;i++)
			if(titulares[i].getCollege().equals(college))
				titularesCollege.add(titulares[i].getNombre());
		return titularesCollege;
	}
	
	//Cambia a algún jugador de la banca a titular siempre y cuando el status del jugador en la banca sea 'A'(active).
	public boolean cambiaTitularPorBanca(String titular, String sbanca) { 
		boolean resp=false;
		int posT, posB;
		Jugador nuevoT, nuevoB;
		
		nuevoT= new Jugador(titular);
		nuevoB= new Jugador(sbanca);
		posT=ManejadorArreglosGenericos.buscaSecuencialOrdenada(titulares, ocupadosT, nuevoT);
		posB=ManejadorArreglosGenericos.buscaSecuencialOrdenada(banca, ocupadosB, nuevoB);
		if(posT!=-1 && posB!=-1 && nuevoB.getStatus()=='A') {
			nuevoT= titulares[posT];
			nuevoB= banca[posB];
			titulares[posT]=nuevoB;
			banca[posB]= nuevoT;
			resp=true;
		}
		else
			resp=false;
		return resp;
	}
	
}