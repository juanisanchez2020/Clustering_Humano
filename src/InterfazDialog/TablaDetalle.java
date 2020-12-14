package InterfazDialog;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Negocio.ConjuntoDePersonas;
import Negocio.Persona;
import javax.swing.JScrollPane;

public class TablaDetalle extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;

	public TablaDetalle() {
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 660, 350);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		model = new DefaultTableModel();
		model.addColumn("Persona");
		model.addColumn("Deporte");
		model.addColumn("Musica");
		model.addColumn("Espectaculo");
		model.addColumn("Ciencia");
		table.setModel(model);
		table.setDefaultEditor(Object.class, null); // hacer tabla no editable (para que no te metan un 1000)
	}

	public void agregarPersona(String s, int i, int i2, int i3, int i4) {

		model.addRow(new Object[] { s, i, i2, i3, i4 });
	}
	
	public void importar(ConjuntoDePersonas personas) {	
		model.setRowCount(0);
		for (Persona persona : personas.list())
		{
			model.addRow(new Object [] { persona.getNombre(), persona.getDeportes(), persona.getMusica(), persona.getEspectaculos(), persona.getCiencia()} );
		}
	}


}
