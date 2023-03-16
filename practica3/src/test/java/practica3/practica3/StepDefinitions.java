package practica3.practica3;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions;
import practica3.BMICalcImpl;

public class StepDefinitions {
	private BMICalcImpl b;
	private double resBMI;
	private String resCateg;
	private boolean error;

	@Before
	public void initialization() {
		b = null;
		resBMI = -1;
		resCateg = null;
		error = false;
	}

	@Given("Tengo una calculadora de BMI")
	public void tengo_una_calculadora_de_bmi() {
		b = new BMICalcImpl();
	}

	@When("Calculo el BMI con peso {double} y con altura {double}")
	public void calculo_el_bmi_con_peso_y_con_altura(Double double1, Double double2) {
		resBMI = b.bmi(double1, double2);
	}

	@When("Calculo el BMI con peso {double} y con altura {double} negativos")
	public void calculo_el_bmi_con_peso_y_con_altura_negativos(Double double1, Double double2) {
		try {
			resBMI = b.bmi(double1, double2);
		} catch (ArithmeticException ex) {
			error = true;
		}
	}

	@When("Calculo el BMI con peso {double} y con altura {double} atipicos")
	public void calculo_el_bmi_con_peso_y_con_altura_atipicos(Double double1, Double double2) {
		try {
			resBMI = b.bmi(double1, double2);
		} catch (ArithmeticException ex) {
			error = true;
		}
	}
	
	@When("Calculo la categoria de {double}")
	public void calculo_la_categoria_de(Double double1) {
		resCateg = b.category(double1);
	}

	@When("Calculo la categoria del BMI negativo {double}")
	public void calculo_la_categoria_del_bmi_negativo(Double double1) {
		try {
			resCateg = b.category(double1);
		} catch (ArithmeticException ex) {
			error = true;
		}
	}
	
	@When("Calculo la categoria del BMI atipico {double}")
	public void calculo_la_categoria_del_bmi_atipico(Double double1) {
		try {
			resCateg = b.category(double1);
		} catch (ArithmeticException ex) {
			error = true;
		}
	}

	@Then("El sistema devuelve {double}")
	public void el_sistema_devuelve(Double double1) {
		Assertions.assertEquals(double1, resBMI);
	}

	@Then("El sistema devuelve la categoria {string}")
	public void el_sistema_devuelve_la_categoria(String string) {
		Assertions.assertEquals(string, resCateg);
	}
	
	@Then("El sistema devuelve un error")
	public void el_sistema_devuelve_un_error() {
		Assertions.assertTrue(error);
	}
}
