Feature: Delete an existing Leads in Leaftaps

Background:
Given Launch Chrome browser
When Load url 'http://leaftaps.com/opentaps'
And Type Username as 'DemoSalesManager'
And Type Password as 'crmsfa'
And Click Login Button
And Click CRM SFA Link
And Click Leads Tab

Scenario Outline: Delete an existing Lead using Phone number

When Click Find Leads menu
And Click on Phone Tab
And Enter Phone Numer as <phone>
And Click Find Leads Button
And Capture lead ID of First Matching lead 
And Click First Matching Result
And Click Delete Button
And Click Find Leads Menu
And Enter the Captured LeadId
And Click Find Leads Button
And Verify the Status


Examples:
|phone|
|99|
|91|