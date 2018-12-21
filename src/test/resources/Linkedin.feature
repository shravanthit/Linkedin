Feature: Linkedin Home Page

  @Homepage
  Scenario Outline: Enter details for signin
    Given  I am on Linkedin Home page
    When   I Enter <Email> and <Password>
    Then   Login Should be successful
    Examples:
<<<<<<< HEAD
      | Email                      | Password  |
      | sraavanthi.thuma@gmail.com | renushrav |

  @ViewProfile
  Scenario Outline: verify Dashboard
    Given I am logged in with <Email> and <Password>
    When  I navigate to my profile page
    Then  I should see my Dashboard
    Examples:
      | Email                      | Password  |
      | sraavanthi.thuma@gmail.com | renushrav |

  @SignOut
  Scenario Outline: Signout
    Given I am logged in with <Email> and <Password>
    When  I click on signout
    Then I should be succesfully logged out
    Examples:
      | Email                      | Password  |
      | sraavanthi.thuma@gmail.com | renushrav |

  @jobSearch
  Scenario Outline: Signout
    Given I am logged in with <Email> and <Password>
    When  I click on job icon and enter <jobtype> and <joblocation>
    Then  I should be able to see list of jobs
    Examples:
      | Email                      | Password  | jobtype         | joblocation    |
      | sraavanthi.thuma@gmail.com | renushrav | Quality Analyst | United Kingdom |










