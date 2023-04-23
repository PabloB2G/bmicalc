package bmicalc;

import java.util.Map;

public class CalcDecorator implements IMCHospital {
	private IMCHospital wrappee;
	
	public CalcDecorator(IMCHospital h) {
		wrappee = h;
	}
	
	@Override
	public Map<Double, String> imc(double altura, double peso) {
		return wrappee.imc(altura, peso);
	}

	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		return wrappee.tieneObesidadAbdominal(genero, circunferencia);
	}

}
