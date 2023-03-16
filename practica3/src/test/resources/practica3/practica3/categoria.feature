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

@US2
Feature: Calcular categoria
Como usuario 
Quiero poder calcular la categoría de un BMI
Para saber cual es mi categoría

	@tag1
  Scenario Outline: Calcular la categoria de un BMI
    Given Tengo una calculadora de BMI
    When Calculo la categoria de <b>
    Then El sistema devuelve la categoria <res>
    
			Examples:
   | b | res |
   | 10.0 | "UNDERWEIGHT" |
   | 20.0 | "NORMAL" |
   | 27.0 | "OVERWEIGHT" |
   | 35.0 | "OBESE" |
   
  @tag2
  Scenario Outline: Calcular la categoria de un BMI negativo
    Given Tengo una calculadora de BMI
    When Calculo la categoria del BMI negativo <b>
    Then El sistema devuelve un error
    
			Examples:
   | b | 
   | -1.0 | 
   | -20.0 |  
   
  @tag3
  Scenario Outline: Calcular la categoria de un BMI atipico
    Given Tengo una calculadora de BMI
    When Calculo la categoria del BMI atipico <b>
    Then El sistema devuelve un error
    
			Examples:
   | b | 
   | 107.0 | 
   | 200.0 |