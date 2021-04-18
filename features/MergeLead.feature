Feature: Merge Functionality for Leaftaps


Scenario Outline: TC001_Mergelead with positive Credential


Given Enter user name as 'DemoSalesManager'
Given Enter Password as 'crmsfa'
When Login button clicked
Given CRM link clicked
Given Lead Tab clicked
When Merge Lead clicked
Given From Lead 'naveen'
Given To Lead 'hari'
When Merge Clicked
Given Find Lead clicked
Then Verify

