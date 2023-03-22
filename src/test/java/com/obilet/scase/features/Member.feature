Feature: Creating a New Membership
  Scenario: Open the page and check that the page opens correctly.
    Given It is observed that the browser opens.
    When  If the URL is entered, the redirection starts.
    Then The page is observed to open.

  Scenario: Click the Member Login button. You will see the Membership pop-up. Click on the Sign In button.
    Given Member Login, Member Modal, Sign Up button is visible
    When It is seen that the Membership pop-up is opened and it is seen that the Sign Up button actions are performed.

  Scenario: Enter your email address and password and click the Sign Up button.
    Given Mail and password fields are entered correctly
    When Click on the button to create the membership and take the necessary actions to complete it.
    Then Indicates that the membership process was successful.

  Scenario: Verify that the new user was created successfully
    Given This is the stage where the new user's information is verified.
    When After the membership phase, the page is changed.
    Then You will see a token indicating that you're logged in.