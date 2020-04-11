Feature:Validate Elements in Practice Page


  @homepage
  Scenario: Validate home page landing
    Given I navigate to "https://learn.letskodeit.com/" url
    Given I am on the  HomePage page
    Then I validate enrollNow is displayed
    #And I validate the home image source is "https://process.fs.teachablecdn.com/ADNupMnWyR7kCWRvm76Laz/resize=height:60/https://www.filepicker.io/api/file/WSundQ6BT6u2OZe2kcNA"
    And I validate homeImg src is "https://process.fs.teachablecdn.com/"


  @practicepage
    Scenario:Validate Radio buttons, checkboxes and selections
    Given I navigate to "https://learn.letskodeit.com/" url
    Then I am on the  HomePage page
    When I click on practice
    And I wait for 5000 miliseconds
    Then I am on the  PracticePage page
    Then I click on BMW
    And I select honda from cars dropdown

  @signuppage
  Scenario:Validate sign up page
    Given I navigate to "https://learn.letskodeit.com/" url
    Then I am on the  HomePage page
    Then I click on enrollNow
    Then I am on signup page
    Then I wait for 5000 miliseconds
    Given I enter user name as "test user"
    Then I enter user email as  "some@email.com"
    Then I enter user password as "somepass"
    Then I agree terms and marketing
    Then I wait for 2000 miliseconds
    Then I verify sign up is "enabled"

