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

@US1
Feature: Calcular BMI
Como usuario con una calculadora de BMI
Quiero poder calcular el BMI dada una altura y un peso
Para saber conocer mi BMI

	@tag1
  Scenario Outline: Calcular el BMI con una altura y un peso positivos
    Given Tengo una calculadora de BMI
    When Calculo el BMI con peso <p> y con altura <a>
    Then El sistema devuelve <res>
    
			Examples:
   | p | a | res |
   | 4.0 | 2.0 | 1.0 |
   | 4.0 | 1.0 | 4.0 |
   
  @tag2
  Scenario Outline: Calcular el BMI con una altura y/o peso negativos
    Given Tengo una calculadora de BMI
    When Calculo el BMI con peso <p> y con altura <a> negativos
    Then El sistema devuelve un error
    
			Examples:
   | p | a |
   | 4.0 | -1.0 |
   | 4.0 | -1.5 |
   | -4.0 | 1.0 |
   | -4.0 | 1.5 |
   
  @tag3
  Scenario Outline: Calcular el BMI con peso y/o altura atipicos
    Given Tengo una calculadora de BMI
    When Calculo el BMI con peso <p> y con altura <a> atipicos
    Then El sistema devuelve un error
    
			Examples:
   | p | a |
   | 0.3 | 1.0 |
   | 700.0 | 1.0 |
   | 4.0 | 3.0 |
   | 4.0 | 0.3 |
   | 0.0 | 1.0 |
   | 4.0 | 0.0 |
   