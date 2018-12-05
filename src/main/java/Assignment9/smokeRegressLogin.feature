Feature: login OrangeHR Application
@Regression
Scenario: Login in Application
Given User is in login page
Then User enter username and password
Then User click on Login Button
Then login is successfully done and landing page is launched

@Smoke
Scenario: Login to application
Given I open my application
And I login with following credentials
| Admin | admin123|
And Validate landing page

@Smoke @Regression
Scenario: Dashboard Validation
Given Availability of report
When User is having report access rights
Then Perform validation on data
