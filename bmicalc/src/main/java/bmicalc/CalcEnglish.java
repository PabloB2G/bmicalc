package bmicalc;

import java.util.Map;

public class CalcEnglish extends CalcDecorator {
	
	public CalcEnglish(IMCHospital h) {
		super(h);
	}
	
	@Override
	public Map<Double, String> imc(double altura, double peso) {
		Map<Double, String> res = super.imc(altura/3.28084f, peso/2.20462f);
		System.out.println("The person with height " + altura + " inches and " + peso + " pounds have a BMI of " + 
				(double) res.keySet().toArray()[0]);
		return res;
	}
	
	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		return super.tieneObesidadAbdominal(genero, circunferencia/3.28084f);
	}
}
