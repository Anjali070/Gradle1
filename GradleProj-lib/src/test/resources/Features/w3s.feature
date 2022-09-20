Feature: To login to w3school and navigate to courses

  Scenario: To check courses and navigate to java Module
    Given user is on home page
    When user clicks on login page and enters the credentials
    Then user clicks on courses
    Then user is navigated to the list
    Then user clicks on java
