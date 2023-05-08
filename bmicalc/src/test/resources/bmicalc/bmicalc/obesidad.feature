#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@US3
Feature: Calcular obesidad abdominal
Como usuario
Quiero poder calcular si hay obesidad abdominal
Para conocer si tengo obesidad abdominal

	@tag1
  Scenario Outline: Calcular obesidad abdominal
    Given Tengo una calculadora de BMI
    When Calculo si tiene obesidad abdominal con cintura <w> y genero <g> 
    Then El sistema devuelve que obesidad es <res>
    
			Examples:
   | w | g | res |
   | 100.0 | "FEMALE" | "T" |
   | 60.0 | "FEMALE" | "F" |
   | 100.0 | "MALE" | "T" |
   | 60.0 | "MALE" | "F" | 
	
   
  @tag2
  Scenario Outline: La medida de la cintura es negativa
    Given Tengo una calculadora de BMI
    When Calculo si tiene obesidad abdominal con cintura negativa <w>
    Then El sistema devuelve un error
    
			Examples:
   | w |
   | -10.0 | 
   | -20.0 |
   
  @tag3
  Scenario Outline: La medida de la cintura es atipica
    Given Tengo una calculadora de BMI
    When Calculo si tiene obesidad abdominal con cintura atipica <w>
    Then El sistema devuelve un error
    
			Examples:
   | w |
   | 500.0 | 
   | 700.0 |
   
	