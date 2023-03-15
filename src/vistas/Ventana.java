package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ControladorCentroEducativo;
import controladores.ControladorMateria;
import controladores.ControladorNivel;
import modelos.CentroEducativo;
import modelos.Materia;
import modelos.Nivel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfCodigo;
	private JTextField jtfUrl;
	private JTextField jtfFecha;
	private JComboBox<CentroEducativo> jcbCentro = null;
	private JComboBox<Nivel> jcbNivel = null;
	private JComboBox<Materia> jcbMateria = null;
	private JCheckBox check = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel_3 = new JLabel("Gestión de Materias");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 0;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("centro");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		jcbCentro = new JComboBox<CentroEducativo>();
		GridBagConstraints gbc_jcbCentro = new GridBagConstraints();
		gbc_jcbCentro.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCentro.gridx = 1;
		gbc_jcbCentro.gridy = 1;
		contentPane.add(jcbCentro, gbc_jcbCentro);

		JButton btnNiveles = new JButton("cargar niveles");
		btnNiveles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarNiveles();
			}
		});
		GridBagConstraints gbc_btnNiveles = new GridBagConstraints();
		gbc_btnNiveles.insets = new Insets(0, 0, 5, 0);
		gbc_btnNiveles.gridx = 2;
		gbc_btnNiveles.gridy = 1;
		contentPane.add(btnNiveles, gbc_btnNiveles);

		JLabel lblNewLabel_1 = new JLabel("nivel");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbNivel = new JComboBox<Nivel>();
		GridBagConstraints gbc_jcbNivel = new GridBagConstraints();
		gbc_jcbNivel.insets = new Insets(0, 0, 5, 5);
		gbc_jcbNivel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNivel.gridx = 1;
		gbc_jcbNivel.gridy = 2;
		contentPane.add(jcbNivel, gbc_jcbNivel);

		JButton btnNewButton = new JButton("cargar materias");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMaterias();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("materia");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 3;
		contentPane.add(jcbMateria, gbc_jcbMateria);

		JButton btnNewButton_1 = new JButton("ver materia");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Para que no salte una exception al pulsarlo en blanco
				if (jcbMateria.getSelectedItem() == null) {
					
				}else {
					leerJcomboMateria();
				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 3;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

		JLabel lblNewLabel_4 = new JLabel("datos de la materia");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("id");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 5;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		jtfId.setEnabled(false);

		JLabel lblNewLabel_6 = new JLabel("nombre");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.gridwidth = 2;
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 6;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblCdigo = new JLabel("código");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 7;
		contentPane.add(lblCdigo, gbc_lblCdigo);

		jtfCodigo = new JTextField();
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCodigo.gridwidth = 2;
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 7;
		contentPane.add(jtfCodigo, gbc_jtfCodigo);
		jtfCodigo.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("URL clasrrom");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfUrl = new JTextField();
		GridBagConstraints gbc_jtfUrl = new GridBagConstraints();
		gbc_jtfUrl.gridwidth = 2;
		gbc_jtfUrl.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUrl.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUrl.gridx = 1;
		gbc_jtfUrl.gridy = 8;
		contentPane.add(jtfUrl, gbc_jtfUrl);
		jtfUrl.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("fecha inicio");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);

		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 9;
		contentPane.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);

		check = new JCheckBox("");
		GridBagConstraints gbc_check = new GridBagConstraints();
		gbc_check.anchor = GridBagConstraints.EAST;
		gbc_check.insets = new Insets(0, 0, 5, 5);
		gbc_check.gridx = 0;
		gbc_check.gridy = 10;
		contentPane.add(check, gbc_check);

		JLabel lblNewLabel_9 = new JLabel("admite matrícula");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 10;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);

		JButton btnNewButton_2 = new JButton("guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validacion();
					cargarMaterias();
				} catch (NumberFormatException | SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 11;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 12;
		contentPane.add(panel, gbc_panel);
		llenarJcb();
	}

	private void validacion() throws NumberFormatException, SQLException, ParseException {
		String str = jtfCodigo.getText();
		int contMayus = 0, contMinus = 0, contNum = 0, contNoAlfa = 0;
		String str1[] = str.split("[ ]{1,}");
		for (int i = 0; i < str1.length; i++) {
			char[] letra = str1[i].toCharArray();
			contMayus = 0;
			contMinus = 0;
			for (int j = 0; j < letra.length; j++) {
				if (Character.isUpperCase(letra[j]))
					contMayus++;
				if (Character.isLowerCase(letra[j]))
					contMinus++;
			}
			if (contMayus >= 3 || contMinus >= 3)
				if (jtfUrl.getText().startsWith("http://") || jtfUrl.getText().startsWith("https://")) {
					guardar();
				}
				
			else
				JOptionPane.showMessageDialog(null, "El campo codigo no comple los requisitos");
		}
	}
	
	private void guardar() throws NumberFormatException, SQLException, ParseException {
		Materia m = new Materia();
		m.setId(Integer.parseInt(jtfId.getText()));
		m.setNombre(jtfNombre.getText());
		m.setCodigo(jtfCodigo.getText());
		m.setUrl(jtfUrl.getText());
		m.setAdmiteMatricula(check.getAutoscrolls());
		m.setFechaInicio(new SimpleDateFormat("dd/MM/yyyy").parse(jtfFecha.getText()));
		ControladorMateria.update(m);
		

	}

	private void leerJcomboMateria() {
		Materia m = (Materia) jcbMateria.getSelectedItem();
		jtfId.setText(Integer.toString(m.getId()));
		jtfNombre.setText(m.getNombre());
		jtfCodigo.setText(m.getCodigo());
		jtfUrl.setText(m.getUrl());
		jtfFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(m.getFechaInicio()));
		check.setSelected(m.isAdmiteMatricula());

	}

	private void cargarMaterias() {
		Nivel n = (Nivel) jcbNivel.getSelectedItem();
		List<Materia> lc = ControladorMateria.cargarNiveles(n.getId());

		try {
			jcbMateria.removeAllItems();
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (Materia m : lc) {
			jcbMateria.addItem(m);
		}

	}

	private void cargarNiveles() {
		CentroEducativo c = (CentroEducativo) jcbCentro.getSelectedItem();
		List<Nivel> lc = ControladorNivel.cargarNiveles(c.getId());

		try {
			jcbNivel.removeAllItems();
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (Nivel n : lc) {
			jcbNivel.addItem(n);
		}

	}

	private void llenarJcb() {
		List<CentroEducativo> lc = ControladorCentroEducativo.findAll();
		for (CentroEducativo ce : lc) {
			jcbCentro.addItem(ce);
		}
	}

}
