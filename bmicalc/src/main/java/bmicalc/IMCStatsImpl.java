package bmicalc;

public class IMCStatsImpl implements IMCStats {
	public static double altura = 0;
	public static double peso = 0;
	public static double imc = 0;
	public static int numPacientes = 0;
	
	@Override
	public double alturaMedia() {
		return altura / numPacientes;
	}

	@Override
	public double pesoMedio() {
		return peso / numPacientes;
	}

	@Override
	public double imcMedio() {
		return imc / numPacientes;
	}

	@Override
	public int numPacientes() {
		return numPacientes;
	}

}
