package bmicalc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bmicalc.BMICalcImpl;
import bmicalc.Gender;


public class Controlador implements ActionListener{
	private BMICalcImpl modelo;
	private Vista vista;
	
	public Controlador(BMICalcImpl modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.equals("BMI")) {
			// Calcular BMI
			try {
				double peso = vista.getPeso();
				double altura = vista.getAltura();
				double res = modelo.bmi(peso, altura);
				vista.setBMI(res);
			}catch (ArithmeticException ex) {
				vista.error("El rango de valores del peso y/o la altura no es correcto.");
			}catch (NumberFormatException ex) {
				vista.error("El formato del peso y/o la altura no son correctos.");
			}
		}else if (comando.equals("Categoria")) {
			// Calcular categoria
			try {
				double peso = vista.getPeso();
				double altura = vista.getAltura();
				double bmi = modelo.bmi(peso, altura);
				String res = modelo.category(bmi);
				vista.setCategoria(bmi, res);
			}catch (ArithmeticException ex) {
				vista.error("El rango de valores del peso y/o la altura no son correctos.");
			}catch (NumberFormatException ex) {
				vista.error("El formato del peso y/o la altura no son correctos.");
			}
		}else if (comando.equals("Obesidad")) {
			try {
				double circ = vista.getCircunferencia();
				Gender sexo = vista.getSexo();
				boolean res = modelo.abdominalObesity(circ, sexo);
				vista.setObesidad(res);
			}catch (ArithmeticException ex) {
				vista.error("El rango de valores de la circunferencia no es correcto.");
			}catch (NumberFormatException ex) {
				vista.error("El formato de la circunferencia no es correcto.");
			}
		}else if (comando.equals("Hombre")) {
			vista.setSexo('M');
		}else if (comando.equals("Mujer")) {
			vista.setSexo('F');
		}
		
	}
	
	

}
