Feature: Automated Mower Operations on a Lawn
  As a user of the MowItNow automatic mower system
  I want the mower to navigate the lawn based on provided instructions
  So that the lawn is mowed efficiently within the defined boundaries

  Background:
    Given the lawn is defined with an upper-right corner at 5 5

  Scenario Outline: Successfully mowing the lawn with varied instructions
    Given a mower is initially positioned at <start_x> <start_y> facing <start_direction>
    When the mower executes navigation instructions <instructions>
    Then the mower should finish at <end_x> <end_y> facing <end_direction>

    Examples:
      | start_x | start_y | start_direction | instructions | end_x | end_y | end_direction |
      | 1       | 2       | N               | GAGAGAGAA    | 1     | 3     | N             |
      | 3       | 3       | E               | AADAADADDA   | 5     | 1     | E             |

  Scenario: Mower ignores command to move outside the lawn boundary
    Given a mower is initially positioned at 0 0 facing S
    When the mower executes navigation instructions A
    Then the mower should finish at 0 0 facing S

  Scenario: Mower navigates to each corner of the lawn
    Given a mower is initially positioned at 0 0 facing N
    When the mower executes navigation instructions AAAAAAAAADAAAAAAAAAADAAAAAAAAAADAAAAAAAAAA
    Then the mower should finish at 0 0 facing W

  Scenario: Complex navigation with multiple turns and moves
    Given a mower is initially positioned at 1 2 facing E
    When the mower executes navigation instructions DAAADAAAGAAA
    Then the mower should finish at 0 0 facing S
