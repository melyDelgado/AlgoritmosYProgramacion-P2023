import java.util.ArrayList;

/*
 * Mely Delgado
 * O2023
 * Clase para probar la clase equipo
 */
public class PruebaEquipo {

	public static void main(String[] args) {
	Equipo e1, e2, e3;
	boolean resp=true, encontre=true, respJuego=true, respStats=true, respCambio=true;
	ArrayList<String> corredoresEliminadosDefensa, receptoresEliminadosDefensa, titularesEliminadosByeWeek, jugadoresCollege;
	String mejorTitular;
	
	//Instanciar Objetos
	e1= new Equipo("Slothers", "Pablo", "pabloemilio@gmail.com");
	e2= new Equipo("Legolas", "Pablo", "pablodelgadovelazquez@gmail.com");
	e3= new Equipo("Mandy", "Mely", "melydelgadoe@gmail,com");
	//Alta jugador titular
	resp=e1.altaJugadorTitular("DeVonta Smith", "Eagles", "RB", 6, "Alabama", 2, 10, "Bucs", 'A');
	if(resp)
		System.out.println("Alta titular exitosa");
	else
		System.out.println("Alta titular NO exitosa");
	resp=e1.altaJugadorTitular("Dak Prescott", "Cowboys", "QB", 20, "Alabama", 4, 18, "GreenBay", 'A');
	if(resp)
		System.out.println("Alta titular exitosa");
	else
		System.out.println("Alta titular NO exitosa");
	resp=e1.altaJugadorTitular("Justin Jefferson", "Vikings", "WR", 18, "LSU", 3, 8, "GreenBay", 'A');
	if(resp)
		System.out.println("Alta titular exitosa");
	else
		System.out.println("Alta titular NO exitosa");
	resp=e1.altaJugadorTitular("Tony Pollard", "Cowboys", "RB", 18, "LSU", 3, 13, "Ravens", 'A');
	if(resp)
		System.out.println("Alta titular exitosa");
	else
		System.out.println("Alta titular NO exitosa");
	resp=e2.altaJugadorTitular("Stefon Diggs", "Bills", "WR", 14, "MaryLand", 0, 0, "Pats", 'A');
	if(resp)
		System.out.println("Alta titular exitosa");
	else
		System.out.println("Alta titular NO exitosa");
	//Alta jugador banca
	resp=e1.altaJugadorBanca("CD Lamb", "Cowboys", "WR", 20, "USC", 4, 18, "GreenBay", 'O');
	if(resp)
		System.out.println("Alta banca exitosa");
	else
		System.out.println("Alta banca NO exitosa");
	resp=e3.altaJugadorBanca("Lamar Jackson", "Ravens", "QB", 8, "Louisville", 5, 10, "Bengals", 'O');
	if(resp)
		System.out.println("Alta banca exitosa");
	else
		System.out.println("Alta banca NO exitosa");
	resp=e3.altaJugadorBanca("Mark Andrews", "Ravens", "TE", 89, "Oklahoma", 5, 13, "Bengals",'O');
	if(resp)
		System.out.println("Alta banca exitosa");
	else
		System.out.println("Alta banca NO exitosa");
	resp=e3.altaJugadorBanca("Austin Ekeler", "Chargers", "RB", 30, "Western State", 6, 6, "Chiefs", 'O');	
	if(resp)
		System.out.println("Alta banca exitosa");
	else
		System.out.println("Alta banca NO exitosa");
	//Baja jugador titular
	//e2.bajaJugadorTitular("Justin Jefferson"); 
	//e1.bajaJugadorTitular("Dak Prescott"); 
	//e1.bajaJugadorTitular("Dak"); 
	//e3.bajaJugadorBanca("Lamar");
	//Busqueda jugador titular
	encontre= e1.busquedaJugadorTitular("DeVonta Smith");
	if(encontre)
		System.out.println("El jugador está en la lista de jugadores titulares.");
	else
		System.out.println("El jugador NO está en la lista de jugadores titulares.");
	encontre= e1.busquedaJugadorTitular("Lamar Jackson"); 
	if(encontre)
		System.out.println("El jugador está en la lista de jugadores.");
	else
		System.out.println("El jugador no está en la lista de jugadores titulares.");
	//Busqueda jugador banca
	encontre= e3.busquedaJugadorBanca("Mark Andrews");
	if(encontre)
		System.out.println("El jugador está en la lista de jugadores en la banca.");
	else
		System.out.println("El jugador NO está en la lista de jugadores en la banca.");
	//Alta juego
	respJuego=e1.altaJuego('W', 2);
	if(respJuego)
		System.out.println("Alta juego exitosa.");
	else
		System.out.println("Alta juego NO exitosa.");
	respJuego=e1.altaJuego('L', 1);
	if(respJuego)
		System.out.println("Alta juego exitosa.");
	else
		System.out.println("Alta juego NO exitosa.");
	respJuego=e2.altaJuego('L', 1);
	if(respJuego)
		System.out.println("Alta juego exitosa.");
	else
		System.out.println("Alta juego NO exitosa.");
	//Alta stats jugador titular
	respStats=e1.altaStatsJugadorTitular("DeVonta Smith", 12.1, 5);
	if(respStats)
		System.out.println("Alta stats exitosa.");
	else
		System.out.println("Alta stats NO exitosa.");
	respStats=e1.altaStatsJugadorTitular("Dak Prescott", 15.1, 1);
	if(respStats)
		System.out.println("Alta stats exitosa.");
	else
		System.out.println("Alta stats NO exitosa.");
	respStats=e1.altaStatsJugadorTitular("Dak Prescott", 20.2, 2);
	if(respStats)
		System.out.println("Alta stats exitosa.");
	else
		System.out.println("Alta stats NO exitosa.");
	respStats=e1.altaStatsJugadorTitular("Justin Jefferson", 24.3, 1);
	if(respStats)
		System.out.println("Alta stats exitosa.");
	else
		System.out.println("Alta stats NO exitosa.");
	respStats=e1.altaStatsJugadorTitular("DeVonta Smith", 42.1, 2);
	if(respStats)
		System.out.println("Alta stats exitosa.");
	else
		System.out.println("Alta stats NO exitosa.");
	//Elimina corredore por defensa
	corredoresEliminadosDefensa=e1.bajaCorredorTitularPorDefensa("Bucs");
	System.out.println("Los corredores eliminados por jugar contra los Bucs son:\n"+corredoresEliminadosDefensa);
	//Elimina receptro por defensa
	receptoresEliminadosDefensa=e1.bajaReceptorTitularPorDefensa("GreenBay");
	System.out.println("Los receptores eliminados por jugar contra GreenBay son:\n"+receptoresEliminadosDefensa);
	receptoresEliminadosDefensa=e1.bajaReceptorTitularPorDefensa("GreenBay");
	System.out.println(receptoresEliminadosDefensa); 
	//Elimina jugador por ByeWeek
	titularesEliminadosByeWeek=e1.eliminaTitularPorByeWeek(10);
	System.out.println("Los titulares eliminados por ByeWeek son:\n"+titularesEliminadosByeWeek);
	//Lista jugador college
	jugadoresCollege=e1.listaJugadoresTitularesCollege("Alabama");
	System.out.println("Los titulares que se graduaron de Alabama son:\n"+jugadoresCollege);
	respCambio=e1.cambiaTitularPorBanca("Dak Prescott", "Lamar Jackson");
	if(respCambio)
		System.out.println("Alta stats exitosa.");
	else
		System.out.println("Alta stats NO exitosa.");
	//toString
	System.out.println(e1.toString()); 
	//System.out.println(e2.toString());
	//System.out.println(e3.toString());
	}

}
