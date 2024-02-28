Feature: Verification of Home Page Element


Scenario: check the Health Insurance plan 
  Given The user is on Homepage
  When User will click on Health insurance
  And  fill the details and click on view plans
  Then retrieve insurance plan 
  
Scenario: retrieve the Health Insurance plans
  Given The user is on Homepage
  Then retrieve the Health Insurance Plans 
  
  
 





