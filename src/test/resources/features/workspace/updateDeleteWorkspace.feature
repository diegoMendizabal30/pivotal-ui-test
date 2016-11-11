@CleanEnvironment
Feature: Delete and Edit a Workspace.

  Background: I have workspace created.
    Given I send a POST request to /projects
      | name | AT01 Project |
    And I expect the status code 200
    And I send a POST request to /my/workspaces
      | name | AT01 Workspace |
    And I expect the status code 200
    And I store as Workspace1

  @DeleteWorkspace
  Scenario: Delete Workspace.
    When I go to the [Workspace1.name]
    And I click in the settings tab
    And I click on Delete link and confirm
    Then I expect the next message: [Workspace1.name] was successfully deleted.

  @DeleteWorkspace
  Scenario: Edit Workspace.
    When I go to the [Workspace1.name]
    And I click in the settings tab
    And I edit the name with
      | WORKSPACE_NAME | AT01 Workspace |
    Then I expect the next message: Changes saved.
