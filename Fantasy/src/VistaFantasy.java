/*
 * Mely Delgado
 * O2023
 * Clase para dibujar la ventana de mi proyecto fantasy, para que el usuario pueda acceder más fácil al programa.
 */

import java.awt.*;
import javax.swing.*;

public class VistaFantasy extends JFrame {
    protected JLabel nombreE, director, correo, nombreJ, equipo, pos, numero, college, numTemp, byeWeek, equipoContra, status, stats, semana, partido, resultado, mejorDefCorr, mejorDefRec, collegeLista, eliminaByeWeek;
    protected JTextField nombreEtxt, directortxt, correotxt, nombreJtxt, equipotxt, postxt, numerotxt, collegetxt, numTemptxt, byeWeektxt, equipoContratxt, statustxt, statstxt, semanatxt, partidotxt, resultadotxt, mejorDefCorrtxt, mejorDefRectxt, collegeListatxt, eliminaByeWeektxt;
    protected JButton vistaLiga, altaEquipo, bajaEquipo, buscaEquipo, altaJT, altaJB, bajaJT, bajaJB, buscaJT, buscaJB, altaStatsJT, altaStatsJB, altaJuego, eliminaC, eliminaR, listaCollege, eliminaBW, cambiaTB, bLimpiaT;
    protected JPanel pVisibleLiga, panelPrincipal, pEquipoJugador, pBotones, pResp, panelRespuestas, panelContenedor;
    protected JTextArea notasResp, info;

