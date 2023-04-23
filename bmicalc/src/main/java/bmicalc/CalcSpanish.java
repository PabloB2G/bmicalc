package bmicalc;

import java.util.Map;

public class CalcSpanish extends CalcDecorator {
	
	public CalcSpanish(IMCHospital h) {
		super(h);
	}
	
	@Override
	public Map<Double, String> imc(double altura, double peso) {
		Map<Double, String> res = super.imc(altura, peso);
		System.out.println("La persona con altura " + altura + " metros y " + peso + " kg tiene un IMC de " + 
				(double) res.keySet().toArray()[0]);
		return res;
	}
	
	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		return super.tieneObesidadAbdominal(genero, circunferencia);
	}
}
