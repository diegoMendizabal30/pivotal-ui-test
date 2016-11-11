#Feature: Project update.
#
#  Background: Project created
#    Given I send a POST request to /projects
#      | name | ATProjectForPivotal |
#    Then I expect the status code 200
#    And I store as Project1
#
#  @deleteAllProjects
#  Scenario: Update a project.
#    When I update the project [Project1.name] for: ATProjectForPivotalUpdate
