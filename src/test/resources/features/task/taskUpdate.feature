Feature: Update item test

  Background: Preconditions for a task
    Given I send a POST request to /projects
      | name | ATProjectForPivotal |
    And I expect the status code 200
    And I store as Project1
    And I send a POST request to /projects/[Project1.id]/stories
      | name      | ATstory01 |
    And I expect the status code 200
    And I store as Story1
    And I send a POST request to /projects/[Project1.id]/stories/[Story1.id]/tasks
      | description | This is a test for pivotal |
    And I expect the status code 200
    And I store as Tasks1

   @toDashBoard @deleteAllProjects
  Scenario: Update a task
    Given I select the project [Project1.name] and story [Story1.name] created
    When I update the task [Tasks1.description] for: The text is updated now
    Then The task: The text is updated now is created

  @deleteAllProjects @toDashBoard
  Scenario: Delete task
    Given I select the project [Project1.name] and story [Story1.name] created
    When I delete the task: [Tasks1.description] pressing the delete button
    Then The task: [Tasks1.description] is deleted


