Feature: User should be able to post articles with all the inputs mentioned
  

 Scenario: Verify that user is able to Post Article on RealWorld site
  
    Given Verify that user is signed in and if not then do login
    	And Click on New Article Hyperlink from header
    When Fill all required details and Submit Article
    Then Verify that Article is submitted successfully