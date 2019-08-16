@FreeCRMLogin
Feature: Login into the CRM application


#Scenario: User will be at login page 

#Given Open the chrome browser and application should be lunched		
#When Enter the "neelamvermamsc@gmail.com" and "12345678"			
#Then User should be reach on home page
#When Create a new contact
#Then Add rating and event for contact



Scenario Outline:: User will be at login page 

Given Open the chrome browser and application should be lunched		
When Enter the "<Username>" and "<Password>"			
Then User should be reach on home page
Then Before adding a new contact delete the if it is already exists 
Then Create a new contact with "<firstname>" and "<lastname>" and add rating and event for contact

Examples: 
         |Username               | Password   |  firstname  | lastname |
         |neelamvermamsc@gmail.com |12345678  |  Julie		| Perira   |	
         |neelamvermamsc@gmail.com |12345678  |  Ria		| Mishra   |
         

