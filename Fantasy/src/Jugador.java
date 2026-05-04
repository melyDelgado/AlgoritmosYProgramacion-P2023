import java.util.Objects;

/*
 * Mely Delgado
 * O2023
 * Clase para describir a un jugador real de fútbol americano en términos de un fantasy, para tener un registro de nuestros jugadadores.
 */

public class Jugador  implements Comparable<Jugador>{
	private String nombre; //Nombre del jugador.
	private String equipo; //Nombre del equipo en el que juega.
	private String pos; //Posición del jugador. QuarterBack: QB, Tight End: TE, Running Back: RB, Wide Receiver: WR, Kicker: K.
	private int numero; //Número que tiene en la playera.
	private String college; //El college del que salieron.
	private int numTemp; //Número de temporadas que ha jugado.
	private int byeWeek; //Semana que descansa su equipo.
	private String equipoContra; //Equipo contra el que juega
	private char status; //Puede estar activo o fuera del juego: Active: A, Out: O.
	private double stats[]; //Estadísticas que ha tenido.
	private final int MAX_SEMANAS=4; //Número máximo de semanas que todos los jugadores pueden dar puntos.
	
	public Jugador(String nombre) {
		this.nombre=nombre;
		stats= new double[MAX_SEMANAS];
	}
	
	public Jugador(String nombre, String equipo, String pos, int numero, String college, int numTemp, int byeWeek, String equipoContra, char status) {
		this(nombre);
		this.nombre=nombre;
		this.equipo=equipo;
		this.pos=pos;
		this.numero=numero;
		this.college=college;
		this.numTemp=numTemp;
		this.byeWeek=byeWeek;
		this.equipoContra=equipoContra;
		this.status=status;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getEquipo() {
		return equipo;
	}
	
	public String getPos() {
		return pos;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getCollege() {
		return college;
	}
	
	public int getNumTemp() {
		return numTemp;
	}
	
	public int getByeWeek() {
		return byeWeek;
	}
	
	public String getEquipoContra() {
		return equipoContra;
	}
	
	public char getStatus() {
		return status;
	}

	//El jugador uede cambiar de equipo.
	public void setEquipo(String equipo) { 	
		this.equipo=equipo;
	}
	
	//No es común, pero si puede cambiar.
	public void setNumero(int numero) { 
		this.numero=numero;
	}
	
	//Se tiene que cambiar manualmente con este set.
	public void setNumTemp(int numTemp) { 
		this.numTemp=numTemp;
	}
	
	//Si cambia de equipo a mitad de la temporada, también cambia su byeWeek.
	public void setByeWeek(int byeWeek) { 
		this.byeWeek=byeWeek;
	}
	
	//Cambia cada semana, pero tenemos que hacer el cambio manualmente.
	public void setEquipoContra(String equipoContra) { 
		this.equipoContra=equipoContra;
	}
	
	//Durante la temporada se pueden lastimar y recuperar.
	public void setStatus(char status) { 
		this.status=status;
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
		Jugador other = (Jugador) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public int compareTo(Jugador otro) {
		int resp;
		
		if(nombre.equals(otro.nombre))
			resp=0;
		else
			if(nombre.compareToIgnoreCase(otro.nombre)>0)
				resp=8;
			else
				resp=-89;
		return resp;
	}
	
	public String toString() {
		StringBuilder sb= new StringBuilder();
		
		sb.append(" Jugador");
		sb.append("\nNombre: "+nombre);
		sb.append("\nEquipo: "+equipo);
		sb.append("\nPosición: "+pos);
		sb.append("\nNúmero: "+numero);
		sb.append("\nCollege: "+college);
		sb.append("\nNúmero de Temporadas: "+numTemp);
		sb.append("\nBye Week: "+byeWeek);
		sb.append("\nEquipo en Contra: "+equipoContra);
		sb.append("\nStatus: "+status);
		sb.append("\nStats por semana: ");
		for(int i=0;i<MAX_SEMANAS; i++) 
			sb.append("\n"+(i+1)+". "+stats[i]);
		sb.append("\n");
		return sb.toString();
	}
	
	 //necesitamos que el stat sea diferente a -1, que el numero de semana no sobrepase el número de semanas, y que no hay estado en ByeWeek
	public boolean altaStats(double stat, int semana) {
		boolean resp=false;
		
		if(semana<=MAX_SEMANAS && stat>=0 && semana!=byeWeek) {
			stats[semana-1]=stat;
			resp=true;
		}
		else
			resp=false;
		return resp;
	}
	
	public double sumaStats() { 
		double suma=0;
		
		for(int i=0; i<MAX_SEMANAS; i++)
			suma+=stats[i];
		return suma;
	}

}
