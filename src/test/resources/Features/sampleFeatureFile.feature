#https://cucumber.io/docs/gherkin/reference/
Feature: Sample feature file
  Scenario: Login and Logout
    Given Login page
    Then Enter username and password and login
    Then Check for successful login
    Then Logout
    Then Check for successful logout