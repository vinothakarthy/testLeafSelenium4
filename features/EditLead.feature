Feature: Editlead Functionality for Leaftaps

@regression
Scenario Outline: TC001_editlead with positive Credential

Given Enter user name as 'DemoSalesManager'
Given Enter Password as 'crmsfa'
When Login button clicked
Given CRM link clicked
Given Lead Tab clicked
Given Find Lead clicked
Given Phone tab clicked
Given phonenumber <phonenumber>
When Find Lead Button clicked
When LeadList clicked
When edit button clicked
Given Modify company name as <companyName>
When edit form submitbutton clicked

Examples:
|phonenumber|companyName|
|'98'|'testleafedit'|
|'97'|'ibm'|
