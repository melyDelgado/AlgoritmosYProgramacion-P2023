/*
 * Mely Delgado 
 * O2023
 * Clase para probar los métodos creados.
 */

public class PruebaJugador {

	public static void main(String[] args) {
		Jugador j1, j2, j3;
		boolean resp=true, resp2=true;
		int compare;
		
		//Instanciar los objetos
		j1 = new Jugador("Lamar Jackson", "Ravens", "QB", 8, "Louisville", 5, 10, "Bengals", 'I');
		j2 = new Jugador("Mark Andrews", "Ravens", "TE", 89, "Oklahoma", 5, 13, "Bengals",'A');
		j3 = new Jugador("Austin Ekeler", "Chargers", "RB", 30, "Western State", 6, 6, "Chiefs", 'O');
		//Alta Stats
		j1.altaStats(12.5, 1);
		j1.altaStats(13.3, 4);
		j1.altaStats(13.3, 2);
		resp2=j1.altaStats(11.2, 3);
		if(resp2)
			System.out.println("Alta EXITOSA");
		else
			System.out.println("Alta NO EXITOSA");
		//College
		System.out.println(j2.getCollege());
		//ByeWeek
		j3.setByeWeek(10);
		//EquipoContra
		j3.setEquipoContra("Raiders");
		System.out.println(j3.toString());
		//Equals
		resp=j1.equals(j3);
		if(resp)
			System.out.println("Los jugadores son iguales");
		else
			System.out.println("Los jugadores son diferentes");
		//CompareTo
		compare=j3.compareTo(j2);
		if(compare==0)
			System.out.println("Los jugadores son iguales");
		else
			if(compare>0)
				System.out.println("El jugador es mayor");
			else
				System.out.println("El jugador es menor");
		//Suma stats
		System.out.println("La suma de los stats del primer juagdor es: "+j1.sumaStats());
		//String
		System.out.println(j1.toString());
	}

}