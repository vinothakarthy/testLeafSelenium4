Feature: CreateLead Functionality for Leaftaps


@smoke
Scenario Outline: TC001_Create Lead with positive Credential


Given Enter user name as 'DemoSalesManager'
Given Enter Password as 'crmsfa'
When Login button clicked
Given CRM link clicked
Given Lead Tab clicked
Given CreateLead clicked
Given Enter Company Name as <companyName>
Given Enter First Name as <firstName>
Given Enter Last Name as <lastName>
Given Enter phone number as <phonenumber>
When SubmitButton Clicked

Examples:
|companyName|firstName|lastName|phonenumber|
|'TestLeaf'|'vinotha'|'karthikeyan'|'98'|
|'Selenium'|'kashwini'|'karthikeyan'|'97'|
