@CleanEnvironment
Feature: Create a Workspace

  Background: I have a project created.
    Given I send a POST request to /projects
      | name | AT01 Project |
    And I expect the status code 200

  @DeleteWorkspace
  Scenario: Create a Workspace with a valid name
    When I create a new Workspace
      | WORKSPACE_NAME | AT01 Workspace |
    Then the display name equals to workspace created

  @DeleteWorkspace
  Scenario: Create a Workspace with empty name
    When I create a new Workspace
      | WORKSPACE_NAME |  |
    Then A message should be displayed: workspace name can't be blank