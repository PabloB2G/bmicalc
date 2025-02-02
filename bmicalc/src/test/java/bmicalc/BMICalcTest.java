package bmicalc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class BMICalcTest {
	static BMICalcImpl calc;

	@BeforeAll
	public static void loadCalc() {
		calc = new BMICalcImpl();
	}

	// Tests for bmi

	@Test
	public void bmiPositiveReals() {
		double mass = 60.5;
		double height = 1.8;
		assertEquals(mass / (height * height), calc.calculateBodyMassIndex(mass, height));
	}

	@Test
	public void bmiPositiveInts() {
		int mass = 60;
		int height = 2;
		assertEquals(mass / (height * height), calc.calculateBodyMassIndex(mass, height));
	}

	@Test
	public void bmiNegativeMass() {
		assertThrows(ArithmeticException.class, () -> calc.calculateBodyMassIndex(-2, 20));
	}
	
	@Test
	public void bmiNegativeHeight() {
		assertThrows(ArithmeticException.class, () -> calc.calculateBodyMassIndex(1.5, -2));
	}
	
	@Test
	public void bmiNegativeBoth() {
		assertThrows(ArithmeticException.class, () -> calc.calculateBodyMassIndex(-4, -2));
	}
	
	@Test
	public void bmiMassZero() {
		assertThrows(ArithmeticException.class, () -> calc.calculateBodyMassIndex(0, 50));
	}

	@Test
	public void bmiHeightZero() {
		assertThrows(ArithmeticException.class, () -> calc.calculateBodyMassIndex(60, 0));
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {0.3, 3})
	public void bmiHeightOutOfBonds(double value) {
		assertThrows(ArithmeticException.class, () -> calc.calculateBodyMassIndex(60, value));
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {1, 650})
	public void bmiMassOutOfBonds(double value) {
		assertThrows(ArithmeticException.class, () -> calc.calculateBodyMassIndex(value, 1.7));
	}

	// Tests for category

	@ParameterizedTest
	@ValueSource(doubles = {0.0, 1.2, 3, 10.99, 18.49999})
	public void categoryUnderweight(double value) {
		assertEquals(ObesityCategory.UNDERWEIGHT, calc.getObesityCategory(value));
	}

	@ParameterizedTest
	@ValueSource(doubles = {18.5, 20, 22.22, 24, 24.9999})
	public void categoryNormal(double value) {
		assertEquals(ObesityCategory.NORMAL, calc.getObesityCategory(value));
	}

	@ParameterizedTest
	@ValueSource(doubles = {25, 26.26, 27, 28.99, 29.9999})
	public void categoryOverweight(double value) {
		assertEquals(ObesityCategory.OVERWEIGHT, calc.getObesityCategory(value));
	}

	@ParameterizedTest
	@ValueSource(doubles = {30, 31.2, 33.222, 40, 100})
	public void categoryObese(double value) {
		assertEquals(ObesityCategory.OBESE, calc.getObesityCategory(value));
	}
	
	@Test
	public void categoryNegative() {
		assertThrows(ArithmeticException.class, () -> calc.getObesityCategory(-1));
	}
	
	@Test
	public void categoryBMIOutOfBonds() {
		assertThrows(ArithmeticException.class, () -> calc.getObesityCategory(120));
	}
	
	// Tests for abdominalObesity
	
	@ParameterizedTest
	@ValueSource(doubles = {90.001, 91, 98.99, 100, 103.254})
	public void abdominalMaleTrue(double value) {
		assertTrue(calc.abdominalObesity(value, Gender.MALE));
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {35, 40.1, 45.121, 89.999, 90})
	public void abdominalMaleFalse(double value) {
		assertFalse(calc.abdominalObesity(value, Gender.MALE));
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {80.001, 81, 90, 100, 103.254})
	public void abdominalFemaleTrue(double value) {
		assertTrue(calc.abdominalObesity(value, Gender.FEMALE));
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {35, 40.1, 45.121, 79.999, 80})
	public void abdominalFemaleFalse(double value) {
		assertFalse(calc.abdominalObesity(value, Gender.FEMALE));
	}
	
	@Test
	public void abdominalNegative() {
		assertThrows(ArithmeticException.class, () -> calc.abdominalObesity(-5, Gender.FEMALE));
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {20, 400})
	public void abdominalOutOfBonds(double value) {
		assertThrows(ArithmeticException.class, () -> calc.abdominalObesity(value, Gender.FEMALE));
	}
}