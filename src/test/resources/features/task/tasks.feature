Feature: Task item test

  Background: Preconditions for a task
    Given I send a POST request to /projects
      | name | ATProjectForPivotal |
    And I expect the status code 200
    And I store as Project
    And I send a POST request to /projects/[Project.id]/stories
      | name | ATstory01 |
    And I expect the status code 200
    And I store as Story

  @toDashBoard @deleteAllProjects
  Scenario: create a task
    Given I select the project [Project.name] and story [Story.name] created
    When I create a task whit the text: this is a task test
    Then The task: this is a task test is created
