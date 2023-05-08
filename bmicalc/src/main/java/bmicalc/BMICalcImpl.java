package bmicalc;

public class BMICalcImpl implements CardiovascularMetrics, MetabolicMetrics {

	public double calculateBodyMassIndex(double mass, double height) {
		if (height == 0) {
			throw new ArithmeticException();
		}
		
		if (mass < 0 || height < 0) { 
			throw new ArithmeticException();
		}
		
		if (height > 2.50 || height < 0.50 || mass > 635 || mass < 3) {
			throw new ArithmeticException();
		}
		
		return mass / (height*height);
	}

	public ObesityCategory getObesityCategory(double bmi) {
		ObesityCategory res;
		
		if (bmi < 0) {
			throw new ArithmeticException();
		}
		
		if (bmi > 106) {
			throw new ArithmeticException();
		}
		
		if (bmi < 18.5) {
			res = ObesityCategory.UNDERWEIGHT;
		}else if (bmi >= 18.5 && bmi < 25) {
			res = ObesityCategory.NORMAL;
		}else if (bmi >= 25 && bmi < 30) {
			res = ObesityCategory.OVERWEIGHT;
		}else {
			res = ObesityCategory.OBESE;
		}
		
		return res;
	}

	public boolean abdominalObesity(double waistCircumference, Gender gender) {
		boolean res = false;
		
		if (Gender.FEMALE != gender && Gender.MALE != gender) {
			throw new ArithmeticException();
		}
		
		if (waistCircumference < 0) {
			throw new ArithmeticException();
		}
		
		if (waistCircumference < 33 || waistCircumference > 303) {
			throw new ArithmeticException();
		}
		
		if (gender == Gender.MALE) {
			if (waistCircumference > 90) {
				res = true;
			}
		}
		
		if (gender == Gender.FEMALE) {
			if (waistCircumference > 80) {
				res = true;
			}
		}
		
		return res;
	}

}


