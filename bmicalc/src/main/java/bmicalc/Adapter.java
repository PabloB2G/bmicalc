package bmicalc;

import java.util.HashMap;
import java.util.Map;

public class Adapter implements IMCHospital {

private BMICalc adaptee;
	
	public Adapter(BMICalc b) {
		adaptee = b;
	}

	@Override
	public Map<Double, String> imc(double altura, double peso) {
		double bmi = adaptee.bmi(peso, altura);
		String categoria = adaptee.category(bmi);
		
		Map<Double, String> m = new HashMap<Double, String>();
		m.put(bmi, categoria);
		
		return m;
	}
	
	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		boolean res = adaptee.abdominalObesity(circunferencia, genero);
		return res;
	}

}
