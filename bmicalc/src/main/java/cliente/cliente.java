package cliente;

import bmicalc.BMICalc;
import bmicalc.BMICalcImpl;

public class cliente {

	public static void main(String[] args) {
		BMICalc b = BMICalcImpl.getInstance();
		b.bmi(4, 2);

	}

}
