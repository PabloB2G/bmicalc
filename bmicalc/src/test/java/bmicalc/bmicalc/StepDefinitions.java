package bmicalc.bmicalc;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions;
import bmicalc.BMICalcImpl;
import bmicalc.Gender;
import bmicalc.ObesityCategory;

public class StepDefinitions {
	private BMICalcImpl b;
	private double resBMI;
	private ObesityCategory resCateg;
	private String resAbdominal;
	private boolean error;

	@Before
	public void initialization() {
		b = null;
		resBMI = -1;
		resCateg = null;
		resAbdominal = null;
		error = false;
	}

	@Given("Tengo una calculadora de BMI")
	public void tengo_una_calculadora_de_bmi() {
		b = new BMICalcImpl();
	}

	@When("Calculo el BMI con peso {double} y con altura {double}")
	public void calculo_el_bmi_con_peso_y_con_altura(Double double1, Double double2) {
		resBMI = b.calculateBodyMassIndex(double1, double2);
	}

	@When("Calculo el BMI con peso {double} y con altura {double} negativos")
	public void calculo_el_bmi_con_peso_y_con_altura_negativos(Double double1, Double double2) {
		try {
			resBMI = b.calculateBodyMassIndex(double1, double2);
		} catch (ArithmeticException ex) {
			error = true;
		}
	}

	@When("Calculo el BMI con peso {double} y con altura {double} atipicos")
	public void calculo_el_bmi_con_peso_y_con_altura_atipicos(Double double1, Double double2) {
		try {
			resBMI = b.calculateBodyMassIndex(double1, double2);
		} catch (ArithmeticException ex) {
			error = true;
		}
	}
	
	@When("Calculo la categoria de {double}")
	public void calculo_la_categoria_de(Double double1) {
		resCateg = b.getObesityCategory(double1);
	}

	@When("Calculo la categoria del BMI negativo {double}")
	public void calculo_la_categoria_del_bmi_negativo(Double double1) {
		try {
			resCateg = b.getObesityCategory(double1);
		} catch (ArithmeticException ex) {
			error = true;
		}
	}
	
	@When("Calculo la categoria del BMI atipico {double}")
	public void calculo_la_categoria_del_bmi_atipico(Double double1) {
		try {
			resCateg = b.getObesityCategory(double1);
		} catch (ArithmeticException ex) {
			error = true;
		}
	}
	
	
	@When("Calculo si tiene obesidad abdominal con cintura {double} y genero {string}")
	public void calculo_si_tiene_obesidad_abdominal_con_cintura_y_genero(Double double1, String gender) {
		boolean res;
		if (gender == "FEMALE") {
			res = b.abdominalObesity(double1, Gender.FEMALE);
		}else {
			res = b.abdominalObesity(double1, Gender.MALE);
		}
		
	    if (res == true) {
	    	resAbdominal = "T";
	    }else {
	    	resAbdominal = "F";
	    }
	}
	
	@When("Calculo si tiene obesidad abdominal con cintura negativa {double}")
	public void calculo_si_tiene_obesidad_abdominal_con_cintura_negativa(Double double1) {
		try {
			b.abdominalObesity(double1, Gender.MALE);
		} catch (ArithmeticException ex) {
			error = true;
		}
	}
	
	@When("Calculo si tiene obesidad abdominal con cintura atipica {double}")
	public void calculo_si_tiene_obesidad_abdominal_con_cintura_atipica(Double double1) {
		try {
			b.abdominalObesity(double1, Gender.MALE);
		} catch (ArithmeticException ex) {
			error = true;
		}
	}

	@Then("El sistema devuelve {double}")
	public void el_sistema_devuelve(Double double1) {
		Assertions.assertEquals(double1, resBMI);
	}

	private ObesityCategory metodoEnum(String s) {
		ObesityCategory c;
		
		if (s == "UNDERWEIGHT") {
			c = ObesityCategory.UNDERWEIGHT;
		}else if (s == "NORMAL") {
			c = ObesityCategory.NORMAL;
		}else if (s == "OVERWEIGHT") {
			c = ObesityCategory.OVERWEIGHT;
		}else {
			c = ObesityCategory.OBESE;
		}
		
		return c;
	}
	
	@Then("El sistema devuelve la categoria {string}")
	public void el_sistema_devuelve_la_categoria(String string) {
		Assertions.assertEquals(metodoEnum(string), resCateg);
	}
	
	@Then("El sistema devuelve que obesidad es {string}")
	public void el_sistema_devuelve_que_obesidad_es(String string) {
		Assertions.assertEquals(string, resAbdominal);
	}
	
	@Then("El sistema devuelve un error")
	public void el_sistema_devuelve_un_error() {
		Assertions.assertTrue(error);
	}
}

