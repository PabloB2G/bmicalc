package bmicalc.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bmicalc.Gender;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class Vista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tPeso;
	private JTextField tAltura;
	private JTextField tCirc;
	private JRadioButton radioHombre;
	private JRadioButton radioMujer;
	private JLabel lblBMI;
	private JLabel lblCategoria;
	private JCheckBox chSi;
	private JCheckBox chNo;
	private JButton btnBMI;
	private JButton btnCategoria;
	private JButton btnObesidad;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel pInformacion = new JPanel();
		contentPane.add(pInformacion);
		pInformacion.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblinfo = new JLabel("Informacion Personal");
		lblinfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblinfo.setForeground(Color.BLACK);
		lblinfo.setBackground(Color.WHITE);
		lblinfo.setHorizontalAlignment(SwingConstants.CENTER);
		pInformacion.add(lblinfo);
		
		JPanel pPeso = new JPanel();
		pInformacion.add(pPeso);
		
		JLabel lblPeso = new JLabel("Peso corporal:");
		lblPeso.setHorizontalAlignment(SwingConstants.LEFT);
		pPeso.add(lblPeso);
		
		tPeso = new JTextField();
		tPeso.setColumns(6);
		pPeso.add(tPeso);
		
		JLabel lblKG = new JLabel("kg");
		pPeso.add(lblKG);
		
		JPanel pAltura = new JPanel();
		pInformacion.add(pAltura);
		pAltura.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblAltura = new JLabel("Altura:");
		pAltura.add(lblAltura);
		
		tAltura = new JTextField();
		tAltura.setColumns(6);
		pAltura.add(tAltura);
		
		JLabel lblM = new JLabel("metros");
		pAltura.add(lblM);
		
		JPanel pCircumferencia = new JPanel();
		pInformacion.add(pCircumferencia);
		
		JLabel lblCirc = new JLabel("Cintura:");
		pCircumferencia.add(lblCirc);
		
		tCirc = new JTextField();
		tCirc.setColumns(6);
		pCircumferencia.add(tCirc);
		
		JLabel lblCM = new JLabel("cm");
		pCircumferencia.add(lblCM);
		
		JPanel pBotones = new JPanel();
		contentPane.add(pBotones);
		pBotones.setLayout(new GridLayout(3, 1, 10, 15));
		
		btnBMI = new JButton("Calcular BMI");
		pBotones.add(btnBMI);
		
		btnCategoria = new JButton("Calcular categoria");
		pBotones.add(btnCategoria);
		
		btnObesidad = new JButton("Calcular obesidad abdominal");
		pBotones.add(btnObesidad);
		
		JPanel pSexo = new JPanel();
		contentPane.add(pSexo);
		pSexo.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		pSexo.add(lblSexo);
		
		radioHombre = new JRadioButton("Hombre");
		radioHombre.setSelected(true);
		radioHombre.setHorizontalAlignment(SwingConstants.CENTER);
		pSexo.add(radioHombre);
		
		radioMujer = new JRadioButton("Mujer");
		radioMujer.setHorizontalAlignment(SwingConstants.CENTER);
		pSexo.add(radioMujer);
		
		JPanel pResultados = new JPanel();
		contentPane.add(pResultados);
		pResultados.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResultados.setForeground(Color.BLACK);
		lblResultados.setHorizontalAlignment(SwingConstants.CENTER);
		pResultados.add(lblResultados);
		
		lblBMI = new JLabel("Su BMI es:");
		lblBMI.setHorizontalAlignment(SwingConstants.LEFT);
		pResultados.add(lblBMI);
		
		lblCategoria = new JLabel("Pertenece a la categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.LEFT);
		pResultados.add(lblCategoria);
		
		JPanel pObesidad = new JPanel();
		pResultados.add(pObesidad);
		
		JLabel lblObesidad = new JLabel("Obesidad abdominal:");
		lblObesidad.setHorizontalAlignment(SwingConstants.LEFT);
		pObesidad.add(lblObesidad);
		
		chSi = new JCheckBox("Si");
		chSi.setEnabled(false);
		pObesidad.add(chSi);
		
		chNo = new JCheckBox("No");
		chNo.setEnabled(false);
		pObesidad.add(chNo);
		
		pack();
		setVisible(true);
	}
	
	public double getPeso() {
		return Double.parseDouble(tPeso.getText());	
	}
	
	public double getAltura() {
		return Double.parseDouble(tAltura.getText());	
	}
	
	public double getCircunferencia() {
		return Double.parseDouble(tCirc.getText());	
	}
	public void setSexo(char s) {
		if (s == 'M') {
			radioHombre.setSelected(true);
			radioMujer.setSelected(false);
		}else {
			radioHombre.setSelected(false);
			radioMujer.setSelected(true);
		}
	}
	public Gender getSexo() {
		if (radioHombre.isSelected()) {
			return Gender.MALE;
		}else {
			return Gender.FEMALE;
		}
	}
	
	public void setBMI(double res) {
		lblBMI.setText("Su BMI es: " + res);
	}
	
	public void setCategoria(double bmi, String categoria) {
		setBMI(bmi);
		lblCategoria.setText("Pertenece a la categoria: " + categoria);
	}
	
	public void setObesidad(boolean res) {
		if (res) {
			chSi.setSelected(true);
			chNo.setSelected(false);
		}else {
			chSi.setSelected(false);
			chNo.setSelected(true);
		}
	}
	
	public void error (String e) {
		JOptionPane.showMessageDialog(null, e);
	}
	
	public void registrarControlador(ActionListener ctrl) {
		btnBMI.addActionListener(ctrl);
		btnBMI.setActionCommand("BMI");
		
		btnCategoria.addActionListener(ctrl);
		btnCategoria.setActionCommand("Categoria");
		
		btnObesidad.addActionListener(ctrl);
		btnObesidad.setActionCommand("Obesidad");
		
		radioHombre.addActionListener(ctrl);
		radioHombre.setActionCommand("Hombre");
		
		radioMujer.addActionListener(ctrl);
		radioMujer.setActionCommand("Mujer");
	}
}
