Feature: Test login functionalities

  Background:
    Given a user is on the login page

  @positive_test
  Scenario: click login successful with valid credentials
    When user enters username "kamal" and password "12345"
    And click on login button
    Then user is navigate to home page


  @dataDriven_test
    #parameterization with multiple sets of data

    Scenario Outline: Check login is successful with valid credentials for multiple users
      When user enters username "<username>" and password "<password>"
      And click on login button
      Then user is navigate to home page
      Examples:
      |username|password|
      |kamal   |12345   |
      |rafan   |12345   |
      |saifan  |12345  |

  @negative_test
  Scenario: click login successful with valid credentials
    When user enters username "kamal" and password "4444"
    And click on login button
    Then user is failed to login


  @dataDriven_test
  Scenario: check login is successful using data table
    When user click on login button upon entering credentials
    |username|password|
    |kamal   |12345   |
    Then user is navigate to home page


