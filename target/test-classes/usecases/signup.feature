Feature: User should be able to sign up

  
  Scenario: Sign up for a new user
  
    Given Click Sign Up button from header
    When Fill Sign Up Form and Submit
    Then Verify that sign up is done successfully