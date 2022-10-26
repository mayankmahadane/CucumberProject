Feature:  User should be able to sign in/sign out


  Scenario: Verify that User is able to Sign In
  
    Given Click on Sign In Link
    When Enter login details
    Then Verify that user is successfully logged in
    
    
  Scenario: Verify that User is able to Sign Out
  
    Given Verify that user is signed in and if not then do login 
    	And Click on Username hyperlink in header
    When Click Edit Profile Settings
    	And Click on Log Out button
    Then Verify that user is successfully logged out