    public VistaFantasy(String titulo) {
        super(titulo);
        nombreE = new JLabel("NombreE: ");
        director = new JLabel("Director: ");
        correo = new JLabel("Correo: ");
        nombreJ = new JLabel("NombreJ: ");
        equipo = new JLabel("EquipoJ");
        pos = new JLabel("PosiciónJ: ");
        numero = new JLabel("NúmeroJ: ");
        college = new JLabel("CollegeJ: ");
        numTemp = new JLabel("TemporadasJ: ");
        byeWeek = new JLabel("ByeWeekJ: ");
        equipoContra = new JLabel("EquipoCJ: ");
        status = new JLabel("EstatusJ: ");
        stats = new JLabel("StatsJ: ");
        semana = new JLabel("SemanaS: ");
        partido = new JLabel("SemanaP: ");
        resultado = new JLabel("ResultadoP: ");
        mejorDefCorr = new JLabel("DefensaT: ");
        mejorDefRec = new JLabel("DefensaA: ");
        collegeLista = new JLabel("CollegeL: ");
        eliminaByeWeek = new JLabel("ByeWeekE");
        nombreEtxt = new JTextField(15);
        directortxt = new JTextField(15);
        correotxt = new JTextField(15);
        nombreJtxt = new JTextField(15);
        equipotxt = new JTextField(15);
        postxt = new JTextField(15);
        numerotxt = new JTextField(15);
        collegetxt = new JTextField(15);
        numTemptxt = new JTextField(15);
        byeWeektxt = new JTextField(15);
        equipoContratxt = new JTextField(15);
        statustxt = new JTextField(15);
        statstxt = new JTextField(15);
        semanatxt = new JTextField(15);
        partidotxt = new JTextField(15);
        resultadotxt = new JTextField(15);
        mejorDefCorrtxt = new JTextField(15);
        mejorDefRectxt = new JTextField(15);
        collegeListatxt = new JTextField(15);
        eliminaByeWeektxt = new JTextField(15);
        vistaLiga = new JButton("Ver Liga");
        altaEquipo = new JButton("Alta Equipo");
        bajaEquipo = new JButton("Baja Equipo");
        buscaEquipo = new JButton("Busca Equipo");
        altaJT = new JButton("Alta Titular");
        altaJB = new JButton("Alta Banca");
        bajaJT = new JButton("Baja Titular");
        bajaJB = new JButton("Baja Banca");
        buscaJT = new JButton("Busca Titular");
        buscaJB = new JButton("Busca Banca");
        altaStatsJT = new JButton("Alta Stats Titular");
        altaStatsJB = new JButton("Alta Stats Banca");
        altaJuego = new JButton("Alta Juego");
        eliminaC = new JButton("Elimina CTPD");
        eliminaR = new JButton("Elimina RTPD");
        listaCollege = new JButton("Lista College");
        eliminaBW = new JButton("Elimina JTPBW");
        cambiaTB = new JButton("Cambia TPB");
        bLimpiaT = new JButton("Limpia casillas");
        notasResp = new JTextArea(10, 4);
        info = new JTextArea(10,4);

        // Panel principal con BorderLayout
        panelPrincipal = new JPanel(new GridLayout(1, 2, 10, 5));

        // Panel de equipo y jugador con GridLayout
        pEquipoJugador = new JPanel();
        pEquipoJugador.setLayout(new GridLayout(8, 4, 10, 5)); // 8 filas, 4 columnas
        //pEquipoJugador.setBackground(Color.orange);
        // Agregar etiquetas y campos de texto al panel de equipo y jugador
        pEquipoJugador.add(nombreE);
        pEquipoJugador.add(director);
        pEquipoJugador.add(correo);
        pEquipoJugador.add(nombreJ);
        pEquipoJugador.add(equipo);
        pEquipoJugador.add(nombreEtxt);
        pEquipoJugador.add(directortxt);
        pEquipoJugador.add(correotxt);
        pEquipoJugador.add(nombreJtxt);
        pEquipoJugador.add(equipotxt);
        pEquipoJugador.add(pos);
        pEquipoJugador.add(numero);
        pEquipoJugador.add(college);
        pEquipoJugador.add(numTemp);
        pEquipoJugador.add(byeWeek);
        pEquipoJugador.add(postxt);
        pEquipoJugador.add(numerotxt);
        pEquipoJugador.add(collegetxt);
        pEquipoJugador.add(numTemptxt);
        pEquipoJugador.add(byeWeektxt);
        pEquipoJugador.add(equipoContra);
        pEquipoJugador.add(status);
        pEquipoJugador.add(stats);
        pEquipoJugador.add(semana);
        pEquipoJugador.add(partido);
        pEquipoJugador.add(equipoContratxt);
        pEquipoJugador.add(statustxt);
        pEquipoJugador.add(statstxt);
        pEquipoJugador.add(semanatxt);
        pEquipoJugador.add(partidotxt);
        pEquipoJugador.add(resultado);
        pEquipoJugador.add(mejorDefCorr);
        pEquipoJugador.add(mejorDefRec);
        pEquipoJugador.add(collegeLista);
        pEquipoJugador.add(eliminaByeWeek);
        pEquipoJugador.add(resultadotxt);
        pEquipoJugador.add(mejorDefCorrtxt);
        pEquipoJugador.add(mejorDefRectxt);
        pEquipoJugador.add(collegeListatxt);
        pEquipoJugador.add(eliminaByeWeektxt);

        // Panel de botones con GridLayout
        pBotones = new JPanel();
        pBotones.setLayout(new GridLayout(8, 1, 5, 5)); // 8 filas, 1 columna
        //pBotones.setBackground(Color.pink);
        pBotones.add(vistaLiga);
        pBotones.add(altaEquipo);
        pBotones.add(bajaEquipo);
        pBotones.add(buscaEquipo);
        pBotones.add(altaJT);
        pBotones.add(altaJB);
        pBotones.add(bajaJT);
        pBotones.add(bajaJB);
        pBotones.add(buscaJT);
        pBotones.add(buscaJB);
        pBotones.add(altaStatsJT);
        pBotones.add(altaStatsJB);
        pBotones.add(altaJuego);
        pBotones.add(eliminaC);
        pBotones.add(eliminaR);
        pBotones.add(listaCollege);
        pBotones.add(eliminaBW);
        pBotones.add(cambiaTB);
        pBotones.add(bLimpiaT);
        vistaLiga.setBackground(Color.pink);

        // Panel de respuesta con GridLayout
        pResp = new JPanel();
        pResp.setLayout(new GridLayout(1, 1));
        pResp.setSize(this.getWidth(), 100);
        pResp.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
       // notasResp.setLineWrap(true);
        notasResp.setEditable(false);
        pResp.add(notasResp);
        
        // Panel de vista liga con GridLayout
        pVisibleLiga = new JPanel();
        pVisibleLiga.setLayout(new GridLayout(1, 0));
        pVisibleLiga.setSize(this.getWidth(), 100);
        pVisibleLiga.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    	JScrollPane scroll = new JScrollPane(info);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pVisibleLiga.add(scroll);
        info.setEditable(true);

        // Agregar los paneles al panel principal
        panelPrincipal.add(pEquipoJugador);
        panelPrincipal.add(pBotones);
        //panelPrincipal.setBackground(Color.orange);

        // Panel para organizar los paneles de respuesta y visible de la liga
        panelRespuestas = new JPanel(new GridLayout(1, 0));
        panelRespuestas.add(pResp);
        panelRespuestas.add(pVisibleLiga);

        // Panel principal con BorderLayout
        panelContenedor = new JPanel(new BorderLayout());
        panelContenedor.add(panelPrincipal, BorderLayout.NORTH);
        panelContenedor.add(panelRespuestas, BorderLayout.SOUTH);
        //panelContenedor.setBackground(Color.pink);

        this.add(panelContenedor);
        this.setVisible(true);
        this.setBounds(10, 10, 1000, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}

