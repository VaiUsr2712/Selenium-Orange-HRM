Feature: PIM

  @test2
  Scenario: Verify user is able to create a customer

    Given Login Website
    And User able to create user


  @test1
  Scenario Outline: Verify user is able to retrieve Employee name and workmail

    Given Login Website
    And I enter jobtitle "<Jobtitle>" and location "<Location>"


    Examples:

    |   Jobtitle  |  Location |
    | Chief Financial Officer| NewYork Sales Office |


