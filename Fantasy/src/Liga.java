import java.util.ArrayList;
import java.util.Objects;

/*
 * Mely Delgado 
 * O2023
 * Clase par describir una liga, dar de alta equipos, etc.
 */
public class Liga {
	private String nombre;
	private Equipo[] equipos;
	private int semanas;
	private int numEquipos;
	private boolean visibleAlPublico;
	private int ocupados;
	
	public Liga() {
		ocupados=0;
	}
	
	public Liga(String nombre, int semanas, int numEquipos, boolean visibleAlPublico) {
		this();
		this.nombre=nombre;
		this.semanas=semanas;
		this.numEquipos=numEquipos;
		this.visibleAlPublico=visibleAlPublico;
		equipos= new Equipo[numEquipos];
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getSemanas() {
		return semanas;
	}
	
	public boolean getVisibleAlPublico() {
		return visibleAlPublico;
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
		Liga other = (Liga) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public int compareTo(Liga otra) {
		int resp;
		
		if(nombre.equals(otra.nombre))
			resp=0;
		else
			if(nombre.compareTo(otra.nombre)>0)
				resp=8;
			else
				resp=-89;
		return resp;
	}
	
	public String toString() {
		StringBuilder sb= new StringBuilder();
		
		sb.append("\nLiga");
		sb.append("\nNombre: "+nombre);
		sb.append("\nSemanas: "+semanas);
		sb.append("\nNumero de Equipos: "+numEquipos);
		sb.append("\nVisible Al Público: "+visibleAlPublico);
		for(int i=0;i<numEquipos; i++) 
			sb.append("\n"+(i+1)+". "+equipos[i]);
		sb.append("\n");
		return sb.toString();
	}
	
	public boolean altaEquipo(String nombre, String director, String correo) { //Método para dar de alta un Euipo en una liga.
		boolean resp;
		Equipo uno;
		int esta;
		
		if(ocupados<numEquipos) {
		uno= new Equipo(nombre, director, correo);
		esta= ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, uno);
		if(esta!=-1)
			resp=false;
		else {
			resp=true;
			equipos[ocupados]=uno;
			ocupados++;
			}
		}
		else
			resp=false;
		return resp;
	}
	
	public boolean bajaEquipo(String nombre) { //Método para dar de alta un Euipo en una liga.
		boolean resp;
		Equipo uno;
		int esta;
		
		uno= new Equipo(nombre);
		esta= ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, uno);
		if(esta==-1)
			resp=false;
		else {
			resp=true;
			equipos[ocupados]=null;
			ManejadorArreglosGenericos.unCorrimientoIzq(equipos, ocupados, esta);
			ocupados--;
			}
		return resp;
	}
	
	public boolean buscaEquipo(String nombre) {
		int i=0;
		boolean encontre=false;
		
		while(i<ocupados && !encontre) {
			if(equipos[i].getNombre().equals(nombre))
				encontre = true;
			else
				encontre=false;
			i++;
		}
		return encontre;
	}
	
	public boolean altaJugadorTitular(String nombreEquipo, String nombre, String equipo, String pos, int numero, String college, int numTemp, int byeWeek, String equipoContra, char status) {
		boolean resp=false;
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					equipos[posE].altaJugadorTitular(nombre, equipo, pos, numero, college, numTemp, byeWeek, equipoContra, status);
					resp=true;
				}
				else
					resp=false;
		}
		return resp;
	}
	
	public boolean altaJugadorBanca(String nombreEquipo, String nombre, String equipo, String pos, int numero, String college, int numTemp, int byeWeek, String equipoContra, char status) {
		boolean resp=false;
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					equipos[posE].altaJugadorBanca(nombre, equipo, pos, numero, college, numTemp, byeWeek, equipoContra, status);
					resp=true;
				}
				else
					resp=false;
		}
		return resp;
	}
	
	public boolean bajaJugadorTitular(String nombreEquipo, String nombre) {
		boolean resp=false;
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					equipos[posE].bajaJugadorTitular(nombre);
					resp=true;
				}
				else
					resp=false;
		}
		return resp;
	}
	
	public boolean bajaJugadorBanca(String nombreEquipo, String nombre) {
		boolean resp=false;
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					equipos[posE].bajaJugadorBanca(nombre);
					resp=true;
				}
				else
					resp=false;
		}
		return resp;
	}
	
	public boolean busquedaJugadorTitular(String nombreEquipo, String nombre) {
		boolean resp=false;
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					equipos[posE].busquedaJugadorTitular(nombre);
					resp=true;
				}
				else
					resp=false;
		}
		return resp;
	}	
	
	public boolean busquedaJugadorBanca(String nombreEquipo, String nombre) {
		boolean resp=false;
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					equipos[posE].busquedaJugadorBanca(nombre);
					resp=true;
				}
				else
					resp=false;
		}
		return resp;
	}
	
	public boolean altaStatsJugadorTitular(String nombreEquipo, String nombre, double stat, int semana) {
		boolean resp=false;
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					equipos[posE].altaStatsJugadorTitular(nombre, stat, semana);
					resp=true;
				}
				else
					resp=false;
		}
		return resp;
	}
	
	public boolean altaStatsJugadorBanca(String nombreEquipo, String nombre, double stat, int semana) {
		boolean resp=false;
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					equipos[posE].altaStatsJugadorBanca(nombre, stat, semana);
					resp=true;
				}
				else
					resp=false;
		}
		return resp;
	}
	
	public boolean altaJuego(String nombreEquipo, char resultado, int partido) {
		boolean resp=false;
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					equipos[posE].altaJuego(resultado, partido);
					resp=true;
				}
				else
					resp=false;
		}
		return resp;
	}
	
	public ArrayList<String> eliminaCorredorTitularPorDefensa(String nombreEquipo, String defensaContra) {
		ArrayList <String> corredoresEliminados= new ArrayList<String>();
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					corredoresEliminados= equipos[posE].bajaCorredorTitularPorDefensa(defensaContra);
				}
		}
		return corredoresEliminados;
	}
	
	public ArrayList<String> eliminaReceptorTitularPorDefensa(String nombreEquipo, String defensaContra) {
		ArrayList <String> receptoresEliminados= new ArrayList<String>();
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					receptoresEliminados= equipos[posE].bajaReceptorTitularPorDefensa(defensaContra);
				}
		}
		return receptoresEliminados;
	}
	
	public ArrayList<String> listaJugadoresCollege(String nombreEquipo, String college) {
		ArrayList <String> jugadoresCollege= new ArrayList<String>();
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					jugadoresCollege= equipos[posE].listaJugadoresTitularesCollege(college);
				}
		}
		return jugadoresCollege;
	}
	
	public ArrayList<String> eliminaTitularPorByeWeek(String nombreEquipo, int byeWeek) {
		ArrayList <String> eliminadosByeWeek= new ArrayList<String>();
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					eliminadosByeWeek= equipos[posE].eliminaTitularPorByeWeek(byeWeek);
				}
		}
		return eliminadosByeWeek;
	}
	
	public boolean cambiaTitularPorBanca(String nombreEquipo, String titular, String sbanca) {
		boolean resp=false;
		Equipo unE;
		int posE;
		
		if (ocupados<=numEquipos) {
			unE= new Equipo(nombreEquipo);
			posE=ManejadorArreglosGenericos.buscaSecuencialOrdenada(equipos, ocupados, unE);
				if(posE!=-1) {
					equipos[posE].cambiaTitularPorBanca(titular, sbanca);
					resp=true;
				}
				else
					resp=false;
		}
		return resp;
	}

}
