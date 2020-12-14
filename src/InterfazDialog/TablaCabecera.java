package InterfazDialog;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class TablaCabecera extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;

	public TablaCabecera(int cantidadDeGrupos) {
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 200, 150);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		model = new DefaultTableModel();
		model.addColumn("Grupo");
		table.setModel(model);
		table.setDefaultEditor(Object.class, null); // hacer tabla no editable (para que no te metan un 1000)
		
		for (int i = 0; i<cantidadDeGrupos; i++)
			model.addRow(new Object[] { "Grupo " + model.getRowCount() });
	}

	public int selectedRow() {
		return table.getSelectedRow();
	}
	public void addRowChangedListener(ListSelectionListener listSelectionListener) {
		table.getColumnModel().getSelectionModel().addListSelectionListener(listSelectionListener);
		table.getSelectionModel().addListSelectionListener(listSelectionListener);
	}

}
