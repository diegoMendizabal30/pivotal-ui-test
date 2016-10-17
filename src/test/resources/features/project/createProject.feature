Feature: Project Create.

  @deleteAllProjects
  Scenario: Create a new project with setting by default.
  New account is create and privacy is private.
    When I delete all account the project
    And I added a new project
      | PROJECT_NAME | Automation Project Test 01 |
      | ACCOUNT      | AutomationTestAT01-01      |
    Then Verify that a new project is created
    And I go to dashboard
    And Verify that a new project is displayed in dashboard

  @deleteAllProjects @deleteAllAccounts
  Scenario: Create a new project when project account exist.
  Create a new project privacy is private by default.
    When I create a new account AutomationTestAT01-02
    And I added a new project
      | PROJECT_NAME | Automation Project Test 01 |
      | ACCOUNT      | AutomationTestAT01-02      |
    Then Verify that a new project is created
    And I go to dashboard
    And Verify that a new project is displayed in dashboard

  @deleteAllProjects @deleteAllAccounts
  Scenario: Create a new project when Project privacy is public and the account exist.
    When I create a new account AutomationTestAT01-03
    And I added a new project
      | PROJECT_NAME    | Automation Project Test 01 |
      | ACCOUNT         | AutomationTestAT01-03      |
      | PROJECT_PRIVACY | Public                     |
    Then Verify that a new project is created
    And I go to dashboard
    And Verify that a new project is displayed in dashboard