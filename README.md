![example workflow](https://github.com/jmhorcas/bmicalc/actions/workflows/maven.yml/badge.svg)

# BMI calculator
A biomedical calculator for the body mass index (BMI) and other parameters.

## Method bmi
1.- Check 5 positive even float numbers  
2.- Check 5 positive even int numbers  
3.- Check a negative mass  
4.- Check a negative height  
5.- Check a negative mass and height  
6.- Check when mass = 0 (It should be zero)  
7.- Check when height = 0 (It should be error)  
8.- Check an abnormal value of Height (It should be error)  
9.- Check an abnormal value of Mass (It should be error)  

## Method category
1.- Check 5 bmi for UNDERWEIGHT  
2.- Check 5 bmi for NORMAL  
3.- Check 5 bmi for OVERWEIGHT  
4.- Check 5 bmi for OBESE  
5.- Check a negative bmi (It should be error)  
6.- Check an abnormal value of bmi (It should be error)  

## Method abdominalObesity
1.- Check 'M' with 5 waistCircumference that give TRUE     
2.- Check 'M' with 5 waistCircumference that give FALSE  
3.- Check 'F' with 5 waistCircumference that give TRUE  
4.- Check 'F' with 5 waistCircumference that give FALSE  
5.- Check 'm' (It should be error)  
6.- Check 'f' (It should be error)  
7.- Check a character different that 'F' and 'M' (It should be error)  
8.- Check a negative waistCircumference (It should be error)  
9.- Check an abnormal value of waistCircumference (It should be error)  

## Diagrama de casos de uso

![Diagrama](/doc/CasosDeUso.jpg)

## Especificación de caso de uso
Caso de uso: Calcular categoría  
Actor primario: Usuario  
Objetivo: El usuario recibe la categoría de su BMI  
Scope: El sistema de la calculadora  
Nivel: Objetivo del usuario  
Stakeholders e intereses:  
	- Usuario: quiere saber su categoría  
Precondición: el usuario accede a la opción de calcular categoría  
Garantía mínima: el usario recibe una categoría correspondiente a su BMI  
Trigger: el usuario selecciona la acción de calcular categoría  
Escenario principal:  
1.- El usuario introduce su BMI  
2.- La calculadora recibe el BMI introducido  
3.- La calculadora devuelve la categoría  
Escenarios alternativos:  
3a. El BMI introducido no es válido  
3a1. La calculadora muestra un mensaje de error.  
3a2. Vuelta al paso 1

## Historias de usuario
Historia de usuario 1  
Como usuario con una calculadora de BMI  
Quiero poder calcular el BMI dada una altura y un peso  
Para saber conocer mi BMI  

	Escenario 1: Calcular el BMI con una altura y un peso positivos  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo el BMI con altura 2 m y con peso 50 kg  
	Entonces El sistema devuelve 12.5  

	Escenario 2: Calcular el BMI con una altura negativa  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo el BMI con altura -1 m y con peso 50 kg  
	Entonces El sistema devuelve un error  

	Escenario 3: Calcular el BMI con un peso negativo  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo el BMI con altura 1 m y con peso -1 kg  
	Entonces El sistema devuelve un error  

	Escenario 4: Calcular el BMI con una altura atípica  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo el BMI con altura 5 m y con peso 10 kg  
	Entonces El sistema devuelve un error  

	Escenario 5: Calcular el BMI con un peso atípico  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo el BMI con altura 1 m y con peso 1000 kg  
	Entonces El sistema devuelve un error  

	Escenario 5: Calcular el BMI con una altura de cero  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo el BMI con altura 0 m y con peso 10 kg  
	Entonces El sistema devuelve un error  

	Escenario 6: Calcular el BMI con un peso cero  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo el BMI con altura 1 m y con peso 0 kg  
	Entonces El sistema devuelve un error  
	

Historia de usuario 2  
Como usuario   
Quiero poder calcular la categoría de un BMI  
Para saber cuál es mi categoría  

	Escenario 1: Calcular UNDERWEIGHT  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo la categoría del BMI 10  
	Entonces El sistema devuelve UNDERWEIGHT  

	Escenario 2: Calcular NORMAL  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo la categoría del BMI 20  
	Entonces El sistema devuelve NORMAL  

	Escenario 3: Calcular OVERRWEIGHT  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo la categoría del BMI 27  
	Entonces El sistema devuelve OVERWEIGHT  

	Escenario 4: Calcular OBESE  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo la categoría del BMI 35  
	Entonces El sistema devuelve OBESE  

	Escenario 5: El BMI introducido es negativo  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo la categoría del BMI -1  
	Entonces El sistema devuelve un error  

	Escenario 6: El BMI introducido es atípico  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo la categoría del BMI 200  
	Entonces El sistema devuelve un error  

Historia de usuario 3  
Como usuario  
Quiero poder calcular si hay obesidad abdominal  
Para conocer si tengo obesidad abdominal  

	Escenario 1: Una mujer tiene obesisad abdominal  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo la obesidad abdominal de F y 100 cm  
	Entonces El sistema devuelve true  

	Escenario 2: Una mujer no tiene obesisad abdominal  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo la obesidad abdominal de F y 60cm  
	Entonces El sistema devuelve false  

	Escenario 3: Un hombre tiene obesisad abdominal  
	Dado Tengo una calculadora de BMI   
	Cuando Calculo la obesidad abdominal de M y 100 cm  
	Entonces El sistema devuelve true  

	Escenario 4: Un hombre no tiene obesisad abdominal  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo la obesidad abdominal de M y 60 cm  
	Entonces El sistema devuelve false  

	Escenario 5: El género no es válido  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo la obesidad abdominal de X y 100 cm  
	Entonces El sistema devuelve un error  

	Escenario 6: La circunferencia de la cintura es negativa  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo la obesidad abdominal de M y -20 cm  
	Entonces El sistema devuelve un error  

	Escenario 7: La circunferencia de la cintura es atípica  
	Dado Tengo una calculadora de BMI  
	Cuando Calculo la obesidad abdominal de M y 500 cm  
	Entonces El sistema devuelve un error  

## Prototipo GUI

![Prototipo](/doc/Prototipo.png)