Feature: Login functionality for Amazon

  Background:
  Given user is in home page


    Scenario: Test scenario- Login with valid username and password

      Given user is in home page
      Given he navigates to the login page
      When he login with "<valid username>" and "valid password"
      Then he will eb able to login
      And A welcome message is displayed


