package InterfazPrincipal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class PersonaView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JComboBox<Integer> cB_Deporte;
	private JComboBox<Integer> cB_Musica;
	private JComboBox<Integer> cB_Espectaculos;
	private JComboBox<Integer> cB_Ciencia;

	/**
	 * Create the panel.
	 */
	public PersonaView(Panel panel) {
		setLayout(null);

		JLabel lblPersona = new JLabel("Nueva Persona");
		lblPersona.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersona.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPersona.setBounds(272, 11, 91, 29);
		add(lblPersona);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 40, 115, 19);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(80, 39, 119, 22);
		add(textField);
		textField.setColumns(10);

		
		JLabel lblIntereses = new JLabel("Intereses: ");
		lblIntereses.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntereses.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIntereses.setBounds(10, 70, 104, 14);
		add(lblIntereses);
		

		JLabel lblMusica = new JLabel("Musica");
		lblMusica.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMusica.setBounds(130, 95, 55, 14);
		add(lblMusica);

		cB_Musica = new JComboBox<Integer>();
		cB_Musica.setBounds(185, 92, 44, 22);
		add(cB_Musica);
		cB_Musica.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 1, 2, 3, 4, 5 }));
		
		
		JLabel lblEspectaculo = new JLabel("Espectaculo");
		lblEspectaculo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEspectaculo.setBounds(240, 95, 85, 14);
		add(lblEspectaculo);
		
		cB_Espectaculos = new JComboBox<Integer>();
		cB_Espectaculos.setBounds(330, 92, 44, 22);
		add(cB_Espectaculos);
		cB_Espectaculos.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 1, 2, 3, 4, 5 }));

		JLabel lblCiencia = new JLabel("Ciencia");
		lblCiencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCiencia.setBounds(390, 95, 55, 14);
		add(lblCiencia);
		
		cB_Ciencia = new JComboBox<Integer>();
		cB_Ciencia.setBounds(450, 92, 44, 22);
		add(cB_Ciencia);
		cB_Ciencia.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 1, 2, 3, 4, 5 }));

		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDeporte.setBounds(10, 95, 68, 14);
		add(lblDeporte);

		cB_Deporte = new JComboBox<Integer>();
		cB_Deporte.setBounds(75, 92, 44, 22);
		add(cB_Deporte);
		cB_Deporte.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 1, 2, 3, 4, 5 }));
		

		JButton btnAgregarPersona = new JButton("Agregar Persona");
		btnAgregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.agregarPersona();
			}
		});
		btnAgregarPersona.setBounds(528, 92, 150, 23);
		add(btnAgregarPersona);

	}

	public String getTextField() {

		return textField.getText();
	}

	public int getComboBoxD() {
		return (int)cB_Deporte.getSelectedItem();
	}

	public int getComboBoxM() {
		return (int)cB_Musica.getSelectedItem();
	}

	public int getComboBoxE() {
		return (int)cB_Espectaculos.getSelectedItem();
	}

	public int getComboBoxC() {
		return (int)cB_Ciencia.getSelectedItem();
	}
}
