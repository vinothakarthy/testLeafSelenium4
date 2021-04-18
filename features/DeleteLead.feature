Feature: Delete Functionality for Leaftaps


Scenario: TC001_deletelead with positive Credential

Given Enter user name as 'DemoSalesManager'
Given Enter Password as 'crmsfa'
When Login button clicked
Given CRM link clicked
Given Lead Tab clicked
Given Find Lead clicked
Given Phone tab clicked
Given phonenumber to delete '98' 
When Find Lead Button for delete clicked
When LeadList for delete clicked
When delete button clicked
When Find Lead clicked
Given enter name as LeadID
When Find Lead Button for delete clicked
Then verify text
