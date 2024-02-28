Feature: Verification of Car Insuarance 


Scenario: Navigate to Car Insuarance and fill car number and check the name 
  Given The user is on Homepage
  When User will click on car insuarance  
  And  fill the car number and click on view price
  Then check if the correct car has been identified
  
Scenario: Navigate to Car Insuarance and fill details and check the error message
  Given The user is on Homepage
  When User will click on car insuarance  
  And  fill the details  
  Then fill personal info check for invalid email error
  And  fill incorrect number and check for invalid number error
 





