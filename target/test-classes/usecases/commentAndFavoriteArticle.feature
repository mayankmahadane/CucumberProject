Feature: User should be able to comment on any articles, favorite it

  
  Scenario: Verify that user is able to comment on any article and mark it as favorite

    Given Verify that user is signed in and if not then do login
    	And Click Global Feed Tab on Homepage
    When Click title of first shown feed
  	 And Add and Post Comment
  #  And yet another action
  #  Then I validate the outcomes
  #  And check more outcomes