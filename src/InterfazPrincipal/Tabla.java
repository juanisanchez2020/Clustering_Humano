package InterfazPrincipal;

import java.awt.event.ActionEvent;
import java.util.function.Consumer;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import InterfazGeneral.ButtonColumn;
import Negocio.ConjuntoDePersonas;
import Negocio.Persona;

import javax.swing.JScrollPane;

public class Tabla extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private Consumer<Integer> funcionEliminarPersona;

	public Tabla(Consumer<Integer> funcionEliminarPersona) {
		//this.panel = panel;
		this.funcionEliminarPersona = funcionEliminarPersona;
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 660, 350);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		model = new DefaultTableModel();
		model.addColumn("Persona");
		model.addColumn("Deporte");
		model.addColumn("Musica");
		model.addColumn("Espectaculo");
		model.addColumn("Ciencia");
		model.addColumn("Acciones");
		table.setModel(model);
		table.setDefaultEditor(Object.class, null); // hacer tabla no editable (para que no te metan un 1000)
	}


	public void agregarPersona(String s, int i, int i2, int i3, int i4) {

		model.addRow(new Object[] { s, i, i2, i3, i4, new ButtonColumn(table, delete, 5) });
	}

	public void importar(ConjuntoDePersonas personas) {
		model.setRowCount(0);
		for (Persona persona : personas.list())
			model.addRow(new Object[] { persona.getNombre(), persona.getDeportes(), persona.getMusica(),
					persona.getEspectaculos(), persona.getCiencia(), new ButtonColumn(table, delete, 5) });
	}

	public int selectedRow() {
		return table.getSelectedRow();
	}

	public int selectedColumn() {
		return table.getSelectedColumn();
	}

	Action delete = new AbstractAction() {
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
			JTable table = (JTable) e.getSource();
			int modelRow = Integer.valueOf(e.getActionCommand());
			((DefaultTableModel) table.getModel()).removeRow(modelRow);
			funcionEliminarPersona.accept(modelRow);
			//panel.eliminarPersona(modelRow);
		}
	};
	
//	public void addRowChangedListener(ListSelectionListener listSelectionListener) {
//		table.getColumnModel().getSelectionModel().addListSelectionListener(listSelectionListener);
//		table.getSelectionModel().addListSelectionListener(listSelectionListener);
//	}

}
