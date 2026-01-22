Feature: Login page feature

Scenario: Login with valid credentials
Given user is on login page
When user enters valid username
And user enters valid password
And user clicks on Login button
Then user should see products on the page

# we can also run negative scenarios for different username and password using scenario outline in this page
 
