@CleanEnvironment
Feature: Add a project to a workspace.

  Background: I have projects and workspace created.
    Given I send a POST request to /projects
      | name | At01 project1 |
    And I expect the status code 200
    And I store as Project1

    And I send a POST request to /projects
      | name | At01 project2 |
    And I expect the status code 200
    And I store as Project2

    And I send a POST request to /my/workspaces
      | name | AT01 Workspace |
    And I expect the status code 200
    And I store as Workspace1


  @DeleteWorkspace
  Scenario: Add project to Workspace created
    When I go to the [Workspace1.name]
    And I add the
      | [Project1.name] |
      | [Project2.name] |
    Then I expect the workspace store
      | [Project1.name] |
      | [Project2.name] |