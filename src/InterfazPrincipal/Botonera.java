package InterfazPrincipal;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Botonera extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public Botonera(Panel panel) {
		setLayout(null);
		
		JButton btnEdicion = new JButton("Tema");
		btnEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.cambiarTema();
			}
		});
		btnEdicion.setBounds(109, 11, 89, 23);
		add(btnEdicion);
		
		JButton btn_info = new JButton("Info");
		btn_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"     Segundo Semestre 2020\r\n" + "        Sanchez Juan Ignacio\r\n"
								+ "        Schmidt Maximiliano\r\n" + "          Sosa Martín Leonel",
						"Clustering Humano - Programacion 3", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btn_info.setBounds(208, 11, 89, 23);
		add(btn_info);
		
		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int resultado = JOptionPane.showConfirmDialog(null, "Esta seguro que desea exportar? Podria estar sobreescribiendo un archivo", "Exportar datos",
						dialogButton);
				if (resultado == 0) { // opcion SI
					panel.exportar();
				}
			}
		});
		btnExportar.setBounds(20, 565, 89, 23);
		add(btnExportar);
		
		JButton btnImportar = new JButton("Importar");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//preguntar si desea sobreescribir los datos
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int resultado = JOptionPane.showConfirmDialog(null, "Esta seguro que desea importar? Sus datos actuales se perderan", "Importar datos",
						dialogButton);
				if (resultado == 0) { // opcion SI
					panel.importar();
				}

			}
		});
		btnImportar.setBounds(10, 11, 89, 23);
		add(btnImportar);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.generar();
			}
		});
		btnGenerar.setBounds(570, 565, 89, 23);
		add(btnGenerar);
		
		

	}
}
