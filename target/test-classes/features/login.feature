Feature: Login Functionality

  Scenario Outline: Verify User logs in with invalid and valid credentials
    Given the user is on the home page
    When clicks on login link
    And the user enters the email "<email>" and the password "<password>"
    And clicks the login button
    Then the user should see logout and myaccount links

    Examples: 
      | email        | password     |
      | sku@mail.com | sku1234      |
      | sku1234      | sku@mail.com |
