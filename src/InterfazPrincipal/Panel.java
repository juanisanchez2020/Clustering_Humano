package InterfazPrincipal;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import InterfazDialog.PanelDialog;
import InterfazGeneral.Temas;
import Negocio.Grafo;
import Negocio.Negocio;

public class Panel {

	private JFrame frame;
	private Botonera botonera;
	private PersonaView personaView;
	public Tabla tabla;
	private Negocio negocio;
	private Temas temas;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel window = new Panel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Panel() {
		negocio = new Negocio();
		initialize();
		temas = new Temas();
		temas.temaPorDefecto();
	}

	public void agregarPersona() {
		negocio.crearPersona(personaView.getTextField(), personaView.getComboBoxD(), personaView.getComboBoxM(),
				personaView.getComboBoxE(), personaView.getComboBoxC());

		tabla.agregarPersona(personaView.getTextField(), personaView.getComboBoxD(), personaView.getComboBoxM(),
				personaView.getComboBoxE(), personaView.getComboBoxC());
	}

	public int eliminarPersona(int n) {
		negocio.eliminarPersona(n);
		return n;
	}

	public void exportar() {
		negocio.exportar();
	}

	public void importar() {
		tabla.importar(negocio.importar());
	}

	public void generar() {
		if (!negocio.esGenerable()) {
			JOptionPane.showMessageDialog(null, "El grafo no puede ser generado. Debe haber al menos dos personas en la lista", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		Grafo grafo = negocio.crearGrafo();
		Grafo grafoCompleto = grafo.generarGrafoCompleto();
		Grafo grafoAGM = grafoCompleto.generarAGMKuskal();
		
		ArrayList<Grafo> grupos = grafoAGM.separarGrafoEnDos();
		
		PanelDialog panelDialog = new PanelDialog(grupos, temas.temaActual());
		panelDialog.setVisible(true);
	}

	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Clustering Humano");
		frame.setBounds(50, 50, 700, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Consumer<Integer> funcionEliminarPersona = this::eliminarPersona;
		tabla = new Tabla(funcionEliminarPersona);
		frame.getContentPane().add(tabla);
		tabla.setBounds(0, 200, 694, 349);
		personaView = new PersonaView(this);
		frame.getContentPane().add(personaView);
		personaView.setBounds(0, 50, 694, 149);

		botonera = new Botonera(this);
		frame.getContentPane().add(botonera);
		botonera.setBounds(0, 0, 694, 621);

	}

	public void cambiarTema() {
		temas.cambiarTema();		
	}

}
