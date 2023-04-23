package cliente;

import java.util.Map;

import bmicalc.BMICalc;
import bmicalc.BMICalcImpl;
import bmicalc.Adapter;
import bmicalc.IMCHospital;

public class cliente {

	public static void main(String[] args) {
		BMICalc b = BMICalcImpl.getInstance();
		System.out.println("Singleton (Masa: 4, Altura: 2): " + b.bmi(4, 2));
		System.out.println("Singleton (Masa: 4, Altura: 2): " + b.category(b.bmi(4, 2)));
		System.out.println("Singleton (Circunferencia: 100, Sexo: M): " + b.abdominalObesity(100, 'M'));
		System.out.println();
		
		///////////////////////////////////////
		
		IMCHospital b_adapter = new Adapter(b);

		Map<Double, String> m = b_adapter.imc(2, 4);
		boolean obesidad = b_adapter.tieneObesidadAbdominal('M', 100);
		System.out.println("Adapter (Altura: 2, Masa: 4): " + m);
		System.out.println("Adapter (Sexo: M, Circunferencia: 100): " + obesidad);
		System.out.println();

		///////////////////////////////////////
	}

}
