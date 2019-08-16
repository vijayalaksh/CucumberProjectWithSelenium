Feature: Login into CRM and Create Deals

Scenario:

Given  Open the browser and application should be lunched
When   User will enter the username and password

|username                 | password |
|neelamvermamsc@gmail.com |12345678 |

Then   User should reach on home page
Then   User should click the deal page and create the new deal
|title| amount|probability |next_step|
|T1   | 2000  |10          |new values| 
|T3   | 3000  |30          |new values| 



