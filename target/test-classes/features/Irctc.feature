@IrctcLogin
Feature: Login to Irctc

@SmokeTest
Scenario:

Given login in irctc website
When Launch browser
Then Launch the Irctc site
Then Provide From and To stations and find trains
Then Select the specific calender date
Then Track the train

#@RegressionTest
#Scenario:
#Then Login into the site
#Then Enter username and password
#And Click on the login button
#Then Close the browser
