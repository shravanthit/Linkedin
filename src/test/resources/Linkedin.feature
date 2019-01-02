Feature: Linkedin Home Page

  @Homepage
  Scenario Outline: Enter details for signin
    Given  I am on Linkedin Home page
    When   I Enter <Email> and <Password>
    Then   Login Should be successful
    Examples:
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

  @RandomConnectionReq
  Scenario Outline:
    Given I am logged in with <Email> and <Password>
    When  I am on connection page and sent connection req to random person
    Then  I should be able to see the message that connection req has been sent
    Examples:
      | Email                      | Password  |
      | sraavanthi.thuma@gmail.com | renushrav |


  @CheckPersonConnections
  Scenario Outline:
   Given I am logged in with <Email> and <Password>
   When  I am on homepage and searched persons profile and connections
   Then  I should be able to see number of connections
    Examples:
      | Email                      | Password  |
      | sraavanthi.thuma@gmail.com | renushrav |

  @asosSearch












