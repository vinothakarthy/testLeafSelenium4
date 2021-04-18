Feature: Login Functionality for Leaftaps



Scenario Outline: TC001_Login with positive Credential

Given Enter user name as <companyName>
Given Enter Password as <password> 
When Login button clicked
Then HomePage should be displayed

Examples:
|companyName|password|
|'DemoSalesManager'|'crmsfa'|
|'DemoCsr'|'crmsfa'|

Scenario: TC001_Login with negative Credential

Given Enter user name as 'DemoSalesManager'
Given Enter Password as 'crmsfa23' 
When Login button clicked
But Error message should be displayed
