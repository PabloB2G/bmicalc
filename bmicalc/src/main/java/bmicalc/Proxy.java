package bmicalc;

import java.util.Map;

public class Proxy implements IMCHospital {
	private IMCHospital realService;
	
	public Proxy(IMCHospital h) {
		realService = h;
		IMCStatsImpl.numPacientes += 1;
	}

	@Override
	public Map<Double, String> imc(double altura, double peso) {
		Map<Double, String> res = realService.imc(altura, peso);
		IMCStatsImpl.altura += altura;
		IMCStatsImpl.peso += altura;
		IMCStatsImpl.imc = (double) res.keySet().toArray()[0];
		return res;
	}

	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		boolean res = realService.tieneObesidadAbdominal(genero, circunferencia);
	
		return res;
	}

}
