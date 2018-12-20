Feature: Linkedin Home Page

  @Homepage
  Scenario Outline: Enter details for signin
    Given  I am on Linkedin Home page
    When   I Enter <Email> and <Password>
    Then   Login Should be successful
    Examples:
      | Email               | Password |
      | sraavanthi.thuma@gmail.com | renushrav  |








