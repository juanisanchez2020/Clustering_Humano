package InterfazDialog;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import InterfazGeneral.Temas;
import Negocio.Grafo;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;

import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelDialog extends JFrame {

	ArrayList<Grafo> grupos;

	private static final long serialVersionUID = 1L;
	private JTextField txt_deporte;
	private JTextField txt_musica;
	private JTextField txt_espectaculo;
	private JTextField txt_ciencia;
	private JTextField txt_numPersonas;

	public PanelDialog(ArrayList<Grafo> grupos, LookAndFeel lookAndFeel) {
		this.grupos = grupos;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Grupos");
		setBounds(50, 50, 700, 650);
		getContentPane().setLayout(null);

		Temas.cambiarTema(lookAndFeel);

		TablaDetalle tablaDetalle = new TablaDetalle();
		tablaDetalle.setBounds(10, 200, 660, 350);
		getContentPane().add(tablaDetalle);

		// agregar promedios (visual)*****************************************
		txt_deporte = new JTextField();
		txt_deporte.setHorizontalAlignment(SwingConstants.CENTER);
		txt_deporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		txt_deporte.setEditable(false);
		txt_deporte.setBounds(253, 105, 167, 31);
		getContentPane().add(txt_deporte);
		txt_deporte.setColumns(10);
		
		txt_musica = new JTextField();
		txt_musica.setHorizontalAlignment(SwingConstants.CENTER);
		txt_musica.setFont(new Font("Tahoma", Font.BOLD, 11));
		txt_musica.setEditable(false);
		txt_musica.setBounds(461, 104, 167, 32);
		getContentPane().add(txt_musica);
		txt_musica.setColumns(10);
		
		txt_espectaculo = new JTextField();
		txt_espectaculo.setHorizontalAlignment(SwingConstants.CENTER);
		txt_espectaculo.setEditable(false);
		txt_espectaculo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txt_espectaculo.setBounds(253, 158, 167, 31);
		getContentPane().add(txt_espectaculo);
		txt_espectaculo.setColumns(10);
		
		txt_ciencia = new JTextField();
		txt_ciencia.setHorizontalAlignment(SwingConstants.CENTER);
		txt_ciencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		txt_ciencia.setEditable(false);
		txt_ciencia.setBounds(461, 156, 167, 33);
		getContentPane().add(txt_ciencia);
		txt_ciencia.setColumns(10);
		
		txt_numPersonas = new JTextField();
		txt_numPersonas.setHorizontalAlignment(SwingConstants.CENTER);
		txt_numPersonas.setFont(new Font("Tahoma", Font.BOLD, 11));
		txt_numPersonas.setEditable(false);
		txt_numPersonas.setBounds(359, 61, 167, 33);
		getContentPane().add(txt_numPersonas);
		txt_numPersonas.setColumns(10);

		TablaCabecera tablaCabecera = new TablaCabecera(grupos.size());
		tablaCabecera.addRowChangedListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting() && tablaCabecera.selectedRow() != -1) {
					tablaDetalle.importar(grupos.get((tablaCabecera.selectedRow())).getVertices());
					int grupoSeleccionado = tablaCabecera.selectedRow();
					// cambiar valores de promedios*****************************************
					setPromedioDeporte(grupoSeleccionado);
					setPromedioMusica(grupoSeleccionado);
					setPromedioEspectaculos(grupoSeleccionado);
					setPromedioCiencia(grupoSeleccionado);
					setNumPersonas(grupoSeleccionado);
					
				}
			}
		});
		tablaCabecera.setBounds(10, 40, 200, 150);
		getContentPane().add(tablaCabecera);
	}

	private void setPromedioDeporte(int grupo) {
		txt_deporte.setText("Promedio deporte: " + grupos.get(grupo).promedioDeporte());
	}
	
	private void setPromedioMusica(int grupo) {
		txt_musica.setText("Promedio música: " + grupos.get(grupo).promedioMusica());
	}
	
	private void setPromedioEspectaculos(int grupo) {
		txt_espectaculo.setText("Promedio espetaculos: " + grupos.get(grupo).promedioEspectaculos());
	}
	
	private void setPromedioCiencia(int grupo) {
		txt_ciencia.setText("Promedio ciencia: " + grupos.get(grupo).promedioCiencia());
	}
	
	private void setNumPersonas(int grupo) {
		txt_numPersonas.setText("Cantidad de Personas: " + grupos.get(grupo).getVertices().list().size());
	}
}
